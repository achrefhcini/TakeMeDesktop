package controller;

import com.jfoenix.controls.JFXTextField;
import controller.mains.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.crud.CrudMembre;
import model.crud.CrudSession;
import model.entities.Membre;
import model.entities.Session;

import java.time.LocalDate;

/**
 * Created by Green on 12/02/2017.
 */
public class FxmlVerifCodeReinsController {
    public JFXTextField codeActivation;
    public Label vMail;
    public ImageView WvMail;
    @FXML
    private StackPane stackpane;

    public void BtnVerifMail(ActionEvent actionEvent) throws Exception {
        CrudMembre crudMembre = new CrudMembre();
        Membre m=crudMembre.afficherMembreById(CrudMembre.membreSelectPwdChange.getId_membre());
        if(Integer.parseInt(codeActivation.getText()) == m.getCodeVerifMail())
        {
            LocalDate dateNow=LocalDate.now();
            CrudSession crudSession = new CrudSession();
            Session session=new Session(m.getId_membre(),dateNow,"desktop");
            crudSession.ajouterSession(session);
            StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlChangePwd.fxml"));
            stackpane.getChildren().clear();
            stackpane.getChildren().add(s);

        }
        else
        {
            vMail.setVisible(true);
            WvMail.setVisible(true);
        }

    }
}
