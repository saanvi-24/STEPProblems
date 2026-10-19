
class Employee {
    String empName;
    double salary;

    // Shared by all employees
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Divya", 50000);
        Employee e2 = new Employee("Arjun", 60000);
        Employee e3 = new Employee("Priya", 55000);

        // Call using the class name
        Employee.printCompanyInfo();
    }
}
