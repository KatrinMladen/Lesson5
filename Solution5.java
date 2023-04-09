import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5 {
    //public static void main(String[] args) {
    public static void readLogFile(String s){
        try {
            File file = new File("data.log");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<TestData> dataList = new ArrayList<>();
            String line;
            String id;
            while ((line = bufferedReader.readLine()) != null) {
                String send;
                LocalDateTime date;
                String status = null;
                if (line.contains("TMobClient3:")) {
                    send = line.split("jsonrpc")[0].split("TMobClient3: ")[1].split(":")[0];
                    date = LocalDateTime.parse(line.split("INFO")[0].split("       ")[0], DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
                    if (send.equals("Send")) {
                        id = line.split("id")[1].split(":")[1].split(",")[0].replaceAll("\"", "");
                    } else {
                        id = line.split("} : HTTP")[0].replaceAll("\"", "").split(",id:")[1];
                        status = line.split("Response: ")[1].split(": \\{")[0];
                    }
                    TestData data = new TestData(send, id, date, status);
                    dataList.add(data);
                }

            }
            System.out.println(dataList);
            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int hasCount(String send, String id) {
        List<TestData> dataList = new ArrayList<>();
        int count = 0;
        for (TestData testData : dataList) {
            if (testData.id.equals(id) && testData.send.equals(send)) {
                count++;
            }
        }
        return count;
    }
//        int count = 0;
//        LocalDateTime lastResponseDate = null;
//        for (TestData testData : dataList) {
//            if (testData.id.equals(id) && testData.send.equals(send)) {
//                if (testData.send.equals("Send")) {
//                    if (lastResponseDate != null && testData.date.isBefore(lastResponseDate)) {
//                        try {
//                            throw new Exception("Error: NO matching Response found for Send with ID " + id);
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                } else {
//                    lastResponseDate = testData.date;
//                }
//                count++;
//                System.out.println(id);
//            }
//        }
//        return count;

    public static boolean hasDuplicates() {
        List<TestData> dataList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (TestData testData : dataList) {
            if (!set.add(testData.id+ testData.send)) {
                return true;
            }
        }
        return false;
    }
}
