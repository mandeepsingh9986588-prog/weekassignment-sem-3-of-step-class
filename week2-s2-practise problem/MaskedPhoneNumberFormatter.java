public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            String errorMsg = "Invalid phone number";
            System.out.println(errorMsg);
            return errorMsg;
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                String errorMsg = "Invalid phone number";
                System.out.println(errorMsg);
                return errorMsg;
            }
        }

        String last4Digits = phone.substring(6);

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.insert(6, "-");
        sb.append(last4Digits);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        maskPhoneNumber("9876543210");
        maskPhoneNumber("98765");
    }
}