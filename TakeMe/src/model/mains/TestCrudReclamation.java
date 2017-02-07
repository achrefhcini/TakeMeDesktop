package model.mains;

import model.crud.CrudOffre;
import model.crud.CrudReclamation;
import model.entities.Reclamation;

import java.sql.SQLException;

/**
 * Created by Green on 07/02/2017.
 */
public class TestCrudReclamation {
    public static void main(String [] args) throws SQLException {
        CrudReclamation crudReclamation = new CrudReclamation();
        CrudOffre crudOffre = new CrudOffre();
        Reclamation r =new Reclamation();
        r.setId_reclamation(1);
        r.setSujet("harcelement sexuel");
        r.setOffre(crudOffre.afficherOffre(1));
        //crudReclamation.ajouterReclamation(r);
        crudReclamation.afficherReclamations().forEach(reclamation -> System.out.println(reclamation));
        //System.out.println(crudReclamation.afficherReclamationById(1));
        r=crudReclamation.afficherReclamationById(1);
        r.setSujet("feedback bla bla bla");
        crudReclamation.modifierReclamation(r);
        crudReclamation.afficherReclamations().forEach(reclamation -> System.out.println(reclamation));
    }
}
