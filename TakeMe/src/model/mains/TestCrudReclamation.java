package model.mains;

import model.crud.CrudOffre;
import model.crud.CrudReclamation;
import model.entities.Offre;
import model.entities.Reclamation;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Marwa on 07/02/2017.
 */
public class TestCrudReclamation {
    public static void main(String [] args) throws SQLException {
        CrudReclamation crudReclamation = new CrudReclamation();
      //  Offre offre=new Offre();
        //offre.setId_offre(1);
        //Reclamation reclamation=new Reclamation("chante","parle",offre);
        //crudReclamation.ajouterReclamation(reclamation);
        ArrayList<Reclamation> r=crudReclamation.afficherReclamationByIdmembre(2);
        if((r!=null)){
            r.forEach(e->System.out.println(e.toString()));
        }
    }
}
