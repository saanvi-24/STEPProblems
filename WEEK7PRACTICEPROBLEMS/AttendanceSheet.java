
class AttendanceSheet {
    private String[] names;
    private int count;

    AttendanceSheet(int maxStudents) {
        names = new String[maxStudents];
        count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (count < names.length) {
            names[count] = name;
            count++;
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: "
                + sheet.getPresentCount());

        System.out.println("Is Ben present? "
                + sheet.isPresent("Ben"));

        System.out.println("Is Chen present? "
                + sheet.isPresent("Chen"));
    }
}
