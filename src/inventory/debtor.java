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
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.Statement;
/*     */ import java.util.Vector;
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
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import javax.swing.table.TableModel;
/*     */ import net.proteanit.sql.DbUtils;
/*     */ 
/*     */ public class debtor extends JDialog
/*     */ {
/*  30 */   JPanel panel = new JPanel();
/*     */   JTable table;
/*     */   JTable tabl;
/*  32 */   Vector columnNames = new Vector();
/*  33 */   Vector columnNames1 = new Vector();
/*  34 */   Vector data = new Vector();
/*  35 */   Vector data1 = new Vector();
/*  36 */   String[][] sample = (String[][])null;
/*  37 */   int counter1 = 0; int counter2 = 0; int counter3 = 0; int counter4 = 0; int counter5 = 0; int counter6 = 0; int counter7 = 0; int counter8 = 0; int counter9 = 0; int counter10 = 0;
/*  38 */   int counter = 0;
/*     */   public JButton jButton1;
/*     */   public JLabel jLabel2;
/*     */   public JLabel jLabel8;
/*     */   public JLabel jLabel9;
/*     */   public JPanel jPanel1;
/*     */   public JPanel jPanel2;
/*     */   public JPanel jPanel3;
/*     */   public JPanel jPanel4;
/*     */   public JPanel jPanel5;
/*     */   public JTextField jTextField1;
/*     */   public JTextField jTextField7;
/*     */   public JTextField jTextField8;
/*     */ 
/*     */   public debtor(Frame parent, boolean modal)
/*     */   {
/*  43 */     super(parent, modal);
/*  44 */     initComponents();
/*     */     try {
/*  46 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/*  47 */       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/*  50 */       String sql = "Select name from invoice WHERE subtotal > paid ";
/*  51 */       Statement statement = con.createStatement();
/*     */ 
/*  53 */       ResultSet resultSet = statement.executeQuery(sql);
/*     */ 
/*  55 */       ResultSetMetaData metaData1 = resultSet.getMetaData();
/*  56 */       int columns1 = metaData1.getColumnCount();
/*  57 */       for (int t = 1; t <= columns1; t++) {
/*  58 */         this.columnNames1.addElement(metaData1.getColumnName(t));
/*     */       }
/*     */ 
/*  62 */       while (resultSet.next())
/*     */       {
/*  64 */         Vector row1 = new Vector(columns1);
/*  65 */         for (int t = 1; t <= columns1; t++) {
/*  66 */           row1.addElement(resultSet.getObject(t));
/*     */ 
/*  68 */           this.data1.addElement(row1);
/*     */         }
/*     */       }
/*  71 */       resultSet.close();
/*  72 */       statement.close();
/*     */     } catch (Exception e) {
/*  74 */       System.out.println(e);
/*  75 */       e.printStackTrace();
/*     */     }
/*  77 */     String[] headers = { "INVOICE NO.", "AMOUNT PAID", "TOTAL " };
/*  78 */     this.table = new JTable(this.data1, this.columnNames1);
/*     */ 
/*  82 */     for (int t = 0; t < this.table.getColumnCount(); t++) {
/*  83 */       TableColumn column1 = this.table.getColumnModel().getColumn(t);
/*  84 */       column1.setMaxWidth(700);
/*     */     }
/*  86 */     JScrollPane scrollPane2 = new JScrollPane(this.table);
/*  87 */     this.jPanel3.add(scrollPane2, "West");
/*  88 */     scrollPane2.setBounds(0, 0, 200, 350);
/*  89 */     kenya();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 103 */     this.jPanel1 = new JPanel();
/* 104 */     this.jPanel2 = new JPanel();
/* 105 */     this.jPanel3 = new JPanel();
/* 106 */     this.jPanel4 = new JPanel();
/* 107 */     this.jLabel2 = new JLabel();
/* 108 */     this.jLabel8 = new JLabel();
/* 109 */     this.jLabel9 = new JLabel();
/* 110 */     this.jTextField1 = new JTextField();
/* 111 */     this.jTextField7 = new JTextField();
/* 112 */     this.jTextField8 = new JTextField();
/* 113 */     this.jButton1 = new JButton();
/* 114 */     this.jPanel5 = new JPanel();
/*     */ 
/* 116 */     setDefaultCloseOperation(2);
/*     */ 
/* 118 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/* 120 */     this.jPanel2.setBackground(new Color(51, 51, 51));
/* 121 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/* 122 */     this.jPanel2.setForeground(new Color(255, 255, 255));
/*     */ 
/* 124 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 125 */     this.jPanel2.setLayout(jPanel2Layout);
/* 126 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 127 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 128 */       .addGap(0, 0, 32767));
/*     */ 
/* 130 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 131 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 132 */       .addGap(0, 34, 32767));
/*     */ 
/* 135 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/* 136 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 138 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 139 */     this.jPanel3.setLayout(jPanel3Layout);
/* 140 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 141 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 142 */       .addGap(0, 190, 32767));
/*     */ 
/* 144 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 145 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 146 */       .addGap(0, 340, 32767));
/*     */ 
/* 149 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/* 150 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder(0));
/*     */ 
/* 152 */     this.jLabel2.setText("INVOICE NO.");
/*     */ 
/* 154 */     this.jLabel8.setText("SUBTOTAL");
/*     */ 
/* 156 */     this.jLabel9.setText("AMOUNT PAID");
/*     */ 
/* 158 */     this.jTextField1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 160 */     this.jTextField7.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 161 */     this.jTextField7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 163 */         debtor.this.jTextField7ActionPerformed(evt);
/*     */       }
/*     */     });
/* 167 */     this.jTextField8.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 169 */     this.jButton1.setText("UPDATE");
/*     */ 
/* 171 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 172 */     this.jPanel4.setLayout(jPanel4Layout);
/* 173 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 174 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 175 */       .addGroup(jPanel4Layout
/* 175 */       .createSequentialGroup()
/* 176 */       .addComponent(this.jLabel2)
/* 177 */       .addGap(18, 18, 18)
/* 178 */       .addComponent(this.jTextField1, -2, 92, -2)
/* 179 */       .addGap(18, 18, 18)
/* 180 */       .addComponent(this.jLabel9)
/* 181 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 182 */       .addGroup(jPanel4Layout
/* 182 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 183 */       .addComponent(this.jButton1)
/* 184 */       .addGroup(jPanel4Layout
/* 184 */       .createSequentialGroup()
/* 185 */       .addComponent(this.jTextField8, -2, 104, -2)
/* 186 */       .addGap(32, 32, 32)
/* 187 */       .addComponent(this.jLabel8)
/* 188 */       .addGap(33, 33, 33)
/* 189 */       .addComponent(this.jTextField7, -2, 110, -2)))
/* 190 */       .addContainerGap(14, 32767)));
/*     */ 
/* 192 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 193 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 194 */       .addGroup(jPanel4Layout
/* 194 */       .createSequentialGroup()
/* 195 */       .addContainerGap(24, 32767)
/* 196 */       .addGroup(jPanel4Layout
/* 196 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 197 */       .addComponent(this.jLabel2)
/* 198 */       .addComponent(this.jTextField1, -2, -1, -2)
/* 199 */       .addComponent(this.jLabel9)
/* 200 */       .addComponent(this.jTextField8, -2, -1, -2)
/* 201 */       .addComponent(this.jLabel8)
/* 202 */       .addComponent(this.jTextField7, -2, -1, -2))
/* 203 */       .addGap(29, 29, 29)
/* 204 */       .addComponent(this.jButton1)
/* 205 */       .addGap(48, 48, 48)));
/*     */ 
/* 208 */     this.jPanel5.setBackground(new Color(153, 153, 255));
/* 209 */     this.jPanel5.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 211 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 212 */     this.jPanel5.setLayout(jPanel5Layout);
/* 213 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 214 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 215 */       .addGap(0, 0, 32767));
/*     */ 
/* 217 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 218 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 219 */       .addGap(0, 0, 32767));
/*     */ 
/* 222 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 223 */     this.jPanel1.setLayout(jPanel1Layout);
/* 224 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 225 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 226 */       .addComponent(this.jPanel4, -1, -1, 32767)
/* 227 */       .addGroup(jPanel1Layout
/* 227 */       .createSequentialGroup()
/* 228 */       .addGap(2, 2, 2)
/* 229 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 230 */       .addGap(18, 18, 18)
/* 231 */       .addComponent(this.jPanel5, -1, -1, 32767))
/* 232 */       .addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */ 
/* 234 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 235 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 236 */       .addGroup(jPanel1Layout
/* 236 */       .createSequentialGroup()
/* 237 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 238 */       .addGap(18, 18, 18)
/* 239 */       .addGroup(jPanel1Layout
/* 239 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 240 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 241 */       .addComponent(this.jPanel5, -1, -1, 32767))
/* 242 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 243 */       .addComponent(this.jPanel4, -2, -1, -2)));
/*     */ 
/* 246 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 247 */     getContentPane().setLayout(layout);
/* 248 */     layout.setHorizontalGroup(layout
/* 249 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 250 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 252 */     layout.setVerticalGroup(layout
/* 253 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 254 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 257 */     pack();
/*     */   }
/*     */ 
/*     */   private void jTextField7ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 274 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 275 */         if ("Nimbus".equals(info.getName())) {
/* 276 */           UIManager.setLookAndFeel(info.getClassName());
/* 277 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 281 */       Logger.getLogger(debtor.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 283 */       Logger.getLogger(debtor.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 285 */       Logger.getLogger(debtor.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 287 */       Logger.getLogger(debtor.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 292 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 294 */         debtor dialog = new debtor(new JFrame(), true);
/* 295 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 298 */             System.exit(0);
/*     */           }
/*     */         });
/* 301 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private void kenya()
/*     */   {
/* 321 */     this.table.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e)
/*     */       {
/* 326 */         Object obj1 = null;
/* 327 */         String q = "";
/* 328 */         int i = debtor.this.table.getSelectedRow();
/*     */ 
/* 330 */         obj1 = GetData(debtor.this.table, i, 0);
/* 331 */         String k = obj1.toString();
/*     */         try
/*     */         {
/* 334 */           Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 335 */           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 337 */           String sql1 = "Select invoiceno,paid,subtotal from invoice WHERE name = '" + k + "' ";
/* 338 */           Statement statement = con.createStatement();
/*     */ 
/* 340 */           ResultSet resultSett = statement.executeQuery(sql1);
/*     */ 
/* 342 */           ResultSetMetaData metaData1 = resultSett.getMetaData();
/* 343 */           int columns1 = metaData1.getColumnCount();
/* 344 */           for (int t = 1; t <= columns1; t++) {
/* 345 */             debtor.this.columnNames.addElement(metaData1.getColumnName(t));
/* 346 */             debtor.this.columnNames.add(debtor.this.tabl);
/*     */           }
/*     */ 
/* 350 */           debtor.this.tabl.setModel(DbUtils.resultSetToTableModel(resultSett));
/*     */ 
/* 352 */           while (resultSett.next())
/*     */           {
/* 354 */             Vector row = new Vector(columns1);
/* 355 */             for (int k1 = 1; k1 <= columns1; k1++) {
/* 356 */               row.addElement(resultSett.getObject(k1));
/* 357 */               debtor.this.data.addElement(row);
/*     */             }
/*     */           }
/* 360 */           resultSett.close();
/* 361 */           statement.close();
/*     */         } catch (Exception el) {
/* 363 */           System.out.println(e);
/* 364 */           el.printStackTrace();
/*     */         }
/* 366 */         debtor.this.tabl = new JTable();
/* 367 */         DefaultTableModel model = new DefaultTableModel(debtor.this.data, debtor.this.columnNames);
/* 368 */         model.fireTableDataChanged();
/*     */ 
/* 370 */         for (int t = 0; t < debtor.this.tabl.getColumnCount(); t++) {
/* 371 */           TableColumn column = debtor.this.tabl.getColumnModel().getColumn(t);
/* 372 */           column.setMaxWidth(900);
/*     */         }
/* 374 */         JScrollPane scrollPane = new JScrollPane(debtor.this.tabl);
/* 375 */         debtor.this.jPanel5.add(scrollPane, "Center");
/* 376 */         scrollPane.setBounds(0, 0, 400, 450);
/* 377 */         debtor.this.tabl.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mouseClicked(MouseEvent e) {
/* 380 */             Object obj1 = null; Object obj2 = null; Object obj3 = null; Object obj4 = null; Object obj5 = null; Object obj6 = null; Object obj7 = null; Object obj8 = null; Object obj9 = null; Object obj10 = null;
/* 381 */             String q = "";
/* 382 */             int i = debtor.this.tabl.getSelectedRow();
/* 383 */             if (i == 0) {
/* 384 */               debtor.this.counter1 += 1;
/* 385 */               q = Integer.toString(debtor.this.counter1);
/*     */             }
/* 387 */             if (i == 1) {
/* 388 */               debtor.this.counter2 += 1;
/* 389 */               q = Integer.toString(debtor.this.counter2);
/*     */             }
/* 391 */             if (i == 2) {
/* 392 */               debtor.this.counter3 += 1;
/* 393 */               q = Integer.toString(debtor.this.counter3);
/*     */             }
/* 395 */             if (i == 3) {
/* 396 */               debtor.this.counter4 += 1;
/* 397 */               q = Integer.toString(debtor.this.counter4);
/*     */             }
/* 399 */             if (i == 4) {
/* 400 */               debtor.this.counter5 += 1;
/* 401 */               q = Integer.toString(debtor.this.counter5);
/*     */             }
/* 403 */             if (i == 5) {
/* 404 */               debtor.this.counter6 += 1;
/* 405 */               q = Integer.toString(debtor.this.counter6);
/*     */             }
/* 407 */             if (i == 6) {
/* 408 */               debtor.this.counter7 += 1;
/* 409 */               q = Integer.toString(debtor.this.counter7);
/*     */             }
/* 411 */             if (i == 7) {
/* 412 */               debtor.this.counter8 += 1;
/* 413 */               q = Integer.toString(debtor.this.counter8);
/*     */             }
/* 415 */             if (i == 8) {
/* 416 */               debtor.this.counter9 += 1;
/* 417 */               q = Integer.toString(debtor.this.counter9);
/*     */             }
/*     */ 
/* 420 */             obj1 = GetData(debtor.this.tabl, i, 0);
/* 421 */             obj2 = GetData(debtor.this.tabl, i, 1);
/* 422 */             obj3 = GetData(debtor.this.tabl, i, 2);
/*     */ 
/* 434 */             debtor.this.jTextField1.setText(obj1.toString());
/* 435 */             debtor.this.jTextField7.setText(obj2.toString());
/* 436 */             debtor.this.jTextField8.setText(obj3.toString());
/*     */           }
/*     */         });
/*     */       }
/*     */ 
/*     */       public Object GetData(JTable table, int row_index, int col_index)
/*     */       {
/* 447 */         return table.getModel().getValueAt(row_index, col_index);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.debtor
 * JD-Core Version:    0.6.0
 */