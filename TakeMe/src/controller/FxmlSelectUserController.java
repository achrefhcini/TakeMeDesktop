package controller;

import com.sun.javafx.cursor.CursorFrame;
import controller.mains.FindUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import model.crud.CrudMembre;
import model.entities.Membre;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.awt.Cursor.HAND_CURSOR;

/**
 * Created by SAW on 14/02/2017.
 */

public class FxmlSelectUserController implements Initializable {
    @FXML
    private StackPane stackpane;
    @FXML
    private HBox selectedUser;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(CrudMembre.membresFoundedPwdChange.size()!=0){
            ArrayList<Membre> list=CrudMembre.membresFoundedPwdChange;
            for (int i=0;i<list.size();i++){
                int FinalI = i;
                Circle circle=new Circle();
                 circle.setRadius(100);

                 circle.setCursor(Cursor.HAND);

                String sexe=list.get(i).getSexe();
                if (sexe!=null){


                    if(sexe.equals("m"))
                    {


                        if (list.get(i).getPhoto()==null)
                        {

                            circle.setFill(new ImagePattern(new Image("ressources/img/profil/homme.png")));
                        }
                        else   if (list.get(i).getPhoto()!=null)
                        {
                            try {
                                URL url = new URL(list.get(i).getPhoto());
                                BufferedImage img = ImageIO.read(url);
                                String nameImage=list.get(i).getNom()+"_"+list.get(i).getPrenom()+"_"+list.get(i).getId_membre()+".jpg";
                                File file = new File(nameImage);
                                ImageIO.write(img, "jpg", file);
                                Image image = new Image(new FileInputStream(file));
                                circle.setFill(new ImagePattern(image));
                            } catch (FileNotFoundException e) {

                                circle.setFill(new ImagePattern(new Image("ressources/img/profil/homme.png")));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                    else  if(sexe.equals("f"))
                    {
                        System.out.println(sexe);

                        if (list.get(i).getPhoto()==null)
                        {

                            circle.setFill(new ImagePattern(new Image("ressources/img/profil/femme.png")));
                        }
                        else   if (list.get(i).getPhoto()!=null)
                        {
                            System.out.println(list.get(i).getPhoto());
                            try {
                                URL url = new URL(list.get(i).getPhoto());
                                BufferedImage img = ImageIO.read(url);
                                String nameImage=list.get(i).getNom()+"_"+list.get(i).getPrenom()+"_"+list.get(i).getId_membre()+".jpg";
                                File file = new File(nameImage);
                                ImageIO.write(img, "jpg", file);
                                Image image = new Image(new FileInputStream(file));
                                circle.setFill(new ImagePattern(image));
                            } catch (FileNotFoundException e) {
                                circle.setFill(new ImagePattern(new Image("ressources/img/profil/femme.png")));
                            }  catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }


                circle.setOnMouseClicked(event ->
                        {
                          CrudMembre.membreSelectPwdChange=list.get(FinalI);
                            try {
                                LoadPwdReset();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );


                selectedUser.getChildren().add(circle);
                selectedUser.setSpacing(30);



            }







        }


        Text t = TextBuilder.create().text("Ce n’est pas vous ?").build();

        t.setFont(Font.font ("Arial", 15));
        t.setFill(Color.WHITE);
        t.setCursor(Cursor.HAND);
        t.setOnMouseClicked(event->{
            System.out.println("Load findUser Gui");
            FindUser findUser =new FindUser();
            try {
                findUser.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((Node)(event.getSource())).getScene().getWindow().hide();

        });
        selectedUser.getChildren().add(t);

    }

    public void LoadPwdReset() throws IOException {

        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlLoadPwdReq.fxml"));
       stackpane.getChildren().add(s);
    }

}
