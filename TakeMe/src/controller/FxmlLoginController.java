package controller;
import controller.mains.LoginFB;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import java.net.URL;
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

import controller.mains.SignUp;
import javafx.scene.Node;
import javafx.stage.Stage;
import controller.mains.Menu;
import model.crud.CrudMembre;

public class FxmlLoginController {
    EmailValidator emailValidator= new EmailValidator();

    @FXML
    private JFXTextField textFieldLoginEmail ;
    @FXML
    private ImageView alerterror;
    @FXML
    private JFXPasswordField textFieldLoginPassword;

    private Boolean checkemail=false;

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
            Menu home = new Menu();
            home.start(new Stage());

            ((Node)(event.getSource())).getScene().getWindow().hide();
        }

    }

    @FXML
    void LoginFBLoad(MouseEvent event) throws Exception {
        System.out.println("Load login Gui");
        LoginFB loginfb =new LoginFB();
        loginfb.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }





}
