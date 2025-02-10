package problemstatem1.testLinearBinary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;

public class TargetFind {
    public static void linearSearchTesting(String filePath , int number) {


        String target = "java";

        // step 1 read words from file
        String[] words = readWordFromFile(filePath);

        if(words == null){
            System.out.println("Error reading file error");
            return;
        }

        // Step 2 perform linear Search

        int index = linearSearch(words , target , number);

        if(index != -1){
            System.out.println("Element found");
        } else{
            System.out.println(index);
            System.out.println("Element Not Found");
        }
    }
    public static void binarySearchTesting(String filePath , int number) {


        String target = "java";
        // step 1 read words from file
        String[] words = readWordFromFile(filePath);

        if(words == null){
            System.out.println("Error reading file error");
            return;
        }

        // Step 2 perform linear Search

        int index = binarySearch(words , target , number);

        if(index != -1){
            System.out.println("Element found");
        } else{
            System.out.println(index);
            System.out.println("Element Not Found");
        }
    }
    public static void main(String[] args) {

        //  Main method contains calling funcation
       String filePath_for_Million = "src/problemstatem1/testLinearBinary/one_million_words.txt";
       String filePath_for_Thousand = "src/problemstatem1/testLinearBinary/java_1000_words.txt";
       String filePath_for_Hundred = "src/problemstatem1/testLinearBinary/java_100_words.txt";
       int number_hundred = 100;
       int number_thousand = 1000;
       int number_million = 100000;
         linearSearchTesting(filePath_for_Million,number_million);
         binarySearchTesting(filePath_for_Million,number_million);
        System.out.println("***************************************");
         linearSearchTesting(filePath_for_Thousand,number_thousand);
         binarySearchTesting(filePath_for_Thousand,number_thousand);
        System.out.println("***************************************");
        linearSearchTesting(filePath_for_Hundred,number_hundred);
        binarySearchTesting(filePath_for_Hundred,number_hundred);
        System.out.println("***************************************");
    }

    // methods to read the file and store in the array
    private static String[] readWordFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                // Normalizing words by removing punctuation but keeping spaces
                sb.append(line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "")).append(" ");
            }
            // convert to array of words
            return sb.toString().split("\\s+");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    // Simple method to search in the linear Way

    private static int linearSearch(String[] words , String target , int number){
       long start = System.nanoTime();
        target = target.toLowerCase();
        for(int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                double end = System.nanoTime();
                double diff = (end - start);
                diff = diff / 1000000;
                System.out.println("For " + number + " Data Set");
                System.out.println("Time taken by linearsearch is :- " + diff + " ms");
                return i; // Word found, return index
            }
        }

        return -1;
    }
    // Custom Binary Search
    private static int binarySearch(String[] words, String target , int number) {
        int left = 0, right = words.length - 1;
        Arrays.sort(words);
        target = target.toLowerCase();
        long start = System.nanoTime();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = words[mid].compareTo(target);

            if (cmp == 0) {
                // Word found
                double end = System.nanoTime();
                double diff = (end - start);
                 diff = diff / 1000000;
                System.out.println("For " + number + " Data Set");
                System.out.println("Time taken by binarySearch is :- " + diff + " ms");
                return mid;
            }
            else if (cmp < 0) left = mid + 1; // Search right
            else right = mid - 1; // Search left
        }
        return -1; // Word not found
    }
}

