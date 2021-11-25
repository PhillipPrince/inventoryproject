/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Vector;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.event.TableModelEvent;
/*     */ import javax.swing.event.TableModelListener;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableModel;
/*     */ 
/*     */ public class expiryDates extends JDialog
/*     */ {
/*  26 */   DBConnection nn = new DBConnection();
/*  27 */   Connection conn = this.nn.getDBConnection();
/*     */   JTable tablep;
/*  29 */   int all = 0;
/*  30 */   String prodid = "";
/*  31 */   String inv = "";
/*     */ 
/*  34 */   ResultSet ris = null;
/*     */ 
/*  36 */   int y = 0;
            int f=0;
/*  37 */   int row = 0;
/*  38 */   int col = 0;
/*  39 */   String subjec = "";
/*  40 */   String[][] list = (String[][])null;
/*  41 */   String[][] psample = (String[][])null;
/*  42 */   Vector<Vector<String>> items = new Vector();
/*  43 */   Calendar c = Calendar.getInstance();
/*  44 */   SimpleDateFormat ff = new SimpleDateFormat("yyMMdd");
/*  45 */   SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JPanel jPanel4;
/*     */ 
/*     */   public expiryDates(Frame parent, boolean modal)
/*     */   {
/*  51 */     super(parent, modal);
/*  52 */     initComponents();
/*  53 */     setLocationRelativeTo(null);
/*  54 */     System.gc();
/*  55 */     addWindowListener(new WindowAdapter()
/*     */     {
/*     */       public void windowClosing(WindowEvent e)
/*     */       {
/*     */         try {
/*  60 */           expiryDates.this.conn.close();
/*     */         } catch (SQLException ex) {
/*  62 */           Logger.getLogger(expiryDates.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void tablep() {
/*  70 */     String[][] data = allBatchno(this.inv);
/*  71 */     int o = 0;
/*  72 */     String[] myheaders = { "batchno", "Expiry Date" };
/*     */     try {
/*  74 */       o = data.length;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  79 */       o = 0;
/*     */     }
/*  81 */     DefaultTableModel model = null;
/*  82 */     String date = "";
/*     */ 
/*  84 */     System.out.println(o + " vvvv  " + getDatap().size());
/*  85 */     if (o == 0) {
/*  86 */       Vector headers = new Vector();
/*  87 */       headers.add("batchno");
/*  88 */       headers.add("Expiry Date");
/*  89 */       model = new DefaultTableModel(getDatap(), headers);
/*     */     }
/*  92 */     else if (getDatap().size() > o)
/*     */     {
/*  94 */       model = new DefaultTableModel(allBatchno2(this.inv, getDatap().size() - o), myheaders);
/*     */     }
/*     */     else
/*     */     {
/*  98 */       model = new DefaultTableModel(data, myheaders);
/*     */     }
/*     */ 
/* 110 */     this.tablep = new JTable(model);
/*     */ 
/* 113 */     JScrollPane scrollPane = new JScrollPane(this.tablep);
/* 114 */     this.tablep.setFillsViewportHeight(true);
/* 115 */     this.jPanel4.add(scrollPane, "Center");
/* 116 */     scrollPane.setBounds(0, 0, 350, 250);
/* 117 */     this.tablep.getModel().addTableModelListener(new TableModelListener()
/*     */     {
/* 119 */       Vector<String> hold = new Vector();
/*     */ 
/*     */       public void tableChanged(TableModelEvent e) {
/* 122 */         expiryDates.this.row = e.getFirstRow();
/* 123 */         expiryDates.this.col = e.getColumn();
/* 124 */         this.hold = ((Vector)expiryDates.this.items.get(e.getFirstRow()));
/* 125 */         expiryDates.this.subjec = ((String)this.hold.elementAt(0));
/* 126 */         String dat = (String)expiryDates.this.tablep.getModel().getValueAt(e.getFirstRow(), 1);
/* 127 */         String batch = (String)expiryDates.this.tablep.getModel().getValueAt(e.getFirstRow(), 0);
/* 128 */         System.out.println(dat + " " + batch + " fffgg");
/* 129 */         if ((expiryDates.this.col == 1) || (expiryDates.this.col == 0))
/*     */         {
/* 131 */           int y = expiryDates.this.checkDate(dat);
/* 132 */           if ((y == 0) && (!dat.equals(""))) {
/* 133 */             JOptionPane.showMessageDialog(expiryDates.this.jPanel1, "Incorrect Date Format", "Error!!!", 0);
/*     */           }
/* 136 */           else if (dat.equals("")) {
/* 137 */             expiryDates.this.deleteExpiry(batch);
/*     */           }
/* 142 */           else if (batch.equals("")) {
/* 143 */             JOptionPane.showMessageDialog(expiryDates.this.jPanel1, "Empty batch Number", "Error!!!", 0);
/*     */           }
/* 145 */           else if (expiryDates.this.checkExist(batch) > 0) {
/* 146 */             y = expiryDates.this.checkDate(dat);
/* 147 */             if ((y == 0) && (!dat.equals(""))) {
/* 148 */               JOptionPane.showMessageDialog(expiryDates.this.jPanel1, "Incorrect Date Format", "Error!!!", 0);
/*     */             }
/*     */             else
/*     */             {
/* 152 */               expiryDates.this.UpdateExpiry(dat, batch);
/*     */             }
/*     */           } else {
/* 155 */             expiryDates.this.InsertExpiry(dat, batch);
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public Vector<Vector<String>> getDatap()
/*     */   {
/* 173 */     this.items.removeAllElements();
/*     */ 
/* 176 */     Vector subjs = new Vector();
/*     */ 
/* 181 */     for (int i = 0; i < this.all; i++) {
/* 182 */       subjs = new Vector();
/* 183 */       subjs.add("");
/* 184 */       subjs.add("\n\n\n\n\n\n\n\n\n");
/*     */ 
/* 187 */       this.items.add(subjs);
/*     */     }
/*     */ 
/* 202 */     return this.items;
/*     */   }
/*     */ 
/*     */   public String prodid()
/*     */   {
/* 207 */     String no = this.ff.format(this.c.getTime());
/*     */     try
/*     */     {
/* 212 */       String sql = "SELECT max(batchno) FROM expirydate where substring(batchno, 1,6)= '" + no + "'";
/* 213 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/* 214 */       ResultSet resultSet = stmt.executeQuery();
/* 215 */       System.out.println(sql);
/* 216 */       if (resultSet.next()) {
/* 217 */         no = String.valueOf(resultSet.getInt(1) + 1);
/*     */         try {
/* 219 */           no.length();
/*     */ 
/* 221 */           if (no.equals("1"))
/* 222 */             no = this.ff.format(this.c.getTime()) + "0";
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 226 */           no = this.ff.format(this.c.getTime()) + "0";
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception exc)
/*     */     {
/* 232 */       System.out.println("process error" + exc);
/*     */     }
/*     */ 
/* 236 */     return no;
/*     */   }
/*     */ 
/*     */   public String InsertExpiry(String date, String batchno)
/*     */   {
/* 241 */     String no = this.ff.format(this.c.getTime());
/*     */     try
/*     */     {
/* 246 */       String sql = "insert into expirydate(batchno,prodid,invoiceno,date,sold) values('" + batchno + "','" + this.prodid + "','" + this.inv + "','" + date + "','" + 0 + "')";
/* 247 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/* 248 */       f = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception exc)
/*     */     {
/*     */       int f;
/* 254 */       System.out.println("process error" + exc);
/*     */     }
/*     */ 
/* 258 */     return no;
/*     */   }
/*     */ 
/*     */   public void UpdateExpiry(String date, String batchno)
/*     */   {
/*     */     try
/*     */     {
/* 268 */       String sql = "update expirydate set prodid='" + this.prodid + "',invoiceno='" + this.inv + "',date='" + date + "' where sold=0 && batchno='" + batchno + "' ";
/* 269 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/* 270 */       f = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception exc)
/*     */     {
/*     */       int f;
/* 276 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void deleteExpiry(String batchno)
/*     */   {
/*     */     try
/*     */     {
/* 290 */       String sql = "delete from expirydate where sold=0 && batchno='" + batchno + "' ";
/* 291 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/* 292 */       f = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception exc)
/*     */     {
/*     */       int f;
/* 298 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int checkDate(String date)
/*     */   {
/* 305 */     int i = 0;
/*     */     try
/*     */     {
/* 308 */       Date dat = this.form.parse(date);
/* 309 */       i = 1;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 313 */       i = 0;
/*     */     }
/*     */ 
/* 318 */     return i;
/*     */   }
/*     */ 
/*     */   public int checkExist(String batch)
/*     */   {
/* 324 */     int i = 0;
/*     */     try
/*     */     {
/* 327 */       String sql = "select * from  expirydate where  batchno='" + batch + "'";
/* 328 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/* 329 */       ResultSet rs = stmt.executeQuery();
/* 330 */       while (rs.next()) {
/* 331 */         i++;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 336 */       i = 0;
/*     */     }
/*     */ 
/* 341 */     return i;
/*     */   }
/*     */ 
/*     */   public void setValues(String inv)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String[][] allBatchno(String inv) {
/* 349 */     String[][] batches = (String[][])null;
/*     */ 
/* 351 */     int i = 0;
/*     */     try
/*     */     {
/* 354 */       String sql = "select batchno,date from  expirydate where  invoiceno='" + inv + "'";
/* 355 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/* 356 */       ResultSet rs = stmt.executeQuery();
/* 357 */       if (rs.next()) {
/* 358 */         rs.last();
/* 359 */         batches = new String[rs.getRow()][2];
/* 360 */         rs.beforeFirst();
/*     */       }
/* 362 */       int r = 0;
/* 363 */       while (rs.next()) {
/* 364 */         batches[r][0] = rs.getString(1);
/* 365 */         batches[r][1] = rs.getString(2);
/* 366 */         r++;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 374 */     return batches;
/*     */   }
/*     */ 
/*     */   public String[][] allBatchno2(String inv, int no)
/*     */   {
/* 379 */     String[][] batches = (String[][])null;
/*     */ 
/* 381 */     int i = 0;
/*     */     try
/*     */     {
/* 384 */       String sql = "select batchno,date from  expirydate where  invoiceno='" + inv + "'";
/* 385 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/* 386 */       ResultSet rs = stmt.executeQuery();
/* 387 */       if (rs.next()) {
/* 388 */         rs.last();
/* 389 */         batches = new String[rs.getRow() + no][2];
/* 390 */         rs.beforeFirst();
/*     */       }
/* 392 */       int r = 0;
/* 393 */       while (rs.next()) {
/* 394 */         batches[r][0] = rs.getString(1);
/* 395 */         batches[r][1] = rs.getString(2);
/* 396 */         r++;
/*     */       }
/* 398 */       System.out.println(no + " errror error");
/* 399 */       int batch = Integer.parseInt(prodid());
/* 400 */       if (no == 1) {
/* 401 */         batches[r][0] = "";
/* 402 */         batches[r][1] = "";
/*     */       } else {
/* 404 */         batches[r][0] = "";
/* 405 */         batches[r][1] = "";
/* 406 */         for (int t = 1; t < no + 1; t++) {
/* 407 */           batches[(r + t)][0] = "";
/* 408 */           batches[(r + t)][1] = "";
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 413 */       System.out.println(batch + " errror error");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 421 */     return batches;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 432 */     this.jPanel1 = new JPanel();
/* 433 */     this.jPanel2 = new JPanel();
/* 434 */     this.jPanel3 = new JPanel();
/* 435 */     this.jPanel4 = new JPanel();
/*     */ 
/* 437 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 438 */     this.jPanel1.setLayout(jPanel1Layout);
/* 439 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 440 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 441 */       .addGap(0, 100, 32767));
/*     */ 
/* 443 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 444 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 445 */       .addGap(0, 100, 32767));
/*     */ 
/* 448 */     setDefaultCloseOperation(2);
/*     */ 
/* 450 */     this.jPanel2.setBackground(new Color(153, 153, 255));
/*     */ 
/* 452 */     this.jPanel3.setBackground(new Color(0, 0, 0));
/*     */ 
/* 454 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 455 */     this.jPanel3.setLayout(jPanel3Layout);
/* 456 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 457 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 458 */       .addGap(0, 0, 32767));
/*     */ 
/* 460 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 461 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 462 */       .addGap(0, 33, 32767));
/*     */ 
/* 465 */     this.jPanel4.setBackground(new Color(153, 153, 255));
/*     */ 
/* 467 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 468 */     this.jPanel4.setLayout(jPanel4Layout);
/* 469 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 470 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 471 */       .addGap(0, 380, 32767));
/*     */ 
/* 473 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 474 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 475 */       .addGap(0, 255, 32767));
/*     */ 
/* 478 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 479 */     this.jPanel2.setLayout(jPanel2Layout);
/* 480 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 481 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 482 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 483 */       .addGroup(jPanel2Layout
/* 483 */       .createSequentialGroup()
/* 484 */       .addContainerGap()
/* 485 */       .addComponent(this.jPanel4, -1, -1, 32767)
/* 486 */       .addContainerGap()));
/*     */ 
/* 488 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 489 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 490 */       .addGroup(jPanel2Layout
/* 490 */       .createSequentialGroup()
/* 491 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 492 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 493 */       .addComponent(this.jPanel4, -1, -1, 32767)
/* 494 */       .addContainerGap()));
/*     */ 
/* 497 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 498 */     getContentPane().setLayout(layout);
/* 499 */     layout.setHorizontalGroup(layout
/* 500 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 501 */       .addComponent(this.jPanel2, -1, -1, 32767));
/*     */ 
/* 503 */     layout.setVerticalGroup(layout
/* 504 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 505 */       .addComponent(this.jPanel2, -1, -1, 32767));
/*     */ 
/* 508 */     pack();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 525 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 526 */         if ("Nimbus".equals(info.getName())) {
/* 527 */           UIManager.setLookAndFeel(info.getClassName());
/* 528 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 532 */       Logger.getLogger(expiryDates.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 534 */       Logger.getLogger(expiryDates.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 536 */       Logger.getLogger(expiryDates.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 538 */       Logger.getLogger(expiryDates.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 545 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 548 */         expiryDates dialog = new expiryDates(new JFrame(), true);
/* 549 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 553 */             System.exit(0);
/*     */           }
/*     */         });
/* 556 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.expiryDates
 * JD-Core Version:    0.6.0
 */