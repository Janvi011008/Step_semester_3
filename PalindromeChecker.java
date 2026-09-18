import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeChecker {

    // Iterative Approach: Two-pointer comparison moving inward
    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Recursive Approach: Compare boundaries and shrink substring
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Array Reversal Approach: Convert to char array, reverse, and compare
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        char[] originalChars = text.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        String reversedText = new String(reversedChars);
        return text.equals(reversedText);
    }

    // Formatted evaluation runner
    public static void evaluateAndDisplay(String inputText) {
        // String Built-in method and escape sequence formatting
        String sanitizedText = inputText.trim().toLowerCase();

        boolean iterativeResult = isPalindromeIterative(sanitizedText);
        boolean recursiveResult = isPalindromeRecursive(sanitizedText);
        boolean reversalResult = isPalindromeArrayReversal(sanitizedText);

        String iterLabel = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recurLabel = recursiveResult ? "Palindrome" : "Not Palindrome";
        String revLabel = reversalResult ? "Palindrome" : "Not Palindrome";

        // Using \" escape sequence in output
        System.out.println("Evaluation for: \"" + inputText + "\"");
        System.out.println("Iterative: " + iterLabel + " | Recursive: " + recurLabel + " | Array Reversal: " + revLabel);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        // Handling Checked Exceptions (IOException) via BufferedReader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter a word/phrase to test (or press Enter for test suite): ");
            String userInput = reader.readLine();

            if (userInput != null && !userInput.trim().isEmpty()) {
                evaluateAndDisplay(userInput);
            } else {
                // Default test cases demonstrating predefined String array
                System.out.println("\nRunning default test suite:\n");
                String[] sampleInputs = {"madam", "hello", "racecar", "step"};
                for (String word : sampleInputs) {
                    evaluateAndDisplay(word);
                }
            }
        } catch (IOException e) {
            // Checked exception handling
            System.err.println("Input/Output error encountered: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Unchecked exception handling
            System.err.println("Validation error: " + e.getMessage());
        } catch (Exception e) {
            // General exception fallback
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
