package pojo;

public class Worker {
    private Integer id;
    private String workerName;
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", workerName='" + workerName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
    //有参和无参构造

    public Worker() {
    }

    public Worker(Integer id, String workerName, String phoneNumber) {
        this.id = id;
        this.workerName = workerName;
        this.phoneNumber = phoneNumber;
    }
}
