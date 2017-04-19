package model.mains;

import model.crud.CrudSession;
import model.crud.CrudTrajet;
import model.entities.Session;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by SAW on 12/02/2017.
 */
public class TestCrudSession {
    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        CrudSession crudSession = new CrudSession();

        LocalDate dateNow=LocalDate.now();

         //Session s=new Session(10,date2,"desktop");
         //crudSession.ajouterSession(s);

    }
}
