package model.mains;

import model.crud.CrudTrajet;
import model.entities.Trajet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Green on 04/02/2017.
 */
public class TestCrudTrajet {
    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        CrudTrajet crudTrajet = new CrudTrajet();

        LocalDate date=LocalDate.of(2015,8,15);
        //Trajet t=new Trajet(1,date,date,"sousse","beja");
      //  crudTrajet.modifierTrajet(t);
      //  System.out.println(date);
    }
}
