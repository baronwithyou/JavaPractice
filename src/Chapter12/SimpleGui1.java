package Chapter12;

import javax.swing.*;

public class SimpleGui1 {
    public static void main(String []args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click me");

        // 在window关闭时把程序结束掉
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
