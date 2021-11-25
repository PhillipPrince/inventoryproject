/*     */ package inventory;
/*     */ 
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableModel;
/*     */ import net.proteanit.sql.DbUtils;
/*     */ 
/*     */ public class purchaseschange extends JDialog
/*     */ {
/*  25 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  26 */   static String username = "root";
/*  27 */   static String password = "this";
/*     */   JTable table;
/*     */   TableModel model;
/*  30 */   String[][] data = (String[][])null;
/*     */   String mydate;
/*     */   private JTextField bal;
/*     */   private JTextField code;
/*     */   private JComboBox jComboBox1;
/*     */   private JDateChooser jDateChooser1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel3;
/*     */   private JPanel jPanel4;
/*     */   private JPanel jPanel5;
/*     */   private JPanel jPanel6;
/*     */   private JTextField paid;
/*     */ 
/*     */   public purchaseschange(Frame parent, boolean modal)
/*     */   {
/*  36 */     super(parent, modal);
/*  37 */     initComponents();
/*     */     try
/*     */     {
/*  40 */       Class.forName("com.mysql.jdbc.Driver");
/*  41 */       Connection conn = DriverManager.getConnection(url, username, password);
/*  42 */       String sql = "SELECT name FROM suppliers";
/*  43 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*  44 */       ResultSet resultSet = stmt.executeQuery();
/*  45 */       while (resultSet.next()) {
/*  46 */         this.jComboBox1.addItem(resultSet.getString(1));
/*     */       }
/*  48 */       conn.close();
/*     */     } catch (Exception exc) {
/*  50 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void fill(String pcode, String date, String supplier)
/*     */   {
/*  60 */     this.mydate = date;
/*  61 */     this.code.setText(pcode);
/*  62 */     Date n = Date.valueOf(date);
/*  63 */     this.jDateChooser1.setDate(n);
/*  64 */     this.jComboBox1.setSelectedItem(supplier);
/*  65 */     this.data = getData();
/*  66 */     table();
/*  67 */     get();
/*     */   }
/*     */ 
/*     */   public void table()
/*     */   {
/*  72 */     String[] headers = { "ITEMCODE", "NAME", "DESCRIPTION", "QUANTITY", "BUYING PRICE" };
/*     */ 
/*  77 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/*  78 */     model.fireTableDataChanged();
/*  79 */     this.table = new JTable(model);
/*     */ 
/*  82 */     JScrollPane scrollPane = new JScrollPane(this.table);
/*     */ 
/*  84 */     this.jPanel6.add(scrollPane, "Center");
/*  85 */     scrollPane.setBounds(0, 0, 604, 250);
/*  86 */     this.table.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent e) {
/*  88 */         int r = purchaseschange.this.table.getSelectedRow();
/*  89 */         String itemcod = purchaseschange.this.data[r][0];
/*  90 */         String itemnam = purchaseschange.this.data[r][1];
/*  91 */         String itemdes = purchaseschange.this.data[r][2];
/*  92 */         String itemquan = purchaseschange.this.data[r][3];
/*  93 */         String buyingprice = purchaseschange.this.data[r][4];
/*  94 */         String theinvoice = purchaseschange.this.code.getText();
/*  95 */         String totalall = purchaseschange.this.bal.getText();
/*  96 */         editpurchases n = new editpurchases(new JFrame(), true);
/*  97 */         n.fill(itemcod, itemnam, itemdes, itemquan, buyingprice, theinvoice, totalall);
/*  98 */         n.setVisible(true);
/*     */         try {
/* 100 */           wait();
/*     */         } catch (InterruptedException ex) {
/* 102 */           Logger.getLogger(purchaseschange.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public String[][] getData()
/*     */   {
/* 111 */     String cod = this.code.getText();
/*     */ 
/* 114 */     String[][] sample = (String[][])null;
/* 115 */     String str = "SELECT Itemcode AS 'ITEMCODE',name AS 'NAME',description AS 'DESCRIPTION',quantity AS 'QUANTITY',price AS 'BUYING PRICE' from purchases where code='" + cod + "' && date= '" + this.mydate + "'";
/*     */     try
/*     */     {
/* 124 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 126 */       Statement st = cn.createStatement();
/*     */ 
/* 128 */       ResultSet rs = st.executeQuery(str);
/*     */ 
/* 131 */       if (rs.next()) {
/* 132 */         rs.last();
/*     */ 
/* 134 */         sample = new String[rs.getRow()][5];
/* 135 */         rs.beforeFirst();
/*     */       }
/* 137 */       int rowcount = 0;
/*     */ 
/* 139 */       while (rs.next())
/*     */       {
/* 142 */         sample[rowcount][0] = rs.getString(1);
/* 143 */         sample[rowcount][1] = rs.getString(2);
/* 144 */         sample[rowcount][2] = rs.getString(3);
/* 145 */         sample[rowcount][3] = rs.getString(4);
/* 146 */         sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 155 */         rowcount++;
/*     */       }
/*     */ 
/* 158 */       rs.close();
/* 159 */       cn.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 163 */       e.printStackTrace();
/*     */     }
/* 165 */     return sample;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 176 */     this.jPanel4 = new JPanel();
/* 177 */     this.jPanel5 = new JPanel();
/* 178 */     this.jPanel1 = new JPanel();
/* 179 */     this.jLabel1 = new JLabel();
/* 180 */     this.code = new JTextField();
/* 181 */     this.jLabel2 = new JLabel();
/* 182 */     this.jDateChooser1 = new JDateChooser();
/* 183 */     this.jComboBox1 = new JComboBox();
/* 184 */     this.jLabel3 = new JLabel();
/* 185 */     this.jPanel3 = new JPanel();
/* 186 */     this.jLabel4 = new JLabel();
/* 187 */     this.jLabel5 = new JLabel();
/* 188 */     this.paid = new JTextField();
/* 189 */     this.bal = new JTextField();
/* 190 */     this.jPanel6 = new JPanel();
/*     */ 
/* 192 */     setDefaultCloseOperation(2);
/*     */ 
/* 194 */     this.jPanel4.setBackground(new Color(153, 153, 255));
/*     */ 
/* 196 */     this.jPanel5.setBackground(new Color(0, 0, 0));
/*     */ 
/* 198 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 199 */     this.jPanel5.setLayout(jPanel5Layout);
/* 200 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 201 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 202 */       .addGap(0, 0, 32767));
/*     */ 
/* 204 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 205 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 206 */       .addGap(0, 20, 32767));
/*     */ 
/* 209 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/* 210 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 212 */     this.jLabel1.setText("PURCHASE CODE:");
/*     */ 
/* 214 */     this.jLabel2.setText("DATE:");
/*     */ 
/* 216 */     this.jLabel3.setText("SUPPLIER:");
/*     */ 
/* 218 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 219 */     this.jPanel1.setLayout(jPanel1Layout);
/* 220 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 221 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 222 */       .addGroup(jPanel1Layout
/* 222 */       .createSequentialGroup()
/* 223 */       .addContainerGap()
/* 224 */       .addGroup(jPanel1Layout
/* 224 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 225 */       .addComponent(this.jLabel1)
/* 226 */       .addComponent(this.jLabel2))
/* 227 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 228 */       .addGroup(jPanel1Layout
/* 228 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 229 */       .addComponent(this.code)
/* 230 */       .addComponent(this.jDateChooser1, -1, 142, 32767))
/* 231 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 232 */       .addComponent(this.jLabel3)
/* 233 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 234 */       .addComponent(this.jComboBox1, -2, 139, -2)
/* 235 */       .addGap(77, 77, 77)));
/*     */ 
/* 237 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 238 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 239 */       .addGroup(jPanel1Layout
/* 239 */       .createSequentialGroup()
/* 240 */       .addGroup(jPanel1Layout
/* 240 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 241 */       .addGroup(jPanel1Layout
/* 241 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 242 */       .addComponent(this.jComboBox1, -2, -1, -2)
/* 243 */       .addComponent(this.jLabel3))
/* 244 */       .addGroup(jPanel1Layout
/* 244 */       .createSequentialGroup()
/* 245 */       .addGroup(jPanel1Layout
/* 245 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 246 */       .addComponent(this.jLabel1)
/* 247 */       .addComponent(this.code, -2, -1, -2))
/* 248 */       .addGap(18, 18, 18)
/* 249 */       .addGroup(jPanel1Layout
/* 249 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 250 */       .addComponent(this.jLabel2)
/* 251 */       .addComponent(this.jDateChooser1, -2, -1, -2))))
/* 252 */       .addGap(0, 20, 32767)));
/*     */ 
/* 255 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*     */ 
/* 257 */     this.jLabel4.setText("AMOUNT PAID:");
/*     */ 
/* 259 */     this.jLabel5.setText("BALANCE:");
/*     */ 
/* 261 */     this.paid.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 263 */     this.bal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 265 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 266 */     this.jPanel3.setLayout(jPanel3Layout);
/* 267 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 268 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 269 */       .addGroup(jPanel3Layout
/* 269 */       .createSequentialGroup()
/* 270 */       .addContainerGap()
/* 271 */       .addGroup(jPanel3Layout
/* 271 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 272 */       .addComponent(this.jLabel4)
/* 273 */       .addComponent(this.jLabel5))
/* 274 */       .addGap(18, 18, 18)
/* 275 */       .addGroup(jPanel3Layout
/* 275 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 276 */       .addComponent(this.paid)
/* 277 */       .addComponent(this.bal, -1, 106, 32767))
/* 278 */       .addContainerGap(42, 32767)));
/*     */ 
/* 280 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 281 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 282 */       .addGroup(jPanel3Layout
/* 282 */       .createSequentialGroup()
/* 283 */       .addContainerGap()
/* 284 */       .addGroup(jPanel3Layout
/* 284 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 285 */       .addComponent(this.jLabel4)
/* 286 */       .addComponent(this.paid, -2, -1, -2))
/* 287 */       .addGap(18, 18, 18)
/* 288 */       .addGroup(jPanel3Layout
/* 288 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 289 */       .addComponent(this.jLabel5)
/* 290 */       .addComponent(this.bal, -2, -1, -2))
/* 291 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 294 */     this.jPanel6.setBackground(new Color(153, 153, 255));
/* 295 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/* 296 */     this.jPanel6.setPreferredSize(new Dimension(604, 250));
/*     */ 
/* 298 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 299 */     this.jPanel6.setLayout(jPanel6Layout);
/* 300 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 301 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 302 */       .addGap(0, 600, 32767));
/*     */ 
/* 304 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 305 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 306 */       .addGap(0, 246, 32767));
/*     */ 
/* 309 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 310 */     this.jPanel4.setLayout(jPanel4Layout);
/* 311 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 312 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 313 */       .addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 314 */       .addGroup(jPanel4Layout
/* 314 */       .createSequentialGroup()
/* 315 */       .addContainerGap()
/* 316 */       .addGroup(jPanel4Layout
/* 316 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 317 */       .addComponent(this.jPanel1, -1, -1, 32767)
/* 318 */       .addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 319 */       .addGroup(jPanel4Layout
/* 319 */       .createSequentialGroup()
/* 320 */       .addComponent(this.jPanel6, -2, -1, -2)
/* 321 */       .addGap(0, 0, 32767)))
/* 322 */       .addContainerGap()));
/*     */ 
/* 324 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 325 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 326 */       .addGroup(jPanel4Layout
/* 326 */       .createSequentialGroup()
/* 327 */       .addComponent(this.jPanel5, -2, -1, -2)
/* 328 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 329 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 330 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 331 */       .addComponent(this.jPanel6, -2, -1, -2)
/* 332 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 333 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 334 */       .addGap(0, 15, 32767)));
/*     */ 
/* 337 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 338 */     getContentPane().setLayout(layout);
/* 339 */     layout.setHorizontalGroup(layout
/* 340 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 341 */       .addComponent(this.jPanel4, -1, -1, 32767));
/*     */ 
/* 343 */     layout.setVerticalGroup(layout
/* 344 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 345 */       .addComponent(this.jPanel4, -1, -1, 32767));
/*     */ 
/* 348 */     pack();
/*     */   }
/*     */ 
/*     */   public void get()
/*     */   {
/* 356 */     String cod = this.code.getText();
/*     */ 
/* 360 */     String str = "SELECT amtowed,amtpaid from purchasedpaid where invoiceno='" + cod + "' && date= '" + this.mydate + "'";
/*     */     try
/*     */     {
/* 369 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 371 */       Statement st = cn.createStatement();
/*     */ 
/* 373 */       ResultSet rs = st.executeQuery(str);
/*     */ 
/* 376 */       while (rs.next())
/*     */       {
/* 378 */         this.bal.setText(rs.getString(1));
/* 379 */         this.paid.setText(rs.getString(2));
/*     */       }
/*     */     } catch (Exception ex) {
/* 382 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/* 389 */     String cod = this.code.getText();
/*     */ 
/* 393 */     String str = "SELECT amtowed,amtpaid from purchasedpaid where invoiceno='" + cod + "' && date= '" + this.mydate + "'";
/*     */     try
/*     */     {
/* 402 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 404 */       Statement st = cn.createStatement();
/*     */ 
/* 406 */       ResultSet rs = st.executeQuery(str);
/* 407 */       this.table.setModel(DbUtils.resultSetToTableModel(rs));
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 428 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 429 */         if ("Nimbus".equals(info.getName())) {
/* 430 */           UIManager.setLookAndFeel(info.getClassName());
/* 431 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 435 */       Logger.getLogger(purchaseschange.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 437 */       Logger.getLogger(purchaseschange.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 439 */       Logger.getLogger(purchaseschange.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 441 */       Logger.getLogger(purchaseschange.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 448 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 451 */         purchaseschange dialog = new purchaseschange(new JFrame(), true);
/* 452 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 456 */             System.exit(0);
/*     */           }
/*     */         });
/* 459 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.purchaseschange
 * JD-Core Version:    0.6.0
 */