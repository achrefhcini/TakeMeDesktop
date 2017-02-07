package model.mains;

import model.crud.CrudNotification;
import model.entities.Notification;

import java.sql.SQLException;


public class TestCrudNotification {
    public static void main(String[]args) throws SQLException, ClassNotFoundException {
    CrudNotification crudNotification = new CrudNotification();
        Notification n = new Notification(1,"gg",5);
     //   crudNotification.supprimerNotification(n);



        

}
}