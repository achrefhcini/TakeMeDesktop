package model.crud;

import database.DBConnect;
import model.entities.Favoris;
import model.interfaces.ICrudFavoris;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by SAW on 04/02/2017.
 */
public class CrudFavoris implements ICrudFavoris {

    Connection c ;
    Statement ste ;
    PreparedStatement prepste;

    public CrudFavoris() throws SQLException, ClassNotFoundException {
        c= DBConnect.getInstance();
    }


    @Override
    public boolean ajouterFavori(Favoris f) {
        String reqajoutfavori="INSERT INTO `favoris` (`id_membre`, `id_membre_favoris`) VALUES ("+f.getId_user()+","+f.getId_followed()+")";
        try {
            ste=c.createStatement();
            ste.executeUpdate(reqajoutfavori);
            return true;
        } catch (SQLException e) {
            System.out.println("erreur");
            return false;
        }
    }

    @Override
    public boolean supprimerFavori(Favoris f) {
        if(f!=null){
            String req= "delete from `favoris` where id_membre="+ f.getId_user()+" AND id_membre_favoris="+f.getId_followed()+"";
            try {
                ste=c.createStatement();
                ste.executeUpdate(req);
                System.out.println(req);
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
    // calculer nombre de follower par un membre
    public int calculerFollower(int idfollowed) {
        String reqSelect="SELECT COUNT(*) FROM favoris where id_membre_favoris="+idfollowed;
        int nombrefollower=0;
        try {
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(reqSelect);
            while(rs.next()){
                nombrefollower=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombrefollower;
    }

    //select distinct favoris pour l'utilisateur
    @Override
    public ArrayList<Favoris> afficherFavoriByuser(int iduser) {
        ArrayList<Favoris> favorisDeUser=new ArrayList<>();
        String reqSelect="SELECT distinct id_membre_favoris from favoris  where id_membre="+iduser+"  ";
        try {

            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(reqSelect);
            while(rs.next()){
                Favoris f=new Favoris(iduser,rs.getInt(1));
                favorisDeUser.add(f);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorisDeUser;
    }
}
