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
    
    
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;
    String user = "root";
    String pass = "masterkey";
    
    
    public void ConnectToDb() throws SQLException{
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
    
    public void query(String q){
   
     myConn = null;
     myStmt = null;
     
      try{
        
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
            myStmt = myConn.createStatement();
            myStmt.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Successfull");
            
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    
}
     public ResultSet getColumn(String query){
        ResultSet set = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb", user, pass);
            Statement stat = myConn.createStatement();
            set = stat.executeQuery(query);
           
        }
          catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return set;
        //Funktionen används för att hämta en lista på varje row i en viss kolumn. Exempelkod finns under 
        //UpdateUser -> 
    }
    public int getCount(String fromWhere) throws Exception{
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

    void delete(String sqlFraga) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String fetchSingle(String sqlName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
