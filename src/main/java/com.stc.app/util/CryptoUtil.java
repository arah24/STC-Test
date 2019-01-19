package com.stc.app.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@Component
public class CryptoUtil {

    private static final String ALGORITHM = "AES";
    private static final String ENCRYPTION_KEY = "ThisIsFoundation";
    private static final String UNICODE_FORMAT = "UTF-8";

    public String encrypt(String valueToEnc) throws Exception {
        Cipher cipher = createCipher(Cipher.ENCRYPT_MODE);
        byte[] encValue = cipher.doFinal(valueToEnc.getBytes(UNICODE_FORMAT));
        return Base64.encodeBase64String(encValue);
    }

    public String decrypt(String encryptedValue) throws Exception {
        Cipher cipher = createCipher(Cipher.DECRYPT_MODE);
        byte[] decordedValue = Base64.decodeBase64(encryptedValue);
        byte[] decValue = cipher.doFinal(decordedValue);
        return new String(decValue);
    }

    private Cipher createCipher(int mode) throws Exception {
        Key key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(UNICODE_FORMAT), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(mode, key);
        return cipher;
    }

}
 