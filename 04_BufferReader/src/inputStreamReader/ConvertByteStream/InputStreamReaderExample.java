package inputStreamReader.ConvertByteStream;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("src//practice//sample.txt"), "UTF-8")) {
            int i;
            while ((i = isr.read()) != -1) {
                System.out.print((char) i);  // Reads the characters from the file with specified encoding
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


