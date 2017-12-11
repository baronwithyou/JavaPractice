package HeadFirst.Chapter10.StaticAndFinal;

public class Foo5 {
    final static int x = 16;

    private void go(final int x) {
        System.out.println(x);
    }

    public static void main(String []args) {
        Foo5 foo = new Foo5();
        foo.go(5);
    }
}
