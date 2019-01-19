package com.stc.app.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CryptoUtilTest {

    @Test
    public void encryptAndDecryptTest() throws Exception {
        CryptoUtil tk = new CryptoUtil();
        String data = "hello-this-is-normal";
        String encrypted = tk.encrypt(data);
        String decrypted = tk.decrypt(encrypted);
        assertEquals(data, decrypted);
    }
}