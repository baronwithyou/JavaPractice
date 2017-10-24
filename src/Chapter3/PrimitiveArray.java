package Chapter3;

public class PrimitiveArray {
    public static void main(String[] args) {
        Dog[] pets;
        pets = new Dog[7];
        pets[0] = new Dog();
        pets[0].bark();
        pets[0].setSize(12);
        System.out.println(pets[0].getSize());
    }
}

class Dog{
    // 变量默认值是在类中而不是方法中
    private int size = 30;
    void bark() {
        System.out.println("I am a Dog ");
    }

    void setSize(int s) {
        size = s;
    }

    int getSize() {
        return size;
    }
}
