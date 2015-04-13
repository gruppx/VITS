/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Validation {
    
    static ConnectionClass db = new ConnectionClass();
    
    
    
    
    static public boolean logInCheck(String username, String password){   
        db.myConn = null;
        db.myStmt = null;

        String query = "SELECT * FROM users where username ='" + username + "' and password = '" + password + "'  ";
        
        try {
            if(username != null || password != null){          
               db.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
               db.myStmt = db.myConn.createStatement();
               db.myStmt.executeQuery(query);            
               MainFrameBoss mainFrameBoss = new MainFrameBoss();
               mainFrameBoss.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Fälten får inte vara tomma.");
            }
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Det gick inte att logga in");
            return false;
        }            
    }
    
}
