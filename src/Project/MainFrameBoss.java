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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainFrameBoss extends javax.swing.JFrame {  
    ConnectionClass db;
    
    AddAssigment addAss;
    AddNewUser addNewUser;
    AddReport addReport;
    AddTravelAdvances addTravelAdvances;
    FillReport fillReport;
    ManageUser manageUser;
    NewReports newReports;
    Search search;   
    public static String currentBossID;
       
    public MainFrameBoss() {
        initComponents();
        
        addAllFramesToPane();
        
        db = new ConnectionClass();
        try {
            db.ConnectToDb();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrameBoss.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void setLoggedInBossInfo(String loggedInName, String loggedInID){
        label_loggedInName.setText(loggedInName);
        label_loggedInBossID.setText(loggedInID);
        currentBossID = loggedInID;
    }
    
    public void NoInternetAccess(){
    
              btn_showNewReports.setVisible(false);
               btn_addNewUser.setVisible(false);
                btn_manageUser.setVisible(false);
                 btn_addAssignment.setVisible(false);
                  btn_writeNewTravelAdvance.setVisible(false);
                   btn_search.setVisible(false);
                           
                    label_loggedInName.setText("No internet access");
                      
        
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPanel = new javax.swing.JDesktopPane();
        btn_showNewReports = new javax.swing.JButton();
        btn_addNewUser = new javax.swing.JButton();
        btn_writeNewReport = new javax.swing.JButton();
        btn_writeNewTravelAdvance = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_addAssignment = new javax.swing.JButton();
        btn_manageUser = new javax.swing.JButton();
        label_loggedInBossID = new javax.swing.JLabel();
        label_loggedInName = new javax.swing.JLabel();

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
            .addGap(0, 516, Short.MAX_VALUE)
        );

        btn_showNewReports.setText("Show new reports");
        btn_showNewReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showNewReportsActionPerformed(evt);
            }
        });

        btn_addNewUser.setText("Add new user");
        btn_addNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addNewUserActionPerformed(evt);
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

        btn_manageUser.setText("Manage User");
        btn_manageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageUserActionPerformed(evt);
            }
        });

        label_loggedInBossID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_loggedInBossID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_loggedInBossID.setLabelFor(label_loggedInBossID);
        label_loggedInBossID.setText("jLabel1");
        label_loggedInBossID.setToolTipText("");

        label_loggedInName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_loggedInName.setLabelFor(label_loggedInName);
        label_loggedInName.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktopPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_showNewReports)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_addNewUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_manageUser, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(btn_addAssignment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_writeNewReport)
                        .addGap(18, 18, 18)
                        .addComponent(btn_writeNewTravelAdvance)
                        .addGap(63, 63, 63)
                        .addComponent(btn_search))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_loggedInName, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_loggedInBossID, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_loggedInBossID)
                    .addComponent(label_loggedInName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_showNewReports)
                    .addComponent(btn_addNewUser)
                    .addComponent(btn_writeNewReport)
                    .addComponent(btn_writeNewTravelAdvance)
                    .addComponent(btn_search)
                    .addComponent(btn_addAssignment)
                    .addComponent(btn_manageUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(desktopPanel)
                .addContainerGap())
        );

        label_loggedInBossID.getAccessibleContext().setAccessibleName("txt_loggedInName");
        label_loggedInName.getAccessibleContext().setAccessibleName("txt_loggedInID");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addAssignmentActionPerformed
        hideAllFrames();
        showAddAss();
    }//GEN-LAST:event_btn_addAssignmentActionPerformed

    private void btn_manageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageUserActionPerformed
        hideAllFrames();
        showManageUser();
    }//GEN-LAST:event_btn_manageUserActionPerformed

    private void btn_writeNewTravelAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_writeNewTravelAdvanceActionPerformed
        hideAllFrames();
        showAddTravelAdvances();
        
    }//GEN-LAST:event_btn_writeNewTravelAdvanceActionPerformed

    private void btn_showNewReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showNewReportsActionPerformed
        hideAllFrames();
        showNewReports();
        newReports.updateReportList();
    }//GEN-LAST:event_btn_showNewReportsActionPerformed

    private void btn_addNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addNewUserActionPerformed
        hideAllFrames();
        showAddNewUser();
    }//GEN-LAST:event_btn_addNewUserActionPerformed

    private void btn_writeNewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_writeNewReportActionPerformed
        hideAllFrames();
        showFillReport();
    }//GEN-LAST:event_btn_writeNewReportActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        hideAllFrames();
        showSearch();
    }//GEN-LAST:event_btn_searchActionPerformed

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
        addNewUser = new AddNewUser();
        desktopPanel.add(addNewUser);
        addReport = new AddReport();
        desktopPanel.add(addReport);
        addTravelAdvances = new AddTravelAdvances();
        desktopPanel.add(addTravelAdvances);
        fillReport = new FillReport();
        desktopPanel.add(fillReport);
        manageUser = new ManageUser();
        desktopPanel.add(manageUser);
        newReports = new NewReports();
        desktopPanel.add(newReports);
        search = new Search();
        desktopPanel.add(search);
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
    
    private void showAddNewUser(){
        addNewUser.show();
        try {       
            addNewUser.setMaximum(true);
            addNewUser.setSelected(rootPaneCheckingEnabled);
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
        newReports.show();
        try {
            newReports.setMaximum(true);
            newReports.setSelected(rootPaneCheckingEnabled);
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
    
    
    
    
    private void hideAllFrames(){        
        try {  
                addAss.hide();
                addNewUser.hide();
                addReport.hide();
                addTravelAdvances.hide();
                fillReport.hide();
                manageUser.hide();
                newReports.hide();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addAssignment;
    private javax.swing.JButton btn_addNewUser;
    private javax.swing.JButton btn_manageUser;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_showNewReports;
    private javax.swing.JButton btn_writeNewReport;
    private javax.swing.JButton btn_writeNewTravelAdvance;
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JLabel label_loggedInBossID;
    private javax.swing.JLabel label_loggedInName;
    // End of variables declaration//GEN-END:variables
}

