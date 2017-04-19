package controller;

import controller.mains.Login;
import controller.mains.Menu;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import model.crud.CrudMembre;
import model.crud.CrudSession;
import model.entities.Membre;
import model.entities.Session;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.time.LocalDate;

/**
 * Created by SAW on 11/02/2017.
 */
public class FxmlLoginGpController {


    private Membre m1=new Membre();
    private CrudMembre crudMembre;
    @FXML
    private BorderPane LoginViewGP;
    @FXML
    private Text BackLogin;

    @FXML
    void BackLoginView(MouseEvent event) throws Exception {
        System.out.println("Load login Gui");
        Login login =new Login();
        login.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    public void GpConnectResult(String first_name, String last_name, String email,String user_url_picture) throws Exception {
        System.out.println(first_name);

        this.m1.setNom(first_name);
        this.m1.setPrenom(last_name);
        this.m1.setEmail(email);
        this.m1.setPhoto(user_url_picture);
        this.m1.setVerifMail(true);
        this.m1.setActif(true);

    }



    public void AuthentifUserGp() throws Exception {
        CrudSession crudSession = new CrudSession();
        crudMembre=new CrudMembre();
        if(crudMembre.VerfiConnecionFB(this.m1.getEmail())!=0){
            LocalDate dateNow=LocalDate.now();

            Session s=new Session(CrudMembre.IdUserConnected,dateNow,"desktop");
             crudSession.ajouterSession(s);

            Menu home = new Menu();
            home.start(new Stage());
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Bonjour ,");
            tray.setMessage(" Nous vous souhaitons une bonne journée");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.setRectangleFill(Paint.valueOf("#252f41"));
            tray.setAnimationType(AnimationType.POPUP);
            tray.showAndDismiss(Duration.seconds(8));
            System.out.println("old");

            System.out.println(CrudMembre.IdUserConnected);
            System.out.println(m1.toString());

        }
        else   if(crudMembre.VerfiConnecionFB(this.m1.getEmail())==0){
            crudMembre.ajouterMembre(this.m1);
            crudMembre.VerfiConnecionFB(m1.getEmail());
            System.out.println(CrudMembre.IdUserConnected);
            LocalDate dateNow=LocalDate.now();

            Session s=new Session(CrudMembre.IdUserConnected,dateNow,"desktop");
            crudSession.ajouterSession(s);
            Menu home = new Menu();
            home.start(new Stage());
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Bienvenue sur TakeMe ,");
            tray.setMessage(" Félicitation ! Votre compte TakeMe a été bien creé");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.setRectangleFill(Paint.valueOf("#252f41"));
            tray.setTrayIcon(new Image("ressources/img/img/logo.png"));
            tray.setAnimationType(AnimationType.POPUP);
            tray.showAndDismiss(Duration.seconds(8));
            System.out.println("new");
            System.out.println(m1.toString());




        }
    }
}
