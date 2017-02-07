package model.crud;

import database.DBConnect;
import model.entities.Trajet;
import model.interfaces.ICrudTrajet;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class CrudTrajet implements ICrudTrajet{
    Connection c ;
    Statement ste ;
    PreparedStatement prepste;
    public CrudTrajet() throws SQLException {
        c= DBConnect.connect();
    }
    @Override
    public boolean ajouterTrajet(Trajet t) {
        String req="insert into trajet (heure_depart,heure_arrivee,lieu_depart,lieu_arrivee)values"
                + "("+t.getHeure_depart()+","+t.getHeure_arrivee()+",'"+t.getLieu_depart()+"','"+t.getLieu_arrivee()+"')";


        try {
            ste=c.createStatement();
            ste.executeUpdate(req);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean supprimerTrajet(Trajet t) {
        if(t!=null){
            String req= "delete from trajet where id_trajet="+t.getId_trajet();
            try {
                ste=c.createStatement();
                int r=ste.executeUpdate(req);
                System.out.println(r);
                return true;
            } catch (SQLException e1) {
                e1.printStackTrace();
                return false;
            }
        }
        else
            return false;

    }

    @Override
    public boolean modifierTrajet(Trajet e) {

        String reqUpdate="UPDATE trajet SET heure_depart=? ,heure_arrivee=? ,lieu_depart=? ,lieu_arrivee=? where id_trajet="+e.getId_trajet();
        if(e!=null) {
            try {
                prepste = c.prepareStatement(reqUpdate);
                if (e.getHeure_depart() != null) {
                    prepste.setDate(1, Date.valueOf(e.getHeure_depart()));
                } else {
                    prepste.setNull(1, Types.DATE);
                }
                if (e.getHeure_arrivee() != null) {
                    prepste.setDate(2, Date.valueOf(e.getHeure_arrivee()));
                } else {
                    prepste.setNull(2, Types.DATE);
                }
                if (e.getLieu_depart() != null) {
                    prepste.setString(3, e.getLieu_depart());
                } else {
                    prepste.setNull(3, Types.VARCHAR);
                }

                if (e.getLieu_arrivee() != null) {
                    prepste.setString(4, e.getLieu_arrivee());
                } else {
                    prepste.setNull(4, Types.VARCHAR);
                }
                System.out.println(prepste);
                prepste.executeUpdate();
                return true;


            } catch (SQLException e1) {
                System.out.println("erreur");
                return false;
            }
        }

        return false;
    }

    @Override
    public ArrayList<Trajet> afficherTrajets() {
        ArrayList<Trajet>list=new ArrayList();
        try {
            String req="SELECT * FROM trajet";
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
    public Trajet afficherTrajetById(int id) {
        try {
            String req="SELECT * FROM trajet WHERE id_trajet="+id;
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
    private Trajet tabToIns (ResultSet rs) throws SQLException {
        Trajet t = new Trajet();

        t.setId_trajet((Integer) rs.getObject(1));;
        t.setHeure_depart(rs.getDate(2).toLocalDate());
        t.setHeure_arrivee( rs.getDate(3).toLocalDate());
        t.setLieu_depart((String) rs.getObject(4));
        t.setLieu_arrivee((String) rs.getObject(5));

        return t;
    }
}
