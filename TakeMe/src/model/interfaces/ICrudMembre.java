package model.interfaces;

import model.entities.Membre;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Green on 03/02/2017.
 */
public interface ICrudMembre {
    public boolean ajouterMembre(Membre e);
    public boolean supprimerMembre(Membre e);
    public boolean modifierMembre(Membre e);
    public ArrayList<Membre> afficherMembres();
    ArrayList<Membre> afficherMembreAges(int from_age,int to_age);
    public ArrayList<Membre> afficherMembresByrange(int idFrom,int idTo);
    public int ageMaxMembre();
    public int nombreMembresHommes() throws SQLException;
    public int nombreMembresFemmes() throws SQLException;
    public Membre afficherMembreById(int id);
    public ArrayList<Membre> findUserByChamp(String champ);



}
