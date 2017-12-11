package HeadFirst.Chapter10.StaticAndFinal;

public class Foo4 {
    final static int x = 14;

    private void go() {
        System.out.println(x);
    }

    public static void main(String []args) {
        Foo4 foo = new Foo4();
        foo.go();
    }
}
