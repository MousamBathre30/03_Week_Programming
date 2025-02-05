package inputStreamReader.userInput;

import java.io.*;

public class UserInput {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // FileWriter to write to a file
            FileWriter fw = null;
            BufferedWriter bw = null;

            try {
                // Create a FileWriter object to write to a file named "output.txt"
                fw = new FileWriter("output.txt");
                bw = new BufferedWriter(fw);

                System.out.println("Enter text to write to file (type 'exit' to stop):");
                String input;

                // Read user input using readLine() and write to the file
                while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                    bw.write(input);
                    bw.newLine(); // Write a new line after each input
                }

                System.out.println("Input stopped. File 'output.txt' has been created.");
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                try {
                    // Close the BufferedWriter and FileWriter
                    if (bw != null) {
                        bw.close();
                    }
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    System.err.println("Error closing streams: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

