
import java.util.Scanner;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

interface UsesBus {
    double transportFee = 12000;

    boolean usesBus();
}

class DayScholar extends Student implements UsesBus {
    DayScholar(String name) {
        super(name);
    }

    public boolean usesBus() {
        return true;
    }

    double calculateFee() {
        return 40000 + transportFee;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements UsesBus {
    Scholar(String name) {
        super(name);
    }

    public boolean usesBus() {
        return true;
    }

    double calculateFee() {
        return 20000 + transportFee;
    }
}

public class FeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else {
                students[i] = new Scholar(name);
            }
        }

        double total = 0;

        for (Student s : students) {
            double fee = s.calculateFee();
            System.out.printf("%s: %.2f%n", s.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
