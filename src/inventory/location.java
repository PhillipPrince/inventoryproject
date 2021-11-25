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
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
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
/*     */ public class location extends JDialog
/*     */ {
/*  18 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  19 */   static String username = "root";
/*  20 */   static String password = "this";
/*     */   private JTextField editter;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
            String gg;
/*     */ 
/*     */   public location(Frame parent, boolean modal)
/*     */   {
/*  25 */     super(parent, modal);
/*  26 */     initComponents();
/*  27 */     setTitle("LOCATIONS");
/*  28 */     setLocationRelativeTo(null);
/*     */     try {
/*  30 */       Class.forName("com.mysql.jdbc.Driver");
/*  31 */       Connection conn = DriverManager.getConnection(url, username, password);
/*  32 */       String sql = "SELECT name FROM location";
/*  33 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*  34 */       ResultSet resultSet = stmt.executeQuery();
/*  35 */       while (resultSet.next()) {
/*  36 */         this.jComboBox1.addItem(resultSet.getString(1));
/*     */       }
/*  38 */       conn.close();
/*     */     } catch (Exception exc) {
/*  40 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete()
/*     */   {
/*  48 */     String myname = (String)this.jComboBox1.getSelectedItem();
/*     */     try
/*     */     {
/*  52 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/*  53 */       Connection conn = DriverManager.getConnection(url, username, password);
/*  54 */       String sql = "delete from location where name='" + myname + "'";
/*     */ 
/*  56 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*     */ 
/*  60 */       int u = stmt.executeUpdate();
/*  61 */       if (u > 0) {
/*  62 */         JOptionPane.showMessageDialog(this.jPanel1, "DELETED!", "Success!", 1);
/*  63 */         dispose();
/*     */       }
/*     */       else
/*     */       {
/*  69 */         JOptionPane.showMessageDialog(this.jPanel1, "Not done!", "ERROR!", 0);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  78 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  95 */     this.jPanel1 = new JPanel();
/*  96 */     this.jPanel2 = new JPanel();
/*  97 */     this.jComboBox1 = new JComboBox();
/*  98 */     this.jLabel1 = new JLabel();
/*  99 */     this.jLabel2 = new JLabel();
/* 100 */     this.editter = new JTextField();
/* 101 */     this.jButton1 = new JButton();
/* 102 */     this.jButton2 = new JButton();
/* 103 */     this.jButton3 = new JButton();
/*     */ 
/* 105 */     setDefaultCloseOperation(2);
/*     */ 
/* 107 */     this.jPanel1.setBackground(new Color(204, 204, 204));
/*     */ 
/* 109 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*     */ 
/* 111 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 112 */     this.jPanel2.setLayout(jPanel2Layout);
/* 113 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 114 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 115 */       .addGap(0, 0, 32767));
/*     */ 
/* 117 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 118 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 119 */       .addGap(0, 25, 32767));
/*     */ 
/* 122 */     this.jLabel1.setText("LOCATION");
/*     */ 
/* 124 */     this.jLabel2.setText("NEW/EDIT:");
/*     */ 
/* 126 */     this.editter.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 128 */     this.jButton1.setText("EDIT");
/* 129 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 131 */         location.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 135 */     this.jButton2.setText("SAVE");
/* 136 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 138 */         location.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 142 */     this.jButton3.setText("DELETE");
/* 143 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 145 */         location.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 149 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 150 */     this.jPanel1.setLayout(jPanel1Layout);
/* 151 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 152 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 153 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 154 */       .addGroup(jPanel1Layout
/* 154 */       .createSequentialGroup()
/* 155 */       .addGroup(jPanel1Layout
/* 155 */       .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 156 */       .addGroup(jPanel1Layout
/* 156 */       .createSequentialGroup()
/* 157 */       .addGap(21, 21, 21)
/* 158 */       .addComponent(this.jButton1)
/* 159 */       .addGap(32, 32, 32)
/* 160 */       .addComponent(this.jButton2)
/* 161 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767)
/* 162 */       .addComponent(this.jButton3))
/* 163 */       .addGroup(jPanel1Layout
/* 163 */       .createSequentialGroup()
/* 164 */       .addContainerGap()
/* 165 */       .addGroup(jPanel1Layout
/* 165 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 166 */       .addComponent(this.jLabel1)
/* 167 */       .addComponent(this.jLabel2))
/* 168 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 169 */       .addGroup(jPanel1Layout
/* 169 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 170 */       .addComponent(this.editter)
/* 171 */       .addComponent(this.jComboBox1, 0, 129, 32767))
/* 172 */       .addGap(65, 65, 65)))
/* 173 */       .addContainerGap(19, 32767)));
/*     */ 
/* 175 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 176 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 177 */       .addGroup(jPanel1Layout
/* 177 */       .createSequentialGroup()
/* 178 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 179 */       .addGap(13, 13, 13)
/* 180 */       .addGroup(jPanel1Layout
/* 180 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 181 */       .addComponent(this.jComboBox1, -2, -1, -2)
/* 182 */       .addComponent(this.jLabel1))
/* 183 */       .addGap(32, 32, 32)
/* 184 */       .addGroup(jPanel1Layout
/* 184 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 185 */       .addComponent(this.jLabel2)
/* 186 */       .addComponent(this.editter, -2, -1, -2))
/* 187 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 188 */       .addGroup(jPanel1Layout
/* 188 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 189 */       .addComponent(this.jButton3)
/* 190 */       .addComponent(this.jButton2)
/* 191 */       .addComponent(this.jButton1))
/* 192 */       .addContainerGap(23, 32767)));
/*     */ 
/* 195 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 196 */     getContentPane().setLayout(layout);
/* 197 */     layout.setHorizontalGroup(layout
/* 198 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 199 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 201 */     layout.setVerticalGroup(layout
/* 202 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 203 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 206 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 211 */     int y = JOptionPane.showConfirmDialog(this.jPanel1, "Do Really You Want to Delete this location?", "Confirm!", 0);
/* 212 */     if (y == 0)
/*     */     {
/* 214 */       delete();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
        
/*     */   {
/* 224 */     String myname = (String)this.jComboBox1.getSelectedItem();
/* 225 */     this.editter.setText(myname);
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
        
/*     */   {
/*     */     try
/*     */     {
/* 232 */       gg = String.valueOf(this.editter.getText());
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       
/* 237 */       this.editter.setText("");
/* 238 */       this.editter.requestFocus();
/* 239 */       JOptionPane.showMessageDialog(this.jPanel1, "EMPTY! NOTHING ENTERED", "ERROR!", 1);
/*     */     }
/*     */ 
/* 243 */     if (this.editter.equals("")) {
/* 244 */       this.editter.requestFocus();
/* 245 */       JOptionPane.showMessageDialog(this.jPanel1, "EMPTY! NOTHING ENTERED", "ERROR!", 1);
/*     */     }
/*     */     else
/*     */     {
/* 251 */       search();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void search()
/*     */   {
/* 257 */     int i = 0;
/*     */ 
/* 259 */     String name = this.editter.getText();
/*     */     try
/*     */     {
/* 262 */       Class.forName("com.mysql.jdbc.Driver");
/* 263 */       Connection conn = DriverManager.getConnection(url, username, password);
/* 264 */       String sql = "SELECT * FROM location where name='" + name + "'";
/* 265 */       PreparedStatement stmt = conn.prepareStatement(sql);
/* 266 */       ResultSet resultSet = stmt.executeQuery();
/* 267 */       while (resultSet.next()) {
/* 268 */         i = 1;
/*     */       }
/* 270 */       conn.close();
/*     */     } catch (Exception exc) {
/* 272 */       System.out.println("process error" + exc);
/*     */     }
/*     */ 
/* 278 */     if (i == 1)
/*     */     {
/* 280 */       update();
/*     */     }
/* 283 */     else if (i == 0)
/* 284 */       insert();
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/* 293 */     String tname = this.editter.getText();
/*     */     try {
/* 295 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 296 */       Connection conn = DriverManager.getConnection(url, username, password);
/* 297 */       String sql = "update location set name ='" + tname + "'";
/* 298 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*     */ 
/* 303 */       int u = stmt.executeUpdate();
/* 304 */       if (u > 0)
/*     */       {
/* 306 */         JOptionPane.showMessageDialog(this.jPanel1, "Saved!", "Success!", 1);
/* 307 */         this.editter.setText("");
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 314 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void insert()
/*     */   {
/*     */     try
/*     */     {
/* 323 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 324 */       Connection conn = DriverManager.getConnection(url, username, password);
/* 325 */       String sql = "INSERT INTO location values(?)";
/* 326 */       PreparedStatement stmt = conn.prepareStatement(sql);
/* 327 */       stmt.setString(1, this.editter.getText());
/*     */ 
/* 331 */       int u = stmt.executeUpdate();
/* 332 */       if (u > 0)
/*     */       {
/* 334 */         JOptionPane.showMessageDialog(this.jPanel1, "Saved!", "Success!", 1);
/* 335 */         this.editter.setText("");
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 342 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 359 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 360 */         if ("Nimbus".equals(info.getName())) {
/* 361 */           UIManager.setLookAndFeel(info.getClassName());
/* 362 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 366 */       Logger.getLogger(location.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 368 */       Logger.getLogger(location.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 370 */       Logger.getLogger(location.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 372 */       Logger.getLogger(location.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 379 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 382 */         location dialog = new location(new JFrame(), true);
/* 383 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 387 */             System.exit(0);
/*     */           }
/*     */         });
/* 390 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.location
 * JD-Core Version:    0.6.0
 */