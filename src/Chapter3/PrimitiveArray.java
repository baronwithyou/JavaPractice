package Chapter3;

public class PrimitiveArray {
    public static void main(String[] args) {
        Dog[] pets;
        pets = new Dog[7];
        pets[0] = new Dog();
        pets[0].bark();
    }
}

class Dog{
    void bark() {
        System.out.println("I am a Dog ");
    }
}
