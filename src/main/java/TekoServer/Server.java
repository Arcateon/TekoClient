package TekoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection.");

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }


            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<h1>Hello</h1>");
        }

    }
}
