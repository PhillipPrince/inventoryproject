/*     */ package inventory;
/*     */ 
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import net.proteanit.sql.DbUtils;
/*     */ 
/*     */ public class Creditors extends JFrame
/*     */ {
/*  32 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  33 */   static String username = "root";
/*  34 */   static String password = "this";
/*     */   ResultSet ris;
/*     */   ResultSet rst;
/*     */   JTable table;
/*     */   JTable table2;
/*  37 */   String[][] data = (String[][])null;
/*     */   String code;
/*     */   String chosen;
/*     */   String invno;
/*     */   String supp;
/*  42 */   String[][] data2 = (String[][])null;
/*     */   public JButton jButton1;
/*     */   public JDateChooser jDateChooser1;
/*     */   public JDateChooser jDateChooser2;
/*     */   public JLabel jLabel1;
/*     */   public JLabel jLabel2;
/*     */   public JPanel jPanel1;
/*     */   public JPanel jPanel2;
/*     */   public JPanel jPanel3;
/*     */   public JPanel jPanel5;
/*     */ 
/*     */   public Creditors(Frame parent, boolean modal)
/*     */   {
/*  48 */     initComponents();
/*     */ 
/*  50 */     setAlwaysOnTop(false);
/*  51 */     setLocationRelativeTo(null);
/*  52 */     setResizable(false);
/*  53 */     setDefaultCloseOperation(2);
/*     */ 
/*  55 */     setLocationRelativeTo(null);
/*     */ 
/*  57 */     setTitle("Creditors");
/*  58 */     this.data = getData();
/*  59 */     table();
/*     */   }
/*     */ 
/*     */   public void table()
/*     */   {
/*  69 */     String[] headers = { "SUPPLIER", "INVOICE NO", "AMT OWED", "AMT PAID", "DATE" };
/*     */ 
/*  74 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/*  75 */     model.fireTableDataChanged();
/*  76 */     this.table = new JTable(model);
/*     */ 
/*  79 */     JScrollPane scrollPane = new JScrollPane(this.table);
/*     */ 
/*  81 */     this.jPanel3.add(scrollPane, "Center");
/*  82 */     scrollPane.setBounds(0, 0, 744, 296);
/*  83 */     this.table.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e)
/*     */       {
/*  87 */         int row = Creditors.this.table.getSelectedRow();
/*  88 */         int col = Creditors.this.table.getSelectedColumn();
/*  89 */         Creditors.this.invno = Creditors.this.data[row][1];
/*  90 */         Creditors.this.supp = Creditors.this.data[row][0];
/*  91 */         String amtpaid = Creditors.this.data[row][3];
/*  92 */         String tot = Creditors.this.data[row][2];
/*  93 */         CreditorsPop nn3 = new CreditorsPop(new JFrame(), true);
/*  94 */         nn3.fill(Creditors.this.supp, Creditors.this.invno, amtpaid, tot);
/*     */ 
/*  96 */         nn3.setVisible(true);
/*  97 */         Creditors.this.data = Creditors.this.getData2();
/*  98 */         Creditors.this.update_table();
/*     */ 
/* 101 */         Creditors.this.getData2(Creditors.this.code);
/*     */ 
/* 106 */         System.out.println("row is " + row + " and " + col + "" + Creditors.this.code);
/*     */       } } );
/*     */   }
/*     */ 
/*     */   public String[][] getData() {
/* 112 */     String[][] sample = (String[][])null;
/* 113 */     String str = "SELECT supplier,invoiceno,amtowed,amtpaid,date from purchasedpaid WHERE amtowed > amtpaid";
/*     */     try
/*     */     {
/* 122 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 124 */       Statement st = cn.createStatement();
/*     */ 
/* 126 */       ResultSet rs = st.executeQuery(str);
/*     */ 
/* 129 */       if (rs.next()) {
/* 130 */         rs.last();
/*     */ 
/* 132 */         sample = new String[rs.getRow()][5];
/* 133 */         rs.beforeFirst();
/*     */       }
/* 135 */       int rowcount = 0;
/*     */ 
/* 137 */       while (rs.next())
/*     */       {
/* 140 */         sample[rowcount][0] = rs.getString(1);
/* 141 */         sample[rowcount][1] = rs.getString(2);
/* 142 */         sample[rowcount][2] = rs.getString(3);
/* 143 */         sample[rowcount][3] = rs.getString(4);
/* 144 */         sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 150 */         System.out.println(sample[rowcount][0]);
/*     */ 
/* 153 */         rowcount++;
/*     */       }
/*     */ 
/* 156 */       rs.close();
/* 157 */       cn.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 161 */       e.printStackTrace();
/*     */     }
/* 163 */     return sample;
/*     */   }
/*     */ 
/*     */   public String[][] getData2()
/*     */   {
/* 168 */     String start = "";
/* 169 */     String stop = "";
/* 170 */     SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
/* 171 */     Date now = dateToday();
/*     */     try {
/* 173 */       start = form.format(this.jDateChooser1.getDate());
/*     */ 
/* 175 */       stop = form.format(this.jDateChooser2.getDate());
/*     */     }
/*     */     catch (Exception e) {
/* 178 */       start = "";
/* 179 */       stop = "";
/*     */     }
/*     */ 
/* 185 */     String[][] sample = (String[][])null;
/*     */ 
/* 187 */     if ((start.equals("")) || (stop.equals(""))) {
/* 188 */       String str = "SELECT supplier,invoiceno,amtowed,amtpaid,date from purchasedpaid WHERE amtowed > amtpaid";
/*     */       try
/*     */       {
/* 197 */         java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 199 */         Statement st = cn.createStatement();
/*     */ 
/* 201 */         ResultSet rs = st.executeQuery(str);
/*     */ 
/* 204 */         if (rs.next()) {
/* 205 */           rs.last();
/*     */ 
/* 207 */           sample = new String[rs.getRow()][5];
/* 208 */           rs.beforeFirst();
/*     */         }
/* 210 */         int rowcount = 0;
/*     */ 
/* 212 */         while (rs.next())
/*     */         {
/* 215 */           sample[rowcount][0] = rs.getString(1);
/* 216 */           sample[rowcount][1] = rs.getString(2);
/* 217 */           sample[rowcount][2] = rs.getString(3);
/* 218 */           sample[rowcount][3] = rs.getString(4);
/*     */ 
/* 220 */           sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 225 */           System.out.println(sample[rowcount][0]);
/*     */ 
/* 228 */           rowcount++;
/*     */         }
/*     */ 
/* 231 */         rs.close();
/* 232 */         cn.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 236 */         e.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/* 240 */     else if ((now.before(this.jDateChooser1.getDate())) || (now.before(this.jDateChooser2.getDate())))
/*     */     {
/* 242 */       JOptionPane.showMessageDialog(null, "Not allowed the date is greater than the current date", "ERROR", 0);
/*     */     }
/* 245 */     else if (this.jDateChooser2.getDate().before(this.jDateChooser1.getDate())) {
/* 246 */       JOptionPane.showMessageDialog(null, "Stop date less than Start Date ", "Error!", 0);
/*     */     }
/*     */     else
/*     */     {
/* 251 */       String str = "SELECT supplier,invoiceno,amtowed,amtpaid,date from purchasedpaid WHERE amtowed > amtpaid && date>='" + start + "' && date<='" + stop + "'";
/*     */       try
/*     */       {
/* 260 */         java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 262 */         Statement st = cn.createStatement();
/*     */ 
/* 264 */         ResultSet rs = st.executeQuery(str);
/*     */ 
/* 267 */         if (rs.next()) {
/* 268 */           rs.last();
/*     */ 
/* 270 */           sample = new String[rs.getRow()][5];
/* 271 */           rs.beforeFirst();
/*     */         }
/* 273 */         int rowcount = 0;
/*     */ 
/* 275 */         while (rs.next())
/*     */         {
/* 278 */           sample[rowcount][0] = rs.getString(1);
/* 279 */           sample[rowcount][1] = rs.getString(2);
/* 280 */           sample[rowcount][2] = rs.getString(3);
/* 281 */           sample[rowcount][3] = rs.getString(4);
/* 282 */           sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 288 */           System.out.println(sample[rowcount][0]);
/*     */ 
/* 291 */           rowcount++;
/*     */         }
/*     */ 
/* 294 */         rs.close();
/* 295 */         cn.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 299 */         e.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 304 */     return sample;
/*     */   }
/*     */   public void update_table() {
/* 307 */     String[] headers = { "SUPPLIER", "INVOICE NO", "AMT OWED", "AMT PAID", "DATE" };
/* 308 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/* 309 */     model.fireTableDataChanged();
/* 310 */     this.table.setModel(model);
/*     */   }
/*     */ 
/*     */   public void update_table2()
/*     */   {
/* 316 */     String str = "SELECT invoiceno AS 'INVOICE NO',amtowed AS 'AMOUNT OWED',amtpaid AS 'TOTAL AMOUNT PAID' from purchasedpaid where invoiceno='" + this.invno + "'";
/*     */ 
/* 319 */     ResultSet rs = null;
/*     */     try
/*     */     {
/* 325 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 327 */       Statement st = cn.createStatement();
/*     */ 
/* 329 */       rs = st.executeQuery(str);
/* 330 */       this.table2.setModel(DbUtils.resultSetToTableModel(rs));
/* 331 */       while (rs.next()) {
/* 332 */         System.out.println(rs.getString(1));
/* 333 */         rs.getString(1);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 339 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String[][] getData2(String purchase)
/*     */   {
/* 349 */     String[][] sample = (String[][])null;
/* 350 */     String str = "SELECT invoiceno AS 'INVOICE NO',amtowed AS 'AMOUNT OWED',amtpaid AS 'TOTAL AMOUNT PAID' from purchasedpaid where supplier='" + purchase + "' ";
/*     */     try
/*     */     {
/* 359 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 361 */       Statement st = cn.createStatement();
/*     */ 
/* 363 */       this.rst = st.executeQuery(str);
/*     */ 
/* 366 */       if (this.rst.next()) {
/* 367 */         this.rst.last();
/*     */ 
/* 369 */         sample = new String[this.rst.getRow()][5];
/* 370 */         this.rst.beforeFirst();
/*     */       }
/* 372 */       int rowcount = 0;
/*     */ 
/* 374 */       while (this.rst.next())
/*     */       {
/* 377 */         sample[rowcount][0] = this.rst.getString(1);
/* 378 */         sample[rowcount][1] = this.rst.getString(2);
/* 379 */         sample[rowcount][2] = this.rst.getString(3);
/*     */ 
/* 390 */         rowcount++;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 398 */       e.printStackTrace();
/*     */     }
/* 400 */     this.data2 = sample;
/* 401 */     return sample;
/*     */   }
/*     */ 
/*     */   public void update_table(String name)
/*     */   {
/* 407 */     String str = "SELECT invoiceno AS 'INVOICE NO',amtowed AS 'AMOUNT OWED',amtpaid AS 'TOTAL AMOUNT PAID' ,date as 'DATE' from purchasedpaid where supplier='" + name + "' ";
/*     */ 
/* 411 */     ResultSet rs = null;
/*     */     try
/*     */     {
/* 417 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 419 */       Statement st = cn.createStatement();
/*     */ 
/* 421 */       rs = st.executeQuery(str);
/* 422 */       this.table2.setModel(DbUtils.resultSetToTableModel(rs));
/*     */     } catch (Exception ex) {
/* 424 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 443 */     this.jPanel1 = new JPanel();
/* 444 */     this.jPanel2 = new JPanel();
/* 445 */     this.jPanel3 = new JPanel();
/* 446 */     this.jPanel5 = new JPanel();
/* 447 */     this.jDateChooser1 = new JDateChooser();
/* 448 */     this.jDateChooser2 = new JDateChooser();
/* 449 */     this.jLabel1 = new JLabel();
/* 450 */     this.jLabel2 = new JLabel();
/* 451 */     this.jButton1 = new JButton();
/*     */ 
/* 453 */     setDefaultCloseOperation(2);
/*     */ 
/* 455 */     this.jPanel1.setBackground(new Color(204, 204, 204));
/*     */ 
/* 457 */     this.jPanel2.setBackground(new Color(153, 153, 255));
/*     */ 
/* 459 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/* 460 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 462 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 463 */     this.jPanel3.setLayout(jPanel3Layout);
/* 464 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 465 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 466 */       .addGap(0, 0, 32767));
/*     */ 
/* 468 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 469 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 470 */       .addGap(0, 296, 32767));
/*     */ 
/* 473 */     this.jPanel5.setBackground(new Color(0, 0, 0));
/* 474 */     this.jPanel5.setBorder(new SoftBevelBorder(0));
/*     */ 
/* 476 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 477 */     this.jPanel5.setLayout(jPanel5Layout);
/* 478 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 479 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 480 */       .addGap(0, 0, 32767));
/*     */ 
/* 482 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 483 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 484 */       .addGap(0, 38, 32767));
/*     */ 
/* 487 */     this.jLabel1.setText("Stop Date:");
/*     */ 
/* 489 */     this.jLabel2.setText("Start Date:");
/*     */ 
/* 491 */     this.jButton1.setText("Search");
/* 492 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 494 */         Creditors.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 498 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 499 */     this.jPanel2.setLayout(jPanel2Layout);
/* 500 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 501 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 502 */       .addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 503 */       .addGroup(jPanel2Layout
/* 503 */       .createSequentialGroup()
/* 504 */       .addGroup(jPanel2Layout
/* 504 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 505 */       .addGroup(jPanel2Layout
/* 505 */       .createSequentialGroup()
/* 506 */       .addGap(18, 18, 18)
/* 507 */       .addComponent(this.jLabel2)
/* 508 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 509 */       .addComponent(this.jDateChooser1, -2, 131, -2)
/* 510 */       .addGap(26, 26, 26)
/* 511 */       .addComponent(this.jLabel1)
/* 512 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 513 */       .addComponent(this.jDateChooser2, -2, 142, -2)
/* 514 */       .addGap(18, 18, 18)
/* 515 */       .addComponent(this.jButton1)
/* 516 */       .addGap(0, 237, 32767))
/* 517 */       .addGroup(jPanel2Layout
/* 517 */       .createSequentialGroup()
/* 518 */       .addContainerGap()
/* 519 */       .addComponent(this.jPanel3, -1, -1, 32767)))
/* 520 */       .addContainerGap()));
/*     */ 
/* 522 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 523 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 524 */       .addGroup(jPanel2Layout
/* 524 */       .createSequentialGroup()
/* 525 */       .addComponent(this.jPanel5, -2, -1, -2)
/* 526 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 527 */       .addGroup(jPanel2Layout
/* 527 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 528 */       .addGroup(jPanel2Layout
/* 528 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 529 */       .addComponent(this.jDateChooser2, -2, -1, -2)
/* 530 */       .addComponent(this.jLabel1)
/* 531 */       .addComponent(this.jLabel2)
/* 532 */       .addComponent(this.jDateChooser1, -2, -1, -2))
/* 533 */       .addComponent(this.jButton1))
/* 534 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767)
/* 535 */       .addComponent(this.jPanel3, -2, -1, -2)));
/*     */ 
/* 538 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 539 */     this.jPanel1.setLayout(jPanel1Layout);
/* 540 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 541 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 542 */       .addGroup(jPanel1Layout
/* 542 */       .createSequentialGroup()
/* 543 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 544 */       .addGap(0, 0, 32767)));
/*     */ 
/* 546 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 547 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 548 */       .addGroup(jPanel1Layout
/* 548 */       .createSequentialGroup()
/* 549 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 550 */       .addGap(0, 0, 32767)));
/*     */ 
/* 553 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 554 */     getContentPane().setLayout(layout);
/* 555 */     layout.setHorizontalGroup(layout
/* 556 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 557 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 559 */     layout.setVerticalGroup(layout
/* 560 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 561 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 564 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 568 */     this.data = getData2();
/* 569 */     update_table();
/*     */   }
/*     */ 
/*     */   public void trunc2() {
/* 573 */     java.sql.Connection connection = null;
/* 574 */     com.mysql.jdbc.PreparedStatement stmt = null;
            int s;
/*     */     try
/*     */     {
/* 577 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 578 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 579 */       String sql = "truncate table purchasedpaidholder";
/* 580 */       stmt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 583 */       s = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       
/* 587 */       System.out.println("Found some error : " + ex);
/* 588 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trunc()
/*     */   {
/* 595 */     java.sql.Connection connection = null;
/* 596 */     com.mysql.jdbc.PreparedStatement stmt = null;
             int s;
/*     */     try
/*     */     {
/* 599 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 600 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 601 */       String sql = "truncate table trancpurchasesholder";
/* 602 */       stmt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 605 */       s = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */      
/* 609 */       System.out.println("Found some error : " + ex);
/* 610 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insertholder2()
/*     */   {
/* 616 */     java.sql.Connection connection = null;
/* 617 */     java.sql.PreparedStatement psmnt = null;
                int s;
/*     */     try {
/* 619 */       String sql = "INSERT INTO purchasedpaidholder (amtpaid,amtowed,date,supplier,invoiceno) select amtpaid,amtowed,date,supplier,invoiceno from purchasedpaid where invoiceno='" + this.invno + "'&& supplier='" + this.supp + "'";
/*     */ 
/* 622 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 623 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 624 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 627 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       
/* 631 */       System.out.println("Found some error : " + ex);
/* 632 */       JOptionPane.showMessageDialog(null, "Error 232" + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insertholder()
/*     */   {
/* 641 */     java.sql.Connection connection = null;
/* 642 */     java.sql.PreparedStatement psmnt = null;
 int s;
/*     */     try {
/* 644 */       String sql = "INSERT INTO trancpurchasesholder (amtpaid,date) select amtpaid,date from trancpurchases where invoiceno='" + this.invno + "'&& supplier='" + this.supp + "'";
/*     */ 
/* 647 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 648 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 649 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 652 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */      
/* 656 */       System.out.println("Found some error : " + ex);
/* 657 */       JOptionPane.showMessageDialog(null, "Error 2222" + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insertholder3()
/*     */   {
/* 667 */     java.sql.Connection connection = null;
/* 668 */     java.sql.PreparedStatement psmnt = null;
 int s;
/*     */     try
/*     */     {
/* 672 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 673 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 674 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement("INSERT INTO purchaseholder(invoiceno,supplier,Itemcode,name,description,quantity,price,date) select code,supplier,itemcode,name,description,quantity,price,date from purchases where code='" + this.invno + "' && supplier='" + this.supp + "'");
/*     */ 
/* 680 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */      
/* 684 */       System.out.println("Found some error : " + ex);
/* 685 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trunc3()
/*     */   {
/* 692 */     java.sql.Connection connection = null;
/* 693 */     com.mysql.jdbc.PreparedStatement stmt = null;
int s;
/*     */     try
/*     */     {
/* 696 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 697 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 698 */       String sql = "truncate table purchaseholder";
/* 699 */       stmt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 702 */       s = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       
/* 706 */       System.out.println("Found some error : " + ex);
/* 707 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void vector()
/*     */   {
/* 720 */     Vector vc = new Vector();
/* 721 */     vc.add("c");
/* 722 */     vc.add("d");
/* 723 */     vc.addElement(new String("r"));
/* 724 */     boolean s = vc.contains("r");
/*     */ 
/* 726 */     int d = vc.capacity();
/*     */ 
/* 728 */     vc.add(2, "chris");
/* 729 */     String h = (String)vc.get(2);
/*     */ 
/* 731 */     Enumeration n = vc.elements();
/* 732 */     while (n.hasMoreElements())
/*     */     {
/* 734 */       System.out.println(n.nextElement());
/*     */     }
/*     */   }
/*     */ 
/*     */   public Date dateToday()
/*     */   {
/* 741 */     Calendar currentDate = Calendar.getInstance();
/*     */ 
/* 743 */     Date date = currentDate.getTime();
/* 744 */     return date;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 757 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 758 */         if ("Windows".equals(info.getName())) {
/* 759 */           UIManager.setLookAndFeel(info.getClassName());
/* 760 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 764 */       Logger.getLogger(Creditors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 766 */       Logger.getLogger(Creditors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 768 */       Logger.getLogger(Creditors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 770 */       Logger.getLogger(Creditors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 777 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 780 */         Creditors dialog = new Creditors(new JFrame(), true);
/* 781 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 785 */             System.exit(0);
/*     */           }
/*     */         });
/* 788 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.Creditors
 * JD-Core Version:    0.6.0
 */