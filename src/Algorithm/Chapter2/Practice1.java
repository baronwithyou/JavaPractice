package Algorithm.Chapter2;

public class Practice1 {
    // 要求： 第一天为2，其余的每天都要在前一天的基础上翻倍
    public static void main(String []args) {
        System.out.println(pay(5));
    }
    private static int pay(int x) {
        if (x == 1)
            return 2;
        int pay = pay(x - 1);
        return pay * pay;
    }
}
