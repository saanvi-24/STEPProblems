
class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Display employee details
    void printProfile() {
        System.out.println(empId + " | " + empName
                + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("E-101", "Divya", 65000);
        Employee e2 = new Employee("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();
    }
}
