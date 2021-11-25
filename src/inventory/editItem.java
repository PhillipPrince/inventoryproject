/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
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
/*     */ public class editItem extends JDialog
/*     */ {
/*  16 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  17 */   static String username = "root";
/*  18 */   static String password = "this";
/*  19 */   String itemcode = "";
/*     */   private JTextField buye;
/*     */   private JTextField code1;
/*     */   private JTextField des1;
/*     */   private JButton jButton13;
/*     */   private JButton jButton15;
/*     */   private JComboBox jComboBox3;
/*     */   private JComboBox jComboBox4;
/*     */   private JComboBox jComboBox5;
/*     */   private JComboBox jComboBox6;
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel16;
/*     */   private JLabel jLabel17;
/*     */   private JLabel jLabel18;
/*     */   private JLabel jLabel19;
/*     */   private JLabel jLabel20;
/*     */   private JLabel jLabel21;
/*     */   private JLabel jLabel22;
/*     */   private JLabel jLabel23;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JPanel jPanel12;
/*     */   private JPanel jPanel13;
/*     */   private JPanel jPanel8;
/*     */   private JTextField name1;
/*     */   private JTextField price1;
/*     */   private JTextField quan;
/*     */   private JTextField reorder1;
/*     */   private JTextField vate;
            int s;
            int e;
            
/*     */ 
/*     */   public editItem(Frame parent, boolean modal)
/*     */   {
/*  24 */     super(parent, modal);
/*  25 */     initComponents();
/*  26 */     setLocationRelativeTo(null);
/*     */     try {
/*  28 */       Class.forName("com.mysql.jdbc.Driver");
/*  29 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/*  30 */       String sql = "SELECT name FROM suppliers";
/*  31 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/*  32 */       ResultSet resultSet = stmt.executeQuery();
/*  33 */       while (resultSet.next()) {
/*  34 */         this.jComboBox3.addItem(resultSet.getString(1));
/*     */       }
/*     */ 
/*  38 */       this.jComboBox3.addItem("NONE");
/*  39 */       conn.close();
/*     */     } catch (Exception exc) {
/*  41 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void set(String item)
/*     */   {
/*  49 */     this.itemcode = item;
/*  50 */     searchfor(this.itemcode);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  62 */     this.jPanel13 = new JPanel();
/*  63 */     this.jPanel8 = new JPanel();
/*  64 */     this.jLabel3 = new JLabel();
/*  65 */     this.jPanel12 = new JPanel();
/*  66 */     this.jLabel14 = new JLabel();
/*  67 */     this.code1 = new JTextField();
/*  68 */     this.jLabel15 = new JLabel();
/*  69 */     this.jLabel16 = new JLabel();
/*  70 */     this.name1 = new JTextField();
/*  71 */     this.des1 = new JTextField();
/*  72 */     this.jLabel17 = new JLabel();
/*  73 */     this.quan = new JTextField();
/*  74 */     this.jLabel18 = new JLabel();
/*  75 */     this.reorder1 = new JTextField();
/*  76 */     this.price1 = new JTextField();
/*  77 */     this.jLabel19 = new JLabel();
/*  78 */     this.jLabel20 = new JLabel();
/*  79 */     this.jComboBox3 = new JComboBox();
/*  80 */     this.jLabel21 = new JLabel();
/*  81 */     this.buye = new JTextField();
/*  82 */     this.jLabel13 = new JLabel();
/*  83 */     this.jComboBox4 = new JComboBox();
/*  84 */     this.jLabel22 = new JLabel();
/*  85 */     this.vate = new JTextField();
/*  86 */     this.jLabel23 = new JLabel();
/*  87 */     this.jComboBox6 = new JComboBox();
/*  88 */     this.jComboBox5 = new JComboBox();
/*  89 */     this.jLabel4 = new JLabel();
/*  90 */     this.jButton13 = new JButton();
/*  91 */     this.jButton15 = new JButton();
/*     */ 
/*  93 */     setDefaultCloseOperation(2);
/*     */ 
/*  95 */     this.jPanel13.setBackground(new Color(153, 153, 255));
/*  96 */     this.jPanel13.setBorder(BorderFactory.createEtchedBorder(0));
/*     */ 
/*  98 */     this.jPanel8.setBackground(new Color(0, 0, 0));
/*     */ 
/* 100 */     this.jLabel3.setFont(new Font("Tahoma", 1, 12));
/* 101 */     this.jLabel3.setForeground(new Color(204, 204, 204));
/* 102 */     this.jLabel3.setText("EDIT ITEM");
/*     */ 
/* 104 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 105 */     this.jPanel8.setLayout(jPanel8Layout);
/* 106 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 107 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 108 */       .addGroup(jPanel8Layout
/* 108 */       .createSequentialGroup()
/* 109 */       .addContainerGap()
/* 110 */       .addComponent(this.jLabel3)
/* 111 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 113 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 114 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 115 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout
/* 115 */       .createSequentialGroup()
/* 116 */       .addGap(0, 11, 32767)
/* 117 */       .addComponent(this.jLabel3)));
/*     */ 
/* 120 */     this.jPanel12.setBackground(new Color(153, 153, 255));
/* 121 */     this.jPanel12.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 123 */     this.jLabel14.setText("CODE:");
/*     */ 
/* 125 */     this.code1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 127 */     this.jLabel15.setText("NAME:");
/*     */ 
/* 129 */     this.jLabel16.setText("DESCRIPTION:");
/*     */ 
/* 131 */     this.name1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 133 */     this.des1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 135 */     this.jLabel17.setText("QUANTITY:");
/*     */ 
/* 137 */     this.quan.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 139 */     this.jLabel18.setText("PRICE:");
/*     */ 
/* 141 */     this.reorder1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 143 */     this.price1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 145 */     this.jLabel19.setText("REORDER:");
/*     */ 
/* 147 */     this.jLabel20.setText("SUPPLIERS:");
/*     */ 
/* 149 */     this.jLabel21.setText("BUYING PRICE:");
/*     */ 
/* 151 */     this.buye.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 153 */     this.jLabel13.setText("UNITS:");
/*     */ 
/* 155 */     this.jComboBox4.setModel(new DefaultComboBoxModel(new String[] { "CARTON", "BAGS", "KILOS", "DOZEN", "PACKETS", "NONE", "TABS", "CAPS", "AMPS", "VIALS", "SESSION" }));
/*     */ 
/* 157 */     this.jLabel22.setText("VAT:");
/*     */ 
/* 159 */     this.vate.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 161 */     this.jLabel23.setText("CATEGORY");
/*     */ 
/* 163 */     this.jComboBox6.setEditable(true);
/*     */ 
/* 165 */     this.jComboBox5.setModel(new DefaultComboBoxModel(new String[] { "Product", "Service" }));
/*     */ 
/* 167 */     this.jLabel4.setText("TYPE:");
/*     */ 
/* 169 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 170 */     this.jPanel12.setLayout(jPanel12Layout);
/* 171 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 172 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 173 */       .addGroup(jPanel12Layout
/* 173 */       .createSequentialGroup()
/* 174 */       .addGroup(jPanel12Layout
/* 174 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 175 */       .addGroup(jPanel12Layout
/* 175 */       .createSequentialGroup()
/* 176 */       .addContainerGap(-1, 32767)
/* 177 */       .addGroup(jPanel12Layout
/* 177 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 178 */       .addComponent(this.jLabel14, GroupLayout.Alignment.TRAILING)
/* 179 */       .addComponent(this.jLabel15, GroupLayout.Alignment.TRAILING))
/* 180 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 181 */       .addGroup(jPanel12Layout
/* 181 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 182 */       .addComponent(this.name1, -1, 149, 32767)
/* 183 */       .addGroup(jPanel12Layout
/* 183 */       .createSequentialGroup()
/* 184 */       .addComponent(this.code1)
/* 185 */       .addGap(21, 21, 21)))
/* 186 */       .addGroup(jPanel12Layout
/* 186 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 187 */       .addGroup(jPanel12Layout
/* 187 */       .createSequentialGroup()
/* 188 */       .addGap(21, 21, 21)
/* 189 */       .addComponent(this.jLabel17)
/* 190 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 191 */       .addComponent(this.quan, -2, 118, -2))
/* 192 */       .addGroup(jPanel12Layout
/* 192 */       .createSequentialGroup()
/* 193 */       .addGroup(jPanel12Layout
/* 193 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 194 */       .addGroup(jPanel12Layout
/* 194 */       .createSequentialGroup()
/* 195 */       .addGap(26, 26, 26)
/* 196 */       .addComponent(this.jLabel19, -2, 54, -2)
/* 197 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/* 198 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout
/* 198 */       .createSequentialGroup()
/* 199 */       .addComponent(this.jLabel13)
/* 200 */       .addGap(13, 13, 13))
/* 201 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout
/* 201 */       .createSequentialGroup()
/* 202 */       .addComponent(this.jLabel22)
/* 203 */       .addGap(18, 18, 18)))
/* 204 */       .addGroup(jPanel12Layout
/* 204 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 205 */       .addGroup(jPanel12Layout
/* 205 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 206 */       .addGroup(jPanel12Layout
/* 206 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 207 */       .addGroup(jPanel12Layout
/* 207 */       .createSequentialGroup()
/* 208 */       .addComponent(this.reorder1, -2, 118, -2)
/* 209 */       .addGap(2, 2, 2))
/* 210 */       .addComponent(this.jComboBox3, GroupLayout.Alignment.TRAILING, -2, 120, -2))
/* 211 */       .addComponent(this.jComboBox4, GroupLayout.Alignment.TRAILING, -2, 118, -2))
/* 212 */       .addComponent(this.vate, GroupLayout.Alignment.TRAILING, -2, 118, -2)))))
/* 213 */       .addGroup(jPanel12Layout
/* 213 */       .createSequentialGroup()
/* 214 */       .addGroup(jPanel12Layout
/* 214 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 215 */       .addGroup(jPanel12Layout
/* 215 */       .createSequentialGroup()
/* 216 */       .addGap(24, 24, 24)
/* 217 */       .addComponent(this.jLabel16)
/* 218 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 219 */       .addComponent(this.des1)
/* 220 */       .addGap(24, 24, 24))
/* 221 */       .addGroup(jPanel12Layout
/* 221 */       .createSequentialGroup()
/* 222 */       .addGroup(jPanel12Layout
/* 222 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 223 */       .addGroup(jPanel12Layout
/* 223 */       .createSequentialGroup()
/* 224 */       .addGap(62, 62, 62)
/* 225 */       .addComponent(this.jLabel18)
/* 226 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 227 */       .addComponent(this.price1, -2, 123, -2))
/* 228 */       .addGroup(jPanel12Layout
/* 228 */       .createSequentialGroup()
/* 229 */       .addGap(24, 24, 24)
/* 230 */       .addGroup(jPanel12Layout
/* 230 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 231 */       .addComponent(this.jLabel21)
/* 232 */       .addComponent(this.jLabel23))
/* 233 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 234 */       .addGroup(jPanel12Layout
/* 234 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 235 */       .addComponent(this.jComboBox6, -2, 111, -2)
/* 236 */       .addComponent(this.buye, -2, 123, -2))))
/* 237 */       .addGap(48, 48, 48)))
/* 238 */       .addGroup(jPanel12Layout
/* 238 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 239 */       .addGroup(jPanel12Layout
/* 239 */       .createSequentialGroup()
/* 240 */       .addComponent(this.jLabel20)
/* 241 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 125, 32767))
/* 242 */       .addGroup(jPanel12Layout
/* 242 */       .createSequentialGroup()
/* 243 */       .addGap(0, 0, 32767)
/* 244 */       .addComponent(this.jLabel4)
/* 245 */       .addGap(18, 18, 18)
/* 246 */       .addComponent(this.jComboBox5, -2, 118, -2)))))
/* 247 */       .addContainerGap()));
/*     */ 
/* 249 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 250 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 251 */       .addGroup(jPanel12Layout
/* 251 */       .createSequentialGroup()
/* 252 */       .addContainerGap()
/* 253 */       .addGroup(jPanel12Layout
/* 253 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 254 */       .addComponent(this.jLabel14)
/* 255 */       .addComponent(this.code1, -2, -1, -2)
/* 256 */       .addComponent(this.jLabel17)
/* 257 */       .addComponent(this.quan, -2, -1, -2))
/* 258 */       .addGap(18, 18, 18)
/* 259 */       .addGroup(jPanel12Layout
/* 259 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 260 */       .addGroup(jPanel12Layout
/* 260 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 261 */       .addComponent(this.jLabel19)
/* 262 */       .addComponent(this.reorder1, -2, -1, -2))
/* 263 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout
/* 263 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 264 */       .addComponent(this.jLabel15)
/* 265 */       .addComponent(this.name1, -2, -1, -2)))
/* 266 */       .addGap(18, 18, 18)
/* 267 */       .addGroup(jPanel12Layout
/* 267 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 268 */       .addComponent(this.jLabel16)
/* 269 */       .addComponent(this.des1, -2, -1, -2)
/* 270 */       .addComponent(this.jLabel20)
/* 271 */       .addComponent(this.jComboBox3, -2, -1, -2))
/* 272 */       .addGap(18, 18, 18)
/* 273 */       .addGroup(jPanel12Layout
/* 273 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 274 */       .addComponent(this.jLabel18)
/* 275 */       .addComponent(this.price1, -2, -1, -2)
/* 276 */       .addComponent(this.jLabel13)
/* 277 */       .addComponent(this.jComboBox4, -2, -1, -2))
/* 278 */       .addGap(18, 18, 18)
/* 279 */       .addGroup(jPanel12Layout
/* 279 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 280 */       .addComponent(this.jLabel21)
/* 281 */       .addComponent(this.buye, -2, -1, -2)
/* 282 */       .addComponent(this.jLabel22)
/* 283 */       .addComponent(this.vate, -2, -1, -2))
/* 284 */       .addGap(18, 18, 18)
/* 285 */       .addGroup(jPanel12Layout
/* 285 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 286 */       .addComponent(this.jLabel23)
/* 287 */       .addComponent(this.jComboBox6, -2, -1, -2)
/* 288 */       .addComponent(this.jComboBox5, -2, -1, -2)
/* 289 */       .addComponent(this.jLabel4))
/* 290 */       .addContainerGap(33, 32767)));
/*     */ 
/* 293 */     this.jButton13.setText("SAVE");
/* 294 */     this.jButton13.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 296 */         editItem.this.jButton13ActionPerformed(evt);
/*     */       }
/*     */     });
/* 300 */     this.jButton15.setText("DELETE");
/* 301 */     this.jButton15.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 303 */         editItem.this.jButton15ActionPerformed(evt);
/*     */       }
/*     */     });
/* 307 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 308 */     this.jPanel13.setLayout(jPanel13Layout);
/* 309 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 310 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 311 */       .addComponent(this.jPanel8, -1, -1, 32767)
/* 312 */       .addGroup(jPanel13Layout
/* 312 */       .createSequentialGroup()
/* 313 */       .addGroup(jPanel13Layout
/* 313 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 314 */       .addGroup(jPanel13Layout
/* 314 */       .createSequentialGroup()
/* 315 */       .addContainerGap()
/* 316 */       .addComponent(this.jPanel12, -1, -1, 32767))
/* 317 */       .addGroup(jPanel13Layout
/* 317 */       .createSequentialGroup()
/* 318 */       .addGap(69, 69, 69)
/* 319 */       .addComponent(this.jButton13)
/* 320 */       .addGap(38, 38, 38)
/* 321 */       .addComponent(this.jButton15)
/* 322 */       .addGap(0, 0, 32767)))
/* 323 */       .addContainerGap()));
/*     */ 
/* 325 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 326 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 327 */       .addGroup(jPanel13Layout
/* 327 */       .createSequentialGroup()
/* 328 */       .addComponent(this.jPanel8, -2, -1, -2)
/* 329 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 330 */       .addComponent(this.jPanel12, -1, -1, 32767)
/* 331 */       .addGap(18, 18, 18)
/* 332 */       .addGroup(jPanel13Layout
/* 332 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 333 */       .addComponent(this.jButton13)
/* 334 */       .addComponent(this.jButton15))
/* 335 */       .addContainerGap()));
/*     */ 
/* 338 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 339 */     getContentPane().setLayout(layout);
/* 340 */     layout.setHorizontalGroup(layout
/* 341 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 342 */       .addComponent(this.jPanel13, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */ 
/* 344 */     layout.setVerticalGroup(layout
/* 345 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 346 */       .addComponent(this.jPanel13, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */ 
/* 349 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 353 */     Double v = Double.valueOf(0.0D);
/* 354 */     Double b = Double.valueOf(0.0D); Double s = Double.valueOf(0.0D);
/* 355 */     Double r = Double.valueOf(0.0D);
/* 356 */     Double q = Double.valueOf(0.0D);
/* 357 */     int check = search();
/* 358 */     int type = this.jComboBox5.getSelectedIndex();
/*     */     try {
/* 360 */       v = Double.valueOf(Double.parseDouble(this.vate.getText()));
/* 361 */       System.out.println(v + "  vat");
/*     */     }
/*     */     catch (Exception ex) {
/* 364 */       this.vate.setText("");
/*     */     }
/*     */     try {
/* 367 */       b = Double.valueOf(Double.parseDouble(this.buye.getText()));
/*     */     } catch (Exception ex) {
/* 369 */       this.buye.setText("");
/*     */     }
/*     */     try {
/* 372 */       s = Double.valueOf(Double.parseDouble(this.price1.getText()));
/*     */     } catch (Exception ex) {
/* 374 */       this.price1.setText("");
/*     */     }
/*     */     try {
/* 377 */       r = Double.valueOf(Double.parseDouble(this.reorder1.getText()));
/*     */     } catch (Exception ex) {
/* 379 */       this.reorder1.setText("");
/*     */     }
/*     */     try {
/* 382 */       q = Double.valueOf(Double.parseDouble(this.quan.getText()));
/*     */     } catch (Exception ex) {
/* 384 */       this.quan.setText("");
/*     */     }
/* 386 */     if ((check == 1) && (!this.itemcode.equals(this.code1.getText()))) {
/* 387 */       JOptionPane.showMessageDialog(null, "Sorry, This Item code is already in use", "Warning!", 2);
/* 388 */       this.code1.requestFocus();
/*     */     }
/* 392 */     else if (this.code1.getText().equals(""))
/*     */     {
/* 394 */       JOptionPane.showMessageDialog(null, "Code is empty!", "ERROR!", 0);
/* 395 */       this.code1.requestFocus();
/* 396 */     } else if (this.jComboBox6.getSelectedItem().equals("")) {
/* 397 */       JOptionPane.showMessageDialog(null, "category is empty!", "ERROR!", 0);
/*     */     }
/* 399 */     else if (this.name1.getText().equals(""))
/*     */     {
/* 401 */       JOptionPane.showMessageDialog(null, "Name is empty!", "ERROR!", 0);
/* 402 */       this.name1.requestFocus();
/* 403 */     } else if (this.vate.getText().equals("")) {
/* 404 */       JOptionPane.showMessageDialog(null, "VAT is empty!", "ERROR!", 0);
/* 405 */       this.vate.requestFocus();
/* 406 */     } else if ((v.doubleValue() < 0.0D) || (v.doubleValue() >= 1.0D)) {
/* 407 */       JOptionPane.showMessageDialog(null, "Value is wrong for Vat!", "ERROR!", 0);
/* 408 */       this.vate.requestFocus();
/* 409 */     } else if (this.des1.getText().equals("")) {
/* 410 */       JOptionPane.showMessageDialog(null, "Description is empty!", "ERROR!", 0);
/* 411 */       this.des1.requestFocus();
/* 412 */     } else if (this.price1.getText().equals("")) {
/* 413 */       JOptionPane.showMessageDialog(null, "Retail Price is empty!", "ERROR!", 0);
/* 414 */       this.price1.requestFocus();
/* 415 */     } else if (this.buye.getText().equals("")) {
/* 416 */       JOptionPane.showMessageDialog(null, "Buying Price is empty!", "ERROR!", 0);
/* 417 */       this.buye.requestFocus();
/* 418 */     } else if (this.quan.getText().equals("")) {
/* 419 */       JOptionPane.showMessageDialog(null, "Price is empty!", "ERROR!", 0);
/* 420 */       this.quan.requestFocus();
/* 421 */     } else if (this.reorder1.getText().equals("")) {
/* 422 */       JOptionPane.showMessageDialog(null, "Price is empty!", "ERROR!", 0);
/* 423 */       this.reorder1.requestFocus();
/*     */     }
/* 425 */     else if (b.doubleValue() >= s.doubleValue()) {
/* 426 */       JOptionPane.showMessageDialog(null, "Buying Price is greater than Selling Price!", "ERROR!", 0);
/*     */     }
/* 429 */     else if (((b.doubleValue() <= 0.0D) || (s.doubleValue() <= 0.0D)) && (type == 0)) {
/* 430 */       JOptionPane.showMessageDialog(null, "Values Less than zero!", "ERROR!", 0);
/*     */     }
/*     */     else
/*     */     {
/* 436 */       save();
/* 437 */       if (!this.itemcode.equals(this.code1.getText())) {
/* 438 */         updatepurchases();
/* 439 */         updatedamagedgoods();
/* 440 */         updateinvoice();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public int search() {
/* 444 */     int i = 0;
/*     */ 
/* 446 */     String find = this.code1.getText();
/*     */     try {
/* 448 */       Class.forName("com.mysql.jdbc.Driver");
/* 449 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 450 */       String sql = "SELECT * FROM stock where Itemcode='" + find + "'";
/* 451 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 452 */       ResultSet resultSet = stmt.executeQuery();
/* 453 */       while (resultSet.next()) {
/* 454 */         i = 1;
/*     */       }
/* 456 */       conn.close();
/*     */     }
/*     */     catch (Exception exc) {
/* 459 */       System.out.println("process error" + exc);
/*     */     }
/*     */ 
/* 463 */     System.out.println(i);
/*     */ 
/* 465 */     return i;
/*     */   }
/*     */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 468 */     int y = 0;
/* 469 */     y = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm", 0);
/*     */ 
/* 473 */     if (y == 0)
/*     */     {
/* 475 */       EnterPass nn = new EnterPass(new JFrame(), true);
/* 476 */       nn.setVisible(true);
/* 477 */       int pass = nn.match();
/* 478 */       if (pass == 1) {
/* 479 */         if (this.code1.getText().equals("")) {
/* 480 */           JOptionPane.showMessageDialog(null, "Code is empty!", "ERROR!", 0);
/* 481 */           this.code1.requestFocus();
/* 482 */         } else if (this.name1.getText().equals(""))
/*     */         {
/* 484 */           JOptionPane.showMessageDialog(null, "Name is empty!", "ERROR!", 0);
/* 485 */           this.name1.requestFocus();
/* 486 */         } else if (this.des1.getText().equals("")) {
/* 487 */           JOptionPane.showMessageDialog(null, "Description is empty!", "ERROR!", 0);
/* 488 */           this.des1.requestFocus();
/* 489 */         } else if (this.price1.getText().equals("")) {
/* 490 */           JOptionPane.showMessageDialog(null, "Price is empty!", "ERROR!", 0);
/* 491 */           this.price1.requestFocus();
/* 492 */         } else if (this.buye.getText().equals("")) {
/* 493 */           JOptionPane.showMessageDialog(null, "Price is empty!", "ERROR!", 0);
/* 494 */           this.price1.requestFocus();
/* 495 */         } else if (this.quan.getText().equals("")) {
/* 496 */           JOptionPane.showMessageDialog(null, "Price is empty!", "ERROR!", 0);
/* 497 */           this.quan.requestFocus();
/* 498 */         } else if (this.reorder1.getText().equals("")) {
/* 499 */           JOptionPane.showMessageDialog(null, "Price is empty!", "ERROR!", 0);
/* 500 */           this.reorder1.requestFocus();
/* 501 */         } else if (this.vate.getText().equals("")) {
/* 502 */           JOptionPane.showMessageDialog(null, "Price is empty!", "ERROR!", 0);
/* 503 */           this.vate.requestFocus();
/*     */         }
/*     */         else {
/* 506 */           delete();
/*     */         }
/*     */       }
/*     */       else
/* 510 */         JOptionPane.showMessageDialog(null, "Not deleted", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void save()
/*     */   {
/* 517 */     String nam = this.name1.getText();
/* 518 */     String cod = this.code1.getText();
/* 519 */     String description = this.des1.getText();
/* 520 */     String quantity = this.quan.getText();
/* 521 */     String supplier = (String)this.jComboBox3.getSelectedItem();
/* 522 */     String tunits = (String)this.jComboBox4.getSelectedItem();
/* 523 */     String cat = (String)this.jComboBox6.getSelectedItem();
/* 524 */     String re = this.reorder1.getText();
/* 525 */     String pric = this.price1.getText();
/* 526 */     String vat = this.vate.getText();
/* 527 */     String spri = this.buye.getText();
/* 528 */     int type = this.jComboBox5.getSelectedIndex();
/* 529 */     updateInvoice(cod, nam, description);
/*     */     try
/*     */     {
/* 533 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 534 */       java.sql.Connection connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/*     */ 
/* 536 */       java.sql.PreparedStatement psmnt = (com.mysql.jdbc.PreparedStatement)connection
/* 536 */         .prepareStatement("UPDATE stock SET type='" + type + "',category ='" + cat + "',itemcode='" + cod + "',vat='" + vat + "',buyingprice='" + spri + "',units='" + tunits + "',name='" + nam + "',description='" + description + "',quantity='" + quantity + "',supplier='" + supplier + "',reorder_level='" + re + "',price='" + pric + "' WHERE Itemcode='" + this.itemcode + "' ");
/*     */ 
/* 539 */       int s = psmnt.executeUpdate();
/* 540 */       if (s > 0)
/*     */       {
/* 543 */         JOptionPane.showMessageDialog(null, "Thank you", " Successfully Saved!", 1);
/*     */       }
/*     */       else
/*     */       {
/* 548 */         JOptionPane.showMessageDialog(null, "Sorry, Not All Details Were Saved!", "Error!", 0);
/*     */       }
/* 550 */       psmnt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 554 */       System.out.println("Found some error : " + ex);
/* 555 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateInvoice(String Itemcode, String item, String description)
/*     */   {
/*     */     try
/*     */     {
/* 569 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 570 */       java.sql.Connection connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, username, password);
/*     */ 
/* 572 */       java.sql.PreparedStatement psmnt = (com.mysql.jdbc.PreparedStatement)connection
/* 572 */         .prepareStatement("UPDATE invoice SET  Itemcode='" + Itemcode + "',Item='" + item + "',description='" + description + "' WHERE Itemcode='" + this.itemcode + "' ");
/*     */ 
/* 575 */       s = psmnt.executeUpdate();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       int s;
/* 578 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete() {
/* 583 */     String codb = this.code1.getText();
/* 584 */     String str = "delete  from stock where itemcode= '" + codb + "'";
/*     */     try
/*     */     {
/* 592 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 594 */       Statement st = cn.createStatement();
/*     */ 
/* 596 */       int e = st.executeUpdate(str);
/* 597 */       if (e > 0)
/*     */       {
/* 600 */         JOptionPane.showMessageDialog(null, "Success!", "DELETED", 1);
/* 601 */         dispose();
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/* 605 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void searchfor(String icode)
/*     */   {
/* 613 */     this.code1.setText(icode);
/*     */     try {
/* 615 */       Class.forName("com.mysql.jdbc.Driver");
/* 616 */       java.sql.Connection conn = DriverManager.getConnection(url, username, password);
/* 617 */       String sql = "SELECT name,description,quantity,reorder_level,price,supplier,vat,buyingprice,units,category,type FROM stock WHERE Itemcode='" + icode + "'";
/* 618 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 619 */       ResultSet resultSet = stmt.executeQuery();
/* 620 */       while (resultSet.next()) {
/* 621 */         this.name1.setText(resultSet.getString(1));
/* 622 */         this.des1.setText(resultSet.getString(2));
/* 623 */         this.quan.setText(resultSet.getString(3));
/* 624 */         this.reorder1.setText(resultSet.getString(4));
/* 625 */         this.price1.setText(resultSet.getString(5));
/* 626 */         this.jComboBox3.setSelectedItem(resultSet.getString(6));
/* 627 */         this.buye.setText(resultSet.getString(8));
/* 628 */         this.jComboBox4.setSelectedItem(resultSet.getString(9));
/* 629 */         this.vate.setText(resultSet.getString(7));
/* 630 */         this.jComboBox6.setSelectedItem(resultSet.getString(10));
/* 631 */         this.jComboBox5.setSelectedIndex(resultSet.getInt(11));
/*     */       }
/* 633 */       conn.close();
/*     */     } catch (Exception exc) {
/* 635 */       exc.printStackTrace();
/* 636 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updatedamagedgoods()
/*     */   {
/* 646 */     String codb = this.code1.getText();
/* 647 */     String str = "update damagedgoods set itemcode= '" + codb + "' where itemcode='" + this.itemcode + "' ";
/*     */     try
/*     */     {
/* 655 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 657 */       Statement st = cn.createStatement();
/*     */ 
/* 659 */       e = st.executeUpdate(str);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int e;
/* 663 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateinvoice()
/*     */   {
/* 672 */     String codb = this.code1.getText();
/* 673 */     String str = "update invoice set itemcode= '" + codb + "' where itemcode='" + this.itemcode + "' ";
/*     */     try
/*     */     {
/* 681 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 683 */       Statement st = cn.createStatement();
/*     */ 
/* 685 */       e = st.executeUpdate(str);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int e;
/* 689 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updatepurchases()
/*     */   {
/* 698 */     String codb = this.code1.getText();
/* 699 */     String str = "update purchases set itemcode= '" + codb + "' where itemcode='" + this.itemcode + "' ";
/*     */     try
/*     */     {
/* 707 */       java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*     */ 
/* 709 */       Statement st = cn.createStatement();
/*     */ 
/* 711 */       e = st.executeUpdate(str);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       int e;
/* 715 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 736 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 737 */         if ("Nimbus".equals(info.getName())) {
/* 738 */           UIManager.setLookAndFeel(info.getClassName());
/* 739 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 743 */       Logger.getLogger(editItem.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 745 */       Logger.getLogger(editItem.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 747 */       Logger.getLogger(editItem.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 749 */       Logger.getLogger(editItem.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 756 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 759 */         editItem dialog = new editItem(new JFrame(), true);
/* 760 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 764 */             System.exit(0);
/*     */           }
/*     */         });
/* 767 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.editItem
 * JD-Core Version:    0.6.0
 */