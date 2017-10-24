package Algorithm.Chapter2;

public class Maximal3 {
    // 利用分治和递归的思路解决最大子序列和问题
    public static void main(String []args) {
        int []a = {4, -3, 5, -2, -1, 2, 6, -2};
        System.out.println(maxSubSum3(a));
    }

    private static int maxSubSum3(int []a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    // 子序列最大和的情况有三种 存在在左边、右边、中间（即中分两边的和）
    private static int maxSumRec(int []a, int left, int right) {
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }

        int middle = (left + right) / 2;
        // 获取左边的最大子序列和
        int maxLeftSum = maxSumRec(a, left, middle);

        // 获取右边的最大子序列和
        int maxRightSum = maxSumRec(a, middle + 1, right);

        // 获得中间分开的子序列和
        int leftBorderSum = 0; int maxLeftBorderSum = 0;
        for (int i = middle; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int rightBorderSum = 0; int maxRightBorderSum = 0;
        for (int i = middle + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int a, int b, int c) {
        int max = 0;
        if (a > max)
            max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        return max;
    }
}
