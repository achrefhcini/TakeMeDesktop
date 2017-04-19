package controller;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.crud.CrudMembre;
import model.crud.CrudReclamation;
import model.entities.Membre;
import model.entities.Reclamation;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


/**
 * Created by SAW on 12/02/2017.
 */
public class FxmlUserViewController {
    static ArrayList<Membre> listSearch=null;
    static Boolean choixDESC=false;
    static String conditionReqAffichage=null;
    @FXML
    private ImageView iconParNom,iconParPrenom,iconParAge,iconParSexe,iconParEtat,iconTous;
    @FXML
    private Label afficherTous,afficherParNom,afficherParPrenom,afficherParAge,afficherParSexe,afficherParEtat;
    public Rectangle barreleft;
    public Rectangle barreright;
    public VBox vbox;
    public HBox hbox1,hbox2;
    public StackPane userView1,userView2,userView3,userView4,userView5,userView6,userView7,userView8;
    public Circle circle1,circle2,circle3,circle4,circle5,circle6,circle7,circle8;
    public Label name1,name2,name3,name4,name5,name6,name7,name8;
    public ImageView actionBloq1,actionBloq2,actionBloq3,actionBloq4,actionBloq5,actionBloq6,actionBloq7,actionBloq8;
    public ImageView actionReclamation1,actionReclamation2,actionReclamation3,actionReclamation4,actionReclamation5,actionReclamation6,actionReclamation7,actionReclamation8;
    @FXML
    private BorderPane borderpane;

    @FXML
    private JFXTextField champSearch;

    @FXML
    private JFXTextField id_from;
    @FXML
    private ImageView imgLeft;

    @FXML
    private ImageView imgright;

    @FXML
    private Label labelNbrUtilisateur;

    @FXML
    void chercherParEmail(MouseEvent event) throws Exception {
    String champToSearch=champSearch.getText();
    CrudMembre crudMembre=new CrudMembre();
        ArrayList<Membre> resultaSearch=crudMembre.findUserByChampListview(champToSearch);
        if(resultaSearch!=null){
            listSearch=resultaSearch;
            initialize();
            listSearch=null;
        }




    }

    @FXML
    void affichierApartir(MouseEvent event) throws IOException, SQLException {
        String idFrom=id_from.getText();
        try {


        int idFromInt=Integer.valueOf(idFrom);

        CrudMembre crudMembre=new CrudMembre();
        int nbrUtilisateur=crudMembre.countMembre();
        if (idFromInt>nbrUtilisateur){
            labelNbrUtilisateur.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
        }
        else {
            CrudMembre.idFromSelect=idFromInt;
            labelNbrUtilisateur.setStyle("-fx-text-fill: white; -fx-font-size: 14;");
            initialize();

        }
        }catch (Exception e){
            System.out.println("not integer");
        }

    }

    @FXML
    void rightEntered(MouseEvent event) {
        Insets value=new Insets(5,60,5,10);
        hbox1.setPadding(value);
        hbox2.setPadding(value);
    }



    @FXML
    void rightExited(MouseEvent event) {
        Insets value1=new Insets(0,0,0,0);
        Insets value2=new Insets(0,0,0,0);
        hbox1.setPadding(value1);
        hbox2.setPadding(value2);
    }


    @FXML
    void leftEntered(MouseEvent event) {
        Insets value=new Insets(5,10,5,60);
        hbox1.setPadding(value);
        hbox2.setPadding(value);
    }



    @FXML
    void leftExited(MouseEvent event) {
        Insets value=new Insets(0,0,0,0);
        hbox1.setPadding(value);
        hbox2.setPadding(value);
    }

    @FXML
    void pagginationAfter(MouseEvent event) throws IOException, SQLException {
        CrudMembre crudMembre=new CrudMembre();
        int nmbrMembre=crudMembre.countMembre();
        if(CrudMembre.idFromSelect+8>nmbrMembre){
            barreright.setVisible(false);
            imgright.setVisible(false);


        }
        else {
            barreright.setVisible(true);
            imgright.setVisible(true);
            CrudMembre.idFromSelect=CrudMembre.idFromSelect+8;
        }
        barreleft.setVisible(true);
        imgLeft.setVisible(true);
        System.out.println(CrudMembre.idFromSelect);
        System.out.println(nmbrMembre);
        initialize();


    }

    @FXML
    void pagginationBack(MouseEvent event) throws IOException, SQLException {
        if (CrudMembre.idFromSelect>8){
            barreleft.setVisible(true);
            imgLeft.setVisible(true);

            CrudMembre.idFromSelect=CrudMembre.idFromSelect-8;
            System.out.println(CrudMembre.idFromSelect);
            initialize();
        }
        else {
            barreleft.setVisible(false);
            imgLeft.setVisible(false);

        }
        barreright.setVisible(true);
        imgright.setVisible(true);

    }
    int profilId;
    public void initialize() throws SQLException, IOException {
        ArrayList<Circle> circles=new ArrayList<>();
        ArrayList<Label> Labels=new ArrayList<>();
        ArrayList<ImageView> buttonRecalamtions=new ArrayList<>();
        ArrayList<ImageView> buttonBloqDeb =new ArrayList<>();
        //array list iicon ASC DEsc
        ArrayList<ImageView> iconAscDesc=new ArrayList<>();
        iconAscDesc.add(iconParAge);iconAscDesc.add(iconParNom);iconAscDesc.add(iconParPrenom);iconAscDesc.add(iconParSexe);iconAscDesc.add(iconParEtat);iconAscDesc.add(iconTous);
        // circle pour mettre les images
        circles.add(circle1);circles.add(circle2);circles.add(circle3);circles.add(circle4);circles.add(circle5);circles.add(circle6);circles.add(circle7);circles.add(circle8);
        // Button reclamation
        buttonRecalamtions.add(actionReclamation1);buttonRecalamtions.add(actionReclamation2);buttonRecalamtions.add(actionReclamation3);buttonRecalamtions.add(actionReclamation4);
        buttonRecalamtions.add(actionReclamation5);buttonRecalamtions.add(actionReclamation6);buttonRecalamtions.add(actionReclamation7);buttonRecalamtions.add(actionReclamation8);
       // label Nom
        Labels.add(name1);Labels.add(name2);Labels.add(name3);Labels.add(name4);Labels.add(name5);Labels.add(name6);Labels.add(name7);Labels.add(name8);
        // Button bloquer et debloquer ;
        buttonBloqDeb.add(actionBloq1);buttonBloqDeb.add(actionBloq2);buttonBloqDeb.add(actionBloq3);buttonBloqDeb.add(actionBloq4);
        buttonBloqDeb.add(actionBloq5);buttonBloqDeb.add(actionBloq6);buttonBloqDeb.add(actionBloq7);buttonBloqDeb.add(actionBloq8);

        // intialise list view vide content
   for (int i=0;i<circles.size();i++){
       circles.get(i).setFill(new ImagePattern(new Image("ressources/img/img/inconnu.png")));
       Labels.get(i).setText("");
       buttonRecalamtions.get(i).setVisible(false);
       buttonBloqDeb.get(i).setVisible(false);
       circles.get(i).setOnMouseClicked(null);
   }

        CrudMembre crudMembre=new CrudMembre();
        labelNbrUtilisateur.setText(crudMembre.countMembre()+" utilisateurs");

        int selectIdFrom=CrudMembre.idFromSelect;

// fonctionalités du par rechercher par
           // affichier tous
        afficherTous.setOnMouseClicked(event->
        {
          for (int i=0;i<iconAscDesc.size();i++){
              int FinalI=i;
              if (iconAscDesc.get(FinalI)==iconTous){
                  iconTous.setVisible(true);
              }
              else iconAscDesc.get(FinalI).setVisible(false);
          }

            CrudMembre.idFromSelect=1;
            if(choixDESC==false){
                conditionReqAffichage="ORDER BY id_membre ASC";
                iconTous.setImage(new Image("ressources/img/img/ASC.png"));

            }
           else if(choixDESC==true) {
                conditionReqAffichage="ORDER BY id_membre DESC";
                iconTous.setImage(new Image("ressources/img/img/DESC.png"));

            }
            try {
                initialize();
                choixDESC=!choixDESC;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //afficher par age
        afficherParAge.setOnMouseClicked(event -> {

            for (int i=0;i<iconAscDesc.size();i++){
                int FinalI=i;
                if (iconAscDesc.get(FinalI)==iconParAge){
                    iconParAge.setVisible(true);
                }
                else iconAscDesc.get(FinalI).setVisible(false);
            }

            if(choixDESC==false){
                conditionReqAffichage="ORDER BY age ASC";
                iconParAge.setImage(new Image("ressources/img/img/ASC.png"));

            }
            else if(choixDESC==true) {
                conditionReqAffichage = "ORDER BY age DESC";
                iconParAge.setImage(new Image("ressources/img/img/DESC.png"));
            }

            try {
                initialize();
                choixDESC=!choixDESC;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        //aficher par nom
        afficherParNom.setOnMouseClicked(event ->
        {

            for (int i=0;i<iconAscDesc.size();i++){
                int FinalI=i;
                if (iconAscDesc.get(FinalI)==iconParNom){
                    iconParNom.setVisible(true);
                }
                else iconAscDesc.get(FinalI).setVisible(false);
            }

            if(choixDESC==false){
                conditionReqAffichage="ORDER BY nom ASC";
                iconParNom.setImage(new Image("ressources/img/img/ASC.png"));

            }
            else if(choixDESC==true) {
                conditionReqAffichage = "ORDER BY nom DESC";
                iconParNom.setImage(new Image("ressources/img/img/DESC.png"));
            }

            try {
                initialize();
                choixDESC=!choixDESC;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //recherche par prenom
        afficherParPrenom.setOnMouseClicked(event ->
        {
            for (int i=0;i<iconAscDesc.size();i++){
                int FinalI=i;
                if (iconAscDesc.get(FinalI)==iconParPrenom){
                    iconParPrenom.setVisible(true);
                }
                else iconAscDesc.get(FinalI).setVisible(false);
            }

            if(choixDESC==false){
                conditionReqAffichage="ORDER BY prenom ASC";
                iconParPrenom.setImage(new Image("ressources/img/img/ASC.png"));

            }
            else if(choixDESC==true) {
                conditionReqAffichage = "ORDER BY prenom DESC";
                iconParPrenom.setImage(new Image("ressources/img/img/DESC.png"));
            }

            try {
                initialize();
                choixDESC=!choixDESC;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //recherche par sexe
        afficherParSexe.setOnMouseClicked(event ->
        {
            for (int i=0;i<iconAscDesc.size();i++){
                int FinalI=i;
                if (iconAscDesc.get(FinalI)==iconParSexe){
                    iconParSexe.setVisible(true);
                }
                else iconAscDesc.get(FinalI).setVisible(false);
            }

            if(choixDESC==false){
                conditionReqAffichage="ORDER BY sexe ASC";
                iconParSexe.setImage(new Image("ressources/img/img/ASC.png"));

            }
            else if(choixDESC==true) {
                conditionReqAffichage = "ORDER BY sexe DESC";
                iconParSexe.setImage(new Image("ressources/img/img/DESC.png"));
            }

            try {
                initialize();
                choixDESC=!choixDESC;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        // aficher par etat
        afficherParEtat.setOnMouseClicked(event ->
        {

            for (int i=0;i<iconAscDesc.size();i++){
                int FinalI=i;
                if (iconAscDesc.get(FinalI)==iconParEtat){
                    iconParEtat.setVisible(true);
                }
                else iconAscDesc.get(FinalI).setVisible(false);
            }

            if(choixDESC==false){
                conditionReqAffichage="ORDER BY isActif ASC";
                iconParEtat.setImage(new Image("ressources/img/img/ASC.png"));

            }
            else if(choixDESC==true) {
                conditionReqAffichage = "ORDER BY isActif DESC";
                iconParEtat.setImage(new Image("ressources/img/img/DESC.png"));
            }

            try {
                initialize();
                choixDESC=!choixDESC;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ArrayList<Membre> list;
            if (listSearch==null){
                list=crudMembre.afficherMembresByrange(selectIdFrom,selectIdFrom+8,conditionReqAffichage);

            }
            else {
                 list=listSearch;
            }
        if(!(list.isEmpty())){
          for (int i=0;i<list.size();i++){
              buttonRecalamtions.get(i).setVisible(true);
              buttonBloqDeb.get(i).setVisible(true);
              Labels.get(i).setText(list.get(i).getNom()+" "+list.get(i).getPrenom());
              int FinalI = i;


              //afficher les barre du reclamation selon nbr reclamation
              CrudReclamation crudReclamation = new CrudReclamation();
              ArrayList<Reclamation> reclamationParMembre=crudReclamation.afficherReclamationByIdmembre(list.get(FinalI).getId_membre());
              remplirReclamationCharge(reclamationParMembre,buttonRecalamtions,FinalI);



              // notifier etat reclamation pour un membre en cliquant sur :
              buttonRecalamtions.get(FinalI).setOnMouseClicked(event ->
                      {
                          recalamtionNotif(reclamationParMembre,list,FinalI);
                      }
              );


              // verifier si utilsateur est bloquer ou nn et remplir le button par bloquer ou debloquer

              if((list.get(i).isActif()==false)&&(list.get(i).isVerifMail()==true)){
                  buttonBloqDeb.get(i).setImage(new Image("ressources/img/deblock.png"));
                  //action debloquer si un membre est bloquer
                  buttonBloqDeb.get(i).setOnMouseClicked(event->{
                      System.out.println("debloquer");
                      list.get(FinalI).setActif(true);
                      if(crudMembre.debloquerMembre(list.get(FinalI))){
                          buttonBloqDeb.get(FinalI).setImage(new Image("ressources/img/block.png"));
                          debloquerNotif(list,FinalI);
                          try {
                              initialize();
                          } catch (SQLException e) {
                              e.printStackTrace();
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }
                  });
              }
              // action bloquer si un membre est actif
          if((list.get(i).isActif()==true)&&(list.get(i).isVerifMail()==true)){

                  buttonBloqDeb.get(i).setImage(new Image("ressources/img/block.png"));
                  buttonBloqDeb.get(i).setOnMouseClicked(event->{
                      System.out.println("bloquer");
                      list.get(FinalI).setActif(false);
                      if(crudMembre.bloquerMembre(list.get(FinalI))){
                          buttonBloqDeb.get(FinalI).setImage(new Image("ressources/img/deblock.png"));
                          bloquerNotif(list,FinalI);
                          try {
                              initialize();
                          } catch (SQLException e) {
                              e.printStackTrace();
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }

                  });
              }

              //button sur image pour charger le profil d un membre
              circles.get(i).setOnMouseClicked(event ->
                      {
                     CrudMembre.membreViewProfil=list.get(FinalI);
                          try {
                              LoadProfilView();
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }
              );

              remplirImagepar(list,circles,i);
          }
        }

    }


    //  ====================> methode pour charger view profil page
    public void LoadProfilView() throws IOException {

        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlProfilView.fxml"));
        borderpane.setTop(null);
        borderpane.setLeft(null);
        borderpane.setRight(null);
        borderpane.setCenter(s);
    }


    //  ====================> methode notification deblocage membre
    public void debloquerNotif(ArrayList<Membre> list,int FinalI){
        TrayNotification tray = new TrayNotification();
        tray.setTitle(list.get(FinalI).getNom()+" "+list.get(FinalI).getPrenom()+" a été debloqué");
        tray.setMessage(" Vous venez de debloquer un membre sur TakeMe");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.setRectangleFill(Paint.valueOf("#252f41"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.setTrayIcon(new Image("ressources/img/img/logo.png"));
        tray.showAndDismiss(Duration.seconds(8));
    }


    //  ====================> methode notification blocage membre
    public void bloquerNotif(ArrayList<Membre> list, int FinalI){
        TrayNotification tray = new TrayNotification();
        tray.setTitle(list.get(FinalI).getNom()+" "+list.get(FinalI).getPrenom()+" a été bloqué");
        tray.setMessage(" Vous venez de bloquer un membre sur TakeMe");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.setRectangleFill(Paint.valueOf("#252f41"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.setTrayIcon(new Image("ressources/img/img/logo.png"));
        tray.showAndDismiss(Duration.seconds(8));
    }



    //  ====================> methode remplir icon reclamation selon nombre reclamation
    public void remplirReclamationCharge(ArrayList<Reclamation> reclamationParMembre,ArrayList<ImageView> buttonRecalamtions,int FinalI){
    if(reclamationParMembre!=null){
        int nbrRec=reclamationParMembre.size();
        if (nbrRec==1){
            buttonRecalamtions.get(FinalI).setImage(new Image("ressources/img/img/good.png"));
        }
        else if(nbrRec==2){
            buttonRecalamtions.get(FinalI).setImage(new Image("ressources/img/img/medium.png"));

        }
        else if(nbrRec==3){
            buttonRecalamtions.get(FinalI).setImage(new Image("ressources/img/img/bad.png"));

        }
        else if(nbrRec>=4){
            buttonRecalamtions.get(FinalI).setImage(new Image("ressources/img/img/verybad.png"));

        }
        else {
            buttonRecalamtions.get(FinalI).setImage(new Image("ressources/img/img/verygood.png"));

        }

    }
    else {
        buttonRecalamtions.get(FinalI).setImage(new Image("ressources/img/img/verygood.png"));

    }
}


 public void recalamtionNotif(ArrayList<Reclamation> reclamationParMembre,ArrayList<Membre> list,int FinalI){
     int nbrRec=0;
     if((reclamationParMembre!=null)) {
          nbrRec = reclamationParMembre.size();

         TrayNotification tray = new TrayNotification();
         tray.setTitle(list.get(FinalI).getNom() + " " + list.get(FinalI).getPrenom() + " a " +nbrRec+" Reclamation(s)");
         tray.setMessage("La dernière a eu le "+reclamationParMembre.get(nbrRec-1).getOffre().getDate_offre()+
         " à cause du "+reclamationParMembre.get(nbrRec-1).getType());
          if(nbrRec<3){
              tray.setNotificationType(NotificationType.INFORMATION);

          }
          if(nbrRec<4&&nbrRec>2){
              tray.setNotificationType(NotificationType.WARNING);

          }
          if(nbrRec>3){
              tray.setNotificationType(NotificationType.ERROR);

          }
         tray.setRectangleFill(Paint.valueOf("#252f41"));
         tray.setAnimationType(AnimationType.POPUP);
         tray.setTrayIcon(new Image("ressources/img/img/logo.png"));
         tray.showAndDismiss(Duration.seconds(8));
     }
     else {
         TrayNotification tray = new TrayNotification(list.get(FinalI).getNom() + " " + list.get(FinalI).getPrenom() + " a aucune Reclamation",
                 "Aucune Reclamation récue pour ce Membre",
                 NotificationType.SUCCESS);
         tray.setRectangleFill(Paint.valueOf("#252f41"));
         tray.setAnimationType(AnimationType.POPUP);
         tray.setTrayIcon(new Image("ressources/img/img/logo.png"));
         tray.showAndDismiss(Duration.seconds(8));
     }
    }






  //  ====================> methode remplir image d un membre
    public void remplirImagepar(ArrayList<Membre> list,ArrayList<Circle> circles,int i){
        String sexe=list.get(i).getSexe();
        if (sexe!=null){
            if(sexe.equals("m"))
            {
                if (list.get(i).getPhoto()==null)
                {
                    circles.get(i).setFill(new ImagePattern(new Image("ressources/img/profil/homme.png")));
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
                        circles.get(i).setFill(new ImagePattern(image));
                    } catch (FileNotFoundException e) {
                        System.out.println(e.toString());
                        circles.get(i).setFill(new ImagePattern(new Image("ressources/img/profil/homme.png")));
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

                    circles.get(i).setFill(new ImagePattern(new Image("ressources/img/profil/femme.png")));
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
                        circles.get(i).setFill(new ImagePattern(image));
                    } catch (FileNotFoundException e) {
                        System.out.println(e.toString());
                        circles.get(i).setFill(new ImagePattern(new Image("ressources/img/profil/femme.png")));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        else if(sexe==null){
            System.out.println("annimaux ?");
        }

    }




    }
