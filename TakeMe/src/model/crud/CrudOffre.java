package model.crud;

import database.DBConnect;
import model.entities.Offre;
import model.interfaces.ICrudOffre;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Moez on 2/3/2017.
 */
public class CrudOffre implements ICrudOffre {
    Connection c ;
    Statement ste ;
    PreparedStatement prepste;

    public CrudOffre() throws SQLException {
        c= DBConnect.getInstance();
    }


    @Override
    public boolean ajouterOffre(Offre o) {
        String req="INSERT INTO `offre` (`type_offre`, `cout`, `date_offre`, `voiture`, `nbr_places`, `etat_disponible`, `id_trajet`, `id_membre`) "+
                "VALUES (?,?,?,?,?,?,?,?)";

        try {
            prepste= c.prepareStatement(req);
            if (o.getType_offre()!=null) {
                prepste.setString(1,o.getType_offre());
            } else {
                prepste.setNull( 1, java.sql.Types.VARCHAR );
            }
            if (o.getCout()!=null) {
                prepste.setFloat(2,o.getCout());
            } else {
                prepste.setNull( 2, Types.FLOAT);
            }
            if (o.getDate_offre()!=null) {
                prepste.setDate(3,java.sql.Date.valueOf(o.getDate_offre()));
            } else {
                prepste.setNull( 3, Types.DATE );
            }
            if (o.getVoiture()!=null) {
                prepste.setString(4,o.getVoiture());
            } else {
                prepste.setNull( 4, Types.VARCHAR );
            }
            if (o.getNbr_places()!=null) {
                prepste.setInt(5,o.getNbr_places());
            } else {
                prepste.setNull( 5, Types.INTEGER);
            }
            if (o.isEtat_disponible()!=null) {
                prepste.setBoolean(6,o.isEtat_disponible());
            } else {
                prepste.setNull( 6, Types.BOOLEAN);
            }
            if (o.getId_trajet()!=null) {
                prepste.setInt(7,o.getId_trajet());
            } else {
                prepste.setNull( 7, Types.INTEGER);
            }
            if (o.getId_membre()!=null) {
                prepste.setInt(8,o.getId_membre());
            } else {
                prepste.setNull( 8, Types.INTEGER);
            }



            prepste.executeUpdate();
            System.out.println(prepste);
            return true;
        } catch (SQLException e) {
            System.out.println("erreur");
            return false;
        }
    }


    @Override
    public boolean supprimerOffre(Offre o) {
        if(o!=null){
            String req1="DELETE FROM `offre` WHERE `id_offre`="+o.getId_offre()+"";
            try {
                ste=c.createStatement();
                ste.executeUpdate(req1);
                System.out.println(req1);
                return true;
            } catch (SQLException e) {
                System.out.println("erreur");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean modifierOffre(Offre o) {
        if(o!=null){
            String req = "UPDATE offre SET type_offre=?,cout=?,date_offre=?,voiture=?,"
                    +"nbr_places=?,"+"etat_disponible=?"
                    +" WHERE id_offre="+o.getId_offre();

            try {
                prepste= c.prepareStatement(req);
                if (o.getType_offre()!=null) {
                    prepste.setString(1,o.getType_offre());
                } else {
                    prepste.setNull( 1, java.sql.Types.VARCHAR );
                }
                if (o.getCout()!=null) {
                    prepste.setFloat(2,o.getCout());
                } else {
                    prepste.setNull( 2, Types.FLOAT);
                }
                if (o.getDate_offre()!=null) {
                    prepste.setDate(3,java.sql.Date.valueOf(o.getDate_offre()));
                } else {
                    prepste.setNull( 3, Types.DATE );
                }
                if (o.getVoiture()!=null) {
                    prepste.setString(4,o.getVoiture());
                } else {
                    prepste.setNull( 4, Types.VARCHAR );
                }
                if (o.getNbr_places()!=null) {
                    prepste.setInt(5,o.getNbr_places());
                } else {
                    prepste.setNull( 5, Types.INTEGER);
                }
                if (o.isEtat_disponible()!=null) {
                    prepste.setBoolean(6,o.isEtat_disponible());
                } else {
                    prepste.setNull( 6, Types.BOOLEAN);
                }




                prepste.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("erreur");
                return false;
            }
        }
        return false;
    }

    @Override
    public Offre afficherOffre(int id) {


        Offre offre = new Offre();
        try {
            ste=c.createStatement();

            ResultSet result = ste.executeQuery("SELECT * FROM `offre` WHERE `id_offre` = "+id+"");
            while(result.next()){


                offre.setId_offre((Integer) result.getObject(1));
                offre.setType_offre(result.getString(2));
                offre.setCout((Float) result.getObject(3));
                if(result.getDate(4)!=null){
                offre.setDate_offre(result.getDate(4).toLocalDate());
                }
                else
                {
                    offre.setDate_offre(null);
                }
                offre.setVoiture(result.getString(5));
                offre.setNbr_places((Integer) result.getObject(6));
                offre.setEtat_disponible((Boolean) result.getObject(7));
                offre.setId_trajet((Integer) result.getObject(8));
                offre.setId_membre((Integer) result.getObject(9));



            }

            return offre;
        }catch (SQLException e) {
            System.out.println("erreur");
            return null;
        }
    }


    @Override
    public ArrayList<Offre> afficherOffres() {
        ArrayList<Offre> offres = new ArrayList<Offre>();
        try {
            ste=c.createStatement();

            ResultSet result = ste.executeQuery("SELECT * FROM `offre`");
            while(result.next()){

                Offre offre = new Offre();

                offre.setId_offre((Integer) result.getObject(1));
                offre.setType_offre(result.getString(2));
                offre.setCout((Float) result.getObject(3));
                if(result.getDate(4)!=null){
                    offre.setDate_offre(result.getDate(4).toLocalDate());
                }
                else
                {
                    offre.setDate_offre(null);
                }
                offre.setVoiture(result.getString(5));
                offre.setNbr_places((Integer) result.getObject(6));
                offre.setEtat_disponible((Boolean) result.getObject(7));
                offre.setId_trajet((Integer) result.getObject(8));
                offre.setId_membre((Integer) result.getObject(9));
                offres.add(offre);

            }
            return offres;
        }catch (SQLException e) {
            System.out.println("erreur");
            return null;
        }
    }

    //mehdi

    @Override
    public int coutMaxOffre() {
        int coutMax = 0;
        String req = "SELECT MAX(cout) FROM offre ";
        try {
            ste = c.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                coutMax = rs.getInt(1);
                return coutMax;

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            return 0;
        }
        return coutMax;
    }

    @Override
    public int afficherOffreCouts(float a, float b) {
        //ArrayList<Offre> SessionUser=new ArrayList<>();
        String reqSelect="SELECT count(*) from offre where cout between '"+a+"' AND '" +b+"'";
        int nombreCouts=0;
        try {

            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(reqSelect);
            while(rs.next()){
                nombreCouts =rs.getInt(1);

                return nombreCouts;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreCouts;
    }


}
