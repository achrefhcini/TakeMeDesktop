package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.crud.CrudMembre;
import model.entities.Membre;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

/**
 * Created by SAW on 13/02/2017.
 */

public class FxmlProfilViewController  {

    @FXML
    private Circle circle;

    @FXML
    private Label age;

    @FXML
    private Label sexe;

    @FXML
    private Label email;

    @FXML
    private Label telephone;

    @FXML
    private Label nom;

    @FXML
    private Label prenom;


    public void initialize() throws SQLException, IOException {
        Membre membre= CrudMembre.membreViewProfil;
        nom.setText(membre.getNom());
        prenom.setText(membre.getPrenom());
        if(membre.getSexe()!=null){
            if(membre.getSexe().equals("m")){
                sexe.setText("homme");
            }
            else {
                sexe.setText("Femme");

            }
        }
        else {
            sexe.setText("Incomplete");
        }


        if(membre.getAge()!=null){

                age.setText(String.valueOf(membre.getAge()));

        }
        else {
            age.setText("Incomplete");
        }


        if(membre.getEmail()!=null){

            email.setText(String.valueOf(membre.getEmail()));

        }
        else {
            email.setText("Incomplete");
        }
        if(membre.getNum_tel()!=null){

            telephone.setText(String.valueOf(membre.getNum_tel()));

        }
        else {
            telephone.setText("Incomplete");
        }


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
}
