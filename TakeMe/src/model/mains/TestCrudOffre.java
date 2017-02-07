package model.mains;

import model.crud.CrudMembre;
import model.crud.CrudOffre;
import model.crud.CrudTrajet;
import model.entities.Membre;
import model.entities.Offre;
import model.entities.Trajet;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Moez on 2/4/2017.
 */
public class TestCrudOffre {
    public static void main(String[]args) throws SQLException{
        CrudOffre crudeOffre = new CrudOffre();
        CrudMembre crudMembre=new CrudMembre();
        CrudTrajet crudTrajet =new CrudTrajet();
        Offre o1 = new Offre();
        crudeOffre.ajouterOffre(o1);

        Trajet trajet=new Trajet();
        trajet.setId_trajet(5);

        crudTrajet.ajouterTrajet(trajet);
        Offre o = new Offre();
        o.setType_offre("Regulier");
        o.setCout(5f);
        o.setDate_offre(LocalDate.of(1212,12,12));
        o.setEtat_disponible(true);
        o.setNbr_places(5);
        o.setVoiture("ferrari");
        o.setId_membre(crudMembre.afficherMembres().get(0).getId_membre());
        o.setId_trajet(trajet.getId_trajet());
        crudeOffre.ajouterOffre(o);



        o=crudeOffre.afficherOffre(55);
        o.setNbr_places(52);
        System.out.println(o);
        crudeOffre.supprimerOffre(o);
        crudeOffre.afficherOffres().forEach(System.out::println);



}
}