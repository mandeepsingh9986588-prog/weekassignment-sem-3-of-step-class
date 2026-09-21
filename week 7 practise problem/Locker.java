class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("Code changed successfully.");
            return true;
        } else {
            System.out.println("Change rejected: Incorrect current code. Code remains unchanged.");
            return false;
        }
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        locker.changeCode("1234", "5678");
        locker.changeCode("0000", "9999");
    }
}