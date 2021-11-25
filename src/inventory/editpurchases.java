/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
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
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class editpurchases extends JDialog
/*     */ {
/*  20 */   String invoice = null;
/*     */   String quantity;
/*     */   String dbquan;
/*     */   String codb;
/*     */   String purcodecurrentsub;
/*     */   String cquan;
/*     */   double subtot;
/*     */   private JTextField cod;
/*     */   private JTextField itemdes;
/*     */   private JTextField itemnam;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton5;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel16;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel4;
/*     */   private JTextField pri;
/*     */   private JTextField quan;
/*     */   private JTextField sub;
/*     */   private JTextField tot;
/*     */ 
/*     */
    private int e;
    private double p;
    private int s;
 public editpurchases(Frame parent, boolean modal)
/*     */   {
/*  28 */     super(parent, modal);
/*  29 */     setLocationRelativeTo(null);
/*  30 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  42 */     this.jPanel1 = new JPanel();
/*  43 */     this.jPanel2 = new JPanel();
/*  44 */     this.jPanel4 = new JPanel();
/*  45 */     this.jLabel3 = new JLabel();
/*  46 */     this.cod = new JTextField();
/*  47 */     this.jLabel4 = new JLabel();
/*  48 */     this.quan = new JTextField();
/*  49 */     this.pri = new JTextField();
/*  50 */     this.jLabel5 = new JLabel();
/*  51 */     this.jLabel13 = new JLabel();
/*  52 */     this.sub = new JTextField();
/*  53 */     this.jButton5 = new JButton();
/*  54 */     this.itemnam = new JTextField();
/*  55 */     this.jLabel15 = new JLabel();
/*  56 */     this.jLabel16 = new JLabel();
/*  57 */     this.itemdes = new JTextField();
/*  58 */     this.jButton1 = new JButton();
/*  59 */     this.jButton2 = new JButton();
/*  60 */     this.jLabel1 = new JLabel();
/*  61 */     this.tot = new JTextField();
/*  62 */     this.jButton3 = new JButton();
/*     */ 
/*  64 */     setDefaultCloseOperation(2);
/*     */ 
/*  66 */     this.jPanel1.setBackground(new Color(204, 204, 204));
/*     */ 
/*  68 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  69 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/*  71 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  72 */     this.jPanel2.setLayout(jPanel2Layout);
/*  73 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  74 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  75 */       .addGap(0, 0, 32767));
/*     */ 
/*  77 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  78 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  79 */       .addGap(0, 27, 32767));
/*     */ 
/*  82 */     this.jPanel4.setBackground(new Color(204, 204, 204));
/*  83 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/*  85 */     this.jLabel3.setText("ITEM CODE:");
/*     */ 
/*  87 */     this.cod.setEditable(false);
/*  88 */     this.cod.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  89 */     this.cod.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  91 */         editpurchases.this.codActionPerformed(evt);
/*     */       }
/*     */     });
/*  94 */     this.cod.addKeyListener(new KeyAdapter() {
/*     */       public void keyReleased(KeyEvent evt) {
/*  96 */         editpurchases.this.codKeyReleased(evt);
/*     */       }
/*     */     });
/* 100 */     this.jLabel4.setText("QUANTITY:");
/*     */ 
/* 102 */     this.quan.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 104 */     this.pri.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 105 */     this.pri.addKeyListener(new KeyAdapter() {
/*     */       public void keyReleased(KeyEvent evt) {
/* 107 */         editpurchases.this.priKeyReleased(evt);
/*     */       }
/*     */     });
/* 111 */     this.jLabel5.setText("PURCHASING PRICE:");
/*     */ 
/* 113 */     this.jLabel13.setText("SUBTOTAL:");
/*     */ 
/* 115 */     this.sub.setEditable(false);
/* 116 */     this.sub.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 118 */     this.jButton5.setText("CALC");
/* 119 */     this.jButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 121 */         editpurchases.this.jButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 125 */     this.itemnam.setEditable(false);
/* 126 */     this.itemnam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 128 */     this.jLabel15.setText("ITEM:");
/*     */ 
/* 130 */     this.jLabel16.setText("DESCRIPTION:");
/*     */ 
/* 132 */     this.itemdes.setEditable(false);
/* 133 */     this.itemdes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 135 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 136 */     this.jPanel4.setLayout(jPanel4Layout);
/* 137 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 138 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 139 */       .addGroup(jPanel4Layout
/* 139 */       .createSequentialGroup()
/* 140 */       .addGap(20, 20, 20)
/* 141 */       .addGroup(jPanel4Layout
/* 141 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 142 */       .addComponent(this.jLabel4, -2, 64, -2)
/* 143 */       .addComponent(this.jLabel3, -2, 84, -2)
/* 144 */       .addComponent(this.jLabel13)
/* 145 */       .addComponent(this.jLabel15)
/* 146 */       .addComponent(this.jLabel16)
/* 147 */       .addComponent(this.jLabel5, -2, 145, -2))
/* 148 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 149 */       .addGroup(jPanel4Layout
/* 149 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 150 */       .addGroup(jPanel4Layout
/* 150 */       .createSequentialGroup()
/* 151 */       .addGroup(jPanel4Layout
/* 151 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 152 */       .addComponent(this.sub)
/* 153 */       .addComponent(this.quan)
/* 154 */       .addComponent(this.itemdes)
/* 155 */       .addComponent(this.itemnam, -1, 148, 32767)
/* 156 */       .addComponent(this.cod))
/* 157 */       .addGap(36, 36, 36)
/* 158 */       .addComponent(this.jButton5))
/* 159 */       .addComponent(this.pri, -2, 148, -2))
/* 160 */       .addContainerGap()));
/*     */ 
/* 162 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 163 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 164 */       .addGroup(jPanel4Layout
/* 164 */       .createSequentialGroup()
/* 165 */       .addGap(12, 12, 12)
/* 166 */       .addGroup(jPanel4Layout
/* 166 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 167 */       .addComponent(this.jLabel3)
/* 168 */       .addComponent(this.cod, -2, -1, -2))
/* 169 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, 32767)
/* 170 */       .addGroup(jPanel4Layout
/* 170 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 171 */       .addComponent(this.jLabel15)
/* 172 */       .addComponent(this.itemnam, -2, -1, -2))
/* 173 */       .addGap(28, 28, 28)
/* 174 */       .addGroup(jPanel4Layout
/* 174 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 175 */       .addComponent(this.jLabel16)
/* 176 */       .addComponent(this.itemdes, -2, -1, -2))
/* 177 */       .addGap(29, 29, 29)
/* 178 */       .addGroup(jPanel4Layout
/* 178 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 179 */       .addComponent(this.jLabel4)
/* 180 */       .addComponent(this.quan, -2, -1, -2))
/* 181 */       .addGap(27, 27, 27)
/* 182 */       .addGroup(jPanel4Layout
/* 182 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 183 */       .addComponent(this.jLabel5)
/* 184 */       .addComponent(this.pri, -2, -1, -2))
/* 185 */       .addGap(27, 27, 27)
/* 186 */       .addGroup(jPanel4Layout
/* 186 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 187 */       .addComponent(this.jLabel13)
/* 188 */       .addComponent(this.sub, -2, -1, -2)
/* 189 */       .addComponent(this.jButton5))
/* 190 */       .addGap(31, 31, 31)));
/*     */ 
/* 193 */     this.jButton1.setText("DELETE");
/* 194 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 196 */         editpurchases.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 200 */     this.jButton2.setText("SAVE");
/* 201 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 203 */         editpurchases.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 207 */     this.jLabel1.setFont(new Font("Tahoma", 1, 11));
/* 208 */     this.jLabel1.setText("TOTAL");
/*     */ 
/* 210 */     this.tot.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 212 */     this.jButton3.setText("BACK");
/* 213 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 215 */         editpurchases.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 219 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 220 */     this.jPanel1.setLayout(jPanel1Layout);
/* 221 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 222 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 223 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 224 */       .addGroup(jPanel1Layout
/* 224 */       .createSequentialGroup()
/* 225 */       .addContainerGap()
/* 226 */       .addComponent(this.jPanel4, -2, -1, -2)
/* 227 */       .addGap(18, 18, 18)
/* 228 */       .addComponent(this.jLabel1)
/* 229 */       .addGap(18, 18, 18)
/* 230 */       .addComponent(this.tot)
/* 231 */       .addContainerGap())
/* 232 */       .addGroup(jPanel1Layout
/* 232 */       .createSequentialGroup()
/* 233 */       .addGap(203, 203, 203)
/* 234 */       .addComponent(this.jButton1)
/* 235 */       .addGap(90, 90, 90)
/* 236 */       .addComponent(this.jButton2)
/* 237 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, 32767)
/* 238 */       .addComponent(this.jButton3)
/* 239 */       .addGap(50, 50, 50)));
/*     */ 
/* 241 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 242 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 243 */       .addGroup(jPanel1Layout
/* 243 */       .createSequentialGroup()
/* 244 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 245 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 246 */       .addGroup(jPanel1Layout
/* 246 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 247 */       .addGroup(jPanel1Layout
/* 247 */       .createSequentialGroup()
/* 248 */       .addComponent(this.jPanel4, -2, -1, -2)
/* 249 */       .addGap(18, 18, 18)
/* 250 */       .addGroup(jPanel1Layout
/* 250 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 251 */       .addComponent(this.jButton1)
/* 252 */       .addComponent(this.jButton2)
/* 253 */       .addComponent(this.jButton3))
/* 254 */       .addGap(0, 38, 32767))
/* 255 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
/* 255 */       .createSequentialGroup()
/* 256 */       .addGap(0, 0, 32767)
/* 257 */       .addGroup(jPanel1Layout
/* 257 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 258 */       .addComponent(this.jLabel1)
/* 259 */       .addComponent(this.tot, -2, -1, -2))
/* 260 */       .addGap(91, 91, 91)))));
/*     */ 
/* 263 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 264 */     getContentPane().setLayout(layout);
/* 265 */     layout.setHorizontalGroup(layout
/* 266 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 267 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 269 */     layout.setVerticalGroup(layout
/* 270 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 271 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 274 */     pack();
/*     */   }
/*     */ 
/*     */   private void codActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void codKeyReleased(KeyEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void priKeyReleased(KeyEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton5ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 296 */     int y = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm", 0);
/*     */ 
/* 298 */     if (y == 0)
/*     */     {
/* 300 */       getQuan();
/* 301 */       Update();
/* 302 */       updatetotal();
/* 303 */       delete();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 312 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void fill(String itemcode, String itemname, String itemde, String itemquan, String bprice, String tinvoice, String totalAll)
/*     */   {
/* 323 */     this.invoice = tinvoice;
/*     */ 
/* 325 */     this.codb = itemcode;
/* 326 */     this.quantity = itemquan;
/* 327 */     double quanval = Double.parseDouble(this.quantity);
/* 328 */     this.subtot = (quanval * Double.parseDouble(bprice));
/* 329 */     this.sub.setText(String.valueOf(this.subtot));
/* 330 */     this.cod.setText(itemcode);
/* 331 */     this.itemnam.setText(itemname);
/* 332 */     this.itemdes.setText(itemde);
/* 333 */     this.quan.setText(itemquan);
/* 334 */     this.pri.setText(bprice);
/* 335 */     this.tot.setText(totalAll);
/*     */   }
/*     */   public void delete() {
/* 338 */     String tcode = this.cod.getText();
/*     */ 
/* 340 */     String str = "Delete from purchases where itemcode='" + tcode + "'&& code='" + this.invoice + "'";
/*     */     try
/*     */     {
/* 348 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 350 */       Statement st = cn.createStatement();
/*     */ 
/* 352 */       int w = st.executeUpdate(str);
/*     */ 
/* 354 */       if (w > 0)
/*     */       {
/* 356 */         JOptionPane.showMessageDialog(this.jPanel1, "Done!", "Success", 1);
/*     */       }
/*     */       else
/* 359 */         JOptionPane.showMessageDialog(this.jPanel1, "Not Done!", "UnSuccessfull", 0);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 363 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void change()
/*     */   {
/* 372 */     double totalchange = Double.parseDouble(this.tot.getText()) - this.subtot;
/* 373 */     this.tot.setText(String.valueOf(totalchange));
/*     */   }
/*     */ 
/*     */   public void getQuan()
/*     */   {
/* 382 */     String str = "SELECT quantity from stock where itemcode= '" + this.codb + "'";
/*     */     try
/*     */     {
/* 391 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 393 */       Statement st = cn.createStatement();
/*     */ 
/* 395 */       ResultSet rs = st.executeQuery(str);
/* 396 */       while (rs.next()) {
/* 397 */         this.dbquan = rs.getString(1);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 403 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void Update()
/*     */   {
/* 411 */     double currquan = Double.parseDouble(this.dbquan);
/* 412 */     double quantitychange = Double.parseDouble(this.quantity);
/* 413 */     double newquan = currquan - quantitychange;
/*     */ 
/* 416 */     String str = "update stock set quantity='" + newquan + "' where itemcode= '" + this.codb + "'";
/*     */     try
/*     */     {
/* 425 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 427 */       Statement st = cn.createStatement();
/*     */ 
/* 429 */       e = st.executeUpdate(str);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int e;
/* 433 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updatetotal()
/*     */   {
/* 441 */     double total = Double.parseDouble(this.tot.getText());
/*     */ 
/* 443 */     double newtotal = total - this.subtot;
/*     */ 
/* 445 */     BigDecimal bd = new BigDecimal(newtotal);
/* 446 */     bd = bd.setScale(2, 4);
/*     */ 
/* 450 */     String str = "update purchasedpaid set amtowed ='" + bd + "' where invoiceno= '" + this.invoice + "'";
/*     */     try
/*     */     {
/* 459 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 461 */       Statement st = cn.createStatement();
/*     */ 
/* 463 */       s = st.executeUpdate(str);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 467 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void validat2()
/*     */   {
/* 479 */     double q = 0.0D;
/*     */     try
/*     */     {
/* 484 */       q = Double.parseDouble(this.quan.getText());
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 487 */       this.quan.setText("");
/* 488 */       this.quan.requestFocus();
/*     */     }
/*     */     try
/*     */     {
/* 492 */       p = Double.parseDouble(this.pri.getText());
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*     */       double p;
/* 495 */       this.pri.setText("");
/* 496 */       this.pri.requestFocus();
/*     */     }
/*     */ 
/* 502 */     if (this.cod.getText().equals("")) {
/* 503 */       this.cod.requestFocus();
/* 504 */       JOptionPane.showMessageDialog(this.jPanel1, "Please Enter item code", "Warning!", 0);
/*     */     }
/* 509 */     else if ((this.quan.getText().equals("")) && (q <= 0.0D)) {
/* 510 */       this.quan.requestFocus();
/* 511 */       JOptionPane.showMessageDialog(this.jPanel1, "Please Enter quantity", "Warning!", 0);
/*     */     }
/* 515 */     else if (this.pri.getText().equals("")) {
/* 516 */       this.pri.requestFocus();
/* 517 */       JOptionPane.showMessageDialog(this.jPanel1, "Please Enter price", "Warning!", 0);
/*     */     }
/*     */     else
/*     */     {
/* 523 */       calc();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void calc()
/*     */   {
/* 530 */     double theprice = Double.parseDouble(this.pri.getText());
/* 531 */     double thequan = Double.parseDouble(this.quan.getText());
/*     */ 
/* 533 */     double finalv = theprice * thequan;
/* 534 */     BigDecimal bd = new BigDecimal(finalv);
/* 535 */     bd = bd.setScale(2, 4);
/*     */ 
/* 537 */     this.sub.setText(String.valueOf(bd));
/*     */   }
/*     */ 
/*     */   public void validater()
/*     */   {
/* 544 */     double q = 0.0D;
/*     */     try
/*     */     {
/* 547 */       q = Double.parseDouble(this.quan.getText());
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 550 */       this.quan.setText("");
/* 551 */       this.quan.requestFocus();
/*     */     }
/*     */     try
/*     */     {
/* 555 */       p = Double.parseDouble(this.pri.getText());
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*     */       double p;
/* 558 */       this.pri.setText("");
/* 559 */       this.pri.requestFocus();
/*     */     }
/*     */ 
/* 568 */     if ((this.quan.getText().equals("")) && (q <= 0.0D)) {
/* 569 */       this.quan.requestFocus();
/* 570 */       JOptionPane.showMessageDialog(this.jPanel1, "Please Enter quantity", "Warning!", 0);
/*     */     }
/* 573 */     else if (this.pri.getText().equals("")) {
/* 574 */       this.pri.requestFocus();
/* 575 */       JOptionPane.showMessageDialog(this.jPanel1, "Please Enter price", "Warning!", 0);
/*     */     }
/*     */     else
/*     */     {
/* 580 */       searchq();
/* 581 */       add();
/* 582 */       newtotal();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void add()
/*     */   {
/* 588 */     double adder = Double.parseDouble(this.quan.getText());
/* 589 */     double before = Double.parseDouble(this.cquan);
/* 590 */     double previous = Double.parseDouble(this.quantity);
/* 591 */     double curentquan = before - previous;
/* 592 */     double both = adder + curentquan;
/* 593 */     String finaltosave = String.valueOf(both);
/* 594 */     String thcode = this.cod.getText();
/*     */     try
/*     */     {
/* 600 */       String sql = "update stock set quantity='" + finaltosave + "' where Itemcode='" + thcode + "'";
/*     */ 
/* 602 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 604 */       Statement st = cn.createStatement();
/*     */ 
/* 607 */       int u = st.executeUpdate(sql);
/* 608 */       if (u > 0)
/*     */       {
/* 610 */         System.out.println("done");
/*     */       }
/*     */     } catch (Exception ex) {
/* 613 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void searchq() {
/* 618 */     String find = this.cod.getText();
/* 619 */     System.out.println(find);
/*     */ 
/* 623 */     String sql = "SELECT * FROM stock where Itemcode='" + find + "'";
/*     */     try
/*     */     {
/* 627 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 629 */       Statement st = cn.createStatement();
/* 630 */       ResultSet rs = st.executeQuery(sql);
/* 631 */       while (rs.next()) {
/* 632 */         this.cquan = rs.getString("quantity");
/*     */ 
/* 634 */         System.out.println(this.cquan + "result");
/*     */       }
/* 636 */       cn.close();
/*     */     } catch (Exception exc) {
/* 638 */       exc.printStackTrace();
/* 639 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void newtotal()
/*     */   {
/* 651 */     double total = Double.parseDouble(this.tot.getText());
/*     */ 
/* 653 */     double newtotal = total - this.subtot + Double.parseDouble(this.sub.getText());
/*     */ 
/* 655 */     BigDecimal bd = new BigDecimal(newtotal);
/* 656 */     bd = bd.setScale(2, 4);
/*     */ 
/* 660 */     String str = "update purchasedpaid set amtowed ='" + bd + "' where invoiceno= '" + this.invoice + "'";
/*     */     try
/*     */     {
/* 669 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 671 */       Statement st = cn.createStatement();
/*     */ 
/* 673 */       s = st.executeUpdate(str);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 677 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 702 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 703 */         if ("Nimbus".equals(info.getName())) {
/* 704 */           UIManager.setLookAndFeel(info.getClassName());
/* 705 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 709 */       Logger.getLogger(editpurchases.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 711 */       Logger.getLogger(editpurchases.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 713 */       Logger.getLogger(editpurchases.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 715 */       Logger.getLogger(editpurchases.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 722 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 725 */         editpurchases dialog = new editpurchases(new JFrame(), true);
/* 726 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 730 */             System.exit(0);
/*     */           }
/*     */         });
/* 733 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.editpurchases
 * JD-Core Version:    0.6.0
 */