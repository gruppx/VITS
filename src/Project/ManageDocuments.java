/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import static Project.Validation.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaspar
 */
public class ManageDocuments extends javax.swing.JInternalFrame {

    static ConnectionClass db = new ConnectionClass();
    
     private Locale l; 
    
    /**
     * Creates new form BossFrame
     */
    public ManageDocuments() {
        initComponents();
        initializeLanguage();
        
    }
    
    
    public void updateReportList(){
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String currID = LogIn.currentLoggedInID;
        
        
        String[] columnNames = {"ID", "Sender", "Date"};
        
        String cbValue = cb_reports.getSelectedItem().toString();
        
        int status = 0;
        
        if(cbValue.equals("New")){
            status = 0;
            btn_approveReport.setEnabled(true);
            btn_denyReport.setEnabled(true);
        }
        else if(cbValue.equals("Approved")){
            status = 1;
            btn_approveReport.setEnabled(false);
            btn_denyReport.setEnabled(false);
        }
        else if(cbValue.equals("Denied")){
            status = 2;
            btn_approveReport.setEnabled(false);
            btn_denyReport.setEnabled(false);
        }
        
        
        
        String query = "SELECT Report.ReportID as rID, Users.Name as senderName, Report.Date as rDate "
                + "FROM Report "
                + "JOIN Users on Users.UserID = Report.SenderID "
                + "WHERE Report.ReceiverID = " + currID + " "
                + "AND Report.Approved = '" + status + "' "
                + "AND Report.Sent = 1";
        try {               
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
            Statement statement = myConn.createStatement();
            ResultSet rs = statement.executeQuery(query);
                                   
            ArrayList<Object[]> data = new ArrayList<>();            
            
            while (rs.next()) {
                int rID = rs.getInt(1);
                String senderName = rs.getString(2);
                String rDate = String.valueOf(rs.getDate(3));
                
                Object[] row = new Object[]{rID, senderName, rDate};
                data.add(row);                
            }
            
            Object[][] dataForTabell = data.toArray(new Object[data.size()][]);
            
            DefaultTableModel model = new DefaultTableModel(dataForTabell, columnNames){      //Lägger till resultaten (dataForTabell) och kolumnnamnen i tabellmodellen.
                @Override
                public boolean isCellEditable(int row, int column) {          // En inbyggd metod som tar bort möjligheten till redigering i tabeller
                    return false;
                }
            };
            table_reportList.setModel(model);
            table_reportListDesign();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }     
        
    }
    
    /*DefaultTableModel model = new DefaultTableModel(null, columnNames);
                table_reportList.setModel(model);
                table_reportListDesign();*/
    
    
    private void table_reportListDesign()
    {
        table_reportList.getColumn("ID").setMaxWidth(30);
        table_reportList.getColumn("Sender").setMaxWidth(150);
        table_reportList.getColumn("Date").setMaxWidth(100);
    }
    
    public void updateTravelAdvancesList(){
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String currID = LogIn.currentLoggedInID;
        
        
        String[] columnNames = {"ID", "Sender", "Amount"};
        
        
        String cbValue = cb_travelAdvances.getSelectedItem().toString();
        
        String status = "";
        
        if(cbValue.equals("New")){
            status = "0";
            btn_approveTravelAdvance.setEnabled(true);
            btn_denyTravelAdvance.setEnabled(true);
        }
        else if(cbValue.equals("Approved")){
            status = "1";
            btn_approveTravelAdvance.setEnabled(false);
            btn_denyTravelAdvance.setEnabled(false);
        }
        else if(cbValue.equals("Denied")){
            status = "2";
            btn_approveTravelAdvance.setEnabled(false);
            btn_denyTravelAdvance.setEnabled(false);
        }
        
        
        
        String query = "SELECT traveladvances.TrAdID as tID, Users.Name as senderName, traveladvances.Amount as amount "
                + "FROM traveladvances "
                + "JOIN Users on Users.UserID = traveladvances.SenderID "
                + "WHERE traveladvances.ReceiverID = " + currID + " "
                + "AND traveladvances.Approved = "+ status +"";
        try {               
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
            Statement statement = myConn.createStatement();
            ResultSet rs = statement.executeQuery(query);
                                   
            ArrayList<Object[]> data = new ArrayList<>();            
            
            while (rs.next()) {
                int tID = rs.getInt(1);
                String senderName = rs.getString(2);
                String amount = String.valueOf(rs.getInt(3));
                
                Object[] row = new Object[]{tID, senderName, amount};
                data.add(row);                
            }
            
            Object[][] dataForTabell = data.toArray(new Object[data.size()][]);
            
            DefaultTableModel model = new DefaultTableModel(dataForTabell, columnNames){      //Lägger till resultaten (dataForTabell) och kolumnnamnen i tabellmodellen.
                @Override
                public boolean isCellEditable(int row, int column) {          // En inbyggd metod som tar bort möjligheten till redigering i tabeller
                    return false;
                }
            };
            table_travelAdvanceList.setModel(model);
            table_travelAdvancesListDesign();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }     
        
    }
    
    private void table_travelAdvancesListDesign()
    {
        table_travelAdvanceList.getColumn("ID").setMaxWidth(30);
        table_travelAdvanceList.getColumn("Sender").setMaxWidth(150);
        table_travelAdvanceList.getColumn("Amount").setMaxWidth(100);
    }
    
    public void approveReport() {
        String rID;
        int selectedRow = table_reportList.getSelectedRow();
        
        if(selectedRow != -1) {    // om inte värdet är utanför (ingen markerad rad)
            rID  = table_reportList.getValueAt(selectedRow,0).toString();    // hämtar värdet från vald rad i kolumn 0
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Du måste välja en rad.");    // Om rad inte är vald, talar om detta 
            rID = "";
        }
        
        String query = "UPDATE report SET Approved = 1 WHERE ReportID = " + rID;
        
        try {               
            db.query(query);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }     
    }
    
    public void approveTravelAdvance() {
        String TrAdID;
        int selectedRow = table_travelAdvanceList.getSelectedRow();
        
        if(selectedRow != -1) {    // om inte värdet är utanför (ingen markerad rad)
            TrAdID  = table_travelAdvanceList.getValueAt(selectedRow,0).toString();    // hämtar värdet från vald rad i kolumn 0
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Du måste välja en rad.");    // Om rad inte är vald, talar om detta 
            TrAdID = "";
        }
        
        String query = "UPDATE traveladvances SET Approved = 1 WHERE TrAdID = " + TrAdID;
        
        try {               
            db.query(query);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }     
    }
    
    public void denyReport() {
        String rID;
        int selectedRow = table_reportList.getSelectedRow();
        
        if(selectedRow != -1) {    // om inte värdet är utanför (ingen markerad rad)
            rID  = table_reportList.getValueAt(selectedRow,0).toString();    // hämtar värdet från vald rad i kolumn 0
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Du måste välja en rad.");    // Om rad inte är vald, talar om detta 
            rID = "";
        }
        
        String query = "UPDATE report SET Approved = 2 WHERE ReportID = " + rID;
        
        try {               
            db.query(query);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }     
    }
    
    public void denyTravelAdvance() {
        String TrAdID;
        int selectedRow = table_travelAdvanceList.getSelectedRow();
        
        if(selectedRow != -1) {    // om inte värdet är utanför (ingen markerad rad)
            TrAdID  = table_travelAdvanceList.getValueAt(selectedRow,0).toString();    // hämtar värdet från vald rad i kolumn 0
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Du måste välja en rad.");    // Om rad inte är vald, talar om detta 
            TrAdID = "";
        }
        
        String query = "UPDATE traveladvances SET Approved = 2 WHERE TrAdID = " + TrAdID;
        
        try {               
            db.query(query);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }     
    }
    private void initializeLanguage(){
        l = LogIn.getString();
         
        ResourceBundle r = ResourceBundle.getBundle("Project/Bundle", l);
        
        label_listTravelAdvance.setText(r.getString("ManageDocuments.label_listTravelAdvance.text"));
         btn_approveTravelAdvance.setText(r.getString("ManageDocuments.btn_approveTravelAdvance.text"));
          btn_denyTravelAdvance.setText(r.getString("ManageDocuments.btn_denyTravelAdvance.text"));
           btn_denyReport.setText(r.getString("ManageDocuments.btn_denyReport.text"));
            btn_approveReport.setText(r.getString("ManageDocuments.btn_approveReport.text"));
             label_listReports.setText(r.getString("ManageDocuments.label_listReports.text"));
    }
               
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_listReports = new javax.swing.JLabel();
        btn_approveReport = new javax.swing.JButton();
        btn_denyReport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_reportList = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_travelAdvanceList = new javax.swing.JTable();
        btn_denyTravelAdvance = new javax.swing.JButton();
        btn_approveTravelAdvance = new javax.swing.JButton();
        label_listTravelAdvance = new javax.swing.JLabel();
        cb_reports = new javax.swing.JComboBox();
        cb_travelAdvances = new javax.swing.JComboBox();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Project/Bundle"); // NOI18N
        setTitle(bundle.getString("ManageDocuments.title")); // NOI18N
        setToolTipText(bundle.getString("ManageDocuments.toolTipText")); // NOI18N

        label_listReports.setText(bundle.getString("ManageDocuments.label_listReports.text")); // NOI18N

        btn_approveReport.setText(bundle.getString("ManageDocuments.btn_approveReport.text")); // NOI18N
        btn_approveReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveReportActionPerformed(evt);
            }
        });

        btn_denyReport.setText(bundle.getString("ManageDocuments.btn_denyReport.text")); // NOI18N
        btn_denyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_denyReportActionPerformed(evt);
            }
        });

        table_reportList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(table_reportList);

        table_travelAdvanceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane3.setViewportView(table_travelAdvanceList);

        btn_denyTravelAdvance.setText(bundle.getString("ManageDocuments.btn_denyTravelAdvance.text")); // NOI18N
        btn_denyTravelAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_denyTravelAdvanceActionPerformed(evt);
            }
        });

        btn_approveTravelAdvance.setText(bundle.getString("ManageDocuments.btn_approveTravelAdvance.text")); // NOI18N
        btn_approveTravelAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveTravelAdvanceActionPerformed(evt);
            }
        });

        label_listTravelAdvance.setText(bundle.getString("ManageDocuments.label_listTravelAdvance.text")); // NOI18N

        cb_reports.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "New", "Approved", "Denied" }));
        cb_reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_reportsActionPerformed(evt);
            }
        });

        cb_travelAdvances.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "New", "Approved", "Denied" }));
        cb_travelAdvances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_travelAdvancesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_approveTravelAdvance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_denyTravelAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_listReports, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_reports, 0, 300, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_approveReport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_denyReport, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_listTravelAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cb_travelAdvances, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_listReports)
                    .addComponent(label_listTravelAdvance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_reports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_travelAdvances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_denyTravelAdvance)
                    .addComponent(btn_approveTravelAdvance)
                    .addComponent(btn_denyReport)
                    .addComponent(btn_approveReport))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_denyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_denyReportActionPerformed
        denyReport();
        updateReportList();
    }//GEN-LAST:event_btn_denyReportActionPerformed

    private void btn_denyTravelAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_denyTravelAdvanceActionPerformed
        denyTravelAdvance();
        updateTravelAdvancesList();
    }//GEN-LAST:event_btn_denyTravelAdvanceActionPerformed

    private void btn_approveReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveReportActionPerformed
        approveReport();
        updateReportList();
    }//GEN-LAST:event_btn_approveReportActionPerformed

    private void btn_approveTravelAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveTravelAdvanceActionPerformed
        approveTravelAdvance();
        updateTravelAdvancesList();
    }//GEN-LAST:event_btn_approveTravelAdvanceActionPerformed

    private void cb_reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_reportsActionPerformed
        updateReportList();
    }//GEN-LAST:event_cb_reportsActionPerformed

    private void cb_travelAdvancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_travelAdvancesActionPerformed
        updateTravelAdvancesList();
    }//GEN-LAST:event_cb_travelAdvancesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approveReport;
    private javax.swing.JButton btn_approveTravelAdvance;
    private javax.swing.JButton btn_denyReport;
    private javax.swing.JButton btn_denyTravelAdvance;
    private javax.swing.JComboBox cb_reports;
    private javax.swing.JComboBox cb_travelAdvances;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_listReports;
    private javax.swing.JLabel label_listTravelAdvance;
    private javax.swing.JTable table_reportList;
    private javax.swing.JTable table_travelAdvanceList;
    // End of variables declaration//GEN-END:variables
}
