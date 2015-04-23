/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaspar
 */
public class Search extends javax.swing.JInternalFrame {
    ConnectionClass db = new ConnectionClass();
    /**
     * Creates new form InternalFrameSearch
     */
    public Search() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_search = new javax.swing.JTextField();
        btn_searchConsultant = new javax.swing.JButton();
        label_searchConsultant = new javax.swing.JLabel();
        btn_saveReportToPDF = new javax.swing.JButton();
        cbox_alternative = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        panel_user = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_userID = new javax.swing.JLabel();
        txt_name = new javax.swing.JLabel();
        txt_email = new javax.swing.JLabel();
        txt_username = new javax.swing.JLabel();
        txt_password = new javax.swing.JLabel();
        txt_status = new javax.swing.JLabel();
        panel_report = new javax.swing.JPanel();
        label_reportInformation = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_reportID = new javax.swing.JLabel();
        txt_senderID = new javax.swing.JLabel();
        txt_receiverID = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        txt_sent = new javax.swing.JLabel();
        txt_approved = new javax.swing.JLabel();
        txt_assignment = new javax.swing.JLabel();
        panel_assignment = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_assID = new javax.swing.JLabel();
        txt_aName = new javax.swing.JLabel();
        txt_aInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_result = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_reports = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_assignments = new javax.swing.JTable();

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        btn_searchConsultant.setText("List All");
        btn_searchConsultant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchConsultantActionPerformed(evt);
            }
        });

        label_searchConsultant.setText("Search:");

        btn_saveReportToPDF.setText("Save to PDF");

        cbox_alternative.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Users", "Report", "Assignment" }));

        panel_user.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("User information");

        jLabel3.setText("User ID:");

        jLabel4.setText("Full name:");

        jLabel5.setText("Email:");

        jLabel6.setText("Username:");

        jLabel7.setText("Password:");

        jLabel8.setText("Status:");

        txt_userID.setText("jLabel9");

        txt_name.setText("jLabel10");

        txt_email.setText("jLabel11");

        txt_username.setText("jLabel12");

        txt_password.setText("jLabel13");

        txt_status.setText("jLabel14");

        javax.swing.GroupLayout panel_userLayout = new javax.swing.GroupLayout(panel_user);
        panel_user.setLayout(panel_userLayout);
        panel_userLayout.setHorizontalGroup(
            panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_userLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panel_userLayout.createSequentialGroup()
                        .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(47, 47, 47)
                        .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_status)
                            .addComponent(txt_password)
                            .addComponent(txt_username)
                            .addComponent(txt_email)
                            .addComponent(txt_name)
                            .addComponent(txt_userID))))
                .addGap(164, 164, 164))
        );
        panel_userLayout.setVerticalGroup(
            panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_userID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_password))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_status))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel_report.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_reportInformation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_reportInformation.setText("Report information:");

        jLabel9.setText("Report ID:");

        jLabel10.setText("Sender ID:");

        jLabel11.setText("Receiver ID:");

        jLabel12.setText("Date:");

        jLabel13.setText("Sent:");

        jLabel14.setText("Approved:");

        jLabel15.setText("Assignment:");

        txt_reportID.setText("jLabel21");

        txt_senderID.setText("jLabel22");

        txt_receiverID.setText("jLabel23");

        txt_date.setText("jLabel24");

        txt_sent.setText("jLabel25");

        txt_approved.setText("jLabel26");

        txt_assignment.setText("jLabel27");

        javax.swing.GroupLayout panel_reportLayout = new javax.swing.GroupLayout(panel_report);
        panel_report.setLayout(panel_reportLayout);
        panel_reportLayout.setHorizontalGroup(
            panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_reportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_reportInformation)
                    .addGroup(panel_reportLayout.createSequentialGroup()
                        .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(76, 76, 76)
                        .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_senderID)
                            .addComponent(txt_reportID)
                            .addComponent(txt_receiverID)
                            .addComponent(txt_assignment)
                            .addComponent(txt_approved)
                            .addComponent(txt_date)
                            .addComponent(txt_sent))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel_reportLayout.setVerticalGroup(
            panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_reportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_reportInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_reportID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_senderID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_receiverID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_sent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_approved))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_assignment))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_assignment.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Assignment information:");

        jLabel18.setText("Assignment ID:");

        jLabel19.setText("Name:");

        jLabel20.setText("Info:");

        txt_assID.setText("jLabel28");

        txt_aName.setText("jLabel29");

        txt_aInfo.setText("jLabel30");

        javax.swing.GroupLayout panel_assignmentLayout = new javax.swing.GroupLayout(panel_assignment);
        panel_assignment.setLayout(panel_assignmentLayout);
        panel_assignmentLayout.setHorizontalGroup(
            panel_assignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_assignmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_assignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_assignmentLayout.createSequentialGroup()
                        .addGroup(panel_assignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(panel_assignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_assID)
                            .addComponent(txt_aName)
                            .addComponent(txt_aInfo)))
                    .addComponent(jLabel17))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panel_assignmentLayout.setVerticalGroup(
            panel_assignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_assignmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_assignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_assID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_assignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_aName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_assignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_aInfo))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        list_result.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_resultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list_result);

        table_reports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Report ID", "Date", "Approved", "Sent"
            }
        ));
        jScrollPane2.setViewportView(table_reports);

        table_assignments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assignment ID", "Name"
            }
        ));
        jScrollPane3.setViewportView(table_assignments);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_searchConsultant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbox_alternative, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchConsultant, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 802, Short.MAX_VALUE)
                        .addComponent(btn_saveReportToPDF))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panel_assignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panel_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(361, 361, 361)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_searchConsultant)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_alternative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchConsultant)
                    .addComponent(btn_saveReportToPDF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_assignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchConsultantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchConsultantActionPerformed
        searchIt();         //rensar alla objekt i comboboxen
        
       
        
// TODO add your handling code here:
    }//GEN-LAST:event_btn_searchConsultantActionPerformed

    private void list_resultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_resultMouseClicked
        String namnet = list_result.getSelectedValue().toString();
        String theResult = "";
        String type = cbox_alternative.getSelectedItem().toString();
        if(type.equals("Users")){
        try{
            theResult = db.getString("select username from users where name = '"+namnet+"'");
            txt_username.setText(theResult);
            theResult = db.getString("select email from users where name = '"+namnet+"'");
            txt_email.setText(theResult);
            txt_name.setText(namnet);
            theResult = db.getString("select password from users where name = '"+namnet+"'");
            txt_password.setText(theResult);
            theResult = db.getString("select userid from users where name = '"+namnet+"'");
            txt_userID.setText(theResult);
            theResult = db.getString("select status from users where name = '"+namnet+"'");
            txt_status.setText(theResult);
            
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
        else if(type.equals("Assignment")){
            try{
                theResult = db.getString("select assignmentid from assignment where name = '"+namnet+"'");
            txt_assID.setText(theResult);
            txt_aName.setText(namnet);
            theResult = db.getString("select info from assignment where name = '"+namnet+"'");
            txt_aInfo.setText(theResult);
            }
            catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
        else if(type.equals("Report")){
            try{
                theResult = db.getString("select reportid from report where date = '"+namnet+"'");
            txt_reportID.setText(theResult);
            theResult = db.getString("select senderid from report where date = '"+namnet+"'");
            txt_senderID.setText(theResult);
            theResult = db.getString("select receiverID from report where date = '"+namnet+"'");
            txt_receiverID.setText(theResult);
            theResult = db.getString("select sent from report where date = '"+namnet+"'");
            txt_sent.setText(theResult);
            txt_date.setText(namnet);
            theResult = db.getString("select approved from report where date = '"+namnet+"'");
            txt_approved.setText(theResult);
            theResult = db.getString("select assignmentid from report where date = '"+namnet+"'");
            txt_assignment.setText(theResult);
            
            }
            catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
        getAssignments();
    }//GEN-LAST:event_list_resultMouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased

        searchIt();
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchKeyReleased

    private void getAssignments(){
        ResultSet rs = db.getColumn("select * from assignment");        
        ArrayList<Object[]> data = new ArrayList<>();
        String[] columnNames = {"ID", "Name"};
        try{
            while(rs.next()){
                int aID = rs.getInt(1);
                String name = rs.getString(2);
                Object[] row = new Object[]{aID, name};
                data.add(row);
            }
            Object[][] dataForTabell = data.toArray(new Object[data.size()][]);
            DefaultTableModel model = new DefaultTableModel(dataForTabell, columnNames){      //Lägger till resultaten (dataForTabell) och kolumnnamnen i tabellmodellen.
                @Override
                public boolean isCellEditable(int row, int column) {          // En inbyggd metod som tar bort möjligheten till redigering i tabeller
                    return false;
                }
            };
            table_assignments.setModel(model);
            table_assignmentsDesign();
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
    
    private void table_assignmentsDesign()
    {
        table_assignments.getColumn("ID").setMaxWidth(30);
        table_assignments.getColumn("Name").setMaxWidth(150);        
    }
    
    private void searchIt()    {
        String alternative = cbox_alternative.getSelectedItem().toString();
        String column = "name"; //standard för sökning av users
        String getUsers = "select * from users where username = '"+"'";
        int numOfAlternatives;
        
        if (alternative.equals("Assignment"))
        {
            column = "name";
        }
        else if(alternative.equals("Report"))
        {
            column = "ReportID";
        }
        
        try{
            DefaultListModel DLM = new DefaultListModel();
            ResultSet search = db.getColumn("select * from "+alternative+" where "+column+" like '"+txt_search.getText()+"%'");
            numOfAlternatives = db.getCount(alternative);
            while(search.next()) //Använd ALLTID while av denna typ! annars stöter du på "after end och result set"
            {
            DLM.addElement(search.getString(column));
            }
            list_result.setModel(DLM);
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_saveReportToPDF;
    private javax.swing.JButton btn_searchConsultant;
    private javax.swing.JComboBox cbox_alternative;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_reportInformation;
    private javax.swing.JLabel label_searchConsultant;
    private javax.swing.JList list_result;
    private javax.swing.JPanel panel_assignment;
    private javax.swing.JPanel panel_report;
    private javax.swing.JPanel panel_user;
    private javax.swing.JTable table_assignments;
    private javax.swing.JTable table_reports;
    private javax.swing.JLabel txt_aInfo;
    private javax.swing.JLabel txt_aName;
    private javax.swing.JLabel txt_approved;
    private javax.swing.JLabel txt_assID;
    private javax.swing.JLabel txt_assignment;
    private javax.swing.JLabel txt_date;
    private javax.swing.JLabel txt_email;
    private javax.swing.JLabel txt_name;
    private javax.swing.JLabel txt_password;
    private javax.swing.JLabel txt_receiverID;
    private javax.swing.JLabel txt_reportID;
    private javax.swing.JTextField txt_search;
    private javax.swing.JLabel txt_senderID;
    private javax.swing.JLabel txt_sent;
    private javax.swing.JLabel txt_status;
    private javax.swing.JLabel txt_userID;
    private javax.swing.JLabel txt_username;
    // End of variables declaration//GEN-END:variables
}
