/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
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
/*     */ public class editsupplier extends JDialog
/*     */ {
/*  17 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  18 */   static String username = "root";
/*  19 */   static String password = "this";
/*  20 */   String id = "";
/*  21 */   String suppnam = "";
/*     */   private JTextField add;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JTextField loc;
/*     */   private JTextField nam;
/*     */   private JTextField phon;
/*     */ 
/*     */
    private int u;
 public editsupplier(Frame parent, boolean modal)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     setTitle("EDIT SUPPLIERS");
/*  29 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */   public void fill(String id, String namef, String location, String address, String phone) {
/*  33 */     this.id = id;
/*  34 */     this.suppnam = namef;
/*  35 */     this.nam.setText(namef);
/*  36 */     this.loc.setText(location);
/*  37 */     this.add.setText(address);
/*  38 */     this.phon.setText(phone);
/*     */   }
/*     */ 
/*     */   public void delete()
/*     */   {
/*  43 */     String myname = this.nam.getText();
/*  44 */     String location = this.loc.getText();
/*     */     try
/*     */     {
/*  47 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/*  48 */       Connection conn = DriverManager.getConnection(url, username, password);
/*  49 */       String sql = "delete from suppliers where name='" + myname + "' && location='" + location + "'";
/*     */ 
/*  51 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*     */ 
/*  55 */       int u = stmt.executeUpdate();
/*  56 */       if (u > 0) {
/*  57 */         JOptionPane.showMessageDialog(this.jPanel1, "DELETED!", "Success!", 1);
/*  58 */         dispose();
/*     */       }
/*     */       else
/*     */       {
/*  64 */         JOptionPane.showMessageDialog(this.jPanel1, "Not done!", "ERROR!", 0);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  73 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  85 */     this.jPanel1 = new JPanel();
/*  86 */     this.jPanel2 = new JPanel();
/*  87 */     this.jPanel3 = new JPanel();
/*  88 */     this.nam = new JTextField();
/*  89 */     this.jLabel1 = new JLabel();
/*  90 */     this.jLabel2 = new JLabel();
/*  91 */     this.jLabel3 = new JLabel();
/*  92 */     this.jLabel4 = new JLabel();
/*  93 */     this.loc = new JTextField();
/*  94 */     this.phon = new JTextField();
/*  95 */     this.add = new JTextField();
/*  96 */     this.jButton2 = new JButton();
/*  97 */     this.jButton1 = new JButton();
/*  98 */     this.jButton3 = new JButton();
/*     */ 
/* 100 */     setDefaultCloseOperation(2);
/*     */ 
/* 102 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/* 104 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*     */ 
/* 106 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 107 */     this.jPanel2.setLayout(jPanel2Layout);
/* 108 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 109 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 110 */       .addGap(0, 400, 32767));
/*     */ 
/* 112 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 113 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 114 */       .addGap(0, 26, 32767));
/*     */ 
/* 117 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/* 118 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 120 */     this.nam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 122 */     this.jLabel1.setText("NAME:");
/*     */ 
/* 124 */     this.jLabel2.setText("LOCATION:");
/*     */ 
/* 126 */     this.jLabel3.setText("PHONE NO:");
/*     */ 
/* 128 */     this.jLabel4.setText("ADDRESS:");
/*     */ 
/* 130 */     this.loc.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 132 */     this.phon.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 134 */     this.add.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 136 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 137 */     this.jPanel3.setLayout(jPanel3Layout);
/* 138 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 139 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 140 */       .addGroup(jPanel3Layout
/* 140 */       .createSequentialGroup()
/* 141 */       .addGap(23, 23, 23)
/* 142 */       .addGroup(jPanel3Layout
/* 142 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 143 */       .addComponent(this.jLabel1)
/* 144 */       .addComponent(this.jLabel2)
/* 145 */       .addComponent(this.jLabel3, -2, 61, -2)
/* 146 */       .addComponent(this.jLabel4))
/* 147 */       .addGap(23, 23, 23)
/* 148 */       .addGroup(jPanel3Layout
/* 148 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 149 */       .addGroup(jPanel3Layout
/* 149 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 150 */       .addComponent(this.nam)
/* 151 */       .addComponent(this.loc, -1, 171, 32767)
/* 152 */       .addComponent(this.phon, -2, 138, -2))
/* 153 */       .addComponent(this.add, -2, 138, -2))
/* 154 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 156 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 157 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 158 */       .addGroup(jPanel3Layout
/* 158 */       .createSequentialGroup()
/* 159 */       .addContainerGap()
/* 160 */       .addGroup(jPanel3Layout
/* 160 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 161 */       .addComponent(this.nam, -2, -1, -2)
/* 162 */       .addComponent(this.jLabel1))
/* 163 */       .addGap(18, 18, 18)
/* 164 */       .addGroup(jPanel3Layout
/* 164 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 165 */       .addComponent(this.jLabel2)
/* 166 */       .addComponent(this.loc, -2, -1, -2))
/* 167 */       .addGap(20, 20, 20)
/* 168 */       .addGroup(jPanel3Layout
/* 168 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 169 */       .addComponent(this.jLabel3)
/* 170 */       .addComponent(this.phon, -2, -1, -2))
/* 171 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, 32767)
/* 172 */       .addGroup(jPanel3Layout
/* 172 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 173 */       .addComponent(this.jLabel4)
/* 174 */       .addComponent(this.add, -2, -1, -2))
/* 175 */       .addGap(24, 24, 24)));
/*     */ 
/* 178 */     this.jButton2.setText("SAVE");
/* 179 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 181 */         editsupplier.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 185 */     this.jButton1.setText("BACK");
/* 186 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 188 */         editsupplier.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 192 */     this.jButton3.setText("DELETE");
/* 193 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 195 */         editsupplier.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 199 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 200 */     this.jPanel1.setLayout(jPanel1Layout);
/* 201 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 202 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 203 */       .addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 204 */       .addGroup(jPanel1Layout
/* 204 */       .createSequentialGroup()
/* 205 */       .addContainerGap()
/* 206 */       .addGroup(jPanel1Layout
/* 206 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 207 */       .addGroup(jPanel1Layout
/* 207 */       .createSequentialGroup()
/* 208 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 209 */       .addContainerGap())
/* 210 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
/* 210 */       .createSequentialGroup()
/* 211 */       .addGap(0, 0, 32767)
/* 212 */       .addComponent(this.jButton2)
/* 213 */       .addGap(35, 35, 35)
/* 214 */       .addComponent(this.jButton3)
/* 215 */       .addGap(36, 36, 36)
/* 216 */       .addComponent(this.jButton1)
/* 217 */       .addGap(17, 17, 17)))));
/*     */ 
/* 219 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 220 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 221 */       .addGroup(jPanel1Layout
/* 221 */       .createSequentialGroup()
/* 222 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 223 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 224 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 225 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 226 */       .addGroup(jPanel1Layout
/* 226 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 227 */       .addComponent(this.jButton2)
/* 228 */       .addComponent(this.jButton1)
/* 229 */       .addComponent(this.jButton3))
/* 230 */       .addGap(0, 19, 32767)));
/*     */ 
/* 233 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 234 */     getContentPane().setLayout(layout);
/* 235 */     layout.setHorizontalGroup(layout
/* 236 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 237 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 239 */     layout.setVerticalGroup(layout
/* 240 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 241 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 244 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 248 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 252 */     save();
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 257 */     int y = 0;
/* 258 */     y = JOptionPane.showConfirmDialog(this.jPanel1, "Do Really You Want to Delete this supplier?", "Confirm!", 0);
/* 259 */     if (y == 0)
/*     */     {
/* 261 */       deleter();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void save()
/*     */   {
/* 267 */     if (this.nam.equals("")) {
/* 268 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, Enter name", "Error!", 0);
/* 269 */       this.nam.requestFocus();
/*     */     }
/* 271 */     else if (this.loc.equals(""))
/*     */     {
/* 273 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, Enter location", "Error!", 0);
/* 274 */       this.loc.requestFocus();
/*     */     }
/* 277 */     else if (this.phon.getText().equals(""))
/*     */     {
/* 279 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, ENTER phone number", "Error!", 0);
/* 280 */       this.phon.requestFocus();
/*     */     }
/* 282 */     else if (this.add.getText().equals(""))
/*     */     {
/* 284 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, ENTER Address", "Error!", 0);
/* 285 */       this.add.requestFocus();
/*     */     }
/*     */     else
/*     */     {
/*     */       try
/*     */       {
/* 292 */         Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 293 */         Connection conn = DriverManager.getConnection(url, username, password);
/* 294 */         String sql = "update suppliers set name='" + this.nam.getText() + "',location='" + this.loc.getText() + "',Address='" + this.add.getText() + "',phone='" + this.phon.getText() + "' where id='" + this.id + "'";
/* 295 */         PreparedStatement stmt = conn.prepareStatement(sql);
/*     */ 
/* 299 */         int u = stmt.executeUpdate();
/* 300 */         if (u > 0)
/*     */         {
/* 302 */           JOptionPane.showMessageDialog(this.jPanel1, "Saved!", "Success!", 1);
/* 303 */           updateOther(this.suppnam);
/* 304 */           updateOther1(this.suppnam);
/* 305 */           this.nam.setText("");
/* 306 */           this.loc.setText("");
/* 307 */           this.add.setText("");
/* 308 */           this.phon.setText("");
/* 309 */           dispose();
/*     */         }
/*     */ 
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 315 */         ex.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateOther(String currsupp)
/*     */   {
/*     */     try
/*     */     {
/* 328 */       delete2();
/* 329 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 330 */       Connection conn = DriverManager.getConnection(url, username, password);
/* 331 */       String sql = "update purchases set supplier='" + this.nam.getText() + "' where supplier='" + currsupp + "' ";
/* 332 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*     */ 
/* 335 */       u = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       int u;
/* 338 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateOther1(String currsupp)
/*     */   {
/*     */     try
/*     */     {
/* 346 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 347 */       Connection conn = DriverManager.getConnection(url, username, password);
/* 348 */       String sql = "update purchasedpaid set supplier='" + this.nam.getText() + "' where supplier='" + currsupp + "'";
/* 349 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*     */ 
/* 353 */       u = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       int u;
/* 356 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   public void delete2() {
/* 364 */     String myname = this.nam.getText();
/* 365 */     String location = this.loc.getText();
/*     */     int u;
/*     */     try {
/* 368 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 369 */       Connection conn = DriverManager.getConnection(url, username, password);
/* 370 */       String sql = "delete from suppliers where name='" + myname + "' && location='" + location + "' id='" + this.id + "'";
/*     */ 
/* 372 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*     */ 
/* 376 */       u = stmt.executeUpdate();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void deleter()
/*     */   {
/* 385 */     if (this.nam.equals("")) {
/* 386 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, Enter name", "Error!", 0);
/* 387 */       this.nam.requestFocus();
/*     */     }
/* 389 */     else if (this.loc.equals(""))
/*     */     {
/* 391 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, Enter location", "Error!", 0);
/* 392 */       this.loc.requestFocus();
/*     */     }
/*     */     else
/*     */     {
/* 400 */       delete();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 419 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 420 */         if ("Nimbus".equals(info.getName())) {
/* 421 */           UIManager.setLookAndFeel(info.getClassName());
/* 422 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 426 */       Logger.getLogger(editsupplier.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 428 */       Logger.getLogger(editsupplier.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 430 */       Logger.getLogger(editsupplier.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 432 */       Logger.getLogger(editsupplier.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 439 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 442 */         editsupplier dialog = new editsupplier(new JFrame(), true);
/* 443 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 447 */             System.exit(0);
/*     */           }
/*     */         });
/* 450 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.editsupplier
 * JD-Core Version:    0.6.0
 */