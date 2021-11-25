/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class home extends javax.swing.JFrame {
    
  DBConnection db=new DBConnection();
//java.sql.Connection conn=(java.sql.Connection)nn.getDBConnection();
   
JTable table,table2;
TableModel model;
String [][] data=null;
String [][] data2=null;
String [][] sample=null;
String [][] purchased=null;
static String url = "jdbc:mysql://localhost:3306/inventory";


    static String username = "root";
    static String password = "this";
    static PreparedStatement stmt;
    static ResultSet resultSet;
    String level; 
    String currcode=null;
     String coded;
     String cquant;
     String codee;
     String cquan2;
     ResultSet rst;
     String sale,deb;
      double thelevel=0.0;
      SimpleDateFormat form=new SimpleDateFormat("yyy-MM-dd");
    /**
     * Creates new form home
     */
    public home(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
         initComponents();
         int t=this.reorder();
         int r=0;
          //       r=checkExpired();
        if(r>0){
        jPanel6.setVisible(true);
        
        
        }
        else{
        
        jPanel6.setVisible(false);
        }
         try{
       if(t>0){
            
        JOptionPane.showMessageDialog(null, "You have some Items below reorder level!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
        
        }
        
         Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int w = screenSize.width;
        int h = screenSize.width;
        jScrollPane1.setSize(w, h);
        this.Runlevel();
    // getData();
        this.setTitle("Home");
        //this.setLocationRelativeTo(null);
        //this.setResizable(false);
        thelevel=Double.parseDouble(level);
      //  data=this.getData("");
    table();
         this.getData2();
       // table2();
       
        
        //update_table(codee);
        this.setTitle("::CosanSoft::");
    //  Backup("inventory","root", "this", "\"C:inventory.sql\"");
        
        if(thelevel==1){
            jMenu4.setEnabled(false);
           jMenuItem14.setEnabled(false);
           jMenuItem17.setEnabled(false);
//           jButton15.setEnabled(false);
            jButton8.setEnabled(false);
            jButton7.setEnabled(false);
         // jButton13.setEnabled(false);
          
        }
        else if(thelevel==2){
  jMenuItem17.setEnabled(false);
jMenu4.setEnabled(false);
         //  jButton13.setEnabled(false);
          //jButton15.setEnabled(false);
            jButton8.setEnabled(false);
            jButton7.setEnabled(false);
         jMenuItem14.setEnabled(false);
          
}
        try {
          
            String sql = "SELECT distinct category FROM stock";
            stmt = db.prepareStatement(sql);
             resultSet = stmt.executeQuery();
             jComboBox7.removeAllItems();
            while (resultSet.next()) {
               
               jComboBox7.addItem(resultSet.getString(1));
             }
           
        } catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);

        }
  
       update2();
       if(purchased!=null){
      stockUpdate();} 
         }catch(Exception e){
         e.printStackTrace();
          JOptionPane.showMessageDialog(jPanel1,e,"Stock Update Error!",JOptionPane.ERROR_MESSAGE);
         }
         System.gc();
    }
    public boolean Backup(String dbName, String dbUserName, String dbPassword, String path) {

String executeCmd = "C:\\xampp\\mysql\\bin\\mysqldump -u " + dbUserName + " -p" + dbPassword + " --add-drop-database -B " + dbName + " -r " + path;

Process runtimeProcess;
try {
runtimeProcess = Runtime.getRuntime().exec(executeCmd);
int processComplete = runtimeProcess.waitFor();

if (processComplete == 0) {
System.out.println("done");
return true;
} else {
System.out.println("done");
}
} catch (Exception ex) {
ex.printStackTrace();
}
return false;
}
 public void intial()
    {
        try
        {
            String sql = "delete from debtors where not exists (select invoiceno from invoice where invoiceno=invoiceno)";
             stmt = db.prepareStatement(sql);
            int s = stmt.executeUpdate();
            if(s > 0)
                JOptionPane.showMessageDialog(jPanel1, "updated", "Successfull", 1);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void update2(){
    
    
    try {
        
       
            String sql = "SELECT * FROM invoice where sold='0'";
            stmt = db.prepareStatement(sql);
            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                resultSet.last();
           purchased=new String[resultSet.getRow()][7];
            resultSet.beforeFirst();}
           // int rows=0;
            int row=0;
            while (resultSet.next()) {
                //cquan=resultSet.getString("quantity");
                //mine=new String[6];
             purchased[row][0]=resultSet.getString(2);
                purchased[row][1]=resultSet.getString(3);
                purchased[row][2]=resultSet.getString(4);
                purchased[row][3]=resultSet.getString(5);
                purchased[row][4]=resultSet.getString(8);
                purchased[row][5]=resultSet.getString(7);
                purchased[row][6]=resultSet.getString(1);
                row++;
               System.out.println("hit");
             }
           
        } catch (Exception exc) {  // process error
            JOptionPane.showMessageDialog(jPanel1,exc,"Error!",JOptionPane.ERROR_MESSAGE);
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    
    }
    public void Runlevel() {

        try {
           
            String sql = "SELECT * FROM holder";
            stmt = db.prepareStatement(sql);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                
             level=resultSet.getString("level");
             //System.out.println("found");
            }
         //   conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
            JOptionPane.showMessageDialog(jPanel1, "Sorry, connection Failed!\nOpen Xampp And Set MySql Running", "Error!", JOptionPane.ERROR_MESSAGE);

        }


    }
    public void table2(){
        
   /// table.removeAll();
    String[] header={ "CATEGORY"};

//data[i][j]=i*j;
//String [][] data2=null;
// make table model with this data..
DefaultTableModel model1 = new DefaultTableModel(data2, header);
model1.fireTableDataChanged();
table2 = new JTable(model1);
//table.setCellSelectionEnabled(true);
//table.setEditingRow(0);
JScrollPane scrollPane = new JScrollPane(table2);
//table.setFillsViewportHeight(true);

scrollPane.setBounds(0,0,187,296);
table2.addMouseListener(new MouseAdapter() {
   
public void mouseClicked(MouseEvent e) {
    
int row = table2.getSelectedRow();
int col = table2.getSelectedColumn();
codee=data2[row][0];
update_table(codee);
//fill();
//get(code,date);
   getData(codee);
   // update_table(code);
    //fill(code);
     // table2();
               
//System.out.println("row is "+row+" and " +col+""+code);
}
}); } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jComboBox7 = new javax.swing.JComboBox();
        jButton14 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem10.setText("jMenuItem10");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 300));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/Purchase-Order-32.PNG"))); // NOI18N
        jButton2.setText("PURCHASES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/Money-32.png"))); // NOI18N
        jButton3.setText("EXPENSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/1349816197_LorryGreen.png"))); // NOI18N
        jButton4.setText("SUPPLIERS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/Invoice-256.png"))); // NOI18N
        jButton5.setText("INVOICE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/suppliers.png"))); // NOI18N
        jButton9.setText("CREDITORS");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/customers_2.png"))); // NOI18N
        jButton10.setText("DEBTORS");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/customers.png"))); // NOI18N
        jButton11.setText("CUSTOMERS");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton16.setText("NEW ITEM");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton11)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 47, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton16)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addGap(26, 26, 26)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/Stocks-iPhone-32(1).png"))); // NOI18N
        jButton7.setText("REPORTS");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/717346428.png"))); // NOI18N
        jButton8.setText("USER");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/Logout-32.png"))); // NOI18N
        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jButton14.setText("Find");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 4, 4));
        jLabel1.setText("You have Some Items almost Expirying.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Click here to View.");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 355, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(127, Short.MAX_VALUE))))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("File");

        jMenuItem2.setText("EXIT");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Adminstration");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem7.setText("New user");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Change Password");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Accounting period");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem13.setText("Company Details");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuItem15.setText("Cash In");
        jMenuItem15.setEnabled(false);
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem6.setText("Expiry Date Setting");
        jMenuItem6.setEnabled(false);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Operations");

        jMenuItem11.setText("Reorder List");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem18.setText("Expired Products");
        jMenuItem18.setEnabled(false);
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem18);

        jMenuItem12.setText("Create order");
        jMenu5.add(jMenuItem12);

        jMenuItem14.setText("Invoicelist");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem17.setText("Edit Purchases");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem17);

        jMenuItem16.setText("GRAPHS");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1283, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
changepass1 n = new changepass1(new javax.swing.JFrame(), true);
        n.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
 newuser n = new newuser(new javax.swing.JFrame(), true);
        n.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
userManager n = new userManager(new javax.swing.JFrame(), true);
        n.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
try {

                reorder m = new reorder();
                m.initConnection();
                m.showReport();

            } catch (FileNotFoundException ex) {
                
            }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     purchases n = new purchases(new javax.swing.JFrame(), true);
//     n.setDis(thelevel);
        n.setVisible(true);    // TODO add your handling code here:
        //update_table(codee);
        data=getData(jComboBox7.getSelectedItem().toString());     
update(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
expenses n=new expenses();
n.setVisible(true);// TODO add your handling code here
//update_table(codee);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
login bb=new login(new javax.swing.JFrame(),true);        // TODO add your handling code here:
this.dispose();
bb.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
reports n=new reports(new javax.swing.JFrame(),true); 
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
invoice_1 n =new invoice_1(new javax.swing.JFrame(),true) {};  
n.setVisible(true);// TODO add your handling code here:
//update();
update2();
      stockUpdate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
suppliers n=new suppliers(new javax.swing.JFrame(),true);    
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
profitlossac n=new profitlossac(new javax.swing.JFrame(),true);    
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
company n=new company(new javax.swing.JFrame(),true); 
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
Creditors n=new Creditors(new javax.swing.JFrame(),true)  ;   
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
Customers n=new Customers(new javax.swing.JFrame(),true);    
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
debtors n=new debtors(new javax.swing.JFrame(),true);    
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
invoicelist n=new invoicelist(new javax.swing.JFrame(),true);    
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
charts n=new charts(new javax.swing.JFrame(),true);   
n.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
data=this. getData(jComboBox7.getSelectedItem().toString());     
this.update();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
 data=this. getDatasearch(search.getText());     
this.update();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyReleased

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
double thelevel2=Double.parseDouble(level);
if(thelevel2==1||thelevel2==2){
JOptionPane.showMessageDialog(null, "Not allowed to do this Operation", "Restriction!", JOptionPane.ERROR_MESSAGE);
}
else{
        
        newItem nn=new newItem(new javax.swing.JFrame(),true);       
nn.setVisible(true);
//this. getDatasearch(search.getText());     
//this.update_tablesearch(search.getText());
data=getData(jComboBox7.getSelectedItem().toString());     
update(); 
 try {
         
            String sql = "SELECT distinct category FROM stock";
            stmt = db.prepareStatement(sql);
            resultSet = stmt.executeQuery();
             jComboBox7.removeAllItems();
            while (resultSet.next()) {
              
               jComboBox7.addItem(resultSet.getString(1));
             }
            
        } catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
   totalcash nn=new totalcash(new javax.swing.JFrame(),true);       
nn.setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
    purchaseedit nne=new purchaseedit(new javax.swing.JFrame(),true);       
nne.setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
     ExpiredProducts pr=new ExpiredProducts(new javax.swing.JFrame(),true);     
pr.setVisible(true); 

if(checkExpired()>0){
        jPanel6.setVisible(true);
        
        
        }
        else{
        
        jPanel6.setVisible(false);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
   setPeriod pr=new setPeriod(new javax.swing.JFrame(),true);     
pr.setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
  ExpiredProducts pr=new ExpiredProducts(new javax.swing.JFrame(),true);     
pr.setVisible(true);   // TODO add your handling code here:

if(checkExpired()>0){
        jPanel6.setVisible(true);
        
        
        }
        else{
        
        jPanel6.setVisible(false);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    /**
     * @param args the command line arguments
     */
     public void table(){
        
   /// table.removeAll();
    String[] headers={ "CODE", "NAME","DESCRIPTION","UNITS","QUANTITY","REORDER","SUPPLIER","SELLING PRICE","BUYING PRICE" };

//data[i][j]=i*j;

// make table model with this data..
DefaultTableModel model = new DefaultTableModel(data, headers);
model.fireTableDataChanged();
table = new JTable(model);
//table.setCellSelectionEnabled(true);
//table.setEditingRow(0);
JScrollPane scrollPane = new JScrollPane(table);
//table.setFillsViewportHeight(true);
jPanel2.add(scrollPane,BorderLayout.CENTER);
scrollPane.setBounds(0,0,919,453);
    table.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
 // getData();
   // update();
int row = table.getSelectedRow();
int col = table.getSelectedColumn();
String tIdno=sample[row][0];
double thelevel2=Double.parseDouble(level);
if(thelevel2==1||thelevel2==2){
JOptionPane.showMessageDialog(null, "Not allowed to do this Operation", "Restriction!", JOptionPane.ERROR_MESSAGE);
}
else{
    editItem nn=new editItem(new javax.swing.JFrame(),true);
//edit b=new edit();
nn.set(tIdno);
//searchfor(tIdno);
nn.setVisible(true);
//getDatasearch(search.getText());     
//update_tablesearch(search.getText());
 data=getData(jComboBox7.getSelectedItem().toString());     
update();  
}

//System.out.println("row is "+row+" and " +col);
}
});
    
    }
     public String [][] getData(String purchase){
    
     if(purchase.equals("")){  
     String str="SELECT  Itemcode,name,description,units,quantity,reorder_level,supplier,price,buyingprice from stock ";

		  Connection cn;
		  ResultSet rs;
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=db.createStatement();

		   rs=st.executeQuery(str);
                   
                 
if(rs.next()){
rs.last();

sample=new String [rs.getRow()][9];
rs.beforeFirst();
}
int rowcount=0;

		   while(rs.next())
		   {
		    
sample[rowcount][0]=rs.getString(1);
sample[rowcount][1]=rs.getString(2);
sample[rowcount][2]=rs.getString(3);
sample[rowcount][3]=rs.getString(4);
sample[rowcount][4]=rs.getString(5);
sample[rowcount][5]=rs.getString(6);
sample[rowcount][6]=rs.getString(7);      
sample[rowcount][7]=rs.getString(8);
sample[rowcount][8]=rs.getString(9);




		    
//System.out.println(sample[1][1]);		    
                   
                  
rowcount++;
                    
		   }
                  rs.close();
                  cn.close();

		  } catch (SQLException e) {

		   e.printStackTrace();
		  }
     
     
     
     }
     else{
     
     String str="SELECT Itemcode,name,description,units,quantity,reorder_level,supplier,price,buyingprice from stock WHERE category = '"+purchase+"'";

		  Connection cn;
		  ResultSet rs;
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();

		   rs=st.executeQuery(str);
                   
                 
if(rs.next()){
rs.last();

sample=new String [rs.getRow()][9];
rs.beforeFirst();
}
int rowcount=0;

		   while(rs.next())
		   {
		    
sample[rowcount][0]=rs.getString(1);
sample[rowcount][1]=rs.getString(2);
sample[rowcount][2]=rs.getString(3);
sample[rowcount][3]=rs.getString(4);
sample[rowcount][4]=rs.getString(5);
sample[rowcount][5]=rs.getString(6);
sample[rowcount][6]=rs.getString(7);
sample[rowcount][7]=rs.getString(8);
sample[rowcount][8]=rs.getString(9);



		    
//System.out.println(sample[1][1]);		    
                   
                  
rowcount++;
                    
		   }
                  rs.close();
                  cn.close();

		  } catch (SQLException e) {

		   e.printStackTrace();
		  }
     }

                // System.out.println(sample.length);
                  return sample;
		 }
      public String [][] getDatasearch(String namee){
    
     
    
String str="SELECT Itemcode,name,description,units,quantity,reorder_level,supplier,price,buyingprice from stock WHERE name like '%"+namee+"%'";

		  Connection cn;
		  ResultSet rs;
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();

		   rs=st.executeQuery(str);
                   
                 
if(rs.next()){
rs.last();

sample=new String [rs.getRow()][9];
rs.beforeFirst();
}
int rowcount=0;

		   while(rs.next())
		   {
		    System.err.println("found data");
sample[rowcount][0]=rs.getString(1);
sample[rowcount][1]=rs.getString(2);
sample[rowcount][2]=rs.getString(3);
sample[rowcount][3]=rs.getString(4);
sample[rowcount][4]=rs.getString(5);
sample[rowcount][5]=rs.getString(6);
sample[rowcount][6]=rs.getString(7);
sample[rowcount][7]=rs.getString(8);
sample[rowcount][8]=rs.getString(9);



		    
//System.out.println(sample[1][1]);		    
                   
                  
rowcount++;
                    
		   }
                  rs.close();
                  cn.close();

		  } catch (SQLException e) {

		   e.printStackTrace();
		  }
                // System.out.println(sample.length);
                  return sample;
		 }
     public int search(){
   int i=0;
      String find="";
    try {
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM stock where Itemcode='"+find+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
               i=1;
             }
            conn.close();
        } catch (Exception exc) {  // process error
            
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    System.out.println(i);
    
   return i;
   }
  
    public void update(){
   String[] headers={ "CODE", "Name","DESCRIPTION","UNITS","QUANTITY","REORDER","SUPPLIER","SELLING PRICE","BUYING PRICE" };

//data[i][j]=i*j;

// make table model with this data..
DefaultTableModel model = new DefaultTableModel(data, headers);
model.fireTableDataChanged();
table.setModel(model);
    
    }
    public void searchfor(String icode){
       currcode=icode;
//code1.setText(icode);



}
   
   
    public int reorder(){
    int i=0;
   String sql="Select * from stock where quantity<=reorder_level && type=0";
    
		  ResultSet rs;
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   st=db.createStatement();

		   resultSet=st.executeQuery(sql);
                  while(resultSet.next()){
                  
                  i=1;
                  } 
                  }catch(Exception ex){
                  ex.printStackTrace();
                  
                  }
             return i;     
    
    }
    public void stockUpdate(){
        String inv=null;
        String cuur;
        double subt=0;
         double vatt=0;
//       System.out.println( purchased[0][3]+"  ");
    if(purchased !=null){
    for(int i=0;i<purchased.length;i++){
    for(int y=0;y<7;y++){
        
      //  purchased[i][0]=coded;
       
        if(y==0){
       coded=purchased[i][y];
       searchq2(coded);
        }
        //System.out.println( purchased[i][y]+"  n ");
        else if(y==3){
        cquant=purchased[i][y];
         System.out.println(cquant+" quan");
        
        }
        else if(y==6){
        inv=purchased[i][y];
        System.out.println(inv+"invoice");
        }
        else if(y==4){
        vatt=Double.parseDouble(purchased[i][y]);
        }
         else if(y==5){
         subt=Double.parseDouble(purchased[i][y]);
         
         }
   // purchased[i][3]=cquant;
   System.out.println(cquant+"fff");
   
    }
    subtract2();
            getamt(inv);
            getsales(inv);
            updatedeb(String.valueOf((vatt)+subt),inv);
    updatesale(String.valueOf((vatt)+subt),inv);
     updatedebt(inv);
      updatesalet(inv);
   
    updateinv();
    intial();
    }
    } 
    
    }
    public void subtract2(){
      // cquant=quantity.getText();
      double adder=Double.parseDouble(cquant);
      double before=Double.parseDouble(cquan2);
      double both=before+adder;
      String finaltosave=String.valueOf(both);
      //String thcode=code.getText();
        
    try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = ("update stock set quantity='"+finaltosave+"' where Itemcode='"+coded+"' && type=0");
            PreparedStatement stmt = conn.prepareStatement(sql);
           
                       
int u = stmt.executeUpdate();
if(u>0){

System.out.println("done");

}
    }catch(Exception ex){ex.printStackTrace();}
    }
    public void searchq2(String find){
    try {
       // String find=code.getText();
        System.out.println(find);
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM stock where Itemcode='"+find+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                cquan2=resultSet.getString("quantity");
                
               System.out.println(cquan2+"result");
             }
            conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    
    
    }
    public void getamt(String find){
   deb="0.0";
    try {
       // String find=code.getText();
       // System.out.println(find);
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT total FROM debtors where invoiceno='"+find+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            System.out.println(sql);
            while (resultSet.next()) {
                deb=resultSet.getString(1);
                
               System.out.println(cquan2+"result");
             }
            conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    
    
    }
    public void getsales(String find){
    sale="0.0";
    try {
       // String find=code.getText();
       // System.out.println(find);
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT amt FROM sales where invoiceno='"+find+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                sale=resultSet.getString(1);
                
               System.out.println(cquan2+"result");
             }
            conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    
    
    }
    public void updatedeb(String curr,String find){
    
    double amtsold=Double.parseDouble(deb);
     double amtcurr=Double.parseDouble(curr);
    
    double finalsave=amtsold+amtcurr;
    try {
       // String find=code.getText();
       // System.out.println(find);
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "update debtors set total='"+finalsave+"' where invoiceno='"+find+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int y = stmt.executeUpdate();
            
            conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    }
        public void updatesale(String curr,String find){
    
    double amtsold=Double.parseDouble(sale);
     double amtcurr=Double.parseDouble(curr);
    double finalsave=amtsold+amtcurr;
    try {
       // String find=code.getText();
       // System.out.println(find);
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "update debtors set total='"+finalsave+"' where invoiceno='"+find+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int y = stmt.executeUpdate();
            
            conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    
    
    }
        public void updatesalet(String invoice){
    
    
  //  double finalsave=amtsold+amtcurr;
    try {
       // String find=code.getText();
       // System.out.println(find);
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "delete from sales where invoiceno='"+invoice+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int y = stmt.executeUpdate();
            
            conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    
    
    }
        public void updateinv(){
    
    
  //  double finalsave=amtsold+amtcurr;
    try {
       // String find=code.getText();
       // System.out.println(find);
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "delete from invoice where sold='0'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int y = stmt.executeUpdate();
            
            conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    
    
    }
        public void updatedebt(String invoice){
    
    try {
       // String find=code.getText();
       // System.out.println(find);
           Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "delete from debtors where invoiceno='"+invoice+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int y = stmt.executeUpdate();
            
            conn.close();
        } catch (Exception exc) {  // process error
            exc.printStackTrace();
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    
    
    
        
    }
       
        public void getData2(){
    //cod=code.getText();
    
     
   // String [][] sample=null;
String str="SELECT distinct category from stock ";

		  Connection cn;
		  
		  Statement st;

		  try {
		   // Change the database name, hosty name,
		   // port and password as per MySQL installed in your PC.
		   cn=DriverManager.getConnection("jdbc:mysql://" +
		     "localhost:3306/inventory","root","this");
		   st=cn.createStatement();

		   rst=st.executeQuery(str);
                   
                 
if(rst.next()){
rst.last();

sample=new String [rst.getRow()][1];
rst.beforeFirst();
}
int rowcount=0;
   jComboBox7.removeAllItems();
		   while(rst.next())
		   {
                     
                       jComboBox7.addItem(rst.getString(1));
		    
sample[rowcount][0]=rst.getString(1);
//sample[rowcount][1]=rst.getString(2);
//sample[rowcount][2]=rst.getString(3);
//sample[rowcount][3]=rst.getString(4);
//sample[rowcount][4]=rst.getString(5);




		    
//System.out.println(sample[1][1]);		    
                   
                  
rowcount++;
                    
		   }
                  //rst.close();
                 // cn.close();

		  } catch (SQLException e) {
  JOptionPane.showMessageDialog(jPanel1,e,"Error!",JOptionPane.ERROR_MESSAGE);
		   e.printStackTrace();
		  }
                  data2=sample;
                 
		 }
            public void update_table(String name){



            String str="SELECT Itemcode as 'CODE',name as 'Name',description as 'DESCRIPTION',quantity as 'QUANTITY',reorder_level as 'REORDER',supplier as 'SUPPLIER',price as 'SELLING PRICE' from stock WHERE category = '"+name+"'";;


                    Connection cn;
                    ResultSet rs=null;
                    Statement st;

                    try {
                    // Change the database name, hosty name,
                    // port and password as per MySQL installed in your PC.
                    cn=DriverManager.getConnection("jdbc:mysql://" +
                        "localhost:3306/inventory","root","this");
                    st=cn.createStatement();

                    rs=st.executeQuery(str);
        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch(Exception ex){
                    ex.printStackTrace();

                    }





        }
            
               public void update_tablesearch(String name){



            String str="SELECT Itemcode as 'CODE',name as 'Name',description as 'DESCRIPTION',quantity as 'QUANTITY',reorder_level as 'REORDER',supplier as 'SUPPLIER',vat as 'VAT AMOUNT',price as 'SELLING PRICE' from stock WHERE name like '%"+name+"%'";;


                    Connection cn;
                    ResultSet rs=null;
                    Statement st;

                    try {
                    // Change the database name, hosty name,
                    // port and password as per MySQL installed in your PC.
                    cn=DriverManager.getConnection("jdbc:mysql://" +
                        "localhost:3306/inventory","root","this");
                    st=cn.createStatement();

                    rs=st.executeQuery(str);
        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch(Exception ex){
                    ex.printStackTrace();

                    }





        }
               public int checkExpired(){
               int f=0;
               

            Calendar cal=Calendar.getInstance();
        
        cal.add(Calendar.DATE,Integer.parseInt(find().toString()));
       String [][] sample=null;
        // "SELECT * FROM records where section='"+ssdg+"' && salary>0 order by f_name DESC"


 String sql = "SELECT a.prodid,b.name,a.batchno,a.invoiceno,a.date from expirydate a,stock b where b.Itemcode=a.prodid && date<='"+form.format(cal.getTime()) +"' && sold='0' ";

       
        
        

        try {
            // Change the database name, hosty name,
            // port and password as per MySQL installed in your PC.
            

java.sql.PreparedStatement st=db.prepareStatement(sql);
ResultSet rs=st.executeQuery();
           

           

            while (rs.next()) {

               f++;
               
        
            }
            rs.close();
           

        } catch (SQLException e) {

            e.printStackTrace();
        }


               
               
               return f;
               }
               
               
               public  Integer find(){
    int doub=0;
    
    BigDecimal bd=null;
    try {
        //DBConnection nn=new DBConnection();
           
           // Connection conn =nn.getDBConnection();
            String sql = "select days,Weeks,months from  expirydatesetting ";
            PreparedStatement stmt = db.prepareStatement(sql);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
           Double doub1=rs.getDouble(1)+(rs.getDouble(2)*7)+(rs.getDouble(3)*31);
             bd = new BigDecimal(doub1);
        bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
            }
           // System.out.println(sql);
            
            
          //  conn.close();
        } catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                     //  JOptionPane.showMessageDialog(jPanel1,"Sorry, connection Failed!\nOpen Xampp And Set MySql Running","Error!",JOptionPane.ERROR_MESSAGE);
//System.exit(0);
        }
    
    
    return Integer.parseInt(String.valueOf(bd));
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                home dialog = new home(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //this.dispose();
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
