package Test;

import java.util.ArrayList;

public class FindFactor {
    private static void find() {
        for (int i = 4; i < 1000; i++) {
            int result = 0;
            String result2 = "";
            int []a = new int[100];
            int z = 0;
            for (int j = i / 2; j > 0; j--) {
                if (i % j == 0) {
                    a[z++] = j;
                    result += j;
                }
            }
            if (result == i) {
                for (int b = 0; b < a.length; b++)
                    if(a[b] != 0)
                        result2 += "+" + a[b];
                System.out.println(result + "=" + result2);
            }
        }
    }

    public static void main(String []args) {
        find();
    }
}
