/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.ResultSet;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author josefin
 */
public class WriteTravelOrdre extends javax.swing.JInternalFrame {
 ConnectionClass db = new ConnectionClass();
 
     private Locale l;
    /**
     * Creates new form writeTravelOrder
     */
    public WriteTravelOrdre() {
        initComponents();
         fillUser();
       fillDay();
        fillMonth();
        fillYear();
        initializeLanguage();
    }
private void fillUser(){
        cbox_names.removeAllItems();
        ResultSet names = db.getColumn("select * from users");
int numOfUsers;
try{
numOfUsers = db.getCount("users");
for (int i=0; i<numOfUsers; i++)
{
names.next();
cbox_names.addItem(names.getString("username"));

}
}
catch(Exception e){
JOptionPane.showMessageDialog(null, e.getMessage());
}
    }

 public void informationUser() {
      try {
    String sqlID = "Select userid from  users where username ='" + cbox_names.getSelectedItem() +"'";                //Sedan fylls information på i de lablen när sql frågorna körs.
        
        String sqlName = "Select name from  users where username ='" + cbox_names.getSelectedItem() +"'";  

        String sqlMail = "Select email from  users where username ='" + cbox_names.getSelectedItem() +"'";  
    
        
        String ID = db.getString(sqlID);
            labelID.setText(ID);
            
            String Name = db.getString(sqlName);
            labelName.setText(Name);
            
            String Mail = db.getString(sqlMail);
            labelMail.setText(Mail);
            
          
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        
    
        }
        } 
  private void fillDay(){
        int [] date = new int[32];
        cbx_ADay.removeAllItems();
        cbx_DDay.removeAllItems();
       
        for(int i = 1; i < 32; i++)
        {
            if(i < 10){
            date[i] = i + 1;
            cbx_ADay.addItem("0" + i);
            cbx_DDay.addItem("0" + i);
        }
        else if(i >= 10)
        {
             date[i] = i + 1;
            cbx_ADay.addItem(i);
            cbx_DDay.addItem(i); 
        }
       }
    }
      

  private void fillMonth(){
       int [] month = new int[13];
       cbx_AMonth.removeAllItems();
       cbx_DMonth.removeAllItems();
       
       for(int i = 1; i < 13; i++){
           if(i < 10){
           cbx_AMonth.addItem("0" + i);
           cbx_DMonth.addItem("0" + i);
           month[i] = i + 1;
           }
           else if(i >= 10)
           {
           cbx_AMonth.addItem(i);
           cbx_DMonth.addItem(i); 
           month[i] = i + 1;
           }
       }
       
    }
        private void initializeLanguage(){
        l = LogIn.getString();
         
        ResourceBundle r = ResourceBundle.getBundle("Project/Bundle", l);
        
      jLabel3.setText(r.getString("WriteTravelOrdre.jLabel3.text"));
       jLabel2.setText(r.getString("WriteTravelOrdre.jLabel2.text"));
          jButton2.setText(r.getString("MainFrameBoss.jButton2.text"));
           jLabel1.setText(r.getString("WriteTravelOrdre.jLabel1.text"));
            jButton1.setText(r.getString("WriteTravelOrdre.jButton1.text"));
             label1.setText(r.getString("WriteTravelOrdre.label1.text"));
              jButton2.setText(r.getString("WriteTravelOrdre.jButton2.text"));
                 jLabel5.setText(r.getString("WriteTravelOrdre.jLabel5.text"));
                  jLabel6.setText(r.getString("WriteTravelOrdre.jLabel6.text"));
                   jLabel7.setText(r.getString("MainFrameBoss.btn_search.text"));
                     jLabel4.setText(r.getString("WriteTravelOrdre.jLabel4.text"));
                 
    }
  
   
    private void fillYear(){
       int [] year = new int[99];
       cbx_AYear.removeAllItems();
       cbx_DYear.removeAllItems();
       
       for(int i = 1; i < 99; i++){
           if(i < 10){
           cbx_AYear.addItem("200" + i);
           cbx_DYear.addItem("200" + i);
           year[i] = i + 1;
           }
           else if(i >= 10)
           {
           cbx_AYear.addItem("20" + i);
           cbx_DYear.addItem("20" + i); 
           year[i] = i + 1;
           }
       }}
       public void AddTravelOrdre()
       {
           String departureYear = cbx_DYear.getSelectedItem().toString();
        String departureMonth = cbx_DMonth.getSelectedItem().toString();
        String departureDay = cbx_DDay.getSelectedItem().toString();

        String arrivalYear = cbx_AYear.getSelectedItem().toString();
        String arrivalMonth = cbx_AMonth.getSelectedItem().toString();
        String arrivalDay = cbx_ADay.getSelectedItem().toString();

      
        
        int departure = Integer.parseInt( departureYear + departureMonth + departureDay);
        int arrival = Integer.parseInt(arrivalYear + arrivalMonth  + arrivalDay );
         int id = Integer.parseInt(labelID.getText());
         
        try {
 String sqlFraga = ("Insert into travelorder(userid, name, email, fromdate, todate, country) values ('" + (id) + "','" +labelName.getText()+ "','" +labelMail.getText()+ "','" + (departure) + "','" + (arrival) + "','" +fieldCountry.getText()+"')");

 db.query(sqlFraga);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

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

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbox_names = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        labelID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelMail = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fieldCountry = new javax.swing.JTextField();
        cbx_AYear = new javax.swing.JComboBox();
        cbx_AMonth = new javax.swing.JComboBox();
        cbx_ADay = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbx_DYear = new javax.swing.JComboBox();
        cbx_DMonth = new javax.swing.JComboBox();
        cbx_DDay = new javax.swing.JComboBox();
        label1 = new java.awt.Label();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Project/Bundle"); // NOI18N
        setTitle(bundle.getString("WriteTravelOrdre.title")); // NOI18N

        jButton2.setText(bundle.getString("WriteTravelOrdre.jButton2.text")); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText(bundle.getString("WriteTravelOrdre.jButton1.text")); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(bundle.getString("WriteTravelOrdre.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbox_names, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_names, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(bundle.getString("WriteTravelOrdre.jLabel2.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText(bundle.getString("WriteTravelOrdre.jLabel3.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText(bundle.getString("WriteTravelOrdre.jLabel4.text")); // NOI18N

        jLabel7.setText(bundle.getString("WriteTravelOrdre.jLabel7.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelName)
                            .addComponent(labelMail, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelID))
                    .addComponent(jLabel7))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelName))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelMail))
                .addGap(40, 40, 40))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText(bundle.getString("WriteTravelOrdre.jLabel6.text")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText(bundle.getString("WriteTravelOrdre.jLabel5.text")); // NOI18N

        label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label1.setText(bundle.getString("WriteTravelOrdre.label1.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbx_AYear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_AMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_ADay, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbx_DYear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_DMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_DDay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(fieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_DMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_DYear)
                    .addComponent(cbx_DDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_AYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_AMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_ADay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        informationUser();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
AddTravelOrdre();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbox_names;
    private javax.swing.JComboBox cbx_ADay;
    private javax.swing.JComboBox cbx_AMonth;
    private javax.swing.JComboBox cbx_AYear;
    private javax.swing.JComboBox cbx_DDay;
    private javax.swing.JComboBox cbx_DMonth;
    private javax.swing.JComboBox cbx_DYear;
    private javax.swing.JTextField fieldCountry;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label label1;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelMail;
    private javax.swing.JLabel labelName;
    // End of variables declaration//GEN-END:variables
}
