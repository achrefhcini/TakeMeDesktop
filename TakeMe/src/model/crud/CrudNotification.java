package model.crud;

import database.DBConnect;
import model.entities.Notification;
import model.interfaces.ICrudNotification;

import java.sql.*;
import java.util.ArrayList;


public class CrudNotification implements ICrudNotification {

    public static Notification afficherNotifications(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection c ;
    Statement ste ;
    PreparedStatement prepste;

    public CrudNotification() throws SQLException, ClassNotFoundException {
        c=DBConnect.getConnection();
    }


    @Override
    public boolean ajouterNotification(Notification n) {
        String req="insert into notification (etat) values"
                + "('"+n.getEtat()+"') where id_demande = "+n.getId_demande();



        try {
            System.out.println(n);
            ste=c.createStatement();
            ste.executeUpdate(req);
            return true;
        } catch (SQLException e) {
            System.out.println("erreur");
            return false;
        }
    }

    @Override
    public boolean supprimerNotification(Notification n) {

        if(n!=null){
            String req= "delete from notification where id_notification="+n.getId_notification();
        try {
            ste=c.createStatement();
           int r=ste.executeUpdate(req);
            System.out.println(r);
            return true;
        } catch (SQLException n1) {
            n1.printStackTrace();
            return false;
        }
        }
        else
            return false;

    }

    @Override
    public boolean modifierNotification(Notification n)
    {
        String req="UPDATE Notification SET etat=? where id_notification="+n.getId_notification();
        try {
            prepste= c.prepareStatement(req);
            if (n.getEtat()!="") {
                prepste.setString(1,n.getEtat());
            } else {
                prepste.setNull( 1, java.sql.Types.VARCHAR );
            }
            
            System.out.println(prepste);
            prepste.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }




    }

    @Override
    public ArrayList<Notification> afficherNotifications() {
        ArrayList<Notification>list=new ArrayList();
        try {
            String req="SELECT * FROM notification";
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                list.add(tabToIns(rs));
               while (rs.next())
               {
                    list.add(tabToIns(rs));
               }
               return list;
            }
            else
                return list;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return list;
        }
    }

    @Override
    public Notification afficherNotificationById(int id) {
        try {
            String req="SELECT * FROM Notification WHERE id_notification="+id;
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                return tabToIns(rs);
            }
            else
                return null;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }
    private Notification tabToIns (ResultSet rs) throws SQLException {
        Notification n = new Notification();
        n.setId_notification(rs.getInt(1));
        n.setEtat(rs.getString(2));
        n.setId_demande(rs.getInt(3));
       
        return n;
    }



}
