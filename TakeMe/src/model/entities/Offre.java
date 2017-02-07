package model.entities;

import java.time.LocalDate;

/**
 * Created by Moez on 2/3/2017.
 */
public class Offre {
    private Integer id_offre;
    private String type_offre;
    private Float cout;
    private LocalDate date_offre;
    private String voiture ;
    private Integer nbr_places;
    private Boolean etat_disponible;
    private Integer id_trajet;
    private Integer id_membre;

    public Integer getId_offre()
    {
        return id_offre;
    }

    public void setId_offre(Integer id_offre)
    {
        this.id_offre = id_offre;
    }

    public String getType_offre()
    {
        return type_offre;
    }

    public void setType_offre(String type_offre)
    {

        this.type_offre = type_offre;
    }

    public Float getCout()
    {

        return cout;
    }

    public void setCout(Float cout)
    {
        this.cout = cout;
    }

    public LocalDate getDate_offre()
    {
        return date_offre;
    }

    public void setDate_offre(LocalDate date_offre)
    {
        this.date_offre = date_offre;
    }

    public String getVoiture()
    {
        return voiture;
    }

    public void setVoiture(String voiture)
    {
        this.voiture = voiture;
    }

    public Integer getNbr_places()
    {
        return nbr_places;
    }

    public void setNbr_places(Integer nbr_places)
    {
        this.nbr_places = nbr_places;
    }

    public Boolean isEtat_disponible()
    {
        return etat_disponible;
    }

    public void setEtat_disponible(Boolean etat_disponible)
    {
        this.etat_disponible = etat_disponible;
    }

    public Integer getId_trajet()
    {
        return id_trajet;
    }

    public void setId_trajet(Integer id_trajet)
    {
        this.id_trajet = id_trajet;
    }

    public Integer getId_membre()
    {
        return id_membre;
    }

    public void setId_membre(Integer id_membre)
    {
        this.id_membre = id_membre;
    }

    public Offre(Integer id_offre, String type_offre, Float cout, LocalDate date_offre, String voiture, Integer nbr_places, Boolean etat_disponible, Trajet trajet, Membre membre) {
        this.id_offre = id_offre;
        this.type_offre = type_offre;
        this.cout = cout;
        this.date_offre = date_offre;
        this.voiture = voiture;
        this.nbr_places = nbr_places;
        this.etat_disponible = etat_disponible;
        this.id_trajet = trajet.getId_trajet();
        this.id_membre = membre.getId_membre();
    }

    public Offre() {
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id_offre=" + id_offre +
                ", type_offre='" + type_offre + '\'' +
                ", cout=" + cout +
                ", date_offre=" + date_offre +
                ", voiture='" + voiture + '\'' +
                ", nbr_places=" + nbr_places +
                ", etat_disponible=" + etat_disponible +
                ", id_trajet=" + id_trajet +
                ", id_membre=" + id_membre +
                '}';
    }
}
