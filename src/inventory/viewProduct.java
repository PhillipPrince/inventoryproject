/*     */ package inventory;
/*     */ 
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
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
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
/*     */ public class viewProduct extends JDialog
/*     */ {
/*     */   private JTextField exp;
/*     */   private JButton jButton2;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel8;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JTextField nam;
/*     */   private JTextField prodid;
/*     */   private JTextField prodname;
/*     */ 
/*     */   public viewProduct(Frame parent, boolean modal)
/*     */   {
/*  22 */     super(parent, modal);
/*  23 */     initComponents();
/*  24 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  36 */     this.jPanel1 = new JPanel();
/*  37 */     this.jPanel2 = new JPanel();
/*  38 */     this.jLabel3 = new JLabel();
/*  39 */     this.jPanel3 = new JPanel();
/*  40 */     this.nam = new JTextField();
/*  41 */     this.jLabel1 = new JLabel();
/*  42 */     this.jLabel2 = new JLabel();
/*  43 */     this.jLabel4 = new JLabel();
/*  44 */     this.jLabel8 = new JLabel();
/*  45 */     this.prodid = new JTextField();
/*  46 */     this.prodname = new JTextField();
/*  47 */     this.exp = new JTextField();
/*  48 */     this.jCheckBox1 = new JCheckBox();
/*  49 */     this.jLabel5 = new JLabel();
/*  50 */     this.jButton2 = new JButton();
/*     */ 
/*  52 */     setDefaultCloseOperation(2);
/*     */ 
/*  54 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*  55 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*     */ 
/*  57 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  58 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/*  60 */     this.jLabel3.setFont(new Font("Arial Unicode MS", 0, 12));
/*  61 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/*  62 */     this.jLabel3.setText("VIEW EXPIRED");
/*     */ 
/*  64 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  65 */     this.jPanel2.setLayout(jPanel2Layout);
/*  66 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  67 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  68 */       .addGroup(jPanel2Layout
/*  68 */       .createSequentialGroup()
/*  69 */       .addGap(24, 24, 24)
/*  70 */       .addComponent(this.jLabel3, -2, 101, -2)
/*  71 */       .addContainerGap(-1, 32767)));
/*     */ 
/*  73 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  74 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  75 */       .addGroup(jPanel2Layout
/*  75 */       .createSequentialGroup()
/*  76 */       .addContainerGap()
/*  77 */       .addComponent(this.jLabel3)
/*  78 */       .addContainerGap(-1, 32767)));
/*     */ 
/*  81 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/*  82 */     this.jPanel3.setBorder(BorderFactory.createBevelBorder(1));
/*     */ 
/*  84 */     this.nam.setEditable(false);
/*  85 */     this.nam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  87 */     this.jLabel1.setFont(new Font("Arial Unicode MS", 0, 11));
/*  88 */     this.jLabel1.setText("BATCH NO:");
/*     */ 
/*  90 */     this.jLabel2.setFont(new Font("Arial Unicode MS", 0, 11));
/*  91 */     this.jLabel2.setText("PROD NAME:");
/*     */ 
/*  93 */     this.jLabel4.setFont(new Font("Arial Unicode MS", 0, 11));
/*  94 */     this.jLabel4.setText("EXPIRY DATE:");
/*     */ 
/*  96 */     this.jLabel8.setText("PROD ID:");
/*     */ 
/*  98 */     this.prodid.setEditable(false);
/*  99 */     this.prodid.setAutoscrolls(false);
/* 100 */     this.prodid.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 102 */     this.prodname.setEditable(false);
/* 103 */     this.prodname.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 105 */     this.exp.setEditable(false);
/* 106 */     this.exp.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 108 */     this.jCheckBox1.setBackground(new Color(153, 153, 255));
/* 109 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 111 */         viewProduct.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 115 */     this.jLabel5.setText("SOLD:");
/*     */ 
/* 117 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 118 */     this.jPanel3.setLayout(jPanel3Layout);
/* 119 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 120 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 121 */       .addGroup(jPanel3Layout
/* 121 */       .createSequentialGroup()
/* 122 */       .addContainerGap()
/* 123 */       .addGroup(jPanel3Layout
/* 123 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 124 */       .addGroup(jPanel3Layout
/* 124 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 125 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout
/* 125 */       .createSequentialGroup()
/* 126 */       .addGroup(jPanel3Layout
/* 126 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 127 */       .addComponent(this.jLabel1, -2, 65, -2)
/* 128 */       .addComponent(this.jLabel8)
/* 129 */       .addComponent(this.jLabel2))
/* 130 */       .addGap(84, 84, 84))
/* 131 */       .addGroup(jPanel3Layout
/* 131 */       .createSequentialGroup()
/* 132 */       .addComponent(this.jLabel4)
/* 133 */       .addGap(35, 35, 35)))
/* 134 */       .addGroup(jPanel3Layout
/* 134 */       .createSequentialGroup()
/* 135 */       .addComponent(this.jLabel5)
/* 136 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/* 137 */       .addGroup(jPanel3Layout
/* 137 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 138 */       .addComponent(this.jCheckBox1)
/* 139 */       .addGroup(jPanel3Layout
/* 139 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 140 */       .addComponent(this.nam, -1, 150, 32767)
/* 141 */       .addComponent(this.prodid)
/* 142 */       .addComponent(this.prodname)
/* 143 */       .addComponent(this.exp)))
/* 144 */       .addGap(0, 0, 32767)));
/*     */ 
/* 146 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 147 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 148 */       .addGroup(jPanel3Layout
/* 148 */       .createSequentialGroup()
/* 149 */       .addGap(25, 25, 25)
/* 150 */       .addGroup(jPanel3Layout
/* 150 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 151 */       .addComponent(this.jLabel1)
/* 152 */       .addComponent(this.nam, -2, -1, -2))
/* 153 */       .addGap(50, 50, 50)
/* 154 */       .addGroup(jPanel3Layout
/* 154 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 155 */       .addComponent(this.jLabel8)
/* 156 */       .addComponent(this.prodid, -2, -1, -2))
/* 157 */       .addGap(49, 49, 49)
/* 158 */       .addGroup(jPanel3Layout
/* 158 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 159 */       .addComponent(this.jLabel2)
/* 160 */       .addComponent(this.prodname, -2, -1, -2))
/* 161 */       .addGap(51, 51, 51)
/* 162 */       .addGroup(jPanel3Layout
/* 162 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 163 */       .addComponent(this.jLabel4)
/* 164 */       .addComponent(this.exp, -2, -1, -2))
/* 165 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, 32767)
/* 166 */       .addGroup(jPanel3Layout
/* 166 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 167 */       .addComponent(this.jCheckBox1, GroupLayout.Alignment.TRAILING)
/* 168 */       .addComponent(this.jLabel5, GroupLayout.Alignment.TRAILING))
/* 169 */       .addContainerGap()));
/*     */ 
/* 172 */     this.jButton2.setFont(new Font("Arial Rounded MT Bold", 0, 11));
/* 173 */     this.jButton2.setText("BACK");
/* 174 */     this.jButton2.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 176 */         viewProduct.this.jButton2MouseClicked(evt);
/*     */       }
/*     */     });
/* 180 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 181 */     this.jPanel1.setLayout(jPanel1Layout);
/* 182 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 183 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 184 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 185 */       .addGroup(jPanel1Layout
/* 185 */       .createSequentialGroup()
/* 186 */       .addContainerGap()
/* 187 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 188 */       .addContainerGap())
/* 189 */       .addGroup(jPanel1Layout
/* 189 */       .createSequentialGroup()
/* 190 */       .addGap(412, 412, 412)
/* 191 */       .addComponent(this.jButton2)
/* 192 */       .addGap(0, 66, 32767)));
/*     */ 
/* 194 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 195 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 196 */       .addGroup(jPanel1Layout
/* 196 */       .createSequentialGroup()
/* 197 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 198 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 199 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 200 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767)
/* 201 */       .addComponent(this.jButton2)
/* 202 */       .addContainerGap()));
/*     */ 
/* 205 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 206 */     getContentPane().setLayout(layout);
/* 207 */     layout.setHorizontalGroup(layout
/* 208 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 209 */       .addGroup(layout
/* 209 */       .createSequentialGroup()
/* 210 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 211 */       .addGap(0, 0, 32767)));
/*     */ 
/* 213 */     layout.setVerticalGroup(layout
/* 214 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 215 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 218 */     pack();
/*     */   }
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 222 */     Boolean bol = Boolean.valueOf(this.jCheckBox1.isSelected());
/* 223 */     if (bol.booleanValue() == true) {
/* 224 */       int y = 0;
/* 225 */       y = JOptionPane.showConfirmDialog(this.jPanel1, "Do Really You Want to set this as sold?", "Confirm!", 0);
/* 226 */       if (y == 0)
/*     */       {
/* 228 */         updateSold();
/*     */       }
/*     */       else
/*     */       {
/* 232 */         this.jCheckBox1.setSelected(false);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton2MouseClicked(MouseEvent evt)
/*     */   {
/* 240 */     dispose();
/*     */   }
/*     */ 
/*     */   public void setValues(String batch, String prod, String prodnam, String expired)
/*     */   {
/* 245 */     this.nam.setText(batch);
/* 246 */     this.prodid.setText(prod);
/* 247 */     this.prodname.setText(prodnam);
/* 248 */     this.exp.setText(expired);
/*     */   }
/*     */ 
/*     */   public void updateSold()
/*     */   {
/*     */     try
/*     */     {
/* 259 */       String sql = "update expirydate set sold='1' where prodid='" + this.prodid.getText() + "'";
/*     */ 
/* 261 */       Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 263 */       Statement st = cn.createStatement();
/*     */ 
/* 265 */       int e = st.executeUpdate(sql);
/* 266 */       if (e > 0)
/* 267 */         dispose();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 271 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 288 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 289 */         if ("Nimbus".equals(info.getName())) {
/* 290 */           UIManager.setLookAndFeel(info.getClassName());
/* 291 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 295 */       Logger.getLogger(viewProduct.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 297 */       Logger.getLogger(viewProduct.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 299 */       Logger.getLogger(viewProduct.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 301 */       Logger.getLogger(viewProduct.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 308 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 311 */         viewProduct dialog = new viewProduct(new JFrame(), true);
/* 312 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 316 */             System.exit(0);
/*     */           }
/*     */         });
/* 319 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.viewProduct
 * JD-Core Version:    0.6.0
 */