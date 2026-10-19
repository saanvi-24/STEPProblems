
import java.util.Scanner;

abstract class Ticket {
    int count;
    final double convenienceFee = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double calculateAmount() {
        return (getPrice() + convenienceFee) * count;
    }

    abstract String getType();
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }

    String getType() {
        return "REGULAR";
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }

    String getType() {
        return "PREMIUM";
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }

    String getType() {
        return "RECLINER";
    }
}

public class TicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            if (type.equals("REGULAR")) {
                tickets[i] = new Regular(count);
            } else if (type.equals("PREMIUM")) {
                tickets[i] = new Premium(count);
            } else {
                tickets[i] = new Recliner(count);
            }
        }

        double total = 0;

        for (Ticket t : tickets) {
            double amount = t.calculateAmount();
            System.out.printf("%s: %.2f%n", t.getType(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
