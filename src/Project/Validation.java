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
        
        boolean logInStatus = false;
        
        String query = "SELECT * FROM users where username ='" + username + "' and password = '" + password + "'";
        if(username.length() != 0 && password.length() != 0){
            try {               
                db.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
                Statement statement = db.myConn.createStatement();
                ResultSet rs = statement.executeQuery(query);
                
                if(rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String user = rs.getString(4);
                    String pass = rs.getString(5);
                    int status = rs.getInt(6);
                    MainFrameBoss mainFrameBoss = new MainFrameBoss();
                    MainFrameConsultant mainFrameConsultant = new MainFrameConsultant();
                    LogIn Login = new LogIn();
                    
                    if(username.equals(user) && password.equals(pass)){
                        if(status == 1){
                            JOptionPane.showMessageDialog(null, "Logged in as boss!");
                            if(Login.Internet() == false){
                            mainFrameBoss.setVisible(true);
                            mainFrameBoss.NoInternetAccess();
                            mainFrameBoss.setLoggedInBossInfo(name+" "+"Dont have internet", String.valueOf(id));
                            
                            }
                            else if (Login.Internet() == true){                           
                              mainFrameBoss.setVisible(true);
                               mainFrameBoss.setLoggedInBossInfo(name, String.valueOf(id));
                            }                             
                            logInStatus = true;
                            
                            
                          
                        }
                        else if(status == 0){
                            if (Login.Internet() == false) {
                                mainFrameConsultant.setVisible(true);
                                mainFrameConsultant.NoInternet();
                                mainFrameConsultant.setLoggedInConsultantInfo(name +" "+ "Dont have internet", String.valueOf(id));
                            }
                            else if (Login.Internet() == true) {
                            mainFrameConsultant.setVisible(true);
                            mainFrameConsultant.setLoggedInConsultantInfo(name, String.valueOf(id));
                            }
                            
                            JOptionPane.showMessageDialog(null, "Logged in as consultant!");           
                            mainFrameConsultant.setVisible(true);                         
                            logInStatus = true;
                        }                        
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong password or username!");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }     
        }
        else{
            JOptionPane.showMessageDialog(null, "The fields cannot be empty!");
        }
        return logInStatus;
    }
    
    static public boolean checkEmail(String email){
        boolean ok = false;
        
        String pattern = "^[A-Za-z0-9_.]+[@][A-Za-z]+\\.+[A-Za-z]+$";
        
        if(email.matches(pattern)){
            ok = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter a valid email.");
        }
        return ok;
    }
    
    static public boolean validateUser(String name, String email, String user, String pass){
        boolean ok = false;
        
        if(name.isEmpty() && email.isEmpty() && user.isEmpty() && pass.isEmpty()){
            JOptionPane.showMessageDialog(null, "The fields cannot be empty!");
        }
        else if(checkEmail(email)){
            ok = true;
        }
        
        return ok;
    }
    
}
