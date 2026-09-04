public class TransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            String error = "Invalid: wrong length";
            System.out.println(error);
            return error;
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                String error = "Invalid: bank code must be 3 letters";
                System.out.println(error);
                return error;
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                String error = "Invalid: remaining characters must be digits";
                System.out.println(error);
                return error;
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String raw1 = "  hdf03022600042";
        String normalized1 = normalizeReference(raw1);
        validateAndFormat(normalized1);

        String raw2 = "12F03022600042";
        String normalized2 = normalizeReference(raw2);
        validateAndFormat(normalized2);
    }
}