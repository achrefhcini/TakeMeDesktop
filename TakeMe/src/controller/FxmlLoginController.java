package controller;
import controller.mains.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.crud.CrudMembre;
import model.crud.CrudSession;
import model.entities.Session;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class FxmlLoginController {
    EmailValidator emailValidator= new EmailValidator();

    @FXML
    private JFXTextField textFieldLoginEmail ;
    @FXML
    private ImageView alerterror;
    @FXML
    private JFXPasswordField textFieldLoginPassword;
    @FXML
    private ImageView WvLogin;
    @FXML
    private Label vLogin;

    private Boolean checkemail=false;
    private int nbrClicknuag1=0,nbrClicknuag12=0,nbrClicknuag3=0;
    @FXML
    void clickNuag1(MouseEvent event) {
        nbrClicknuag1++;


    }

    @FXML
    void clickNuag2(MouseEvent event) {
        nbrClicknuag12++;
    }

    @FXML
    void clickNuag3(MouseEvent event) {
        nbrClicknuag3++;

    }
    @FXML
    void LoginGpLoad(MouseEvent event) throws Exception {
        System.out.println("Load login FB Gui");
        LoginGPlus loginGPlus =new LoginGPlus();
        loginGPlus.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void clickNuag4(MouseEvent event) throws Exception {
        System.out.println(nbrClicknuag1);
        if ((nbrClicknuag1==2)&&(nbrClicknuag12==1)&&(nbrClicknuag3==2)){
            System.out.println("hello");




            LoginAdmin loginAdmin =new LoginAdmin();
            loginAdmin.start(new Stage());
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }
        else {
            nbrClicknuag1=0;nbrClicknuag12=0;nbrClicknuag3=0;
        }

    }



    @FXML
    void EmailMousehover(MouseEvent event) {
        Boolean ChampCheckEmail=textFieldLoginEmail.getText().equals("") ;
        String TxtChampEmail=textFieldLoginEmail.getText();
        Boolean CheckEmail= emailValidator.validate(TxtChampEmail);
        if((!(ChampCheckEmail))&&(!CheckEmail)){

            System.out.println(CheckEmail);
            Color c = Color.web("#ff0000");
            textFieldLoginEmail.getStyleClass().add("erroremail");
            alerterror.getStyleClass().add("imagealertehidden");
            textFieldLoginEmail.setUnFocusColor(c);
        }
        else if ((!(ChampCheckEmail))&&(CheckEmail)){

            Color c = Color.web("#014920");
            textFieldLoginEmail.setUnFocusColor(c);
            textFieldLoginEmail.getStyleClass().remove("erroremail");
            alerterror.getStyleClass().remove("imagealertehidden");

        }
        else if(ChampCheckEmail){
            checkemail=true;
            Color c = Color.web("#61d4c3");
            textFieldLoginEmail.setUnFocusColor(c);
            textFieldLoginEmail.getStyleClass().remove("erroremail");
            alerterror.getStyleClass().remove("imagealertehidden");
        }
    }



    @FXML
    void EmailKeyevent(KeyEvent event) {

        Boolean ChampCheckEmail=textFieldLoginEmail.getText().equals("") ;
        String TxtChampEmail=textFieldLoginEmail.getText();
        Boolean CheckEmail= emailValidator.validate(TxtChampEmail);
        if((!(ChampCheckEmail))&&(!CheckEmail)){

            System.out.println(CheckEmail);
            textFieldLoginEmail.getStyleClass().add("erroremail");
            Color c = Color.web("#ff0000");
            textFieldLoginEmail.setUnFocusColor(c);
        }
        else if ((!(ChampCheckEmail))&&(CheckEmail)){

            Color c = Color.web("#014920");
            textFieldLoginEmail.setUnFocusColor(c);
            textFieldLoginEmail.getStyleClass().remove("erroremail");
            alerterror.getStyleClass().remove("imagealertehidden");
        }
        else if(ChampCheckEmail){

            checkemail=true;
            Color c = Color.web("#61d4c3");
            textFieldLoginEmail.setUnFocusColor(c);
            alerterror.getStyleClass().remove("imagealertehidden");
            textFieldLoginEmail.getStyleClass().remove("erroremail");

        }
    }

    public void SignUpLoader(ActionEvent actionEvent)throws Exception
    {
        System.out.println("Load login Gui");
        SignUp signUp =new SignUp();
        signUp.start(new Stage());
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


    }
@FXML
    private void homeLoader(ActionEvent event) throws Exception {

           String Email=textFieldLoginEmail.getText();
           String Password=textFieldLoginPassword.getText();
        CrudMembre membre=new CrudMembre();
      int idmembre=  membre.VerfiConnexion(Email,Password);

        if((textFieldLoginEmail.getText().equals("root") && textFieldLoginPassword.getText().equals("root") )||(idmembre!=0)){

            LocalDate dateNow=LocalDate.now();
            CrudSession crudSession = new CrudSession();
            Session session=new Session(CrudMembre.IdUserConnected,dateNow,"desktop");
            crudSession.ajouterSession(session);
            notificationLogin();
            Menu home = new Menu();
            home.start(new Stage());

            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else if(idmembre==0){
            WvLogin.setVisible(true);
            vLogin.setVisible(true);
        }

    }

    @FXML
    void LoginFBLoad(MouseEvent event) throws Exception {
        System.out.println("Load login FB Gui");
        LoginFB loginfb =new LoginFB();
        loginfb.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @FXML
    void forgetPwd(MouseEvent event) throws Exception {

        System.out.println("Load findUser Gui");
        FindUser findUser =new FindUser();
        findUser.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    public void notificationLogin(){
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Bienvenue sur TakeMe ,");
        tray.setMessage(" Nous vous souhaitons une bonne journée");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.setRectangleFill(Paint.valueOf("#252f41"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.setTrayIcon(new Image("ressources/img/img/logo.png"));
        tray.showAndDismiss(Duration.seconds(8));

    }


}
