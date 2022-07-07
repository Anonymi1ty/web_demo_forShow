package pojo;

public class WareHouse {
    private Integer id;
    private Integer goodNumber;
    private String goodType;
    private String goodPosition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getGoodPosition() {
        return goodPosition;
    }

    public void setGoodPosition(String goodPosition) {
        this.goodPosition = goodPosition;
    }


    @Override
    public String toString() {
        return "WareHouse{" +
                "id=" + id +
                ", goodNumber=" + goodNumber +
                ", goodType='" + goodType + '\'' +
                ", goodPosition='" + goodPosition + '\'' +
                '}';
    }

    public WareHouse() {
    }

    public WareHouse(Integer id, Integer goodNumber, String goodType, String goodPosition) {
        this.id = id;
        this.goodNumber = goodNumber;
        this.goodType = goodType;
        this.goodPosition = goodPosition;
    }
}
