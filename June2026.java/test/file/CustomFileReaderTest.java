package file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

class CustomFileReaderTest {


    @Test
    public void testCanReadFromFile(){
        String fileLocation = "/home/semicolon/IdeaProjects/FireDrill/src/ProductNames.java";

        byte[] data = file.CustomFileReader.readDataFrom(fileLocation);
        assertNotNull(data);
        System.out.println(new String(data));
        assertTrue(new String(data).contains("ProductNames"));
    }


    @Test
    public void testCanScanDataFromFile(){
        try {
            String fileLocation = "/home/semicolon/IdeaProjects/FireDrill/src/ProductNames.java";
            InputStream inputStream = new FileInputStream(fileLocation);
            Scanner scanner = new Scanner(inputStream);
            String data = file.CustomFileReader.readDataFrom(scanner);
            assertNotNull(data);
            System.out.println(data);
            assertTrue(data.contains("ProductNames"));
        }catch (IOException exception){
            assertNull(exception);
        }
    }

    @Test
    public void testCanWriteToFile(){
        String fileLocation = "/home/semi/Test.java";
        String text = "Happy Friday";
        file.CustomFileReader.writeDataTo(fileLocation, text);

        byte[] data = file.CustomFileReader.readDataFrom(fileLocation);
        assertNotNull(data);
        System.out.println(new String(data));
        assertTrue(new String(data).contains(text));

    }

    @Test
    public void testBufferReaderReadsEntireFile(){
        String fileLocation = "/home/semi/Test.java";
        byte [] data = file.CustomFileReader.bufferReader(fileLocation);
        assertNotNull(data);
        assertTrue(new String(data).contains ("import java.util.regex.Matcher;"));

    }
}