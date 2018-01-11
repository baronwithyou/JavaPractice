package Test;

public class Quote {
    public void exchange(int []arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String []args) {
        int []arr = {1, 2, 3, 4};
        new Quote().exchange(arr, 1, 2);
        for (int item : arr)
            System.out.println(item);
        int i = 1;
        int j = ++i + i++ + ++i + ++i + i++;
        System.out.println(j);
    }
}
