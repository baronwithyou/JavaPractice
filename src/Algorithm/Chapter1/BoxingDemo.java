package Algorithm.Chapter1;

public class BoxingDemo {
    public static void main(String []args) {
        GenericMemoryCell<Integer> m = new GenericMemoryCell<>();
        m.write(5);
        int val = m.read();
        System.out.println("The Value is " + val);
    }
}
