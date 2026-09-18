import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseCustomerName {

    // Traverses customer name, reverses it using a char array, and returns it
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            throw new IllegalArgumentException("Customer name cannot be null.");
        }
        if (customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be blank or empty.");
        }

        char[] originalChars = customerName.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        return new String(reversedChars);
    }

    // Prints both original and reversed strings with escape sequences
    public static void displayReversedIdentity(String name) {
        try {
            String reversed = reverseCustomerName(name);
            System.out.println("Original Name: \"" + name + "\"");
            System.out.println("Reversed Name: \"" + reversed + "\"");
            System.out.println("----------------------------------------");
        } catch (IllegalArgumentException ex) {
            System.err.println("Validation Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Checked exception handling using BufferedReader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter Customer Name (or press Enter for test suite): ");
            String inputName = reader.readLine();

            if (inputName != null && !inputName.trim().isEmpty()) {
                displayReversedIdentity(inputName.trim());
            } else {
                System.out.println("\nRunning sample test suite:\n");
                String[] sampleCustomers = {"Sunil", "Alice Smith", "Robert", "Janvi"};
                for (String customer : sampleCustomers) {
                    displayReversedIdentity(customer);
                }
            }
        } catch (IOException e) {
            System.err.println("Checked Exception (I/O error): " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }
    }
}
