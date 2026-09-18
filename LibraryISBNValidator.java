public class LibraryISBNValidator {

    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append("[")
                 .append(code.substring(0, 3))
                 .append("] YEAR: ")
                 .append(code.substring(3, 7))
                 .append(" | CATALOG: ")
                 .append(code.substring(7));

        return formatted.toString();
    }

    public static void processCode(String raw) {
        String normalized = normalizeCode(raw);
        System.out.println(validateAndFormat(normalized));
    }

    public static void main(String[] args) {
        processCode("pen2026004251");
        processCode("12N2026004251");
    }
}
