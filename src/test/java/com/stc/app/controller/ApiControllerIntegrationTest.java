package com.stc.app.controller;

import com.stc.app.App;
import com.stc.app.util.CryptoUtil;
import com.stc.app.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiControllerIntegrationTest {

    public static final String FILE_NAME = "./src/main/resources/encryptedFile.txt";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CryptoUtil cryptoUtill;

    @Test
    public void testForDefaultResponseMessage() throws Exception {
        assertEquals(expectedResult(), testRestTemplate.getForObject("http://localhost:" + port + "/files",
                String.class));
    }

    private Object expectedResult() throws Exception {
        File file = new File(FILE_NAME);
        if (file.exists()) return cryptoUtill.decrypt(FileUtil.readFile(FILE_NAME));
        return null;
    }


}
