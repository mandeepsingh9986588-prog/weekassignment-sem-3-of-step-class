import java.util.Scanner;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlacementRecord[] records = new PlacementRecord[3];

        for (int i = 0; i < 3; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            records[i] = new PlacementRecord(parts[0].trim(), parts[1].trim(), Double.parseDouble(parts[2].trim()));
        }

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}