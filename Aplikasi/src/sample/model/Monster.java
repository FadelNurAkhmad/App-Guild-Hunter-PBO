package sample.model;

public class Monster extends GameObject {

    private int power;

    public Monster (){}

    public Monster(int id,String name, int power, String rank){
        setID(id);
        setName(name);
        setPower(power);
        setRank(rank);
    }
    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String getRank() {
        String rank = "C";
        if (getPower() > 300) rank = "S";
        else if (getPower() > 200) rank ="A";
        else if (getPower() > 80) rank ="B";
        else if (getPower() > 50) rank ="C";
        setRank(rank);
        return rank;
    }
}
