package database;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author arbi
 */
public class DBConnect {
    private static Connection conn;
    private static String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11157205";
    private static String user = "sql11157205";
    private static String pass = "19plrCc2Bs";

    public static Connection connect() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Connexion success");
        }catch(ClassNotFoundException cnfe){
            System.err.println("Error: "+cnfe.getMessage());
        }catch(InstantiationException ie){
            System.err.println("Error: "+ie.getMessage());
        }catch(IllegalAccessException iae){
            System.err.println("Error: "+iae.getMessage());
        }

        conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn !=null && !conn.isClosed())
            return conn;
        connect();
        return conn;

    }
}
/*
*   test database
*    Connection c ;
*    c=DBConnect.connect();
*
* */