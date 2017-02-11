package controller.mains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getResource("../../view/FxmlMenu.fxml"));
        primaryStage.setTitle("Hello World");
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
