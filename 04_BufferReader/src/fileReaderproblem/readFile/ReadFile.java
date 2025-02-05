package fileReaderproblem.readFile;

import java.io.FileReader;
import java.io.IOException;
public class ReadFile {

    public static void main(String[] args) {
        int i ;

        try (FileReader fr = new FileReader("src/practice/sample.txt")) {

            while ((i = fr.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
