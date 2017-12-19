package Test;

public class InsertionSort {
    private static int[] sort(int []arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            // 这里面的tmp不能写成arr[i] 因为在赋值的时候arr[i]的值被改变了
            for (; j >= 0 && tmp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String []args) {
        int []arr = {5, 1, 2, 10, 6, 4};
        arr = sort(arr);
        for (int item : arr)
            System.out.println(item);
    }
}
