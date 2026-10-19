
import java.util.Scanner;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return 100 * 5 + (units - 100) * 7;
        }
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            if (type.equals("HOME")) {
                connections[i] = new Home(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new Shop(units);
            } else if (type.equals("FACTORY")) {
                connections[i] = new Factory(units);
            }
        }

        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n",
                    c.getClass().getSimpleName().toUpperCase(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
