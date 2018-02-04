package Algorithm.Chapter7;

import java.util.ArrayList;

public class RadixSort {
    // 对相同长度的单词进行排序 从后往前遍历字符排序（定长字符串的基数排序）
    private static void radixSortA(String []arr, int stringLen) {
        final int BUCKETS = 256;
        ArrayList<String> []buckets = new ArrayList[BUCKETS];

        for (int i = 0; i < BUCKETS; i++)
            buckets[i] = new ArrayList<>();

        for (int pos = stringLen - 1; pos >= 0; pos--) {
            for (String s : arr)
                buckets[s.charAt(pos)].add(s);

            int idx = 0;
            for (ArrayList<String> thisBucket : buckets) {
                for (String s : thisBucket)
                    arr[idx++] = s;
                thisBucket.clear();
            }
        }
    }

    public static void main(String []args) {
        String []arr = {"bbbbae", "bbbbbc", "bbbbbb"};
        radixSortA(arr, 6);

        for (String item : arr)
            System.out.println(item);
    }
}
