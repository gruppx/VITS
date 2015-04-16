
package Project;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrik
 */
public class AddTravelAdvances2 extends javax.swing.JInternalFrame {
    ConnectionClass db = new ConnectionClass();
    /**
     * Creates new form NewJInternalFrame
     */
    public AddTravelAdvances2() {
        initComponents();
        fillBoxes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbox_assignment = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_info = new javax.swing.JTextArea();
        cbox_boss = new javax.swing.JComboBox();

        cbox_assignment.setMaximumRowCount(999);
        cbox_assignment.setToolTipText("");

        jLabel1.setText("Amount:");

        jLabel2.setText("Reason for travel advance:");

        btn_send.setText("Send");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        txt_info.setColumns(20);
        txt_info.setRows(5);
        jScrollPane1.setViewportView(txt_info);

        cbox_boss.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbox_boss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_bossActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_amount, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbox_assignment, javax.swing.GroupLayout.Alignment.LEADING, 0, 129, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(cbox_boss, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btn_send)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 100, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_assignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_boss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_send)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        int travelID;
        String name = cbox_assignment.getSelectedItem().toString();
        try{
           travelID =  db.getID("select assignmentid from assignment where name = '"+name+"'");
            db.query("insert into traveladvances(amount, approved, assignmentid, reason) values("+
                    txt_amount.getText()+", 0, "+travelID+", '"+txt_info.getText()+"')");
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }//GEN-LAST:event_btn_sendActionPerformed

    private void cbox_bossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_bossActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_bossActionPerformed

    private void fillBoxes(){
        ResultSet names = db.getColumn("select * from assignment");
        int numOfUsers;
        try{
            numOfUsers = db.getCount("assignment");
            for (int i=0; i<numOfUsers; i++)
            {
            names.next();
            cbox_assignment.addItem(names.getString("name"));
            }
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_send;
    private javax.swing.JComboBox cbox_assignment;
    private javax.swing.JComboBox cbox_boss;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextArea txt_info;
    // End of variables declaration//GEN-END:variables
}

