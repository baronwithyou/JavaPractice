package HeadFirst.Chapter15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class VerySimpleChatServer {
    ArrayList<PrintWriter> clientOutputStreams;
//    PrintWriter writer;

    public static void main(String []args) {
        new VerySimpleChatServer().go();
    }

    public void go() {
        clientOutputStreams = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();
        while(it.hasNext()) {
            PrintWriter writer = (PrintWriter)it.next();
            writer.println(message);
            writer.flush();
        }
    }

    /**
     * 线程 -- 用户读取用户传入的消息
     */
    public class ClientHandler implements Runnable {
        BufferedReader reader;
//        Socket socket;

        public ClientHandler (Socket clientSocket) {
            try {
//                socket = clientSocket;
                InputStreamReader streamReader = new InputStreamReader(clientSocket.getInputStream());
                reader = new BufferedReader(streamReader);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    tellEveryone(message);
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
