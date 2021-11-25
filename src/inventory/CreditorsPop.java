/*     */ package inventory;
/*     */ 
/*     */ import com.mysql.jdbc.Statement;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
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
/*     */ 
/*     */ public class CreditorsPop extends JDialog
/*     */ {
             int s;
/*  24 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  25 */   static String username = "root";
/*  26 */   static String password = "this";
/*     */   ResultSet ris;
/*     */   ResultSet rst;
/*     */   String chosen;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   private JTextField jTextField3;
/*     */   private JTextField jTextField4;
/*     */   private JTextField jTextField5;
/*     */   private JTextField jTextField6;
/*     */ 
/*     */   public CreditorsPop(Frame parent, boolean modal)
/*     */   {
/*  33 */     super(parent, modal);
/*  34 */     initComponents();
/*  35 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */   public void fill(String supp, String invoiceno, String amtpaid, String totamt) {
/*  39 */     this.jTextField3.setText(supp);
/*  40 */     this.jTextField6.setText(invoiceno);
/*  41 */     this.jTextField1.setText(amtpaid);
/*  42 */     this.jTextField2.setText(totamt);
/*  43 */     this.jTextField4.setText(String.valueOf(Double.parseDouble(totamt) - Double.parseDouble(amtpaid)));
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  57 */     this.jPanel1 = new JPanel();
/*  58 */     this.jPanel2 = new JPanel();
/*  59 */     this.jLabel3 = new JLabel();
/*  60 */     this.jTextField2 = new JTextField();
/*  61 */     this.jLabel2 = new JLabel();
/*  62 */     this.jTextField1 = new JTextField();
/*  63 */     this.jLabel4 = new JLabel();
/*  64 */     this.jTextField4 = new JTextField();
/*  65 */     this.jLabel5 = new JLabel();
/*  66 */     this.jTextField5 = new JTextField();
/*  67 */     this.jButton1 = new JButton();
/*  68 */     this.jButton2 = new JButton();
/*  69 */     this.jButton3 = new JButton();
/*  70 */     this.jLabel1 = new JLabel();
/*  71 */     this.jTextField3 = new JTextField();
/*  72 */     this.jLabel6 = new JLabel();
/*  73 */     this.jTextField6 = new JTextField();
/*     */ 
/*  75 */     setDefaultCloseOperation(2);
/*     */ 
/*  77 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  79 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*     */ 
/*  81 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  82 */     this.jPanel2.setLayout(jPanel2Layout);
/*  83 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  84 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  85 */       .addGap(0, 372, 32767));
/*     */ 
/*  87 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  88 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  89 */       .addGap(0, 33, 32767));
/*     */ 
/*  92 */     this.jLabel3.setText("TOTAL AMOUNT:");
/*     */ 
/*  94 */     this.jTextField2.setEditable(false);
/*  95 */     this.jTextField2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  97 */         CreditorsPop.this.jTextField2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 101 */     this.jLabel2.setText("AMOUNT  PAID:");
/*     */ 
/* 103 */     this.jTextField1.setEditable(false);
/*     */ 
/* 105 */     this.jLabel4.setText("AMOUNT DUE:");
/*     */ 
/* 107 */     this.jTextField4.setEditable(false);
/* 108 */     this.jTextField4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 110 */         CreditorsPop.this.jTextField4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 114 */     this.jLabel5.setText("ENTER AMOUNT(KSH):");
/*     */ 
/* 116 */     this.jButton1.setText("SAVE");
/* 117 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 119 */         CreditorsPop.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 123 */     this.jButton2.setText("SUMMARY");
/* 124 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 126 */         CreditorsPop.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 130 */     this.jButton3.setText("VIEW INVOICE");
/* 131 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 133 */         CreditorsPop.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 137 */     this.jLabel1.setText("NAME:");
/*     */ 
/* 139 */     this.jTextField3.setEditable(false);
/*     */ 
/* 141 */     this.jLabel6.setText("INVOICE NO:");
/*     */ 
/* 143 */     this.jTextField6.setEditable(false);
/*     */ 
/* 145 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 146 */     this.jPanel1.setLayout(jPanel1Layout);
/* 147 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 148 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 149 */       .addGroup(jPanel1Layout
/* 149 */       .createSequentialGroup()
/* 150 */       .addContainerGap()
/* 151 */       .addGroup(jPanel1Layout
/* 151 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 152 */       .addGroup(jPanel1Layout
/* 152 */       .createSequentialGroup()
/* 153 */       .addComponent(this.jButton1)
/* 154 */       .addGap(18, 18, 18)
/* 155 */       .addComponent(this.jButton2)
/* 156 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 157 */       .addComponent(this.jButton3))
/* 158 */       .addGroup(jPanel1Layout
/* 158 */       .createSequentialGroup()
/* 159 */       .addGroup(jPanel1Layout
/* 159 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 160 */       .addComponent(this.jLabel4)
/* 161 */       .addComponent(this.jLabel5)
/* 162 */       .addComponent(this.jLabel3)
/* 163 */       .addComponent(this.jLabel2)
/* 164 */       .addComponent(this.jLabel1)
/* 165 */       .addComponent(this.jLabel6))
/* 166 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 167 */       .addGroup(jPanel1Layout
/* 167 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 168 */       .addComponent(this.jTextField3, -2, 211, -2)
/* 169 */       .addGroup(jPanel1Layout
/* 169 */       .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 170 */       .addComponent(this.jTextField6, GroupLayout.Alignment.LEADING, -1, 123, 32767)
/* 171 */       .addComponent(this.jTextField5, GroupLayout.Alignment.LEADING)
/* 172 */       .addComponent(this.jTextField4, GroupLayout.Alignment.LEADING)
/* 173 */       .addComponent(this.jTextField2, GroupLayout.Alignment.LEADING)
/* 174 */       .addComponent(this.jTextField1, GroupLayout.Alignment.LEADING)))))
/* 175 */       .addContainerGap())
/* 176 */       .addGroup(jPanel1Layout
/* 176 */       .createSequentialGroup()
/* 177 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 178 */       .addGap(0, 0, 32767)));
/*     */ 
/* 180 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 181 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 182 */       .addGroup(jPanel1Layout
/* 182 */       .createSequentialGroup()
/* 183 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 184 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 185 */       .addGroup(jPanel1Layout
/* 185 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 186 */       .addComponent(this.jLabel1)
/* 187 */       .addComponent(this.jTextField3, -2, -1, -2))
/* 188 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, 32767)
/* 189 */       .addGroup(jPanel1Layout
/* 189 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 190 */       .addComponent(this.jTextField6, -2, -1, -2)
/* 191 */       .addComponent(this.jLabel6))
/* 192 */       .addGap(21, 21, 21)
/* 193 */       .addGroup(jPanel1Layout
/* 193 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 194 */       .addComponent(this.jLabel2)
/* 195 */       .addComponent(this.jTextField1, -2, -1, -2))
/* 196 */       .addGap(29, 29, 29)
/* 197 */       .addGroup(jPanel1Layout
/* 197 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 198 */       .addComponent(this.jTextField2, -2, -1, -2)
/* 199 */       .addComponent(this.jLabel3))
/* 200 */       .addGap(26, 26, 26)
/* 201 */       .addGroup(jPanel1Layout
/* 201 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 202 */       .addComponent(this.jLabel4)
/* 203 */       .addComponent(this.jTextField4, -2, -1, -2))
/* 204 */       .addGap(24, 24, 24)
/* 205 */       .addGroup(jPanel1Layout
/* 205 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 206 */       .addComponent(this.jLabel5)
/* 207 */       .addComponent(this.jTextField5, -2, -1, -2))
/* 208 */       .addGap(18, 18, 18)
/* 209 */       .addGroup(jPanel1Layout
/* 209 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 210 */       .addComponent(this.jButton1)
/* 211 */       .addComponent(this.jButton2)
/* 212 */       .addComponent(this.jButton3))));
/*     */ 
/* 215 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 216 */     getContentPane().setLayout(layout);
/* 217 */     layout.setHorizontalGroup(layout
/* 218 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 219 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 221 */     layout.setVerticalGroup(layout
/* 222 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 223 */       .addGroup(layout
/* 223 */       .createSequentialGroup()
/* 224 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 225 */       .addGap(0, 0, 32767)));
/*     */ 
/* 228 */     pack();
/*     */   }
/*     */ 
/*     */   private void jTextField2ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jTextField4ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 240 */     String v = null;
/*     */     try
/*     */     {
/* 245 */       String str1 = "Select amtpaid from purchasedpaid where invoiceno= '" + this.jTextField6.getText() + "' ";
/*     */ 
/* 248 */       com.mysql.jdbc.Connection cn1 = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 250 */       Statement st3 = (Statement)cn1.createStatement();
/*     */ 
/* 253 */       ResultSet rs2 = st3.executeQuery(str1);
/* 254 */       while (rs2.next()) {
/* 255 */         v = rs2.getString(1);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 261 */       ex.printStackTrace();
/*     */     }
/*     */ 
/* 265 */     System.out.println(v);
/* 266 */     if (this.jTextField5.getText().equals("")) {
/* 267 */       JOptionPane.showMessageDialog(null, "Enter AMOUNT PAID", "Missing fields", 0);
/* 268 */       this.jTextField5.requestFocus();
/* 269 */       return;
/*     */     }
/*     */ 
/* 272 */     double u = Double.parseDouble(this.jTextField4.getText());
/* 273 */     double k = Double.parseDouble(this.jTextField5.getText());
/* 274 */     if (k > u) {
/* 275 */       JOptionPane.showMessageDialog(null, "ITS MORE THAN OWED", "ERROR IN AMOUNT", 1);
/* 276 */     } else if (k <= u) {
/* 277 */       inserter();
/* 278 */       String k1 = String.valueOf(Double.parseDouble(this.jTextField1.getText()) + Double.parseDouble(this.jTextField5.getText()));
/* 279 */       String str = "update purchasedpaid set amtpaid ='" + k1 + "' where invoiceno= '" + this.jTextField6.getText() + "'";
/*     */       try
/*     */       {
/* 288 */         com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 290 */         Statement st = (Statement)cn.createStatement();
/*     */ 
/* 292 */         int s = st.executeUpdate(str);
/*     */ 
/* 294 */         if (s > 0) {
/* 295 */           JOptionPane.showMessageDialog(null, "Saved!", "Done", 1);
/*     */         }
/*     */ 
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 302 */         ex.printStackTrace();
/*     */       }
/*     */ 
/* 305 */       this.jTextField1.setText("");
/* 306 */       this.jTextField2.setText("");
/*     */ 
/* 308 */       this.jTextField4.setText("");
/* 309 */       this.jTextField5.setText("");
/*     */     }
/* 311 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 316 */       trunc();
/* 317 */       trunc2();
/* 318 */       insertholder();
/* 319 */       insertholder2();
/* 320 */       purchasesum ma = new purchasesum(new JFrame(), true);
/* 321 */       ma.initConnection();
/* 322 */       ma.showReport();
/*     */     }
/*     */     catch (FileNotFoundException ex) {
/* 325 */       Logger.getLogger(Creditors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 331 */     if (this.jTextField2.equals(""))
/* 332 */       JOptionPane.showMessageDialog(null, "No Invoice Selected", "Error", 0);
/*     */     else
/*     */       try
/*     */       {
/* 336 */         trunc3();
/* 337 */         trunc2();
/* 338 */         insertholder3();
/* 339 */         insertholder2();
/* 340 */         purchasejasper ma = new purchasejasper();
/* 341 */         ma.initConnection();
/* 342 */         ma.showReport();
/*     */       }
/*     */       catch (FileNotFoundException ex) {
/* 345 */         Logger.getLogger(purchases.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void inserter()
/*     */   {
/* 351 */     Calendar currentDate = Calendar.getInstance();
/*     */ 
/* 353 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*     */     try
/*     */     {
/* 357 */       this.chosen = formatter.format(currentDate.getTime());
/*     */ 
/* 359 */       System.out.println(this.chosen);
/*     */     } catch (Exception e) {
/* 361 */       System.out.println(e);
/*     */     }
/*     */ 
/* 365 */     java.sql.Connection connection = null;
/* 366 */     java.sql.PreparedStatement psmnt = null;
/*     */     try
/*     */     {
/* 369 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 370 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 371 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement("INSERT INTO trancpurchases values(?,?,?,?)");
/*     */ 
                int s;
/* 376 */       psmnt.setString(1, this.jTextField6.getText());
/* 377 */       psmnt.setString(2, this.jTextField5.getText());
/* 378 */       psmnt.setString(3, this.jTextField3.getText());
/*     */ 
/* 380 */       psmnt.setString(4, this.chosen);
/* 381 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 385 */       System.out.println("Found some error : " + ex);
/* 386 */       JOptionPane.showMessageDialog(null, "Error 2222" + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trunc2()
/*     */   {
/* 395 */     java.sql.Connection connection = null;
/* 396 */     com.mysql.jdbc.PreparedStatement stmt = null;
/*     */     try
/*     */     {
/* 399 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 400 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 401 */       String sql = "truncate table purchasedpaidholder";
/* 402 */       stmt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
                   int s;
/* 405 */       s = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       
/* 409 */       System.out.println("Found some error : " + ex);
/* 410 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trunc()
/*     */   {
/* 417 */     java.sql.Connection connection = null;
/* 418 */     com.mysql.jdbc.PreparedStatement stmt = null;
/*     */     try
/*     */     {
/* 421 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 422 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 423 */       String sql = "truncate table trancpurchasesholder";
/* 424 */       stmt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 427 */       s = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 431 */       System.out.println("Found some error : " + ex);
/* 432 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insertholder2()
/*     */   {
/* 438 */     java.sql.Connection connection = null;
/* 439 */     java.sql.PreparedStatement psmnt = null;
/*     */     try {
/* 441 */       String sql = "INSERT INTO purchasedpaidholder (amtpaid,amtowed,date,supplier,invoiceno) select amtpaid,amtowed,date,supplier,invoiceno from purchasedpaid where invoiceno='" + this.jTextField6.getText() + "'&& supplier='" + this.jTextField3.getText() + "'";
/*     */ 
/* 444 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 445 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 446 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 449 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 453 */       System.out.println("Found some error : " + ex);
/* 454 */       JOptionPane.showMessageDialog(null, "Error 232" + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insertholder()
/*     */   {
/* 463 */     java.sql.Connection connection = null;
/* 464 */     java.sql.PreparedStatement psmnt = null;
/*     */     try {
/* 466 */       String sql = "INSERT INTO trancpurchasesholder (amtpaid,date) select amtpaid,date from trancpurchases where invoiceno='" + this.jTextField6.getText() + "'&& supplier='" + this.jTextField3.getText() + "'";
/*     */ 
/* 469 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 470 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 471 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 474 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 478 */       System.out.println("Found some error : " + ex);
/* 479 */       JOptionPane.showMessageDialog(null, "Error 2222" + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insertholder3()
/*     */   {
/* 489 */     java.sql.Connection connection = null;
/* 490 */     java.sql.PreparedStatement psmnt = null;
/*     */     try
/*     */     {
/* 494 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 495 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 496 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement("INSERT INTO purchaseholder(invoiceno,supplier,Itemcode,name,description,quantity,price,date) select code,supplier,itemcode,name,description,quantity,price,date from purchases where code='" + this.jTextField6.getText() + "' && supplier='" + this.jTextField3.getText() + "'");
/*     */ 
/* 502 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 506 */       System.out.println("Found some error : " + ex);
/* 507 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trunc3()
/*     */   {
/* 514 */     java.sql.Connection connection = null;
/* 515 */     com.mysql.jdbc.PreparedStatement stmt = null;
/*     */     try
/*     */     {
/* 518 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 519 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 520 */       String sql = "truncate table purchaseholder";
/* 521 */       stmt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 524 */       s = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 528 */       System.out.println("Found some error : " + ex);
/* 529 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 550 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 551 */         if ("Nimbus".equals(info.getName())) {
/* 552 */           UIManager.setLookAndFeel(info.getClassName());
/* 553 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 557 */       Logger.getLogger(CreditorsPop.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 559 */       Logger.getLogger(CreditorsPop.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 561 */       Logger.getLogger(CreditorsPop.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 563 */       Logger.getLogger(CreditorsPop.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 570 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 573 */         CreditorsPop dialog = new CreditorsPop(new JFrame(), true);
/* 574 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 578 */             System.exit(0);
/*     */           }
/*     */         });
/* 581 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.CreditorsPop
 * JD-Core Version:    0.6.0
 */