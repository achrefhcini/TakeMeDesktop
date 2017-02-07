package model.interfaces;

import model.entities.Membre;
import java.util.ArrayList;

/**
 * Created by Green on 03/02/2017.
 */
public interface ICrudMembre {
    public boolean ajouterMembre(Membre e);
    public boolean supprimerMembre(Membre e);
    public boolean modifierMembre(Membre e);
    public ArrayList<Membre> afficherMembres();
    public Membre afficherMembreById(int id);

}
