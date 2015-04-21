/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import static Project.Validation.db;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaspar
 */
public class NewReportsTrAd extends javax.swing.JInternalFrame {

    static ConnectionClass db = new ConnectionClass();
    
    
    /**
     * Creates new form BossFrame
     */
    public NewReportsTrAd() {
        initComponents();
        
    }
    
    
    public void updateReportList(){
        db.myConn = null;
        db.myStmt = null;
        
        String currID = LogIn.currentLoggedInID;
        
        
        String[] columnNames = {"ID", "Sender", "Date"};
        
        
        String query = "SELECT Report.ReportID as rID, Users.Name as senderName, Report.Date as rDate "
                + "FROM Report "
                + "JOIN Users on Users.UserID = Report.SenderID "
                + "WHERE Report.ReceiverID = " + currID + " "
                + "AND Report.Approved = 0 "
                + "AND Report.Sent = 1";
        try {               
            db.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
            Statement statement = db.myConn.createStatement();
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
        db.myConn = null;
        db.myStmt = null;
        
        String currID = LogIn.currentLoggedInID;
        
        
        String[] columnNames = {"ID", "Sender", "Amount"};
        
        
        String query = "SELECT traveladvances.TrAdID as tID, Users.Name as senderName, traveladvances.Amount as amount "
                + "FROM traveladvances "
                + "JOIN Users on Users.UserID = traveladvances.SenderID "
                + "WHERE traveladvances.ReceiverID = " + currID + " "
                + "AND traveladvances.Approved = 0";
        try {               
            db.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vitsdb","root","masterkey");
            Statement statement = db.myConn.createStatement();
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

        label_listReports.setText("Reports");

        btn_approveReport.setText("Approve");
        btn_approveReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveReportActionPerformed(evt);
            }
        });

        btn_denyReport.setText("Deny");
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

        btn_denyTravelAdvance.setText("Deny");
        btn_denyTravelAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_denyTravelAdvanceActionPerformed(evt);
            }
        });

        btn_approveTravelAdvance.setText("Approve");
        btn_approveTravelAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveTravelAdvanceActionPerformed(evt);
            }
        });

        label_listTravelAdvance.setText("Travel advances");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btn_approveReport)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_denyReport, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label_listReports, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btn_approveTravelAdvance)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_denyTravelAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label_listTravelAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_listReports)
                    .addComponent(label_listTravelAdvance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_denyTravelAdvance)
                        .addComponent(btn_approveTravelAdvance))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_denyReport)
                        .addComponent(btn_approveReport)))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approveReport;
    private javax.swing.JButton btn_approveTravelAdvance;
    private javax.swing.JButton btn_denyReport;
    private javax.swing.JButton btn_denyTravelAdvance;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_listReports;
    private javax.swing.JLabel label_listTravelAdvance;
    private javax.swing.JTable table_reportList;
    private javax.swing.JTable table_travelAdvanceList;
    // End of variables declaration//GEN-END:variables
}
