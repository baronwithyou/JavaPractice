package Test;

import java.util.Scanner;

public class Test {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字，再输入个数");
        int digit = sc.nextInt();
        int n = sc.nextInt();
        int result = 0;
//        System.out.println(digit + "\n" + n);
        for (int number = 1000; number < 9999; number++) {
            if (count(digit, number) == n) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static int count(int digit, int number) {
        int j = 0;
        if (number % 10 == digit)
            j++;
        if (number / 10 % 10 == digit)
            j++;
        if (number / 100 % 10 == digit)
            j++;
        if (number / 1000 % 10 == digit)
            j++;
        return j;
    }
}
