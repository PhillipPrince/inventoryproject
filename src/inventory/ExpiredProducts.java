/*     */ package inventory;
/*     */ 
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
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
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class ExpiredProducts extends JDialog
/*     */ {
/*  26 */   SimpleDateFormat form = new SimpleDateFormat("yyy-MM-dd");
/*  27 */   DBConnection nn = new DBConnection();
/*  28 */   Connection conn = this.nn.getDBConnection();
/*     */   JTable table;
/*  30 */   String ip = "localhost";
/*  31 */   String[][] list = (String[][])null;
/*  32 */   String start = "";
/*  33 */   String end = "";
/*     */   private JButton jButton1;
/*     */   private JDateChooser jDateChooser2;
/*     */   private JDateChooser jDateChooser3;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */ 
/*     */   public ExpiredProducts(Frame parent, boolean modal)
/*     */   {
/*  38 */     super(parent, modal);
/*  39 */     initComponents();
/*  40 */     setLocationRelativeTo(null);
/*  41 */     tablep();
/*     */   }
/*     */ 
/*     */   public void date()
/*     */   {
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  59 */     this.jPanel1 = new JPanel();
/*  60 */     this.jPanel2 = new JPanel();
/*  61 */     this.jLabel1 = new JLabel();
/*  62 */     this.jPanel3 = new JPanel();
/*  63 */     this.jLabel2 = new JLabel();
/*  64 */     this.jLabel3 = new JLabel();
/*  65 */     this.jDateChooser2 = new JDateChooser();
/*  66 */     this.jDateChooser3 = new JDateChooser();
/*  67 */     this.jButton1 = new JButton();
/*     */ 
/*  69 */     setDefaultCloseOperation(2);
/*     */ 
/*  71 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*  72 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*     */ 
/*  74 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  75 */     this.jPanel2.setBorder(BorderFactory.createBevelBorder(0));
/*     */ 
/*  77 */     this.jLabel1.setFont(new Font("Arial Rounded MT Bold", 0, 11));
/*  78 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/*  79 */     this.jLabel1.setText("EXPIRED PRODUCTS");
/*     */ 
/*  81 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  82 */     this.jPanel2.setLayout(jPanel2Layout);
/*  83 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  84 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  85 */       .addGroup(jPanel2Layout
/*  85 */       .createSequentialGroup()
/*  86 */       .addContainerGap()
/*  87 */       .addComponent(this.jLabel1)
/*  88 */       .addContainerGap(455, 32767)));
/*     */ 
/*  90 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  91 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  92 */       .addGroup(jPanel2Layout
/*  92 */       .createSequentialGroup()
/*  93 */       .addContainerGap()
/*  94 */       .addComponent(this.jLabel1)
/*  95 */       .addContainerGap(-1, 32767)));
/*     */ 
/*  98 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/*  99 */     this.jPanel3.setBorder(BorderFactory.createBevelBorder(1));
/*     */ 
/* 101 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 102 */     this.jPanel3.setLayout(jPanel3Layout);
/* 103 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 104 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 105 */       .addGap(0, 557, 32767));
/*     */ 
/* 107 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 108 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 109 */       .addGap(0, 221, 32767));
/*     */ 
/* 112 */     this.jLabel2.setText("StartDate");
/*     */ 
/* 114 */     this.jLabel3.setText("End Date:");
/*     */ 
/* 116 */     this.jButton1.setText("Find");
/* 117 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 119 */         ExpiredProducts.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 123 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 124 */     this.jPanel1.setLayout(jPanel1Layout);
/* 125 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 126 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 127 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 128 */       .addGroup(jPanel1Layout
/* 128 */       .createSequentialGroup()
/* 129 */       .addGroup(jPanel1Layout
/* 129 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 130 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
/* 130 */       .createSequentialGroup()
/* 131 */       .addContainerGap()
/* 132 */       .addComponent(this.jPanel3, -1, -1, 32767))
/* 133 */       .addGroup(jPanel1Layout
/* 133 */       .createSequentialGroup()
/* 134 */       .addGap(19, 19, 19)
/* 135 */       .addComponent(this.jLabel2)
/* 136 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 137 */       .addComponent(this.jDateChooser2, -2, 148, -2)
/* 138 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 139 */       .addComponent(this.jLabel3)
/* 140 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 141 */       .addComponent(this.jDateChooser3, -2, 148, -2)
/* 142 */       .addGap(18, 18, 18)
/* 143 */       .addComponent(this.jButton1)
/* 144 */       .addGap(0, 0, 32767)))
/* 145 */       .addContainerGap()));
/*     */ 
/* 147 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 148 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 149 */       .addGroup(jPanel1Layout
/* 149 */       .createSequentialGroup()
/* 150 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 151 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 152 */       .addGroup(jPanel1Layout
/* 152 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 153 */       .addGroup(jPanel1Layout
/* 153 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 154 */       .addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING)
/* 155 */       .addComponent(this.jLabel2))
/* 156 */       .addComponent(this.jDateChooser2, -2, -1, -2)
/* 157 */       .addComponent(this.jDateChooser3, -2, -1, -2)
/* 158 */       .addComponent(this.jButton1))
/* 159 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 160 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 161 */       .addGap(10, 10, 10)));
/*     */ 
/* 164 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 165 */     getContentPane().setLayout(layout);
/* 166 */     layout.setHorizontalGroup(layout
/* 167 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 168 */       .addGroup(layout
/* 168 */       .createSequentialGroup()
/* 169 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 170 */       .addGap(0, 1, 32767)));
/*     */ 
/* 172 */     layout.setVerticalGroup(layout
/* 173 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 174 */       .addGroup(layout
/* 174 */       .createSequentialGroup()
/* 175 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 176 */       .addGap(0, 0, 32767)));
/*     */ 
/* 179 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 183 */     update();
/*     */   }
/*     */ 
/*     */   public void tablep()
/*     */   {
/* 190 */     String[] headers = { "Prod Id", "Name", "BatchNo", "InvoiceNo", "Expiry Date" };
/*     */ 
/* 194 */     this.list = getDatap();
/*     */ 
/* 196 */     DefaultTableModel model = new DefaultTableModel(this.list, headers);
/* 197 */     this.table = new JTable(model);
/*     */ 
/* 200 */     JScrollPane scrollPane = new JScrollPane(this.table);
/* 201 */     this.table.setFillsViewportHeight(true);
/* 202 */     this.jPanel3.add(scrollPane, "Center");
/* 203 */     scrollPane.setBounds(0, 0, 560, 225);
/* 204 */     this.table.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e) {
/* 207 */         int row = ExpiredProducts.this.table.getSelectedRow();
/* 208 */         String batch = ExpiredProducts.this.list[row][2];
/* 209 */         String pid = ExpiredProducts.this.list[row][0];
/* 210 */         String pname = ExpiredProducts.this.list[row][1];
/* 211 */         String exp = ExpiredProducts.this.list[row][4];
/* 212 */         viewProduct nn = new viewProduct(new JFrame(), true);
/*     */ 
/* 214 */         nn.setValues(batch, pid, pname, exp);
/*     */ 
/* 216 */         nn.setVisible(true);
/* 217 */         ExpiredProducts.this.update();
/* 218 */         ExpiredProducts.this.list = ExpiredProducts.this.getDatap();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public String[][] getDatap()
/*     */   {
/* 227 */     String first = "";
/* 228 */     String last = "";
/*     */     try
/*     */     {
/* 231 */       SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
/* 232 */       first = form.format(this.jDateChooser2.getDate());
/* 233 */       last = form.format(this.jDateChooser3.getDate());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 237 */       first = "";
/* 238 */       last = "";
/*     */     }
/*     */ 
/* 243 */     Calendar cal = Calendar.getInstance();
/*     */ 
/* 245 */     cal.add(5, Integer.parseInt(find().toString()));
/* 246 */     String[][] sample = (String[][])null;
/*     */ 
/* 248 */     if ((first.equals("")) || (last.equals("")))
/*     */     {
/* 250 */       String sql = "SELECT a.prodid,b.name,a.batchno,a.invoiceno,a.date from expirydate a,stock b where b.Itemcode=a.prodid && date<='" + this.form.format(cal.getTime()) + "' && sold='0' ";
/*     */       try
/*     */       {
/* 260 */         Connection con = this.nn.getDBConnection();
/* 261 */         PreparedStatement st = con.prepareStatement(sql);
/* 262 */         ResultSet rs = st.executeQuery();
/*     */ 
/* 265 */         if (rs.next()) {
/* 266 */           rs.last();
/*     */ 
/* 268 */           sample = new String[rs.getRow()][5];
/* 269 */           rs.beforeFirst();
/*     */         }
/* 271 */         int rowcount = 0;
/*     */ 
/* 273 */         while (rs.next())
/*     */         {
/* 275 */           sample[rowcount][0] = rs.getString(1);
/* 276 */           sample[rowcount][1] = rs.getString(2);
/* 277 */           sample[rowcount][2] = rs.getString(3);
/* 278 */           sample[rowcount][3] = rs.getString(4);
/* 279 */           sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 286 */           rowcount++;
/*     */         }
/*     */ 
/* 289 */         rs.close();
/* 290 */         con.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 294 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 299 */       String sql = "SELECT a.prodid,b.name,a.batchno,a.invoiceno,a.date from expirydate a,stock b where b.Itemcode=a.prodid && sold='0' && date>='" + first + "' && date<='" + last + "'";
/*     */ 
/* 303 */       sample = (String[][])null;
/*     */       try
/*     */       {
/* 309 */         Connection con = this.nn.getDBConnection();
/* 310 */         PreparedStatement st = con.prepareStatement(sql);
/* 311 */         ResultSet rs = st.executeQuery();
/*     */ 
/* 314 */         if (rs.next()) {
/* 315 */           rs.last();
/*     */ 
/* 317 */           sample = new String[rs.getRow()][5];
/* 318 */           rs.beforeFirst();
/*     */         }
/* 320 */         int rowcount = 0;
/*     */ 
/* 322 */         while (rs.next())
/*     */         {
/* 324 */           sample[rowcount][0] = rs.getString(1);
/* 325 */           sample[rowcount][1] = rs.getString(2);
/* 326 */           sample[rowcount][2] = rs.getString(3);
/* 327 */           sample[rowcount][3] = rs.getString(4);
/* 328 */           sample[rowcount][4] = rs.getString(5);
/*     */ 
/* 335 */           rowcount++;
/*     */         }
/*     */ 
/* 338 */         rs.close();
/* 339 */         con.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 343 */         e.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 349 */     return sample;
/*     */   }
/*     */ 
/*     */   public void update() {
/* 353 */     String[] headers = { "Prod Id", "Name", "BatchNo", "InvoiceNo", "Expiry Date" };
/*     */ 
/* 357 */     this.list = getDatap();
/*     */ 
/* 359 */     DefaultTableModel model = new DefaultTableModel(this.list, headers);
/* 360 */     this.table.setModel(model);
/*     */   }
/*     */ 
/*     */   public Integer find()
/*     */   {
/* 365 */     int doub = 0;
/*     */ 
/* 367 */     BigDecimal bd = null;
/*     */     try
/*     */     {
/* 372 */       String sql = "select days,Weeks,months from  expirydatesetting ";
/* 373 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/* 374 */       ResultSet rs = stmt.executeQuery();
/* 375 */       while (rs.next()) {
/* 376 */         Double doub1 = Double.valueOf(rs.getDouble(1) + rs.getDouble(2) * 7.0D + rs.getDouble(3) * 31.0D);
/* 377 */         bd = new BigDecimal(doub1.doubleValue());
/* 378 */         bd = bd.setScale(0, 4);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception exc)
/*     */     {
/* 385 */       System.out.println("process error" + exc);
/*     */     }
/*     */ 
/* 391 */     return Integer.valueOf(Integer.parseInt(String.valueOf(bd)));
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 407 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 408 */         if ("Nimbus".equals(info.getName())) {
/* 409 */           UIManager.setLookAndFeel(info.getClassName());
/* 410 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 414 */       Logger.getLogger(ExpiredProducts.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 416 */       Logger.getLogger(ExpiredProducts.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 418 */       Logger.getLogger(ExpiredProducts.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 420 */       Logger.getLogger(ExpiredProducts.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 427 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 430 */         ExpiredProducts dialog = new ExpiredProducts(new JFrame(), true);
/* 431 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 435 */             System.exit(0);
/*     */           }
/*     */         });
/* 438 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.ExpiredProducts
 * JD-Core Version:    0.6.0
 */