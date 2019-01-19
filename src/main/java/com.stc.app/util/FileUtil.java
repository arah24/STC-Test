package com.stc.app.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class FileUtil {

    public static void createFile(String content, String fileName) {
        try (FileOutputStream fs = new FileOutputStream(fileName)) {
            fs.write(content.getBytes());
        } catch (IOException e) {
            log.error("Unable to create file: ", e);
        }
    }


    public static String readFile(String fileName) {
        String data = "";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            data = IOUtils.toString(fis, "UTF-8");
        } catch (IOException e) {
            log.error("Unable to read file: ", e);
        }
        return data;
    }
}
