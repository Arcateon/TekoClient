package TekoPost;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonToBs4 {

    public static String dataJson(String path, String key) throws IOException {
        byte[] dataByte = Files.readAllBytes(Path.of(path));
        byte[] keyByte = key.getBytes();
        HmacUtils hm256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, keyByte);
        String hmac = Base64.encodeBase64String(hm256.hmac(dataByte));
        return hmac;
    }
}
