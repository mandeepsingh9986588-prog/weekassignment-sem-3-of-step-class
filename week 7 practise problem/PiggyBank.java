class PiggyBank {
    private final String piggyBankId;
    private double savings;

    public PiggyBank(String piggyBankId) {
        this.piggyBankId = piggyBankId;
        this.savings = 0.0;
    }

    public String getPiggyBankId() {
        return piggyBankId;
    }

    public double getSavings() {
        return savings;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Deposited: " + amount + " -> savings = " + savings);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > savings) {
            System.out.println("Withdrawal of " + amount + " rejected, savings stays " + savings);
        } else {
            savings -= amount;
            System.out.println("Withdrew: " + amount + " -> savings = " + savings);
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}