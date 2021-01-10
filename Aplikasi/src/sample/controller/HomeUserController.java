package sample.controller;

import sample.model.Quest;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeUserController implements Initializable {


    @FXML
    public JFXButton btnWelcomeUser;
    @FXML
    public AnchorPane pnWelcomeUser;
    @FXML
    public GridPane pnListJobs;
    @FXML
    public GridPane pnTentangUser;
    @FXML
    public JFXButton btnListJobs;
    @FXML
    public JFXButton btnTentangUser;
    @FXML
    public AnchorPane formPartyQuest;
    @FXML
    public AnchorPane formActiveQuest;
    @FXML
    public AnchorPane formSoloQuest;
    @FXML
    public AnchorPane formJobs;
    @FXML
    public JFXButton btnCLoseParty;
    @FXML
    public JFXButton btnCLoseSolo;
    @FXML
    public JFXButton btnCLoseActive;
    @FXML
    public JFXButton btnTakeSolo;
    @FXML
    public JFXButton btnTakeParty;
    @FXML
    public JFXButton btnTakeActive;
    @FXML
    public AnchorPane ibTentangUser;

    @FXML
    public TableView<?> tablePartyMember;
    @FXML
    public TableColumn<?, ?> idColPartyMember;
    @FXML
    public TableColumn<?, ?> nameColPartyMember;
    @FXML
    public TableColumn<?, ?> rankColPartyMember;
    @FXML
    public TableColumn<?, ?> powerColPartyMember;


    @FXML
    public JFXTextField tfNameProfile;
    @FXML
    public JFXTextField tfGenderProfile;
    @FXML
    public JFXTextField tfAgeProfile;
    @FXML
    public JFXTextField tfPowerProfile;
    @FXML
    public JFXTextField tfMoneyProfile;
    @FXML
    public JFXTextField tfRankProfile;
    @FXML
    public JFXTextField tfPartyProfile;

    @FXML
    public TableView<?> tableSoloQuest;
    @FXML
    public TableColumn<?, ?> idColSoloQuest;
    @FXML
    public TableColumn<?, ?> titleColSoloQuest;
    @FXML
    public TableColumn<?, ?> typeColSoloQuest;
    @FXML
    public TableColumn<?, ?> rankColSoloQuest;
    @FXML
    public TableColumn<?, ?> powerColSoloQuest;
    @FXML
    public TableColumn<?, ?> rewardColSoloQuest;

    @FXML
    public TableView<?> tablePartyQuest;
    @FXML
    public TableColumn<?, ?> idColPartyQuest;
    @FXML
    public TableColumn<?, ?> titleColPartyQuest;
    @FXML
    public TableColumn<?, ?> typeColPartyQuest;
    @FXML
    public TableColumn<?, ?> rankColPartyQuest;
    @FXML
    public TableColumn<?, ?> powerColPartyQuest;
    @FXML
    public TableColumn<?, ?> rewardColPartyQuest;

    @FXML
    public TableView<Quest> tableActiveQuest;
    @FXML
    public TableColumn<Quest, Integer> idColActiveQuest;
    @FXML
    public TableColumn<Quest, String> titleColActiveQuest;
    @FXML
    public TableColumn<Quest, String> typeColActiveQuest;
    @FXML
    public TableColumn<Quest, String> rankColActiveQuest;
    @FXML
    public TableColumn<?, ?> powerColActiveQuest;
    @FXML
    public TableColumn<?, ?> rewardColActiveQuest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting Form di Jobs User
        pnWelcomeUser.toFront();
        formPartyQuest.setVisible(false);
        formSoloQuest.setVisible(false);
        formActiveQuest.setVisible(false);
    }
        public void logout (MouseEvent mouseEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/view/login.fxml"));
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        }

        // Halaman User
        public void handleClickUser (ActionEvent event){
            if (event.getSource() == btnWelcomeUser) {
                pnWelcomeUser.toFront();

            } else if (event.getSource() == btnListJobs) {
                pnListJobs.toFront();
                formPartyQuest.setVisible(false);
                formSoloQuest.setVisible(false);
                formActiveQuest.setVisible(false);
                formJobs.toBack();

            } else if(event.getSource() == btnTentangUser){
                pnTentangUser.toFront();

            }

        }

    public void btnSoloQuest (ActionEvent actionEvent){
            formJobs.toFront();
            formPartyQuest.setVisible(false);
            formSoloQuest.setVisible(true);
            formActiveQuest.setVisible(false);
        }

        public void btnPartyQuest (ActionEvent actionEvent){
            formJobs.toFront();
            formPartyQuest.setVisible(true);
            formSoloQuest.setVisible(false);
            formActiveQuest.setVisible(false);
        }

        public void btnActiveQuest (ActionEvent actionEvent){
            formJobs.toFront();
            formPartyQuest.setVisible(false);
            formSoloQuest.setVisible(false);
            formActiveQuest.setVisible(true);
        }

    public void btnCloseJobs(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCLoseSolo){
            formSoloQuest.setVisible(false);
            formJobs.toBack();
        }else if (actionEvent.getSource() == btnCLoseParty){
            formPartyQuest.setVisible(false);
            formJobs.toBack();
        }else if(actionEvent.getSource() == btnCLoseActive){
            formActiveQuest.setVisible(false);
            formJobs.toBack();
        }
    }

    public void btnTakeJobs(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnTakeSolo){

        }else if(actionEvent.getSource() == btnTakeParty){

        }else if(actionEvent.getSource() == btnTakeParty){

        }
    }
}
