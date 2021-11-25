/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
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
/*     */ 
/*     */ public class editPurchased extends JDialog
/*     */ {
/*  19 */   String ctotal = "0";
/*  20 */   String quantityc = "0";
/*  21 */   Double subtot = Double.valueOf(0.0D);
/*  22 */   String invoice = "";
/*  23 */   String ntotal = "0";
/*  24 */   String cquan = "0";
/*  25 */   String finaltosave = "0";
/*  26 */   String quantity = ""; String dbquan = "";
/*     */   private JTextField code;
/*     */   private JTextField itemnam;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton5;
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JPanel jPanel2;
/*     */   private JTextField pri;
/*     */   private JTextField quan;
/*     */   private JTextField sub;
/*     */ 
/*     */
    private int e;
    private int s;
 public editPurchased(Frame parent, boolean modal)
/*     */   {
/*  31 */     super(parent, modal);
/*  32 */     initComponents();
/*  33 */     setTitle("Edit Item");
/*  34 */     setLocationRelativeTo(null);
/*     */   }
/*     */   public void setFields(String itemcode, String item, String quantity, String price, String inv, String tot) {
/*  37 */     this.code.setText(itemcode);
/*  38 */     this.itemnam.setText(item);
/*  39 */     this.quan.setText(quantity);
/*  40 */     this.pri.setText(price);
/*  41 */     this.ctotal = tot;
/*  42 */     this.ntotal = tot;
/*  43 */     this.quantity = quantity;
/*  44 */     this.subtot = Double.valueOf(Double.parseDouble(price) * Double.parseDouble(quantity));
/*  45 */     this.sub.setText(String.valueOf(this.subtot));
/*  46 */     this.invoice = inv;
/*  47 */     this.quantityc = quantity;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  59 */     this.jPanel2 = new JPanel();
/*  60 */     this.jLabel3 = new JLabel();
/*  61 */     this.jLabel4 = new JLabel();
/*  62 */     this.quan = new JTextField();
/*  63 */     this.pri = new JTextField();
/*  64 */     this.jLabel5 = new JLabel();
/*  65 */     this.jLabel13 = new JLabel();
/*  66 */     this.sub = new JTextField();
/*  67 */     this.jButton5 = new JButton();
/*  68 */     this.itemnam = new JTextField();
/*  69 */     this.jLabel15 = new JLabel();
/*  70 */     this.code = new JTextField();
/*  71 */     this.jButton1 = new JButton();
/*  72 */     this.jButton2 = new JButton();
/*     */ 
/*  74 */     setDefaultCloseOperation(2);
/*     */ 
/*  76 */     this.jPanel2.setBackground(new Color(153, 153, 255));
/*  77 */     this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/*  79 */     this.jLabel3.setText("ITEM CODE:");
/*     */ 
/*  81 */     this.jLabel4.setText("QUANTITY:");
/*     */ 
/*  83 */     this.quan.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  85 */     this.pri.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  86 */     this.pri.addKeyListener(new KeyAdapter() {
/*     */       public void keyReleased(KeyEvent evt) {
/*  88 */         editPurchased.this.priKeyReleased(evt);
/*     */       }
/*     */     });
/*  92 */     this.jLabel5.setText("PURCHASING PRICE:");
/*     */ 
/*  94 */     this.jLabel13.setText("SUBTOTAL:");
/*     */ 
/*  96 */     this.sub.setEditable(false);
/*  97 */     this.sub.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  99 */     this.jButton5.setText("UPDATE ITEM");
/* 100 */     this.jButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 102 */         editPurchased.this.jButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 106 */     this.itemnam.setEditable(false);
/* 107 */     this.itemnam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 109 */     this.jLabel15.setText("ITEM:");
/*     */ 
/* 111 */     this.code.setEditable(false);
/* 112 */     this.code.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 114 */     this.jButton1.setText("DELETE");
/* 115 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 117 */         editPurchased.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 121 */     this.jButton2.setText("EXPIRY DATES");
/* 122 */     this.jButton2.setEnabled(false);
/* 123 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 125 */         editPurchased.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 129 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 130 */     this.jPanel2.setLayout(jPanel2Layout);
/* 131 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 132 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 133 */       .addGroup(jPanel2Layout
/* 133 */       .createSequentialGroup()
/* 134 */       .addGap(20, 20, 20)
/* 135 */       .addGroup(jPanel2Layout
/* 135 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 136 */       .addGroup(jPanel2Layout
/* 136 */       .createSequentialGroup()
/* 137 */       .addGroup(jPanel2Layout
/* 137 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 138 */       .addComponent(this.jLabel4, -2, 64, -2)
/* 139 */       .addComponent(this.jLabel3, -2, 84, -2)
/* 140 */       .addComponent(this.jLabel15))
/* 141 */       .addGap(65, 65, 65)
/* 142 */       .addGroup(jPanel2Layout
/* 142 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 143 */       .addComponent(this.quan)
/* 144 */       .addComponent(this.itemnam)
/* 145 */       .addComponent(this.code, GroupLayout.Alignment.LEADING)))
/* 146 */       .addGroup(jPanel2Layout
/* 146 */       .createSequentialGroup()
/* 147 */       .addGroup(jPanel2Layout
/* 147 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 148 */       .addComponent(this.jLabel5, -2, 138, -2)
/* 149 */       .addComponent(this.jLabel13))
/* 150 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 151 */       .addGroup(jPanel2Layout
/* 151 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 152 */       .addGroup(jPanel2Layout
/* 152 */       .createSequentialGroup()
/* 153 */       .addComponent(this.jButton5)
/* 154 */       .addGap(18, 18, 18)
/* 155 */       .addComponent(this.jButton1)
/* 156 */       .addGap(0, 0, 32767))
/* 157 */       .addComponent(this.sub)
/* 158 */       .addComponent(this.pri))))
/* 159 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 160 */       .addComponent(this.jButton2)
/* 161 */       .addContainerGap()));
/*     */ 
/* 163 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 164 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 165 */       .addGroup(jPanel2Layout
/* 165 */       .createSequentialGroup()
/* 166 */       .addGap(19, 19, 19)
/* 167 */       .addGroup(jPanel2Layout
/* 167 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 168 */       .addComponent(this.jLabel3)
/* 169 */       .addComponent(this.code, -2, -1, -2))
/* 170 */       .addGap(25, 25, 25)
/* 171 */       .addGroup(jPanel2Layout
/* 171 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 172 */       .addComponent(this.itemnam, -2, -1, -2)
/* 173 */       .addComponent(this.jLabel15))
/* 174 */       .addGap(30, 30, 30)
/* 175 */       .addGroup(jPanel2Layout
/* 175 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 176 */       .addComponent(this.jLabel4)
/* 177 */       .addComponent(this.quan, -2, -1, -2))
/* 178 */       .addGap(25, 25, 25)
/* 179 */       .addGroup(jPanel2Layout
/* 179 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 180 */       .addComponent(this.jLabel5)
/* 181 */       .addComponent(this.pri, -2, -1, -2))
/* 182 */       .addGap(35, 35, 35)
/* 183 */       .addGroup(jPanel2Layout
/* 183 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 184 */       .addComponent(this.jLabel13)
/* 185 */       .addComponent(this.sub, -2, -1, -2))
/* 186 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, 32767)
/* 187 */       .addGroup(jPanel2Layout
/* 187 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 188 */       .addComponent(this.jButton5)
/* 189 */       .addComponent(this.jButton1)
/* 190 */       .addComponent(this.jButton2))));
/*     */ 
/* 193 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 194 */     getContentPane().setLayout(layout);
/* 195 */     layout.setHorizontalGroup(layout
/* 196 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 197 */       .addGap(0, 477, 32767)
/* 198 */       .addGroup(layout
/* 198 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 199 */       .addGroup(layout
/* 199 */       .createSequentialGroup()
/* 200 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 201 */       .addGap(0, 0, 32767))));
/*     */ 
/* 203 */     layout.setVerticalGroup(layout
/* 204 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 205 */       .addGap(0, 261, 32767)
/* 206 */       .addGroup(layout
/* 206 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 207 */       .addComponent(this.jPanel2, -1, -1, 32767)));
/*     */ 
/* 210 */     pack();
/*     */   }
/*     */ 
/*     */   private void priKeyReleased(KeyEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton5ActionPerformed(ActionEvent evt)
/*     */   {
/* 219 */     if (this.quan.getText().equals(""))
/*     */     {
/* 221 */       JOptionPane.showMessageDialog(null, "The quantity field is empty ", " Error!", 0);
/*     */     }
/* 223 */     else if (this.pri.getText().equals(""))
/*     */     {
/* 225 */       JOptionPane.showMessageDialog(null, "The Price field is empty ", " Error!", 0);
/*     */     }
/* 227 */     else if (this.code.getText().equals(""))
/*     */     {
/* 229 */       JOptionPane.showMessageDialog(null, "No Item Selected ", " Error!", 0);
/*     */     }
/*     */     else {
/* 232 */       calc();
/* 233 */       searchq();
/* 234 */       add();
/* 235 */       newtotal();
/* 236 */       update();
/*     */ 
/* 248 */       dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 255 */     int y = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm", 0);
/*     */ 
/* 257 */     if (y == 0)
/* 258 */       if (this.code.getText().equals(""))
/*     */       {
/* 260 */         JOptionPane.showMessageDialog(null, "No Item selected", "Error!", 0);
/*     */       } else {
/* 262 */         getQuan();
/* 263 */         Update1();
/* 264 */         updatetotal();
/* 265 */         delete();
/*     */ 
/* 267 */         this.pri.setText("");
/* 268 */         this.quan.setText("");
/* 269 */         this.itemnam.setText("");
/* 270 */         this.sub.setText("");
/* 271 */         dispose();
/*     */       }
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 278 */     expiryDates nn = new expiryDates(new JFrame(), true);
/* 279 */     nn.inv = this.invoice;
/* 280 */     nn.prodid = this.code.getText();
/* 281 */     nn.all = Integer.parseInt(this.quan.getText());
/* 282 */     nn.tablep();
/* 283 */     nn.setVisible(true);
/*     */   }
/*     */ 
/*     */   public void calc() {
/* 287 */     double theprice = Double.parseDouble(this.pri.getText());
/* 288 */     double thequan = Double.parseDouble(this.quan.getText());
/*     */ 
/* 290 */     double finalv = theprice * thequan;
/* 291 */     BigDecimal bd = new BigDecimal(finalv);
/* 292 */     bd = bd.setScale(2, 4);
/*     */ 
/* 294 */     this.sub.setText(String.valueOf(bd));
/*     */   }
/*     */ 
/*     */   public void newtotal()
/*     */   {
/* 301 */     double total = Double.parseDouble(this.ctotal);
/*     */ 
/* 303 */     double newtotal = total + (Double.parseDouble(this.sub.getText()) - this.subtot.doubleValue());
/* 304 */     System.out.println(total + (Double.parseDouble(this.sub.getText()) - this.subtot.doubleValue()) + " otuutut");
/* 305 */     BigDecimal bd = new BigDecimal(newtotal);
/* 306 */     bd = bd.setScale(2, 4);
/* 307 */     this.subtot = Double.valueOf(0.0D);
/*     */ 
/* 310 */     this.ntotal = String.valueOf(bd);
/* 311 */     String str = "update purchasedpaid set amtowed='" + newtotal + "' where invoiceno= '" + this.invoice + "'";
/*     */     try
/*     */     {
/* 320 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 322 */       Statement st = cn.createStatement();
/*     */ 
/* 324 */       int s = st.executeUpdate(str);
/*     */ 
/* 326 */       if (s > 0)
/* 327 */         JOptionPane.showMessageDialog(null, "Saved!", "Done", 1);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 331 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/* 345 */     String tcode = this.code.getText();
/* 346 */     String price = this.pri.getText();
/* 347 */     String quant = this.quan.getText();
/* 348 */     String str = "update purchases set quantity='" + quant + "', price='" + price + "'where itemcode='" + tcode + "'&& code='" + this.invoice + "'";
/*     */     try
/*     */     {
/* 356 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 358 */       Statement st = cn.createStatement();
/*     */ 
/* 360 */       int w = st.executeUpdate(str);
/*     */ 
/* 362 */       if (w <= 0);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 371 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void searchq()
/*     */   {
/* 381 */     String find = this.code.getText();
/* 382 */     System.out.println(find);
/*     */ 
/* 386 */     String sql = "SELECT * FROM stock where Itemcode='" + find + "'";
/*     */     try
/*     */     {
/* 390 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 392 */       Statement st = cn.createStatement();
/* 393 */       ResultSet rs = st.executeQuery(sql);
/* 394 */       while (rs.next()) {
/* 395 */         this.cquan = rs.getString("quantity");
/*     */ 
/* 397 */         System.out.println(this.cquan + "result");
/*     */       }
/* 399 */       cn.close();
/*     */     } catch (Exception exc) {
/* 401 */       exc.printStackTrace();
/* 402 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void add()
/*     */   {
/* 413 */     double adder = Double.parseDouble(this.quan.getText());
/* 414 */     double before = Double.parseDouble(this.cquan);
/* 415 */     double previous = Double.parseDouble(this.quantity);
/* 416 */     double curentquan = before - previous;
/* 417 */     double both = before + (adder - previous);
/* 418 */     this.finaltosave = String.valueOf(both);
/* 419 */     String thcode = this.code.getText();
/* 420 */     String buyingprice = this.pri.getText();
/*     */     try
/*     */     {
/* 425 */       String sql = "update stock set quantity='" + this.finaltosave + "',buyingprice='" + buyingprice + "' where Itemcode='" + thcode + "' && type=0";
/*     */ 
/* 427 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 429 */       Statement st = cn.createStatement();
/*     */ 
/* 432 */       int u = st.executeUpdate(sql);
/* 433 */       if (u > 0)
/*     */       {
/* 435 */         System.out.println("done");
/*     */       }
/*     */     } catch (Exception ex) {
/* 438 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void getQuan()
/*     */   {
/* 445 */     String str = "SELECT quantity from stock where itemcode= '" + this.code.getText() + "'";
/*     */     try
/*     */     {
/* 454 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 456 */       Statement st = cn.createStatement();
/*     */ 
/* 458 */       ResultSet rs = st.executeQuery(str);
/* 459 */       while (rs.next()) {
/* 460 */         this.dbquan = rs.getString(1);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 466 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void Update1()
/*     */   {
/* 474 */     double currquan = Double.parseDouble(this.dbquan);
/* 475 */     double quantitychange = Double.parseDouble(this.quantity);
/* 476 */     double newquan = currquan - quantitychange;
/*     */ 
/* 479 */     String str = "update stock set quantity='" + newquan + "' where itemcode= '" + this.code.getText() + "' && type=0";
/*     */     try
/*     */     {
/* 488 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 490 */       Statement st = cn.createStatement();
/*     */ 
/* 492 */       e = st.executeUpdate(str);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int e;
/* 496 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updatetotal()
/*     */   {
/* 504 */     double total = Double.parseDouble(this.ctotal);
/*     */ 
/* 506 */     double newtotal = total - this.subtot.doubleValue();
/*     */ 
/* 508 */     BigDecimal bd = new BigDecimal(newtotal);
/* 509 */     bd = bd.setScale(2, 4);
/*     */ 
/* 512 */     this.ntotal = String.valueOf(bd);
/* 513 */     String str = "update purchasedpaid set amtowed ='" + bd + "' where invoiceno= '" + this.invoice + "'";
/*     */     try
/*     */     {
/* 522 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 524 */       Statement st = cn.createStatement();
/*     */ 
/* 526 */       s = st.executeUpdate(str);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int s;
/* 530 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete()
/*     */   {
/* 542 */     String tcode = this.code.getText();
/*     */ 
/* 544 */     String str = "Delete from purchases where itemcode='" + tcode + "'&& code='" + this.invoice + "'";
/*     */     try
/*     */     {
/* 552 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 554 */       Statement st = cn.createStatement();
/*     */ 
/* 556 */       int w = st.executeUpdate(str);
/*     */ 
/* 558 */       if (w > 0)
/*     */       {
/* 560 */         JOptionPane.showMessageDialog(null, "Done!", "Success", 1);
/*     */       }
/*     */       else
/*     */       {
/* 564 */         JOptionPane.showMessageDialog(null, "Not Done!", "UnSuccessfull", 0);
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/* 568 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 590 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 591 */         if ("Nimbus".equals(info.getName())) {
/* 592 */           UIManager.setLookAndFeel(info.getClassName());
/* 593 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 597 */       Logger.getLogger(editPurchased.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 599 */       Logger.getLogger(editPurchased.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 601 */       Logger.getLogger(editPurchased.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 603 */       Logger.getLogger(editPurchased.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 610 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 613 */         editPurchased dialog = new editPurchased(new JFrame(), true);
/* 614 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 618 */             System.exit(0);
/*     */           }
/*     */         });
/* 621 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.editPurchased
 * JD-Core Version:    0.6.0
 */