package model.crud;

import database.DBConnect;
import model.entities.Membre;
import model.entities.Offre;
import model.entities.Reclamation;
import model.interfaces.ICrudReclamation;

import java.awt.*;
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
        c= DBConnect.getInstance();
    }
    @Override
    public boolean ajouterReclamation(Reclamation R) {
        String req="insert into reclamation (sujet,id_offre,type)values"
                + "(?,?,?)";

        try {
            prepste= c.prepareStatement(req);
            if (R.getSujet()!=null) {
                prepste.setString(1,R.getSujet());
            } else {
                prepste.setNull( 1, Types.VARCHAR );
            }
            if (R.getOffre()==null) {
                prepste.setNull( 2, Types.INTEGER );

            } else if (R.getOffre().getId_offre()==0 )
            {
                prepste.setNull( 2, Types.INTEGER );
            }
            else
            {
                prepste.setInt(2,R.getOffre().getId_offre());
            }
            if (R.getType()!=null) {
                prepste.setString(3,R.getType());
            } else {
                prepste.setNull( 3, Types.VARCHAR );
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
        String req="UPDATE reclamation SET sujet=?,id_offre=?,type=?"
                +" WHERE id_reclamation="+R.getId_reclamation();
        try {
            prepste= c.prepareStatement(req);
            if (R.getSujet()!=null) {
                prepste.setString(1,R.getSujet());
            } else {
                prepste.setNull( 1, Types.VARCHAR );
            }
            if (R.getOffre().getId_offre()!=0) {
                prepste.setInt(2,R.getOffre().getId_offre());
            } else {
                prepste.setNull( 2, Types.INTEGER );
            }
            if (R.getType()!=null) {
                prepste.setString(3,R.getType());
            } else {
                prepste.setNull( 3, Types.VARCHAR );
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
        r.setType((String) rs.getObject(3));
        CrudOffre Co =new CrudOffre();
        if((Integer) rs.getObject(4)==null)
        { r.setOffre(null);}
        else
        {Offre o=Co.afficherOffre((Integer) rs.getObject(4));
            r.setOffre(o);}

        return r;
    }


    @Override
    public ArrayList<Reclamation> afficherReclamationByIdmembre(int idmembre) {
        ArrayList<Reclamation> reclamations=new ArrayList<>();
        try {
            String req="SELECT * FROM reclamation r, offre o where o.id_offre=r.id_offre and o.id_membre='"+idmembre+"'";
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                reclamations.add(tabToIns(rs));
                while (rs.next())
                {
                    reclamations.add(tabToIns(rs));
                }
                return reclamations;

            }
            else
                return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }







}
