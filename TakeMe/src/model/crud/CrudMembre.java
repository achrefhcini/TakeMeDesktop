package model.crud;

import database.DBConnect;
import model.entities.Membre;
import model.interfaces.ICrudMembre;
import controller.MD5hashing;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Green on 03/02/2017.
 */
public class CrudMembre implements ICrudMembre {
    Connection c ;
    Statement ste ;
    PreparedStatement prepste;

    public CrudMembre() throws SQLException {
        c=DBConnect.connect();
    }


    @Override
    public boolean ajouterMembre(Membre m) {


        String req="insert into membre "+
                " (role,nom,prenom,num_tel,email,photo,age,sexe,password,verifMail,verifTel,CodeVerifMail,CodeVerifTel,isActif) "+
                " Values(?,?,?,?,"
                +"?,?,?,?,?,?,?,"
                +"?,?,?)";
        try {
            prepste= c.prepareStatement(req);
            if (m.getRole()!=null) {
                prepste.setString(1,m.getRole());
            } else {
                prepste.setNull( 1, java.sql.Types.VARCHAR );
            }
            if (m.getNom()!=null) {
                prepste.setString(2,m.getNom());
            } else {
                prepste.setNull( 2, java.sql.Types.VARCHAR );
            }
            if (m.getPrenom()!=null) {
                prepste.setString(3,m.getPrenom());
            } else {
                prepste.setNull( 3, java.sql.Types.VARCHAR );
            }
            if (m.getNum_tel()!=null) {
                prepste.setString(4,m.getNum_tel());
            } else {
                prepste.setNull( 4, java.sql.Types.VARCHAR );
            }
            if (m.getEmail()!=null) {
                prepste.setString(5,m.getEmail());
            } else {
                prepste.setNull( 5, java.sql.Types.VARCHAR );
            }
            if (m.getPhoto()!=null) {
                prepste.setString(6,m.getPhoto());
            } else {
                prepste.setNull( 6, java.sql.Types.VARCHAR );
            }
            if (m.getAge()!=null) {
                prepste.setInt(7,m.getAge());
            } else {
                prepste.setNull( 7, Types.INTEGER);
            }
            if (m.getSexe()!=null) {
                prepste.setString(8,m.getSexe());
            } else {
                prepste.setNull( 8, java.sql.Types.VARCHAR );
            }
            if (m.getPassword()!=null) {
                // NB : crypter password MD5
                MD5hashing md5=new MD5hashing(m.getPassword());
                String PasswordMd5Hash=md5.Md5Encrypt();
                prepste.setString(9,PasswordMd5Hash);
            } else {
                prepste.setNull( 9, java.sql.Types.VARCHAR );
            }
            if (m.isVerifMail()!=null) {
                prepste.setBoolean(10,m.isVerifMail());
            } else {
                prepste.setNull( 10, Types.BOOLEAN );
            }
            if (m.isVerifTel()!=null) {
                prepste.setBoolean(11,m.isVerifTel());
            } else {
                prepste.setNull( 11, Types.BOOLEAN );
            }

            if (m.getCodeVerifMail()!=null) {
                prepste.setInt(12,m.getCodeVerifMail());
            } else {
                prepste.setNull( 12, Types.INTEGER );
            }
            if (m.getCodeVerifTel()!=null) {
                prepste.setInt(13,m.getCodeVerifTel());
            } else {
                prepste.setNull( 13, Types.INTEGER );
            }
            if (m.isActif()!=null) {
                prepste.setBoolean(14,m.isActif());
            } else {
                prepste.setNull( 14, Types.BOOLEAN );
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
    public boolean supprimerMembre(Membre e) {

        if(e!=null){
            String req= "delete from membre where id_membre="+e.getId_membre();
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

    @Override
    public boolean modifierMembre(Membre m)
    {
        String req="UPDATE membre SET role=?,nom=?,prenom=?,num_tel=?,"
                +"email=?,photo=?,age=?,sexe=?,password=?,verifMail=?,verifTel=?,"
                +"CodeVerifMail=?,CodeVerifTel=?"
                +" WHERE id_membre="+m.getId_membre();
        try {
            prepste= c.prepareStatement(req);
            if (m.getRole()!=null) {
                prepste.setString(1,m.getRole());
            } else {
                prepste.setNull( 1, java.sql.Types.VARCHAR );
            }
            if (m.getNom()!=null) {
                prepste.setString(2,m.getNom());
            } else {
                prepste.setNull( 2, java.sql.Types.VARCHAR );
            }
            if (m.getPrenom()!=null) {
                prepste.setString(3,m.getPrenom());
            } else {
                prepste.setNull( 3, java.sql.Types.VARCHAR );
            }
            if (m.getNum_tel()!=null) {
                prepste.setString(4,m.getNum_tel());
            } else {
                prepste.setNull( 4, java.sql.Types.VARCHAR );
            }
            if (m.getEmail()!=null) {
                prepste.setString(5,m.getEmail());
            } else {
                prepste.setNull( 5, java.sql.Types.VARCHAR );
            }
            if (m.getPhoto()!=null) {
                prepste.setString(6,m.getPhoto());
            } else {
                prepste.setNull( 6, java.sql.Types.VARCHAR );
            }
            if (m.getAge()!=null) {
                prepste.setInt(7,m.getAge());
            } else {
                prepste.setNull( 7, Types.INTEGER);
            }
            if (m.getSexe()!=null) {
                prepste.setString(8,m.getSexe());
            } else {
                prepste.setNull( 8, java.sql.Types.VARCHAR );
            }
            if (m.getPassword()!=null) {
                prepste.setString(9,m.getPassword());
            } else {
                prepste.setNull( 9, java.sql.Types.VARCHAR );
            }
            if (m.isVerifMail()!=null) {
                prepste.setBoolean(10,m.isVerifMail());
            } else {
                prepste.setNull( 10, Types.BOOLEAN );
            }
            if (m.isVerifTel()!=null) {
                prepste.setBoolean(11,m.isVerifTel());
            } else {
                prepste.setNull( 11, Types.BOOLEAN );
            }

            if (m.getCodeVerifMail()!=null) {
                prepste.setInt(12,m.getCodeVerifMail());
            } else {
                prepste.setNull( 12, Types.INTEGER );
            }
            if (m.getCodeVerifTel()!=null) {
                prepste.setInt(13,m.getCodeVerifTel());
            } else {
                prepste.setNull( 13, Types.INTEGER );
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
    public ArrayList<Membre> afficherMembres() {
        ArrayList<Membre>list=new ArrayList();
        try {
            String req="SELECT * FROM membre";
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
    public Membre afficherMembreById(int id) {
        try {
            String req="SELECT * FROM membre WHERE id_membre="+id;
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
    private Membre tabToIns (ResultSet rs) throws SQLException {
        Membre m = new Membre();
        m.setId_membre((Integer) rs.getObject(1));
        m.setRole((String) rs.getObject(2));
        m.setNom((String) rs.getObject(3));
        m.setPrenom((String) rs.getObject(4));
        m.setNum_tel((String) rs.getObject(5));
        m.setEmail((String) rs.getObject(6));
        m.setPhoto((String) rs.getObject(7));
        m.setAge((Integer) rs.getObject(8));
        m.setSexe((String) rs.getObject(9));
        m.setPassword((String) rs.getObject(10));
        m.setVerifMail((Boolean) rs.getObject(11));
        m.setVerifTel((Boolean) rs.getObject(12));
        m.setCodeVerifMail((Integer) rs.getObject(13));
        m.setCodeVerifTel((Integer) rs.getObject(14));
        return m;
    }

    // realiser par achref connexion et md5 verification password

    public int VerfiConnexion(String email,String password){
        MD5hashing md5=new MD5hashing(password);
        String emailuser="'"+email+"'";
        String PasswordMd5Hash="'"+md5.Md5Encrypt()+"'";
        try {
            String req="SELECT id_membre FROM membre WHERE  password = "+PasswordMd5Hash+" AND email = "+ emailuser+" AND verifMail = 0 ";
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                int id_membre=rs.getInt(1);
                Membre.IdUserConnected=id_membre;
                return id_membre;

            }
            else
                return 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return 0;
        }

    }

    public int VerfiConnecionFB(String email){
        String emailuser="'"+email+"'";
        try {
            String req="SELECT id_membre FROM membre WHERE  email = "+ emailuser+" ";
            ste=c.createStatement();
            ResultSet rs=ste.executeQuery(req);
            if (rs.next())
            {
                int id_membre=rs.getInt(1);
                Membre.IdUserConnected=id_membre;
                return id_membre;

            }
            else
                return 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return 0;
        }

    }




}
