package model.interfaces;

import model.entities.Membre;
import model.entities.Message;

import java.util.ArrayList;

/**
 * Created by Green on 07/02/2017.
 */
public interface ICrudMessage {
    public boolean ajouterMessage(Message m);
    public boolean supprimerMessage(Message m);
    public boolean modifierMessage(Message m);
    public ArrayList<Message> afficherMessages();
    public Message afficherMessageById(int id);

}
