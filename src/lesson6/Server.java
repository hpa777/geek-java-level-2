package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT);
             Socket socket = server.accept();
             Scanner scanner = new Scanner(socket.getInputStream());
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);) {
            System.out.println("Client connected");
            KeyListener keyListener = new KeyListener(printWriter);
            keyListener.start();
            while (true) {
                String str = scanner.nextLine();
                if (str.equals("/end")) {
                    System.out.println("Client disconnect");
                    keyListener.interrupt();
                    break;
                }
                System.out.println("Client: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
