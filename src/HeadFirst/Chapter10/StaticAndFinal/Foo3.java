package HeadFirst.Chapter10.StaticAndFinal;

public class Foo3 {
    // final变量必须在申明的时候进行初始化
//    final int x;
    final int x = 12;

    private void go() {
        System.out.println(x);
    }

    public static void main(String []args) {
        Foo3 foo = new Foo3();
        foo.go();
    }

}
