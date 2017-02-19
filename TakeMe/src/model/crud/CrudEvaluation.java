

package model.crud;


import database.DBConnect;
import model.entities.Evaluation;
import model.interfaces.ICrudEvaluation;

import java.sql.*;
import java.util.ArrayList;


public class CrudEvaluation implements ICrudEvaluation {
    Connection c ;
    Statement ste ;
    PreparedStatement prepste;

    public CrudEvaluation() throws SQLException, ClassNotFoundException {
        c=DBConnect.getInstance();
    }


    @Override
    public boolean ajouterEvaluation(Evaluation e) {
        String req="insert into evaluation (note)values"
                + "('"+e.getNote()+"') where id_offre="+e.getId_offre();



        try {
            ste=c.createStatement();
            ste.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur");
            return false;
        }
    }

    @Override
    public boolean supprimerEvaluation(Evaluation e) {

        if(e!=null){
            String req= "delete from evaluation where id_evaluation="+e.getId_evaluation();
        try {
            ste=c.createStatement();
           int r=ste.executeUpdate(req);
            System.out.println(r);
            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
        }
        else
            return false;

    }

    //@Override
    public boolean modifierEvaluation(Evaluation e)
    {
        String req="UPDATE Evaluation SET note=? where id_evaluation="+e.getId_evaluation();
        try {
            prepste= c.prepareStatement(req);
            if (e.getNote()!=0) {
                prepste.setInt(1,e.getNote());
            } else {
                prepste.setNull( 1, java.sql.Types.VARCHAR );
            }
            
            System.out.println(prepste);
            prepste.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public ArrayList<Evaluation> afficherEvaluations() {
        ArrayList<Evaluation>list=new ArrayList();
        try {
            String req="SELECT * FROM evaluation";
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                list.add(tabToIns(rs));
               while (rs.next())
               {
                    list.add(tabToIns(rs));
               }
               return list;
            }
            else
                return list;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return list;
        }
    }

    @Override
    public Evaluation afficherEvaluation() {
        try {
            String req="SELECT * FROM Evaluation ";
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                return tabToIns(rs);
            }
            else
                return null;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }
    private Evaluation tabToIns (ResultSet rs) throws SQLException {
        Evaluation n = new Evaluation();
        n.setId_evaluation(rs.getInt(1));
        n.setNote(rs.getInt(2));
        n.setId_offre(rs.getInt(3));
       
        return n;
    }

    @Override
    public boolean mmodifierEvaluation(Evaluation e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
