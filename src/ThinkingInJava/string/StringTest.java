package ThinkingInJava.string;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Formatter;

public class StringTest {
    public static void main(String []args) {
        String test = "Hello World";
        StringBuilder test2 = new StringBuilder("Hello World");
        System.out.println(test.contains("w"));
        System.out.println(test.contentEquals(test2));
        System.out.println(test.contentEquals("Hello World"));
        System.out.println(String.valueOf(test2));
        System.out.printf("%s\n", test2);
        System.out.format("%s\n", test);

        PrintStream outAlias = System.out;
        outAlias.format("%s\n", "This is from `System.out` 's alias");

        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("Terry", new Formatter(outAlias));
        tommy.move(4, 8);
        terry.move(4, 3);

        System.out.println(Arrays.toString(test.split("W")));
    }
}

class Turtle {
    private String name;
    private Formatter formatter;

    Turtle(String name, Formatter formatter) {
        this.name = name;
        this.formatter  = formatter;
    }

    public void move(int x, int y) {
        formatter.format("%s The Turtle is at (%d, %d)\n", name, x, y);
    }
}
