package model.mains;

import model.crud.CrudMembre;
import model.crud.CrudMessage;
import model.entities.Membre;
import model.entities.Message;

import java.sql.SQLException;

/**
 * Created by Green on 07/02/2017.
 */
public class TestCrudMessage {
    public static void main (String [] args) throws SQLException {
        CrudMembre cm =new CrudMembre();
        //cm.afficherMembres().forEach(e->System.out.println(e));
        CrudMessage CMess=new CrudMessage();
        Membre membre1=cm.afficherMembreById(9);
        Membre membre2=cm.afficherMembreById(10);
        Message message=new Message();
        message.setMembreSource(membre1);
        message.setMembreDestinataire(membre2);
        message.setSujet("hello :D");
        //CMess.ajouterMessage(message);
        CMess.afficherMessages().forEach(msg -> System.out.println(msg));
        message.setSujet("hello2 :D");
        message.setId_message(1);
        CMess.modifierMessage(message);
        CMess.afficherMessages().forEach(msg -> System.out.println(msg));

    }
}
