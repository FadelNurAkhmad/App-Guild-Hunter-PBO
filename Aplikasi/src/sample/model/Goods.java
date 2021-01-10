package sample.model;

public class Goods extends GameObject{

        private int price;

        public Goods (){}

        public Goods(int id,String name, int price, String rank){
            setID(id);
            setName(name);
            setPrice(price);
            setRank(rank);
        }

        public void setPrice(int price) {
            this.price = price;
        }
        public int getPrice() {
            return price;
        }

    @Override
        public String getRank() {
            String rank = "C";
            if (getPrice() > 100) rank = "S";
            else if (getPrice() > 50) rank ="A";
            else if (getPrice() > 10) rank ="B";
            else if (getPrice() > 1) rank ="C";
            setRank(rank);
            return rank;
        }
}

