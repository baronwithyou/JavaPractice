package Algorithm.Chapter7;

public class CountingSort {
    // 计数排序只排序在一定范围内的数组, 该方法默认k为上界，0为下界
    private static void sort(int []a, int []b, int k) {
        int []c = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            c[i] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }

        for (int i = 0, j = 0; i < a.length; i++) {
            while(c[j] == 0)
                j++;

            b[i] = j;
            c[j]--;
        }
    }

    public static void main(String []args) {
        int []a = {4, 2, 5, 12, 45, 1, 34};
        int []b = new int[a.length];
        sort(a, b, 45);
        for (int item : b)
            System.out.println(item);
    }
}
