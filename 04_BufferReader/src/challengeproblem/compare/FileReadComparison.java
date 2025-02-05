package challengeproblem.compare;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class FileReadComparison {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Replace with your file path

        // Using FileReader
        long startTime1 = System.nanoTime();
        int wordCount1 = countWordsUsingFileReader(filePath);
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1) / 1_000_000; // Convert to milliseconds

        System.out.println("Word Count using FileReader: " + wordCount1);
        System.out.println("Time taken using FileReader: " + duration1 + " ms");

        // Using InputStreamReader
        long startTime2 = System.nanoTime();
        int wordCount2 = countWordsUsingInputStreamReader(filePath);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2) / 1_000_000; // Convert to milliseconds

        System.out.println("Word Count using InputStreamReader: " + wordCount2);
        System.out.println("Time taken using InputStreamReader: " + duration2 + " ms");
    }

    public static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }
}
