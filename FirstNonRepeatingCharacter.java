import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstNonRepeatingCharacter {

    // ASCII frequency map check to find first distinct character
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty.");
        }

        // Standard ASCII lookup array
        int[] frequencyMap = new int[256];

        // First pass: compute character frequencies
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            frequencyMap[currentChar]++;
        }

        // Second pass: identify first character with a count of exactly 1
        for (int i = 0; i < text.length(); i++) {
            char candidateChar = text.charAt(i);
            if (frequencyMap[candidateChar] == 1) {
                return candidateChar;
            }
        }

        // Null character indicates no unique character was found
        return '\0';
    }

    public static void displayResult(String sampleText) {
        try {
            char nonRepeatingChar = findFirstNonRepeatingChar(sampleText);

            if (nonRepeatingChar != '\0') {
                // Using escape sequence \" to format output properly
                System.out.println("Input: \"" + sampleText + "\" -> First Non-Repeating Character: '" + nonRepeatingChar + "'");
            } else {
                System.out.println("Input: \"" + sampleText + "\" -> No Non-Repeating Character Found");
            }
        } catch (IllegalArgumentException ex) {
            System.err.println("Validation Notice for \"" + sampleText + "\": " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Handling checked exceptions via BufferedReader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter text to scan (or press Enter for test suite): ");
            String userInput = reader.readLine();

            if (userInput != null && !userInput.trim().isEmpty()) {
                displayResult(userInput);
            } else {
                // Run automated test array
                System.out.println("\nRunning sample test suite:\n");
                String[] sampleWords = {"swiss", "aabbcc", "stress", "algorithm"};
                for (String word : sampleWords) {
                    displayResult(word);
                }
            }
        } catch (IOException ioException) {
            System.err.println("Checked Exception (I/O error): " + ioException.getMessage());
        } catch (Exception unexpectedException) {
            System.err.println("An unexpected error occurred: " + unexpectedException.getMessage());
        }
    }
}
