/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.interfaces;

import model.entities.Demande;

/**
 *
 * @author user
 */
public interface ICrudDemande {
    
    public boolean ajouterDemande(Demande d);
    public boolean supprimerDemande(Demande  d);
    public boolean modifierDemande(Demande d);
    public void afficherDemande();
    //public Demande afficherDemande(int id);
        public void afficherDemande(int id);

    
    
}
