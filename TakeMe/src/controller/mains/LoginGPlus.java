package controller.mains;

import controller.FxmlLoginFbController;
import controller.FxmlLoginGpController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;


/**
 * Created by SAW on 11/02/2017.
 */
public class LoginGPlus extends Application {
    public void start(Stage primaryStage) throws Exception {
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    BorderPane root = FXMLLoader.load(getClass().getResource("../../view/FxmlLoginGP.fxml"));
        webEngine.load("http://www.expletus.org/takemegp.php");
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
        @Override
        public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
            int nbrredirect=0;
            if (newState == Worker.State.SUCCEEDED) {

                String lien = browser.getEngine().getLocation() ;
                System.out.println(lien);
                if(lien.contains("http://www.expletus.org/takemegp.php")){

                    try {
                        JSObject window = (JSObject) webEngine.executeScript("window");
                        FxmlLoginGpController GPlogin=new FxmlLoginGpController();

                        window.setMember("app", GPlogin);


                    } catch (Exception e) {
                    }
                }
                else if(lien.contains("https://accounts.google.com/o/oauth2/auth?redirect_uri=storagerelay")){
                    nbrredirect++;
                    System.out.println(nbrredirect);

             webEngine.load("http://www.expletus.org/takemegp.php");


                }  }} });
     root.setCenter(browser);


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
