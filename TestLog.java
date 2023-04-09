public class TestLog extends Solution5 {
    public static void main(String[] args) {
        readLogFile("data.log");
        try {
            int count = hasCount("18123411111111110000017744", "Send");
            System.out.println("Found " + count + " log lines with ID 18123411111111110000017744 and Type Send");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        boolean hasDuplicates = hasDuplicates();
        if (hasDuplicates) {
            System.out.println("There are duplicate log lines with the same ID and Type");
        } else {
            System.out.println("There are NO duplicate log lines with the same ID and Type");
        }
    }
}
