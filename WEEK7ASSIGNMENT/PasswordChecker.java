
class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordChecker {
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");

        System.out.println(pc1.getStrength());
        System.out.println(pc2.getStrength());
        System.out.println(pc3.getStrength());
    }
}
