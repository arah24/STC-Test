package com.stc.app.util;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileUtilTest {


    @Test
    public void createFileAndReadFileTest() {
        String content = "dummy-data";
        String fileName = "./src/main/resources/filetest.txt";

        FileUtil.createFile(content, fileName);
        File file = new File(fileName);
        String fileContents = FileUtil.readFile(fileName);

        assertNotNull(file);
        assertEquals(content, fileContents);

        if (file.delete()) System.out.println("Test file has been deleted");
    }

}