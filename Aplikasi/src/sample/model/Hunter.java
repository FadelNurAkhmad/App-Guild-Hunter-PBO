package app.model;


import app.utils.DBConnector;
import javax.swing.text.TableView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Hunter extends User {
   private String gender;
   private int age;
   private String rank;
   private int power;
   private int money;
   private String party;
   private List<Quest> listQuest;

   //constructor
   public Hunter() {
   }

   public Hunter(int id, int money) {
       setId(id);
       setMoney(money);
   }

   public Hunter(String name, String username, String password) {
       setName(name);
       setUsername(username);
       setPassword(password);
   }

   public Hunter(int id, String name, int power) {
       setId(id);
       setName(name);
       setPower(power);
   }

   public Hunter(int id, String name, String gender, int age, String rank, int power, int money, String party, String username, String password) {
       setId(id);
       setName(name);
       setGender(gender);
       setAge(age);
       setRank(rank);
       setPower(power);
       setMoney(money);
       setParty(party);
       setUsername(username);
       setPassword(password);
   }

   //setter
   public void setGender(String gender) {
       this.gender = gender;
   }

   public void setAge(int age) {
       this.age = age;
   }

   public void setRank(String rank) {
       this.rank = rank;
   }

   public void setPower(int power) {
       this.power = power;
   }

   public void setMoney(int money) {
       this.money = money;
   }

   public void setParty(String party) {
       this.party = party;
   }

   //getter
   public String getGender() {
       return gender;
   }

   public int getAge() {
       return age;
   }

   public int getPower() {
       return power;
   }

   public int getMoney() {
       return money;
   }

   public String getParty() {
       return party;
   }

   public String getRank() {
       if (getPower() > 100) rank = "S";
       else if (getPower() > 80) rank = "A";
       else if (getPower() > 60) rank = "B";
       else if (getPower() > 40) rank = "C";
       setRank(rank);
       return rank;
   }

    public static Hunter getMemberInfo(User user) {
       ...
    }

    public static Party getPartyInfo(Hunter member, TableView<Hunter> tableProfileParty) {
        ...
    }

    public static void distributeRewards(User user, Quest quest) {
        Hunter member = Hunter.getMemberInfo(user);
        if (quest.getStatus().equals(member.getName())) {
            int money = member.getMoney() = quest.getReward();
            String dbCommand = "UPDATE table_member SET member_money = " + money + "WHERE member_id = " + member.getId();
            DBConnector dbConn = new DBConnector();
            dbConn.update(dbCommand);
        } else {
            String dbCommand = "SELECT member_id, member_money FROM table_member WHERE member_party =' " + member.getParty() + "'";
            DBConnector dbConn = new DBConnector();
           dbConn.start(dbCommand);
            int addMoney = quest.getReward() / dbConn.getData().size();

           for (ObservableList<String> dataRow : dbConn.getData()) {
                int memberMoney + Integer.parseInt(dataRow.get(1)) + addMoney;
                dbCommand = "UPDATE table_member SET member_money = " + memberMoney + "WHERE member_id = " + Integer.parseInt(dataRow.get(0));

                DBConnector dbConn1 = new DBConnector();
                dbConn1.update(dbCommand);
            }
        }
    }
}
}
