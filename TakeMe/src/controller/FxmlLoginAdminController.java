package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.mains.Administrator;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.crud.CrudMembre;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.sql.SQLException;

/**
 * Created by SAW on 14/02/2017.
 */
public class FxmlLoginAdminController {

    @FXML
    private JFXTextField emailUser;

    @FXML
    private JFXPasswordField PassworldUser;

    @FXML
    private Label erreurtext;

    private int iduser;

    @FXML
    void SeConnecter(MouseEvent event) throws Exception {

        CrudMembre crudMembre=new CrudMembre();
        iduser=crudMembre.VerfiConnexionAdmin(emailUser.getText(),PassworldUser.getText());
        if(iduser!=0){
            Administrator loginAdmin =new Administrator();
            loginAdmin.start(new Stage());
            ((Node)(event.getSource())).getScene().getWindow().hide();
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Bonjour Sir ,");
            tray.setMessage(" Nous vous souhaitons une bonne journée");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.setRectangleFill(Paint.valueOf("#252f41"));

            tray.setAnimationType(AnimationType.POPUP);

            tray.showAndDismiss(Duration.seconds(8));

        }
        else {
            erreurtext.setVisible(true);
        }


    }




}