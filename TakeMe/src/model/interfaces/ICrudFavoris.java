package model.interfaces;

import model.entities.Favoris;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by SAW on 04/02/2017.
 */
public interface ICrudFavoris {
    public boolean ajouterFavori(Favoris f);
    public boolean supprimerFavori(Favoris f);
    public int calculerFollower(int idfollowed) throws SQLException;
    public ArrayList<Favoris> afficherFavoriByuser(int iduser);
}
