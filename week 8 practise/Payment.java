import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getTypeName();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    
    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }

    @Override
    public String getTypeName() { return "CARD"; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }

    @Override
    public String getTypeName() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }

    @Override
    public String getTypeName() { return "BANKTRANSFER"; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if (type.equals("CARD")) {
                payments.add(new CardPayment(amount));
            } else if (type.equals("WALLET")) {
                payments.add(new WalletPayment(amount));
            } else if (type.equals("BANKTRANSFER")) {
                payments.add(new BankTransferPayment(amount));
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Payment p : payments) {
            double finalAmt = p.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f\n", p.getTypeName(), finalAmt);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}