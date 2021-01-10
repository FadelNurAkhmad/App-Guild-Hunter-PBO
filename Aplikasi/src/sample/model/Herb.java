package sample.model;

public class Herb extends GameObject {

    public String rarity;

    public Herb (){}
    public Herb(int id,String name, String rarity, String rank){
        setID(id);
        setName(name);
        setRarity(rarity);
        setRank(rank);
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRarity() {
        return rarity;
    }

    @Override
    public String getRank() {
        String rank = "C";
        if (getRarity().equals("Mythical")) rank = "S";
        else if (getRarity().equals("Legendary")) rank ="A";
        else if (getRarity().equals("Epic")) rank ="B";
        else if (getRarity().equals("Rare")) rank ="C";
        setRank(rank);
        return rank;
    }
}
