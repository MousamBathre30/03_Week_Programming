package linearSearchProblem.SearchWord;

import java.io.BufferedReader;
import java.io.*;
import java.util.HashMap;

public class LinearSearchFile {
    public static void main(String[] args) {
        String filePath = "src/practice/sample.txt"; // Path to the text file
        String targetWord = "java"; // Word to search

        // Step 1: Read words from file
        String[] words = readWordsFromFile(filePath);
        if (words == null) {
            System.out.println("Error reading the file.");
            return;
        }

        // Step 2: Perform Linear Search
        int index = linearSearch(words, targetWord);
        if (index != -1) {
            System.out.println("Word '" + targetWord + "' found at index: " + index);
        } else {
            System.out.println("Word '" + targetWord + "' not found.");
        }
    }

    // Method to read words from a file and store in an array
    private static String[] readWordsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                // Normalize by removing punctuation and making words lowercase
                sb.append(line.toLowerCase().replaceAll("[^a-zA-Z ]", "")).append(" ");
            }
            return sb.toString().split("\\s+"); // Convert to array of words
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Simple Linear Search implementation
    private static int linearSearch(String[] words, String target) {
        target = target.toLowerCase();  // Normalize target word to lowercase
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                return i; // Word found, return index
            }
        }
        return -1; // Word not found
    }
}

