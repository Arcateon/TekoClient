package TekoPost;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InitRedirectPayment.connect();
        GetByTag.connect();
    }
}
