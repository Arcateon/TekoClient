package TekoPost;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class getPaymentStatus {
        private static final String path = "/home/arcateon/IdeaProjects/Teko/src/main/java/TekoPost/jsons/getPaymentsInfo.json";
        private static final String key = "TestSecret";
        private static final String url = "https://gate-test-02.teko.io/api/initiators/default/getPaymentsByTag";

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
