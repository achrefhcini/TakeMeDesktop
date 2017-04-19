package controller.mains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by SAW on 14/02/2017.
 */
public class FindUser extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FxmlFindUser.fxml"));
        primaryStage.setTitle("Take Me");
        primaryStage.getIcons().add(new Image("ressources/img/img/logo.png"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

}
