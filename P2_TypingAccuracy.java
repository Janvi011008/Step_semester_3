public class P2_TypingAccuracy {

    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int total = original.length();
        int firstMismatchPos = -1;
        char origCharMismatch = ' ';
        char typedCharMismatch = ' ';

        for (int i = 0; i < total; i++) {
            char oChar = original.charAt(i);
            char tChar = typed.charAt(i);

            if (oChar == tChar) {
                matches++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origCharMismatch = oChar;
                typedCharMismatch = tChar;
            }
        }

        double accuracy = ((double) matches / total) * 100.0;

        System.out.print(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matches, total, accuracy));
        if (firstMismatchPos == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println(String.format("First Mismatch at position %d ('%c' vs '%c')",
                    firstMismatchPos, origCharMismatch, typedCharMismatch));
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
