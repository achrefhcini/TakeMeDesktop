/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.ICrudDemande;
import database.DBConnect;
import model.entities.Demande;
import model.interfaces.ICrudDemande;

/**
 *
 * @author user
 */
public class CrudDemande  implements ICrudDemande {
 
    
    Connection cnx;
    Statement st ;
    PreparedStatement prepst;
    
    public CrudDemande() throws SQLException, ClassNotFoundException {

        cnx= DBConnect.getInstance();

    }
    

     

    @Override
    public boolean ajouterDemande(Demande d) {
       
         try {
            
             String req1="insert into demande (id_offre,id_membre) values"
                    + "("+d.getId_offre()+",' "+d.getId_membre()+"')";
            
 
                        st = cnx.createStatement();

            st.executeUpdate(req1);
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
          return false;
        
     }

    @Override
    public boolean supprimerDemande(Demande d) {
  try {
           String req2= "delete from demande where id_demande=?";
            
           prepst = cnx.prepareStatement(req2);
           prepst.setInt(1, d.getId_demande());
           
           prepst.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudDemande.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return false;
    }

    @Override
    public boolean modifierDemande(Demande d) {
        
        
         if(d!=null){
             
            String req3 = "UPDATE demande SET id_membre=?,id_offre=? WHERE id_demande=?";

            try {
                prepst= cnx.prepareStatement(req3);
                
               prepst.setInt(1, d.getId_membre());
               prepst.setInt(2, d.getId_offre());
               prepst.setInt(3, d.getId_demande());



                 prepst.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("erreur");
                return false;
            }
        }
        return false;
        
     }
   // public Demande afficherDemande(int id) {
public void afficherDemande(int id) {

        Demande demande = new Demande();
        try {
            st=cnx.createStatement();

            ResultSet res = st.executeQuery("SELECT * FROM `demande` WHERE `id_demande` = "+id+"");
            while(res.next()){


                
                  demande.setId_demande(res.getInt(1));
                  demande.setId_offre(res.getInt(2));
                   demande.setId_membre(res.getInt(3));



            }

            //return demande;
            System.out.println(demande);
        }catch (SQLException e) {
            System.out.println("erreur");
           // return null;
        }
    }
    

    @Override
   // public  ArrayList<Demande> afficherDemande() {
             public  void afficherDemande() {
        
          ArrayList<Demande> demandes = new ArrayList<>();
         String req4= "select * from demande";

         
        try {
               st = cnx.createStatement();

            ResultSet res  =st.executeQuery(req4);
            while (res.next()) { 
                
                 Demande demande = new Demande();
                  demande.setId_demande(res.getInt(1));
                  demande.setId_offre(res.getInt(2));
                   demande.setId_membre(res.getInt(3));


                demandes.add(demande);
                
            }
           // return demandes;
            demandes.stream().forEach((e) -> {
                  System.out.println(e);              
              });
        } catch (SQLException ex) {
            Logger.getLogger(CrudDemande.class.getName()).log(Level.SEVERE, null, ex);
          //   return null;
        }
       
    }

     
    }
    

