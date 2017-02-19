package model.mains;

import model.crud.CrudMembre;
import model.entities.Membre;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Green on 04/02/2017.
 */
public class TestCrudMembre {
    public static void main(String[]args) throws SQLException {
        CrudMembre crudMembre = new CrudMembre();
        Membre membre =new Membre();
        membre.setPassword("hello world");
        System.out.println(membre.getPassword());




      ArrayList<Membre> list=crudMembre.afficherMembres();
        if(!(list.isEmpty())){
            list.forEach(e->System.out.println(e.isActif()));
        }





    }

}
