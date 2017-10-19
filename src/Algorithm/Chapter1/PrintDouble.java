package Algorithm.Chapter1;

public class PrintDouble {
    private static void printInt(int num) {
        if (num >= 10)
            printInt(num / 10);
        System.out.print(num % 10);
    }

    private static void printDouble(double double_num) {
        if (double_num < 0) {
            System.out.print("-");
            double_num = -double_num;
        }
        int num = (int)double_num;
        double decimal = double_num - num;
        printInt(num);
        System.out.print(".");
    }

    public static void main(String []args) {
        double double_num = 123213.123123;
        printDouble(double_num);
    }
}
