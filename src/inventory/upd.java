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
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
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
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class upd extends JDialog
/*     */ {
/*  21 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  22 */   static String username = "root";
/*  23 */   static String password = "this";
/*     */   public JTextField id;
/*     */   public JButton jButton1;
/*     */   public JLabel jLabel1;
/*     */   public JLabel jLabel2;
/*     */   public JLabel jLabel3;
/*     */   public JLabel jLabel4;
/*     */   public JLabel jLabel5;
/*     */   public JPanel jPanel1;
/*     */   public JPanel jPanel2;
/*     */   public JTextField jTextField1;
/*     */   public JTextField jTextField3;
/*     */   public JTextField jTextField4;
/*     */ 
/*     */   public upd(Frame parent, boolean modal)
/*     */   {
/*  28 */     super(parent, modal);
/*  29 */     initComponents();
/*  30 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  44 */     this.jPanel1 = new JPanel();
/*  45 */     this.jLabel1 = new JLabel();
/*  46 */     this.jLabel2 = new JLabel();
/*  47 */     this.jLabel3 = new JLabel();
/*  48 */     this.id = new JTextField();
/*  49 */     this.jButton1 = new JButton();
/*  50 */     this.jTextField1 = new JTextField();
/*  51 */     this.jTextField3 = new JTextField();
/*  52 */     this.jTextField4 = new JTextField();
/*  53 */     this.jLabel4 = new JLabel();
/*  54 */     this.jPanel2 = new JPanel();
/*  55 */     this.jLabel5 = new JLabel();
/*     */ 
/*  57 */     setDefaultCloseOperation(2);
/*  58 */     setBackground(new Color(204, 204, 255));
/*     */ 
/*  60 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  62 */     this.jLabel1.setText("Name");
/*     */ 
/*  64 */     this.jLabel2.setText("Id no.");
/*     */ 
/*  66 */     this.jLabel3.setText("Phoneno");
/*     */ 
/*  68 */     this.jButton1.setBackground(new Color(204, 204, 204));
/*  69 */     this.jButton1.setText("ADD NEW CUSTOMER");
/*  70 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  72 */         upd.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  76 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  78 */         upd.this.jTextField1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  82 */     this.jLabel4.setText("Address");
/*     */ 
/*  84 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  85 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/*  87 */     this.jLabel5.setFont(new Font("Tahoma", 0, 12));
/*  88 */     this.jLabel5.setForeground(new Color(204, 204, 204));
/*  89 */     this.jLabel5.setText("NEW");
/*     */ 
/*  91 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  92 */     this.jPanel2.setLayout(jPanel2Layout);
/*  93 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  94 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  95 */       .addGroup(jPanel2Layout
/*  95 */       .createSequentialGroup()
/*  96 */       .addContainerGap()
/*  97 */       .addComponent(this.jLabel5, -2, 48, -2)
/*  98 */       .addContainerGap(275, 32767)));
/*     */ 
/* 100 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 101 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 102 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout
/* 102 */       .createSequentialGroup()
/* 103 */       .addGap(0, 14, 32767)
/* 104 */       .addComponent(this.jLabel5)));
/*     */ 
/* 107 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 108 */     this.jPanel1.setLayout(jPanel1Layout);
/* 109 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 110 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 111 */       .addGroup(jPanel1Layout
/* 111 */       .createSequentialGroup()
/* 112 */       .addGap(43, 43, 43)
/* 113 */       .addGroup(jPanel1Layout
/* 113 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 114 */       .addComponent(this.jLabel3)
/* 115 */       .addComponent(this.jLabel1)
/* 116 */       .addComponent(this.jLabel2)
/* 117 */       .addComponent(this.jLabel4))
/* 118 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 119 */       .addGroup(jPanel1Layout
/* 119 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 120 */       .addComponent(this.jTextField3, -1, 190, 32767)
/* 121 */       .addComponent(this.jTextField1)
/* 122 */       .addComponent(this.jTextField4)
/* 123 */       .addComponent(this.id)))
/* 124 */       .addGroup(jPanel1Layout
/* 124 */       .createSequentialGroup()
/* 125 */       .addGap(112, 112, 112)
/* 126 */       .addComponent(this.jButton1))
/* 127 */       .addComponent(this.jPanel2, -2, -1, -2));
/*     */ 
/* 129 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 130 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 131 */       .addGroup(jPanel1Layout
/* 131 */       .createSequentialGroup()
/* 132 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 133 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 134 */       .addGroup(jPanel1Layout
/* 134 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 135 */       .addComponent(this.jLabel1)
/* 136 */       .addComponent(this.jTextField1, -2, -1, -2))
/* 137 */       .addGap(18, 18, 18)
/* 138 */       .addGroup(jPanel1Layout
/* 138 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 139 */       .addComponent(this.jLabel3)
/* 140 */       .addComponent(this.jTextField3, -2, -1, -2))
/* 141 */       .addGap(21, 21, 21)
/* 142 */       .addGroup(jPanel1Layout
/* 142 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 143 */       .addComponent(this.id, -2, -1, -2)
/* 144 */       .addComponent(this.jLabel2))
/* 145 */       .addGap(18, 18, 18)
/* 146 */       .addGroup(jPanel1Layout
/* 146 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 147 */       .addComponent(this.jTextField4, -2, -1, -2)
/* 148 */       .addComponent(this.jLabel4))
/* 149 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 150 */       .addComponent(this.jButton1)
/* 151 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 154 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 155 */     getContentPane().setLayout(layout);
/* 156 */     layout.setHorizontalGroup(layout
/* 157 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 158 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 160 */     layout.setVerticalGroup(layout
/* 161 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 162 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 165 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 169 */     int u = check();
/*     */ 
/* 171 */     if ((this.jTextField1.getText() == null) || (this.jTextField1.getText().equals(""))) {
/* 172 */       JOptionPane.showMessageDialog(null, "Enter NAME.", "Missing fields", -1);
/* 173 */       this.jTextField1.requestFocus();
/* 174 */       return;
/*     */     }
/* 176 */     if ((this.jTextField3.getText() == null) || (this.jTextField3.getText().equals(""))) {
/* 177 */       JOptionPane.showMessageDialog(null, "Enter PHONE NUMBER.", "Missing fields", -1);
/* 178 */       this.jTextField3.requestFocus();
/* 179 */       return;
/*     */     }
/* 181 */     if ((this.id.getText() == null) || (this.id.getText().equals(""))) {
/* 182 */       JOptionPane.showMessageDialog(null, "Enter ID NUMBER.", "Missing fields", -1);
/* 183 */       this.id.requestFocus();
/* 184 */       return;
/*     */     }
/*     */ 
/* 187 */     if ((this.jTextField4.getText() == null) || (this.jTextField4.getText().equals(""))) {
/* 188 */       JOptionPane.showMessageDialog(null, "Enter ADDRESS NUMBER", "Missing fields", -1);
/* 189 */       this.jTextField4.requestFocus();
/* 190 */       return;
/*     */     }
/* 192 */     if (u > 0) {
/* 193 */       JOptionPane.showMessageDialog(null, "This customer already exists", "Error!", 0);
/*     */     }
/*     */     else
/*     */     {
/* 197 */       saveCos();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void saveCos()
/*     */   {
/*     */     try
/*     */     {
/* 205 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 206 */       Connection connection = DriverManager.getConnection(url, username, password);
/*     */ 
/* 208 */       PreparedStatement psmnt = connection
/* 208 */         .prepareStatement("INSERT INTO  customer values(?,?,?,?,?)");
/*     */ 
/* 209 */       psmnt.setString(1, null);
/* 210 */       psmnt.setString(2, this.jTextField1.getText());
/* 211 */       psmnt.setString(3, this.jTextField3.getText());
/* 212 */       psmnt.setString(4, this.id.getText());
/* 213 */       psmnt.setString(5, this.jTextField4.getText());
/*     */ 
/* 219 */       int s = psmnt.executeUpdate();
/* 220 */       psmnt.close();
/*     */ 
/* 222 */       this.jTextField1.setText("");
/* 223 */       this.id.setText("");
/* 224 */       this.jTextField3.setText("");
/* 225 */       this.jTextField4.setText("");
/*     */ 
/* 228 */       if (s > 0) {
/* 229 */         System.out.println("sucessfull  ");
/* 230 */         JOptionPane.showMessageDialog(null, " All Details Were Saved!", "saved!", 1);
/*     */       }
/*     */       else {
/* 233 */         System.out.println("unsucessfull to upload ");
/* 234 */         JOptionPane.showMessageDialog(null, "Sorry, Not All Details Were Saved!", "Error!", 0);
/*     */       }
/* 236 */       connection.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 240 */       System.out.println("Found some error : " + ex);
/* 241 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */     finally
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public int check()
/*     */   {
/* 250 */     int y = 0;
/* 251 */     String str = "SELECT * from customer where idno='" + this.id.getText() + "'";
/*     */     try
/*     */     {
/* 260 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 262 */       Statement st = cn.createStatement();
/*     */ 
/* 264 */       ResultSet rs = st.executeQuery(str);
/* 265 */       while (rs.next()) {
/* 266 */         y = 1;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/* 272 */     return y;
/*     */   }
/*     */ 
/*     */   private void jTextField1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 288 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 289 */         if ("windows".equals(info.getName())) {
/* 290 */           UIManager.setLookAndFeel(info.getClassName());
/* 291 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 295 */       Logger.getLogger(upd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 297 */       Logger.getLogger(upd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 299 */       Logger.getLogger(upd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 301 */       Logger.getLogger(upd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 306 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 308 */         upd dialog = new upd(new JFrame(), true);
/* 309 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 312 */             System.exit(0);
/*     */           }
/*     */         });
/* 315 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.upd
 * JD-Core Version:    0.6.0
 */