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
/*     */ public class newsupplier extends JDialog
/*     */ {
/*  18 */   String url = "jdbc:mysql://localhost:3306/inventory";
/*  19 */   static String username = "root";
/*  20 */   static String password = "this";
/*  21 */   int i = 0;
            int s=0;
/*     */   private JTextField add;
/*     */   private JButton jButton2;
/*     */   private JButton jButton4;
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
/*     */   public newsupplier(Frame parent, boolean modal)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     setTitle("NEW SUPPLIERS");
/*  29 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  41 */     this.jPanel1 = new JPanel();
/*  42 */     this.jPanel2 = new JPanel();
/*  43 */     this.jPanel3 = new JPanel();
/*  44 */     this.nam = new JTextField();
/*  45 */     this.jLabel1 = new JLabel();
/*  46 */     this.jLabel2 = new JLabel();
/*  47 */     this.jLabel3 = new JLabel();
/*  48 */     this.jLabel4 = new JLabel();
/*  49 */     this.loc = new JTextField();
/*  50 */     this.phon = new JTextField();
/*  51 */     this.add = new JTextField();
/*  52 */     this.jButton2 = new JButton();
/*  53 */     this.jButton4 = new JButton();
/*     */ 
/*  55 */     setDefaultCloseOperation(2);
/*     */ 
/*  57 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  59 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*     */ 
/*  61 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  62 */     this.jPanel2.setLayout(jPanel2Layout);
/*  63 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  64 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  65 */       .addGap(0, 400, 32767));
/*     */ 
/*  67 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  68 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  69 */       .addGap(0, 26, 32767));
/*     */ 
/*  72 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/*  73 */     this.jPanel3.setBorder(BorderFactory.createBevelBorder(1));
/*     */ 
/*  75 */     this.nam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  77 */     this.jLabel1.setText("NAME:");
/*     */ 
/*  79 */     this.jLabel2.setText("LOCATION:");
/*     */ 
/*  81 */     this.jLabel3.setText("PHONE NO:");
/*     */ 
/*  83 */     this.jLabel4.setText("ADDRESS:");
/*     */ 
/*  85 */     this.loc.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  87 */     this.phon.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  89 */     this.add.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  91 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  92 */     this.jPanel3.setLayout(jPanel3Layout);
/*  93 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  94 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  95 */       .addGroup(jPanel3Layout
/*  95 */       .createSequentialGroup()
/*  96 */       .addGap(23, 23, 23)
/*  97 */       .addGroup(jPanel3Layout
/*  97 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  98 */       .addComponent(this.jLabel1)
/*  99 */       .addComponent(this.jLabel2)
/* 100 */       .addComponent(this.jLabel3, -2, 61, -2)
/* 101 */       .addComponent(this.jLabel4))
/* 102 */       .addGap(23, 23, 23)
/* 103 */       .addGroup(jPanel3Layout
/* 103 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 104 */       .addGroup(jPanel3Layout
/* 104 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 105 */       .addComponent(this.nam)
/* 106 */       .addComponent(this.loc, -1, 171, 32767)
/* 107 */       .addComponent(this.phon, -2, 138, -2))
/* 108 */       .addComponent(this.add, -2, 138, -2))
/* 109 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 111 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 112 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 113 */       .addGroup(jPanel3Layout
/* 113 */       .createSequentialGroup()
/* 114 */       .addContainerGap()
/* 115 */       .addGroup(jPanel3Layout
/* 115 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 116 */       .addComponent(this.nam, -2, -1, -2)
/* 117 */       .addComponent(this.jLabel1))
/* 118 */       .addGap(18, 18, 18)
/* 119 */       .addGroup(jPanel3Layout
/* 119 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 120 */       .addComponent(this.jLabel2)
/* 121 */       .addComponent(this.loc, -2, -1, -2))
/* 122 */       .addGap(20, 20, 20)
/* 123 */       .addGroup(jPanel3Layout
/* 123 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 124 */       .addComponent(this.jLabel3)
/* 125 */       .addComponent(this.phon, -2, -1, -2))
/* 126 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, 32767)
/* 127 */       .addGroup(jPanel3Layout
/* 127 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 128 */       .addComponent(this.jLabel4)
/* 129 */       .addComponent(this.add, -2, -1, -2))
/* 130 */       .addGap(24, 24, 24)));
/*     */ 
/* 133 */     this.jButton2.setText("SAVE");
/* 134 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 136 */         newsupplier.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 140 */     this.jButton4.setText("BACK");
/* 141 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 143 */         newsupplier.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 147 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 148 */     this.jPanel1.setLayout(jPanel1Layout);
/* 149 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 150 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 151 */       .addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 152 */       .addGroup(jPanel1Layout
/* 152 */       .createSequentialGroup()
/* 153 */       .addContainerGap()
/* 154 */       .addGroup(jPanel1Layout
/* 154 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 155 */       .addGroup(jPanel1Layout
/* 155 */       .createSequentialGroup()
/* 156 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 157 */       .addContainerGap())
/* 158 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
/* 158 */       .createSequentialGroup()
/* 159 */       .addGap(0, 0, 32767)
/* 160 */       .addComponent(this.jButton2)
/* 161 */       .addGap(90, 90, 90)
/* 162 */       .addComponent(this.jButton4)
/* 163 */       .addGap(41, 41, 41)))));
/*     */ 
/* 165 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 166 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 167 */       .addGroup(jPanel1Layout
/* 167 */       .createSequentialGroup()
/* 168 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 169 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 170 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 171 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 172 */       .addGroup(jPanel1Layout
/* 172 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 173 */       .addComponent(this.jButton2)
/* 174 */       .addComponent(this.jButton4))
/* 175 */       .addGap(0, 26, 32767)));
/*     */ 
/* 178 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 179 */     getContentPane().setLayout(layout);
/* 180 */     layout.setHorizontalGroup(layout
/* 181 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 182 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 184 */     layout.setVerticalGroup(layout
/* 185 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 186 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 189 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 193 */     save();
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 197 */     dispose();
/*     */   }
/*     */ 
/*     */   public void save()
/*     */   {
/* 204 */     this.i = 0;
/* 205 */     search();
/*     */     try {
/* 207 */       s = (int) Double.parseDouble(this.phon.getText());
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/*     */       double s;
/* 211 */       this.phon.setText("");
/*     */     }
/*     */ 
/* 216 */     if (this.nam.equals("")) {
/* 217 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, Enter name", "Error!", 0);
/* 218 */       this.nam.requestFocus();
/*     */     }
/* 220 */     else if (this.loc.equals(""))
/*     */     {
/* 222 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, Enter location", "Error!", 0);
/* 223 */       this.loc.requestFocus();
/*     */     }
/* 225 */     else if (this.i == 1)
/*     */     {
/* 227 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, This supppler already Exists", "Error!", 0);
/* 228 */       this.nam.requestFocus();
/*     */     }
/* 230 */     else if (this.phon.getText().equals(""))
/*     */     {
/* 232 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, ENTER phone number", "Error!", 0);
/* 233 */       this.phon.requestFocus();
/*     */     }
/* 235 */     else if (this.add.getText().equals(""))
/*     */     {
/* 237 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, ENTER Address", "Error!", 0);
/* 238 */       this.add.requestFocus();
/*     */     }
/*     */     else
/*     */     {
/*     */       try
/*     */       {
/* 244 */         Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 245 */         Connection conn = DriverManager.getConnection(this.url, username, password);
/* 246 */         String sql = "INSERT INTO suppliers(name,location,address,phone) values('" + this.nam.getText() + "','" + this.loc.getText() + "','" + this.add.getText() + "','" + this.phon.getText() + "')";
/* 247 */         PreparedStatement stmt = conn.prepareStatement(sql);
/*     */ 
/* 250 */         int u = stmt.executeUpdate();
/* 251 */         if (u > 0)
/*     */         {
/* 253 */           JOptionPane.showMessageDialog(this.jPanel1, "Saved!", "Success!", 1);
/* 254 */           this.nam.setText("");
/* 255 */           this.loc.setText("");
/* 256 */           this.add.setText("");
/* 257 */           this.phon.setText("");
/* 258 */           this.i = 0;
/*     */         }
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 263 */         ex.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void search()
/*     */   {
/* 273 */     String name = this.nam.getText();
/*     */     try
/*     */     {
/* 276 */       Class.forName("com.mysql.jdbc.Driver");
/* 277 */       Connection conn = DriverManager.getConnection(this.url, username, password);
/* 278 */       String sql = "SELECT * FROM suppliers where name='" + name + "'";
/* 279 */       PreparedStatement stmt = conn.prepareStatement(sql);
/* 280 */       ResultSet resultSet = stmt.executeQuery();
/* 281 */       while (resultSet.next()) {
/* 282 */         this.i = 1;
/*     */       }
/* 284 */       conn.close();
/*     */     } catch (Exception exc) {
/* 286 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 305 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 306 */         if ("Nimbus".equals(info.getName())) {
/* 307 */           UIManager.setLookAndFeel(info.getClassName());
/* 308 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 312 */       Logger.getLogger(newsupplier.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 314 */       Logger.getLogger(newsupplier.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 316 */       Logger.getLogger(newsupplier.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 318 */       Logger.getLogger(newsupplier.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 325 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 328 */         newsupplier dialog = new newsupplier(new JFrame(), true);
/* 329 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 333 */             System.exit(0);
/*     */           }
/*     */         });
/* 336 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.newsupplier
 * JD-Core Version:    0.6.0
 */