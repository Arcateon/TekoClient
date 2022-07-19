package TekoPost;


import TekoServer.Server;

import java.io.IOException;
import java.net.ConnectException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Server.connect(8084);
//            InitRedirectPayment.connect();
//            GetByTag.connect();
        } catch (ConnectException e) {
                e.printStackTrace();
        }
    }
}
