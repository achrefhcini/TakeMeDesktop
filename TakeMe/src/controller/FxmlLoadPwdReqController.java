package controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.crud.CrudMembre;
import model.entities.Membre;
import utiles.MainSms;
import utiles.SendLinkEmail;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by SAW on 14/02/2017.
 */
public class FxmlLoadPwdReqController implements Initializable {

    @FXML
    private VBox hbox;

    @FXML
    private Circle circle;
    @FXML
    private StackPane stackpane;

    @FXML
    private JFXButton buttonSendEmail;

    @FXML
    private Label labelEmail;

    @FXML
    private JFXButton buttonSendSms;

    @FXML
    private Label labelSms;

    @FXML
    void sendEmailToUser(MouseEvent event) throws Exception {
        CrudMembre crudMembre=new CrudMembre();
        Membre m=CrudMembre.membreSelectPwdChange;
        int randomPIN = (int)(Math.random()*9000)+1000;
        m.setCodeVerifMail(randomPIN);
         crudMembre.modifierMembre(m);
        SendLinkEmail.Send(m.getEmail(),m.getNom(),randomPIN);
        System.out.println(m.getEmail());
        loadVerifCod();

    }

    @FXML
    void sendSmsToUser(MouseEvent event) throws Exception{
        CrudMembre crudMembre=new CrudMembre();
        Membre m=CrudMembre.membreSelectPwdChange;
        int randomPIN = (int)(Math.random()*9000)+1000;
        m.setCodeVerifMail(randomPIN);
        crudMembre.modifierMembre(m);
        MainSms.callURL(m.getNum_tel(),randomPIN);
        loadVerifCod();

    }


    public void initialize(URL location, ResourceBundle resources) {

        if(CrudMembre.membreSelectPwdChange!=null){
            Membre membre=CrudMembre.membreSelectPwdChange;

            if(membre.getEmail()!=null){
                String email=membre.getEmail();
                String nmbreEtoileEmail="*";
                int indicAt=email.indexOf("@");
                for (int i=0;i<email.length()-5-indicAt;i++){
                    nmbreEtoileEmail=nmbreEtoileEmail+"*";
                }
                String invisible=email.substring(0,2)+nmbreEtoileEmail+email.substring(email.length()-(indicAt+2));
                labelEmail.setText(invisible);


            }
            if(membre.getNum_tel()!=null){

                 String numTel=membre.getNum_tel();
                 String nmbreEtoileSms="*";

                for (int i=0;i<numTel.length()-8;i++){
                    nmbreEtoileSms=nmbreEtoileSms+"*";
                }
                String invisible=numTel.substring(0,6)+nmbreEtoileSms+numTel.substring(numTel.length()-1);
                labelSms.setText(invisible);
            }else
            {
                buttonSendSms.setVisible(false);
                labelSms.setVisible(false);

            }



            try {
                loadImage(membre);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }




    }

    public void loadImage(Membre membre) throws Exception {
        if (membre.getPhoto()!=null)
        {
            try {
                URL url = new URL(membre.getPhoto());
                BufferedImage img = ImageIO.read(url);
                String nameImage=membre.getNom()+"_"+membre.getPrenom()+"_"+membre.getId_membre()+".jpg";
                File file = new File(nameImage);
                ImageIO.write(img, "jpg", file);
                Image image = new Image(new FileInputStream(file));
                circle.setFill(new ImagePattern(image));
            } catch (FileNotFoundException e) {
                if (membre.getSexe().equals("m")){
                    circle.setFill(new ImagePattern(new Image("ressources/img/profil/homme.png")));

                }
                else if (membre.getSexe().equals("f")){
                    circle.setFill(new ImagePattern(new Image("ressources/img/profil/femme.png")));
                }
            }

        }
        else {
            if (membre.getSexe().equals("m")){
                circle.setFill(new ImagePattern(new Image("ressources/img/profil/homme.png")));

            }
            else if (membre.getSexe().equals("f")){
                circle.setFill(new ImagePattern(new Image("ressources/img/profil/femme.png")));
            }
        }
    }

    void loadVerifCod() throws IOException {
        Pane s= (Pane) FXMLLoader.load(getClass().getResource("/view/FxmlVerifCodeReins.fxml"));
        stackpane.getChildren().add(s);
    }
}
