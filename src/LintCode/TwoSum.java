package LintCode;

public class TwoSum {
    public static void main(String []args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(twoSum(numbers, 7)[0]);
        System.out.println(twoSum(numbers, 7)[1]);
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && i != j) {
                    result[0] = Math.min(i, j) + 1;
                    result[1] = Math.max(i, j) + 1;
                }
            }
        }
        return result;
    }

}
