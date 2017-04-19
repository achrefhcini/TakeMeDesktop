package controller;

import com.jfoenix.controls.JFXTextField;
import controller.mains.Menu;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.crud.CrudMembre;
import model.entities.Membre;

import java.sql.SQLException;

/**
 * Created by SAW on 18/02/2017.
 */
public class FxmlChangePwdController {

    @FXML
    private JFXTextField newPassword;

    @FXML
    private ImageView WvPwd;

    @FXML
    private Label vPwd;

    @FXML
    void saveNewPwd(MouseEvent event) throws Exception {
        String newPwd=newPassword.getText();
        if(newPwd!=""){
            CrudMembre crudMembre=new CrudMembre();
            Membre membre=CrudMembre.membreSelectPwdChange;
            membre.setPassword(newPwd);
            crudMembre.modifierMembre(membre);
            Menu home = new Menu();
            home.start(new Stage());

            ((Node)(event.getSource())).getScene().getWindow().hide();

        }
        else {
            vPwd.setVisible(true);
            WvPwd.setVisible(true);
        }

    }

}
