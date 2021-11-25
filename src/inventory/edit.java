/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
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
/*     */ public class edit extends JFrame
/*     */ {
/*  18 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  19 */   static String username = "root";
/*  20 */   static String password = "this";
/*     */   private JTextField code;
/*     */   private JTextField des;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JTextField name;
/*     */   private JTextField price;
/*     */   private JTextField quan;
/*     */   private JTextField reorder;
/*     */ 
/*     */   public edit()
/*     */   {
/*  26 */     initComponents();
/*     */ 
/*  28 */     setLocationRelativeTo(null);
/*  29 */     addWindowListener(new WindowAdapter()
/*     */     {
/*     */       public void windowClosing(WindowEvent e)
/*     */       {
/*  35 */         System.exit(1);
/*  36 */         edit.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void save() {
/*  43 */     String nam = this.name.getText();
/*  44 */     String cod = this.code.getText();
/*  45 */     String description = this.des.getText();
/*  46 */     String quantity = this.quan.getText();
/*  47 */     String supplier = (String)this.jComboBox1.getSelectedItem();
/*  48 */     String re = this.quan.getText();
/*  49 */     String pric = this.price.getText();
/*     */     try
/*     */     {
/*  53 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/*  54 */       java.sql.Connection connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/*     */ 
/*  56 */       java.sql.PreparedStatement psmnt = (com.mysql.jdbc.PreparedStatement)connection
/*  56 */         .prepareStatement("UPDATE stock SET name='" + nam + "',description='" + description + "',quantity='" + quantity + "',supplier='" + supplier + "',reorder_level='" + re + "',price='" + pric + "' WHERE Itemcode='" + cod + "' ");
/*     */ 
/*  59 */       int s = psmnt.executeUpdate();
/*  60 */       if (s > 0)
/*     */       {
/*  63 */         JOptionPane.showMessageDialog(null, "Thank you", " Successfully Saved!", 1);
/*  64 */         dispose();
/*     */       }
/*     */       else {
/*  67 */         JOptionPane.showMessageDialog(null, "Sorry, Not All Details Were Saved!", "Error!", 0);
/*     */       }
/*  69 */       psmnt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  73 */       System.out.println("Found some error : " + ex);
/*  74 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  93 */     this.jPanel1 = new JPanel();
/*  94 */     this.jPanel2 = new JPanel();
/*  95 */     this.jLabel1 = new JLabel();
/*  96 */     this.jLabel2 = new JLabel();
/*  97 */     this.code = new JTextField();
/*  98 */     this.jLabel3 = new JLabel();
/*  99 */     this.jLabel4 = new JLabel();
/* 100 */     this.name = new JTextField();
/* 101 */     this.des = new JTextField();
/* 102 */     this.jLabel5 = new JLabel();
/* 103 */     this.quan = new JTextField();
/* 104 */     this.jLabel6 = new JLabel();
/* 105 */     this.reorder = new JTextField();
/* 106 */     this.price = new JTextField();
/* 107 */     this.jLabel7 = new JLabel();
/* 108 */     this.jLabel8 = new JLabel();
/* 109 */     this.jComboBox1 = new JComboBox();
/* 110 */     this.jButton1 = new JButton();
/* 111 */     this.jButton2 = new JButton();
/*     */ 
/* 113 */     setDefaultCloseOperation(3);
/*     */ 
/* 115 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/* 117 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/* 118 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/* 120 */     this.jLabel1.setForeground(new Color(204, 204, 204));
/* 121 */     this.jLabel1.setText("EDIT ITEM");
/*     */ 
/* 123 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 124 */     this.jPanel2.setLayout(jPanel2Layout);
/* 125 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 126 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 127 */       .addGroup(jPanel2Layout
/* 127 */       .createSequentialGroup()
/* 128 */       .addContainerGap()
/* 129 */       .addComponent(this.jLabel1, -2, 70, -2)
/* 130 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 132 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 133 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 134 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout
/* 134 */       .createSequentialGroup()
/* 135 */       .addGap(0, 11, 32767)
/* 136 */       .addComponent(this.jLabel1)));
/*     */ 
/* 139 */     this.jLabel2.setText("CODE");
/*     */ 
/* 141 */     this.code.setEditable(false);
/* 142 */     this.code.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 144 */     this.jLabel3.setText("NAME");
/*     */ 
/* 146 */     this.jLabel4.setText("DESCRIPTION");
/*     */ 
/* 148 */     this.name.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 150 */     this.des.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 152 */     this.jLabel5.setText("QUANTITY");
/*     */ 
/* 154 */     this.quan.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 156 */     this.jLabel6.setText("PRICE");
/*     */ 
/* 158 */     this.reorder.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 160 */     this.price.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 162 */     this.jLabel7.setText("REORDER LEVEL");
/*     */ 
/* 164 */     this.jLabel8.setText("SUPPLIERS");
/*     */ 
/* 166 */     this.jButton1.setText("SAVE");
/* 167 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 169 */         edit.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 173 */     this.jButton2.setText("BACK");
/* 174 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 176 */         edit.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 180 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 181 */     this.jPanel1.setLayout(jPanel1Layout);
/* 182 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 183 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 184 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 185 */       .addGroup(jPanel1Layout
/* 185 */       .createSequentialGroup()
/* 186 */       .addGroup(jPanel1Layout
/* 186 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 187 */       .addGroup(jPanel1Layout
/* 187 */       .createSequentialGroup()
/* 188 */       .addContainerGap()
/* 189 */       .addGroup(jPanel1Layout
/* 189 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 190 */       .addGroup(jPanel1Layout
/* 190 */       .createSequentialGroup()
/* 191 */       .addGroup(jPanel1Layout
/* 191 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 192 */       .addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 193 */       .addComponent(this.jLabel5, -1, -1, 32767)
/* 194 */       .addComponent(this.jLabel8, -1, -1, 32767)
/* 195 */       .addComponent(this.jLabel2, -1, -1, 32767)
/* 196 */       .addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/* 197 */       .addGroup(jPanel1Layout
/* 197 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 198 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
/* 198 */       .createSequentialGroup()
/* 199 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 200 */       .addGroup(jPanel1Layout
/* 200 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 201 */       .addComponent(this.quan, GroupLayout.Alignment.TRAILING, -2, 118, -2)
/* 202 */       .addComponent(this.jComboBox1, GroupLayout.Alignment.TRAILING, -2, 118, -2)
/* 203 */       .addComponent(this.reorder, GroupLayout.Alignment.TRAILING, -2, 118, -2)
/* 204 */       .addComponent(this.price, GroupLayout.Alignment.TRAILING, -2, 118, -2))
/* 205 */       .addGap(8, 8, 8))
/* 206 */       .addGroup(jPanel1Layout
/* 206 */       .createSequentialGroup()
/* 207 */       .addGap(47, 47, 47)
/* 208 */       .addGroup(jPanel1Layout
/* 208 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 209 */       .addComponent(this.name, -2, 118, -2)
/* 210 */       .addComponent(this.code, -2, 118, -2)
/* 211 */       .addComponent(this.des, -2, 126, -2)))))
/* 212 */       .addGroup(jPanel1Layout
/* 212 */       .createSequentialGroup()
/* 213 */       .addGroup(jPanel1Layout
/* 213 */       .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 214 */       .addComponent(this.jLabel6, -1, -1, 32767)
/* 215 */       .addComponent(this.jLabel7, -1, -1, 32767))
/* 216 */       .addGap(18, 18, 18)
/* 217 */       .addComponent(this.jButton1)
/* 218 */       .addGap(61, 61, 61))))
/* 219 */       .addGroup(jPanel1Layout
/* 219 */       .createSequentialGroup()
/* 220 */       .addGap(216, 216, 216)
/* 221 */       .addComponent(this.jButton2)))
/* 222 */       .addContainerGap(53, 32767)));
/*     */ 
/* 224 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 225 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 226 */       .addGroup(jPanel1Layout
/* 226 */       .createSequentialGroup()
/* 227 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 228 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 229 */       .addGroup(jPanel1Layout
/* 229 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 230 */       .addComponent(this.jLabel2)
/* 231 */       .addComponent(this.code, -2, -1, -2))
/* 232 */       .addGap(18, 18, 18)
/* 233 */       .addGroup(jPanel1Layout
/* 233 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 234 */       .addComponent(this.jLabel3)
/* 235 */       .addComponent(this.name, -2, -1, -2))
/* 236 */       .addGap(18, 18, 18)
/* 237 */       .addGroup(jPanel1Layout
/* 237 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 238 */       .addComponent(this.jLabel4)
/* 239 */       .addComponent(this.des, -2, -1, -2))
/* 240 */       .addGap(18, 18, 18)
/* 241 */       .addGroup(jPanel1Layout
/* 241 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 242 */       .addComponent(this.jComboBox1, -2, -1, -2)
/* 243 */       .addComponent(this.jLabel8))
/* 244 */       .addGap(18, 18, 18)
/* 245 */       .addGroup(jPanel1Layout
/* 245 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 246 */       .addComponent(this.jLabel5)
/* 247 */       .addComponent(this.quan, -2, -1, -2))
/* 248 */       .addGap(26, 26, 26)
/* 249 */       .addGroup(jPanel1Layout
/* 249 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 250 */       .addComponent(this.jLabel7)
/* 251 */       .addComponent(this.reorder, -2, -1, -2))
/* 252 */       .addGap(18, 18, 18)
/* 253 */       .addGroup(jPanel1Layout
/* 253 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 254 */       .addComponent(this.price, -2, -1, -2)
/* 255 */       .addComponent(this.jLabel6))
/* 256 */       .addGap(18, 18, 18)
/* 257 */       .addGroup(jPanel1Layout
/* 257 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 258 */       .addComponent(this.jButton1)
/* 259 */       .addComponent(this.jButton2))
/* 260 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 263 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 264 */     getContentPane().setLayout(layout);
/* 265 */     layout.setHorizontalGroup(layout
/* 266 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 267 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 269 */     layout.setVerticalGroup(layout
/* 270 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 271 */       .addGroup(layout
/* 271 */       .createSequentialGroup()
/* 272 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 273 */       .addGap(0, 31, 32767)));
/*     */ 
/* 276 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 280 */     save();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 284 */     dispose();
/*     */   }
/*     */   public void search(String icode) {
/* 287 */     this.code.setText(icode);
/*     */     try {
/* 289 */       Class.forName("com.mysql.jdbc.Driver");
/* 290 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 291 */       String sql = "SELECT name,description,quantity,reorder_level,price,supplier,vat FROM stock";
/* 292 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 293 */       ResultSet resultSet = stmt.executeQuery();
/* 294 */       while (resultSet.next()) {
/* 295 */         this.name.setText(resultSet.getString(1));
/* 296 */         this.des.setText(resultSet.getString(2));
/* 297 */         this.quan.setText(resultSet.getString(3));
/* 298 */         this.reorder.setText(resultSet.getString(4));
/* 299 */         this.price.setText(resultSet.getString(5));
/* 300 */         this.jComboBox1.addItem(resultSet.getString(6));
/*     */       }
/*     */ 
/* 304 */       conn.close();
/*     */     } catch (Exception exc) {
/* 306 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 328 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 329 */         if ("Nimbus".equals(info.getName())) {
/* 330 */           UIManager.setLookAndFeel(info.getClassName());
/* 331 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 335 */       Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 337 */       Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 339 */       Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 341 */       Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 348 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 351 */         new edit().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.edit
 * JD-Core Version:    0.6.0
 */