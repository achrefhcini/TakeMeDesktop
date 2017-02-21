package controller;

import controller.mains.Login;
import controller.mains.LoginFB;
import controller.mains.Menu;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.crud.CrudMembre;
import model.crud.CrudSession;
import model.entities.Membre;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.entities.Session;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by SAW on 09/02/2017.
 */
public class FxmlLoginFbController {
    private Membre m1=new Membre();
    private CrudMembre crudMembre;
    @FXML
    private BorderPane LoginViewFB;

    @FXML
    void BackLoginView(MouseEvent event) throws Exception {
        System.out.println("Load login Gui");
        Login login =new Login();
        login.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    public void FBConnectResult(String first_name, String last_name, String gender, String email,String user_url_picture) throws Exception {
        System.out.println(first_name);

        this.m1.setNom(first_name);
        this.m1.setPrenom(last_name);
        if((gender.contains("male"))){
            this.m1.setSexe("m");
        }
        else  {
            this.m1.setSexe("f");

        }

        this.m1.setEmail(email);
        this.m1.setPhoto(user_url_picture);
        this.m1.setVerifMail(true);
        this.m1.setActif(true);

    }



    public void AuthentifUserFB() throws Exception {
        CrudSession crudSession = new CrudSession();
        crudMembre=new CrudMembre();
        if(crudMembre.VerfiConnecionFB(this.m1.getEmail())!=0){

            LocalDate dateNow=LocalDate.now();

            Session s=new Session(CrudMembre.IdUserConnected,dateNow,"desktop");
            crudSession.ajouterSession(s);
            Menu home = new Menu();
            home.start(new Stage());
            System.out.println("old");
            System.out.println(CrudMembre.IdUserConnected);
            System.out.println(m1.toString());
            notifOldMmbere();
            Stage stage = (Stage) this.LoginViewFB.getScene().getWindow();
            stage.close();
        }
        else   if(crudMembre.VerfiConnecionFB(this.m1.getEmail())==0){
            LocalDate dateNow=LocalDate.now();

            Session s=new Session(CrudMembre.IdUserConnected,dateNow,"desktop");
            crudSession.ajouterSession(s);
            crudMembre.ajouterMembre(this.m1);
            crudMembre.VerfiConnecionFB(m1.getEmail());
            System.out.println(CrudMembre.IdUserConnected);
            Menu home = new Menu();
            home.start(new Stage());
            System.out.println("new");
            System.out.println(m1.toString());
            notifNewMembre();
            Stage stage = (Stage) this.LoginViewFB.getScene().getWindow();

            stage.close();

        }
    }


    public void notifNewMembre(){
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Bienvenue sur TakeMe ,");
        tray.setMessage(" Félicitation ! Votre compte TakeMe a été bien creé");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.setRectangleFill(Paint.valueOf("#252f41"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.setTrayIcon(new Image("ressources/img/img/logo.png"));

        tray.showAndDismiss(Duration.seconds(8));
    }

    public void notifOldMmbere(){
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Bonjour ,");
        tray.setMessage(" Nous vous souhaitons une bonne journée");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.setRectangleFill(Paint.valueOf("#252f41"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(8));
    }
}
