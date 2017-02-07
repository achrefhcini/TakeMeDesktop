/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entities;

/**
 *
 * @author user
 */
public class Demande {
    
    
    private int id_demande;
    private int  id_offre;
    private int id_membre;

    public Demande(  int id_offre, int id_membre) {
      
        this.id_offre = id_offre;
        this.id_membre = id_membre;
    }
     public Demande(  int id_demande, int id_offre, int id_membre) {
      
        this.id_demande = id_demande;
        this.id_offre = id_offre;
        this.id_membre = id_membre;
    }
    

    public Demande() {
     }

    public int getId_demande() {
        return id_demande;
    }

    public int getId_offre() {
        return id_offre;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    } 
    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }
    @Override
    public String toString() {
        return "Demande{" + "id_demande=" + id_demande + ", id_offre=" + id_offre + ", id_membre=" + id_membre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id_demande;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Demande other = (Demande) obj;
        if (this.id_demande != other.id_demande) {
            return false;
        }
        if (this.id_offre != other.id_offre) {
            return false;
        }
        return true;
    }
    
    
}
