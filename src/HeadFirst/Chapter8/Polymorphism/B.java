package HeadFirst.Chapter8.Polymorphism;

public class B extends A{
    public void show(A obj) {
        System.out.println("This is from Class B");
    }

    public static void main(String []args) {
        A a = new A();
        a.show(a);
        A b = new B();
        b.show(a);
    }
}
