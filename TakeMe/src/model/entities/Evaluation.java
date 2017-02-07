package model.entities;


public class Evaluation {
    private int id_evaluation;
    private int note;
    private int id_offre;
    
    

        public Evaluation(int id_evaluation, int note, int id_offre) {
        this.id_evaluation = id_evaluation;
        this.note = note;
        this.id_offre = id_offre;
       
    }

    public Evaluation (){}
    @Override
    public String toString() {
        return "Evaluation{" +
                " id_evaluation=" + id_evaluation +
                ", note='" + note + '\'' +
                ", id_offre='" + id_offre + '\'' +                
                '}';
    }


    public int getId_evaluation() {
        return id_evaluation;
    }

    public void setId_evaluation( int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Evaluation)) return false;

        Evaluation Evaluation = (Evaluation) o;

        return id_evaluation == Evaluation.id_evaluation;
    }

    @Override
    public int hashCode() {
        return id_evaluation;
    }
}
