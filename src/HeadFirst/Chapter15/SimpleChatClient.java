package HeadFirst.Chapter15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 双线程的聊天室
 */
public class SimpleChatClient {
    JTextField outgoing;
    JTextArea incoming;
    PrintWriter writer;
    BufferedReader reader;
    Socket socket;

    public void go() {
        // 创建swing
        JFrame frame = new JFrame("Simple chat client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        incoming = new JTextArea(10, 20);
        incoming.setEditable(false);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(incoming);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        setUpNetWorking();
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetWorking() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            System.out.println("NetWork established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String []args) {
        new SimpleChatClient().go();
    }

    class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            writer.println(outgoing.getText());
            writer.flush();
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    class IncomingReader implements Runnable {

        @Override
        public void run() {
            String message;
            try {
                while((message = reader.readLine()) != null) {
                    incoming.append(message + "\n");
                    System.out.println(message);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
