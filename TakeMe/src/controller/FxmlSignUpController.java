package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.crud.CrudMembre;
import model.entities.Membre;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class FxmlSignUpController {
    //initialition des elements
    public JFXRadioButton rsw;
    public JFXRadioButton rsm;
    public JFXPasswordField repwd;
    public JFXPasswordField pwd;
    public JFXTextField mail;
    public JFXTextField lastName;
    public JFXTextField name;

    //les labels des warning
    public Label vName;
    public Label vLast;
    public Label vMail;
    public Label vPwd;
    public Label vRepwd;
    //les icons des warning
    public ImageView WvName;
    public ImageView WvLast;
    public ImageView WvMail;
    public ImageView WvPwd;
    public ImageView WvRepwd;

    //
    public void BtnInscri(ActionEvent actionEvent) throws Exception {
        if(name.getText().isEmpty())
            {
                vName.setVisible(true);
                WvName.setVisible(true);
            }
        else
            {
                vName.setVisible(false);
                WvName.setVisible(false);
            }

    //Validate that this address conforms to the syntax rules of RFC 822.
        try
            {
            InternetAddress address =new InternetAddress(mail.getText());
            address.validate();
            vMail.setVisible(false);
            WvMail.setVisible(false);
            }
        catch (AddressException e)
            {
            vMail.setVisible(true);
            WvMail.setVisible(true);
        }

        Membre m =new Membre(name.getText(),lastName.getText(),mail.getText(),"dd",pwd.getText());
        System.out.println(m.toString());
        CrudMembre crudMembre = new CrudMembre();
        crudMembre.ajouterMembre(m);


    }

    public void radioM(ActionEvent actionEvent)
    {
        rsw.setSelected(false);
    }

    public void radioW(ActionEvent actionEvent)
    {
        rsm.setSelected(false);
    }

}
