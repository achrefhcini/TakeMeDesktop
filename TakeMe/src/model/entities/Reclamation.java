package model.entities;

import model.entities.Offre;

/**
 * Created by Green on 06/02/2017.
 */
public class Reclamation {

    private Integer id_reclamation;
    private String sujet;
    private Offre offre;


    public Reclamation(Integer id_reclamation, String sujet, Offre offre) {

        this.id_reclamation = id_reclamation;
        this.sujet = sujet;
        this.offre = offre;
    }

    public Reclamation() {

    }
    @Override
    public String toString() {
        return "Reclamation{" +
                "id_reclamation=" + id_reclamation +
                ", sujet='" + sujet + '\'' +
                ", offre=" + offre +
                '}';
    }


    public Integer getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(Integer id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }


}
