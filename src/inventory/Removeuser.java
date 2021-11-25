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
/*     */ import java.io.PrintStream;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class Removeuser extends JDialog
/*     */ {
/*  19 */   String url = "jdbc:mysql://localhost:3306/inventory";
/*  20 */   String username = "root";
/*  21 */   String password = "this";
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel3;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */ 
/*     */   public Removeuser(Frame parent, boolean modal)
/*     */   {
/*  27 */     super(parent, modal);
/*  28 */     initComponents();
/*     */ 
/*  30 */     setLocationRelativeTo(null);
/*  31 */     fill();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  44 */     this.jPanel1 = new JPanel();
/*  45 */     this.jLabel1 = new JLabel();
/*  46 */     this.jButton2 = new JButton();
/*  47 */     this.jPanel2 = new JPanel();
/*  48 */     this.jLabel3 = new JLabel();
/*  49 */     this.jButton1 = new JButton();
/*  50 */     this.jComboBox1 = new JComboBox();
/*     */ 
/*  52 */     setDefaultCloseOperation(2);
/*     */ 
/*  54 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  56 */     this.jLabel1.setFont(new Font("Arial Unicode MS", 0, 11));
/*  57 */     this.jLabel1.setText("NAME");
/*     */ 
/*  59 */     this.jButton2.setFont(new Font("Arial Rounded MT Bold", 0, 11));
/*  60 */     this.jButton2.setText("Cancel");
/*  61 */     this.jButton2.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/*  63 */         Removeuser.this.jButton2MouseClicked(evt);
/*     */       }
/*     */     });
/*  67 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  68 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/*  70 */     this.jLabel3.setFont(new Font("Arial Unicode MS", 0, 11));
/*  71 */     this.jLabel3.setForeground(new Color(204, 255, 255));
/*  72 */     this.jLabel3.setText("REMOVE USER");
/*     */ 
/*  74 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  75 */     this.jPanel2.setLayout(jPanel2Layout);
/*  76 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  77 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  78 */       .addGroup(jPanel2Layout
/*  78 */       .createSequentialGroup()
/*  79 */       .addGap(24, 24, 24)
/*  80 */       .addComponent(this.jLabel3, -2, 122, -2)
/*  81 */       .addContainerGap(248, 32767)));
/*     */ 
/*  83 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  84 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  85 */       .addGroup(jPanel2Layout
/*  85 */       .createSequentialGroup()
/*  86 */       .addContainerGap()
/*  87 */       .addComponent(this.jLabel3)
/*  88 */       .addContainerGap(-1, 32767)));
/*     */ 
/*  91 */     this.jButton1.setFont(new Font("Arial Rounded MT Bold", 0, 11));
/*  92 */     this.jButton1.setText("REMOVE");
/*  93 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  95 */         Removeuser.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  99 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 100 */     this.jPanel1.setLayout(jPanel1Layout);
/* 101 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 102 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 103 */       .addGroup(jPanel1Layout
/* 103 */       .createSequentialGroup()
/* 104 */       .addGap(53, 53, 53)
/* 105 */       .addComponent(this.jLabel1, -2, 57, -2)
/* 106 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 107 */       .addGroup(jPanel1Layout
/* 107 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 108 */       .addGroup(jPanel1Layout
/* 108 */       .createSequentialGroup()
/* 109 */       .addComponent(this.jButton1)
/* 110 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 111 */       .addComponent(this.jButton2))
/* 112 */       .addComponent(this.jComboBox1, -2, 181, -2))
/* 113 */       .addContainerGap())
/* 114 */       .addComponent(this.jPanel2, -1, -1, 32767));
/*     */ 
/* 116 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 117 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 118 */       .addGroup(jPanel1Layout
/* 118 */       .createSequentialGroup()
/* 119 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 120 */       .addGap(23, 23, 23)
/* 121 */       .addGroup(jPanel1Layout
/* 121 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 122 */       .addComponent(this.jLabel1)
/* 123 */       .addComponent(this.jComboBox1, -2, -1, -2))
/* 124 */       .addGap(40, 40, 40)
/* 125 */       .addGroup(jPanel1Layout
/* 125 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 126 */       .addComponent(this.jButton1)
/* 127 */       .addComponent(this.jButton2))
/* 128 */       .addContainerGap(74, 32767)));
/*     */ 
/* 131 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 132 */     getContentPane().setLayout(layout);
/* 133 */     layout.setHorizontalGroup(layout
/* 134 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 135 */       .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */ 
/* 137 */     layout.setVerticalGroup(layout
/* 138 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 139 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 142 */     pack();
/*     */   }
/*     */ 
/*     */   public void fill()
/*     */   {
/*     */     try {
/* 148 */       Class.forName("com.mysql.jdbc.Driver");
/* 149 */       java.sql.Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
/* 150 */       String sql = "SELECT user FROM login";
/* 151 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 152 */       ResultSet resultSet = stmt.executeQuery();
/* 153 */       while (resultSet.next()) {
/* 154 */         this.jComboBox1.addItem(resultSet.getString(1));
/* 155 */         System.out.println(resultSet.getString(1));
/*     */       }
/* 157 */       conn.close();
/*     */     } catch (Exception exc) {
/* 159 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void fill1()
/*     */   {
/*     */     try
/*     */     {
/* 167 */       Class.forName("com.mysql.jdbc.Driver");
/* 168 */       java.sql.Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
/* 169 */       String sql = "SELECT user FROM login";
/* 170 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 171 */       ResultSet resultSet = stmt.executeQuery();
/* 172 */       this.jComboBox1.removeAllItems();
/* 173 */       while (resultSet.next()) {
/* 174 */         this.jComboBox1.addItem(resultSet.getString(1));
/*     */       }
/* 176 */       conn.close();
/* 177 */       resultSet.close();
/*     */     } catch (Exception exc) {
/* 179 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String user()
/*     */   {
/* 186 */     String cuser = "";
/*     */     try {
/* 188 */       Class.forName("com.mysql.jdbc.Driver");
/* 189 */       java.sql.Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
/* 190 */       String sql = "SELECT name FROM holder";
/* 191 */       java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
/* 192 */       ResultSet resultSet = stmt.executeQuery();
/*     */ 
/* 194 */       while (resultSet.next()) {
/* 195 */         cuser = resultSet.getString(1);
/*     */       }
/* 197 */       conn.close();
/* 198 */       resultSet.close();
/*     */     } catch (Exception exc) {
/* 200 */       System.out.println("process error" + exc);
/*     */     }
/*     */ 
/* 204 */     return cuser;
/*     */   }
/*     */ 
/*     */   private void jButton2MouseClicked(MouseEvent evt) {
/* 208 */     int y = JOptionPane.showConfirmDialog(this.jPanel1, "Do Really You Want to Discard This?", "Confirm!", 0);
/* 209 */     if (y == 0)
/* 210 */       dispose();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 217 */     String kk = (String)this.jComboBox1.getSelectedItem();
/* 218 */     String ee = "Adminstrator";
/* 219 */     if (kk.equals(ee))
/*     */     {
/* 221 */       JOptionPane.showMessageDialog(this.jPanel1, "Adminstrator Cannot be deleted ", "Error!", 0);
/*     */     }
/*     */     else
/*     */     {
/* 225 */       int x = JOptionPane.showConfirmDialog(this.jPanel1, "Do Really You Want to delete This User?", "Confirm!", 0);
/* 226 */       if (x == 0)
/* 227 */         Allowremove();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void Allowremove()
/*     */   {
/* 243 */     String nam = (String)this.jComboBox1.getSelectedItem();
/*     */     try
/*     */     {
/* 246 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 247 */       java.sql.Connection connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(this.url, this.username, this.password);
/* 248 */       String sql = "DELETE FROM login where user='" + nam + "'";
/* 249 */       com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 252 */       int s = stmt.executeUpdate();
/* 253 */       if (s > 0) {
/* 254 */         JOptionPane.showMessageDialog(this.jPanel1, "User deleted", "Successful!", 1);
/*     */ 
/* 256 */         if (nam.equals(user()))
/*     */         {
/* 259 */           System.exit(0);
/*     */         }
/* 261 */         fill1();
/*     */       }
/*     */       else
/*     */       {
/* 265 */         JOptionPane.showMessageDialog(this.jPanel1, "User not deleted", "UnSuccessful!", 0);
/*     */       }
/* 267 */       stmt.close();
/* 268 */       connection.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 272 */       System.out.println("Found some error : " + ex);
/* 273 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 291 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 292 */         if ("Nimbus".equals(info.getName())) {
/* 293 */           UIManager.setLookAndFeel(info.getClassName());
/* 294 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 298 */       Logger.getLogger(Removeuser.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 300 */       Logger.getLogger(Removeuser.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 302 */       Logger.getLogger(Removeuser.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 304 */       Logger.getLogger(Removeuser.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 311 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 314 */         Removeuser dialog = new Removeuser(new JFrame(), true);
/* 315 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 319 */             System.exit(0);
/*     */           }
/*     */         });
/* 322 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.Removeuser
 * JD-Core Version:    0.6.0
 */