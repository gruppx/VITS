/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Musse
 */
public class AddAssigment extends javax.swing.JInternalFrame {
ConnectionClass db = new ConnectionClass(); //skapar connection till databas
    /**
     * Creates new form NewJInternalFrame
     */
    public AddAssigment() {
        initComponents();
        String name = "";
        String info = "";
        
        fillAssignmentCMB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
            java.util.logging.Logger.getLogger(AddCountry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCountry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCountry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCountry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAssigment().setVisible(true);
                
                
            }
        });
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel_Name = new javax.swing.JLabel();
        jTextField_Name = new javax.swing.JTextField();
        jButton_AddAssigment = new javax.swing.JButton();
        jLabel_info = new javax.swing.JLabel();
        Remove_delete = new javax.swing.JButton();
        Combo_Assigment = new javax.swing.JComboBox();
        ShowInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField_info = new javax.swing.JTextArea();

        jButton1.setText("jButton1");

        setTitle("Add Assigment");

        jLabel_Name.setText("Name");

        jButton_AddAssigment.setText("Add");
        jButton_AddAssigment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddAssigmentActionPerformed(evt);
            }
        });

        jLabel_info.setText("Info");

        Remove_delete.setText("Remove");
        Remove_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remove_deleteActionPerformed(evt);
            }
        });

        Combo_Assigment.setName("assignmentsCMB"); // NOI18N

        ShowInfo.setText("Show info");
        ShowInfo.setName("jButton_showInfo"); // NOI18N
        ShowInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowInfoActionPerformed(evt);
            }
        });

        jTextField_info.setColumns(20);
        jTextField_info.setRows(5);
        jTextField_info.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_infoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextField_info);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_AddAssigment, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Remove_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Name)
                                    .addComponent(jLabel_info, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Combo_Assigment, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(54, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combo_Assigment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Name))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_info, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_AddAssigment)
                    .addComponent(Remove_delete))
                .addGap(36, 36, 36))
        );

        jLabel_Name.getAccessibleContext().setAccessibleName("jL-Name");

        setBounds(0, 0, 377, 351);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * lägger till en assigment till databasen och rensar text fälten efteråt
     */
    private void jButton_AddAssigmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddAssigmentActionPerformed
        try
        { 
            String Query = "insert into assignment(name, info) values('" + jTextField_Name.getText() + "', '" + jTextField_info.getText() + "')";
             db.query(Query);
             
             fillAssignmentCMB();
             
             jTextField_Name.setText("");
             jTextField_info.setText("");
        }
   
       /* query("insert into users(name, email, username, password, status) values ('niklas', 'niklas', 'niklas', 'nilkas', 3);");*/
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Det gick inte att lägga till ett assignment");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_AddAssigmentActionPerformed
    
    /**
     * Tar bort en vald assigment och tar alla referenser till den
     */
    private void Remove_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remove_deleteActionPerformed
        
        try
        {
            String assignment = Combo_Assigment.getSelectedItem().toString();
            
            String Query1 = "Delete Report, Assignment from Report join assignment on Report.AssignmentID = assignment.AssignmentID where assignment.name = '" + assignment + "';Delete receipt, assignment, Report from receipt join Report on Report.ReportID = receipt.ReportID join assignment on assignment.AssignmentID = Report.AssignmentID where assignment.name = '" + assignment + "'; Delete traveladvances, assignment from traveladvances join assignment on assignment.assignmentID = traveladvances.assignmentID where assignment.name = '" + assignment + "'; Delete Trip, assignment from Trip join assignment on assignment.AssignmentID = Trip.AssignmentID where assignment.name = '" + assignment + "'; Delete from assignment where name = '" + assignment + "'";
                      
          
            String[] Queries = new String[]
            {"Delete Report, Assignment from Report join assignment on Report.AssignmentID = assignment.AssignmentID where assignment.name = '" + assignment + "'",
             "Delete receipt, assignment, report from receipt join Report on Report.ReportID = receipt.ReportID join assignment on assignment.AssignmentID = Report.AssignmentID where assignment.name = '" + assignment + "'",
             "Delete traveladvances, assignment from traveladvances join assignment on assignment.assignmentID = traveladvances.assignmentID where assignment.name = '" + assignment + "'",
             "Delete Trip, assignment from Trip join assignment on assignment.AssignmentID = Trip.AssignmentID where assignment.name = '" + assignment + "'",
             "Delete from assignment where name = '" + assignment + "'"
            };
            
            db.executeMultiple(Queries);
            
            fillAssignmentCMB();
            jTextField_Name.setText("");
            jTextField_info.setText("");

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_Remove_deleteActionPerformed
   
    /**
     * visar info om en specifik assigment som hämtas ifrån databasen
     */
    private void ShowInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowInfoActionPerformed
        // TODO add your handling code here:
        
        
        if(Combo_Assigment.getSelectedItem() != null)          
        {
            try
            {
                String Query = "Select * from assignment where name = '" + Combo_Assigment.getSelectedItem().toString() + "'";
                ResultSet rs = db.getColumn(Query);
        
                while(rs.next())
                {
                    jTextField_Name.setText(rs.getString("name"));
                    jTextField_info.setText(rs.getString("info"));
                }
            
            }   
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please choose an assignment");
        }
    }//GEN-LAST:event_ShowInfoActionPerformed

    private void jTextField_infoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_infoKeyPressed
if(evt.getKeyCode() ==KeyEvent.VK_ENTER){       
     try
        { 
            String Query = "insert into assignment(name, info) values('" + jTextField_Name.getText() + "', '" + jTextField_info.getText() + "')";
             db.query(Query);
             
             fillAssignmentCMB();
             
             jTextField_Name.setText("");
             jTextField_info.setText("");
        }
   
       /* query("insert into users(name, email, username, password, status) values ('niklas', 'niklas', 'niklas', 'nilkas', 3);");*/
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Det gick inte att lägga till ett assignment");
        }
       


}
    }//GEN-LAST:event_jTextField_infoKeyPressed


    /**
     * fyller comboboxen med alla assigment
     */
    private void  fillAssignmentCMB()
    {
       try
        {
            Combo_Assigment.removeAllItems();
        String Query = "Select name from Assignment";  
        
        ResultSet rs = db.getColumn(Query);
        
        while(rs.next())
        {
            Combo_Assigment.addItem(rs.getString("name"));
        }
        
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_Assigment;
    private javax.swing.JButton Remove_delete;
    private javax.swing.JButton ShowInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_AddAssigment;
    private javax.swing.JLabel jLabel_Name;
    private javax.swing.JLabel jLabel_info;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_Name;
    private javax.swing.JTextArea jTextField_info;
    // End of variables declaration//GEN-END:variables
}
