package model.entities;

import java.time.LocalDate;


public class Trajet {
    private Integer id_trajet;
    private LocalDate heure_depart;
    private LocalDate heure_arrivee;
    private String lieu_depart;
    private String lieu_arrivee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trajet)) return false;

        Trajet trajet = (Trajet) o;

        return id_trajet == trajet.id_trajet;
    }

    @Override
    public int hashCode() {
        return id_trajet;
    }

    public Trajet() {
    }

    @Override
    public String toString() {
        return "Trajet{" +
                "id_trajet=" + id_trajet +
                ", heure_depart=" + heure_depart +
                ", heure_arrivee=" + heure_arrivee +
                ", lieu_depart='" + lieu_depart + '\'' +
                ", lieu_arrivee='" + lieu_arrivee + '\'' +
                '}';
    }

    public Integer getId_trajet() {
        return id_trajet;
    }

    public void setId_trajet(Integer id_trajet) {
        this.id_trajet = id_trajet;
    }

    public LocalDate getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(LocalDate heure_depart) {
        this.heure_depart = heure_depart;
    }

    public LocalDate getHeure_arrivee() {
        return heure_arrivee;
    }

    public void setHeure_arrivee(LocalDate heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    public String getLieu_depart() {
        return lieu_depart;
    }

    public void setLieu_depart(String lieu_depart) {
        this.lieu_depart = lieu_depart;
    }

    public String getLieu_arrivee() {
        return lieu_arrivee;
    }

    public void setLieu_arrivee(String lieu_arrivee) {
        this.lieu_arrivee = lieu_arrivee;
    }

    public Trajet( LocalDate heure_depart, LocalDate heure_arrivee, String lieu_depart, String lieu_arrivee) {
        this.heure_depart = heure_depart;
        this.heure_arrivee = heure_arrivee;
        this.lieu_depart = lieu_depart;
        this.lieu_arrivee = lieu_arrivee;
    }

    public Trajet(Integer id_trajet, LocalDate heure_depart, LocalDate heure_arrivee, String lieu_depart, String lieu_arrivee) {
        this.id_trajet = id_trajet;
        this.heure_depart = heure_depart;
        this.heure_arrivee = heure_arrivee;
        this.lieu_depart = lieu_depart;
        this.lieu_arrivee = lieu_arrivee;
    }
}
