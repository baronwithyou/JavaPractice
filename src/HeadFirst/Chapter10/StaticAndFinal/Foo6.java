package HeadFirst.Chapter10.StaticAndFinal;

public class Foo6 {
    int x;
    private static void go(final int x) {
        System.out.println(x);
    }

    public static void main(String []args) {
        go(20);
    }
}
