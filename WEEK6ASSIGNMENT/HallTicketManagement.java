
class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor
    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class Main {
    public static void main(String[] args) {

        HallTicket priya = new HallTicket("Priya", 0);

        // Both variables refer to the same object
        HallTicket copy = priya;

        // Change through the second reference
        copy.seatNumber = 45;

        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        // Create a separate object with the same field values
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("separate == priya: "
                + (separate == priya));
    }
}
