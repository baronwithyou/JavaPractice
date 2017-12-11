package HeadFirst.Chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans",
    "One word: inappropriate", "Just for today, be honest"};
    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while(true) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String []args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
