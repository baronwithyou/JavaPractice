package HeadFirst.Chapter10.StaticAndFinal;

public class Foo1 {
    static int x;
    private void go() {
        System.out.println(x);
    }

    public static void main(String []args) {
        Foo1 foo = new Foo1();
        foo.go();
    }
}
