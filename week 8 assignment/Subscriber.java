import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Subscriber {
    protected String name;
    protected LocalDate startDate;

    public Subscriber(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();
    public String getName() { return name; }
    public LocalDate getStartDate() { return startDate; }
}

class BasicSubscriber extends Subscriber {
    public BasicSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 30; }
}

class StandardSubscriber extends Subscriber {
    public StandardSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 90; }
}

class PremiumSubscriber extends Subscriber {
    public PremiumSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 365; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Subscriber> subscribers = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr, formatter);

            if (type.equals("BASIC")) {
                subscribers.add(new BasicSubscriber(name, startDate));
            } else if (type.equals("STANDARD")) {
                subscribers.add(new StandardSubscriber(name, startDate));
            } else if (type.equals("PREMIUM")) {
                subscribers.add(new PremiumSubscriber(name, startDate));
            }
        }
        scanner.close();

        for (Subscriber sub : subscribers) {
            LocalDate renewalDate = sub.getStartDate().plusDays(sub.getValidityDays());
            System.out.println(sub.getName() + ": " + renewalDate.format(formatter));
        }
    }
}