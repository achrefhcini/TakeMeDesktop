package model.mains;

import model.crud.CrudFavoris;

import model.entities.Favoris;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by SAW on 04/02/2017.
 */
public class TestCrudFavoris {

    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        CrudFavoris f=new CrudFavoris();
        Favoris f1=new Favoris(10,12);
     //   int a=f.calculerFollower(f1.getId_followed());
       // System.out.println(a);
 // MD5hashing m=new MD5hashing("");
   //     System.out.println(m.Md5Encrypt());
        f.ajouterFavori(f1);



    }

}
