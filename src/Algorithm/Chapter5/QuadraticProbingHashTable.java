package Algorithm.Chapter5;

/**
 * 对于平方探测法来说
 * 如果填装因子超过0.5 则表就是满的
 * @param <AnyType>
 */
public class QuadraticProbingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 11;

    private static class HashEntry<AnyType> {
        AnyType element;
        boolean isActive;
        HashEntry(AnyType element) {
            this(element, true);
        }

        HashEntry(AnyType element, boolean isActive) {
            this.element = element;
            this.isActive = isActive;
        }
    }

    private HashEntry<AnyType> []array;

    private int currentSize;

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++)
            array[i] = null;
    }

    private void allocateArray(int size) {
        array = new HashEntry[nextPrime(size)];
    }

    private int nextPrime(int size) {
        return size;
    }

    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    /**
     * 该函数用于寻找空的位置或者寻找x所在的位置
     * @param x
     * @return
     */
    private int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myhash(x);

        // 持续循环直到寻找到空的位置或者和该元素相同的元素
        while(array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    private int myhash(AnyType x) {
        int hashVal = x.hashCode();

        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;

        return hashVal;
    }

    public void insert(AnyType x) {
        int currentPos = findPos(x);
        // 如果该位置已经被占用并且没有被删除(该元素的isActive属性被设置为false)
        if (isActive(currentPos))
            return;
        array[currentPos] = new HashEntry<>(x);

        if (currentSize > array.length / 2) {
            rehash();
        }
    }

    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos))
            array[currentPos].isActive = false;
    }

    private void rehash() {
        HashEntry<AnyType> []oldArray = array;

        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;

        for (int i = 0; i < oldArray.length; i++)
            if (oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].element);
    }

    // 判断是否被删除不需要以值作为参数 因为已经有findPos这个函数存在
    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }
}
