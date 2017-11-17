package Chapter10.StaticAndFinal;

public class Foo2 {
    int x;
    private static void go() {
        // 静态方法无法调用非静态的变量
//        System.out.println(x);
    }

    public static void main(String []args) {
        go();
    }
}
