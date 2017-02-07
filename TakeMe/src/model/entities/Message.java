package model.entities;

/**
 * Created by Green on 06/02/2017.
 */
public class Message {
    private Integer id_message;
    private String sujet;
    private Membre MembreSource;
    private Membre MembreDestinataire;

    @Override
    public String toString() {
        return "Message{" +
                "id_message=" + id_message +
                ", sujet=" + sujet  +
                ", MembreSource=" + MembreSource +
                ", MembreDestinataire=" + MembreDestinataire +
                '}';
    }

    public Integer getId_message() {
        return id_message;
    }

    public void setId_message(Integer id_message) {
        this.id_message = id_message;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Membre getMembreSource() {
        return MembreSource;
    }

    public void setMembreSource(Membre membreSource) {
        MembreSource = membreSource;
    }

    public Membre getMembreDestinataire() {
        return MembreDestinataire;
    }

    public void setMembreDestinataire(Membre membreDestinataire) {
        MembreDestinataire = membreDestinataire;
    }

    public Message(Integer id_message, String sujet, Membre membreSource, Membre membreDestinataire) {

        this.id_message = id_message;
        this.sujet = sujet;
        MembreSource = membreSource;
        MembreDestinataire = membreDestinataire;
    }

    public Message() {

    }
}
