/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Validation {
    
    static ConnectionClass db = new ConnectionClass();
    
    static public boolean logInCheck(String username, String password){   
        db.myConn = null;
        db.myStmt = null;

        String query = "SELECT * FROM users where username ='" + username + "' and password = '" + password + "'";
        if(username.length() != 0 && password.length() != 0){
            try {               
                db.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
                Statement statement = db.myConn.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String user = rs.getString(4);
                    String pass = rs.getString(5);
                    int status = rs.getInt(6);
                    if(status == 1 && username.equals(user) && password.equals(pass)){
                        JOptionPane.showMessageDialog(null, "Inloggad som chef!");
                        MainFrameBoss mainFrameBoss = new MainFrameBoss();
                        mainFrameBoss.setVisible(true);
                        mainFrameBoss.setLoggedInInfo(name, String.valueOf(id));
                        mainFrameBoss.currentID = String.valueOf(id);
                        return true;
                    }
                    else if(status == 0 && username.equals(user) && password.equals(pass)){
                        JOptionPane.showMessageDialog(null, "Inloggad som konsult!");
                        MainFrameConsultant mainFrameConsultant = new MainFrameConsultant();
                        mainFrameConsultant.setVisible(true);
                        return true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Fel användarnamn eller lösenord!");
                        return false;
                    }
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }     
        }
        else{
            JOptionPane.showMessageDialog(null, "Fälten får inte vara tomma.");
            return false;
        }
        return false;
    }
}
