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
/*     */ 
/*     */ public class debtors extends JFrame
/*     */ {
/*  29 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  30 */   static String username = "root";
/*  31 */   static String password = "this";
/*     */   ResultSet ris;
/*     */   ResultSet rst;
/*     */   JTable table;
/*     */   JTable table2;
/*  34 */   String[][] data = (String[][])null;
/*     */   String itemcod;
/*     */   String itemde;
/*  37 */   String[][] data2 = (String[][])null;
/*     */   String code;
/*     */   String cust;
/*     */   String dateTopay;
/*     */   public JButton jButton1;
/*     */   public JDateChooser jDateChooser1;
/*     */   public JDateChooser jDateChooser2;
/*     */   public JLabel jLabel1;
/*     */   public JLabel jLabel2;
/*     */   public JPanel jPanel1;
/*     */   public JPanel jPanel2;
/*     */   public JPanel jPanel3;
            int s;
/*     */ 
/*     */   public debtors(Frame parent, boolean modal)
/*     */   {
/*  46 */     initComponents();
/*  47 */     setLocationRelativeTo(null);
/*     */ 
/*  50 */     setResizable(false);
/*  51 */     setTitle("Debtors");
/*  52 */     this.data = getData();
/*  53 */     table();
/*     */   }
/*     */ 
/*     */   public void table()
/*     */   {
/*  62 */     String[] headers = { "NAME", "Invoice No", "Amount Paid ", "Total ", "Date " };
/*     */ 
/*  67 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/*  68 */     model.fireTableDataChanged();
/*  69 */     this.table = new JTable(model);
/*     */ 
/*  72 */     JScrollPane scrollPane = new JScrollPane(this.table);
/*     */ 
/*  74 */     this.jPanel3.add(scrollPane, "Center");
/*  75 */     scrollPane.setBounds(0, 0, 776, 297);
/*  76 */     this.table.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e)
/*     */       {
/*  80 */         int row = debtors.this.table.getSelectedRow();
/*  81 */         int col = debtors.this.table.getSelectedColumn();
/*  82 */         debtors.this.code = debtors.this.data[row][0];
/*     */ 
/*  84 */         debtorsPop nn = new debtorsPop(new JFrame(), true);
/*  85 */         nn.fill(debtors.this.data[row][0], debtors.this.data[row][1], debtors.this.data[row][2], debtors.this.data[row][3]);
/*  86 */         nn.setVisible(true);
/*  87 */         debtors.this.data = debtors.this.getData2();
/*  88 */         debtors.this.update_table();
/*     */ 
/*  97 */         System.out.println("row is " + row + " and " + col + "" + debtors.this.code);
/*     */       } } );
/*     */   }
/*     */ 
/*     */   public String[][] getData() {
/* 103 */     String[][] sample = (String[][])null;
/* 104 */     String str = "SELECT name,invoiceno,amtpaid ,total,date from debtors WHERE total > amtpaid";
/*     */     try
/*     */     {
/* 113 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 115 */       Statement st = cn.createStatement();
/*     */ 
/* 117 */       ResultSet rs = st.executeQuery(str);
/*     */ 
/* 120 */       if (rs.next()) {
/* 121 */         rs.last();
/*     */ 
/* 123 */         sample = new String[rs.getRow()][5];
/* 124 */         rs.beforeFirst();
/*     */       }
/* 126 */       int rowcount = 0;
/*     */ 
/* 128 */       while (rs.next())
/*     */       {
/* 131 */         sample[rowcount][0] = rs.getString(1);
/* 132 */         sample[rowcount][1] = rs.getString(2);
/* 133 */         sample[rowcount][2] = rs.getString(3);
/* 134 */         sample[rowcount][3] = rs.getString(4);
/* 135 */         sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 144 */         rowcount++;
/*     */       }
/*     */ 
/* 147 */       rs.close();
/* 148 */       cn.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 152 */       e.printStackTrace();
/*     */     }
/* 154 */     return sample;
/*     */   }
/*     */   public String[][] getData2() {
/* 157 */     String start = "";
/* 158 */     String stop = "";
/* 159 */     SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
/* 160 */     Date now = dateToday();
/*     */     try {
/* 162 */       start = form.format(this.jDateChooser1.getDate());
/*     */ 
/* 164 */       stop = form.format(this.jDateChooser2.getDate());
/*     */     }
/*     */     catch (Exception e) {
/* 167 */       start = "";
/* 168 */       stop = "";
/*     */     }
/*     */ 
/* 172 */     String[][] sample = (String[][])null;
/*     */ 
/* 174 */     if ((start.equals("")) || (stop.equals("")))
/*     */     {
/* 176 */       String str = "SELECT name,invoiceno,amtpaid ,total,date from debtors WHERE total > amtpaid";
/*     */       try
/*     */       {
/* 185 */         java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 187 */         Statement st = cn.createStatement();
/*     */ 
/* 189 */         ResultSet rs = st.executeQuery(str);
/*     */ 
/* 192 */         if (rs.next()) {
/* 193 */           rs.last();
/*     */ 
/* 195 */           sample = new String[rs.getRow()][5];
/* 196 */           rs.beforeFirst();
/*     */         }
/* 198 */         int rowcount = 0;
/*     */ 
/* 200 */         while (rs.next())
/*     */         {
/* 203 */           sample[rowcount][0] = rs.getString(1);
/* 204 */           sample[rowcount][1] = rs.getString(2);
/* 205 */           sample[rowcount][2] = rs.getString(3);
/* 206 */           sample[rowcount][3] = rs.getString(4);
/* 207 */           sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 216 */           rowcount++;
/*     */         }
/*     */ 
/* 219 */         rs.close();
/* 220 */         cn.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 224 */         e.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/* 231 */     else if ((now.before(this.jDateChooser1.getDate())) || (now.before(this.jDateChooser2.getDate())))
/*     */     {
/* 233 */       JOptionPane.showMessageDialog(null, "Not allowed the date is greater than the current date", "ERROR", 0);
/*     */     }
/* 236 */     else if (this.jDateChooser2.getDate().before(this.jDateChooser1.getDate())) {
/* 237 */       JOptionPane.showMessageDialog(null, "Stop date less than Start Date ", "Error!", 0);
/*     */     }
/*     */     else
/*     */     {
/* 242 */       String str = "SELECT name,invoiceno,amtpaid ,total,date from debtors WHERE total > amtpaid && date>='" + start + "' && date<='" + stop + "'";
/*     */       try
/*     */       {
/* 251 */         java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 253 */         Statement st = cn.createStatement();
/*     */ 
/* 255 */         ResultSet rs = st.executeQuery(str);
/*     */ 
/* 258 */         if (rs.next()) {
/* 259 */           rs.last();
/*     */ 
/* 261 */           sample = new String[rs.getRow()][5];
/* 262 */           rs.beforeFirst();
/*     */         }
/* 264 */         int rowcount = 0;
/*     */ 
/* 266 */         while (rs.next())
/*     */         {
/* 269 */           sample[rowcount][0] = rs.getString(1);
/* 270 */           sample[rowcount][1] = rs.getString(2);
/* 271 */           sample[rowcount][2] = rs.getString(3);
/* 272 */           sample[rowcount][3] = rs.getString(4);
/* 273 */           sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 282 */           rowcount++;
/*     */         }
/*     */ 
/* 285 */         rs.close();
/* 286 */         cn.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 290 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 292 */     return sample;
/*     */   }
/*     */ 
/*     */   public void update_table()
/*     */   {
/* 297 */     String[] headers = { "NAME", "Invoice No", "Amount Paid ", "Total ", "Date " };
/*     */ 
/* 302 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/* 303 */     this.table.setModel(model);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 320 */     this.jPanel1 = new JPanel();
/* 321 */     this.jPanel3 = new JPanel();
/* 322 */     this.jPanel2 = new JPanel();
/* 323 */     this.jDateChooser1 = new JDateChooser();
/* 324 */     this.jDateChooser2 = new JDateChooser();
/* 325 */     this.jButton1 = new JButton();
/* 326 */     this.jLabel1 = new JLabel();
/* 327 */     this.jLabel2 = new JLabel();
/*     */ 
/* 329 */     setDefaultCloseOperation(2);
/*     */ 
/* 331 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/* 332 */     this.jPanel1.setBorder(new SoftBevelBorder(0));
/*     */ 
/* 334 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/* 335 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 337 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 338 */     this.jPanel3.setLayout(jPanel3Layout);
/* 339 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 340 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 341 */       .addGap(0, 780, 32767));
/*     */ 
/* 343 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 344 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 345 */       .addGap(0, 296, 32767));
/*     */ 
/* 348 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/* 349 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/* 351 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 352 */     this.jPanel2.setLayout(jPanel2Layout);
/* 353 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 354 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 355 */       .addGap(0, 0, 32767));
/*     */ 
/* 357 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 358 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 359 */       .addGap(0, 38, 32767));
/*     */ 
/* 362 */     this.jButton1.setText("Search");
/* 363 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 365 */         debtors.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 369 */     this.jLabel1.setText("Stop Date:");
/*     */ 
/* 371 */     this.jLabel2.setText("Start Date:");
/*     */ 
/* 373 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 374 */     this.jPanel1.setLayout(jPanel1Layout);
/* 375 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 376 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 377 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 378 */       .addGroup(jPanel1Layout
/* 378 */       .createSequentialGroup()
/* 379 */       .addGroup(jPanel1Layout
/* 379 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 380 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 381 */       .addGroup(jPanel1Layout
/* 381 */       .createSequentialGroup()
/* 382 */       .addContainerGap()
/* 383 */       .addComponent(this.jLabel2)
/* 384 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 385 */       .addComponent(this.jDateChooser1, -2, 141, -2)
/* 386 */       .addGap(18, 18, 18)
/* 387 */       .addComponent(this.jLabel1)
/* 388 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 389 */       .addComponent(this.jDateChooser2, -2, 134, -2)
/* 390 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 391 */       .addComponent(this.jButton1)))
/* 392 */       .addContainerGap()));
/*     */ 
/* 394 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 395 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 396 */       .addGroup(jPanel1Layout
/* 396 */       .createSequentialGroup()
/* 397 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 398 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 399 */       .addGroup(jPanel1Layout
/* 399 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 400 */       .addComponent(this.jButton1)
/* 401 */       .addGroup(jPanel1Layout
/* 401 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 402 */       .addComponent(this.jLabel2)
/* 403 */       .addComponent(this.jDateChooser1, -2, -1, -2)
/* 404 */       .addComponent(this.jLabel1)
/* 405 */       .addComponent(this.jDateChooser2, -2, -1, -2)))
/* 406 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 407 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 408 */       .addGap(19, 19, 19)));
/*     */ 
/* 411 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 412 */     getContentPane().setLayout(layout);
/* 413 */     layout.setHorizontalGroup(layout
/* 414 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 415 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 417 */     layout.setVerticalGroup(layout
/* 418 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 419 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 422 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 426 */     this.data = getData2();
/* 427 */     update_table();
/*     */   }
/*     */ 
/*     */   public void insertdet(String inv, String cusq, String paid, String due)
/*     */   {
/* 432 */     String str = "INSERT INTO invoicedetails values('" + inv + "','" + cusq + "','" + paid + "','" + due + "') ";
/*     */     try
/*     */     {
/* 440 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 442 */       Statement st = cn.createStatement();
/* 443 */       int i = st.executeUpdate(str);
/*     */ 
/* 446 */       st = cn.createStatement();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insertholder2()
/*     */   {
/* 457 */     java.sql.Connection connection = null;
/* 458 */     java.sql.PreparedStatement psmnt = null;
/*     */     try
/*     */     {
/* 462 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 463 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 464 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement("INSERT INTO invoicetrancholder(name,invoiceno,total,date,amtpaid) select name,invoiceno,total,date,amtpaid from debtors where invoiceno='" + this.itemcod + "' && name='" + this.cust + "'");
/*     */ 
/* 470 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 474 */       System.out.println("Found some error : " + ex);
/* 475 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insertholder()
/*     */   {
/* 482 */     java.sql.Connection connection = null;
/* 483 */     java.sql.PreparedStatement psmnt = null;
/*     */     try {
/* 485 */       String sql = "INSERT INTO invoicetransactionsholder (amtpaid,date) select amtpaid,date from invoicetransactions where invoiceno='" + this.itemcod + "'&& Name='" + this.cust + "'";
/*     */ 
/* 488 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 489 */       connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/* 490 */       psmnt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 493 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 497 */       System.out.println("Found some error : " + ex);
/* 498 */       JOptionPane.showMessageDialog(null, "Error 2222" + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void invoicereport(String inv)
/*     */   {
/* 510 */     String str = "INSERT INTO invoiceholder (invoiceno,itemcode,item,description,quantity,price,subtotal,vat) select invoiceno,itemcode,item,description,quantity,price,subtotal,vat from invoice where invoiceno='" + inv + "'";
/*     */     try
/*     */     {
/* 518 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 520 */       Statement st = cn.createStatement();
/* 521 */       int i = st.executeUpdate(str);
/*     */ 
/* 524 */       st = cn.createStatement();
/*     */     }
/*     */     catch (Exception ex) {
/* 527 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trunc()
/*     */   {
/* 533 */     String str = "truncate table invoiceholder";
/*     */     try
/*     */     {
/* 541 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 543 */       Statement st = cn.createStatement();
/* 544 */       int i = st.executeUpdate(str);
/*     */ 
/* 547 */       st = cn.createStatement();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trunc3()
/*     */   {
/* 556 */     String str = "truncate table invoicetrancholder";
/*     */     try
/*     */     {
/* 564 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 566 */       Statement st = cn.createStatement();
/* 567 */       int i = st.executeUpdate(str);
/*     */ 
/* 570 */       st = cn.createStatement();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trunc2()
/*     */   {
/* 579 */     String str = "truncate table invoicetransactionsholder";
/*     */     try
/*     */     {
/* 587 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 589 */       Statement st = cn.createStatement();
/* 590 */       int i = st.executeUpdate(str);
/*     */ 
/* 593 */       st = cn.createStatement();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void truncdetails()
/*     */   {
/* 602 */     String str = "truncate table invoicedetails";
/*     */     try
/*     */     {
/* 610 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 612 */       Statement st = cn.createStatement();
/* 613 */       int i = st.executeUpdate(str);
/*     */ 
/* 616 */       st = cn.createStatement();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public Date dateToday()
/*     */   {
/* 625 */     Calendar currentDate = Calendar.getInstance();
/*     */ 
/* 627 */     Date date = currentDate.getTime();
/* 628 */     return date;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 644 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 645 */         if ("Windows".equals(info.getName())) {
/* 646 */           UIManager.setLookAndFeel(info.getClassName());
/* 647 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 651 */       Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 653 */       Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 655 */       Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 657 */       Logger.getLogger(debtors.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 664 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 667 */         debtors dialog = new debtors(new JFrame(), true);
/* 668 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 672 */             System.exit(0);
/*     */           }
/*     */         });
/* 675 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.debtors
 * JD-Core Version:    0.6.0
 */