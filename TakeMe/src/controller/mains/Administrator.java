package controller.mains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by SAW on 12/02/2017.
 */
public class Administrator extends Application {
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getResource("../../view/FxmlAdministrateur.fxml"));
        primaryStage.setTitle("Take Me");
        primaryStage.getIcons().add(new Image("ressources/img/img/logo.png"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinHeight(640);
        primaryStage.setMinWidth(800);

        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
