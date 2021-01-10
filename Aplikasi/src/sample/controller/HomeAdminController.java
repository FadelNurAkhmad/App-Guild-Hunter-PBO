package sample.controller;

import sample.model.*;
import sample.utils.Connector;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class HomeAdminController implements Initializable {

    @FXML
    private AnchorPane homeHalaman;
    @FXML
    private BorderPane bpAdmin;
    @FXML
    private JFXButton btnWelcome;
    @FXML
    private JFXButton btnListQuest;
    @FXML
    private JFXButton btnListMember;
    @FXML
    private JFXButton btnListHerb;
    @FXML
    private JFXButton btnListGoods;
    @FXML
    private JFXButton btnListMonster;
    @FXML
    private JFXButton btnTentang;
    @FXML
    private AnchorPane pnWelcome;
    @FXML
    private AnchorPane pnStatus;
    @FXML
    private Label ibStatus;
    @FXML
    private GridPane pnTentang;
    @FXML
    private GridPane pnListMember;

    @FXML
    private TableView<User> memberTable;
    @FXML
    private TableColumn<User, Integer> idColMember;
    @FXML
    private TableColumn<User, String> nameColMember;
    @FXML
    private TableColumn<User, String> genderColMember;
    @FXML
    private TableColumn<User, Integer> ageColMember;
    @FXML
    private TableColumn<User, String> rankColMember;
    @FXML
    private TableColumn<User, Integer> powerColMember;
    @FXML
    private TableColumn<User, Integer> moneyColMember;
    @FXML
    private TableColumn<User, String> partyColMember;
    @FXML
    private TableColumn<User, String> usernameColMember;
    @FXML
    private TableColumn<User, String> passwordColMember;

    @FXML
    private AnchorPane formAddItemMember;
    @FXML
    private TextField tfNameAddMember;
    @FXML
    private TextField tfUsernameAddMember;
    @FXML
    private TextField tfPasswordAddMember;
    @FXML
    private JFXButton btnCancelAddMember;
    @FXML
    private JFXButton btnOkAddMember;
    @FXML
    private AnchorPane formUpdateItemMember;
    @FXML
    private TextField tfNameUpdateMember;
    @FXML
    private ComboBox<String> cbGenderUpdateMember;
    @FXML
    private TextField tfAgeUpdateMember;
    @FXML
    private TextField tfPowerUpdateMember;
    @FXML
    private TextField tfMoneyUpdateMember;
    @FXML
    private TextField tfPartyUpdateMember;
    @FXML
    private TextField tfUsernameUpdateMember;
    @FXML
    private TextField tfPasswordUpdateMember;
    @FXML
    private TextField tfRankUpdateMember;
    @FXML
    private TextField tfIdUpdateMember;
    @FXML
    private JFXButton btnCancelUpdateMember;
    @FXML
    private JFXButton btnRankUpdateMember;
    @FXML
    private JFXButton btnOkUpdateMember;
    @FXML
    private GridPane pnListHerb;
    @FXML
    private AnchorPane formAddItemHerb;
    @FXML
    private TextField tfNameAddHerb;
    @FXML
    private ComboBox<String> cbRarityAddHerb;
    @FXML
    private TextField tfRankAddHerb;
    @FXML
    private JFXButton btnCancelAddHerb;
    @FXML
    private JFXButton btnRankAddHerb;
    @FXML
    private JFXButton btnOkAddHerb;
    @FXML
    private AnchorPane formUpdateItemHerb;
    @FXML
    private TextField tfNameUpdateHerb;
    @FXML
    private ComboBox<String> cbRarityUpdateHerb;
    @FXML
    private TextField tfRankUpdateHerb;
    @FXML
    private JFXButton btnCancelUpdateHerb;
    @FXML
    private JFXButton btnRankUpdateHerb;
    @FXML
    private JFXButton btnOkUpdateHerb;
    @FXML
    private TextField tfIdUpdateHerb;


    @FXML
    private TableView<Herb> tableHerb;
    @FXML
    private TableColumn<Herb, Integer> idColHerb;
    @FXML
    private TableColumn<Herb, String> nameColHerb;
    @FXML
    private TableColumn<Herb, String> rarityColHerb;
    @FXML
    private TableColumn<Herb, String> rankColHerb;
    @FXML
    private GridPane pnListGoods;

    @FXML
    private TableView<Goods> goodsTable;
    @FXML
    private TableColumn<Goods, Integer> idColGoods;
    @FXML
    private TableColumn<Goods, String> nameColGoods;
    @FXML
    private TableColumn<Goods, Integer> priceColGoods;
    @FXML
    private TableColumn<Goods, String> rankColGoods;

    @FXML
    private AnchorPane formUpdateItemGoods;
    @FXML
    private TextField tfNameUpdateGoods;
    @FXML
    private TextField tfPriceUpdateGoods;
    @FXML
    private TextField tfRankUpdateGoods;
    @FXML
    private JFXButton btnCancelUpdateGoods;
    @FXML
    private JFXButton btnRankUpdateGoods;
    @FXML
    private JFXButton btnOkUpdateGoods;
    @FXML
    private AnchorPane formAddItemGoods;
    @FXML
    private TextField tfNameAddGoods;
    @FXML
    private TextField tfPriceAddGoods;
    @FXML
    private TextField tfIdUpdateGoods;
    @FXML
    private TextField tfRankAddGoods;
    @FXML
    private JFXButton btnCancelAddGoods;
    @FXML
    private JFXButton btnRankAddGoods;
    @FXML
    private JFXButton btnOkAddGoods;
    @FXML
    private GridPane pnListMonster;


    @FXML
    private TableView<Monster> monsterTable;
    @FXML
    private TableColumn<Monster, Integer> idColMonster;
    @FXML
    private TableColumn<Monster, String> nameColMonster;
    @FXML
    private TableColumn<Monster, Integer> powerColMonster;
    @FXML
    private TableColumn<Monster, String> rankColMonster;

    @FXML
    private AnchorPane formAddItemMonster;
    @FXML
    private TextField tfNameAddMonster;
    @FXML
    private TextField tfPowerAddMonster;
    @FXML
    private TextField tfRankAddMonster;
    @FXML
    private TextField tfPowerUpdateMonster;
    @FXML
    private JFXButton btnCancelAddMonster;
    @FXML
    private JFXButton btnRankAddMonster;
    @FXML
    private JFXButton btnOkAddMonster;
    @FXML
    private AnchorPane formUpdateItemMonster;
    @FXML
    private TextField tfNameUpdateMonster;
    @FXML
    private TextField tfIdUpdateMonster;

    @FXML
    private TextField tfPriceUpdateMonster;
    @FXML
    private TextField tfRankUpdateMonster;
    @FXML
    private JFXButton btnCancelUpdateMonster;
    @FXML
    private JFXButton btnRankUpdateMonster;
    @FXML
    private JFXButton btnOkUpdateMonster;
    @FXML
    private GridPane pnListQuest;


    @FXML
    private TableView<Quest> questTable;
    @FXML
    private TableColumn<Quest, Integer> idColQuest;
    @FXML
    private TableColumn<Quest, String > titleColQuest;
    @FXML
    private TableColumn<Quest, String> typeColQuest;
    @FXML
    private TableColumn<Quest, String> rankColQuest;
    @FXML
    private TableColumn<Quest, String > objectColQuest;
    @FXML
    private TableColumn<Quest,Integer> capacityColQuest;
    @FXML
    private TableColumn<Quest, Integer> powerColQuest;
    @FXML
    private TableColumn<Quest, Integer> rewardColQuest;
    @FXML
    private TableColumn<Quest, String> statusColQuest;

    @FXML
    private AnchorPane formAddItemQuest;
    @FXML
    private TextField tfTitleQuestAdd;
    @FXML
    private ComboBox<String> cbTypeQuestAdd;
    @FXML
    private TextField tfObjectQuestAdd;
    @FXML
    private TextField tfCapacityQuestAdd;
    @FXML
    private TextField tfPowerQuestAdd;
    @FXML
    private TextField tfRewardQuestAdd;
    @FXML
    private TextField tfStatusQuestAdd;
    @FXML
    private TextField tfRankQuestAdd;
    @FXML
    private JFXButton btnCancelAddQuest;
    @FXML
    private JFXButton btnOkAddQuest;
    @FXML
    private JFXButton btnRankAddQuest;
    @FXML
    private AnchorPane formUpdateItemQuest;
    @FXML
    private TextField tfIdUpdateQuest;
    @FXML
    private TextField tfTitleUpdateQuest;
    @FXML
    private ComboBox<String> cbTypeUpdateQuest;
    @FXML
    private TextField tfObjectUpdateQuest;
    @FXML
    private TextField tfCapacityUpdateQuest;
    @FXML
    private TextField tfPowerUpdateQuest;
    @FXML
    private TextField tfRewardUpdateQuest;
    @FXML
    private TextField tfStatusUpdateQuest;
    @FXML
    private TextField tfRankUpdateQuest;
    @FXML
    private JFXButton btnCancelUpdateQuest;
    @FXML
    private JFXButton btnRankUpdateQuest;
    @FXML
    private JFXButton btnOkUpdateQuest;

    ObservableList<Quest> listQuest;
    ObservableList<User> listMember;
    ObservableList<Herb> listHerb;
    ObservableList<Goods> listGoods;
    ObservableList<Monster> listMonster;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst =null;

    int index = -1;

    // menjalankan apapun saat aplikasi muncul
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Welcome
        pnWelcome.toFront();

        // Atur Form di Quest
        formAddItemQuest.setVisible(false);
        formUpdateItemQuest.setVisible(false);

        // Atur Form di Member
        formAddItemMember.setVisible(false);
        formUpdateItemMember.setVisible(false);

        // Atur Form di Herb
        formAddItemHerb.setVisible(false);
        formUpdateItemHerb.setVisible(false);

        // Atur Form di Goods
        formAddItemGoods.setVisible(false);
        formUpdateItemGoods.setVisible(false);

        // Atur Form di Monster
        formAddItemMonster.setVisible(false);
        formUpdateItemMonster.setVisible(false);

        // Table Quest
        showQuest();
        cbTypeQuestAdd.setItems(listQ);
        cbTypeUpdateQuest.setItems(listQ);
        tfStatusQuestAdd.setText("Available");

        // Table Member
        cbGenderUpdateMember.setItems(listM);
        showMember();

        // Table Herb
        cbRarityAddHerb.setItems(listH);
        cbRarityUpdateHerb.setItems(listH);
        showHerb();

        // Table Goods
        showGoods();

        // Table Monster
        showMonster();



    }

    //Properti Halaman Dashboard Admin
    public void handleClick(ActionEvent event) {
        if (event.getSource() == btnWelcome)
        {
            pnWelcome.toFront();
            pnWelcome.setVisible(true);

        }
        else if (event.getSource() == btnListQuest)
        {
            ibStatus.setText("List Quest");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 177, 66 ), CornerRadii.EMPTY, Insets.EMPTY)));
            pnListQuest.toFront();
            pnWelcome.setVisible(false);
            formAddItemQuest.setVisible(false);
            formUpdateItemQuest.setVisible(false);
        }
        else if (event.getSource() == btnListMember)
        {
            ibStatus.setText("List Member");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 218, 121 ), CornerRadii.EMPTY, Insets.EMPTY)));
            pnListMember.toFront();
            pnWelcome.setVisible(false);
            formAddItemMember.setVisible(false);
            formUpdateItemMember.setVisible(false);
        }
        else if (event.getSource() == btnListHerb) {
            ibStatus.setText("List Herb");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(209, 204, 192 ), CornerRadii.EMPTY, Insets.EMPTY)));
            pnListHerb.toFront();
            formAddItemHerb.setVisible(false);
            formUpdateItemHerb.setVisible(false);
        }
        else if (event.getSource() == btnListGoods)
        {
            ibStatus.setText("List Goods");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 121, 63 ), CornerRadii.EMPTY, Insets.EMPTY)));
            pnListGoods.toFront();
            pnWelcome.setVisible(false);
            formAddItemGoods.setVisible(false);
            formUpdateItemGoods.setVisible(false);
        }
        else if (event.getSource() == btnListMonster)
        {
            ibStatus.setText("List Monster");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(51, 217, 178 ), CornerRadii.EMPTY, Insets.EMPTY)));
            pnListMonster.toFront();
            pnWelcome.setVisible(false);
            formAddItemMonster.setVisible(false);
            formUpdateItemMonster.setVisible(false);
        }
        else if (event.getSource() == btnTentang) {
            ibStatus.setText("Tentang");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 82, 82 ), CornerRadii.EMPTY, Insets.EMPTY)));
            pnTentang.toFront();
            pnWelcome.setVisible(false);

        }
    }
    public void logout(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/login.fxml"));
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
    }

    //Halaman Quest
    public void btnAddItemQuest(ActionEvent actionEvent) {
        formAddItemQuest.setVisible(true);
        formUpdateItemQuest.setVisible(false);
    }
    public void btnUpdateItemQuest(ActionEvent actionEvent) {
        formUpdateItemQuest.setVisible(true);
        formAddItemQuest.setVisible(false);
    }

    public void btnDeleteItemQuest(ActionEvent actionEvent) {
        formUpdateItemQuest.setVisible(false);
        formAddItemQuest.setVisible(false);

        conn = Connector.ConnDB();
        String sql = "DELETE FROM quest WHERE quest_id=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, tfIdUpdateQuest.getText());
            pst.execute();
            showQuest();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void getSelectedQuest (MouseEvent event){
        Quest quest = questTable.getSelectionModel().getSelectedItem();

        tfIdUpdateQuest.setText(""+quest.getID());
        tfTitleUpdateQuest.setText(quest.getTitle());
        cbTypeUpdateQuest.getSelectionModel().select(quest.getType());
        tfRankUpdateQuest.setText(quest.getRank());
        tfObjectUpdateQuest.setText(quest.getObject());
        tfCapacityUpdateQuest.setText(""+quest.getCapacity());
        tfPowerUpdateQuest.setText("" +quest.getPower());
        tfRewardUpdateQuest.setText("" +quest.getReward());
        tfStatusUpdateQuest.setText(quest.getStatus());

    }

    public void showQuest(){
        idColQuest.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("ID"));
        titleColQuest.setCellValueFactory(new PropertyValueFactory<Quest, String>("Title"));
        typeColQuest.setCellValueFactory(new PropertyValueFactory<Quest, String>("Type"));
        rankColQuest.setCellValueFactory(new PropertyValueFactory<Quest, String>("Rank"));
        objectColQuest.setCellValueFactory(new PropertyValueFactory<Quest, String>("Object"));
        capacityColQuest.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("Capacity"));
        powerColQuest.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("Power"));
        rewardColQuest.setCellValueFactory(new PropertyValueFactory<Quest, Integer>("Reward"));
        statusColQuest.setCellValueFactory(new PropertyValueFactory<Quest, String>("Status"));

        listQuest = Connector.getDataQuest();
        questTable.setItems(listQuest);

    }

    ObservableList<String> listQ = FXCollections.observableArrayList("Gathering","Subjugation","Escort");
    public void okButtonQuest(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnOkAddQuest){

            try{
                conn = Connector.ConnDB();
                String sql = "INSERT INTO quest(quest_title,quest_type,quest_rank,quest_object,quest_capacity,quest_power,quest_reward,quest_status)values(?,?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(sql);
                pst.setString(1, tfTitleQuestAdd.getText());
                pst.setString(2, cbTypeQuestAdd.getSelectionModel().getSelectedItem());
                pst.setString(3, tfRankQuestAdd.getText());
                pst.setString(4, tfObjectQuestAdd.getText());
                pst.setString(5, tfCapacityQuestAdd.getText());
                pst.setString(6, tfPowerQuestAdd.getText());
                pst.setString(7, tfRewardQuestAdd.getText());
                pst.setString(8, tfStatusQuestAdd.getText());
                pst.execute();
                showQuest();
                formAddItemQuest.setVisible(false);

                }catch (Exception e){
                 e.printStackTrace();
                }
            }else if(actionEvent.getSource() == btnOkUpdateQuest){
                try{
                    conn = Connector.ConnDB();

                    String value1 = tfTitleUpdateQuest.getText();
                    String value2 = cbTypeUpdateQuest.getSelectionModel().getSelectedItem();
                    String value3 = tfRankUpdateQuest.getText();
                    String value4 = tfObjectUpdateQuest.getText();
                    String value5 = tfCapacityUpdateQuest.getText();
                    String value6 = tfPowerUpdateQuest.getText();
                    String value7 = tfRewardUpdateQuest.getText();
                    String value8 = tfStatusUpdateQuest.getText();
                    String value9 = tfIdUpdateQuest.getText();

                    String sql = "UPDATE quest set quest_title= '"+value1+"',quest_type= '"+value2+"',quest_rank= '"+value3+"',quest_object= '"+
                            value4+"',quest_capacity= '"+value5+"',quest_power= '"+value6+"',quest_reward= '"+value7+"',quest_status= '"+ value8+"'WHERE quest_id='"+value9+"''";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    showQuest();
                }catch (Exception e){
                    e.printStackTrace();
            }
        }
        }

    public void checkRankButtonQuest(ActionEvent actionEvent) {
    }

    public void cancelButtonQuest(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCancelAddQuest){
            formAddItemQuest.setVisible(false);
        }else if (actionEvent.getSource() == btnCancelUpdateQuest){
            formUpdateItemQuest.setVisible(false);
        }
    }



    // Halaman Member
    public void btnAddItemMember(ActionEvent actionEvent) {
        formAddItemMember.setVisible(true);
        formUpdateItemMember.setVisible(false);
    }

    public void btnUpdateItemMember(ActionEvent actionEvent) {
        formUpdateItemMember.setVisible(true);
        formAddItemMember.setVisible(false);
    }

    public void btnDeleteItemMember(ActionEvent actionEvent) {
        formAddItemMember.setVisible(false);
        formUpdateItemMember.setVisible(false);

        conn = Connector.ConnDB();
        String sql = "DELETE FROM member WHERE member_id=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, tfIdUpdateMember.getText());
            pst.execute();
            showQuest();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    ObservableList<String> listM = FXCollections.observableArrayList("Male","Female");
    @FXML
    private void getSelectedMember (MouseEvent event){
        User user = memberTable.getSelectionModel().getSelectedItem();

        tfNameUpdateMember.setText(""+user.getId());
        cbGenderUpdateMember.getSelectionModel().select(user.getGender());
        tfAgeUpdateMember.setText(""+user.getAge());
        tfRankUpdateMember.setText(user.getRank());
        tfPowerUpdateMember.setText(""+user.getPower());
        tfMoneyUpdateMember.setText(""+user.getMoney());
        tfPartyUpdateMember.setText(user.getParty());
        tfUsernameUpdateMember.setText(user.getUsername());
        tfPasswordUpdateMember.setText(user.getPassword());

    }
    public void showMember(){
        idColMember.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID"));
        nameColMember.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
        genderColMember.setCellValueFactory(new PropertyValueFactory<User, String>("Gender"));
        ageColMember.setCellValueFactory(new PropertyValueFactory<User, Integer>("Age"));
        rankColMember.setCellValueFactory(new PropertyValueFactory<User, String>("Rank"));
        powerColMember.setCellValueFactory(new PropertyValueFactory<User, Integer>("Power"));
        moneyColMember.setCellValueFactory(new PropertyValueFactory<User, Integer>("Money"));
        partyColMember.setCellValueFactory(new PropertyValueFactory<User, String>("Party"));
        usernameColMember.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));
        passwordColMember.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));

        listMember = Connector.getDataMember();
        memberTable.setItems(listMember);

    }

    public void okButtonMember(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnOkAddMember){

            try{
                conn = Connector.ConnDB();
                String sql = "INSERT INTO member(member_name,username,password) VALUES (?,?,?)";

                pst = conn.prepareStatement(sql);
                pst.setString(1, tfNameAddMember.getText());
                pst.setString(2, tfUsernameAddMember.getText());
                pst.setString(3, tfPasswordAddMember.getText());

                pst.execute();
                showMember();
                formAddItemMember.setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(actionEvent.getSource() == btnOkUpdateMember){
            try{
                conn = Connector.ConnDB();
                String value1 = tfNameUpdateGoods.getText();
                String value2 = tfPriceUpdateGoods.getText();
                String value3 = tfRankUpdateGoods.getText();

                String sql = "UPDATE goods set goods_name= '"+value1+"',goods_price= '"+value2+"',goods_rank'"+value3+"'WHERE goods_id='"+value3+"''";
                pst = conn.prepareStatement(sql);
                pst.execute();
                showMember();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public void checkRankButtonMember(ActionEvent actionEvent) {
    }

    public void cancelButtonMember(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCancelAddMember){
            formAddItemMember.setVisible(false);
        }else if (actionEvent.getSource() == btnCancelUpdateMember){
            formUpdateItemMember.setVisible(false);
        }
    }

    // Halaman Herb
    public void btnAddItemHerb(ActionEvent actionEvent) {
        formAddItemHerb.setVisible(true);
        formUpdateItemHerb.setVisible(false);
    }

    public void btnUpdateItemHerb(ActionEvent actionEvent) {
        formUpdateItemHerb.setVisible(true);
        formAddItemHerb.setVisible(false);
    }

    public void btnDeleteItemHerb(ActionEvent actionEvent) {
        formUpdateItemHerb.setVisible(false);
        formAddItemHerb.setVisible(false);

        conn = Connector.ConnDB();
        String sql = "DELETE FROM member WHERE herb_id=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, tfIdUpdateHerb.getText());
            pst.execute();
            showHerb();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    ObservableList<String> listH = FXCollections.observableArrayList("Legendary","Epic","Rare");
    @FXML
    private void getSelectedHerb (MouseEvent event){
        Herb herb = (Herb) tableHerb.getSelectionModel().getSelectedItem();

        tfIdUpdateHerb.setText(""+herb.getID());
        tfNameUpdateHerb.setText(herb.getName());
        cbRarityUpdateHerb.getSelectionModel().select(herb.getRarity());
        tfRankUpdateHerb.setText(herb.getRank());

    }

    public void showHerb(){
        idColHerb.setCellValueFactory(new PropertyValueFactory<Herb, Integer>("ID"));
        nameColHerb.setCellValueFactory(new PropertyValueFactory<Herb, String>("Name"));
        rarityColHerb.setCellValueFactory(new PropertyValueFactory<Herb, String>("Rarity"));
        rankColHerb.setCellValueFactory(new PropertyValueFactory<Herb, String>("Rank"));

        listHerb = Connector.getDataHerb();
        tableHerb.setItems(listHerb);

    }

    public void okButtonHerb(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnOkAddHerb){

            try{
                conn = Connector.ConnDB();
                String sql = "INSERT INTO herb(herb_id,herb_name,herb_rarity,herb_rank)values(?,?,?,?)";

                pst = conn.prepareStatement(sql);
                pst.setString(1, tfNameAddHerb.getText());
                pst.setString(2, cbRarityAddHerb.getSelectionModel().getSelectedItem());
                pst.setString(3, tfRankAddHerb.getText());

                pst.execute();
                showHerb();
                formAddItemHerb.setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(actionEvent.getSource() == btnOkUpdateHerb){
            try{
                conn = Connector.ConnDB();
                String value1 = tfNameUpdateHerb.getText();
                String value2 = cbRarityUpdateHerb.getSelectionModel().getSelectedItem();
                String value3 = tfRankUpdateHerb.getText();

                String sql = "UPDATE herb set herb_name= '"+value1+"',herb_rarity= '"+value2+"',herb_rank'"+value3+"'WHERE herb_id='"+value3+"''";
                pst = conn.prepareStatement(sql);
                pst.execute();
                showHerb();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void checkRankButtonHerb(ActionEvent actionEvent) {
    }
    public void cancelButtonHerb(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCancelAddHerb){
            formAddItemHerb.setVisible(false);
        }else if (actionEvent.getSource() == btnCancelUpdateHerb){
            formUpdateItemHerb.setVisible(false);
        }
    }

    // Halaman Goods
    public void btnAddItemGoods(ActionEvent actionEvent) {
        formAddItemGoods.setVisible(true);
        formUpdateItemGoods.setVisible(false);
    }

    public void btnUpdateItemGoods(ActionEvent actionEvent) {
        formUpdateItemGoods.setVisible(true);
        formAddItemGoods.setVisible(false);
    }

    public void btnDeleteItemGoods(ActionEvent actionEvent) {
        formUpdateItemGoods.setVisible(false);
        formAddItemGoods.setVisible(false);

        conn = Connector.ConnDB();
        String sql = "DELETE FROM quest WHERE goods_id=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, tfIdUpdateGoods.getText());
            pst.execute();
            showGoods();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void getSelectedGoods (MouseEvent event){
        Goods goods = goodsTable.getSelectionModel().getSelectedItem();

        tfIdUpdateGoods.setText(""+goods.getID());
        tfNameUpdateGoods.setText(goods.getName());
        tfPriceUpdateGoods.setText(String.valueOf(goods.getPrice()));
        tfRankUpdateGoods.setText(goods.getRank());

    }

    public void showGoods() {
        idColGoods.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("ID"));
        nameColGoods.setCellValueFactory(new PropertyValueFactory<Goods, String>("Name"));
        priceColGoods.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("Price"));
        rankColGoods.setCellValueFactory(new PropertyValueFactory<Goods, String>("Rank"));

        listGoods = Connector.getDataGoods();
        goodsTable.setItems(listGoods);
    }

    public void okButtonGoods(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnOkAddGoods){

            try{
                conn = Connector.ConnDB();
                String sql = "INSERT INTO goods(goods_id,goods_name,goods_price,goods_rank)values(?,?,?,?)";

                pst = conn.prepareStatement(sql);
                pst.setString(1, tfNameAddHerb.getText());
                pst.setString(2, tfPriceAddGoods.getText());
                pst.setString(3, tfRankAddHerb.getText());

                pst.execute();
                showGoods();
                formAddItemGoods.setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(actionEvent.getSource() == btnOkUpdateGoods){
            try{
                conn = Connector.ConnDB();
                String value1 = tfNameUpdateGoods.getText();
                String value2 = tfPriceUpdateGoods.getText();
                String value3 = tfRankUpdateGoods.getText();

                String sql = "UPDATE goods set goods_name= '"+value1+"',goods_price= '"+value2+"',goods_rank'"+value3+"'WHERE goods_id='"+value3+"''";
                pst = conn.prepareStatement(sql);
                pst.execute();
                showGoods();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public void checkRankButtonGoods(ActionEvent actionEvent) {
    }

    public void cancelButtonGoods(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCancelAddGoods){
            formAddItemGoods.setVisible(false);
        }else if (actionEvent.getSource() == btnCancelUpdateGoods){
            formUpdateItemGoods.setVisible(false);
        }
    }

    // Halaman Monster
    public void btnAddItemMonster(ActionEvent actionEvent) {
        formAddItemMonster.setVisible(true);
        formUpdateItemMonster.setVisible(false);
    }

    public void btnUpdateItemMonster(ActionEvent actionEvent) {
        formUpdateItemMonster.setVisible(true);
        formAddItemMonster.setVisible(false);
    }

    public void btnDeleteItemMonster(ActionEvent actionEvent) {
        formUpdateItemMonster.setVisible(false);
        formAddItemMonster.setVisible(false);

        conn = Connector.ConnDB();
        String sql = "DELETE FROM monster WHERE monster_id=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, tfIdUpdateMonster.getText());
            pst.execute();
            showMonster();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void getSelectedMonster (MouseEvent event){
        Monster monster = monsterTable.getSelectionModel().getSelectedItem();

        tfIdUpdateMonster.setText(""+monster.getID());
        tfNameUpdateMonster.setText(monster.getName());
        tfPowerUpdateMonster.setText(String.valueOf(monster.getPower()));
        tfRankUpdateMonster.setText(monster.getRank());

    }

    public void showMonster() {
        idColMonster.setCellValueFactory(new PropertyValueFactory<Monster, Integer>("ID"));
        nameColMonster.setCellValueFactory(new PropertyValueFactory<Monster, String>("Name"));
        powerColMonster.setCellValueFactory(new PropertyValueFactory<Monster, Integer>("Power"));
        rankColMonster.setCellValueFactory(new PropertyValueFactory<Monster, String>("Rank"));

        listMonster = Connector.getDataMonster();
        monsterTable.setItems(listMonster);
    }

    public void okButtonMonster(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnOkAddMonster){

            try{
                conn = Connector.ConnDB();
                String sql = "INSERT INTO monster(monster_id,monster_name,monster_power,monster_rank)values(?,?,?,?)";

                pst = conn.prepareStatement(sql);
                pst.setString(1, tfNameAddMonster.getText());
                pst.setString(2, tfPowerAddMonster.getText());
                pst.setString(3, tfRankAddMonster.getText());

                pst.execute();
                showGoods();
                formAddItemMonster.setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(actionEvent.getSource() == btnOkUpdateMonster){
            try{
                conn = Connector.ConnDB();
                String value1 = tfNameUpdateMonster.getText();
                String value2 = tfPowerUpdateMonster.getText();
                String value3 = tfRankUpdateMonster.getText();
                String value4 = tfIdUpdateMonster.getText();

                String sql = "UPDATE monster set monster_name= '"+value1+"',monster_poser= '"+value2+"',monster_rank'"+value3+"'WHERE monster_id='"+value4+"''";
                pst = conn.prepareStatement(sql);
                pst.execute();
                showMonster();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public void checkRankButtonMonster(ActionEvent actionEvent) {
    }

    public void cancelButtonMonster(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCancelAddMonster){
            formAddItemMonster.setVisible(false);
        }else if (actionEvent.getSource() == btnCancelUpdateMonster){
            formUpdateItemMonster.setVisible(false);
        }
    }


}


