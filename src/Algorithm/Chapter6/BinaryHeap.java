package Algorithm.Chapter6;

import java.nio.BufferUnderflowException;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (AnyType[]) new Comparable[capacity + 1];
    }

    /**
     * Construct the binary heap given an array of items
     * @param items
     */
    public BinaryHeap(AnyType []items) {
        currentSize = items.length;

        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;

        for (AnyType item : items)
            array[i++] = item;
        buildHeap();
    }

    public void insert(AnyType x) {
        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        // 下标为0不放置实用元素
        return array[1];
    }

    // 找到最小的元素（首位），然后在第一位进行下滤操作
    public AnyType deleteMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    // The heap array
    private AnyType []array;

    private void percolateDown(int hole) {
        int child;
        // 保存父节点为tmp
        AnyType tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            // 左子树
            child = hole * 2;
            // 判断左右子树的大小然后将更小的元素和父节点进行对比
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        // 将待换的节点替换为父节点
        array[hole] = tmp;
    }

    /**
     * 二叉堆的数组实现中可以看出 检查是否满足二叉堆性质 现有元素个数 / 2 = 最后一个元素对应的父节点
     * 该函数代表 从最后一个节点的父节点开始 逐步检查每一个树
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    private void enlargeArray(int newSize) {
        AnyType []old = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];
    }

    public void printAll() {
        for (AnyType item : array)
            System.out.println(item);
    }

    public static void main(String []args) {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>();
        int i = 37;

        for (; i != 0; i = (i + 37) % numItems)
            h.insert(i);
//        for (i = 1; i < numItems; i++)
//            if (h.deleteMin() != i)
//                System.out.println("Oops! " + i);
        h.printAll();
    }
}
