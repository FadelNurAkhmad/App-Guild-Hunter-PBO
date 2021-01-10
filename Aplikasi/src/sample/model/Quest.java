package sample.model;

public class Quest {
    private int id;
    private String title;
    private String type;
    private String rank;
    private String object;
    private int capacity;
    private int power;
    private int reward;
    private String status;


    public Quest (){}

    public Quest(int id, String title, String type, String rank, String object, int capacity, int power, int reward, String status) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.rank = rank;
        this.object = object;
        this.capacity = capacity;
        this.power = power;
        this.reward = reward;
        this.status = status;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getRank() {
        return rank;
    }

    public String getObject() {
        return object;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPower() {
        return power;
    }

    public int getReward() {
        return reward;
    }

    public String getStatus() {
        return status;
    }




}
