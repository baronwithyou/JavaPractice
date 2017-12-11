package HeadFirst.Chapter9;

import java.awt.*;

public class Mini extends Car{
    Color color;
    public static void main(String []args) {
        Mini mini = new Mini();
        System.out.println(mini.getColor());
    }

    public Mini() {
        this(Color.RED);
    }

    public Mini(Color c) {
        super("Mini");
        color = c;
    }

    public Color getColor() {
        return color;
    }
}
