import java.time.LocalDateTime;

public class TestData {
    String send;
    String id;
    LocalDateTime date;
    String status;


    public TestData(String send, String id, LocalDateTime date, String status) {
        this.send = send;
        this.id = id;
        this. date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "send='" + send + '\'' +
                ", id='" + id + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }

    //    public String getDate () {
//        return date;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getSend() {
//        return send;
//    }
//
//    public String getStatus() {
//        return status;
//    }
}
