package Algorithm.Chapter7;

public class HeapSort {
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * build heap
     * @param a
     * @param i
     * @param n
     * @param <AnyType>
     */
    private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType []a, int i, int n) {
        int child; // child必须在for循环外面定义 因为每次循环都要 i = child（这里的child必须在for循环外）
        AnyType tmp;

        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            // 比较左右子树 选择叫较小的那个
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) // child不能是最后一个 因为这样就没有child + 1这个数组下标
                child++;
            if (tmp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    public static <AnyType> void swapReferences(AnyType []a, int index1, int index2) {
        AnyType tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    public static <AnyType extends Comparable<? super AnyType>> void heapsort(AnyType []a) {
        // 对于一个下标0没有值得数组来说 a.length-1是最后的父节点
        for (int i = a.length / 2 - 1; i >= 0; i--)
            percDown(a, i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
        for (AnyType item : a)
            System.out.println(item);
    }

    public static void main(String []args) {
        Integer []arr = {5, 10, 2, 9, 30, 7, 12};
        heapsort(arr);
    }
}
