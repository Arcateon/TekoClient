package TekoPost;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InitRedirectPayment {
    private static final String path = "/home/arcateon/IdeaProjects/Teko/src/main/java/TekoPost/jsons/payment.json";
    private static final String key = "TestSecret";
    private static final String url = "https://gate-test-02.teko.io/api/initiators/default/initPayment";

    public static void connect() throws IOException {
        Response response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Signature", JsonToBs4.dataJson(path, key))
                .body(Files.readString(Path.of(path)))
                .post(url);
        response.then().log().all();
    }
}