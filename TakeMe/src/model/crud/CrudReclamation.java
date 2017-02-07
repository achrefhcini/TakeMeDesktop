package model.crud;

import database.DBConnect;
import model.entities.Membre;
import model.entities.Offre;
import model.entities.Reclamation;
import model.interfaces.ICrudReclamation;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Green on 07/02/2017.
 */

public class CrudReclamation implements ICrudReclamation {
    Connection c ;
    Statement ste ;
    PreparedStatement prepste;

    public CrudReclamation() throws SQLException {
        c= DBConnect.connect();
    }
    @Override
    public boolean ajouterReclamation(Reclamation R) {
        String req="insert into reclamation (sujet,id_offre)values"
                + "('"+R.getSujet()+"',"+R.getOffre().getId_offre()+")";
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
    public boolean supprimerReclamation(Reclamation R) {
        if(R!=null){
            String req= "delete from reclamation where id_reclamation="+R.getId_reclamation();
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
    public boolean modifierReclamation(Reclamation R) {
        String req="UPDATE reclamation SET sujet=?,id_offre=?"
                +" WHERE id_reclamation="+R.getId_reclamation();
        try {
            prepste= c.prepareStatement(req);
            if (R.getSujet()!=null) {
                prepste.setString(1,R.getSujet());
            } else {
                prepste.setNull( 1, java.sql.Types.VARCHAR );
            }
            if (R.getOffre().getId_offre()!=null) {
                prepste.setInt(2,R.getOffre().getId_offre());
            } else {
                prepste.setNull( 2, Types.INTEGER );
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
    public ArrayList<Reclamation> afficherReclamations() {
        ArrayList<Reclamation>list=new ArrayList();
        try {
            String req="SELECT * FROM reclamation";
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
    public Reclamation afficherReclamationById(int id) {
        try {
            String req="SELECT * FROM reclamation WHERE id_reclamation="+id;
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                return tabToIns(rs);
            }
            else
                return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    private Reclamation tabToIns (ResultSet rs) throws SQLException {
        Reclamation r = new Reclamation();
        r.setId_reclamation((Integer) rs.getObject(1));
        r.setSujet((String) rs.getObject(2));
        CrudOffre Co =new CrudOffre();
        Offre o=Co.afficherOffre((Integer) rs.getObject(3));
        r.setOffre(o);

        return r;
    }
}
