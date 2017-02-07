package model.interfaces;

import model.entities.Trajet;

import java.util.ArrayList;


public interface ICrudTrajet
{
    public boolean ajouterTrajet(Trajet e);
    public boolean supprimerTrajet(Trajet e);
    public boolean modifierTrajet(Trajet e);
    public ArrayList<Trajet> afficherTrajets();
    public Trajet afficherTrajetById(int id);
}
