package model.crud;

import database.DBConnect;
import model.entities.Session;
import model.interfaces.ICrudSession;
import sun.util.resources.LocaleData;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by SAW on 12/02/2017.
 */
public class CrudSession implements ICrudSession{
    Connection c ;
    Statement ste ;
    PreparedStatement prepste;

    public CrudSession() throws SQLException, ClassNotFoundException {
        c= DBConnect.getInstance();
    }

    public boolean ajouterSession(Session s) {
        String req="insert into session (id_membre,date_connexion,plateform)values"
                + "('"+s.getId_membre()+"','"+s.getDate_connexion()+"','"+s.getPlateform()+"')";


        try {
            ste=c.createStatement();
            ste.executeUpdate(req);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public int afficheNbrSession(LocalDate from_date,LocalDate to_date,String plateform) {
        ArrayList<Session> SessionUser=new ArrayList<>();
        String reqSelect="SELECT COUNT(*) from session where plateform = '" + plateform+"' AND date_connexion between '"+from_date+"' AND '" +to_date+"'";
        int nombreSessionUser=0;
        try {

            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(reqSelect);
            while(rs.next()){
                nombreSessionUser =rs.getInt(1);

                return nombreSessionUser;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreSessionUser;
    }



}
