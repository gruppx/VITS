/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaspar
 */
public class ConnectionClass {
    
    
    
    
    String user = "root";
    String pass = "masterkey";
    
    
    public void ConnectToDb() throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        try {
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb", user, pass);
        myStmt = myConn.createStatement();
        myRs = myStmt.executeQuery("select * from users");
        
        while (myRs.next()){
            System.out.println(myRs.getString("Name") + ", " + myRs.getString("Email"));  //Visar det som finns i userstabellen i konsollen.
        }
        
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(myRs != null){
                myRs.close();
            }
            if(myStmt != null){
                myStmt.close();
            }
            if(myConn != null){
                myConn.close();
            }
        }
    }
    
    public void closeConnection(){
        Connection myConn = null;
        try{
            if(myConn != null){
                myConn.close();
            }
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void query(String q){
        Connection myConn = null;

        Statement myStmt = null;
        ResultSet myRs = null;
     
      try{
        
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
            myStmt = myConn.createStatement();
            myStmt.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Successful");
            
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
      
    
}
    
     public ResultSet getColumn(String query){
         Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb", user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(query);
           
        }
          catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return myRs;
        //Funktionen används för att hämta en lista på varje row i en viss kolumn. Exempelkod finns under 
        //UpdateUser -> 
    }
     
     public ResultSet getRow(String fromTable, String fromType, String fromObject){
         Connection myConn = null;
         Statement myStmt = null;
        ResultSet myRs = null;
         try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb", user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from "+fromTable+" where "+fromType+"='"+fromObject+"'");
         }
         catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
         
         return myRs;
     }
     
    public int getCount(String fromWhere) throws Exception{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        int count = 0;
       
         try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb", user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from "+fromWhere);
         
            while(myRs.next())
            {
                count++;
            }
          
        }
         catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
         return count;
    }

    public String getString(String query) throws Exception{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String getString = "";
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb", user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(query);
            while(myRs.next()){
                getString = myRs.getString(1);
            }
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return getString;
        //samma funktion som ovan fast denna returnerar ett stringvärde.
    }
    
   public int getID(String query) throws Exception{
       Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
       
        int getID = 0;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb", user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(query);
            while(myRs.next()){
                getID = myRs.getInt(1);
            }
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return getID;
        //FUNKTIONEN används för att returera int värde (exempelvis ett ID).
    }
   
   public int getTraktemente(String country){
       Connection myConn = null;
       Statement myStmt = null;
        ResultSet myRs = null;
       int traktamente = 0;
       try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb", user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select amount from allowance where country = '"+country+"'");
            while(myRs.next()){
                traktamente = myRs.getInt(1);
            }
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
       return traktamente;
   }
   /**
    * kör flera sql frågor samtidigt
    */
   public void executeMultiple(String[] Queries)   {
       Connection myConn = null;
       Statement myStmt = null;
        ResultSet myRs = null;
       try
       {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
            myStmt = myConn.createStatement();
            
            for(String query : Queries)
            {
                myStmt.addBatch(query);
            }
            
            myStmt.executeBatch();
            
            JOptionPane.showMessageDialog(null, ""
                    + "Success");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
   }
    
    
  
}
