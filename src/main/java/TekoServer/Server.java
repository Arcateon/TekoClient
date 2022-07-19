package TekoServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Server {

    public static void connect(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Start server on " + port + " port.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection.");

            try(BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter output = new PrintWriter(socket.getOutputStream())) {
                while (!input.ready());
                System.out.println();
                while (input.ready()) {

                    // наверно, тут я буду получать json и парсить его через jackson

                    System.out.println(input.readLine());
                }

                output.println("HTTP/1.1 200 OK");
                output.println("Content-Type: application/json; charset=utf-8");
                output.println();
                output.println("hello");
                output.flush();
                System.out.println("Disconnected.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
