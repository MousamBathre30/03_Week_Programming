package problemstatement4.largefileReading;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LargeFileReading {



    public static void readFileUsingFileReader_1MB() {
        long start = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader("src/problemstatement4/largefileReading/one_million_words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Do nothing, just read
                continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("The time taken by FileReader is " + (end - start) + " ms" + " For 100MB fie");
    }
   // method that read the file size 100 MB
    public static void readFileUsingFileReader_100MB() {
        long start = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader("problemstatement4/largefileReading/100mb.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Do nothing, just read
                continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("The time taken by FileReader is " + (end - start) + " ms" + " For 100MB fie");
    }
   // file reader that read file of size 500 MB--->
    public static void readFileUsingFileReader_500MB() {
        long start = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader("src/problemstatement4/largefileReading/500mb.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Do nothing, just read
                continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("The time taken by FileReader is " + (end - start) + " ms" + " For 100MB fie");
    }
     // Read file of size 100 mb using input Stream REader -->
     public static void readFileUsingInputStreamReader_1MB() {
         long start = System.currentTimeMillis();
         try (BufferedReader br = new BufferedReader(new InputStreamReader(
                 new FileInputStream("src/problemstatement4/largefileReading/one_million_words.txt"), StandardCharsets.UTF_8))) {
             String line;
             while ((line = br.readLine()) != null) {
                 // Do nothing, just read
                 continue;
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         long end = System.currentTimeMillis();
         System.out.println("The time taken by InputStreamReader is " + (end - start) + " ms" + " for 500 MB File");
     }
    public static void readFileUsingInputStreamReader_100MB() {
        long start = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("problemstatement4/largefileReading/100mb.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Do nothing, just read
                continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("The time taken by InputStreamReader is " + (end - start) + " ms" + " for 500 MB File");
    }
    // Read file of size 100 mb using input Stream REader -->
    public static void readFileUsingInputStreamReader_500MB() {
        long start = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("src/problemstatement4/largefileReading/500mb.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Do nothing, just read
                continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("The time taken by InputStreamReader is " + (end - start) + " ms" + "For 500 MBB file");
    }

    public static void main(String[] args) {
        readFileUsingFileReader_1MB();
        readFileUsingFileReader_100MB();
        readFileUsingFileReader_500MB();
        readFileUsingInputStreamReader_1MB();
        readFileUsingInputStreamReader_100MB();
        readFileUsingInputStreamReader_500MB();
    }
}
