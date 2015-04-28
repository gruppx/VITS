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
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainFrameBoss extends javax.swing.JFrame {  
    ConnectionClass db;
    
    AddAssigment addAss;
    AddReport addReport;
    AddTravelAdvances addTravelAdvances;
    FillReport fillReport;
    ManageUsers manageUser;
    ManageDocuments manageDocuments;
    Search search;
    WriteTravelOrdre writeTravelOrdre;
    String UserID;
    String UserName;
       
    public MainFrameBoss() {
        initComponents();
        
        addAllFramesToPane();
        CurrentDate();
        
        db = new ConnectionClass();
    }
    
    
    public void setLoggedInBossInfo(String loggedInName, String loggedInID){
        
        label_loggedInName.setText(loggedInName);
        label_loggedInBossID.setText(loggedInID);
        LogIn.currentLoggedInID = loggedInID;
        UserID = loggedInID;
        UserName = loggedInName;
    }
    
    public void NoInternetAccess(){
    
              btn_manageDocuments.setVisible(false);
                btn_manageUsers.setVisible(false);
                 btn_addAssignment.setVisible(false);
                  btn_writeNewTravelAdvance.setVisible(false);
                   btn_search.setVisible(false);
                    jButton2.setVisible(false);
                     fillReport.show();
                      label_loggedInBossID.setText(UserName);
                      label_loggedInName.setText(UserID);
                     

                     
    }
    
    public void CurrentDate(){
        
        
        Thread clock = new Thread(){
        
            public void run(){
              for(;;){
                  Calendar cal = new GregorianCalendar();
                  int year = cal.get(Calendar.YEAR);
                  int month = cal.get(Calendar.MONTH);
                  int day = cal.get(Calendar.DAY_OF_MONTH);
                  txt_currDate.setText("Date:  " + year + "/" + (month+1) + "/" +day);
                     
                  
                  
                  
                     
                     int second = cal.get(Calendar.SECOND);
                     int minute = cal.get(Calendar.MINUTE);
                     int hour = cal.get(Calendar.HOUR);
                     txt_currTime.setText("Time:  " + hour + ":" + (minute) + ":" +second);
                    
                     
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPanel = new javax.swing.JDesktopPane();
        btn_manageDocuments = new javax.swing.JButton();
        btn_writeNewReport = new javax.swing.JButton();
        btn_writeNewTravelAdvance = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_addAssignment = new javax.swing.JButton();
        btn_manageUsers = new javax.swing.JButton();
        label_loggedInBossID = new javax.swing.JLabel();
        label_loggedInName = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        txt_currDate = new javax.swing.JMenu();
        txt_currTime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        javax.swing.GroupLayout desktopPanelLayout = new javax.swing.GroupLayout(desktopPanel);
        desktopPanel.setLayout(desktopPanelLayout);
        desktopPanelLayout.setHorizontalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPanelLayout.setVerticalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        btn_manageDocuments.setText("Manage documents");
        btn_manageDocuments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageDocumentsActionPerformed(evt);
            }
        });

        btn_writeNewReport.setText("Write new report");
        btn_writeNewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_writeNewReportActionPerformed(evt);
            }
        });

        btn_writeNewTravelAdvance.setText("Write new travel advance");
        btn_writeNewTravelAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_writeNewTravelAdvanceActionPerformed(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_addAssignment.setText("Add assignment");
        btn_addAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addAssignmentActionPerformed(evt);
            }
        });

        btn_manageUsers.setText("Manage users");
        btn_manageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageUsersActionPerformed(evt);
            }
        });

        label_loggedInBossID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_loggedInBossID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_loggedInBossID.setLabelFor(label_loggedInBossID);
        label_loggedInBossID.setText("ID");
        label_loggedInBossID.setToolTipText("");

        label_loggedInName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_loggedInName.setLabelFor(label_loggedInName);
        label_loggedInName.setText("Name");

        jButton2.setText("Write new travel order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_currDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(txt_currDate);

        txt_currTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(txt_currTime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPanel)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_loggedInBossID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_manageDocuments)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_manageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_addAssignment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_writeNewReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_writeNewTravelAdvance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_loggedInName, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_loggedInName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_manageDocuments)
                    .addComponent(btn_writeNewReport)
                    .addComponent(btn_writeNewTravelAdvance)
                    .addComponent(btn_search)
                    .addComponent(btn_addAssignment)
                    .addComponent(btn_manageUsers)
                    .addComponent(jButton2)
                    .addComponent(label_loggedInBossID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPanel))
        );

        label_loggedInBossID.getAccessibleContext().setAccessibleName("txt_loggedInName");
        label_loggedInName.getAccessibleContext().setAccessibleName("txt_loggedInID");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addAssignmentActionPerformed
        hideAllFrames();
        showAddAss();
    }//GEN-LAST:event_btn_addAssignmentActionPerformed

    private void btn_manageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageUsersActionPerformed
        hideAllFrames();
        showManageUser();
    }//GEN-LAST:event_btn_manageUsersActionPerformed

    private void btn_writeNewTravelAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_writeNewTravelAdvanceActionPerformed
        hideAllFrames();
        showAddTravelAdvances();
        
    }//GEN-LAST:event_btn_writeNewTravelAdvanceActionPerformed

    private void btn_manageDocumentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageDocumentsActionPerformed
        hideAllFrames();
        showNewReports();
        manageDocuments.updateReportList();
        manageDocuments.updateTravelAdvancesList();
    }//GEN-LAST:event_btn_manageDocumentsActionPerformed

    private void btn_writeNewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_writeNewReportActionPerformed
        hideAllFrames();
        showFillReport();
    }//GEN-LAST:event_btn_writeNewReportActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        hideAllFrames();
        showSearch();
    }//GEN-LAST:event_btn_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        hideAllFrames();
        showWriteTravelOrdre();         
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrameBoss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameBoss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameBoss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameBoss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameBoss().setVisible(true);
            }
        });
    }

    
    
    private void addAllFramesToPane() {        
        addAss = new AddAssigment();
        desktopPanel.add(addAss);
        addReport = new AddReport();
        desktopPanel.add(addReport);
        addTravelAdvances = new AddTravelAdvances();
        desktopPanel.add(addTravelAdvances);
        fillReport = new FillReport();
        desktopPanel.add(fillReport);
        manageUser = new ManageUsers();
        desktopPanel.add(manageUser);
        manageDocuments = new ManageDocuments();
        desktopPanel.add(manageDocuments);
        search = new Search();
        desktopPanel.add(search);
        writeTravelOrdre = new WriteTravelOrdre();
        desktopPanel.add(writeTravelOrdre);
    }   
    
    private void showAddAss(){
        addAss.show();
        try {       
            addAss.setMaximum(true);
            addAss.setSelected(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());    // Ev. errormeddelande
        }
    }
    
    
    
    private void showAddReport(){
        addReport.show();
        try {   
            addReport.setMaximum(true);
            addReport.setSelected(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());    // Ev. errormeddelande
        }
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
    
    private void showFillReport(){
        fillReport.show();
        try {     
            fillReport.setMaximum(true);
            fillReport.setSelected(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());    // Ev. errormeddelande
        }
    }
    
    private void showManageUser(){
        manageUser.show();
        try {       
            manageUser.setMaximum(true);
            manageUser.setSelected(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());    // Ev. errormeddelande
        }
   
           
    }
    private void showNewReports(){
        manageDocuments.show();
        try {
            manageDocuments.setMaximum(true);
            manageDocuments.setSelected(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());    // Ev. errormeddelande
        }
    }   
    
    private void showSearch(){
         search.show();
         try {
             search.setMaximum(true);
             search.setSelected(rootPaneCheckingEnabled);
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
    
    
    private void hideAllFrames(){        
        try {  
                addAss.hide();
                addReport.hide();
                addTravelAdvances.hide();
                fillReport.hide();
                manageUser.hide();
                manageDocuments.hide();
                writeTravelOrdre.hide();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addAssignment;
    private javax.swing.JButton btn_manageDocuments;
    private javax.swing.JButton btn_manageUsers;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_writeNewReport;
    private javax.swing.JButton btn_writeNewTravelAdvance;
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel label_loggedInBossID;
    private javax.swing.JLabel label_loggedInName;
    private javax.swing.JMenu txt_currDate;
    private javax.swing.JMenu txt_currTime;
    // End of variables declaration//GEN-END:variables
}

