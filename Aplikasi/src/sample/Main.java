package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setTitle("Hunter Guild App - Tugas Akhir PBO");
        primaryStage.setScene(new Scene(root));
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        javafx.scene.image.Image icon = new Image(getClass().getResourceAsStream("/app/images/icon8_yarn_100px_2.png"));
//        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
