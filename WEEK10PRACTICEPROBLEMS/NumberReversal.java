
import java.util.Scanner;

public class NumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int temp = number;
        int sum = 0;
        int reverse = 0;

        while (temp > 0) {
            int digit = temp % 10;

            sum += digit;
            reverse = reverse * 10 + digit;

            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);

        sc.close();
    }
}
