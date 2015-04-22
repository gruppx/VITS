/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Gaspar
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    
    
    public static String currentLoggedInID;
    
    public LogIn() {
        initComponents();
        Internet();
        this.getRootPane().setDefaultButton(btn_login);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_loginUser = new javax.swing.JTextField();
        pass_loginPassword = new javax.swing.JPasswordField();
        label_loginUsername = new javax.swing.JLabel();
        label_loginPassword = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        btn_writeReport = new javax.swing.JButton();
        label_offline = new javax.swing.JLabel();
        label_welcome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pass_loginPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass_loginPasswordKeyPressed(evt);
            }
        });

        label_loginUsername.setText("Username");

        label_loginPassword.setText("Password");

        btn_login.setText("Log in");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_writeReport.setText("Write a report!");
        btn_writeReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_writeReportActionPerformed(evt);
            }
        });

        label_offline.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_offline.setText("You do not have internet");

        label_welcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_welcome.setText("Welcome to");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/logga.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(label_welcome))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_login))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_loginUser, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_loginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass_loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_offline, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btn_writeReport)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(label_welcome)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(label_loginUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_loginUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_loginPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pass_loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btn_login)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_writeReport)
                    .addComponent(label_offline, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Showbtn(){
    
        label_offline.setVisible(true);
        btn_writeReport.setVisible(true);
    
    }
    
    private void Hidebtn(){
    
        label_offline.setVisible(false);
        btn_writeReport.setVisible(false);
    }
    
    
    
    public boolean Internet() { 
    try {                                                                                                                                                                                                                                 
        final URL url = new URL("http://www.google.com");                                                                                                                                                                                 
        final URLConnection check = url.openConnection();                                                                                                                                                                                  
             check.connect();
               System.out.println("har internet");      
               Hidebtn();
                       
    }   
    catch (MalformedURLException e) { 
        System.out.println("Har inte internet");
        Showbtn();
        throw new RuntimeException(e);                                                                                                                                                                                                    
    } catch (IOException e) {                
        System.out.println("har inte internet");
           return false;                                                                                                                                                                                                                   
    }    
       return false;         
 }  

    
    
    
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String username = txt_loginUser.getText();
        String password = pass_loginPassword.getText();
        
        if(Validation.logInCheck(username, password)){
            this.dispose();
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_writeReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_writeReportActionPerformed
       MainFrameBoss Mainframe = new MainFrameBoss();
        Mainframe.show();   
            Mainframe.fillReport.setVisible(true);
               Mainframe.NoInternetAccess();
// TODO add your handling code here:
    }//GEN-LAST:event_btn_writeReportActionPerformed

    private void pass_loginPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_loginPasswordKeyPressed
if(evt.getKeyCode() ==KeyEvent.VK_ENTER){      
    String username = txt_loginUser.getText();
        String password = pass_loginPassword.getText();
        
        if(Validation.logInCheck(username, password)){
            this.dispose();
        }
    
}
    }//GEN-LAST:event_pass_loginPasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_writeReport;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_loginPassword;
    private javax.swing.JLabel label_loginUsername;
    private javax.swing.JLabel label_offline;
    private javax.swing.JLabel label_welcome;
    private javax.swing.JPasswordField pass_loginPassword;
    private javax.swing.JTextField txt_loginUser;
    // End of variables declaration//GEN-END:variables
}
