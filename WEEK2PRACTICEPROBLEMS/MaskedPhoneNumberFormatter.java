import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {

        // Validate length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate that all characters are digits
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get last four digits
        String lastFourDigits = phone.substring(6);

        // Create masked number using StringBuilder
        StringBuilder maskedNumber = new StringBuilder("XXXXXX");

        // Insert '-' before last four digits
        maskedNumber.append("-");
        maskedNumber.append(lastFourDigits);

        return maskedNumber.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));

        sc.close();
    }
}