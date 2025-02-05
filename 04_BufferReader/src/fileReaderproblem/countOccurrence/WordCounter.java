package fileReaderproblem.countOccurrence;

import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to the file you want to read
        String targetWord = "example"; // Change this to the word you want to count

        int wordCount = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
    }

    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words using whitespace
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // Case-insensitive comparison
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return count;
    }
}