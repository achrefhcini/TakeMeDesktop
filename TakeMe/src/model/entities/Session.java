package model.entities;

import sun.util.resources.LocaleData;

import java.time.LocalDate;

/**
 * Created by SAW on 12/02/2017.
 */
public class Session {

    private int id_membre;
    private LocalDate date_connexion;
    private String plateform;

    public Session(int id_membre, LocalDate date_connexion, String plateform) {
        this.id_membre = id_membre;
        this.date_connexion = date_connexion;
        this.plateform = plateform;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public LocalDate getDate_connexion() {
        return date_connexion;
    }

    public void setDate_connexion(LocalDate date_connexion) {
        this.date_connexion = date_connexion;
    }

    public String getPlateform() {
        return plateform;
    }

    public void setPlateform(String plateform) {
        this.plateform = plateform;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id_membre=" + id_membre +
                ", date_connexion=" + date_connexion +
                ", plateform='" + plateform + '\'' +
                '}';
    }


}
