package model.interfaces;


//import entites.Offre;
import model.entities.Evaluation;

import java.util.ArrayList;


public interface ICrudEvaluation{
    public boolean ajouterEvaluation(Evaluation e);
    public boolean supprimerEvaluation(Evaluation e);
    public boolean mmodifierEvaluation(Evaluation e);
    public Evaluation afficherEvaluation();
    public ArrayList<Evaluation> afficherEvaluations();
}
