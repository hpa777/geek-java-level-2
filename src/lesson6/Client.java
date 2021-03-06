package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {

    private static final int PORT = 8000;

    private static final String IP = "localhost";

    public static void main(String[] args) {
        try (Socket socket = new Socket(IP, PORT);
             Scanner scanner = new Scanner(socket.getInputStream());
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);) {
            System.out.println("Server connected");
            KeyListener keyListener = new KeyListener(printWriter);
            keyListener.setDaemon(true);
            keyListener.start();
            while (true) {
                String str = "";
                try {
                    str = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    break;
                };
                if (str.equals("/end")) {
                    System.out.println("Server disconnect");
                    break;
                }
                System.out.println("Server: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
