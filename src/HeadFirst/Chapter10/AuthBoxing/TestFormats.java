package HeadFirst.Chapter10.AuthBoxing;

import static java.lang.System.out;

public class TestFormats {
    private String name;
    public static void main(String []args) {
        String s = String.format("%,d", 10000000);
        String c = String.format("%s%%", "123");
        // 下面的6的位置代表的是最小的字符数 若不足会自动在前面补零
        String s2 = String.format("%,6.2f", 4.4761);
        out.println(s);
        out.println(c);
        out.println(s2);
        TestFormats tf = new TestFormats("Martin");
    }
    public TestFormats(String name) {
        // this()函数主要应用于同一个类从某个构造函数调用另一个重载版的构造函数（和super一样 要放在首行）
        this(123);
        // 在传入的参数和实例参数名字相同时 this关键词派上用场
        this.name = name;
        test();
        out.println(this.name);
    }

    public TestFormats(int a) {
        out.println(a);
    }

    // 静态方法不能使用非静态的变量或函数
    private static void test() {
        out.println("Hello World");
        test2();
    }

    private static void test2() {
        out.println("Hello Again");
    }
}
