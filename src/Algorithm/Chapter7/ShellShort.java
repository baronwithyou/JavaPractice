package Algorithm.Chapter7;

public class ShellShort {
    /**
     * 希尔排序 插入排序的优化版 最坏时间复杂度O(N^2)
     * @param arr
     * @return
     */
    private static int[] shellsort(int []arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2)
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int tmp = arr[i];
                for (; j >= gap && tmp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        return arr;
    }

    public static void main(String []args) {
        int []arr = {5, 10, 2, 9, 30, 7, 12};
        arr = shellsort(arr);
        for (int item : arr)
            System.out.println(item);
    }
}
