
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanDays();
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getLoanDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getLoanDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getLoanDays() {
        return 3;
    }
}

public class DueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        LibraryItem[] items = new LibraryItem[n];

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int firstSpace = line.indexOf(' ');

            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title);
            } else {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {
            LocalDate dueDate =
                currentDate.plusDays(item.getLoanDays());

            System.out.println(
                item.title + ": " + dueDate.format(formatter)
            );
        }

        sc.close();
    }
}
