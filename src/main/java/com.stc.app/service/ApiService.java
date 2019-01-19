package com.stc.app.service;

import com.stc.app.util.CryptoUtil;
import com.stc.app.util.FileUtil;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class ApiService {

    public static final String FILE_NAME = "./src/main/resources/encryptedFile.txt";
    private CryptoUtil cryptoUtil;

    public ApiService(CryptoUtil cryptoUtil) {
        this.cryptoUtil = cryptoUtil;
    }

    public String getFile() throws NoSuchPaddingException,
            UnsupportedEncodingException,
            NoSuchAlgorithmException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException {
        String encryptedFile = FileUtil.readFile(FILE_NAME);
        return cryptoUtil.decrypt(encryptedFile);
    }

    public void createFile(String file) throws NoSuchPaddingException,
            BadPaddingException,
            NoSuchAlgorithmException,
            IllegalBlockSizeException,
            UnsupportedEncodingException,
            InvalidKeyException {
        Optional.of(file).orElseThrow(RuntimeException::new);
        String encryptedData = cryptoUtil.encrypt(file);
        FileUtil.createFile(encryptedData, FILE_NAME);
    }

}
