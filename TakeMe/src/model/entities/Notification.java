package model.entities;


public class Notification {
    private int id_notification;
    private String etat;
    private int id_demande;
    

        public Notification(int id_notification, String etat, int id_demande) {
        this.id_notification = id_notification;
        this.etat = etat;
        this.id_demande = id_demande;
       
    }

    public Notification (){}
    @Override
    public String toString() {
        return "Notification{" +
                " id_notification=" + id_notification +
                ", etat='" + etat + '\'' +
                ", id_demande='" + id_demande + '\'' +                
                '}';
    }


    public int getId_notification() {
        return id_notification;
    }

    public void setId_notification(int id_notification) {
        this.id_notification = id_notification;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Notification)) return false;

        Notification Notification = (Notification) o;

        return id_notification == Notification.id_notification;
    }

    @Override
    public int hashCode() {
        return id_notification;
    }
}
