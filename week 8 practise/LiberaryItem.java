import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDuration();
    public String getTitle() { return title; }
}

class Book extends LibraryItem {
    public Book(String title) { super(title); }
    @Override public int getBorrowingDuration() { return 14; }
}

class DVD extends LibraryItem {
    public DVD(String title) { super(title); }
    @Override public int getBorrowingDuration() { return 7; }
}

class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }
    @Override public int getBorrowingDuration() { return 3; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");

            if (type.equals("BOOK")) {
                items.add(new Book(title));
            } else if (type.equals("DVD")) {
                items.add(new DVD(title));
            } else if (type.equals("MAGAZINE")) {
                items.add(new Magazine(title));
            }
        }
        scanner.close();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (LibraryItem item : items) {
            LocalDate dueDate = currentDate.plusDays(item.getBorrowingDuration());
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }
    }
}