/*      */ package inventory;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import java.awt.Container;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.EventQueue;
/*      */ import java.awt.Font;
/*      */ import java.awt.Frame;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.WindowAdapter;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.PrintStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.sql.DriverManager;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Statement;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.JViewport;
import javax.swing.LayoutStyle;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ import javax.swing.UIManager;
/*      */ import javax.swing.UIManager.LookAndFeelInfo;
/*      */ import javax.swing.UnsupportedLookAndFeelException;
/*      */ import javax.swing.border.SoftBevelBorder;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import net.proteanit.sql.DbUtils;
/*      */ 
/*      */ public class invoice2 extends JDialog
/*      */ {
/*      */   JTable table;
/*      */   JTable table2;
/*      */   JTable tablec;
/*      */   JTable tablecategory;
/*      */   DefaultTableModel model;
/*   34 */   String[][] data = (String[][])null;
/*   35 */   String[] mine = null;
/*      */   String cquant;
/*      */   String tIdno;
/*   38 */   String[][] purchased = (String[][])null;
/*   39 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*   40 */   static String username = "root";
/*   41 */   static String password = "this";
/*   42 */   String tvat = "";
/*      */   String cquan2;
/*      */   String tprice;
/*      */   String cprice;
/*      */   String item;
/*      */   String des;
/*      */   String quan;
/*   49 */   String[] cate = null;
/*      */   String coded;
/*      */   String quant;
/*      */   String vatn;
/*      */   double due;
/*      */   String sale;
/*      */   String deb;
/*   55 */   int proc = 5;
/*   56 */   int type = 0;
/*      */   private JTextField ch;
/*      */   private JTextField code;
/*      */   private JTextField dat;
/*      */   private JTextField invoiceno;
/*      */   private JButton jButton1;
/*      */   private JButton jButton2;
/*      */   private JButton jButton3;
/*      */   private JButton jButton4;
/*      */   private JButton jButton5;
/*      */   private JButton jButton7;
/*      */   private JButton jButton8;
/*      */   private JComboBox jComboBox1;
/*      */   private JComboBox jComboBox2;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel11;
/*      */   private JLabel jLabel13;
/*      */   private JLabel jLabel18;
/*      */   private JLabel jLabel19;
/*      */   private JLabel jLabel2;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel6;
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel10;
/*      */   private JPanel jPanel11;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel4;
/*      */   private JPanel jPanel5;
/*      */   private JPanel jPanel6;
/*      */   private JPanel jPanel7;
/*      */   private JPanel jPanel8;
/*      */   private JPanel jPanel9;
/*      */   private JScrollPane jScrollPane1;
/*      */   private JTextField nat;
/*      */   private JTextField paid;
/*      */   private JTextField quantity;
/*      */   private JTextField search;
/*      */   private JTextField sub;
/*      */   private JTextField tot;
/*      */   private JTextField vat;
/*      */ 
/*      */   public invoice2(Frame parent, boolean modal)
/*      */   {
/*   61 */     super(parent, modal);
/*   62 */     initComponents();
/*   63 */     table();
/*   64 */     setLocationRelativeTo(null);
/*   65 */     setResizable(false);
/*   66 */     setDefaultCloseOperation(2);
/*   67 */     this.jLabel1.setVisible(false);
/*      */ 
/*   75 */     fill();
/*   76 */     tablecat();
/*   77 */     fillcat();
/*      */ 
/*   79 */     tablecat2();
/*   80 */     update();
/*   81 */     update_table();
/*      */   }
/*      */ 
/*      */   public void invoiceno(String inv)
/*      */   {
/*   86 */     this.invoiceno.setText(inv);
/*      */   }
/*      */ 
/*      */   public void date(String da)
/*      */   {
/*   92 */     this.dat.setText(da);
/*      */   }
/*      */ 
/*      */   public void fillcat()
/*      */   {
/*      */     try {
/*   98 */       String find = this.code.getText();
/*   99 */       System.out.println(find);
/*  100 */       Class.forName("com.mysql.jdbc.Driver");
/*  101 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  102 */       String sql = "SELECT distinct category as 'CATEGORY' FROM stock";
/*  103 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  104 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/*  106 */       this.tablec.setModel(DbUtils.resultSetToTableModel(resultSet));
/*  107 */       conn.close();
/*      */     } catch (Exception exc) {
/*  109 */       exc.printStackTrace();
/*  110 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void fillcat2(String cate)
/*      */   {
/*      */     try
/*      */     {
/*  119 */       String find = this.code.getText();
/*  120 */       System.out.println(find);
/*  121 */       Class.forName("com.mysql.jdbc.Driver");
/*  122 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  123 */       String sql = "SELECT Itemcode as 'CODE',name as 'NAME',description as 'DESCRIPTION',quantity as 'QUANTITY' FROM stock WHERE category='" + cate + "'";
/*  124 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  125 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/*  127 */       this.tablecategory.setModel(DbUtils.resultSetToTableModel(resultSet));
/*  128 */       conn.close();
/*      */     } catch (Exception exc) {
/*  130 */       exc.printStackTrace();
/*  131 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void tablecat2()
/*      */   {
/*  140 */     String[] headers = { "CODE", "NAME", "DESCRIPTION", "QUANTITY" };
/*      */ 
/*  146 */     String[][] category = (String[][])null;
/*      */ 
/*  148 */     this.model = new DefaultTableModel(category, headers);
/*      */ 
/*  153 */     this.tablecategory = new JTable();
/*  154 */     this.tablecategory.setModel(this.model);
/*      */ 
/*  157 */     JScrollPane scrollPane = new JScrollPane(this.tablecategory);
/*  158 */     scrollPane.getViewport().setBackground(Color.WHITE);
/*  159 */     this.tablecategory.setFillsViewportHeight(true);
/*  160 */     this.jPanel11.add(scrollPane, "Center");
/*  161 */     scrollPane.setBackground(Color.WHITE);
/*  162 */     scrollPane.setBounds(0, 0, 345, 153);
/*  163 */     this.tablecategory.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent e) {
/*  165 */         invoice2.this.proc = 0;
/*      */ 
/*  167 */         int row = invoice2.this.tablecategory.getSelectedRow();
/*  168 */         int col = invoice2.this.tablecategory.getSelectedColumn();
/*      */ 
/*  170 */         invoice2.this.code.setText(invoice2.this.cate[row]);
/*  171 */         invoice2.this.jLabel1.setVisible(true);
/*      */ 
/*  173 */         invoice2.this.search();
/*      */ 
/*  177 */         System.out.println("row is " + row + " and " + col);
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public String[] cat()
/*      */   {
/*      */     try {
/*  186 */       String find = this.code.getText();
/*  187 */       System.out.println(find);
/*  188 */       Class.forName("com.mysql.jdbc.Driver");
/*  189 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  190 */       String sql = "SELECT distinct category FROM stock";
/*  191 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  192 */       ResultSet resultSet = stmt.executeQuery();
/*  193 */       if (resultSet.next()) {
/*  194 */         resultSet.last();
/*  195 */         this.mine = new String[resultSet.getRow()];
/*  196 */         resultSet.beforeFirst();
/*      */       }
/*  198 */       int row = 0;
/*  199 */       while (resultSet.next())
/*      */       {
/*  202 */         this.mine[row] = resultSet.getString(1);
/*      */ 
/*  205 */         row++;
/*      */       }
/*  207 */       conn.close();
/*      */     } catch (Exception exc) {
/*  209 */       exc.printStackTrace();
/*  210 */       System.out.println("process error" + exc);
/*      */     }
/*      */ 
/*  215 */     return this.mine;
/*      */   }
/*      */ 
/*      */   public void tablecat()
/*      */   {
/*  220 */     final String[] category2 = cat();
/*      */ 
/*  222 */     String[] headers = { "CODE" };
/*      */ 
/*  228 */     String[][] category = (String[][])null;
/*      */ 
/*  230 */     this.model = new DefaultTableModel(category, headers);
/*      */ 
/*  235 */     this.tablec = new JTable();
/*  236 */     this.tablec.setModel(this.model);
/*      */ 
/*  239 */     JScrollPane scrollPane = new JScrollPane(this.tablec);
/*  240 */     scrollPane.getViewport().setBackground(Color.lightGray);
/*      */ 
/*  242 */     this.jPanel10.add(scrollPane, "Center");
/*  243 */     scrollPane.setBackground(Color.WHITE);
/*  244 */     scrollPane.setBounds(0, 0, 127, 185);
/*      */ 
/*  246 */     this.tablec.addMouseListener(new MouseAdapter()
/*      */     {
/*      */       public void mouseClicked(MouseEvent e)
/*      */       {
/*  250 */         int row = invoice2.this.tablec.getSelectedRow();
/*  251 */         int col = invoice2.this.tablec.getSelectedColumn();
                        tIdno=category2[row];
/*      */ 
/*  255 */         fillcat2(invoice2.this.tIdno);
/*  256 */         invoice2.this.cod(invoice2.this.tIdno);
/*      */ 
/*  258 */         System.out.println("row is " + row + " and " + col);
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   private void initComponents()
/*      */   {
/*  271 */     this.jScrollPane1 = new JScrollPane();
/*  272 */     this.jPanel1 = new JPanel();
/*  273 */     this.jPanel3 = new JPanel();
/*  274 */     this.jPanel5 = new JPanel();
/*  275 */     this.jPanel4 = new JPanel();
/*  276 */     this.jLabel3 = new JLabel();
/*  277 */     this.sub = new JTextField();
/*  278 */     this.jLabel2 = new JLabel();
/*  279 */     this.vat = new JTextField();
/*  280 */     this.jLabel4 = new JLabel();
/*  281 */     this.tot = new JTextField();
/*  282 */     this.jLabel8 = new JLabel();
/*  283 */     this.paid = new JTextField();
/*  284 */     this.jLabel18 = new JLabel();
/*  285 */     this.ch = new JTextField();
/*  286 */     this.jPanel6 = new JPanel();
/*  287 */     this.jPanel7 = new JPanel();
/*  288 */     this.jLabel6 = new JLabel();
/*  289 */     this.jComboBox1 = new JComboBox();
/*  290 */     this.jLabel9 = new JLabel();
/*  291 */     this.nat = new JTextField();
/*  292 */     this.jButton4 = new JButton();
/*  293 */     this.jButton5 = new JButton();
/*  294 */     this.dat = new JTextField();
/*  295 */     this.invoiceno = new JTextField();
/*  296 */     this.jLabel5 = new JLabel();
/*  297 */     this.jPanel8 = new JPanel();
/*  298 */     this.jLabel7 = new JLabel();
/*  299 */     this.jLabel11 = new JLabel();
/*  300 */     this.code = new JTextField();
/*  301 */     this.quantity = new JTextField();
/*  302 */     this.jLabel1 = new JLabel();
/*  303 */     this.jButton3 = new JButton();
/*  304 */     this.jPanel9 = new JPanel();
/*  305 */     this.jPanel10 = new JPanel();
/*  306 */     this.jPanel11 = new JPanel();
/*  307 */     this.jLabel19 = new JLabel();
/*  308 */     this.search = new JTextField();
/*  309 */     this.jButton1 = new JButton();
/*  310 */     this.jButton7 = new JButton();
/*  311 */     this.jLabel10 = new JLabel();
/*  312 */     this.jComboBox2 = new JComboBox();
/*  313 */     this.jButton2 = new JButton();
/*  314 */     this.jButton8 = new JButton();
/*  315 */     this.jLabel13 = new JLabel();
/*      */ 
/*  317 */     setDefaultCloseOperation(2);
/*      */ 
/*  319 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*  320 */     this.jPanel1.setAutoscrolls(true);
/*      */ 
/*  322 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*  323 */     this.jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */ 
/*  325 */     this.jPanel5.setBackground(new Color(153, 153, 255));
/*  326 */     this.jPanel5.setBorder(BorderFactory.createBevelBorder(1));
/*  327 */     this.jPanel5.setPreferredSize(new Dimension(900, 200));
/*      */ 
/*  329 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  330 */     this.jPanel5.setLayout(jPanel5Layout);
/*  331 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  332 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  333 */       .addGap(0, 909, 32767));
/*      */ 
/*  335 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  336 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  337 */       .addGap(0, 202, 32767));
/*      */ 
/*  340 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  341 */     this.jPanel3.setLayout(jPanel3Layout);
/*  342 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  343 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  344 */       .addGroup(jPanel3Layout
/*  344 */       .createSequentialGroup()
/*  345 */       .addComponent(this.jPanel5, -2, 913, -2)
/*  346 */       .addGap(0, 0, 32767)));
/*      */ 
/*  348 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  349 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  350 */       .addComponent(this.jPanel5, -1, 206, 32767));
/*      */ 
/*  353 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/*  354 */     this.jPanel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */ 
/*  356 */     this.jLabel3.setFont(new Font("Tahoma", 1, 11));
/*  357 */     this.jLabel3.setText("SUB-TOTAL:");
/*      */ 
/*  359 */     this.sub.setText("0.00");
/*  360 */     this.sub.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
/*      */ 
/*  362 */     this.jLabel2.setFont(new Font("Tahoma", 1, 11));
/*  363 */     this.jLabel2.setText("TOTAL VAT:");
/*      */ 
/*  365 */     this.vat.setText("0.00");
/*  366 */     this.vat.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
/*      */ 
/*  368 */     this.jLabel4.setFont(new Font("Tahoma", 1, 11));
/*  369 */     this.jLabel4.setText("TOTAL:");
/*      */ 
/*  371 */     this.tot.setText("0.00");
/*  372 */     this.tot.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
/*      */ 
/*  374 */     this.jLabel8.setFont(new Font("Tahoma", 1, 11));
/*  375 */     this.jLabel8.setText("PAID:");
/*      */ 
/*  377 */     this.paid.setFont(new Font("Tahoma", 1, 11));
/*  378 */     this.paid.setText("0.00");
/*  379 */     this.paid.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  380 */     this.paid.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  382 */         invoice2.this.paidActionPerformed(evt);
/*      */       }
/*      */     });
/*  385 */     this.paid.addKeyListener(new KeyAdapter() {
/*      */       public void keyReleased(KeyEvent evt) {
/*  387 */         invoice2.this.paidKeyReleased(evt);
/*      */       }
/*      */     });
/*  391 */     this.jLabel18.setFont(new Font("Tahoma", 1, 12));
/*  392 */     this.jLabel18.setText("CHANGE:");
/*      */ 
/*  394 */     this.ch.setEnabled(false);
/*      */ 
/*  396 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  397 */     this.jPanel4.setLayout(jPanel4Layout);
/*  398 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  399 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  400 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout
/*  400 */       .createSequentialGroup()
/*  401 */       .addContainerGap(19, 32767)
/*  402 */       .addGroup(jPanel4Layout
/*  402 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  403 */       .addGroup(jPanel4Layout
/*  403 */       .createSequentialGroup()
/*  404 */       .addGroup(jPanel4Layout
/*  404 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  405 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout
/*  405 */       .createSequentialGroup()
/*  406 */       .addComponent(this.jLabel4)
/*  407 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  408 */       .addComponent(this.tot, -2, 85, -2))
/*  409 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout
/*  409 */       .createSequentialGroup()
/*  410 */       .addComponent(this.jLabel3)
/*  411 */       .addGap(60, 60, 60)
/*  412 */       .addComponent(this.sub, -2, 84, -2))
/*  413 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout
/*  413 */       .createSequentialGroup()
/*  414 */       .addComponent(this.jLabel2)
/*  415 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  416 */       .addComponent(this.vat, -2, 85, -2)))
/*  417 */       .addContainerGap())
/*  418 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout
/*  418 */       .createSequentialGroup()
/*  419 */       .addGroup(jPanel4Layout
/*  419 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  420 */       .addComponent(this.jLabel8)
/*  421 */       .addComponent(this.jLabel18))
/*  422 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  423 */       .addGroup(jPanel4Layout
/*  423 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  424 */       .addComponent(this.paid, -1, 83, 32767)
/*  425 */       .addComponent(this.ch))
/*  426 */       .addGap(30, 30, 30)))));
/*      */ 
/*  428 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  429 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  430 */       .addGroup(jPanel4Layout
/*  430 */       .createSequentialGroup()
/*  431 */       .addContainerGap()
/*  432 */       .addGroup(jPanel4Layout
/*  432 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  433 */       .addComponent(this.jLabel3)
/*  434 */       .addComponent(this.sub, -2, -1, -2))
/*  435 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  436 */       .addGroup(jPanel4Layout
/*  436 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  437 */       .addGroup(jPanel4Layout
/*  437 */       .createSequentialGroup()
/*  438 */       .addComponent(this.vat, -2, -1, -2)
/*  439 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  440 */       .addComponent(this.tot, -2, -1, -2))
/*  441 */       .addGroup(jPanel4Layout
/*  441 */       .createSequentialGroup()
/*  442 */       .addComponent(this.jLabel2)
/*  443 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  444 */       .addComponent(this.jLabel4)))
/*  445 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  446 */       .addGroup(jPanel4Layout
/*  446 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  447 */       .addComponent(this.jLabel8)
/*  448 */       .addComponent(this.paid, -2, 27, -2))
/*  449 */       .addGap(18, 18, 18)
/*  450 */       .addGroup(jPanel4Layout
/*  450 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  451 */       .addComponent(this.ch, -2, -1, -2)
/*  452 */       .addComponent(this.jLabel18))
/*  453 */       .addContainerGap(-1, 32767)));
/*      */ 
/*  456 */     this.jPanel6.setBackground(new Color(0, 0, 0));
/*  457 */     this.jPanel6.setBorder(new SoftBevelBorder(0));
/*      */ 
/*  459 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  460 */     this.jPanel6.setLayout(jPanel6Layout);
/*  461 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  462 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  463 */       .addGap(0, 0, 32767));
/*      */ 
/*  465 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  466 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  467 */       .addGap(0, 27, 32767));
/*      */ 
/*  470 */     this.jPanel7.setBackground(new Color(153, 153, 255));
/*  471 */     this.jPanel7.setBorder(BorderFactory.createEtchedBorder());
/*      */ 
/*  473 */     this.jLabel6.setText("CUSTOMER :");
/*      */ 
/*  475 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "customer" }));
/*  476 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  478 */         invoice2.this.jComboBox1ActionPerformed(evt);
/*      */       }
/*      */     });
/*  482 */     this.jLabel9.setText("IDNO#:");
/*      */ 
/*  484 */     this.nat.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  485 */     this.nat.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  487 */         invoice2.this.natActionPerformed(evt);
/*      */       }
/*      */     });
/*  490 */     this.nat.addKeyListener(new KeyAdapter() {
/*      */       public void keyReleased(KeyEvent evt) {
/*  492 */         invoice2.this.natKeyReleased(evt);
/*      */       }
/*      */     });
/*  496 */     this.jButton4.setText("FIND");
/*  497 */     this.jButton4.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  499 */         invoice2.this.jButton4ActionPerformed(evt);
/*      */       }
/*      */     });
/*  503 */     this.jButton5.setText("New Customer");
/*  504 */     this.jButton5.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  506 */         invoice2.this.jButton5ActionPerformed(evt);
/*      */       }
/*      */     });
/*  510 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  511 */     this.jPanel7.setLayout(jPanel7Layout);
/*  512 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  513 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  514 */       .addGroup(jPanel7Layout
/*  514 */       .createSequentialGroup()
/*  515 */       .addContainerGap()
/*  516 */       .addComponent(this.jLabel6)
/*  517 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  518 */       .addComponent(this.jComboBox1, -2, 116, -2)
/*  519 */       .addGap(18, 18, 18)
/*  520 */       .addComponent(this.jLabel9)
/*  521 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  522 */       .addComponent(this.nat, -2, 116, -2)
/*  523 */       .addGap(18, 18, 18)
/*  524 */       .addComponent(this.jButton4)
/*  525 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  526 */       .addComponent(this.jButton5)
/*  527 */       .addContainerGap(-1, 32767)));
/*      */ 
/*  529 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  530 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  531 */       .addGroup(jPanel7Layout
/*  531 */       .createSequentialGroup()
/*  532 */       .addContainerGap()
/*  533 */       .addGroup(jPanel7Layout
/*  533 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  534 */       .addComponent(this.jComboBox1, -2, -1, -2)
/*  535 */       .addComponent(this.jLabel6)
/*  536 */       .addComponent(this.jLabel9)
/*  537 */       .addComponent(this.nat, -2, -1, -2)
/*  538 */       .addComponent(this.jButton4)
/*  539 */       .addComponent(this.jButton5))
/*  540 */       .addContainerGap(-1, 32767)));
/*      */ 
/*  543 */     this.dat.setBackground(new Color(204, 204, 204));
/*  544 */     this.dat.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
/*      */ 
/*  546 */     this.invoiceno.setBackground(new Color(204, 204, 204));
/*  547 */     this.invoiceno.setEditable(false);
/*  548 */     this.invoiceno.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
/*      */ 
/*  550 */     this.jLabel5.setText("Invoice no:");
/*      */ 
/*  552 */     this.jPanel8.setBackground(new Color(153, 153, 255));
/*  553 */     this.jPanel8.setBorder(BorderFactory.createEtchedBorder());
/*      */ 
/*  555 */     this.jLabel7.setText("CODE:");
/*      */ 
/*  557 */     this.jLabel11.setText("QUANTITY:");
/*      */ 
/*  559 */     this.code.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  560 */     this.code.addKeyListener(new KeyAdapter() {
/*      */       public void keyReleased(KeyEvent evt) {
/*  562 */         invoice2.this.codeKeyReleased(evt);
/*      */       }
/*      */     });
/*  566 */     this.quantity.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */ 
/*  568 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/inventory/tick-1.png")));
/*      */ 
/*  570 */     this.jButton3.setText("ADD ITEM");
/*  571 */     this.jButton3.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  573 */         invoice2.this.jButton3ActionPerformed(evt);
/*      */       }
/*      */     });
/*  577 */     this.jPanel9.setBackground(new Color(153, 153, 255));
/*  578 */     this.jPanel9.setBorder(BorderFactory.createEtchedBorder());
/*      */ 
/*  580 */     this.jPanel10.setBackground(new Color(153, 153, 255));
/*      */ 
/*  582 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  583 */     this.jPanel10.setLayout(jPanel10Layout);
/*  584 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  585 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  586 */       .addGap(0, 127, 32767));
/*      */ 
/*  588 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  589 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  590 */       .addGap(0, 184, 32767));
/*      */ 
/*  593 */     this.jPanel11.setBackground(new Color(153, 153, 255));
/*      */ 
/*  595 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  596 */     this.jPanel11.setLayout(jPanel11Layout);
/*  597 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/*  598 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  599 */       .addGap(0, 345, 32767));
/*      */ 
/*  601 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/*  602 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  603 */       .addGap(0, 0, 32767));
/*      */ 
/*  606 */     this.jLabel19.setText("Search");
/*      */ 
/*  608 */     this.search.addKeyListener(new KeyAdapter() {
/*      */       public void keyReleased(KeyEvent evt) {
/*  610 */         invoice2.this.searchKeyReleased(evt);
/*      */       }
/*      */     });
/*  614 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  615 */     this.jPanel9.setLayout(jPanel9Layout);
/*  616 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  617 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  618 */       .addGroup(jPanel9Layout
/*  618 */       .createSequentialGroup()
/*  619 */       .addComponent(this.jPanel10, -1, -1, 32767)
/*  620 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  621 */       .addGroup(jPanel9Layout
/*  621 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  622 */       .addGroup(jPanel9Layout
/*  622 */       .createSequentialGroup()
/*  623 */       .addComponent(this.jLabel19)
/*  624 */       .addGap(18, 18, 18)
/*  625 */       .addComponent(this.search, -2, 170, -2)
/*  626 */       .addGap(76, 76, 76))
/*  627 */       .addGroup(jPanel9Layout
/*  627 */       .createSequentialGroup()
/*  628 */       .addComponent(this.jPanel11, -2, -1, -2)
/*  629 */       .addContainerGap()))));
/*      */ 
/*  631 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  632 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  633 */       .addGroup(jPanel9Layout
/*  633 */       .createSequentialGroup()
/*  634 */       .addContainerGap()
/*  635 */       .addGroup(jPanel9Layout
/*  635 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  636 */       .addComponent(this.jLabel19)
/*  637 */       .addComponent(this.search, -2, -1, -2))
/*  638 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  639 */       .addComponent(this.jPanel11, -1, -1, 32767))
/*  640 */       .addComponent(this.jPanel10, GroupLayout.Alignment.TRAILING, -2, -1, -2));
/*      */ 
/*  643 */     this.jButton1.setText("Save& Print");
/*  644 */     this.jButton1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  646 */         invoice2.this.jButton1ActionPerformed(evt);
/*      */       }
/*      */     });
/*  650 */     this.jButton7.setText("DISCARD");
/*  651 */     this.jButton7.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  653 */         invoice2.this.jButton7ActionPerformed(evt);
/*      */       }
/*      */     });
/*  657 */     this.jLabel10.setText("PRICE:");
/*      */ 
/*  659 */     this.jComboBox2.setEditable(true);
/*  660 */     this.jComboBox2.addKeyListener(new KeyAdapter() {
/*      */       public void keyReleased(KeyEvent evt) {
/*  662 */         invoice2.this.jComboBox2KeyReleased(evt);
/*      */       }
/*      */     });
/*  666 */     this.jButton2.setText("REMOVE ITEM");
/*  667 */     this.jButton2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  669 */         invoice2.this.jButton2ActionPerformed(evt);
/*      */       }
/*      */     });
/*  673 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  674 */     this.jPanel8.setLayout(jPanel8Layout);
/*  675 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  676 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  677 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout
/*  677 */       .createSequentialGroup()
/*  678 */       .addContainerGap()
/*  679 */       .addComponent(this.jPanel9, -2, -1, -2)
/*  680 */       .addGroup(jPanel8Layout
/*  680 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  681 */       .addGroup(jPanel8Layout
/*  681 */       .createSequentialGroup()
/*  682 */       .addGap(53, 53, 53)
/*  683 */       .addComponent(this.jLabel7)
/*  684 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  685 */       .addComponent(this.code, -2, 116, -2)
/*  686 */       .addGap(26, 26, 26)
/*  687 */       .addGroup(jPanel8Layout
/*  687 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  688 */       .addGroup(jPanel8Layout
/*  688 */       .createSequentialGroup()
/*  689 */       .addGap(0, 0, 32767)
/*  690 */       .addComponent(this.jButton7)
/*  691 */       .addGap(18, 18, 18)
/*  692 */       .addComponent(this.jButton1)
/*  693 */       .addGap(34, 34, 34))
/*  694 */       .addGroup(jPanel8Layout
/*  694 */       .createSequentialGroup()
/*  695 */       .addComponent(this.jLabel1)
/*  696 */       .addContainerGap(-1, 32767))))
/*  697 */       .addGroup(jPanel8Layout
/*  697 */       .createSequentialGroup()
/*  698 */       .addGap(26, 26, 26)
/*  699 */       .addGroup(jPanel8Layout
/*  699 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  700 */       .addComponent(this.jLabel10)
/*  701 */       .addComponent(this.jLabel11))
/*  702 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  703 */       .addGroup(jPanel8Layout
/*  703 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  704 */       .addGroup(jPanel8Layout
/*  704 */       .createSequentialGroup()
/*  705 */       .addComponent(this.jComboBox2, -2, 122, -2)
/*  706 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  707 */       .addComponent(this.jButton3)
/*  708 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  709 */       .addComponent(this.jButton2))
/*  710 */       .addComponent(this.quantity, -2, 115, -2))
/*  711 */       .addContainerGap()))));
/*      */ 
/*  713 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  714 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  715 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout
/*  715 */       .createSequentialGroup()
/*  716 */       .addGroup(jPanel8Layout
/*  716 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  717 */       .addComponent(this.jButton1, -2, 23, -2)
/*  718 */       .addComponent(this.jButton7))
/*  719 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767)
/*  720 */       .addGroup(jPanel8Layout
/*  720 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  721 */       .addGroup(jPanel8Layout
/*  721 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  722 */       .addComponent(this.code, -2, -1, -2)
/*  723 */       .addComponent(this.jLabel7))
/*  724 */       .addComponent(this.jLabel1))
/*  725 */       .addGap(18, 18, 18)
/*  726 */       .addGroup(jPanel8Layout
/*  726 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  727 */       .addComponent(this.jLabel11)
/*  728 */       .addComponent(this.quantity, -2, -1, -2))
/*  729 */       .addGap(25, 25, 25)
/*  730 */       .addGroup(jPanel8Layout
/*  730 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  731 */       .addComponent(this.jLabel10)
/*  732 */       .addComponent(this.jComboBox2, -2, -1, -2)
/*  733 */       .addComponent(this.jButton3)
/*  734 */       .addComponent(this.jButton2))
/*  735 */       .addGap(74, 74, 74))
/*  736 */       .addGroup(jPanel8Layout
/*  736 */       .createSequentialGroup()
/*  737 */       .addContainerGap()
/*  738 */       .addComponent(this.jPanel9, -2, -1, -2)
/*  739 */       .addContainerGap(-1, 32767)));
/*      */ 
/*  742 */     this.jButton8.setText("New Invoice");
/*  743 */     this.jButton8.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  745 */         invoice2.this.jButton8ActionPerformed(evt);
/*      */       }
/*      */     });
/*  749 */     this.jLabel13.setText("Date:");
/*      */ 
/*  751 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  752 */     this.jPanel1.setLayout(jPanel1Layout);
/*  753 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  754 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  755 */       .addComponent(this.jPanel6, -1, -1, 32767)
/*  756 */       .addGroup(jPanel1Layout
/*  756 */       .createSequentialGroup()
/*  757 */       .addContainerGap()
/*  758 */       .addGroup(jPanel1Layout
/*  758 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  759 */       .addGroup(jPanel1Layout
/*  759 */       .createSequentialGroup()
/*  760 */       .addGroup(jPanel1Layout
/*  760 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  761 */       .addGroup(jPanel1Layout
/*  761 */       .createSequentialGroup()
/*  762 */       .addComponent(this.jLabel5)
/*  763 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  764 */       .addComponent(this.invoiceno, -2, 133, -2)
/*  765 */       .addGap(18, 18, 18)
/*  766 */       .addComponent(this.jButton8)
/*  767 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  768 */       .addComponent(this.jLabel13)
/*  769 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  770 */       .addComponent(this.dat, -2, 122, -2))
/*  771 */       .addComponent(this.jPanel7, -2, -1, -2))
/*  772 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  773 */       .addComponent(this.jPanel4, -2, -1, -2))
/*  774 */       .addComponent(this.jPanel3, -2, -1, -2)
/*  775 */       .addComponent(this.jPanel8, -2, 929, -2))
/*  776 */       .addContainerGap(-1, 32767)));
/*      */ 
/*  778 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  779 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  780 */       .addGroup(jPanel1Layout
/*  780 */       .createSequentialGroup()
/*  781 */       .addComponent(this.jPanel6, -2, -1, -2)
/*  782 */       .addGroup(jPanel1Layout
/*  782 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  783 */       .addGroup(jPanel1Layout
/*  783 */       .createSequentialGroup()
/*  784 */       .addGap(3, 3, 3)
/*  785 */       .addGroup(jPanel1Layout
/*  785 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  786 */       .addComponent(this.jLabel5)
/*  787 */       .addComponent(this.invoiceno)
/*  788 */       .addComponent(this.dat, -2, -1, -2)
/*  789 */       .addComponent(this.jButton8)
/*  790 */       .addComponent(this.jLabel13))
/*  791 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  792 */       .addComponent(this.jPanel7, -2, -1, -2)
/*  793 */       .addGap(106, 106, 106))
/*  794 */       .addGroup(jPanel1Layout
/*  794 */       .createSequentialGroup()
/*  795 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  796 */       .addComponent(this.jPanel4, -2, -1, -2)
/*  797 */       .addGap(15, 15, 15)))
/*  798 */       .addComponent(this.jPanel8, -2, -1, -2)
/*  799 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  800 */       .addComponent(this.jPanel3, -2, -1, -2)
/*  801 */       .addContainerGap()));
/*      */ 
/*  804 */     this.jScrollPane1.setViewportView(this.jPanel1);
/*      */ 
/*  806 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  807 */     getContentPane().setLayout(layout);
/*  808 */     layout.setHorizontalGroup(layout
/*  809 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  810 */       .addComponent(this.jScrollPane1, -1, 966, 32767));
/*      */ 
/*  812 */     layout.setVerticalGroup(layout
/*  813 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  814 */       .addComponent(this.jScrollPane1, -1, 668, 32767));
/*      */ 
/*  817 */     pack();
/*      */   }
/*      */ 
/*      */   private void paidActionPerformed(ActionEvent evt)
/*      */   {
/*      */     try {
/*  823 */       double d = Double.parseDouble(this.tot.getText());
/*  824 */       double p = Double.parseDouble(this.paid.getText());
/*  825 */       if (d < p) {
/*  826 */         this.paid.setText(String.valueOf(p));
/*      */       }
/*  828 */       else if (d == p) {
/*  829 */         this.paid.setText(String.valueOf(p));
/*      */       }
/*  831 */       else if (p > d) {
/*  832 */         double f = p - d;
/*  833 */         this.paid.setText(String.valueOf(f));
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  838 */       this.paid.setText("");
/*  839 */       this.paid.requestFocus();
/*      */     }
/*      */   }
/*      */ 
/*      */   private void paidKeyReleased(KeyEvent evt)
/*      */   {
/*      */     try {
/*  846 */       double d = Double.parseDouble(this.tot.getText());
/*  847 */       double p = Double.parseDouble(this.paid.getText());
/*  848 */       if (d < p) {
/*  849 */         this.paid.setText(String.valueOf(p));
/*      */       }
/*  851 */       else if (d == p) {
/*  852 */         this.paid.setText(String.valueOf(p));
/*      */       }
/*  854 */       else if (p > d) {
/*  855 */         double f = p - d;
/*  856 */         this.paid.setText(String.valueOf(f));
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  861 */       this.paid.setText("");
/*  862 */       this.paid.requestFocus();
/*      */     }
/*      */   }
/*      */ 
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/*  867 */     fill2((String)this.jComboBox1.getSelectedItem());
/*      */   }
/*      */ 
/*      */   private void natActionPerformed(ActionEvent evt)
/*      */   {
/*      */   }
/*      */ 
/*      */   private void natKeyReleased(KeyEvent evt)
/*      */   {
/*      */   }
/*      */ 
/*      */   private void jButton4ActionPerformed(ActionEvent evt)
/*      */   {
/*  883 */     if (this.nat.getText().equals("")) {
/*  884 */       JOptionPane.showMessageDialog(null, "Empty ID field", "Error", 0);
/*      */     }
/*      */     else
/*  887 */       searchid(this.nat.getText());
/*      */   }
/*      */ 
/*      */   private void jButton5ActionPerformed(ActionEvent evt)
/*      */   {
/*  893 */     upd dialog = new upd(new JFrame(), true);
/*  894 */     dialog.setVisible(true);
/*      */ 
/*  897 */     fill();
/*      */   }
/*      */ 
/*      */   private void codeKeyReleased(KeyEvent evt) {
/*  901 */     search();
/*      */   }
/*      */ 
/*      */   private void jButton3ActionPerformed(ActionEvent evt)
/*      */   {
/*  906 */     if (!this.code.equals(""))
/*      */     {
/*  910 */       if (this.proc == 0)
/*      */       {
/*  913 */         if (this.vat.getText().equals("")) {
/*  914 */           this.vat.setText("0.00");
/*      */         }
/*  916 */         if (this.tot.getText().equals("")) {
/*  917 */           this.tot.setText("0.00");
/*      */         }
/*  919 */         if (this.sub.getText().equals("")) {
/*  920 */           this.sub.setText("0.00");
/*      */         }
/*  922 */         double check = Double.parseDouble(this.quan);
/*  923 */         int yu = checkInvoice();
/*  924 */         double q = 0.0D;
/*      */         try
/*      */         {
/*  927 */           q = Double.valueOf(this.quantity.getText()).doubleValue();
/*      */         }
/*      */         catch (Exception ex) {
/*  930 */           this.quantity.setText("");
/*      */         }
/*      */ 
/*  935 */         if ((this.quantity.equals("")) || (q <= 0.0D)) {
/*  936 */           this.quantity.setText("");
/*  937 */           JOptionPane.showMessageDialog(null, "Quantity is Empty", "Error!", 0);
/*      */         }
/*  941 */         else if ((q > check) && (this.type == 0)) {
/*  942 */           JOptionPane.showMessageDialog(null, "Stock availble is " + check, "Error!", 0);
/*  943 */           this.quantity.requestFocus();
/*      */         }
/*  946 */         else if (this.jComboBox2.getSelectedItem().toString().equals(""))
/*      */         {
/*  948 */           JOptionPane.showMessageDialog(null, "Enter price", "Error!", 0);
/*      */         }
/*  950 */         else if (yu > 0) {
/*  951 */           JOptionPane.showMessageDialog(null, "Edit Item quantity. Item already Exists", "Error!", 0);
/*      */         }
/*  955 */         else if (Double.parseDouble(this.jComboBox2.getSelectedItem().toString()) < BuyingPrice(this.item)) {
/*  956 */           int x = 0;
/*  957 */           x = JOptionPane.showConfirmDialog(null, "The price Entered is Less than the cost of Item. Click yes to go ahead and sell Item", " Item price!!", 0);
/*      */ 
/*  959 */           if (x == 0)
/*      */           {
/*  961 */             Iinvoice();
/*      */ 
/*  969 */             insertsales();
/*  970 */             insertdebtors();
/*      */ 
/*  972 */             this.jButton1.setEnabled(true);
/*  973 */             fillcat2(this.tIdno);
/*  974 */             int checkreor = checkReorder(this.code.getText());
/*  975 */             if ((checkreor >= 1) && (this.type == 0)) {
/*  976 */               JOptionPane.showMessageDialog(null, "Please reoder stock for item " + this.code.getText() + "", "Warning!!", 1);
/*      */             }
/*      */ 
/*  979 */             this.code.setText("");
/*      */           }
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  987 */           Iinvoice();
/*      */ 
/*  995 */           insertsales();
/*  996 */           insertdebtors();
/*      */ 
/*  998 */           this.jButton1.setEnabled(true);
/*  999 */           fillcat2(this.tIdno);
/* 1000 */           int checkreor = checkReorder(this.code.getText());
/* 1001 */           if (checkreor >= 1) {
/* 1002 */             JOptionPane.showMessageDialog(null, "Please reoder stock for item " + this.code.getText() + "", "Warning!!", 1);
/*      */           }
/*      */ 
/* 1005 */           this.code.setText("");
/*      */         }
/*      */ 
/*      */       }
/* 1011 */       else if (this.proc == 1) {
/* 1012 */         updateInvoice();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private void jButton1ActionPerformed(ActionEvent evt)
/*      */   {
/* 1020 */     double pd = 0.0D;
/*      */     try {
/* 1022 */       pd = Double.parseDouble(this.paid.getText());
/*      */     }
/*      */     catch (Exception e) {
/* 1025 */       this.paid.setText("");
/*      */     }
/* 1027 */     if (this.paid.getText().equals(""))
/*      */     {
/* 1030 */       JOptionPane.showMessageDialog(null, "Paid is empty", "ERROR", 0);
/*      */     }
/* 1033 */     else if ((this.jComboBox1.getSelectedItem().toString().equals("customer")) && (pd < Double.parseDouble(this.tot.getText()))) {
/* 1034 */       JOptionPane.showMessageDialog(null, "Select customer name to continue", "ERROR", 0);
/*      */     }
/*      */     else
/*      */       try
/*      */       {
/* 1039 */         calc();
/* 1040 */         truncdetails();
/* 1041 */         truncinvoice();
/* 1042 */         insertdet();
/* 1043 */         invoicereport();
/* 1044 */         sold();
/* 1045 */         updatename();
/* 1046 */         updatename2();
/*      */ 
/* 1048 */         System.out.println("purchss");
/* 1049 */         invoicereport ma = new invoicereport(new JFrame(), true);
/* 1050 */         ma.initConnection();
/* 1051 */         ma.showReport();
/*      */       }
/*      */       catch (FileNotFoundException ex)
/*      */       {
/* 1055 */         Logger.getLogger(reports.class.getName()).log(Level.SEVERE, null, ex);
/*      */       }
/*      */   }
/*      */ 
/*      */   public void updatename()
/*      */   {
/*      */     try
/*      */     {
/* 1065 */       Class.forName("com.mysql.jdbc.Driver");
/* 1066 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1067 */       String sql = "update debtors set name='" + this.jComboBox1.getSelectedItem().toString() + "' where invoiceno='" + this.invoiceno.getText() + "'";
/* 1068 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1069 */       int y = stmt.executeUpdate();
/*      */ 
/* 1071 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1073 */       exc.printStackTrace();
/* 1074 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatename2()
/*      */   {
/*      */     try
/*      */     {
/* 1090 */       Class.forName("com.mysql.jdbc.Driver");
/* 1091 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1092 */       String sql = "update invoicetransactions set name='" + this.jComboBox1.getSelectedItem().toString() + "' where invoiceno='" + this.invoiceno.getText() + "'";
/* 1093 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1094 */       int y = stmt.executeUpdate();
/*      */ 
/* 1096 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1098 */       exc.printStackTrace();
/* 1099 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   private void jButton2ActionPerformed(ActionEvent evt)
/*      */   {
/* 1113 */     if (this.proc != 1) {
/* 1114 */       JOptionPane.showMessageDialog(null, "Select Item to remove", "Error!", 0);
/*      */     }
/* 1117 */     else if (this.code.getText().equals(""))
/*      */     {
/* 1119 */       JOptionPane.showMessageDialog(null, "Select Item to remove", "Error!", 0);
/* 1120 */       this.code.requestFocus();
/*      */     }
/*      */     else {
/* 1123 */       int y = 0;
/* 1124 */       y = JOptionPane.showConfirmDialog(null, "Do you want do delete " + this.coded + " from " + this.invoiceno.getText() + "?", "Confirm", 1);
/* 1125 */       if (y == 0) {
/* 1126 */         if (this.coded != null)
/*      */         {
/* 1128 */           String inv = this.invoiceno.getText();
/* 1129 */           String itemcode = this.code.getText();
/* 1130 */           searchq2(this.coded);
/* 1131 */           getamt(inv);
/* 1132 */           getsales(inv);
/*      */ 
/* 1134 */           addition();
/* 1135 */           delete();
/* 1136 */           update_table();
/* 1137 */           update();
/* 1138 */           add();
/* 1139 */           add2();
/* 1140 */           total();
/* 1141 */           intial();
/* 1142 */           intial2();
/*      */ 
/* 1148 */           updatedeb(inv);
/* 1149 */           updatesale(inv);
/* 1150 */           updatedebt();
/* 1151 */           updatesalet();
/*      */ 
/* 1153 */           fillcat2(this.tIdno);
/*      */         }
/* 1155 */         this.code.setText("");
/* 1156 */         this.quantity.setText("");
/* 1157 */         this.jComboBox2.setSelectedItem("");
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private void jButton7ActionPerformed(ActionEvent evt)
/*      */   {
/* 1164 */     stockUpdate();
/* 1165 */     delete();
/* 1166 */     delete2();
/* 1167 */     delete3();
/* 1168 */     dispose();
/*      */   }
/*      */ 
/*      */   private void searchKeyReleased(KeyEvent evt) {
/* 1172 */     codsearch(this.search.getText());
/* 1173 */     fillcat2search(this.search.getText());
/*      */   }
/*      */ 
/*      */   private void jComboBox2KeyReleased(KeyEvent evt) {
/*      */     try {
           double hfg;
/* 1178 */       hfg = Double.parseDouble(this.jComboBox2.getSelectedItem().toString());
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */       
/* 1181 */       this.jComboBox2.setSelectedItem("");
/*      */     }
/*      */   }
/*      */ 
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 1186 */     dispose();
/*      */ 
/* 1188 */     Invoice n = new Invoice(new JFrame(), true) {};
/* 1189 */    n.setVisible(true);
            
/*      */   }
/*      */ 
/*      */   public void invoiceno()
/*      */   {
/* 1194 */     Calendar cal = Calendar.getInstance();
/* 1195 */     SimpleDateFormat form = new SimpleDateFormat("ssmmhhddMMyy");
/* 1196 */     this.invoiceno.setText(form.format(cal.getTime()));
/*      */   }
/*      */ 
/*      */   public String[][] getData()
/*      */   {
/* 1201 */     String[][] sample = (String[][])null;
/* 1202 */     String str = "SELECT * from invoice";
/*      */     try
/*      */     {
/* 1211 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/* 1212 */       Statement st = cn.createStatement();
/*      */ 
/* 1214 */       ResultSet rs = st.executeQuery(str);
/*      */ 
/* 1217 */       if (rs.next()) {
/* 1218 */         rs.last();
/*      */ 
/* 1220 */         sample = new String[rs.getRow()][6];
/* 1221 */         rs.beforeFirst();
/*      */       }
/* 1223 */       int rowcount = 0;
/*      */ 
/* 1225 */       while (rs.next())
/*      */       {
/* 1228 */         sample[rowcount][0] = rs.getString(2);
/* 1229 */         sample[rowcount][1] = rs.getString(3);
/* 1230 */         sample[rowcount][2] = rs.getString(4);
/* 1231 */         sample[rowcount][3] = rs.getString(5);
/*      */ 
/* 1233 */         sample[rowcount][4] = rs.getString(8);
/* 1234 */         sample[rowcount][5] = rs.getString(7);
/*      */ 
/* 1242 */         rowcount++;
/*      */       }
/*      */ 
/* 1245 */       rs.close();
/* 1246 */       cn.close();
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*      */     }
/*      */ 
/* 1252 */     System.out.println(sample);
/* 1253 */     return sample;
/*      */   }
/*      */   public void update() {
/* 1256 */     String tsearch = this.invoiceno.getText();
/*      */     try
/*      */     {
/* 1262 */       Class.forName("com.mysql.jdbc.Driver");
/* 1263 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1264 */       String sql = "SELECT * FROM invoice where invoiceno='" + tsearch + "'";
/* 1265 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1266 */       ResultSet resultSet = stmt.executeQuery();
/* 1267 */       if (resultSet.next()) {
/* 1268 */         resultSet.last();
/* 1269 */         this.purchased = new String[resultSet.getRow()][7];
/* 1270 */         resultSet.beforeFirst();
/*      */       }
/* 1272 */       int row = 0;
/* 1273 */       while (resultSet.next())
/*      */       {
/* 1276 */         this.purchased[row][0] = resultSet.getString(2);
/* 1277 */         this.purchased[row][1] = resultSet.getString(3);
/* 1278 */         this.purchased[row][2] = resultSet.getString(4);
/* 1279 */         this.purchased[row][3] = resultSet.getString(5);
/* 1280 */         this.purchased[row][4] = resultSet.getString(8);
/* 1281 */         this.purchased[row][5] = resultSet.getString(7);
/* 1282 */         this.purchased[row][6] = resultSet.getString(6);
/* 1283 */         row++;
/* 1284 */         System.out.println("hit");
/*      */       }
/* 1286 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1288 */       exc.printStackTrace();
/* 1289 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void table()
/*      */   {
/* 1300 */     String[] headers = { "CODE", "Name", "DESCRIPTION", "QUANTITY", "VAT AMOUNT", "PRICE" };
/*      */ 
/* 1307 */     this.model = new DefaultTableModel(this.data, headers);
/*      */ 
/* 1312 */     this.table = new JTable();
/* 1313 */     this.table.setModel(this.model);
/*      */ 
/* 1316 */     JScrollPane scrollPane = new JScrollPane(this.table);
/* 1317 */     scrollPane.getViewport().setBackground(Color.white);
/*      */ 
/* 1320 */     this.jPanel5.add(scrollPane, "Center");
/* 1321 */     scrollPane.setBackground(Color.WHITE);
/* 1322 */     scrollPane.setBounds(0, 0, 915, 204);
/* 1323 */     this.table.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent e) {
/* 1325 */         invoice2.this.proc = 1;
/*      */ 
/* 1328 */         int row = invoice2.this.table.getSelectedRow();
/* 1329 */         int col = invoice2.this.table.getSelectedColumn();
/*      */ 
/* 1332 */         invoice2.this.coded = invoice2.this.purchased[row][0];
/* 1333 */         invoice2.this.quant = invoice2.this.purchased[row][3];
/* 1334 */         invoice2.this.vatn = invoice2.this.purchased[row][4];
/*      */ 
/* 1336 */         invoice2.this.quantity.setText(invoice2.this.quant);
/* 1337 */         invoice2.this.code.setText(invoice2.this.coded);
/* 1338 */         invoice2.this.jComboBox2.removeAllItems();
/* 1339 */         invoice2.this.jComboBox2.setSelectedItem(invoice2.this.purchased[row][6]);
/* 1340 */         invoice2.this.cprice = invoice2.this.purchased[row][6];
/*      */ 
/* 1343 */         System.out.println("row is " + row + " and " + col);
/*      */       } } );
/*      */   }
/*      */ 
/*      */   public String[] cod(String catego) {
/* 1348 */     String tsearch = this.invoiceno.getText();
/*      */     try
/*      */     {
/* 1352 */       String find = this.code.getText();
/* 1353 */       System.out.println(find);
/* 1354 */       Class.forName("com.mysql.jdbc.Driver");
/* 1355 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1356 */       String sql = "SELECT Itemcode FROM stock where category='" + catego + "'";
/* 1357 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1358 */       ResultSet resultSet = stmt.executeQuery();
/* 1359 */       if (resultSet.next()) {
/* 1360 */         resultSet.last();
/* 1361 */         this.cate = new String[resultSet.getRow()];
/* 1362 */         resultSet.beforeFirst();
/*      */       }
/* 1364 */       int row = 0;
/* 1365 */       while (resultSet.next())
/*      */       {
/* 1368 */         this.cate[row] = resultSet.getString(1);
/*      */ 
/* 1371 */         row++;
/*      */       }
/* 1373 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1375 */       exc.printStackTrace();
/* 1376 */       System.out.println("process error" + exc);
/*      */     }
/*      */ 
/* 1381 */     return this.cate;
/*      */   }
/*      */ 
/*      */   public void fillcat3()
/*      */   {
/*      */     try
/*      */     {
/* 1388 */       String find = this.code.getText();
/* 1389 */       System.out.println(find);
/* 1390 */       Class.forName("com.mysql.jdbc.Driver");
/* 1391 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1392 */       String sql = "SELECT Itemcode FROM stock";
/* 1393 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1394 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/* 1396 */       this.tablecategory.setModel(DbUtils.resultSetToTableModel(resultSet));
/* 1397 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1399 */       exc.printStackTrace();
/* 1400 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updateInvoice()
/*      */   {
/* 1408 */     double qy = 0.0D;
/*      */     try
/*      */     {
/* 1411 */       qy = Double.valueOf(this.quantity.getText()).doubleValue();
/*      */     }
/*      */     catch (Exception ex) {
/* 1414 */       this.quantity.setText("");
/*      */     }
/*      */ 
/* 1418 */     if ((this.quantity.equals("")) || (qy <= 0.0D)) {
/* 1419 */       JOptionPane.showMessageDialog(null, "Quantity is Empty", "Error!", 0);
/* 1420 */       this.quantity.requestFocus();
/*      */     }
/* 1424 */     else if (this.code.getText().equals(""))
/*      */     {
/* 1426 */       JOptionPane.showMessageDialog(null, "Select Item to save", "Error!", 0);
/* 1427 */       this.code.requestFocus();
/*      */     }
/* 1430 */     else if (this.jComboBox2.getSelectedItem().toString().equals(""))
/*      */     {
/* 1432 */       JOptionPane.showMessageDialog(null, "Enter price", "Error!", 0);
/*      */     }
/* 1436 */     else if (this.coded != null)
/*      */     {
/* 1439 */       search2();
/* 1440 */       searchq2(this.coded);
/* 1441 */       double check = Double.parseDouble(this.quan);
/* 1442 */       if (qy > check) {
/* 1443 */         JOptionPane.showMessageDialog(null, "Stock availble is " + check, "Error!", 0);
/* 1444 */         this.quantity.requestFocus();
/*      */       }
/* 1449 */       else if (Double.parseDouble(this.jComboBox2.getSelectedItem().toString()) < BuyingPrice(this.code.getText())) {
/* 1450 */         int x = 0;
/* 1451 */         x = JOptionPane.showConfirmDialog(null, "The price Entered is Less than the cost of Item. Click yes to go ahead and sell Item", " Item price!!", 0);
/*      */ 
/* 1453 */         if (x == 0)
/*      */         {
/* 1455 */           addition2();
/* 1456 */           delete();
/* 1457 */           Iinvoice2();
/* 1458 */           update();
/* 1459 */           update_table();
/*      */ 
/* 1461 */           this.quantity.setText("");
/* 1462 */           this.jComboBox2.setSelectedItem("");
/* 1463 */           fillcat2(this.tIdno);
/* 1464 */           int checkreor = checkReorder(this.code.getText());
/* 1465 */           if (checkreor >= 1) {
/* 1466 */             JOptionPane.showMessageDialog(null, "Please reoder stock for item " + this.code.getText() + "", "Warning!!", 1);
/*      */           }
/*      */ 
/* 1469 */           this.code.setText("");
/*      */         }
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1476 */         addition2();
/* 1477 */         delete();
/* 1478 */         Iinvoice2();
/* 1479 */         update();
/* 1480 */         update_table();
/*      */ 
/* 1482 */         this.quantity.setText("");
/* 1483 */         this.jComboBox2.setSelectedItem("");
/* 1484 */         fillcat2(this.tIdno);
/* 1485 */         int checkreor = checkReorder(this.code.getText());
/* 1486 */         if (checkreor >= 1) {
/* 1487 */           JOptionPane.showMessageDialog(null, "Please reoder stock for item " + this.code.getText() + "", "Warning!!", 1);
/*      */         }
/*      */ 
/* 1490 */         this.code.setText("");
/* 1491 */         this.code.setText("");
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public void delete()
/*      */   {
/*      */     try
/*      */     {
/* 1507 */       Class.forName("com.mysql.jdbc.Driver");
/* 1508 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1509 */       String sql = "DELETE FROM invoice where Itemcode='" + this.coded + "' && invoiceno='" + this.invoiceno.getText() + "'";
/* 1510 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1511 */       int r = stmt.executeUpdate();
/*      */ 
/* 1514 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1516 */       exc.printStackTrace();
/* 1517 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void update_table()
/*      */   {
/*      */     try
/*      */     {
/* 1527 */       String find = this.invoiceno.getText();
/* 1528 */       System.out.println(find);
/* 1529 */       Class.forName("com.mysql.jdbc.Driver");
/* 1530 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1531 */       String sql = "SELECT Itemcode as 'CODE',item as 'Name', description as 'DESCRIPTION',quantity as 'QUANTITY',vat as 'VAT AMOUNT',price as 'PRICE' FROM invoice where invoiceno='" + find + "'";
/* 1532 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1533 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/* 1535 */       this.table.setModel(DbUtils.resultSetToTableModel(resultSet));
/* 1536 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1538 */       exc.printStackTrace();
/* 1539 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void searchq2(String find)
/*      */   {
/*      */     try
/*      */     {
/* 1550 */       System.out.println(find);
/* 1551 */       Class.forName("com.mysql.jdbc.Driver");
/* 1552 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1553 */       String sql = "SELECT quantity FROM stock where Itemcode='" + find + "'";
/* 1554 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1555 */       ResultSet resultSet = stmt.executeQuery();
/* 1556 */       while (resultSet.next()) {
/* 1557 */         this.cquan2 = resultSet.getString("quantity");
/*      */ 
/* 1559 */         System.out.println(this.cquan2 + "result");
/*      */       }
/* 1561 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1563 */       exc.printStackTrace();
/* 1564 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void invoicereport()
/*      */   {
/* 1574 */     String inv = this.invoiceno.getText();
/* 1575 */     String datq = this.dat.getText();
/* 1576 */     String str = "INSERT INTO invoiceholder (invoiceno,itemcode,item,description,quantity,price,subtotal,vat) select invoiceno,itemcode,item,description,quantity,price,subtotal,vat from invoice where invoiceno='" + inv + "'";
/*      */     try
/*      */     {
/* 1584 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 1586 */       Statement st = cn.createStatement();
/* 1587 */       int i = st.executeUpdate(str);
/*      */ 
/* 1590 */       st = cn.createStatement();
/*      */     }
/*      */     catch (Exception ex) {
/* 1593 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void addition()
/*      */   {
/* 1599 */     double adder = Double.parseDouble(this.quant);
/* 1600 */     double before = Double.parseDouble(this.cquan2);
/* 1601 */     double both = before + adder;
/* 1602 */     String finaltosave = String.valueOf(both);
/*      */     try
/*      */     {
/* 1606 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 1607 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1608 */       String sql = "update stock set quantity='" + finaltosave + "' where Itemcode='" + this.coded + "' && type=0";
/* 1609 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 1612 */       int u = stmt.executeUpdate();
/* 1613 */       if (u > 0)
/*      */       {
/* 1615 */         System.out.println("done");
/*      */       }
/*      */     } catch (Exception ex) {
/* 1618 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void search2()
/*      */   {
/*      */     try {
/* 1625 */       Class.forName("com.mysql.jdbc.Driver");
/* 1626 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1627 */       String sql = "SELECT name,description,quantity,vat,price,type FROM stock where Itemcode='" + this.coded + "'";
/* 1628 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1629 */       ResultSet resultSet = stmt.executeQuery();
/* 1630 */       while (resultSet.next())
/*      */       {
/* 1632 */         this.item = resultSet.getString("name");
/* 1633 */         this.des = resultSet.getString("description");
/* 1634 */         this.quan = resultSet.getString("quantity");
/* 1635 */         this.type = resultSet.getInt("type");
/* 1636 */         this.jComboBox2.addItem(resultSet.getString("price"));
/* 1637 */         this.tvat = resultSet.getString("vat");
/* 1638 */         this.jLabel1.setVisible(true);
/*      */       }
/*      */ 
/* 1641 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1643 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void fill()
/*      */   {
/*      */     try
/*      */     {
/* 1652 */       Class.forName("com.mysql.jdbc.Driver");
/* 1653 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1654 */       String sql = "SELECT name FROM customer";
/* 1655 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1656 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/* 1658 */       while (resultSet.next()) {
/* 1659 */         this.jComboBox1.addItem(resultSet.getString(1));
/*      */       }
/* 1661 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1663 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void Iinvoice2()
/*      */   {
/* 1669 */     double cvat = Double.parseDouble(this.tvat);
/* 1670 */     double ctotal = Double.parseDouble(this.cprice);
/* 1671 */     double total = 0.0D;
/* 1672 */     if (cvat > 0.0D) {
/* 1673 */       total = (1.0D - cvat) * Double.parseDouble(this.jComboBox2.getSelectedItem().toString());
/*      */     }
/*      */     else {
/* 1676 */       total = Double.parseDouble(this.jComboBox2.getSelectedItem().toString());
/*      */     }
/* 1678 */     double atotal = Double.parseDouble(this.jComboBox2.getSelectedItem().toString());
/* 1679 */     double now = Double.parseDouble(this.quant);
/* 1680 */     double cquan = Double.parseDouble(this.quantity.getText());
/* 1681 */     double tvat2 = Double.parseDouble(this.vat.getText());
/* 1682 */     double ftotal = total * cquan;
/* 1683 */     double tt = Double.parseDouble(this.sub.getText());
/*      */ 
/* 1685 */     double newsub = tt + ftotal - (now * ctotal - Double.parseDouble(this.vatn));
/*      */ 
/* 1687 */     String stotal = String.valueOf(ftotal);
/* 1688 */     double fvat = atotal * cvat * cquan;
/* 1689 */     double vatdis = fvat + (tvat2 - Double.parseDouble(this.vatn));
/* 1690 */     System.out.println(tvat2 + " " + fvat + " both " + this.vatn);
/* 1691 */     double distotal = vatdis + newsub;
/* 1692 */     String svat = String.valueOf(fvat);
/*      */ 
/* 1694 */     BigDecimal bd = new BigDecimal(vatdis);
/* 1695 */     bd = bd.setScale(2, 4);
/*      */ 
/* 1697 */     BigDecimal bd1 = new BigDecimal(newsub);
/* 1698 */     bd1 = bd1.setScale(2, 4);
/*      */ 
/* 1700 */     BigDecimal bd2 = new BigDecimal(distotal);
/* 1701 */     bd2 = bd2.setScale(2, 4);
/* 1702 */     this.vat.setText(String.valueOf(bd));
/* 1703 */     this.sub.setText(String.valueOf(bd1));
/* 1704 */     this.tot.setText(String.valueOf(bd2));
/* 1705 */     String codeval = "1";
/*      */     try
/*      */     {
/* 1708 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 1709 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1710 */       String sql = "INSERT INTO invoice values(?,?,?,?,?,?,?,?,?)";
/* 1711 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 1713 */       stmt.setString(1, this.invoiceno.getText());
/* 1714 */       stmt.setString(2, this.code.getText());
/* 1715 */       stmt.setString(3, this.item);
/* 1716 */       stmt.setString(4, this.des);
/* 1717 */       stmt.setString(7, stotal);
/* 1718 */       stmt.setString(8, svat);
/* 1719 */       stmt.setString(5, this.quantity.getText());
/* 1720 */       stmt.setString(6, this.jComboBox2.getSelectedItem().toString());
/* 1721 */       stmt.setString(9, codeval);
/*      */ 
/* 1733 */       int u = stmt.executeUpdate();
/* 1734 */       if (u > 0)
/*      */       {
/* 1736 */         update();
/* 1737 */         update_table();
/*      */ 
/* 1739 */         this.jLabel1.setVisible(false);
/*      */ 
/* 1741 */         this.quantity.setText("");
/*      */       }
/*      */     }
/*      */     catch (Exception exc)
/*      */     {
/* 1746 */       exc.printStackTrace();
/* 1747 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void Iinvoice()
/*      */   {
/* 1754 */     double cvat = Double.parseDouble(this.tvat);
/* 1755 */     double total = 0.0D;
/* 1756 */     if (cvat > 0.0D) {
/* 1757 */       total = (1.0D - cvat) * Double.parseDouble(this.jComboBox2.getSelectedItem().toString());
/*      */     }
/*      */     else {
/* 1760 */       total = Double.parseDouble(this.jComboBox2.getSelectedItem().toString());
/*      */     }
/*      */ 
/* 1763 */     double atotal = Double.parseDouble(this.jComboBox2.getSelectedItem().toString());
/* 1764 */     double cquan = Double.parseDouble(this.quantity.getText());
/* 1765 */     double tvat2 = Double.parseDouble(this.vat.getText());
/* 1766 */     double ftotal = total * cquan;
/* 1767 */     double tt = Double.parseDouble(this.sub.getText());
/*      */ 
/* 1769 */     double newsub = tt + ftotal;
/* 1770 */     System.out.println(tt + " " + ftotal + " both" + total);
/* 1771 */     String stotal = String.valueOf(ftotal);
/* 1772 */     double fvat = atotal * cvat * cquan;
/* 1773 */     double vatdis = tvat2 + fvat;
/* 1774 */     double distotal = vatdis + newsub;
/* 1775 */     String svat = String.valueOf(fvat);
/*      */ 
/* 1777 */     BigDecimal bd = new BigDecimal(vatdis);
/* 1778 */     bd = bd.setScale(2, 4);
/*      */ 
/* 1780 */     BigDecimal bd1 = new BigDecimal(newsub);
/* 1781 */     bd1 = bd1.setScale(2, 4);
/*      */ 
/* 1783 */     BigDecimal bd2 = new BigDecimal(distotal);
/* 1784 */     bd2 = bd2.setScale(2, 4);
/*      */ 
/* 1786 */     this.vat.setText(String.valueOf(bd));
/* 1787 */     this.sub.setText(String.valueOf(bd1));
/* 1788 */     this.tot.setText(String.valueOf(bd2));
/*      */     try
/*      */     {
/* 1792 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 1793 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1794 */       String sql = "INSERT INTO invoice values(?,?,?,?,?,?,?,?,?)";
/* 1795 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 1797 */       stmt.setString(1, this.invoiceno.getText());
/* 1798 */       stmt.setString(2, this.code.getText());
/* 1799 */       stmt.setString(3, this.item);
/* 1800 */       stmt.setString(4, this.des);
/* 1801 */       stmt.setString(7, stotal);
/* 1802 */       stmt.setString(8, svat);
/* 1803 */       stmt.setString(5, this.quantity.getText());
/* 1804 */       stmt.setString(6, this.jComboBox2.getSelectedItem().toString());
/* 1805 */       stmt.setString(9, String.valueOf("1"));
/* 1806 */       searchq();
/* 1807 */       subtract();
/*      */ 
/* 1815 */       int u = stmt.executeUpdate();
/* 1816 */       if (u > 0)
/*      */       {
/* 1818 */         update();
/* 1819 */         update_table();
/*      */ 
/* 1821 */         this.jLabel1.setVisible(false);
/*      */ 
/* 1823 */         this.quantity.setText("");
/*      */       }
/*      */     }
/*      */     catch (Exception exc)
/*      */     {
/* 1828 */       exc.printStackTrace();
/* 1829 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void fill2(String name)
/*      */   {
/*      */     try
/*      */     {
/* 1837 */       this.nat.setText("");
/* 1838 */       Class.forName("com.mysql.jdbc.Driver");
/* 1839 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1840 */       String sql = "SELECT idno FROM customer  where name='" + name + "'";
/* 1841 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1842 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/* 1844 */       while (resultSet.next()) {
/* 1845 */         this.nat.setText(resultSet.getString(1));
/*      */       }
/* 1847 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1849 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void searchid(String id)
/*      */   {
/* 1859 */     this.jComboBox1.setSelectedItem("customer");
/*      */     try {
/* 1861 */       Class.forName("com.mysql.jdbc.Driver");
/* 1862 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1863 */       String sql = "SELECT name FROM customer where idno='" + id + "'";
/* 1864 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 1865 */       ResultSet resultSet = stmt.executeQuery();
/* 1866 */       while (resultSet.next()) {
/* 1867 */         this.jComboBox1.setSelectedItem(resultSet.getString(1));
/*      */       }
/* 1869 */       conn.close();
/*      */     } catch (Exception exc) {
/* 1871 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void insertsales()
/*      */   {
/* 1878 */     Calendar currentdate = Calendar.getInstance();
/* 1879 */     SimpleDateFormat n = new SimpleDateFormat("yyyy-MM-dd");
/* 1880 */     String ddate = n.format(currentdate.getTime());
/*      */ 
/* 1882 */     int u = searchsales();
/*      */ 
/* 1884 */     if (u == 0) { int t;
/*      */       try { Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 1887 */         java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1888 */         String sql = "INSERT INTO sales values(?,?,?,?)";
/* 1889 */         java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 1891 */         stmt.setString(2, this.invoiceno.getText());
/* 1892 */         stmt.setString(1, (String)this.jComboBox1.getSelectedItem());
/* 1893 */         stmt.setString(3, ddate);
/* 1894 */         stmt.setString(4, this.tot.getText());
/*      */ 
/* 1897 */         t = stmt.executeUpdate();
/*      */       } catch (Exception ex)
/*      */       {
/*      */       }
/* 1901 */     } else if (u >= 1) {
/*      */       int t;
/*      */       try { String ss = this.tot.getText();
/* 1905 */         Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 1906 */         java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1907 */         String sql = "update sales set amt='" + ss + "' where invoiceno='" + this.invoiceno.getText() + "' ";
/* 1908 */         java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 1910 */         t = stmt.executeUpdate();
/*      */       }
/*      */       catch (Exception ex)
/*      */       {
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public void insertdebtors()
/*      */   {
/* 1920 */     Calendar currentdate = Calendar.getInstance();
/* 1921 */     SimpleDateFormat n = new SimpleDateFormat("yyyy-MM-dd");
/* 1922 */     String ddate = n.format(currentdate.getTime());
/*      */ 
/* 1924 */     int u = searchdebtors();
/*      */ 
/* 1926 */     if (u == 0) { int t;
/*      */       try { Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 1929 */         java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1930 */         String sql = "INSERT INTO debtors values(?,?,?,?,?)";
/* 1931 */         java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 1933 */         stmt.setString(2, this.invoiceno.getText());
/* 1934 */         stmt.setString(1, (String)this.jComboBox1.getSelectedItem());
/* 1935 */         stmt.setString(3, this.paid.getText());
/* 1936 */         stmt.setString(5, ddate);
/* 1937 */         stmt.setString(4, this.tot.getText());
/*      */ 
/* 1940 */         t = stmt.executeUpdate();
/*      */       } catch (Exception ex)
/*      */       {
/*      */       }
/* 1944 */     } else if (u <= 1) {
/*      */       int t;
/*      */       try { String ss = this.tot.getText();
/* 1948 */         Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 1949 */         java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 1950 */         String sql = "update debtors set total='" + ss + "', amtpaid='" + this.paid.getText() + "' where invoiceno='" + this.invoiceno.getText() + "' ";
/* 1951 */         java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 1953 */         t = stmt.executeUpdate();
/*      */       } catch (Exception ex)
/*      */       {
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public int searchdebtors() {
/* 1961 */     String inv = this.invoiceno.getText();
/* 1962 */     int i = 0;
/*      */     try
/*      */     {
/* 1965 */       Class.forName("com.mysql.jdbc.Driver");
/* 1966 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*      */ 
/* 1968 */       String str = "select * from debtors where invoiceno='" + inv + "'";
/* 1969 */       java.sql.PreparedStatement stmt = conn.prepareStatement(str);
/* 1970 */       ResultSet rs = stmt.executeQuery();
/* 1971 */       while (rs.next())
/*      */       {
/* 1973 */         i = 1;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */     }
/*      */ 
/* 1981 */     return i;
/*      */   }
/*      */ 
/*      */   public void insertdet() {
/* 1985 */     String inv = this.invoiceno.getText();
/* 1986 */     String cusq = (String)this.jComboBox1.getSelectedItem();
/* 1987 */     String str = "INSERT INTO invoicedetails values('" + inv + "','" + cusq + "','" + this.paid.getText() + "','" + this.due + "') ";
/*      */     try
/*      */     {
/* 1995 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 1997 */       Statement st = cn.createStatement();
/* 1998 */       int i = st.executeUpdate(str);
/*      */ 
/* 2001 */       st = cn.createStatement();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public int searchsales()
/*      */   {
/* 2011 */     String inv = this.invoiceno.getText();
/* 2012 */     int i = 0;
/*      */     try
/*      */     {
/* 2015 */       Class.forName("com.mysql.jdbc.Driver");
/* 2016 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*      */ 
/* 2018 */       String str = "select * from sales where invoiceno='" + inv + "'";
/* 2019 */       java.sql.PreparedStatement stmt = conn.prepareStatement(str);
/* 2020 */       ResultSet rs = stmt.executeQuery();
/* 2021 */       while (rs.next())
/*      */       {
/* 2023 */         i = 1;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */     }
/*      */ 
/* 2031 */     return i;
/*      */   }
/*      */ 
/*      */   public void truncdetails()
/*      */   {
/* 2036 */     String str = "truncate table invoicedetails";
/*      */     try
/*      */     {
/* 2044 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 2046 */       Statement st = cn.createStatement();
/* 2047 */       int i = st.executeUpdate(str);
/*      */ 
/* 2050 */       st = cn.createStatement();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public void intial()
/*      */   {
/*      */     try
/*      */     {
/* 2062 */       Class.forName("com.mysql.jdbc.Driver");
/* 2063 */       String user = "root";
/* 2064 */       String pass = "this";
/* 2065 */       String url = "jdbc:mysql://localhost:3306/inventory";
/* 2066 */       String sql = "delete from debtors where not exists (select invoiceno from invoice where invoiceno=invoiceno)";
/* 2067 */       com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, user, pass);
/* 2068 */       com.mysql.jdbc.PreparedStatement stms = (com.mysql.jdbc.PreparedStatement)conn.prepareStatement(sql);
/* 2069 */       int s = stms.executeUpdate();
/* 2070 */       if (s > 0)
/* 2071 */         JOptionPane.showMessageDialog(this.jPanel1, "updated", "Successfull", 1);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 2075 */       System.out.println(ex);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void intial2()
/*      */   {
/*      */     try {
/* 2082 */       Class.forName("com.mysql.jdbc.Driver");
/* 2083 */       String user = "root";
/* 2084 */       String pass = "this";
/* 2085 */       String url = "jdbc:mysql://localhost:3306/inventory";
/* 2086 */       String sql = "delete from sales where not exists (select invoiceno from invoice where invoiceno=invoiceno)";
/* 2087 */       com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, user, pass);
/* 2088 */       com.mysql.jdbc.PreparedStatement stms = (com.mysql.jdbc.PreparedStatement)conn.prepareStatement(sql);
/* 2089 */       int s = stms.executeUpdate();
/* 2090 */       if (s > 0)
/* 2091 */         JOptionPane.showMessageDialog(this.jPanel1, "updated", "Successfull", 1);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 2095 */       System.out.println(ex);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void add() {
/* 2099 */     this.sub.setText("");
/*      */     try {
/* 2101 */       Class.forName("com.mysql.jdbc.Driver");
/* 2102 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2103 */       String sql = "SELECT round( sum( subtotal) , 2 )FROM invoice where invoiceno='" + this.invoiceno.getText() + "'";
/* 2104 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2105 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/* 2107 */       while (resultSet.next())
/* 2108 */         this.sub.setText(resultSet.getString(1));
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 2112 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void add2() {
/* 2117 */     this.vat.setText("0.00");
/*      */     try
/*      */     {
/* 2120 */       Class.forName("com.mysql.jdbc.Driver");
/* 2121 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2122 */       String sql = "SELECT round( sum( vat) , 2 )FROM invoice where invoiceno='" + this.invoiceno.getText() + "'";
/* 2123 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2124 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/* 2126 */       while (resultSet.next())
/*      */       {
/* 2128 */         this.vat.setText(resultSet.getString(1));
/*      */       }
/*      */     } catch (Exception ex) {
/* 2131 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void total() {
/* 2136 */     this.tot.setText("0.00");
/*      */     try {
/* 2138 */       Double addvat = Double.valueOf(Double.parseDouble(this.vat.getText()));
/* 2139 */       Double addsub = Double.valueOf(Double.parseDouble(this.sub.getText()));
/* 2140 */       Double finalval = Double.valueOf(addvat.doubleValue() + addsub.doubleValue());
/* 2141 */       this.tot.setText(String.valueOf(finalval));
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public void paidamt(String amtpaid)
/*      */   {
/* 2154 */     this.paid.setText(amtpaid);
/*      */   }
/*      */ 
/*      */   public void search() {
/* 2158 */     this.jComboBox2.removeAllItems();
/*      */ 
/* 2160 */     this.jLabel1.setVisible(false);
/* 2161 */     String tcode = this.code.getText();
/*      */     try {
/* 2163 */       Class.forName("com.mysql.jdbc.Driver");
/* 2164 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2165 */       String sql = "SELECT name,description,quantity,vat,price,type FROM stock where Itemcode='" + tcode + "'";
/* 2166 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2167 */       ResultSet resultSet = stmt.executeQuery();
/* 2168 */       while (resultSet.next())
/*      */       {
/* 2170 */         this.item = resultSet.getString("name");
/* 2171 */         this.des = resultSet.getString("description");
/* 2172 */         this.quan = resultSet.getString("quantity");
/* 2173 */         this.type = resultSet.getInt("type");
/*      */ 
/* 2175 */         this.jComboBox2.addItem(resultSet.getString("price"));
/* 2176 */         this.tvat = resultSet.getString("vat");
/* 2177 */         this.jLabel1.setVisible(true);
/*      */       }
/*      */ 
/* 2180 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2182 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void addition2()
/*      */   {
/* 2191 */     double adder = Double.parseDouble(this.quant);
/* 2192 */     double before = Double.parseDouble(this.cquan2);
/* 2193 */     double now = Double.parseDouble(this.quantity.getText());
/* 2194 */     double both = before + adder - now;
/* 2195 */     String finaltosave = String.valueOf(both);
/*      */     try
/*      */     {
/* 2199 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 2200 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2201 */       String sql = "update stock set quantity='" + finaltosave + "' where Itemcode='" + this.coded + "' && type=0";
/* 2202 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 2205 */       int u = stmt.executeUpdate();
/* 2206 */       if (u > 0)
/*      */       {
/* 2208 */         System.out.println("done");
/*      */       }
/*      */     } catch (Exception ex) {
/* 2211 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */   public void calc() {
/* 2214 */     double c = 0.0D;
/*      */     try
/*      */     {
/* 2217 */       double d = Double.parseDouble(this.tot.getText());
/* 2218 */       double p = Double.parseDouble(this.paid.getText());
/* 2219 */       if (p < d) {
/* 2220 */         this.paid.setText(String.valueOf(p));
/* 2221 */         c = 0.0D;
/* 2222 */         this.ch.setText(String.valueOf(c));
/*      */       }
/* 2224 */       else if (d == p) {
/* 2225 */         this.paid.setText(String.valueOf(p));
/* 2226 */         c = 0.0D;
/* 2227 */         this.ch.setText(String.valueOf(c));
/*      */       }
/* 2229 */       else if (p > d) {
/* 2230 */         double f = p - d;
/* 2231 */         this.paid.setText(String.valueOf(d));
/*      */ 
/* 2233 */         c = f;
/* 2234 */         this.ch.setText(String.valueOf(c));
/*      */       }
/* 2236 */       this.due = ((p - d) * -1.0D);
/* 2237 */       insertsales();
/* 2238 */       insertdebtors();
/* 2239 */       invoicepopup f = new invoicepopup(new JFrame(), true);
/* 2240 */       f.fill(String.valueOf(c));
/* 2241 */       f.setVisible(true);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 2245 */       this.paid.setText("");
/* 2246 */       this.paid.requestFocus();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void truncinvoice()
/*      */   {
/* 2252 */     String str = "truncate table invoiceholder";
/*      */     try
/*      */     {
/* 2260 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 2262 */       Statement st = cn.createStatement();
/* 2263 */       int i = st.executeUpdate(str);
/*      */ 
/* 2266 */       st = cn.createStatement();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public void subtract() {
/* 2274 */     this.cquant = this.quantity.getText();
/* 2275 */     double adder = Double.parseDouble(this.cquant);
/* 2276 */     double before = Double.parseDouble(this.cquan2);
/* 2277 */     double both = before - adder;
/* 2278 */     String finaltosave = String.valueOf(both);
/* 2279 */     String thcode = this.code.getText();
/*      */     try
/*      */     {
/* 2282 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 2283 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2284 */       String sql = "update stock set quantity='" + finaltosave + "' where Itemcode='" + thcode + "' && type=0";
/* 2285 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 2288 */       int u = stmt.executeUpdate();
/* 2289 */       if (u > 0)
/*      */       {
/* 2291 */         System.out.println("done");
/*      */       }
/*      */     } catch (Exception ex) {
/* 2294 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void subtract2() {
/* 2298 */     double adder = Double.parseDouble(this.cquant);
/* 2299 */     double before = Double.parseDouble(this.cquan2);
/* 2300 */     double both = before + adder;
/* 2301 */     String finaltosave = String.valueOf(both);
/*      */     try
/*      */     {
/* 2305 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 2306 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2307 */       String sql = "update stock set quantity='" + finaltosave + "' where Itemcode='" + this.coded + "' && type=0";
/* 2308 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 2311 */       int u = stmt.executeUpdate();
/* 2312 */       if (u > 0)
/*      */       {
/* 2314 */         System.out.println("done");
/*      */       }
/*      */     } catch (Exception ex) {
/* 2317 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */   public void searchq() {
/*      */     try {
/* 2321 */       String find = this.code.getText();
/* 2322 */       System.out.println(find);
/* 2323 */       Class.forName("com.mysql.jdbc.Driver");
/* 2324 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2325 */       String sql = "SELECT * FROM stock where Itemcode='" + find + "'";
/* 2326 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2327 */       ResultSet resultSet = stmt.executeQuery();
/* 2328 */       while (resultSet.next()) {
/* 2329 */         this.cquan2 = resultSet.getString("quantity");
/*      */ 
/* 2331 */         System.out.println(this.cquan2 + "result");
/*      */       }
/* 2333 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2335 */       exc.printStackTrace();
/* 2336 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void sold()
/*      */   {
/* 2347 */     String d = "1";
/*      */     try {
/* 2349 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 2350 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2351 */       String sql = "update invoice set sold='" + d + "' where invoiceno='" + this.invoiceno.getText() + "'";
/* 2352 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/* 2355 */       int u = stmt.executeUpdate();
/* 2356 */       if (u > 0)
/*      */       {
/* 2358 */         System.out.println("done");
/*      */       }
/*      */     } catch (Exception ex) {
/* 2361 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void setselec(String nam)
/*      */   {
/* 2368 */     this.jComboBox1.setSelectedItem(nam);
/* 2369 */     fill2(nam);
/*      */   }
/*      */ 
/*      */   public void delete2()
/*      */   {
/*      */     try
/*      */     {
/* 2376 */       Class.forName("com.mysql.jdbc.Driver");
/* 2377 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2378 */       String sql = "DELETE FROM debtors where date='" + this.dat.getText() + "' && invoiceno='" + this.invoiceno.getText() + "'";
/* 2379 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2380 */       int r = stmt.executeUpdate();
/*      */ 
/* 2383 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2385 */       exc.printStackTrace();
/* 2386 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void delete3()
/*      */   {
/*      */     try
/*      */     {
/* 2397 */       Class.forName("com.mysql.jdbc.Driver");
/* 2398 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2399 */       String sql = "DELETE FROM sales where date='" + this.dat.getText() + "' && invoiceno='" + this.invoiceno.getText() + "'";
/* 2400 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2401 */       int r = stmt.executeUpdate();
/*      */ 
/* 2404 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2406 */       exc.printStackTrace();
/* 2407 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void stockUpdate()
/*      */   {
/* 2416 */     if (this.purchased != null)
/* 2417 */       for (int i = 0; i < this.purchased.length; i++) {
/* 2418 */         for (int y = 0; y < 6; y++)
/*      */         {
/* 2422 */           if (y == 0) {
/* 2423 */             this.coded = this.purchased[i][y];
/* 2424 */             searchq2(this.coded);
/*      */           }
/* 2427 */           else if (y == 3) {
/* 2428 */             this.cquant = this.purchased[i][y];
/* 2429 */             System.out.println(this.cquant);
/*      */           }
/*      */ 
/* 2434 */           System.out.println(this.cquant + "fff");
/*      */         }
/*      */ 
/* 2437 */         subtract2();
/*      */       }
/*      */   }
/*      */ 
/*      */   public void getDetails()
/*      */   {
/*      */   }
/*      */ 
/*      */   public void getamt(String find)
/*      */   {
/*      */     try
/*      */     {
/* 2452 */       System.out.println(find + "    isssssssssssssssssssssssssssssss");
/* 2453 */       Class.forName("com.mysql.jdbc.Driver");
/* 2454 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2455 */       String sql = "SELECT total FROM debtors where invoiceno='" + find + "'";
/* 2456 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2457 */       ResultSet resultSet = stmt.executeQuery();
/* 2458 */       while (resultSet.next()) {
/* 2459 */         this.deb = resultSet.getString(1);
/*      */       }
/*      */ 
/* 2463 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2465 */       exc.printStackTrace();
/* 2466 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void getsales(String find)
/*      */   {
/*      */     try
/*      */     {
/* 2480 */       Class.forName("com.mysql.jdbc.Driver");
/* 2481 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2482 */       String sql = "SELECT amt FROM sales where invoiceno='" + find + "'";
/* 2483 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2484 */       ResultSet resultSet = stmt.executeQuery();
/* 2485 */       while (resultSet.next()) {
/* 2486 */         this.sale = resultSet.getString(1);
/*      */       }
/*      */ 
/* 2490 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2492 */       exc.printStackTrace();
/* 2493 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatedeb(String find)
/*      */   {
/* 2505 */     String paidamt = this.paid.getText();
/*      */ 
/* 2507 */     String finalsave = this.tot.getText();
/* 2508 */     System.out.println(finalsave + "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
/*      */     try
/*      */     {
/* 2512 */       Class.forName("com.mysql.jdbc.Driver");
/* 2513 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2514 */       String sql = "update debtors set total='" + finalsave + "', amtpaid='" + paidamt + "' where invoiceno='" + find + "'";
/* 2515 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2516 */       int y = stmt.executeUpdate();
/* 2517 */       if (y > 0) {
/* 2518 */         JOptionPane.showMessageDialog(null, "done", "Success!!", 1);
/*      */       }
/*      */ 
/* 2521 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2523 */       exc.printStackTrace();
/* 2524 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatesale(String find)
/*      */   {
/* 2532 */     double amtsold = Double.parseDouble(this.sale);
/*      */ 
/* 2534 */     String finalsave = this.tot.getText();
/*      */     try
/*      */     {
/* 2538 */       Class.forName("com.mysql.jdbc.Driver");
/* 2539 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2540 */       String sql = "update sales set amt='" + finalsave + "' where invoiceno='" + find + "'";
/* 2541 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2542 */       int y = stmt.executeUpdate();
/*      */ 
/* 2544 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2546 */       exc.printStackTrace();
/* 2547 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatesalet()
/*      */   {
/*      */     try
/*      */     {
/* 2563 */       Class.forName("com.mysql.jdbc.Driver");
/* 2564 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2565 */       String sql = "delete from debtors where total<='0'";
/* 2566 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2567 */       int y = stmt.executeUpdate();
/*      */ 
/* 2569 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2571 */       exc.printStackTrace();
/* 2572 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updateinv()
/*      */   {
/*      */     try
/*      */     {
/* 2588 */       Class.forName("com.mysql.jdbc.Driver");
/* 2589 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2590 */       String sql = "delete from invoice where sold='0'";
/* 2591 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2592 */       int y = stmt.executeUpdate();
/*      */ 
/* 2594 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2596 */       exc.printStackTrace();
/* 2597 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatedebt()
/*      */   {
/*      */     try
/*      */     {
/* 2611 */       Class.forName("com.mysql.jdbc.Driver");
/* 2612 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2613 */       String sql = "delete from sales where amt<='0'";
/* 2614 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2615 */       int y = stmt.executeUpdate();
/*      */ 
/* 2617 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2619 */       exc.printStackTrace();
/* 2620 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public Double frominv(String find, String code)
/*      */   {
/* 2633 */     double ret = 0.0D;
/* 2634 */     String sub = "";
/* 2635 */     String vat = "";
/*      */     try
/*      */     {
/* 2639 */       Class.forName("com.mysql.jdbc.Driver");
/* 2640 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2641 */       String sql = "SELECT subtotal,vat FROM invoice where invoiceno='" + find + "'&& Itemcode='" + code + "'";
/* 2642 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2643 */       ResultSet resultSet = stmt.executeQuery();
/* 2644 */       while (resultSet.next()) {
/* 2645 */         sub = resultSet.getString(1);
/* 2646 */         vat = resultSet.getString(2);
/*      */ 
/* 2648 */         ret = Double.parseDouble(sub) + Double.parseDouble(vat);
/*      */       }
/* 2650 */       conn.close();
/*      */     }
/*      */     catch (Exception exc) {
/* 2653 */       exc.printStackTrace();
/* 2654 */       System.out.println("process error" + exc);
/*      */     }
/*      */ 
/* 2659 */     return Double.valueOf(ret);
/*      */   }
/*      */ 
/*      */   public String[] codsearch(String namego) {
/* 2663 */     String tsearch = this.invoiceno.getText();
/*      */     try
/*      */     {
/* 2667 */       String find = this.code.getText();
/* 2668 */       System.out.println(find);
/* 2669 */       Class.forName("com.mysql.jdbc.Driver");
/* 2670 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2671 */       String sql = "SELECT Itemcode FROM stock where name like '%" + namego + "%'";
/* 2672 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2673 */       ResultSet resultSet = stmt.executeQuery();
/* 2674 */       if (resultSet.next()) {
/* 2675 */         resultSet.last();
/* 2676 */         this.cate = new String[resultSet.getRow()];
/* 2677 */         resultSet.beforeFirst();
/*      */       }
/* 2679 */       int row = 0;
/* 2680 */       while (resultSet.next())
/*      */       {
/* 2683 */         this.cate[row] = resultSet.getString(1);
/*      */ 
/* 2686 */         row++;
/*      */       }
/* 2688 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2690 */       exc.printStackTrace();
/* 2691 */       System.out.println("process error" + exc);
/*      */     }
/*      */ 
/* 2696 */     return this.cate;
/*      */   }
/*      */ 
/*      */   public void fillcat2search(String name)
/*      */   {
/*      */     try
/*      */     {
/* 2703 */       String find = this.code.getText();
/* 2704 */       System.out.println(find);
/* 2705 */       Class.forName("com.mysql.jdbc.Driver");
/* 2706 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2707 */       String sql = "SELECT Itemcode as 'CODE',name as 'NAME',description as 'DESCRIPTION',quantity as 'QUANTITY' FROM stock WHERE name like '%" + name + "%'";
/* 2708 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2709 */       ResultSet resultSet = stmt.executeQuery();
/*      */ 
/* 2711 */       this.tablecategory.setModel(DbUtils.resultSetToTableModel(resultSet));
/* 2712 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2714 */       exc.printStackTrace();
/* 2715 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public int checkInvoice()
/*      */   {
/* 2722 */     int x = 0;
/*      */     try
/*      */     {
/* 2727 */       Class.forName("com.mysql.jdbc.Driver");
/* 2728 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2729 */       String sql = "select * from invoice where invoiceno='" + this.invoiceno.getText() + "' && Itemcode='" + this.code.getText() + "'";
/* 2730 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2731 */       ResultSet rs = stmt.executeQuery();
/* 2732 */       while (rs.next()) {
/* 2733 */         x = 1;
/*      */       }
/*      */ 
/* 2737 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2739 */       exc.printStackTrace();
/* 2740 */       System.out.println("process error" + exc);
/*      */     }
/*      */ 
/* 2744 */     return x;
/*      */   }
/*      */   public int checkReorder(String cod) {
/* 2747 */     int x = 0;
/*      */     try
/*      */     {
/* 2752 */       Class.forName("com.mysql.jdbc.Driver");
/* 2753 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2754 */       String sql = "select * from stock where Itemcode='" + cod + "' && reorder_level>=quantity && type=0";
/* 2755 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2756 */       ResultSet rs = stmt.executeQuery();
/* 2757 */       while (rs.next()) {
/* 2758 */         x = 1;
/* 2759 */         System.err.println(x);
/*      */       }
/*      */ 
/* 2762 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2764 */       exc.printStackTrace();
/* 2765 */       System.out.println("process error" + exc);
/*      */     }
/*      */ 
/* 2769 */     return x;
/*      */   }
/*      */   public double BuyingPrice(String itemcode) {
/* 2772 */     double xy = 0.0D;
/*      */     try
/*      */     {
/* 2777 */       Class.forName("com.mysql.jdbc.Driver");
/* 2778 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 2779 */       String sql = "select buyingprice,vat from stock where Itemcode='" + itemcode + "'";
/* 2780 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 2781 */       ResultSet rs = stmt.executeQuery();
/* 2782 */       while (rs.next()) {
/* 2783 */         xy = rs.getDouble(1) + rs.getDouble(1) * rs.getDouble(2);
/*      */       }
/*      */ 
/* 2787 */       conn.close();
/*      */     } catch (Exception exc) {
/* 2789 */       exc.printStackTrace();
/* 2790 */       System.out.println("process error" + exc);
/*      */     }
/*      */ 
/* 2794 */     return xy;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*      */     try
/*      */     {
/* 2809 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 2810 */         if ("Windows".equals(info.getName())) {
/* 2811 */           UIManager.setLookAndFeel(info.getClassName());
/* 2812 */           break;
/*      */         }
/*      */     }
/*      */     catch (ClassNotFoundException ex) {
/* 2816 */       Logger.getLogger(invoice2.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (InstantiationException ex) {
/* 2818 */       Logger.getLogger(invoice2.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (IllegalAccessException ex) {
/* 2820 */       Logger.getLogger(invoice2.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (UnsupportedLookAndFeelException ex) {
/* 2822 */       Logger.getLogger(invoice2.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/*      */ 
/* 2829 */     EventQueue.invokeLater(new Runnable()
/*      */     {
/*      */       public void run() {
/* 2832 */         invoice2 dialog = new invoice2(new JFrame(), true) {};
/* 2833 */         dialog.addWindowListener(new WindowAdapter()
/*      */         {
/*      */           public void windowClosing(WindowEvent e)
/*      */           {
/* 2837 */             System.exit(0);
/*      */           }
/*      */         });
/* 2840 */         dialog.setVisible(true);
/*      */       }
/*      */     });
/*      */   }
/*      */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.invoice2
 * JD-Core Version:    0.6.0
 */