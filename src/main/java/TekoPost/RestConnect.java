package TekoPost;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RestConnect {
    public RestConnect() throws IOException {
    }

    public static void connect() throws IOException {

        Response response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Signature", dataJson())
                .body(Files.readString(Path.of("/home/arcateon/IdeaProjects/Teko/src/main/java/TekoPost/jsons/payment.json")))
                .post("https://gate-test-02.teko.io/api/initiators/default/initPayment");
        response.then().log().all();
    }

    public static String dataJson() throws IOException {
        byte[] data = Files.readAllBytes(Path.of("/home/arcateon/IdeaProjects/Teko/src/main/java/TekoPost/jsons/payment.json"));
        byte[] key = "TestSecret".getBytes();
        HmacUtils hm256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, key);
        String hmac = Base64.encodeBase64String(hm256.hmac(data));
        return hmac;
    }
}