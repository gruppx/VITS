/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Musse
 */
public class AddNewUser extends javax.swing.JInternalFrame {
    ConnectionClass db = new ConnectionClass();
       
    /**
     * Creates new form AddNewUser
     */
    public AddNewUser() {
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

        jLabel_NewUser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel_AddUserName = new javax.swing.JLabel();
        jLabel_AddUserNameEmail = new javax.swing.JLabel();
        jLabel_AddNewUserName = new javax.swing.JLabel();
        jLabel_AddPassword = new javax.swing.JLabel();
        jLabel_AddUserNameStatus = new javax.swing.JLabel();
        box_Status = new javax.swing.JComboBox();
        txt_UserName = new javax.swing.JTextField();
        txt_UserEmail = new javax.swing.JTextField();
        txt_UsernameName = new javax.swing.JTextField();
        txt_Password = new javax.swing.JTextField();
        jButton_AddUserSave = new javax.swing.JButton();

        jLabel_NewUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_NewUser.setText("Add a new user:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_AddUserName.setText("Full name:");

        jLabel_AddUserNameEmail.setText("Email:");

        jLabel_AddNewUserName.setText("Username:");

        jLabel_AddPassword.setText("Password:");

        jLabel_AddUserNameStatus.setText("Privilege:");

        box_Status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boss", "Konsultant" }));
        box_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_StatusActionPerformed(evt);
            }
        });

        txt_UsernameName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsernameNameActionPerformed(evt);
            }
        });

        jButton_AddUserSave.setText("Save");
        jButton_AddUserSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddUserSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel_AddNewUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_AddUserNameEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_AddUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_AddPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_AddUserNameStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_UserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_UsernameName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_AddUserSave, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_AddUserName)
                    .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_AddUserNameEmail)
                    .addComponent(txt_UserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_AddNewUserName)
                    .addComponent(txt_UsernameName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_AddPassword)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_AddUserNameStatus)
                    .addComponent(box_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_AddUserSave)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_NewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel_NewUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_UsernameNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsernameNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsernameNameActionPerformed

 
    
    private void box_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_StatusActionPerformed
        /*Object SelectedItem = box_Status.getSelectedItem();
        String Boss = "Boss";
        
        // SelectedItem = SelectedItem.toString();
        if(SelectedItem.equals(Boss)){
         int Bossvalue = Integer.parseInt(Boss);
            System.out.println(Boss);
         }
        */
        // TODO add your handling code here:
    }//GEN-LAST:event_box_StatusActionPerformed

    private void jButton_AddUserSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddUserSaveActionPerformed
           
        int Status = 0;
        if (box_Status.getSelectedItem().toString() == "Boss"){
            Status = 1;
            System.out.println("Motha");
           }
        
             try
        {
             db.query("insert into users(name, email, username, password, status) values ('" +txt_UserName.getText()+ "', "
                     + " '"+txt_UserEmail.getText()+"',"
                     + " '"+txt_UsernameName.getText()+"',"
                     + " '"+txt_Password.getText()+"',"
                     + " '"+Status+"')");
        }
   
       /* query("insert into users(name, email, username, password, status) values ('niklas', 'niklas', 'niklas', 'nilkas', 3);");*/
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Det gick inte att lägga till en användare");
        }
        


// TODO add your handling code here:
    }//GEN-LAST:event_jButton_AddUserSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox box_Status;
    private javax.swing.JButton jButton_AddUserSave;
    private javax.swing.JLabel jLabel_AddNewUserName;
    private javax.swing.JLabel jLabel_AddPassword;
    private javax.swing.JLabel jLabel_AddUserName;
    private javax.swing.JLabel jLabel_AddUserNameEmail;
    private javax.swing.JLabel jLabel_AddUserNameStatus;
    private javax.swing.JLabel jLabel_NewUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JTextField txt_UserEmail;
    private javax.swing.JTextField txt_UserName;
    private javax.swing.JTextField txt_UsernameName;
    // End of variables declaration//GEN-END:variables
}
