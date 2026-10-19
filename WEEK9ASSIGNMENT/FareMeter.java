
import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract String getType();

    double calculateFare() {
        return Math.max(km * getRate(), 100);
    }
}

interface NightService {
    double nightMultiplier = 1.20;
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    double calculateNightFare() {
        return calculateFare() * nightMultiplier;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    double calculateNightFare() {
        return calculateFare() * nightMultiplier;
    }

    String getType() {
        return "SUV";
    }
}

public class FareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    double fare;

                    if (cab instanceof Sedan) {
                        fare = ((Sedan) cab).calculateNightFare();
                    } else {
                        fare = ((SUV) cab).calculateNightFare();
                    }

                    System.out.printf("%s: %.2f%n",
                            cab.getType(), fare);
                    total += fare;
                } else {
                    System.out.println(
                        cab.getType() + ": night service not available"
                    );
                }
            } else {
                double fare = cab.calculateFare();
                System.out.printf("%s: %.2f%n",
                        cab.getType(), fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
