package model.interfaces;

import model.entities.Membre;
import model.entities.Offre;

import java.util.ArrayList;

/**
 * Created by Moez on 2/3/2017.
 */
public interface ICrudOffre {
    public boolean ajouterOffre(Offre o);
    public boolean supprimerOffre(Offre o);
    public boolean modifierOffre(Offre o);
    public Offre afficherOffre(int id);
    public ArrayList<Offre> afficherOffres();
    //mehdi
    public int coutMaxOffre();
    public int afficherOffreCouts(float a, float b);

}
