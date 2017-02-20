package controller.mains;

import controller.FxmlLoginFbController;
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
 * Created by SAW on 09/02/2017.
 */
public class LoginFB extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        BorderPane root = FXMLLoader.load(getClass().getResource("../../view/FxmlLoginFB.fxml"));
        webEngine.load("https://goo.gl/Ntl44j");
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            int nbrredirect=0;
            @Override
            public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {

                if (newState == Worker.State.SUCCEEDED) {


                    String lien = browser.getEngine().getLocation() ;
                    System.out.println(lien);
                    if(lien.contains("expletus.org/take.php")){

                        try {
                           JSObject window = (JSObject) webEngine.executeScript("window");
                            FxmlLoginFbController fblogin=new FxmlLoginFbController();

                          window.setMember("app", fblogin);


                        } catch (Exception e) {
                        }
                    }
                    else if(lien.contains("https://www.facebook.com/v2.8/dialog/oauth?redirect_uri")){
                        nbrredirect++;

                            webEngine.load("http://expletus.org/take.php");


                    }  }} });
     root.setCenter(browser);


        primaryStage.setTitle("Take Me");
        primaryStage.getIcons().add(new Image("ressources/img/img/logo.png"));
        primaryStage.setScene(new Scene(root, 800, 600));
        //primaryStage.setResizable(false);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
