package Chapter4;

public class Test1 {
    // 使用==来判别两个引用是否指向同一个对象
    public static void main(String []args) {
        // short可以传入函数中转换成int， 但是long不行
//        long c = 8;
        short c = 9;
        int result = calcArea(c, 12);
        System.out.println(result);
        checkObjectEqual();
    }

    private static void checkObjectEqual() {
        Foo a = new Foo();
        Foo b = new Foo();
        Foo c = a;
        System.out.println(a == b);
        System.out.println(a == c);
    }

    private static int calcArea(int height, int width) {
        return height * width;
    }
}

class Foo { }