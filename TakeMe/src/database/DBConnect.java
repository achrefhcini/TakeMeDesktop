package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnect {


    String login="root";
    String pwd="";
    String url="jdbc:mysql://localhost:3306/takeme";
    static Connection instanceConnection;

    private DBConnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            instanceConnection= DriverManager.getConnection(url,login, pwd);
            System.out.println("connexion reussie");
        } catch (SQLException ex) {
            System.out.println("faux");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance(){

        if(instanceConnection == null)
        {
            new DBConnect();
        }

        return instanceConnection;
    }




}
