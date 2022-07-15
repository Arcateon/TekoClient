package TekoServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Server {

    public static void connect(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("==============");
        System.out.println("Start server on " + port + " port.");
        System.out.println("==============");

        Socket socket = serverSocket.accept();
        System.out.println("New connection.");
        System.out.println("==============");

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        PrintWriter output = new PrintWriter(socket.getOutputStream());

        while (!bufferedReader.ready());
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }

        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: application/json; charset=utf-8");
        output.println();
    }
}
