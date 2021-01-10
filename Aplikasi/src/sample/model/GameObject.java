package sample.model;

public abstract class GameObject {
    private int id;
    private String name;
    private String rank;

    //constructor
    public GameObject(){}

    //Setter
    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    //Getter
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getRank();
}
