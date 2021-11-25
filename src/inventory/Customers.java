/*     */ package inventory;
/*     */ 
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
/*     */ import java.sql.Connection;
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
/*     */ import javax.swing.JButton;
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
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import net.proteanit.sql.DbUtils;
/*     */ 
/*     */ public class Customers extends JDialog
/*     */ {
/*  25 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  26 */   static String username = "root";
/*  27 */   static String password = "this";
/*     */   ResultSet ris;
/*     */   ResultSet rst;
/*     */   JTable table;
/*     */   JTable table2;
/*  30 */   String[][] data = (String[][])null;
/*  31 */   String[][] data2 = (String[][])null;
/*  32 */   String idn = "";
/*  33 */   String name = "";
/*     */   public JButton jButton1;
/*     */   public JPanel jPanel1;
/*     */   public JPanel jPanel2;
/*     */   public JPanel jPanel3;
/*     */ 
/*     */   public Customers(Frame parent, boolean modal)
/*     */   {
/*  39 */     super(parent, modal);
/*  40 */     initComponents();
/*  41 */     setResizable(false);
/*  42 */     setLocationRelativeTo(null);
/*  43 */     setTitle("Customers");
/*  44 */     this.data = getData();
/*     */ 
/*  47 */     table();
/*     */   }
/*     */ 
/*     */   public void table()
/*     */   {
/*  52 */     String[] headers = { "NAME ", "PHONE NO", "ID. NUMBER ", "ADDRESS" };
/*     */ 
/*  57 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/*  58 */     model.fireTableDataChanged();
/*  59 */     this.table = new JTable(model);
/*     */ 
/*  62 */     JScrollPane scrollPane = new JScrollPane(this.table);
/*     */ 
/*  64 */     this.jPanel3.add(scrollPane, "Center");
/*  65 */     scrollPane.setBounds(0, 0, 610, 249);
/*  66 */     this.table.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e)
/*     */       {
/*  70 */         int row = Customers.this.table.getSelectedRow();
/*     */ 
/*  72 */         int col = Customers.this.table.getSelectedColumn();
/*  73 */         String code = Customers.this.data[row][0];
/*     */ 
/*  75 */         Customers.this.idn = Customers.this.data[row][2];
/*  76 */         Customers.this.name = code;
/*  77 */         CustomerDialog cus = new CustomerDialog(new JFrame(), true);
/*  78 */         cus.setData(Customers.this.name, Customers.this.idn);
/*  79 */         cus.setVisible(true);
/*  80 */         Customers.this.data = Customers.this.getData();
/*  81 */         Customers.this.update_table1();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public String[][] getData()
/*     */   {
/*  96 */     String[][] sample = (String[][])null;
/*  97 */     String str = "SELECT * from customer";
/*     */     try
/*     */     {
/* 106 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 108 */       Statement st = cn.createStatement();
/*     */ 
/* 110 */       ResultSet rs = st.executeQuery(str);
/*     */ 
/* 113 */       if (rs.next()) {
/* 114 */         rs.last();
/*     */ 
/* 116 */         sample = new String[rs.getRow()][4];
/* 117 */         rs.beforeFirst();
/*     */       }
/* 119 */       int rowcount = 0;
/*     */ 
/* 121 */       while (rs.next())
/*     */       {
/* 124 */         sample[rowcount][0] = rs.getString(2);
/* 125 */         sample[rowcount][1] = rs.getString(3);
/* 126 */         sample[rowcount][2] = rs.getString(4);
/* 127 */         sample[rowcount][3] = rs.getString(5);
/*     */ 
/* 135 */         rowcount++;
/*     */       }
/*     */ 
/* 138 */       rs.close();
/* 139 */       cn.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 143 */       e.printStackTrace();
/*     */     }
/* 145 */     return sample;
/*     */   }
/*     */ 
/*     */   public void update_table1() {
/* 149 */     String[] headers = { "NAME ", "PHONE NO", "ID. NUMBER ", "ADDRESS" };
/*     */ 
/* 154 */     DefaultTableModel model = new DefaultTableModel(this.data, headers);
/* 155 */     model.fireTableDataChanged();
/* 156 */     this.table.setModel(model);
/*     */   }
/*     */ 
/*     */   public void update_table(String name)
/*     */   {
/* 166 */     String str = "SELECT  phoneno AS 'PHONE NO',idno AS 'ID NUMBER',address AS 'ADDRESS' from customer where name='" + name + "' ";
/*     */ 
/* 170 */     ResultSet rs = null;
/*     */     try
/*     */     {
/* 176 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 178 */       Statement st = cn.createStatement();
/*     */ 
/* 180 */       rs = st.executeQuery(str);
/* 181 */       this.table2.setModel(DbUtils.resultSetToTableModel(rs));
/*     */     } catch (Exception ex) {
/* 183 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 202 */     this.jPanel1 = new JPanel();
/* 203 */     this.jPanel2 = new JPanel();
/* 204 */     this.jPanel3 = new JPanel();
/* 205 */     this.jButton1 = new JButton();
/*     */ 
/* 207 */     setDefaultCloseOperation(2);
/*     */ 
/* 209 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/* 211 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/* 212 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/* 214 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 215 */     this.jPanel2.setLayout(jPanel2Layout);
/* 216 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 217 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 218 */       .addGap(0, 0, 32767));
/*     */ 
/* 220 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 221 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 222 */       .addGap(0, 27, 32767));
/*     */ 
/* 225 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/* 226 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 228 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 229 */     this.jPanel3.setLayout(jPanel3Layout);
/* 230 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 231 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 232 */       .addGap(0, 608, 32767));
/*     */ 
/* 234 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 235 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 236 */       .addGap(0, 245, 32767));
/*     */ 
/* 239 */     this.jButton1.setText("ADD NEW");
/* 240 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 242 */         Customers.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 246 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 247 */     this.jPanel1.setLayout(jPanel1Layout);
/* 248 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 249 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 250 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 251 */       .addGroup(jPanel1Layout
/* 251 */       .createSequentialGroup()
/* 252 */       .addGroup(jPanel1Layout
/* 252 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 253 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 254 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
/* 254 */       .createSequentialGroup()
/* 255 */       .addGap(120, 120, 120)
/* 256 */       .addComponent(this.jButton1)))
/* 257 */       .addGap(0, 27, 32767)));
/*     */ 
/* 259 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 260 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 261 */       .addGroup(jPanel1Layout
/* 261 */       .createSequentialGroup()
/* 262 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 263 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 264 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 265 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 266 */       .addComponent(this.jButton1)));
/*     */ 
/* 269 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 270 */     getContentPane().setLayout(layout);
/* 271 */     layout.setHorizontalGroup(layout
/* 272 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 273 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 275 */     layout.setVerticalGroup(layout
/* 276 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 277 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 280 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 284 */     upd dialog = new upd(new JFrame(), true);
/* 285 */     dialog.setVisible(true);
/* 286 */     this.data = getData();
/* 287 */     update_table1();
/*     */   }
/*     */ 
/*     */   public void delete()
/*     */   {
/*     */     try
/*     */     {
/* 299 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 300 */       Connection connection = DriverManager.getConnection(url, username, password);
/*     */ 
/* 302 */       PreparedStatement psmnt = connection.prepareStatement("Delete from customer where  idno='" + this.idn + "'");
/*     */ 
/* 304 */       int s = psmnt.executeUpdate();
/* 305 */       if (s > 0) {
/* 306 */         JOptionPane.showMessageDialog(null, "success", "deleted", 1);
/* 307 */         dispose();
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 313 */       e.printStackTrace();
/* 314 */       JOptionPane.showMessageDialog(null, "did not delete", "error", -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 334 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 335 */         if ("Windows".equals(info.getName())) {
/* 336 */           UIManager.setLookAndFeel(info.getClassName());
/* 337 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 341 */       Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 343 */       Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 345 */       Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 347 */       Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 354 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 357 */         Customers dialog = new Customers(new JFrame(), true);
/* 358 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 362 */             System.exit(0);
/*     */           }
/*     */         });
/* 365 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.Customers
 * JD-Core Version:    0.6.0
 */