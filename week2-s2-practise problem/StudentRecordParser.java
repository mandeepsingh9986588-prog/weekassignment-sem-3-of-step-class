public class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNumber, department);
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
    }
}