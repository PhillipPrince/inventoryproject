/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class userEdit extends javax.swing.JDialog {
DBConnection nn=new DBConnection();
String ip="localhost";
String p1,p2;
int Userlevel;
String we="";
String uname="";

    /**
     * Creates new form userEdit
     */
    public userEdit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
                this.setLocationRelativeTo(null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nam = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        pass2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jButton1.setText("CHANGE");
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

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EDIT USER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        nam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        pass2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel1.setText("USER NAME");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel2.setText("PASSWORD");

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel4.setText("CONFIRM PASSWORD");

        jLabel8.setText("USER LEVEL:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GENERAL USER", "ADMINSTRATOR" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(0, 66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        // TODO add your handling code here:
   }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        p1 = new String(pass.getPassword());
        p2 = new String(pass2.getPassword());
        
        String wr = nam.getText();


        //fre.setText(String.valueOf(Userlevel));
       if (nam.getText().equals("") ) {
            JOptionPane.showMessageDialog(jPanel1, "Sorry, Incomplete", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else if (pass2.getText().equals("") &&pass.getText().equals("")==false) {
            JOptionPane.showMessageDialog(jPanel1, "Sorry, You Did Not Confirm Your Password!", "Incomplete!", JOptionPane.ERROR_MESSAGE);

        }  else if (jComboBox2.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(jPanel1, "Sorry, You Need to select Userlevel!", "Incomplete!", JOptionPane.ERROR_MESSAGE);



        }  else if ((p1.equals(p2) && p1.equals("")==false && p2.equals("")==false  ) ) {
            save();
            pass.setText("");
            pass2.setText("");
            nam.setText("");
            
        } 
        else if ((p1.equals(p2) && p1.equals("")==true && p2.equals("")==true  ) ) {
            save2();
            pass.setText("");
            pass2.setText("");
            nam.setText("");
            
        }
        else {
            JOptionPane.showMessageDialog(jPanel1, "Sorry, Password Match!", "Inconsistent!", JOptionPane.ERROR_MESSAGE);
            pass.setText("");
            pass2.setText("");



        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

                               int y=0;
y=JOptionPane.showConfirmDialog(jPanel1,"Do Really You Want to Delete this User?","Confirm!",JOptionPane.YES_NO_OPTION);
if(y==0)
{
     String kk=(String) jComboBox2.getSelectedItem();
String ee="Adminstrator";
  if(kk.equals(ee)){

  JOptionPane.showMessageDialog(jPanel1,"Adminstrator Cannot be deleted ","Error!",JOptionPane.ERROR_MESSAGE);
  }
  else{
  delete(); 
  
  }
           }
else{}// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
public void save(){
        
        int userlvl=this.jComboBox2.getSelectedIndex()+2;
    com.mysql.jdbc.Connection connection;
                   PreparedStatement psmnt;
         try
             {






connection = (com.mysql.jdbc.Connection) nn.getDBConnection();
psmnt =     (PreparedStatement) connection.prepareStatement
("update login set user='"+nam.getText()+"',password='"+p1+"',userlevel='"+userlvl+"' where user='"+uname+"' ");




int s = psmnt.executeUpdate();
psmnt.close();

if(s>0) {

     JOptionPane.showMessageDialog(null,"USER SAVED","saved!",JOptionPane.INFORMATION_MESSAGE);
     this.dispose();
}
else {
System.out.println("unsucessfull item not found ");
          JOptionPane.showMessageDialog(null,"Sorry, Not All Details Were Saved!","Error!",JOptionPane.ERROR_MESSAGE);
  }
connection.close();
}

     catch (Exception ex) {
System.out.println("Found some error : "+ex);
    JOptionPane.showMessageDialog(null,"Error "+ex+"","Error!",JOptionPane.ERROR_MESSAGE);

}
     }
public void save2(){
        
        int userlvl=this.jComboBox2.getSelectedIndex()+2;
    com.mysql.jdbc.Connection connection;
                   PreparedStatement psmnt;
         try
             {






connection = (com.mysql.jdbc.Connection) nn.getDBConnection();
psmnt =     (PreparedStatement) connection.prepareStatement
("update login set user='"+nam.getText()+"',userlevel='"+userlvl+"' where user='"+uname+"' ");




int s = psmnt.executeUpdate();
psmnt.close();

if(s>0) {

     JOptionPane.showMessageDialog(null,"USER SAVED","saved!",JOptionPane.INFORMATION_MESSAGE);
     this.dispose();
}
else {
System.out.println("unsucessfull item not found ");
          JOptionPane.showMessageDialog(null,"Sorry, Not All Details Were Saved!","Error!",JOptionPane.ERROR_MESSAGE);
  }
connection.close();
}

     catch (Exception ex) {
System.out.println("Found some error : "+ex);
    JOptionPane.showMessageDialog(null,"Error "+ex+"","Error!",JOptionPane.ERROR_MESSAGE);

}
     }
public void fill(String name){
this.uname=name;
try{
    
 
             com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) nn.getDBConnection();
            String sql = "SELECT user ,userlevel FROM login where user='"+name+"'";
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
nam.setText(resultSet.getString(1));

                jComboBox2.setSelectedIndex(resultSet.getInt(2)-2);
             }
            conn.close();
        } catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);

               
        }


}
public void delete(){
    String kk=nam.getText();
    try{
    
 
             com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) nn.getDBConnection();
            String sql = "delete from login where user='"+uname+"'";
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
            int y=stmt.executeUpdate();
            conn.close();
            if(y>0){
                if(kk.equals(this.user())){


System.exit(0);
}
            this.dispose();
            
            }
            conn.close();
        } catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);

               
        }
                //ide1.setText(resultSet.getString(3));



           









}
public String user(){
         String cuser="";
    try {
           
           java.sql.Connection con=(java.sql.Connection)nn.getDBConnection();
            String sql = "SELECT name FROM holder";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
             
            while (resultSet.next()) {
             cuser=resultSet.getString(1);
             }
            con.close();
            resultSet.close();
        } catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
       
    }
    return cuser;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(userEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                userEdit dialog = new userEdit(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nam;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField pass2;
    // End of variables declaration//GEN-END:variables
}
