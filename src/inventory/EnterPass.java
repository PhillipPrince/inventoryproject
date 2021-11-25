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
/*     */ import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ public class EnterPass extends JDialog
/*     */ {
/*  18 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  19 */   static String username = "root";
/*  20 */   static String password = "this";
/*  21 */   int y = 0;
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPasswordField jPasswordField1;
/*     */ 
/*     */   public EnterPass(Frame parent, boolean modal)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     setLocationRelativeTo(null);
/*     */   }
/*     */   public void passMarch() {
/*  31 */     int r = 0;
/*  32 */     String pass = this.jPasswordField1.getText().toString();
/*     */     try {
/*  34 */       Class.forName("com.mysql.jdbc.Driver");
/*  35 */       Connection conn = DriverManager.getConnection(url, username, password);
/*  36 */       String sql = "SELECT * FROM login where userlevel='3' && password='" + pass + "'";
/*  37 */       PreparedStatement stmt = conn.prepareStatement(sql);
/*  38 */       ResultSet resultSet = stmt.executeQuery();
/*  39 */       while (resultSet.next()) {
/*  40 */         r = 1;
/*     */       }
/*  42 */       conn.close();
/*     */     }
/*     */     catch (Exception exc) {
/*  45 */       System.out.println("process error" + exc);
/*     */     }
/*     */ 
/*  50 */     this.y = r;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  61 */     this.jPanel1 = new JPanel();
/*  62 */     this.jPanel2 = new JPanel();
/*  63 */     this.jLabel1 = new JLabel();
/*  64 */     this.jButton1 = new JButton();
/*  65 */     this.jPasswordField1 = new JPasswordField();
/*     */ 
/*  67 */     setDefaultCloseOperation(2);
/*     */ 
/*  69 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  71 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*     */ 
/*  73 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  74 */     this.jPanel2.setLayout(jPanel2Layout);
/*  75 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  76 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  77 */       .addGap(0, 0, 32767));
/*     */ 
/*  79 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  80 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  81 */       .addGap(0, 35, 32767));
/*     */ 
/*  84 */     this.jLabel1.setText("Enter Admin PassWord:");
/*     */ 
/*  86 */     this.jButton1.setText("OK");
/*  87 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  89 */         EnterPass.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  93 */     this.jPasswordField1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  95 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  96 */     this.jPanel1.setLayout(jPanel1Layout);
/*  97 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  98 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  99 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 100 */       .addGroup(jPanel1Layout
/* 100 */       .createSequentialGroup()
/* 101 */       .addGap(41, 41, 41)
/* 102 */       .addComponent(this.jLabel1)
/* 103 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 104 */       .addComponent(this.jPasswordField1, -2, 139, -2)
/* 105 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 106 */       .addComponent(this.jButton1)
/* 107 */       .addContainerGap(46, 32767)));
/*     */ 
/* 109 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 110 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 111 */       .addGroup(jPanel1Layout
/* 111 */       .createSequentialGroup()
/* 112 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 113 */       .addGap(18, 18, 18)
/* 114 */       .addGroup(jPanel1Layout
/* 114 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 115 */       .addComponent(this.jLabel1)
/* 116 */       .addComponent(this.jButton1)
/* 117 */       .addComponent(this.jPasswordField1, -2, -1, -2))
/* 118 */       .addGap(0, 28, 32767)));
/*     */ 
/* 121 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 122 */     getContentPane().setLayout(layout);
/* 123 */     layout.setHorizontalGroup(layout
/* 124 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 125 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 127 */     layout.setVerticalGroup(layout
/* 128 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 129 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 132 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 136 */     if (this.jPasswordField1.getText().toString().equals("")) {
/* 137 */       JOptionPane.showMessageDialog(null, "Enter password", "Error!", 0);
/*     */     }
/*     */     else {
/* 140 */       passMarch();
/* 141 */       if (this.y == 1) {
/* 142 */         JOptionPane.showMessageDialog(null, "Password Match", "Success", 1);
/* 143 */         dispose();
/*     */       }
/*     */       else {
/* 146 */         JOptionPane.showMessageDialog(null, "Password Did not Match", "Error!", 0);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public int match()
/*     */   {
/* 157 */     return this.y;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 173 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 174 */         if ("Nimbus".equals(info.getName())) {
/* 175 */           UIManager.setLookAndFeel(info.getClassName());
/* 176 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 180 */       Logger.getLogger(EnterPass.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 182 */       Logger.getLogger(EnterPass.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 184 */       Logger.getLogger(EnterPass.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 186 */       Logger.getLogger(EnterPass.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 193 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 196 */         EnterPass dialog = new EnterPass(new JFrame(), true);
/* 197 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 201 */             System.exit(0);
/*     */           }
/*     */         });
/* 204 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.EnterPass
 * JD-Core Version:    0.6.0
 */