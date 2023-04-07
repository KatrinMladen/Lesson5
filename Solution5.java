import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("./src/Task6/data.log");
            BufferedReader bufferedReader = new BufferedReader(file);
            List<TestData> dataList = new ArrayList<>();
            String line;
            String id;
            while ((line = bufferedReader.readLine()) != null) {
                String send;
                String date;
                String status = null;
                if (line.contains("TMobClient3:")) {
                    send = line.split("jsonrpc")[0].split("TMobClient3: ")[1].split(":")[0];
                    date = line.split("INFO")[0].split("       ")[0];
                    if (send.equals("Send")) {
                        id = line.split("id")[1].split(":")[1].split(",")[0].replaceAll("\"", "");
                    } else {
                        id = line.split(",")[2].split(":")[1].split("\\}")[0].replaceAll("\"", "");
                        status = line.split("Response: ")[1].split(": \\{")[0];
                    }
                    TestData data = new TestData(send, id, date, status);
                    dataList.add(data);
                }

            }
            //System.out.println(dataList);
            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
