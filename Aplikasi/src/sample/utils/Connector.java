package sample.utils;

import sample.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Connector {
    Connection conn =null;
    public static Connection ConnDB()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/guild_administration_db", "root", "");
            return conn;
        }catch (SQLException | ClassNotFoundException e){
            System.err.println("Conector : "+e.getMessage());
            return null;
        }
    }

    public static ObservableList<Quest> getDataQuest(){
        Connection conn = ConnDB();
        ObservableList<Quest> questlist = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM quest");
            ResultSet rs = pst.executeQuery();
            Quest quest;
            while (rs.next()){
                questlist.add(new Quest(Integer.parseInt(rs.getString("quest_id")),rs.getString("quest_title"),rs.getString("quest_type")
                        ,rs.getString("quest_rank"),rs.getString("quest_object"),Integer.parseInt(rs.getString("quest_capacity"))
                        ,Integer.parseInt(rs.getString("quest_power")) ,Integer.parseInt(rs.getString("quest_reward"))
                        ,rs.getString("quest_status")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return questlist;
    }
    public static ObservableList<User> getDataMember(){
        Connection conn = ConnDB();
        ObservableList<User> memberlist = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT member.member_id,member.member_name,member.member_gender,member.member_age,member.member_rank,member.member_power,member.member_money,member.party,status.username,status.password FROM member INNER JOIN status ON member.status_id = status.status_id");
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                memberlist.add(new User(Integer.parseInt(rs.getString("member_id")),rs.getString("member_name"),rs.getString("member_gender")
                ,Integer.parseInt(rs.getString("member_age")),rs.getString("member_rank"),Integer.parseInt(rs.getString("member_power"))
                ,Integer.parseInt(rs.getString("member_money")),rs.getString("party"),rs.getString("username"),rs.getString("password")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return memberlist;
    }
    public static ObservableList<Herb> getDataHerb(){
        Connection conn = ConnDB();
        ObservableList<Herb> herblist = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM herb");
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                herblist.add(new Herb(Integer.parseInt(rs.getString("herb_id")),rs.getString("herb_name")
                        ,rs.getString("herb_rarity"),rs.getString("herb_rank")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return herblist;
    }
    public static ObservableList<Goods> getDataGoods(){
        Connection conn = ConnDB();
        ObservableList<Goods> goodslist = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM goods");
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                goodslist.add(new Goods(Integer.parseInt(rs.getString("goods_id")),rs.getString("goods_name")
                        ,Integer.parseInt(rs.getString("goods_price")),rs.getString("goods_rank")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return goodslist;
    }
    public static ObservableList<Monster> getDataMonster(){
        Connection conn = ConnDB();
        ObservableList<Monster> monsterlist = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM monster");
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                monsterlist.add(new Monster(Integer.parseInt(rs.getString("monster_id")),rs.getString("monster_name")
                        ,Integer.parseInt(rs.getString("monster_power")),rs.getString("monster_rank")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return monsterlist;
    }
}
