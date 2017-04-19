package controller;

import com.jfoenix.controls.JFXTextField;
import controller.mains.Login;
import controller.mains.LoginFB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.crud.CrudMembre;
import model.entities.Membre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by SAW on 14/02/2017.
 */
public class FxmlFindUserController {

    @FXML
    private BorderPane retrouverUser;

    @FXML
    private JFXTextField filedSearch;

    @FXML
    private Label erreurSearch;

    @FXML
    void BackLoginView(MouseEvent event) throws Exception {
        System.out.println("Load login Gui");
        Login login =new Login();
        login.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void findUser(MouseEvent event) throws Exception {
        if(filedSearch.getText().length()>3){
            CrudMembre crudMembre=new CrudMembre();
            ArrayList<Membre> list=crudMembre.findUserByChamp(filedSearch.getText());
            if(list.size()==0){
                erreurSearch.setVisible(true);
            }
            else if(list.size()!=0) {
                erreurSearch.setVisible(false);
                crudMembre.membresFoundedPwdChange=list;
                LoadProfilView();

            }
            for (Membre m:list
                    ) {
                System.out.println(m.toString());

            }

        }
        else {
            erreurSearch.setVisible(true);
        }


    }
    public void LoadProfilView() throws IOException {

        StackPane s= (StackPane) FXMLLoader.load(getClass().getResource("/view/FxmlSelectUser.fxml"));
        retrouverUser.setTop(null);
        retrouverUser.setLeft(null);
        retrouverUser.setRight(null);
        retrouverUser.setCenter(s);
    }

}
