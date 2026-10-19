
class PiggyBank {
    private double savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings = savings + amount;
            System.out.println("Savings = " + savings);
        } else {
            System.out.println("Invalid deposit");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected");
        } else {
            savings = savings - amount;
            System.out.println("Savings = " + savings);
        }
    }

    public double getSavings() {
        return savings;
    }
}

public class PiggyBank {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final savings = " + pb.getSavings());
    }
}
