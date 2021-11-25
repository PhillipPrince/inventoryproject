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
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
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
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class DEL extends JDialog
/*     */ {
/*  22 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  23 */   static String username = "root";
/*  24 */   static String password = "this";
/*     */   public JButton jButton1;
/*     */   public JComboBox jComboBox1;
/*     */   public JLabel jLabel1;
/*     */   public JLabel jLabel2;
/*     */   public JLabel jLabel3;
/*     */   public JLabel jLabel4;
/*     */   public JLabel jLabel5;
/*     */   public JPanel jPanel1;
/*     */   public JPanel jPanel2;
/*     */   public JPanel jPanel3;
/*     */   public JTextField jTextField2;
/*     */   public JTextField jTextField3;
/*     */   public JTextField jTextField4;
/*     */ 
/*     */   public DEL(Frame parent, boolean modal)
/*     */   {
/*  29 */     super(parent, modal);
/*  30 */     initComponents();
/*  31 */     setLocationRelativeTo(null);
/*     */     try {
/*  33 */       Class.forName("com.mysql.jdbc.Driver");
/*  34 */       Connection conn = DriverManager.getConnection(url, username, password);
/*  35 */       Statement st = conn.createStatement();
/*  36 */       ResultSet rs = st.executeQuery("Select * from customer");
/*  37 */       while (rs.next())
/*     */       {
/*  39 */         this.jComboBox1.addItem(rs.getString("name"));
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  58 */     this.jPanel1 = new JPanel();
/*  59 */     this.jPanel2 = new JPanel();
/*  60 */     this.jLabel2 = new JLabel();
/*  61 */     this.jLabel3 = new JLabel();
/*  62 */     this.jTextField2 = new JTextField();
/*  63 */     this.jTextField3 = new JTextField();
/*  64 */     this.jTextField4 = new JTextField();
/*  65 */     this.jLabel4 = new JLabel();
/*  66 */     this.jComboBox1 = new JComboBox();
/*  67 */     this.jLabel1 = new JLabel();
/*  68 */     this.jButton1 = new JButton();
/*  69 */     this.jPanel3 = new JPanel();
/*  70 */     this.jLabel5 = new JLabel();
/*     */ 
/*  72 */     setDefaultCloseOperation(2);
/*     */ 
/*  74 */     this.jPanel2.setBackground(new Color(153, 153, 255));
/*     */ 
/*  76 */     this.jLabel2.setText("Id.No");
/*     */ 
/*  78 */     this.jLabel3.setText("Phoneno");
/*     */ 
/*  80 */     this.jLabel4.setText("Address");
/*     */ 
/*  82 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  84 */         DEL.this.jComboBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  88 */     this.jLabel1.setText("Name");
/*     */ 
/*  90 */     this.jButton1.setText("DELETE");
/*  91 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  93 */         DEL.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  97 */     this.jPanel3.setBackground(new Color(0, 0, 0));
/*  98 */     this.jPanel3.setBorder(new SoftBevelBorder(0));
/*     */ 
/* 100 */     this.jLabel5.setBackground(new Color(0, 0, 0));
/* 101 */     this.jLabel5.setFont(new Font("Times New Roman", 1, 12));
/* 102 */     this.jLabel5.setForeground(new Color(204, 204, 204));
/* 103 */     this.jLabel5.setText("CUSTOMER DELETE");
/*     */ 
/* 105 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 106 */     this.jPanel3.setLayout(jPanel3Layout);
/* 107 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 108 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 109 */       .addGroup(jPanel3Layout
/* 109 */       .createSequentialGroup()
/* 110 */       .addGap(26, 26, 26)
/* 111 */       .addComponent(this.jLabel5, -2, 155, -2)
/* 112 */       .addContainerGap(260, 32767)));
/*     */ 
/* 114 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 115 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 116 */       .addGroup(jPanel3Layout
/* 116 */       .createSequentialGroup()
/* 117 */       .addContainerGap()
/* 118 */       .addComponent(this.jLabel5)
/* 119 */       .addContainerGap(12, 32767)));
/*     */ 
/* 122 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 123 */     this.jPanel2.setLayout(jPanel2Layout);
/* 124 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 125 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 126 */       .addGroup(jPanel2Layout
/* 126 */       .createSequentialGroup()
/* 127 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 128 */       .addGap(0, 1, 32767))
/* 129 */       .addGroup(jPanel2Layout
/* 129 */       .createSequentialGroup()
/* 130 */       .addGap(43, 43, 43)
/* 131 */       .addGroup(jPanel2Layout
/* 131 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 132 */       .addComponent(this.jLabel4)
/* 133 */       .addComponent(this.jLabel3)
/* 134 */       .addComponent(this.jLabel2)
/* 135 */       .addComponent(this.jLabel1))
/* 136 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 137 */       .addGroup(jPanel2Layout
/* 137 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 138 */       .addComponent(this.jButton1)
/* 139 */       .addGroup(jPanel2Layout
/* 139 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 140 */       .addComponent(this.jTextField3)
/* 141 */       .addComponent(this.jTextField4)
/* 142 */       .addComponent(this.jComboBox1, 0, 199, 32767)
/* 143 */       .addComponent(this.jTextField2)))
/* 144 */       .addGap(84, 84, 84)));
/*     */ 
/* 146 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 147 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 148 */       .addGroup(jPanel2Layout
/* 148 */       .createSequentialGroup()
/* 149 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 150 */       .addGap(17, 17, 17)
/* 151 */       .addGroup(jPanel2Layout
/* 151 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 152 */       .addComponent(this.jComboBox1, -2, -1, -2)
/* 153 */       .addComponent(this.jLabel1))
/* 154 */       .addGap(18, 18, 18)
/* 155 */       .addGroup(jPanel2Layout
/* 155 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 156 */       .addComponent(this.jTextField3, -2, -1, -2)
/* 157 */       .addComponent(this.jLabel3))
/* 158 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, 32767)
/* 159 */       .addGroup(jPanel2Layout
/* 159 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 160 */       .addComponent(this.jLabel2)
/* 161 */       .addComponent(this.jTextField2, -2, -1, -2))
/* 162 */       .addGap(24, 24, 24)
/* 163 */       .addGroup(jPanel2Layout
/* 163 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 164 */       .addComponent(this.jTextField4, -2, -1, -2)
/* 165 */       .addComponent(this.jLabel4))
/* 166 */       .addGap(14, 14, 14)
/* 167 */       .addComponent(this.jButton1)));
/*     */ 
/* 170 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 171 */     this.jPanel1.setLayout(jPanel1Layout);
/* 172 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 173 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 174 */       .addGroup(jPanel1Layout
/* 174 */       .createSequentialGroup()
/* 175 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 176 */       .addGap(0, 0, 32767)));
/*     */ 
/* 178 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 179 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 180 */       .addGroup(jPanel1Layout
/* 180 */       .createSequentialGroup()
/* 181 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 182 */       .addGap(0, 0, 32767)));
/*     */ 
/* 185 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 186 */     getContentPane().setLayout(layout);
/* 187 */     layout.setHorizontalGroup(layout
/* 188 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 189 */       .addGroup(GroupLayout.Alignment.TRAILING, layout
/* 189 */       .createSequentialGroup()
/* 190 */       .addGap(0, 0, 32767)
/* 191 */       .addComponent(this.jPanel1, -2, -1, -2)));
/*     */ 
/* 193 */     layout.setVerticalGroup(layout
/* 194 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 195 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 198 */     pack();
/*     */   }
/*     */ 
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 202 */     String g = (String)this.jComboBox1.getSelectedItem();
/*     */     try {
/* 204 */       Class.forName("com.mysql.jdbc.Driver");
/* 205 */       Connection conn = DriverManager.getConnection(url, username, password);
/* 206 */       Statement st = conn.createStatement();
/* 207 */       ResultSet rs = st.executeQuery("Select * from customer where name = '" + g + "'");
/* 208 */       while (rs.next()) {
/* 209 */         this.jTextField2.setText(rs.getString(3));
/* 210 */         this.jTextField3.setText(rs.getString(4));
/* 211 */         this.jTextField4.setText(rs.getString(5));
/*     */       }
/*     */     }
/*     */     catch (SQLException e) {
/* 215 */       e.printStackTrace();
/*     */     } catch (Exception f) {
/* 217 */       f.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try
/*     */     {
/* 227 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 228 */       Connection connection = DriverManager.getConnection(url, username, password);
/*     */ 
/* 230 */       PreparedStatement psmnt = connection.prepareStatement("Delete from customer where phoneno='" + this.jTextField2.getText() + "'&& idno='" + this.jTextField3.getText() + "'");
/*     */ 
/* 232 */       int s = psmnt.executeUpdate();
/* 233 */       if (s > 0) {
/* 234 */         JOptionPane.showMessageDialog(null, "success", "deleted", 1);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 240 */       e.printStackTrace();
/* 241 */       JOptionPane.showMessageDialog(null, "did not delete", "error", -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 260 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 261 */         if ("Nimbus".equals(info.getName())) {
/* 262 */           UIManager.setLookAndFeel(info.getClassName());
/* 263 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 267 */       Logger.getLogger(DEL.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 269 */       Logger.getLogger(DEL.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 271 */       Logger.getLogger(DEL.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 273 */       Logger.getLogger(DEL.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 280 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 283 */         DEL dialog = new DEL(new JFrame(), true);
/* 284 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 288 */             System.exit(0);
/*     */           }
/*     */         });
/* 291 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.DEL
 * JD-Core Version:    0.6.0
 */