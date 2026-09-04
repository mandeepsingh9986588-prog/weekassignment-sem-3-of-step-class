public class LibraryIsbnValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            String error = "Invalid: wrong length";
            System.out.println(error);
            return error;
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                String error = "Invalid: publisher code must be 3 letters";
                System.out.println(error);
                return error;
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                String error = "Invalid: remaining characters must be digits";
                System.out.println(error);
                return error;
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ")
          .append(year).append(" | CATALOG: ").append(catalog);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String raw1 = "pen2026004251";
        String normalized1 = normalizeCode(raw1);
        validateAndFormat(normalized1);

        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        validateAndFormat(normalized2);
    }
}