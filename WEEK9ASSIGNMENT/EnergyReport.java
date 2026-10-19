
import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000;
    }

    double calculateCost() {
        return calculateUnits() * 8;
    }
}

interface SaverMode {
    double SAVING = 0.75;

    double calculateSaverUnits();
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    String getType() {
        return "AC";
    }

    public double calculateSaverUnits() {
        return calculateUnits() * SAVING;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    String getType() {
        return "WASHER";
    }

    public double calculateSaverUnits() {
        return calculateUnits() * SAVING;
    }
}

public class EnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                sc.skip("[ \\t]*");
                if (sc.hasNext("SAVER")) {
                    sc.next();
                    saver = true;
                }
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AC(hours);
            } else if (type.equals("TV")) {
                appliance = new TV(hours);
            } else {
                appliance = new Washer(hours);
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(
                    type + ": saver mode not supported"
                );
                continue;
            }

            double units;

            if (saver) {
                units = ((SaverMode) appliance).calculateSaverUnits();
            } else {
                units = appliance.calculateUnits();
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getType(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
