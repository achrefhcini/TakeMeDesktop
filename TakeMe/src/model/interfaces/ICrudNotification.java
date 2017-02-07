package model.interfaces;

//import entites.Demande;
import model.entities.Notification;

import java.util.ArrayList;


public interface ICrudNotification {
    public boolean ajouterNotification(Notification n);
    public boolean supprimerNotification(Notification n);
    public boolean modifierNotification(Notification n);
    public Notification afficherNotificationById(int id);
    public ArrayList<Notification> afficherNotifications();
}
