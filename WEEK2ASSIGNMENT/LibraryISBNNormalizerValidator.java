import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    static String normalizeCode(String raw) {

        // Remove leading and trailing spaces
        String code = raw.trim();

        // If fewer than 3 characters, return as it is
        // so validation can report the correct reason
        if (code.length() < 3) {
            return code;
        }

        // Uppercase only the first 3 characters
        String publisherCode = code.substring(0, 3).toUpperCase();

        // Keep the remaining characters unchanged
        String remainingPart = code.substring(3);

        return publisherCode + remainingPart;
    }

    static String validateAndFormat(String code) {

        // Check total length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract publisher code
        String publisherCode = code.substring(0, 3);

        // Extract year
        String year = code.substring(3, 7);

        // Extract catalog number
        String catalogNumber = code.substring(7, 13);

        // Build formatted output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalogNumber);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String rawCode = sc.nextLine();

        // Normalize the code
        String normalizedCode = normalizeCode(rawCode);

        // Validate and format
        String result = validateAndFormat(normalizedCode);

        System.out.println(result);

        sc.close();
    }
}