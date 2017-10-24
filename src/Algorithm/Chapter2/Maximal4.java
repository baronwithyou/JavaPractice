package Algorithm.Chapter2;

public class Maximal4 {
    public static void main(String []args) {
        int a[] = {4, -3, 5, -2, -1, 2, 6, -2};
        System.out.println(maxSubSum4(a));
    }

    private static int maxSubSum4(int a[]) {
        int thisSum = 0; int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
