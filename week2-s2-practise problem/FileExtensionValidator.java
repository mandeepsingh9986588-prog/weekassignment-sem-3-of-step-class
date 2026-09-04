public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            System.out.println("Rejected — invalid file type");
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            System.out.println("Rejected — invalid file type");
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);

        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            System.out.println("Accepted");
            return "Accepted";
        } else {
            System.out.println("Rejected — invalid file type");
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        validateFileExtension("Assignment1.PDF");
        validateFileExtension("notes.txt");
    }
}