package util;

import java.security.MessageDigest;
import java.util.Base64;

public class Encode {
    /**
     * SHA256
     */
    public static String toSHA256(String value) {
        String salt = "hsgd53@jhbnfdb7@#$%9(7ywegdfs";
        String result = null;
        value+=salt;
        try {
            byte[] dataBytes = value.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            result = Base64.getEncoder().encodeToString(md.digest(dataBytes));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(toSHA256("123456"));
        System.out.println(toSHA256("12345678"));
    }
}
