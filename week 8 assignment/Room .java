import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Room {
    protected double units;

    public Room(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getTypeName();
}

class SingleRoom extends Room {
    public SingleRoom(double units) { super(units); }
    @Override
    public double calculateBill() {
        return units * 8.0;
    }
    @Override public String getTypeName() { return "SINGLE"; }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
    @Override public String getTypeName() { return "SHARED"; }
}

class ACRoom extends Room {
    public ACRoom(double units) { super(units); }
    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
    @Override public String getTypeName() { return "AC"; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equals("SHARED")) {
                int occupants = scanner.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("AC")) {
                rooms.add(new ACRoom(units));
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", r.getTypeName(), bill);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}