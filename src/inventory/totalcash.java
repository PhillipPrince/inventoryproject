/*     */ package inventory;
/*     */ 
/*     */ import com.mysql.jdbc.Connection;
/*     */ import com.mysql.jdbc.PreparedStatement;
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import com.toedter.calendar.JDayChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
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
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ public class totalcash extends JDialog
/*     */ {
/*  23 */   String url = "jdbc:mysql://localhost:3306/inventory";
/*  24 */   String user = "root";
/*  25 */   String pass = "this";
/*  26 */   Connection con = null;
/*     */   private JTextField cash;
/*     */   private JTextField cred;
/*     */   private JTextField debts;
/*     */   private JTextField exp;
/*     */   private JButton jButton1;
/*     */   private JDateChooser jDateChooser1;
/*     */   private JDayChooser jDayChooser1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JPanel jPanel4;
/*     */   private JTextField sales;
/*     */ 
/*     */   public totalcash(Frame parent, boolean modal)
/*     */   {
/*  31 */     super(parent, modal);
/*  32 */     initComponents();
/*  33 */     setLocationRelativeTo(null);
/*     */     try {
/*  35 */       Class.forName("com.mysql.jdbc.Driver");
/*     */ 
/*  38 */       this.con = ((Connection)DriverManager.getConnection(this.url, this.user, this.pass));
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  52 */     this.jPanel3 = new JPanel();
/*  53 */     this.jDayChooser1 = new JDayChooser();
/*  54 */     this.jPanel1 = new JPanel();
/*  55 */     this.jPanel2 = new JPanel();
/*  56 */     this.jLabel7 = new JLabel();
/*  57 */     this.jPanel4 = new JPanel();
/*  58 */     this.jDateChooser1 = new JDateChooser();
/*  59 */     this.jLabel1 = new JLabel();
/*  60 */     this.jLabel2 = new JLabel();
/*  61 */     this.sales = new JTextField();
/*  62 */     this.jLabel3 = new JLabel();
/*  63 */     this.jLabel4 = new JLabel();
/*  64 */     this.debts = new JTextField();
/*  65 */     this.exp = new JTextField();
/*  66 */     this.jLabel5 = new JLabel();
/*  67 */     this.cred = new JTextField();
/*  68 */     this.jLabel6 = new JLabel();
/*  69 */     this.cash = new JTextField();
/*  70 */     this.jButton1 = new JButton();
/*     */ 
/*  72 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  73 */     this.jPanel3.setLayout(jPanel3Layout);
/*  74 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  75 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  76 */       .addGap(0, 100, 32767));
/*     */ 
/*  78 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  79 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  80 */       .addGap(0, 100, 32767));
/*     */ 
/*  83 */     setDefaultCloseOperation(2);
/*     */ 
/*  85 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  87 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*     */ 
/*  89 */     this.jLabel7.setFont(new Font("Tahoma", 0, 12));
/*  90 */     this.jLabel7.setForeground(new Color(255, 255, 255));
/*  91 */     this.jLabel7.setText("Total Cash In");
/*     */ 
/*  93 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  94 */     this.jPanel2.setLayout(jPanel2Layout);
/*  95 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  96 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  97 */       .addGroup(jPanel2Layout
/*  97 */       .createSequentialGroup()
/*  98 */       .addContainerGap()
/*  99 */       .addComponent(this.jLabel7, -2, 149, -2)
/* 100 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 102 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 103 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 104 */       .addGroup(jPanel2Layout
/* 104 */       .createSequentialGroup()
/* 105 */       .addContainerGap()
/* 106 */       .addComponent(this.jLabel7)
/* 107 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 110 */     this.jPanel4.setBackground(new Color(153, 153, 255));
/* 111 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 113 */     this.jLabel1.setText("SELECT DATE");
/*     */ 
/* 115 */     this.jLabel2.setText("TOTAL SALES:");
/*     */ 
/* 117 */     this.sales.setEditable(false);
/* 118 */     this.sales.setText("0.0");
/* 119 */     this.sales.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 121 */     this.jLabel3.setText("TOTAL EXPENSES:");
/*     */ 
/* 123 */     this.jLabel4.setText("DEBTS PAID:");
/*     */ 
/* 125 */     this.debts.setEditable(false);
/* 126 */     this.debts.setText("0.0");
/* 127 */     this.debts.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 129 */     this.exp.setEditable(false);
/* 130 */     this.exp.setText("0.0");
/* 131 */     this.exp.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 133 */     this.jLabel5.setText("CREDIT PAID:");
/*     */ 
/* 135 */     this.cred.setEditable(false);
/* 136 */     this.cred.setText("0.0");
/* 137 */     this.cred.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 139 */     this.jLabel6.setText("CASH IN:");
/*     */ 
/* 141 */     this.cash.setEditable(false);
/* 142 */     this.cash.setFont(new Font("Tahoma", 1, 11));
/* 143 */     this.cash.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 145 */     this.jButton1.setText("FILL");
/* 146 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 148 */         totalcash.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 152 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 153 */     this.jPanel4.setLayout(jPanel4Layout);
/* 154 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 155 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 156 */       .addGroup(jPanel4Layout
/* 156 */       .createSequentialGroup()
/* 157 */       .addGap(21, 21, 21)
/* 158 */       .addGroup(jPanel4Layout
/* 158 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 159 */       .addComponent(this.jLabel1)
/* 160 */       .addComponent(this.jLabel2)
/* 161 */       .addComponent(this.jLabel4)
/* 162 */       .addComponent(this.jLabel3)
/* 163 */       .addComponent(this.jLabel5)
/* 164 */       .addComponent(this.jLabel6))
/* 165 */       .addGap(33, 33, 33)
/* 166 */       .addGroup(jPanel4Layout
/* 166 */       .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 167 */       .addComponent(this.cred, GroupLayout.Alignment.LEADING)
/* 168 */       .addComponent(this.exp, GroupLayout.Alignment.LEADING)
/* 169 */       .addComponent(this.debts, GroupLayout.Alignment.LEADING)
/* 170 */       .addComponent(this.jDateChooser1, GroupLayout.Alignment.LEADING, -1, 120, 32767)
/* 171 */       .addComponent(this.sales, GroupLayout.Alignment.LEADING)
/* 172 */       .addComponent(this.cash))
/* 173 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 174 */       .addComponent(this.jButton1)
/* 175 */       .addContainerGap(51, 32767)));
/*     */ 
/* 177 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 178 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 179 */       .addGroup(jPanel4Layout
/* 179 */       .createSequentialGroup()
/* 180 */       .addGroup(jPanel4Layout
/* 180 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 181 */       .addGroup(jPanel4Layout
/* 181 */       .createSequentialGroup()
/* 182 */       .addGroup(jPanel4Layout
/* 182 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 183 */       .addComponent(this.jLabel1)
/* 184 */       .addComponent(this.jDateChooser1, -2, -1, -2))
/* 185 */       .addGap(18, 18, 18)
/* 186 */       .addGroup(jPanel4Layout
/* 186 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 187 */       .addComponent(this.jLabel2)
/* 188 */       .addComponent(this.sales, -2, -1, -2))
/* 189 */       .addGap(18, 18, 18)
/* 190 */       .addGroup(jPanel4Layout
/* 190 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 191 */       .addComponent(this.jLabel4)
/* 192 */       .addComponent(this.debts, -2, -1, -2))
/* 193 */       .addGap(18, 18, 18)
/* 194 */       .addGroup(jPanel4Layout
/* 194 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 195 */       .addComponent(this.jLabel3)
/* 196 */       .addComponent(this.exp, -2, -1, -2))
/* 197 */       .addGap(18, 18, 18)
/* 198 */       .addGroup(jPanel4Layout
/* 198 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 199 */       .addComponent(this.jLabel5)
/* 200 */       .addComponent(this.cred, -2, -1, -2))
/* 201 */       .addGap(18, 18, 18)
/* 202 */       .addGroup(jPanel4Layout
/* 202 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 203 */       .addComponent(this.cash, -2, -1, -2)
/* 204 */       .addComponent(this.jLabel6)))
/* 205 */       .addComponent(this.jButton1))
/* 206 */       .addContainerGap(21, 32767)));
/*     */ 
/* 209 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 210 */     this.jPanel1.setLayout(jPanel1Layout);
/* 211 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 212 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 213 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 214 */       .addGroup(jPanel1Layout
/* 214 */       .createSequentialGroup()
/* 215 */       .addContainerGap()
/* 216 */       .addComponent(this.jPanel4, -1, -1, 32767)
/* 217 */       .addContainerGap()));
/*     */ 
/* 219 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 220 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 221 */       .addGroup(jPanel1Layout
/* 221 */       .createSequentialGroup()
/* 222 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 223 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 224 */       .addComponent(this.jPanel4, -2, -1, -2)
/* 225 */       .addGap(0, 14, 32767)));
/*     */ 
/* 228 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 229 */     getContentPane().setLayout(layout);
/* 230 */     layout.setHorizontalGroup(layout
/* 231 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 232 */       .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */ 
/* 234 */     layout.setVerticalGroup(layout
/* 235 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 236 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 239 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 244 */     String b = check();
/*     */ 
/* 246 */     if (b != null) {
/*     */       try
/*     */       {
/* 249 */         totalsales();
/* 250 */         totalexpenses();
/* 251 */         totaldebts();
/* 252 */         totalcreditors();
/* 253 */         cash();
/*     */       }
/*     */       catch (Exception ex) {
/* 256 */         ex.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 262 */       JOptionPane.showMessageDialog(null, "Date is empty", "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void totalsales()
/*     */   {
/* 271 */     this.sales.setText("0.00");
/*     */     try {
/* 273 */       SimpleDateFormat n = new SimpleDateFormat("yyyy-MM-dd");
/* 274 */       Date aa = this.jDateChooser1.getDate();
/* 275 */       String date = n.format(Long.valueOf(aa.getTime()));
/* 276 */       String sql = "select round(sum(amt),2) from sales where date='" + date + "'";
/* 277 */       PreparedStatement st = (PreparedStatement)this.con.prepareStatement(sql);
/* 278 */       ResultSet rs = st.executeQuery();
/* 279 */       if (rs.next()) {
/* 280 */         this.sales.setText(rs.getString(1));
/*     */       }
/*     */       else
/* 283 */         this.sales.setText("0.00");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 287 */       ex.printStackTrace();
/* 288 */       Logger.getLogger(totalcash.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void totaldebts()
/*     */   {
/* 295 */     this.debts.setText("0.00");
/*     */     try {
/* 297 */       SimpleDateFormat n = new SimpleDateFormat("yyyy-MM-dd");
/* 298 */       Date aa = this.jDateChooser1.getDate();
/* 299 */       String date = n.format(Long.valueOf(aa.getTime()));
/* 300 */       String sql = "select round(sum(amtpaid),2) from invoicetransactions where date='" + date + "'";
/* 301 */       PreparedStatement st = (PreparedStatement)this.con.prepareStatement(sql);
/* 302 */       ResultSet rs = st.executeQuery();
/* 303 */       if (rs.next()) {
/* 304 */         this.debts.setText(rs.getString(1));
/*     */       }
/*     */       else
/* 307 */         this.debts.setText("0.00");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 311 */       ex.printStackTrace();
/* 312 */       Logger.getLogger(totalcash.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void totalexpenses()
/*     */   {
/* 319 */     this.exp.setText("0.00");
/*     */     try {
/* 321 */       SimpleDateFormat n = new SimpleDateFormat("yyyy-MM-dd");
/* 322 */       Date aa = this.jDateChooser1.getDate();
/* 323 */       String date = n.format(Long.valueOf(aa.getTime()));
/* 324 */       String sql = "select (0+round(sum(amt),2)) from expenses where date='" + date + "'";
/* 325 */       PreparedStatement st = (PreparedStatement)this.con.prepareStatement(sql);
/* 326 */       ResultSet rs = st.executeQuery();
/* 327 */       if (rs.next()) {
/* 328 */         this.exp.setText(rs.getString(1));
/*     */       }
/*     */       else
/* 331 */         this.exp.setText("0.00");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 335 */       ex.printStackTrace();
/* 336 */       Logger.getLogger(totalcash.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void totalcreditors()
/*     */   {
/* 343 */     this.cred.setText("0.00");
/*     */     try {
/* 345 */       SimpleDateFormat n = new SimpleDateFormat("yyyy-MM-dd");
/* 346 */       Date aa = this.jDateChooser1.getDate();
/* 347 */       String date = n.format(Long.valueOf(aa.getTime()));
/* 348 */       String sql = "select round(sum(amtpaid),2) from trancpurchases where date='" + date + "'";
/* 349 */       PreparedStatement st = (PreparedStatement)this.con.prepareStatement(sql);
/* 350 */       ResultSet rs = st.executeQuery();
/* 351 */       if (rs.next()) {
/* 352 */         this.cred.setText(rs.getString(1));
/*     */       }
/*     */       else
/* 355 */         this.cred.setText("0.00");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 359 */       ex.printStackTrace();
/* 360 */       Logger.getLogger(totalcash.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void cash()
/*     */   {
/* 367 */     double sale = 0.0D;
/* 368 */     double deb = 0.0D;
/* 369 */     double expenses = 0.0D;
/* 370 */     double credt = 0.0D;
/*     */     try {
/* 372 */       sale = Double.parseDouble(this.sales.getText());
/*     */     }
/*     */     catch (Exception e) {
/* 375 */       sale = 0.0D;
/*     */     }
/*     */     try
/*     */     {
/* 379 */       deb = Double.parseDouble(this.debts.getText());
/*     */     }
/*     */     catch (Exception e) {
/* 382 */       deb = 0.0D;
/*     */     }
/*     */     try
/*     */     {
/* 386 */       expenses = Double.parseDouble(this.exp.getText());
/*     */     }
/*     */     catch (Exception e) {
/* 389 */       expenses = 0.0D;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 394 */       credt = Double.parseDouble(this.cred.getText());
/*     */     }
/*     */     catch (Exception e) {
/* 397 */       credt = 0.0D;
/*     */     }
/*     */ 
/* 402 */     double cashin = deb - expenses - credt;
/* 403 */     this.cash.setText(String.valueOf(cashin));
/*     */   }
/*     */   public String check() {
/* 406 */     String ret = null;
/*     */     try
/*     */     {
/* 409 */       SimpleDateFormat n = new SimpleDateFormat("yyyy-MM-dd");
/* 410 */       Date aa = this.jDateChooser1.getDate();
/* 411 */       ret = n.format(Long.valueOf(aa.getTime()));
/*     */     } catch (Exception ex) {
/* 413 */       ret = null;
/* 414 */     }return ret;
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
/* 435 */       Logger.getLogger(totalcash.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 437 */       Logger.getLogger(totalcash.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 439 */       Logger.getLogger(totalcash.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 441 */       Logger.getLogger(totalcash.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 448 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 451 */         totalcash dialog = new totalcash(new JFrame(), true);
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
 * Qualified Name:     inventory.totalcash
 * JD-Core Version:    0.6.0
 */