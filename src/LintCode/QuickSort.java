package LintCode;

public class QuickSort {
    public static void quickSort(int []a, int left, int right) {
        if (left >= right)
            return;

        int pivot = a[(left + right) / 2];

        int i = left, j = right;
        while (i <= j) {
            while (i <= j && a[i] < pivot)
                i++;
            while (i <= j && a[j] > pivot)
                j--;
            if (i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }

        quickSort(a, left, j);
        quickSort(a, i, right);
    }

    public static void main(String []args) {
        int []a = {4, 2, 1, 6, 3, 9};

        quickSort(a, 0, a.length - 1);
        for (int item : a) {
            System.out.println(item);
        }
    }
}
