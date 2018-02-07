package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterTest {
    public static void main(String []args) {
//        System.out.println(getString());
//        string []strings = new string[]{"javascript", "java", "php", "go", "python", "c++"};
//        mergeSort(strings);
//        for (string item: strings) {
//            System.out.println(item);
//        }
//        System.out.println(firstToUpper("let it be light"));
        String name = "Martin";
        String test = "Marin";
        name = test;
        System.out.println(name);
    }

    // 创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
    // 方法1
    private static String getString() {
        char[] chars = new char[5];
        byte start = '0';
        byte end = 'z' + 1;
        char random;
        for (int i = 0; i < chars.length; i++) {
            do {
                random = (char)(Math.random() * (end - start) + start);
            } while (!Character.isLetter(random) && !Character.isDigit(random));
            chars[i] = random;
        }
        String result = new String(chars);
        return result;
    }

    private static void mergeSort(String []strings) {
        mergeSort(strings, 0, strings.length - 1);
    }

    private static void mergeSort(String []strings, int start, int end) {
        if (start < end) {
            int middle = (start + end)  / 2;
            mergeSort(strings, start, middle);
            mergeSort(strings, middle + 1, end);
            merge(strings, start, middle, end);
        }
    }

    private static void merge(String []strings, int leftStart, int leftEnd, int rightEnd) {
        int count = rightEnd - leftStart + 1;
        String []tmp = new String[count];
        int rightStart = leftEnd + 1;
        int k = 0;
        while(leftStart <= leftEnd && rightStart <= rightEnd) {
            if (strings[leftStart].compareTo(strings[rightStart]) < 0)
                tmp[k++] = strings[leftStart++];
            else
                tmp[k++] = strings[rightStart++];
        }
        while(leftStart <= leftEnd) {
            tmp[k++] = strings[leftStart++];
        }
        while(rightStart <= rightEnd) {
            tmp[k++] = strings[rightStart++];
        }
        for (int i = 0; i < count; i++, rightEnd--) {
            strings[rightEnd] = tmp[--k];
        }
    }

    private static String firstToUpper(String s) {
        String []strings = s.split(" ");
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result += strings[i].substring(0, 1).toUpperCase() + strings[i].substring(1) + " ";
        }
        return result;
    }
}
