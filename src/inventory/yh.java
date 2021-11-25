/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ public class yh extends JDialog
/*     */ {
/*  22 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  23 */   static String username = "root";
/*  24 */   static String password = "this";
/*  25 */   String idn = "";
/*     */   public JButton jButton1;
/*     */   public JComboBox jComboBox1;
/*     */   public JLabel jLabel1;
/*     */   public JLabel jLabel2;
/*     */   public JLabel jLabel3;
/*     */   public JLabel jLabel4;
/*     */   public JLabel jLabel5;
/*     */   public JPanel jPanel2;
/*     */   public JPanel jPanel3;
/*     */   public JTextField jTextField2;
/*     */   public JTextField jTextField3;
/*     */   public JTextField jTextField4;
/*     */ 
/*     */   public yh(Frame parent, boolean modal)
/*     */   {
/*  30 */     super(parent, modal);
/*  31 */     initComponents();
/*  32 */     setLocationRelativeTo(null);
/*     */     try {
/*  34 */       Class.forName("com.mysql.jdbc.Driver");
/*  35 */       Connection conn = DriverManager.getConnection(url, username, password);
/*  36 */       Statement st = conn.createStatement();
/*  37 */       ResultSet rs = st.executeQuery("Select * from customer");
/*  38 */       while (rs.next())
/*     */       {
/*  40 */         this.jComboBox1.addItem(rs.getString("name"));
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  59 */     this.jPanel2 = new JPanel();
/*  60 */     this.jLabel2 = new JLabel();
/*  61 */     this.jLabel3 = new JLabel();
/*  62 */     this.jTextField2 = new JTextField();
/*  63 */     this.jTextField3 = new JTextField();
/*  64 */     this.jTextField4 = new JTextField();
/*  65 */     this.jLabel4 = new JLabel();
/*  66 */     this.jComboBox1 = new JComboBox();
/*  67 */     this.jLabel1 = new JLabel();
/*  68 */     this.jButton1 = new JButton();
/*  69 */     this.jPanel3 = new JPanel();
/*  70 */     this.jLabel5 = new JLabel();
/*     */ 
/*  72 */     setDefaultCloseOperation(2);
/*     */ 
/*  74 */     this.jPanel2.setBackground(new Color(153, 153, 255));
/*     */ 
/*  76 */     this.jLabel2.setText("Id No.");
/*     */ 
/*  78 */     this.jLabel3.setText("Phoneno");
/*     */ 
/*  80 */     this.jLabel4.setText("Address");
/*     */ 
/*  82 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  84 */         yh.this.jComboBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  88 */     this.jLabel1.setText("Name");
/*     */ 
/*  90 */     this.jButton1.setText("UPDATE");
/*  91 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  93 */         yh.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  97 */     this.jPanel3.setBackground(new Color(0, 0, 0));
/*     */ 
/*  99 */     this.jLabel5.setBackground(new Color(0, 0, 0));
/* 100 */     this.jLabel5.setFont(new Font("Times New Roman", 1, 12));
/* 101 */     this.jLabel5.setForeground(new Color(204, 204, 204));
/* 102 */     this.jLabel5.setText("CUSTOMER DETAILS");
/*     */ 
/* 104 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 105 */     this.jPanel3.setLayout(jPanel3Layout);
/* 106 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 107 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 108 */       .addGroup(jPanel3Layout
/* 108 */       .createSequentialGroup()
/* 109 */       .addGap(25, 25, 25)
/* 110 */       .addComponent(this.jLabel5, -2, 146, -2)
/* 111 */       .addContainerGap(198, 32767)));
/*     */ 
/* 113 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 114 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 115 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout
/* 115 */       .createSequentialGroup()
/* 116 */       .addContainerGap(-1, 32767)
/* 117 */       .addComponent(this.jLabel5)
/* 118 */       .addContainerGap()));
/*     */ 
/* 121 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 122 */     this.jPanel2.setLayout(jPanel2Layout);
/* 123 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 124 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 125 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 126 */       .addGroup(jPanel2Layout
/* 126 */       .createSequentialGroup()
/* 127 */       .addGap(43, 43, 43)
/* 128 */       .addGroup(jPanel2Layout
/* 128 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 129 */       .addComponent(this.jLabel3)
/* 130 */       .addComponent(this.jLabel2)
/* 131 */       .addComponent(this.jLabel4)
/* 132 */       .addComponent(this.jLabel1))
/* 133 */       .addGap(57, 57, 57)
/* 134 */       .addGroup(jPanel2Layout
/* 134 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 135 */       .addComponent(this.jButton1)
/* 136 */       .addComponent(this.jTextField4, -2, 149, -2)
/* 137 */       .addGroup(jPanel2Layout
/* 137 */       .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 138 */       .addComponent(this.jTextField2, GroupLayout.Alignment.LEADING)
/* 139 */       .addComponent(this.jComboBox1, GroupLayout.Alignment.LEADING, 0, 148, 32767)
/* 140 */       .addComponent(this.jTextField3, GroupLayout.Alignment.LEADING)))));
/*     */ 
/* 142 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 143 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 144 */       .addGroup(jPanel2Layout
/* 144 */       .createSequentialGroup()
/* 145 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 146 */       .addGap(17, 17, 17)
/* 147 */       .addGroup(jPanel2Layout
/* 147 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 148 */       .addComponent(this.jComboBox1, -2, -1, -2)
/* 149 */       .addComponent(this.jLabel1))
/* 150 */       .addGap(26, 26, 26)
/* 151 */       .addGroup(jPanel2Layout
/* 151 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 152 */       .addComponent(this.jTextField3, -2, -1, -2)
/* 153 */       .addComponent(this.jLabel3))
/* 154 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767)
/* 155 */       .addGroup(jPanel2Layout
/* 155 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 156 */       .addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING)
/* 157 */       .addComponent(this.jTextField2, GroupLayout.Alignment.TRAILING, -2, -1, -2))
/* 158 */       .addGap(24, 24, 24)
/* 159 */       .addGroup(jPanel2Layout
/* 159 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 160 */       .addComponent(this.jTextField4, -2, -1, -2)
/* 161 */       .addComponent(this.jLabel4))
/* 162 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 163 */       .addComponent(this.jButton1)));
/*     */ 
/* 166 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 167 */     getContentPane().setLayout(layout);
/* 168 */     layout.setHorizontalGroup(layout
/* 169 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 170 */       .addComponent(this.jPanel2, -2, -1, -2));
/*     */ 
/* 172 */     layout.setVerticalGroup(layout
/* 173 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 174 */       .addComponent(this.jPanel2, -1, -1, 32767));
/*     */ 
/* 177 */     pack();
/*     */   }
/*     */   public void setid(String id) {
/* 180 */     this.idn = id;
/*     */   }
/*     */ 
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 184 */     String g = (String)this.jComboBox1.getSelectedItem();
/*     */     try {
/* 186 */       Class.forName("com.mysql.jdbc.Driver");
/* 187 */       Connection conn = DriverManager.getConnection(url, username, password);
/* 188 */       Statement st = conn.createStatement();
/* 189 */       ResultSet rs = st.executeQuery("Select * from customer where name = '" + g + "'");
/* 190 */       while (rs.next()) {
/* 191 */         this.jTextField2.setText(rs.getString(3));
/* 192 */         this.jTextField3.setText(rs.getString(4));
/* 193 */         this.jTextField4.setText(rs.getString(5));
/*     */       }
/*     */     }
/*     */     catch (SQLException e) {
/* 197 */       e.printStackTrace();
/*     */     } catch (Exception f) {
/* 199 */       f.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try
/*     */     {
/* 210 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 211 */       Connection connection = DriverManager.getConnection(url, username, password);
/*     */ 
/* 213 */       PreparedStatement psmnt = connection.prepareStatement("update customer set phoneno='" + this.jTextField2.getText() + "', idno='" + this.jTextField3.getText() + "',address='" + this.jTextField4.getText() + "' where && idno='" + this.idn + "' ");
/*     */ 
/* 215 */       int r = psmnt.executeUpdate();
/* 216 */       if (r > 0)
/*     */       {
/* 218 */         JOptionPane.showMessageDialog(null, "Successful", "Updated", 1);
/*     */       }
/*     */       else {
/* 221 */         JOptionPane.showMessageDialog(null, "did not update", "error", -1);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 228 */       e.printStackTrace();
/* 229 */       JOptionPane.showMessageDialog(null, "did not update", "error", -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 243 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 244 */         if ("windows".equals(info.getName())) {
/* 245 */           UIManager.setLookAndFeel(info.getClassName());
/* 246 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 250 */       Logger.getLogger(yh.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 252 */       Logger.getLogger(yh.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 254 */       Logger.getLogger(yh.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 256 */       Logger.getLogger(yh.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 261 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 263 */         yh dialog = new yh(new JFrame(), true);
/* 264 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 267 */             System.exit(0);
/*     */           }
/*     */         });
/* 270 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.yh
 * JD-Core Version:    0.6.0
 */