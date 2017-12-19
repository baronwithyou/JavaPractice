package Algorithm.Chapter5;

import java.util.LinkedList;
import java.util.List;

/**
 * 分离链接法
 * @param <AnyType>
 */
public class SeparateChainingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<AnyType>[] theLists;

    private int currentSize;

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;
        // 如果n不是质数 就在基础上+2
        while(!isPrime(n))
            n += 2;
        System.out.println(n);
        return n;
    }

    /**
     * 判断是否是质数
     * @param n
     * @return
     */
    private static boolean isPrime(int n){
        if (n == 2 || n == 3)
            return true;

        if (n == 1 || n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    private int myhash(AnyType x) {
        int hashVal = x.hashCode();

        hashVal %= theLists.length;
        while (hashVal < 0) {
            hashVal += theLists.length;
        }
        return hashVal;
    }

    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++)
            theLists[i].clear();
        currentSize = 0;
    }

    public boolean contains(AnyType x) {
        List<AnyType> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    private void rehash() {
        List<AnyType> []oldLists = theLists;

        theLists = new List[nextPrime(2 * oldLists.length)];

        // 将新的list数组空间变大两倍 然后将数组中的所有元素都初始化
        for (int j = 0; j < theLists.length; j++)
            theLists[j] = new LinkedList<>();

        currentSize = 0;
        // 将原本oldLists每一个链表中的元素插入新的list数组中
        for (int i = 0; i < oldLists.length; i++)
            for (AnyType item : oldLists[i])
                insert(item);
    }

    public void print() {
        for (int i = 0; i < theLists.length; i++) {
            List<AnyType> thisList = theLists[i];
            if (!thisList.isEmpty())
                System.out.println(thisList);
        }
    }

    public void insert(AnyType x) {
        List<AnyType> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
            if (++currentSize > theLists.length) {
                rehash();
            }
        }
    }

    public void remove(AnyType x) {
        List<AnyType> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    public static void main(String []args) {
        Employee e1 = new Employee("martin");
        Employee e2 = new Employee("Elian");
        Employee e3 = new Employee("Alexandra");
        SeparateChainingHashTable<Employee> hashTable = new SeparateChainingHashTable<>();
        hashTable.insert(e1);
        hashTable.insert(e2);
        hashTable.insert(e3);
        hashTable.print();
    }
}
