/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author Gaspar
 */

import java.beans.PropertyVetoException;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class MainFrameConsultant extends javax.swing.JFrame {
    ConnectionClass db;
    
    AddTravelAdvances addTravelAdvances;   
    FillReport fillReport;
    WriteTravelOrdre writeTravelOrdre;
    
    private Locale l; 
    
    public MainFrameConsultant() {
        initComponents();
        addAllFramesToPane();
        CurrentDate();
        
        db = new ConnectionClass();
        initializeLanguage();
    }
    
    
    public void setLoggedInConsultantInfo(String loggedInName, String loggedInID){
        label_loggedInName.setText(loggedInName);
        label_loggedInID.setText(loggedInID);
        LogIn.currentLoggedInID = loggedInID;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPanel = new javax.swing.JDesktopPane();
        btn_newTravelAdvance = new javax.swing.JButton();
        btn_newReport = new javax.swing.JButton();
        label_loggedInName = new javax.swing.JLabel();
        label_loggedInID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        txt_Date = new javax.swing.JMenu();
        txt_Time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout desktopPanelLayout = new javax.swing.GroupLayout(desktopPanel);
        desktopPanel.setLayout(desktopPanelLayout);
        desktopPanelLayout.setHorizontalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPanelLayout.setVerticalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Project/Bundle"); // NOI18N
        btn_newTravelAdvance.setText(bundle.getString("MainFrameConsultant.btn_newTravelAdvance.text")); // NOI18N
        btn_newTravelAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newTravelAdvanceActionPerformed(evt);
            }
        });

        btn_newReport.setText(bundle.getString("MainFrameConsultant.btn_newReport.text")); // NOI18N
        btn_newReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newReportActionPerformed(evt);
            }
        });

        label_loggedInName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_loggedInName.setText(bundle.getString("MainFrameConsultant.label_loggedInName.text")); // NOI18N

        label_loggedInID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_loggedInID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_loggedInID.setText(bundle.getString("MainFrameConsultant.label_loggedInID.text")); // NOI18N
        label_loggedInID.setToolTipText(bundle.getString("MainFrameConsultant.label_loggedInID.toolTipText")); // NOI18N

        jButton1.setText(bundle.getString("MainFrameConsultant.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuBar1.add(txt_Date);
        jMenuBar1.add(txt_Time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPanel)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_loggedInName, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_loggedInID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_newTravelAdvance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_newReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(376, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_loggedInName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_newTravelAdvance)
                    .addComponent(btn_newReport)
                    .addComponent(jButton1)
                    .addComponent(label_loggedInID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPanel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newTravelAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newTravelAdvanceActionPerformed
        hideAllFrames();
        showAddTravelAdvances();
    }//GEN-LAST:event_btn_newTravelAdvanceActionPerformed

    private void btn_newReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newReportActionPerformed
        hideAllFrames();
        showFillReport();
    }//GEN-LAST:event_btn_newReportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
hideAllFrames();
showWriteTravelOrdre();       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrameConsultant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameConsultant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameConsultant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameConsultant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameConsultant().setVisible(true);
            }
        });
    }
    
    private void addAllFramesToPane() {      
        addTravelAdvances = new AddTravelAdvances();
        desktopPanel.add(addTravelAdvances);
        fillReport = new FillReport();
        desktopPanel.add(fillReport);
        writeTravelOrdre = new WriteTravelOrdre();
        desktopPanel.add(writeTravelOrdre);
    }   
    
    private void showAddTravelAdvances(){
        addTravelAdvances.show();
        try {
            addTravelAdvances.setMaximum(true);
            addTravelAdvances.setSelected(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());    // Ev. errormeddelande
        }
    }
        public void showWriteTravelOrdre(){
        writeTravelOrdre.show();
        try {
            writeTravelOrdre.setMaximum(true);
            writeTravelOrdre.setSelected(rootPaneCheckingEnabled);
        }catch (PropertyVetoException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());    // Ev. errormeddelande
        }
        }
    
    private void showFillReport(){
        fillReport.show();
        try {     
            fillReport.setMaximum(true);
            fillReport.setSelected(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());    // Ev. errormeddelande
        }
    }
    
    private void hideAllFrames(){        
        try {  
                addTravelAdvances.hide();
                fillReport.hide();
                writeTravelOrdre.hide();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
        
    }
    
    public void NoInternet(){
    
            btn_newTravelAdvance.setVisible(false);
             jButton1.setVisible(false);
             
    
    
    }
    
     private void initializeLanguage(){
        l = LogIn.getString();
         
        ResourceBundle r = ResourceBundle.getBundle("Project/Bundle", l);
        
        btn_newReport.setText(r.getString("MainFrameConsultant.btn_newReport.text"));
         btn_newTravelAdvance.setText(r.getString("MainFrameConsultant.btn_newTravelAdvance.text"));
          jButton1.setText(r.getString("MainFrameConsultant.jButton1.text"));
           label_loggedInID.setText(r.getString("MainFrameConsultant.label_loggedInID.text"));
            label_loggedInName.setText(r.getString("MainFrameConsultant.label_loggedInName.text"));
             
    }
    
    
    
    public void CurrentDate(){
        
        
        Thread clock = new Thread(){
        
            public void run(){
              for(;;){
                  Calendar cal = new GregorianCalendar();
                  int year = cal.get(Calendar.YEAR);
                  int month = cal.get(Calendar.MONTH);
                  int day = cal.get(Calendar.DAY_OF_MONTH);
                  txt_Date.setText("Date:  " + year + "/" + (month) + "/" +day);
                     
                  
                  
                  
                     
                     int second = cal.get(Calendar.SECOND);
                     int minute = cal.get(Calendar.MINUTE);
                     int hour = cal.get(Calendar.HOUR);
                     txt_Time.setText("Time:  " + hour + ":" + (minute) + ":" +second);
                    
                     
                  try {
                      sleep(1000);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(MainFrameBoss.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
            }
            
        };
        clock.start();
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_newReport;
    private javax.swing.JButton btn_newTravelAdvance;
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel label_loggedInID;
    private javax.swing.JLabel label_loggedInName;
    private javax.swing.JMenu txt_Date;
    private javax.swing.JMenu txt_Time;
    // End of variables declaration//GEN-END:variables
}
