package Algorithm.Chapter7;

public class QuickSort {
    private final static int CUTOFF = 20;
    private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType []a) {
        quickSelect(a, 0, a.length - 1, 1);
    }
    private static <AnyType extends Comparable<? super AnyType>> void quickSelect(AnyType []a, int left, int right, int k) {
        if (left + CUTOFF <= right) {
            AnyType pivot = median3(a, left, right);

            int i = left, j = right - 1;
            for ( ; ; ) {
                while (a[++i].compareTo(pivot) < 0) ;
                while (a[--j].compareTo(pivot) > 0) ;
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }

            if (k <= i)
                quickSelect(a, left, i - 1, k);
            else if (k > i + 1)
                quickSelect(a, i + 1, right, k);
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

    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType []a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0)
            swapReferences(a, left, right);
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
        Integer []a = {2, 4, 1, 3, 5};
        insertionSort(a, 0, a.length - 1);

        for (int item : a)
            System.out.println(item);
    }
}
