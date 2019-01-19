package com.stc.app.service;

import com.stc.app.util.CryptoUtil;
import com.stc.app.util.FileUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiService {

    public static final String FILE_NAME = "./src/main/resources/encryptedFile.txt";
    private CryptoUtil cryptoUtil;

    public ApiService(CryptoUtil cryptoUtil) {
        this.cryptoUtil = cryptoUtil;
    }

    public String getFile() throws Exception {
        String encryptedFile = FileUtil.readFile(FILE_NAME);
        return cryptoUtil.decrypt(encryptedFile);
    }

    public void createFile(String file) throws Exception {
        Optional.of(file).orElseThrow(RuntimeException::new);
        String encryptedData = cryptoUtil.encrypt(file);
        FileUtil.createFile(encryptedData, FILE_NAME);
    }

}
