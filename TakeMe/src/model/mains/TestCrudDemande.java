

package model.mains;
import java.sql.SQLException;
import model.entities.Demande;
import model.crud.CrudDemande;

/**
 *
 * @author user
 */
public class TestCrudDemande   {


    public static void main(String[]args) throws SQLException, ClassNotFoundException {



        Demande d = new Demande(  13,41);
        Demande d1 = new Demande( 12,11);
        Demande d2 = new Demande(  20,41);
        Demande d3 = new Demande(  14,52);
        Demande d4 = new Demande(  10,13);

        CrudDemande demandeCrud = new CrudDemande();

       // demandeCrud.ajouterDemande(d4);
        // demandeCrud.supprimerDemande(d1);



        // TEST EFFECTUE AVEC SUCCESS




        //demandeCrud.afficherDemande(1);



    }
}
