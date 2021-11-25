/*      */ package inventory;
/*      */ 
/*      */ import com.toedter.calendar.JCalendar;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Container;
/*      */ import java.awt.EventQueue;
/*      */ import java.awt.Frame;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.WindowAdapter;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.DriverManager;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Statement;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ import javax.swing.UIManager;
/*      */ import javax.swing.UIManager.LookAndFeelInfo;
/*      */ import javax.swing.UnsupportedLookAndFeelException;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.TableModel;
/*      */ import net.proteanit.sql.DbUtils;
/*      */ 
/*      */ public class invoicelist extends JFrame
/*      */ {
/*   25 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*   26 */   static String username = "root";
/*   27 */   static String password = "this";
/*      */   JTable table;
/*      */   String nam;
/*      */   String invoice;
/*      */   String dat;
/*      */   String deb;
/*      */   String coded;
/*      */   String cquant;
/*      */   TableModel model;
/*   35 */   String[][] data = (String[][])null;
/*   36 */   String[][] sample = (String[][])null;
/*   37 */   String[][] mine = (String[][])null;
/*   38 */   String[][] purchased = (String[][])null;
/*      */   String cquan2;
/*      */   String sale;
/*      */   private JButton jButton1;
/*      */   private JButton jButton2;
/*      */   private JCalendar jCalendar1;
/*      */   private JDateChooser jDateChooser1;
/*      */   private JDateChooser jDateChooser2;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel2;
/*      */   private JLabel jLabel3;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JTextField name;
/*      */ 
/*      */   public invoicelist(Frame parent, boolean modal)
/*      */   {
/*   44 */     super(null, null);
/*   45 */     initComponents();
/*   46 */     setLocationRelativeTo(null);
/*   47 */     setDefaultCloseOperation(2);
/*   48 */     table();
/*   49 */     setResizable(false);
/*   50 */     update();
/*   51 */     this.data = getData();
/*   52 */     setTitle("INVOICES");
/*   53 */     update2();
/*   54 */     stockUpdate();
/*   55 */     intial();
/*   56 */     intial2();
/*      */   }
/*      */ 
/*      */   private void initComponents()
/*      */   {
/*   69 */     this.jCalendar1 = new JCalendar();
/*   70 */     this.jPanel1 = new JPanel();
/*   71 */     this.jPanel2 = new JPanel();
/*   72 */     this.jPanel3 = new JPanel();
/*   73 */     this.jButton1 = new JButton();
/*   74 */     this.jDateChooser1 = new JDateChooser();
/*   75 */     this.jDateChooser2 = new JDateChooser();
/*   76 */     this.jLabel1 = new JLabel();
/*   77 */     this.jLabel2 = new JLabel();
/*   78 */     this.jLabel3 = new JLabel();
/*   79 */     this.jButton2 = new JButton();
/*   80 */     this.name = new JTextField();
/*      */ 
/*   82 */     setDefaultCloseOperation(2);
/*      */ 
/*   84 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*      */ 
/*   86 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*      */ 
/*   88 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*   89 */     this.jPanel2.setLayout(jPanel2Layout);
/*   90 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*   91 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   92 */       .addGap(0, 0, 32767));
/*      */ 
/*   94 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*   95 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   96 */       .addGap(0, 25, 32767));
/*      */ 
/*   99 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/*  100 */     this.jPanel3.setBorder(BorderFactory.createBevelBorder(1));
/*      */ 
/*  102 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  103 */     this.jPanel3.setLayout(jPanel3Layout);
/*  104 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  105 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  106 */       .addGap(0, 538, 32767));
/*      */ 
/*  108 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  109 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  110 */       .addGap(0, 229, 32767));
/*      */ 
/*  113 */     this.jButton1.setText("DELETE");
/*  114 */     this.jButton1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  116 */         invoicelist.this.jButton1ActionPerformed(evt);
/*      */       }
/*      */     });
/*  120 */     this.jLabel1.setText("START");
/*      */ 
/*  122 */     this.jLabel2.setText("STOP");
/*      */ 
/*  124 */     this.jLabel3.setText("NAME");
/*      */ 
/*  126 */     this.jButton2.setText("FILTER");
/*  127 */     this.jButton2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  129 */         invoicelist.this.jButton2ActionPerformed(evt);
/*      */       }
/*      */     });
/*  133 */     this.name.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */ 
/*  135 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  136 */     this.jPanel1.setLayout(jPanel1Layout);
/*  137 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  138 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  139 */       .addComponent(this.jPanel2, -1, -1, 32767)
/*  140 */       .addGroup(jPanel1Layout
/*  140 */       .createSequentialGroup()
/*  141 */       .addGroup(jPanel1Layout
/*  141 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  142 */       .addGroup(jPanel1Layout
/*  142 */       .createSequentialGroup()
/*  143 */       .addGap(71, 71, 71)
/*  144 */       .addComponent(this.jButton1))
/*  145 */       .addGroup(jPanel1Layout
/*  145 */       .createSequentialGroup()
/*  146 */       .addGap(20, 20, 20)
/*  147 */       .addGroup(jPanel1Layout
/*  147 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  148 */       .addComponent(this.jPanel3, -2, -1, -2)
/*  149 */       .addGroup(jPanel1Layout
/*  149 */       .createSequentialGroup()
/*  150 */       .addGap(11, 11, 11)
/*  151 */       .addComponent(this.jLabel1)
/*  152 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  153 */       .addComponent(this.jDateChooser1, -2, 113, -2)
/*  154 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  155 */       .addComponent(this.jLabel2)
/*  156 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  157 */       .addComponent(this.jDateChooser2, -2, 127, -2)
/*  158 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  159 */       .addComponent(this.jLabel3)
/*  160 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  161 */       .addComponent(this.name, -1, 116, 32767)
/*  162 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  163 */       .addComponent(this.jButton2)))))
/*  164 */       .addContainerGap()));
/*      */ 
/*  166 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  167 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  168 */       .addGroup(jPanel1Layout
/*  168 */       .createSequentialGroup()
/*  169 */       .addComponent(this.jPanel2, -2, -1, -2)
/*  170 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  171 */       .addGroup(jPanel1Layout
/*  171 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  172 */       .addComponent(this.jDateChooser2, -2, -1, -2)
/*  173 */       .addGroup(jPanel1Layout
/*  173 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  174 */       .addComponent(this.jLabel3)
/*  175 */       .addComponent(this.jButton2)
/*  176 */       .addComponent(this.name, -2, -1, -2))
/*  177 */       .addGroup(jPanel1Layout
/*  177 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  178 */       .addComponent(this.jDateChooser1, -2, -1, -2)
/*  179 */       .addComponent(this.jLabel1)
/*  180 */       .addComponent(this.jLabel2)))
/*  181 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  182 */       .addComponent(this.jPanel3, -2, -1, -2)
/*  183 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  184 */       .addComponent(this.jButton1)
/*  185 */       .addGap(20, 20, 20)));
/*      */ 
/*  188 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  189 */     getContentPane().setLayout(layout);
/*  190 */     layout.setHorizontalGroup(layout
/*  191 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  192 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*      */ 
/*  194 */     layout.setVerticalGroup(layout
/*  195 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  196 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*      */ 
/*  199 */     pack();
/*      */   }
/*      */ 
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  203 */     int y = 0;
/*  204 */     y = JOptionPane.showConfirmDialog(this.jPanel1, "Do Really You Want to delete " + this.nam + " invoice " + this.invoice, "Confirm!", 0);
/*  205 */     if (y == 0)
/*      */     {
/*  207 */       iterate();
/*  208 */       delete(this.invoice, this.dat);
/*  209 */       deletesales(this.invoice, this.dat);
/*  210 */       deletedebtors(this.invoice, this.dat);
/*  211 */       update();
/*  212 */       getData();
/*      */     }
/*      */   }
/*      */ 
/*      */   private void jButton2ActionPerformed(ActionEvent evt)
/*      */   {
/*  218 */     searchitems();
/*      */   }
/*      */ 
/*      */   public void updateinv()
/*      */   {
/*      */     try
/*      */     {
/*  231 */       Class.forName("com.mysql.jdbc.Driver");
/*  232 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  233 */       String sql = "delete from invoice where sold='0'";
/*  234 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  235 */       int y = stmt.executeUpdate();
/*      */ 
/*  237 */       conn.close();
/*      */     } catch (Exception exc) {
/*  239 */       exc.printStackTrace();
/*  240 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void stockUpdate()
/*      */   {
/*  250 */     String inv = null;
/*      */ 
/*  252 */     double subt = 0.0D;
/*  253 */     double vatt = 0.0D;
/*      */ 
/*  255 */     if (this.purchased != null)
/*  256 */       for (int i = 0; i < this.purchased.length; i++) {
/*  257 */         for (int y = 0; y < 7; y++)
/*      */         {
/*  261 */           if (y == 0) {
/*  262 */             this.coded = this.purchased[i][y];
/*  263 */             searchq2(this.coded);
/*      */           }
/*  266 */           else if (y == 3) {
/*  267 */             this.cquant = this.purchased[i][y];
/*  268 */             System.out.println(this.cquant);
/*      */           }
/*  271 */           else if (y == 6) {
/*  272 */             inv = this.purchased[i][y];
/*      */           }
/*  274 */           else if (y == 4) {
/*  275 */             vatt = Double.parseDouble(this.purchased[i][y]);
/*      */           }
/*  277 */           else if (y == 5) {
/*  278 */             subt = Double.parseDouble(this.purchased[i][y]);
/*      */           }
/*      */ 
/*  282 */           System.out.println(this.cquant + "fff");
/*      */         }
/*      */ 
/*  285 */         subtract2();
/*  286 */         getamt(inv);
/*  287 */         getsales(inv);
/*  288 */         updatedeb(String.valueOf(vatt + subt), inv);
/*  289 */         updatesale(String.valueOf(vatt + subt), inv);
/*  290 */         updatedebt();
/*  291 */         updatesalet();
/*  292 */         updateinv();
/*  293 */         intial();
/*      */       }
/*      */   }
/*      */ 
/*      */   public void getamt(String find)
/*      */   {
/*      */     try
/*      */     {
/*  303 */       Class.forName("com.mysql.jdbc.Driver");
/*  304 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  305 */       String sql = "SELECT total FROM debtors where invoiceno='" + find + "'";
/*  306 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  307 */       ResultSet resultSet = stmt.executeQuery();
/*  308 */       while (resultSet.next()) {
/*  309 */         this.deb = resultSet.getString(1);
/*      */ 
/*  311 */         System.out.println(this.cquan2 + "result");
/*      */       }
/*  313 */       conn.close();
/*      */     } catch (Exception exc) {
/*  315 */       exc.printStackTrace();
/*  316 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void getsales(String find)
/*      */   {
/*      */     try
/*      */     {
/*  330 */       Class.forName("com.mysql.jdbc.Driver");
/*  331 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  332 */       String sql = "SELECT amt FROM sales where invoiceno='" + find + "'";
/*  333 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  334 */       ResultSet resultSet = stmt.executeQuery();
/*  335 */       while (resultSet.next()) {
/*  336 */         this.sale = resultSet.getString(1);
/*      */ 
/*  338 */         System.out.println(this.cquan2 + "result");
/*      */       }
/*  340 */       conn.close();
/*      */     } catch (Exception exc) {
/*  342 */       exc.printStackTrace();
/*  343 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatedeb(String curr, String find)
/*      */   {
/*  354 */     double amtsold = Double.parseDouble(this.deb);
/*  355 */     double amtcurr = Double.parseDouble(curr);
/*      */ 
/*  357 */     double finalsave = amtsold + amtcurr;
/*      */     try
/*      */     {
/*  361 */       Class.forName("com.mysql.jdbc.Driver");
/*  362 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  363 */       String sql = "update debtors set total='" + finalsave + "' where invoiceno='" + find + "'";
/*  364 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  365 */       int y = stmt.executeUpdate();
/*      */ 
/*  367 */       conn.close();
/*      */     } catch (Exception exc) {
/*  369 */       exc.printStackTrace();
/*  370 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatesale(String curr, String find)
/*      */   {
/*  378 */     double amtsold = Double.parseDouble(this.sale);
/*  379 */     double amtcurr = Double.parseDouble(curr);
/*  380 */     double finalsave = amtsold + amtcurr;
/*      */     try
/*      */     {
/*  384 */       Class.forName("com.mysql.jdbc.Driver");
/*  385 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  386 */       String sql = "update debtors set total='" + finalsave + "' where invoiceno='" + find + "'";
/*  387 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  388 */       int y = stmt.executeUpdate();
/*      */ 
/*  390 */       conn.close();
/*      */     } catch (Exception exc) {
/*  392 */       exc.printStackTrace();
/*  393 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void subtract2()
/*      */   {
/*  404 */     double adder = Double.parseDouble(this.cquant);
/*  405 */     double before = Double.parseDouble(this.cquan2);
/*  406 */     double both = before + adder;
/*  407 */     String finaltosave = String.valueOf(both);
/*      */     try
/*      */     {
/*  411 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/*  412 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  413 */       String sql = "update stock set quantity='" + finaltosave + "' where Itemcode='" + this.coded + "'";
/*  414 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/*  417 */       int u = stmt.executeUpdate();
/*  418 */       if (u > 0)
/*      */       {
/*  420 */         System.out.println("done");
/*      */       }
/*      */     } catch (Exception ex) {
/*  423 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void searchq2(String find) {
/*      */     try {
/*  428 */       System.out.println(find);
/*  429 */       Class.forName("com.mysql.jdbc.Driver");
/*  430 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  431 */       String sql = "SELECT * FROM stock where Itemcode='" + find + "'";
/*  432 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  433 */       ResultSet resultSet = stmt.executeQuery();
/*  434 */       while (resultSet.next()) {
/*  435 */         this.cquan2 = resultSet.getString("quantity");
/*      */ 
/*  437 */         System.out.println(this.cquan2 + "result");
/*      */       }
/*  439 */       conn.close();
/*      */     } catch (Exception exc) {
/*  441 */       exc.printStackTrace();
/*  442 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatesalet()
/*      */   {
/*      */     try
/*      */     {
/*  458 */       Class.forName("com.mysql.jdbc.Driver");
/*  459 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  460 */       String sql = "delete from debtors where total<='0'";
/*  461 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  462 */       int y = stmt.executeUpdate();
/*      */ 
/*  464 */       conn.close();
/*      */     } catch (Exception exc) {
/*  466 */       exc.printStackTrace();
/*  467 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void updatedebt()
/*      */   {
/*      */     try
/*      */     {
/*  481 */       Class.forName("com.mysql.jdbc.Driver");
/*  482 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  483 */       String sql = "delete from sales where amt<='0'";
/*  484 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  485 */       int y = stmt.executeUpdate();
/*      */ 
/*  487 */       conn.close();
/*      */     } catch (Exception exc) {
/*  489 */       exc.printStackTrace();
/*  490 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void update2()
/*      */   {
/*      */     try
/*      */     {
/*  509 */       Class.forName("com.mysql.jdbc.Driver");
/*  510 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  511 */       String sql = "SELECT * FROM invoice where sold='0'";
/*  512 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  513 */       ResultSet resultSet = stmt.executeQuery();
/*  514 */       if (resultSet.next()) {
/*  515 */         resultSet.last();
/*  516 */         this.purchased = new String[resultSet.getRow()][7];
/*  517 */         resultSet.beforeFirst();
/*      */       }
/*  519 */       int row = 0;
/*  520 */       while (resultSet.next())
/*      */       {
/*  523 */         this.purchased[row][0] = resultSet.getString(2);
/*  524 */         this.purchased[row][1] = resultSet.getString(3);
/*  525 */         this.purchased[row][2] = resultSet.getString(4);
/*  526 */         this.purchased[row][3] = resultSet.getString(5);
/*  527 */         this.purchased[row][4] = resultSet.getString(8);
/*  528 */         this.purchased[row][5] = resultSet.getString(7);
/*  529 */         this.purchased[row][6] = resultSet.getString(1);
/*  530 */         row++;
/*  531 */         System.out.println("hit");
/*      */       }
/*  533 */       conn.close();
/*      */     } catch (Exception exc) {
/*  535 */       exc.printStackTrace();
/*  536 */       System.out.println("process error" + exc);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void table()
/*      */   {
/*  547 */     String[] headers = { "NAME", "INVOICENO", "AMTPAID", "TOTAL", "DATE" };
/*      */ 
/*  552 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/*  553 */     model.fireTableDataChanged();
/*  554 */     this.table = new JTable(model);
/*      */ 
/*  557 */     JScrollPane scrollPane = new JScrollPane(this.table);
/*      */ 
/*  559 */     this.jPanel3.add(scrollPane, "Center");
/*  560 */     scrollPane.setBounds(0, 0, 538, 229);
/*  561 */     this.table.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent e) {
/*  563 */         int row = invoicelist.this.table.getSelectedRow();
/*  564 */         int col = invoicelist.this.table.getSelectedColumn();
/*  565 */         System.out.println(row);
/*  566 */         invoicelist.this.nam = invoicelist.this.data[row][0];
/*  567 */         invoicelist.this.invoice = invoicelist.this.data[row][1];
/*  568 */         String amt = invoicelist.this.data[row][3];
/*  569 */         String amtpaid = invoicelist.this.data[row][2];
/*  570 */         invoicelist.this.dat = invoicelist.this.data[row][4];
/*      */ 
/*  572 */         invoice2 nn = new invoice2(new JFrame(), true);
/*  573 */         nn.invoiceno(invoicelist.this.invoice);
/*  574 */         nn.date(invoicelist.this.dat);
/*  575 */         nn.update();
/*  576 */         nn.update_table();
/*  577 */         nn.setselec(invoicelist.this.nam);
/*  578 */         nn.add();
/*  579 */         nn.add2();
/*  580 */         nn.total();
/*  581 */         nn.paidamt(amtpaid);
/*      */ 
/*  583 */         nn.setVisible(true);
/*      */ 
/*  586 */         invoicelist.this.searchitems();
/*  587 */         invoicelist.this.update();
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public String[][] getData()
/*      */   {
/*  597 */     String str = "SELECT name,invoiceno,amtpaid,total,date from debtors order by date desc";
/*      */     try
/*      */     {
/*  606 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/*  608 */       Statement st = cn.createStatement();
/*      */ 
/*  610 */       ResultSet rs = st.executeQuery(str);
/*      */ 
/*  613 */       if (rs.next()) {
/*  614 */         rs.last();
/*      */ 
/*  616 */         this.sample = new String[rs.getRow()][5];
/*  617 */         rs.beforeFirst();
/*      */       }
/*  619 */       int rowcount = 0;
/*      */ 
/*  621 */       while (rs.next())
/*      */       {
/*  624 */         this.sample[rowcount][0] = rs.getString(1);
/*  625 */         this.sample[rowcount][1] = rs.getString(2);
/*  626 */         this.sample[rowcount][2] = rs.getString(3);
/*  627 */         this.sample[rowcount][3] = rs.getString(4);
/*  628 */         this.sample[rowcount][4] = rs.getString(5);
/*      */ 
/*  636 */         rowcount++;
/*      */       }
/*      */ 
/*  639 */       rs.close();
/*  640 */       cn.close();
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  644 */       e.printStackTrace();
/*      */     }
/*  646 */     return this.sample;
/*      */   }
/*      */ 
/*      */   public void update() {
/*  650 */     String[] headers = { "NAME", "INVOICENO", "AMTPAID", "TOTAL", "DATE" };
/*      */ 
/*  655 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/*  656 */     model.fireTableDataChanged();
/*  657 */     this.table.setModel(model);
/*      */   }
/*      */ 
/*      */   public void search(String inv)
/*      */   {
/*  663 */     String sql = "select Itemcode,quantity from invoice where invoiceno='" + inv + "'";
/*      */     try
/*      */     {
/*  672 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/*  674 */       Statement st = cn.createStatement();
/*      */ 
/*  676 */       ResultSet rs = st.executeQuery(sql);
/*      */ 
/*  679 */       if (rs.next()) {
/*  680 */         rs.last();
/*      */ 
/*  682 */         this.mine = new String[rs.getRow()][2];
/*  683 */         rs.beforeFirst();
/*      */       }
/*  685 */       int rowcount = 0;
/*      */ 
/*  687 */       while (rs.next())
/*      */       {
/*  690 */         this.mine[rowcount][0] = rs.getString(1);
/*  691 */         this.mine[rowcount][1] = rs.getString(2);
/*      */ 
/*  700 */         rowcount++;
/*      */       }
/*      */ 
/*  704 */       rs.close();
/*  705 */       cn.close();
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*  709 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void delete(String invoiceno, String date)
/*      */   {
/*      */     try
/*      */     {
/*  717 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/*  718 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  719 */       String sql = "delete from invoice where invoiceno='" + invoiceno + "'";
/*      */ 
/*  721 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/*  725 */       int u = stmt.executeUpdate();
/*  726 */       if (u > 0) {
/*  727 */         JOptionPane.showMessageDialog(this.jPanel1, "DELETED!", "Success!", 1);
/*      */       }
/*      */       else
/*      */       {
/*  734 */         JOptionPane.showMessageDialog(this.jPanel1, "Not done!", "ERROR!", 0);
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public void deletesales(String invoiceno, String date)
/*      */   {
/*      */     try
/*      */     {
/*  746 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/*  747 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  748 */       String sql = "delete from sales where invoiceno='" + invoiceno + "'";
/*      */ 
/*  750 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/*  754 */       int u = stmt.executeUpdate();
/*  755 */       if (u <= 0)
/*      */       {
/*  763 */         JOptionPane.showMessageDialog(this.jPanel1, "Not done!", "ERROR!", 0);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  771 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void deletedebtors(String invoiceno, String date)
/*      */   {
/*      */     try {
/*  778 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/*  779 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  780 */       String sql = "delete from debtors where invoiceno='" + this.invoice + "' ";
/*      */ 
/*  782 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*      */ 
/*  786 */       int u = stmt.executeUpdate();
/*  787 */       if (u <= 0)
/*      */       {
/*  795 */         JOptionPane.showMessageDialog(this.jPanel1, "Not done!", "ERROR!", 0);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  802 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public String searchquan(String code)
/*      */   {
/*  810 */     String quan = null;
/*  811 */     String sql = "select quantity from stock where itemcode='" + code + "'";
/*      */     try
/*      */     {
/*  820 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/*  822 */       Statement st = cn.createStatement();
/*      */ 
/*  824 */       ResultSet rs = st.executeQuery(sql);
/*  825 */       while (rs.next())
/*      */       {
/*  827 */         quan = rs.getString(1);
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/*      */     }
/*  832 */     return quan;
/*      */   }
/*      */ 
/*      */   public void updateqaun(String ite, String qua)
/*      */   {
/*  837 */     String sql = "update stock set quantity='" + qua + "' where Itemcode='" + ite + "'";
/*      */     try
/*      */     {
/*  846 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/*  848 */       Statement st = cn.createStatement();
/*      */ 
/*  850 */       int r = st.executeUpdate(sql);
/*  851 */       if (r > 0)
/*      */       {
/*  853 */         JOptionPane.showMessageDialog(this.jPanel1, "UPDATED!", "Success!", 1);
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  858 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void iterate()
/*      */   {
/*  865 */     System.out.println(this.invoice);
/*  866 */     search(this.invoice);
/*  867 */     int r = this.mine.length;
/*      */ 
/*  869 */     for (int y = 0; y < this.mine.length; y++) {
/*  870 */       for (int t = 0; t < 2; t++);
/*  877 */       double dd = Double.parseDouble(searchquan(this.mine[y][0]));
/*  878 */       double hdd = Double.parseDouble(this.mine[y][1]);
/*  879 */       System.out.println(this.mine[y][1] + " " + String.valueOf(dd + hdd));
/*  880 */       updateqaun(this.mine[y][0], String.valueOf(dd + hdd));
/*      */     }
/*      */   }
/*      */ 
/*      */   public void intial()
/*      */   {
/*      */     try
/*      */     {
/*  891 */       Class.forName("com.mysql.jdbc.Driver");
/*  892 */       String user = "root";
/*  893 */       String pass = "this";
/*  894 */       String url = "jdbc:mysql://localhost:3306/inventory";
/*  895 */       String sql = "delete from debtors where not exists (select invoiceno from invoice where invoiceno=invoiceno)";
/*  896 */       com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, user, pass);
/*  897 */       com.mysql.jdbc.PreparedStatement stms = (com.mysql.jdbc.PreparedStatement)conn.prepareStatement(sql);
/*  898 */       int s = stms.executeUpdate();
/*  899 */       if (s > 0)
/*  900 */         JOptionPane.showMessageDialog(this.jPanel1, "updated", "Successfull", 1);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  904 */       System.out.println(ex);
/*      */     }
/*      */   }
/*      */   public void searchitems() {
/*  912 */     SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
/*      */     String strstart;
/*      */     try {
/*  914 */       System.out.println("SAART");
/*      */ 
/*  917 */       strstart = f.format(this.jDateChooser1.getDate());
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */       
/*  920 */       strstart = "";
/*      */     }
/*      */ 
/*      */     String strstop;
/*      */     try
/*      */     {
/*  928 */       strstop = f.format(this.jDateChooser2.getDate());
/*      */     }
/*      */     catch (Exception x)
/*      */     {
/*      */       
/*  931 */       strstop = "";
/*      */     }
/*      */     String who;
/*      */     try
/*      */     {
/*  937 */       who = this.name.getText();
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */       
/*  941 */       who = "";
/*      */     }
/*  943 */     System.out.println(strstart + " dates " + strstop);
/*      */ 
/*  945 */     if ((who.equals("") == true) && (!strstart.equals("")) && (!strstop.equals(""))) {
/*  946 */       this.data = getData3(strstart, strstop);
/*  947 */       update();
/*  948 */       System.out.println("data3");
/*      */     }
/*  950 */     else if ((!who.equals("")) && (strstart.equals("") == true) && (strstop.equals("") == true)) {
/*  951 */       this.data = getData1();
/*  952 */       update();
/*  953 */       System.out.println("data1");
/*      */     }
/*  955 */     else if ((!who.equals("")) && (!strstart.equals("")) && (!strstop.equals(""))) {
/*  956 */       this.data = getData2(strstart, strstop);
/*  957 */       update();
/*  958 */       System.out.println("data2");
/*      */     }
/*      */     else
/*      */     {
/*  962 */       this.data = getData();
/*  963 */       update();
/*      */     }
/*      */   }
/*      */ 
/*      */   public String[][] getData1()
/*      */   {
/*  970 */     this.sample = ((String[][])null);
/*  971 */     String person = this.name.getText();
/*  972 */     String str = "SELECT name,invoiceno,amtpaid,total,date from debtors where name='" + person + "'order by date desc";
/*      */     try
/*      */     {
/*  981 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/*  983 */       Statement st = cn.createStatement();
/*      */ 
/*  985 */       ResultSet rs = st.executeQuery(str);
/*      */ 
/*  988 */       if (rs.next()) {
/*  989 */         rs.last();
/*      */ 
/*  991 */         this.sample = new String[rs.getRow()][5];
/*  992 */         rs.beforeFirst();
/*      */       }
/*  994 */       int rowcount = 0;
/*      */ 
/*  996 */       while (rs.next())
/*      */       {
/*  999 */         this.sample[rowcount][0] = rs.getString(1);
/* 1000 */         this.sample[rowcount][1] = rs.getString(2);
/* 1001 */         this.sample[rowcount][2] = rs.getString(3);
/* 1002 */         this.sample[rowcount][3] = rs.getString(4);
/* 1003 */         this.sample[rowcount][4] = rs.getString(5);
/*      */ 
/* 1011 */         rowcount++;
/*      */       }
/*      */ 
/* 1014 */       rs.close();
/* 1015 */       cn.close();
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/* 1019 */       e.printStackTrace();
/*      */     }
/* 1021 */     return this.sample;
/*      */   }
/*      */   public String[][] getData2(String start, String stop) {
/* 1024 */     String person = this.name.getText();
/*      */ 
/* 1026 */     this.sample = ((String[][])null);
/* 1027 */     String str = "SELECT name,invoiceno,amtpaid,total,date from debtors where name='" + person + "'&& date>='" + start + "' && date<='" + stop + "' order by date desc";
/*      */     try
/*      */     {
/* 1036 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 1038 */       Statement st = cn.createStatement();
/*      */ 
/* 1040 */       ResultSet rs = st.executeQuery(str);
/*      */ 
/* 1043 */       if (rs.next()) {
/* 1044 */         rs.last();
/*      */ 
/* 1046 */         this.sample = new String[rs.getRow()][5];
/* 1047 */         rs.beforeFirst();
/*      */       }
/* 1049 */       int rowcount = 0;
/*      */ 
/* 1051 */       while (rs.next())
/*      */       {
/* 1054 */         this.sample[rowcount][0] = rs.getString(1);
/* 1055 */         this.sample[rowcount][1] = rs.getString(2);
/* 1056 */         this.sample[rowcount][2] = rs.getString(3);
/* 1057 */         this.sample[rowcount][3] = rs.getString(4);
/* 1058 */         this.sample[rowcount][4] = rs.getString(5);
/*      */ 
/* 1066 */         rowcount++;
/*      */       }
/*      */ 
/* 1069 */       rs.close();
/* 1070 */       cn.close();
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/* 1074 */       e.printStackTrace();
/*      */     }
/* 1076 */     return this.sample;
/*      */   }
/*      */ 
/*      */   public String[][] getData3(String start, String stop)
/*      */   {
/* 1082 */     this.sample = ((String[][])null);
/* 1083 */     String str = "SELECT name,invoiceno,amtpaid,total,date from debtors where date>='" + start + "' && date<='" + stop + "' order by date desc";
/* 1084 */     System.out.println(str);
/*      */     try
/*      */     {
/* 1092 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 1094 */       Statement st = cn.createStatement();
/*      */ 
/* 1096 */       ResultSet rs = st.executeQuery(str);
/*      */ 
/* 1099 */       if (rs.next()) {
/* 1100 */         rs.last();
/*      */ 
/* 1102 */         this.sample = new String[rs.getRow()][5];
/* 1103 */         rs.beforeFirst();
/*      */       }
/* 1105 */       int rowcount = 0;
/*      */ 
/* 1107 */       while (rs.next())
/*      */       {
/* 1110 */         this.sample[rowcount][0] = rs.getString(1);
/* 1111 */         this.sample[rowcount][1] = rs.getString(2);
/* 1112 */         this.sample[rowcount][2] = rs.getString(3);
/* 1113 */         this.sample[rowcount][3] = rs.getString(4);
/* 1114 */         this.sample[rowcount][4] = rs.getString(5);
/*      */ 
/* 1122 */         rowcount++;
/*      */       }
/*      */ 
/* 1125 */       rs.close();
/* 1126 */       cn.close();
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/* 1130 */       e.printStackTrace();
/*      */     }
/* 1132 */     return this.sample;
/*      */   }
/*      */   public void update1() {
/* 1135 */     String person = this.name.getText();
/* 1136 */     String str = "SELECT name AS 'NAME',invoiceno as 'INVOICENO',amtpaid as 'AMT PAID',total as 'TOTAL',date as 'DATE' from debtors where name='" + person + "'order by date desc";
/*      */     try
/*      */     {
/* 1145 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 1147 */       Statement st = cn.createStatement();
/*      */ 
/* 1149 */       ResultSet rs = st.executeQuery(str);
/*      */ 
/* 1151 */       this.table.setModel(DbUtils.resultSetToTableModel(rs));
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1155 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void update3(String start, String stop)
/*      */   {
/* 1164 */     String person = this.name.getText();
/* 1165 */     String str = "SELECT name AS 'NAME',invoiceno as 'INVOICENO',amtpaid as 'AMT PAID',total as 'TOTAL',date as 'DATE' from debtors where name='" + person + "' && date>='" + start + "' && date<'" + stop + "'order by date desc";
/*      */     try
/*      */     {
/* 1174 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 1176 */       Statement st = cn.createStatement();
/*      */ 
/* 1178 */       ResultSet rs = st.executeQuery(str);
/*      */ 
/* 1180 */       this.table.setModel(DbUtils.resultSetToTableModel(rs));
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1184 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void update4(String start, String stop)
/*      */   {
/* 1192 */     String person = this.name.getText();
/* 1193 */     String str = "SELECT name AS 'NAME',invoiceno as 'INVOICENO',amtpaid as 'AMT PAID',total as 'TOTAL',date as 'DATE' from debtors where date>='" + start + "' && date < '" + stop + "'order by date desc";
/*      */     try
/*      */     {
/* 1202 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*      */ 
/* 1204 */       Statement st = cn.createStatement();
/*      */ 
/* 1206 */       ResultSet rs = st.executeQuery(str);
/*      */ 
/* 1208 */       this.table.setModel(DbUtils.resultSetToTableModel(rs));
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1212 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void intial2()
/*      */   {
/*      */     try
/*      */     {
/* 1223 */       Class.forName("com.mysql.jdbc.Driver");
/* 1224 */       String user = "root";
/* 1225 */       String pass = "this";
/* 1226 */       String url = "jdbc:mysql://localhost:3306/inventory";
/* 1227 */       String sql = "delete from sales where not exists (select invoiceno from invoice where invoiceno=invoiceno)";
/* 1228 */       com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, user, pass);
/* 1229 */       com.mysql.jdbc.PreparedStatement stms = (com.mysql.jdbc.PreparedStatement)conn.prepareStatement(sql);
/* 1230 */       int s = stms.executeUpdate();
/* 1231 */       if (s > 0)
/* 1232 */         JOptionPane.showMessageDialog(this.jPanel1, "updated", "Successfull", 1);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1236 */       System.out.println(ex);
/*      */     }
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*      */     try
/*      */     {
/* 1250 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 1251 */         if ("Windows".equals(info.getName())) {
/* 1252 */           UIManager.setLookAndFeel(info.getClassName());
/* 1253 */           break;
/*      */         }
/*      */     }
/*      */     catch (ClassNotFoundException ex) {
/* 1257 */       Logger.getLogger(invoicelist.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (InstantiationException ex) {
/* 1259 */       Logger.getLogger(invoicelist.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (IllegalAccessException ex) {
/* 1261 */       Logger.getLogger(invoicelist.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (UnsupportedLookAndFeelException ex) {
/* 1263 */       Logger.getLogger(invoicelist.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/*      */ 
/* 1270 */     EventQueue.invokeLater(new Runnable()
/*      */     {
/*      */       public void run() {
/* 1273 */         invoicelist dialog = new invoicelist(new JFrame(), true);
/* 1274 */         dialog.addWindowListener(new WindowAdapter()
/*      */         {
/*      */           public void windowClosing(WindowEvent e)
/*      */           {
/*      */           }
/*      */         });
/* 1281 */         dialog.setVisible(true);
/*      */       }
/*      */     });
/*      */   }
/*      */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.invoicelist
 * JD-Core Version:    0.6.0
 */