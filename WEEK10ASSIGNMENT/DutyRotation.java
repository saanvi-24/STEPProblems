
import java.util.Arrays;

public class DutyRotation {

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
