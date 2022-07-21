package TekoPost;


import java.io.IOException;
import java.net.ConnectException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            InitRedirectPayment.connect();
            getPaymentStatus.connect();
        } catch (ConnectException e) {
                e.printStackTrace();
        }
    }
}
