package controller;

import controller.mains.Login;
import controller.mains.LoginFB;
import controller.mains.Menu;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.crud.CrudMembre;
import model.entities.Membre;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.sql.SQLException;

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
        this.m1.setSexe(gender);
        this.m1.setEmail(email);
        this.m1.setPhoto(user_url_picture);
        this.m1.setVerifMail(true);
        this.m1.setActif(true);

    }



    public void AuthentifUserFB() throws Exception {

        crudMembre=new CrudMembre();
        if(crudMembre.VerfiConnecionFB(this.m1.getEmail())!=0){
            Menu home = new Menu();
            home.start(new Stage());
            System.out.println("old");
            System.out.println(Membre.IdUserConnected);
            System.out.println(m1.toString());
            Stage stage = (Stage) this.LoginViewFB.getScene().getWindow();

            stage.close();
        }
        else   if(crudMembre.VerfiConnecionFB(this.m1.getEmail())==0){
            crudMembre.ajouterMembre(this.m1);
            crudMembre.VerfiConnecionFB(m1.getEmail());
            System.out.println(Membre.IdUserConnected);
            Menu home = new Menu();
            home.start(new Stage());
            System.out.println("new");
            System.out.println(m1.toString());

            Stage stage = (Stage) this.LoginViewFB.getScene().getWindow();

            stage.close();

        }
    }
}
