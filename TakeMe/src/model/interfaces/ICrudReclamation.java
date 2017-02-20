package model.interfaces;

import model.entities.Membre;
import model.entities.Reclamation;

import java.util.ArrayList;

/**
 * Created by Green on 07/02/2017.
 */
public interface ICrudReclamation {
    public boolean ajouterReclamation(Reclamation R);
    public boolean supprimerReclamation(Reclamation R);
    public boolean modifierReclamation(Reclamation R);
    public ArrayList<Reclamation> afficherReclamations();
    public Reclamation afficherReclamationById(int id);
    public ArrayList<Reclamation> afficherReclamationByIdmembre(int idmembre);
}
