/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.io.FileNotFoundException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class debtorsPop extends javax.swing.JDialog {
static String url = "jdbc:mysql://localhost:3306/inventory";
    static String username = "root";
    static String password = "this";
    String dateTopay;
    /**
     * Creates new form debtorsPop
     */
    public debtorsPop(java.awt.Frame parent, boolean modal) {
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jLabel1.setText("Name:");

        jTextField1.setEditable(false);

        jLabel2.setText("TOTAL AMOUNT  PAID:");

        jLabel3.setText("TOTAL AMOUNT");

        jLabel5.setText("ENTER AMOUNT(KSH)");

        jLabel4.setText("AMOUNT DUE");

        jTextField2.setEditable(false);

        jTextField4.setEditable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton3.setText("VIEW INVOICE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("SUMMARY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("INVOICE No:");

        jTextField3.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton3)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (jTextField2.equals("")) {
            JOptionPane.showMessageDialog(null, "No Invoice Selected", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            try {//inserter();
                trunc();
                truncdetails();
                insertdet(jTextField3.getText(), jTextField1.getText(),  jTextField2.getText(), jTextField5.getText());
                invoicereport(jTextField3.getText());
              //  invoicereport ma = new invoicereport(new javax.swing.JFrame(), true);
                invoicereport ma = new invoicereport();
                ma.initConnection();
                ma.showReport();
                //this.dispose();
                System.out.println("poutuutt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(debtorsPop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            trunc3();
            trunc2();        // TODO add your handling code here:
            insertholder();
            insertholder2();
           // invoicetranc ma = new invoicetranc(new javax.swing.JFrame(),true);
            invoicetranc ma = new invoicetranc();
            ma.initConnection();
            ma.showReport();
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(debtorsPop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String v = null;
        Connection cn1;
        ResultSet rs2;
        Statement st3;
        try {
            String str1 = "Select amtpaid from debtors where invoiceno= '" + jTextField3.getText() + "' ";
            // Change the database name, hosty name,
            // port and password as per MySQL installed in your PC.
            cn1 = DriverManager.getConnection("jdbc:mysql://"
                    + "localhost:3306/inventory", "root", "this");
            st3 = cn1.createStatement();

            //int s=st3.executeUpdate(str1);
            rs2 = st3.executeQuery(str1);
            while (rs2.next()) {
                v = rs2.getString(1);


            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        System.out.println(v);

        if (jTextField5.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter AMOUNT PAID", "Missing fields", JOptionPane.DEFAULT_OPTION);
            jTextField5.requestFocus();
            return;
        }
        double u = Double.parseDouble(jTextField4.getText());
        double k = Double.parseDouble(jTextField5.getText());

        if (k > u) {
            JOptionPane.showMessageDialog(null, "ITS MORE THAN OWED", "ERROR IN AMOUNT", JOptionPane.INFORMATION_MESSAGE);
        } else if (k <= u) {
            in();
            String k1 = (String.valueOf((Double.parseDouble(jTextField6.getText())) + (Double.parseDouble(jTextField2.getText()))));
            String str = "update debtors set amtpaid ='" + k1 + "' where invoiceno= '" + jTextField3.getText()+ "'";

            Connection cn;
            ResultSet rs;
            Statement st;

            try {
                // Change the database name, hosty name,
                // port and password as per MySQL installed in your PC.
                cn = DriverManager.getConnection("jdbc:mysql://"
                        + "localhost:3306/inventory", "root", "this");
                st = cn.createStatement();

                int s = st.executeUpdate(str);

                if (s > 0) {
                    JOptionPane.showMessageDialog(null, "Saved!", "Done", JOptionPane.INFORMATION_MESSAGE);
                    //update_table1();

                  //  this.update_table2();
                  //  this.getData2(code);
                  // this.update_table(code);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Enter AMOUNT PAID", "Missing fields", JOptionPane.DEFAULT_OPTION);
            }
            this.dispose();
            jTextField1.setText("");
            jTextField2.setText("");
            // jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
public void fill(String nam,String inv,String amtpaid,String totamt){
jTextField3.setText(inv);
jTextField1.setText(nam);
jTextField2.setText(amtpaid);
jTextField4.setText(totamt);
jTextField5.setText(String.valueOf(Double.parseDouble(totamt)-Double.parseDouble(amtpaid)));

}
public void insertdet(String inv,String cusq,String paid,String due){
        //String inv=invoiceno.getText();
         //String cusq=((String)jComboBox1.getSelectedItem());
    String str="INSERT INTO invoicedetails values('"+inv+"','"+cusq+"','"+paid+"','"+due+"') ";
       Connection cn;
		  
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();
int i=st.executeUpdate(str);
   
   
   st=cn.createStatement();
		   
                  }catch(Exception ex){}
   
   
    
    
    
    }
 public void insertholder2(){
        
    Connection connection=null;
    PreparedStatement psmnt=null;
    
    try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, username, password);
            psmnt = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement("INSERT INTO invoicetrancholder(name,invoiceno,total,date,amtpaid) select name,invoiceno,total,date,amtpaid from debtors where invoiceno='"+jTextField3.getText()+"' && name='"+jTextField1.getText()+"'");





            int s = psmnt.executeUpdate();
           // psmnt.close();

        } catch (Exception ex) {
            System.out.println("Found some error : " + ex);
            JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    
    
    }
 public void insertholder(){
    Connection connection=null;
    PreparedStatement psmnt=null;
    try {
        String sql="INSERT INTO invoicetransactionsholder (amtpaid,date) select amtpaid,date from invoicetransactions where invoiceno='" +jTextField3.getText()+ "'&& Name='"+jTextField1.getText()+"'";
            

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, username, password);
            psmnt = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement(sql);
            
            
                   int s = psmnt.executeUpdate();
           // psmnt.close();

        } catch (Exception ex) {
            System.out.println("Found some error : " + ex);
            JOptionPane.showMessageDialog(null, "Error 2222" + ex + "", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    
    
    
    
  }
 public void transactions(){
     Calendar currentDate = Calendar.getInstance();
       
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     
//      sad.format(ove);
       
        try{
             
            dateTopay= formatter.format(currentDate.getTime());
            
             // System.out.println( dateTopay);
        }catch(Exception e){
       System.out.println(e); 


        } 
 try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = ("INSERT INTO debtors values(?,?,?,?)");
            PreparedStatement stmt = conn.prepareStatement(sql);
           
 stmt.setString(2,(jTextField3.getText()));                      
stmt.setString(1,(jTextField1.getText()));
stmt.setString(3,(jTextField2.getText()));
stmt.setString(4,dateTopay);
//stmt.setString(4,(tot.getText()));


    int t=stmt.executeUpdate();
    }catch(Exception ex){}
 }
 public void invoicereport(String inv){
        
        
       String str="INSERT INTO invoiceholder (invoiceno,itemcode,item,description,quantity,price,subtotal,vat) select invoiceno,itemcode,item,description,quantity,price,subtotal,vat from invoice where invoiceno='" +inv + "'";
       Connection cn;
		  
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();
int i=st.executeUpdate(str);
   
   
   st=cn.createStatement();
		   
                  }catch(Exception ex){
                  ex.printStackTrace();
                  }
   
   } 
    public void trunc(){
   
   String str="truncate table invoiceholder";
   Connection cn;
		  
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();
int i=st.executeUpdate(str);
   
   
   st=cn.createStatement();
                  }catch(Exception ex){
                  
                  
                  
                  }
   }
     public void trunc3(){
   
   String str="truncate table invoicetrancholder";
   Connection cn;
		  
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();
int i=st.executeUpdate(str);
   
   
   st=cn.createStatement();
                  }catch(Exception ex){
                  
                  
                  
                  }
   }
    public void trunc2(){
   
   String str="truncate table invoicetransactionsholder";
   Connection cn;
		  
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();
int i=st.executeUpdate(str);
   
   
   st=cn.createStatement();
                  }catch(Exception ex){
                  
                  
                  
                  }
   }
 public void truncdetails(){
   
   String str="truncate table invoicedetails";
   Connection cn;
		  
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();
int i=st.executeUpdate(str);
   
   
   st=cn.createStatement();
                  }catch(Exception ex){
                  
                  
                  
                  }
   }
 public void in(){
      String chosen=null;
 Calendar currentDate = Calendar.getInstance();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
             
       chosen= formatter.format(currentDate.getTime());
            
             // System.out.println( chosen);
        }catch(Exception e){
       System.out.println(e); 


        }  
 try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = ("INSERT INTO invoicetransactions values(?,?,?,?)");
            PreparedStatement stmt = conn.prepareStatement(sql);
           
 stmt.setString(1,(jTextField3.getText()));                      
stmt.setString(2,(jTextField1.getText()));
stmt.setString(3,(jTextField6.getText()));
stmt.setString(4,chosen);
//stmt.setString(4,(tot.getText()));


    int t=stmt.executeUpdate();
    }catch(Exception ex){} 
 
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
            java.util.logging.Logger.getLogger(debtorsPop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(debtorsPop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(debtorsPop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(debtorsPop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                debtorsPop dialog = new debtorsPop(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
