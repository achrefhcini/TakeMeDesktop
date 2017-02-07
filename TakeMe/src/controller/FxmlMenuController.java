package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import controller.mains.Login;

import java.io.IOException;

public class FxmlMenuController {

    @FXML
    private BorderPane tochange;

    @FXML
  public void SearchLoader (MouseEvent event) throws IOException {
        System.out.println("Load Search Gui");
        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlSearch.fxml"));

        tochange.setCenter(s);
    }
    @FXML
    public void HomeLoader(MouseEvent event) throws IOException {
        System.out.println("Load Home Gui");
        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlHome.fxml"));

        tochange.setCenter(s);

    }
    @FXML


    public void JourneyLoader(MouseEvent event) throws IOException {
        System.out.println("Load journey Gui");
        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlJourney.fxml"));

        tochange.setCenter(s);
    }

    @FXML
    public void ActivityLoader(MouseEvent event) throws IOException {
        System.out.println("Load Activity Gui");
        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlActivity.fxml"));

        tochange.setCenter(s);

    }

    @FXML

    public void MessageLoader(MouseEvent event) throws IOException {
        System.out.println("Load Message Gui");
        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlMessage.fxml"));

        tochange.setCenter(s);

    }
    public void NotificationLoader(MouseEvent event) throws IOException {
        System.out.println("Load Notification Gui");
        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlMessage.fxml"));

        tochange.setCenter(s);

    }

    @FXML
    private void initialize() throws IOException {



    }


  
    public void LoginLoader(MouseEvent event) throws Exception {
        System.out.println("Load login Gui");
        Login login =new Login();
        login.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
}