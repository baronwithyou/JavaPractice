package HeadFirst.Chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button1 = new JButton("Shock me");
    JButton button2 = new JButton("bliss");
    JButton button3 = new JButton("huh?");
    public static void main(String []args) {
        Button1 b = new Button1();
        b.go();
    }

    private void go() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.darkGray);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        button1.addActionListener(new AnotherPanel());
        button2.addActionListener(new AnotherPanel());
        button3.addActionListener(new AnotherPanel());
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    class AnotherPanel implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            button1.setText("Hello world");
        }
    }
}
