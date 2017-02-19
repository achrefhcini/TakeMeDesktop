package model.crud;

import database.DBConnect;
import model.entities.Membre;
import model.entities.Message;
import model.entities.Offre;
import model.entities.Reclamation;
import model.interfaces.ICrudMessage;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Green on 07/02/2017.
 */
public class CrudMessage implements ICrudMessage {

    Connection c ;
    Statement ste ;
    PreparedStatement prepste;

    public CrudMessage() throws SQLException {
        c= DBConnect.getInstance();
    }
    @Override
    public boolean ajouterMessage(Message m) {
        String req="insert into message (sujet,id_membreS,id_membreD)values"
                + "('"+m.getSujet()+"',"+m.getMembreSource().getId_membre()+","+m.getMembreDestinataire().getId_membre()+")";
        try {
            ste=c.createStatement();
            ste.executeUpdate(req);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean supprimerMessage(Message m) {
        if(m!=null){
            String req= "delete from message where id_message="+m.getId_message();
            try {
                ste=c.createStatement();
                int r=ste.executeUpdate(req);
                return true;
            } catch (SQLException e1) {
                e1.printStackTrace();
                return false;
            }
        }
        else
            return false;
    }

    @Override
    public boolean modifierMessage(Message m) {
        String req="UPDATE message SET sujet=?,id_membreS=?,id_membreD=?"
                +" WHERE id_message="+m.getId_message();
        try {
            prepste= c.prepareStatement(req);
            if (m.getSujet()!=null) {
                prepste.setString(1,m.getSujet());
            } else {
                prepste.setNull( 1, java.sql.Types.VARCHAR );
            }
            if (m.getMembreSource().getId_membre()!=null) {
                prepste.setInt(2,m.getMembreSource().getId_membre());
            } else {
                prepste.setNull( 2, Types.INTEGER );
            }
            if (m.getMembreDestinataire().getId_membre()!=null) {
                prepste.setInt(3,m.getMembreDestinataire().getId_membre());
            } else {
                prepste.setNull( 3, Types.INTEGER );
            }

            System.out.println(prepste);
            prepste.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Message> afficherMessages() {
        ArrayList<Message>list=new ArrayList();
        try {
            String req="SELECT * FROM message";
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
    public Message afficherMessageById(int id) {
        try {
            String req="SELECT * FROM message WHERE id_message="+id;
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                return tabToIns(rs);
            }
            else
                return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    private Message tabToIns (ResultSet rs) throws SQLException {
        Message m = new Message();
        m.setId_message((Integer) rs.getObject(1));
        m.setSujet((String) rs.getObject(2));
        CrudMembre Cm =new CrudMembre();
        Membre membreS=Cm.afficherMembreById(((Integer) rs.getObject(3)));
        Membre membreD=Cm.afficherMembreById(((Integer) rs.getObject(4)));
        m.setMembreSource(membreS);
        m.setMembreDestinataire(membreD);

        return m;
    }
}
