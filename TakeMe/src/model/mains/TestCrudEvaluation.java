package model.mains;

import model.crud.CrudEvaluation;
import model.entities.Evaluation;

import java.sql.SQLException;


public class TestCrudEvaluation {
    public static void main(String[]args) throws SQLException, ClassNotFoundException {
    CrudEvaluation crudEvaluation = new CrudEvaluation();
        Evaluation e = new Evaluation();

        e=crudEvaluation.afficherEvaluation();
        System.out.println(e);
      

        

}
}