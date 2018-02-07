package Test;

public class Super {
    double height = 1.8;
//    public static void main(string []args) {
//        Super2 s1 = new Super2();
//        Super2 s2 = new Super2();
//        System.out.println(s1.equals(s2));
//    }

//    public Super() {
//        System.out.println("This is parent class");
//    }

    public Super(String name) {
        System.out.println("This is " + name + " from parent class");
    }

    public void finalize() {
        System.out.println("The Super is been callback");
    }

    public boolean equals(Object o) {
        if (o instanceof Super) {
            return height == ((Super) o).height;
        }
        return false;
    }

    public String toString() {
        return "Hello world";
    }
}

class Super2 extends Super{
    double height = 1.1;
    public Super2() {
        super("hello");
//        System.out.println(this.height);
//        System.out.println(super.height);
//        super("Martin");
//        System.out.println("This is child class");
    }
}

abstract class Super3{
    public static void main(String []args) {
        new Super2();
    }
}
