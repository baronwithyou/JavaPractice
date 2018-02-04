package Algorithm.Chapter7;

public class QuickSort {
    private final static int CUTOFF = 1;
    private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType []a) {
        quickSelect(a, 0, a.length - 1);
    }
    private static <AnyType extends Comparable<? super AnyType>> void quickSelect(AnyType []a, int left, int right) {
        if (left + CUTOFF <= right) {
            AnyType pivot = median3(a, left, right);

            int i = left + 1, j = right - 2;
            for ( ; ; ) {
                while (a[i].compareTo(pivot) < 0)
                    i++;
                while (a[j].compareTo(pivot) > 0)
                    j--;
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }

            swapReferences(a, i, right - 1);
            quickSelect(a, left, i - 1);
            quickSelect(a, i + 1, right);
        } else
            insertionSort(a, left, right);
    }

    private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType []a, int left, int right) {
        int j;
        for (int i = left + 1; i < right + 1; i++) {
            AnyType tmp = a[i];
            for (j = i; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    /**
     * 该方法是修整后的枢纽元策略
     * 将left、right和center进行排序并且将center的元素放在right-1的位置并且返回pivot值
     * @param a
     * @param left
     * @param right
     * @param <AnyType>
     * @return
     */
    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType []a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0)
            swapReferences(a, left, center);
        if (a[right].compareTo(a[left]) < 0)
            swapReferences(a, left, right);
        if (a[right].compareTo(a[center]) < 0)
            swapReferences(a, center, right);

        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private static <AnyType extends Comparable<? super AnyType>> void swapReferences(AnyType []a, int i, int j) {
        AnyType tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String []args) {
        int []a = {3,2,1,4,5};
//        insertionSort(a, 0, a.length - 1);
//        swapReferences(a, 0, 1);


//        quickSort(a);
//        median4(a, 0, a.length - 1);
        for (int item : a)
            System.out.println(item);
    }
}
