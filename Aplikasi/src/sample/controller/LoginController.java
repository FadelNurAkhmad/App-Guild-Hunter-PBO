package sample.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public JFXTextField txtUsername;

    @FXML
    public JFXPasswordField txtPassword;

    @FXML
    public JFXComboBox cbStatus;

    @FXML
    public JFXButton btnLogin;

    @FXML
    public Label ibError;


    @Override
    public void initialize(URL url, ResourceBundle resource) {

    }

    public void handleLogin (ActionEvent actionEvent){
        try{
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/guild_administration_db", "root", "");
            Statement stat = koneksi.createStatement();
            PreparedStatement pst = null;
            ResultSet rs = stat.executeQuery("SELECT * FROM status WHERE username='"+txtUsername.getText()+"' "
                    +"and password='"+txtPassword.getText()+"'");
            if(rs.next()){
                if("admin".equals(rs.getString("status"))){
                    JOptionPane.showMessageDialog(null, "Login Admin Berhasil");
                    System.out.println("Berhasil Login");
                    Parent root = FXMLLoader.load(getClass().getResource("/sample/view/homeAdmin.fxml"));
                    Node node = (Node) actionEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.centerOnScreen();
                }else if("member".equals(rs.getString("status"))){
                    JOptionPane.showMessageDialog(null, "Login User Berhasil");
                    System.out.println("Berhasil Login");
                    Parent root = FXMLLoader.load(getClass().getResource("/sample/view/homeUser.fxml"));
                    Node node = (Node) actionEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.centerOnScreen();
                }

            }else{
                ibError.setTextFill(Color.TOMATO);
                ibError.setText("Username / Password Salah");
                System.err.println("Salah Input");

            }

        }catch (SQLException | IOException e){
            System.out.println("Error "+e);
        }
    }

    double x=0, y=0;
    public void dragged(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setX(mouseEvent.getSceneX() - x);
        stage.setY(mouseEvent.getSceneY() - y);
    }

    public void pressed(MouseEvent mouseEvent) {
        x=mouseEvent.getSceneX();
        y=mouseEvent.getSceneY();
    }

}
