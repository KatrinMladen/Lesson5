public class TestData {
    String send;
    String id;
    String date;
    String status;

    public TestData(String send, String id, String date, String status) {
        this.send = send;
        this.id = id;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "send='" + send + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
