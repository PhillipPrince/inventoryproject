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
/*     */ 
/*     */ public class company extends JDialog
/*     */ {
/*  26 */   String username = "root";
/*  27 */   String password = "this";
/*  28 */   String url = "jdbc:mysql://localhost:3306/inventory";
/*     */   ResultSet resultSet;
/*  30 */   String thenam = "n";
/*     */   private JTextField add;
/*     */   private JButton jButton1;
/*     */   private JButton jButton3;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JTextField nam;
/*     */   private JTextField ph;
/*     */ 
/*     */   public company(Frame parent, boolean modal)
/*     */   {
/*  34 */     super(parent, modal);
/*  35 */     initComponents();
/*  36 */     setLocationRelativeTo(null);
/*  37 */     setResizable(false);
/*  38 */     setAlwaysOnTop(true);
/*     */ 
/*  40 */     setTitle("COMPANY DETAILS");
/*  41 */     fill();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  53 */     this.jPanel1 = new JPanel();
/*  54 */     this.jPanel2 = new JPanel();
/*  55 */     this.jLabel6 = new JLabel();
/*  56 */     this.jPanel3 = new JPanel();
/*  57 */     this.jLabel1 = new JLabel();
/*  58 */     this.nam = new JTextField();
/*  59 */     this.jLabel2 = new JLabel();
/*  60 */     this.add = new JTextField();
/*  61 */     this.jLabel3 = new JLabel();
/*  62 */     this.jLabel7 = new JLabel();
/*  63 */     this.ph = new JTextField();
/*  64 */     this.jButton1 = new JButton();
/*  65 */     this.jButton3 = new JButton();
/*     */ 
/*  67 */     setDefaultCloseOperation(2);
/*     */ 
/*  69 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  71 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*     */ 
/*  73 */     this.jLabel6.setFont(new Font("Arial", 1, 12));
/*  74 */     this.jLabel6.setForeground(new Color(204, 204, 204));
/*  75 */     this.jLabel6.setText("COMPANY DETAILS");
/*     */ 
/*  77 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  78 */     this.jPanel2.setLayout(jPanel2Layout);
/*  79 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  80 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  81 */       .addGroup(jPanel2Layout
/*  81 */       .createSequentialGroup()
/*  82 */       .addContainerGap()
/*  83 */       .addComponent(this.jLabel6)
/*  84 */       .addContainerGap(-1, 32767)));
/*     */ 
/*  86 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  87 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  88 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout
/*  88 */       .createSequentialGroup()
/*  89 */       .addContainerGap(-1, 32767)
/*  90 */       .addComponent(this.jLabel6)
/*  91 */       .addContainerGap()));
/*     */ 
/*  94 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/*  95 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/*  97 */     this.jLabel1.setFont(new Font("Arial", 0, 12));
/*  98 */     this.jLabel1.setText("NAME:");
/*     */ 
/* 100 */     this.nam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 102 */     this.jLabel2.setFont(new Font("Arial", 0, 12));
/* 103 */     this.jLabel2.setText("ADDRESS");
/*     */ 
/* 105 */     this.add.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 107 */     this.jLabel3.setText("(e.g 234,Nairobi)");
/*     */ 
/* 109 */     this.jLabel7.setFont(new Font("Arial Unicode MS", 0, 11));
/* 110 */     this.jLabel7.setText("PHONE NO:");
/*     */ 
/* 112 */     this.ph.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 114 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 115 */     this.jPanel3.setLayout(jPanel3Layout);
/* 116 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 117 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 118 */       .addGroup(jPanel3Layout
/* 118 */       .createSequentialGroup()
/* 119 */       .addGroup(jPanel3Layout
/* 119 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 120 */       .addGroup(jPanel3Layout
/* 120 */       .createSequentialGroup()
/* 121 */       .addGroup(jPanel3Layout
/* 121 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 122 */       .addGroup(jPanel3Layout
/* 122 */       .createSequentialGroup()
/* 123 */       .addGap(31, 31, 31)
/* 124 */       .addGroup(jPanel3Layout
/* 124 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 125 */       .addComponent(this.jLabel1)
/* 126 */       .addComponent(this.jLabel2))
/* 127 */       .addGap(24, 24, 24))
/* 128 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout
/* 128 */       .createSequentialGroup()
/* 129 */       .addContainerGap()
/* 130 */       .addComponent(this.jLabel7, -2, 72, -2)
/* 131 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
/* 132 */       .addGroup(jPanel3Layout
/* 132 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 133 */       .addComponent(this.nam, -2, 256, -2)
/* 134 */       .addComponent(this.add, -2, 164, -2)
/* 135 */       .addComponent(this.ph, -2, 163, -2)))
/* 136 */       .addGroup(jPanel3Layout
/* 136 */       .createSequentialGroup()
/* 137 */       .addGap(158, 158, 158)
/* 138 */       .addComponent(this.jLabel3, -2, 141, -2)))
/* 139 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 141 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 142 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 143 */       .addGroup(jPanel3Layout
/* 143 */       .createSequentialGroup()
/* 144 */       .addGap(19, 19, 19)
/* 145 */       .addGroup(jPanel3Layout
/* 145 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 146 */       .addComponent(this.jLabel1)
/* 147 */       .addComponent(this.nam, -2, -1, -2))
/* 148 */       .addGap(18, 18, 18)
/* 149 */       .addGroup(jPanel3Layout
/* 149 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 150 */       .addComponent(this.jLabel2)
/* 151 */       .addComponent(this.add, -2, -1, -2))
/* 152 */       .addGap(18, 18, 18)
/* 153 */       .addComponent(this.jLabel3)
/* 154 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 155 */       .addGroup(jPanel3Layout
/* 155 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 156 */       .addComponent(this.ph, -2, -1, -2)
/* 157 */       .addComponent(this.jLabel7))
/* 158 */       .addGap(0, 17, 32767)));
/*     */ 
/* 161 */     this.jButton1.setText("SAVE");
/* 162 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 164 */         company.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 168 */     this.jButton3.setText("BACK");
/* 169 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 171 */         company.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 175 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 176 */     this.jPanel1.setLayout(jPanel1Layout);
/* 177 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 178 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 179 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 180 */       .addGroup(jPanel1Layout
/* 180 */       .createSequentialGroup()
/* 181 */       .addContainerGap()
/* 182 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 183 */       .addContainerGap())
/* 184 */       .addGroup(jPanel1Layout
/* 184 */       .createSequentialGroup()
/* 185 */       .addGap(169, 169, 169)
/* 186 */       .addComponent(this.jButton1)
/* 187 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 188 */       .addComponent(this.jButton3)
/* 189 */       .addGap(36, 36, 36)));
/*     */ 
/* 191 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 192 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 193 */       .addGroup(jPanel1Layout
/* 193 */       .createSequentialGroup()
/* 194 */       .addComponent(this.jPanel2, -2, 33, -2)
/* 195 */       .addGap(18, 18, 18)
/* 196 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 197 */       .addGap(18, 18, 18)
/* 198 */       .addGroup(jPanel1Layout
/* 198 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 199 */       .addComponent(this.jButton1)
/* 200 */       .addComponent(this.jButton3))
/* 201 */       .addContainerGap(20, 32767)));
/*     */ 
/* 204 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 205 */     getContentPane().setLayout(layout);
/* 206 */     layout.setHorizontalGroup(layout
/* 207 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */       .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */ 
/* 210 */     layout.setVerticalGroup(layout
/* 211 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 212 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 215 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
    double f;
/*     */     try {
/* 221 */       f = Double.parseDouble(this.ph.getText());
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/*     */       
/* 225 */       this.ph.setText("");
/*     */     }
/*     */ 
/* 229 */     if (this.nam.getText().equals("")) {
/* 230 */       JOptionPane.showMessageDialog(this.jPanel1, "NAME Empty", "NOTICE!", 1);
/*     */     }
/* 232 */     else if (this.add.getText().equals("")) {
/* 233 */       JOptionPane.showMessageDialog(this.jPanel1, "Address Empty", "NOTICE!", 1);
/*     */     }
/* 236 */     else if (this.ph.getText().equals(""))
/* 237 */       JOptionPane.showMessageDialog(this.jPanel1, "Phone number is Empty", "NOTICE!", 1);
/* 238 */     else if (this.thenam.equals("n"))
/*     */     {
/* 240 */       prepare();
/*     */     }
/* 242 */     else update();
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 252 */     dispose();
/*     */   }
/*     */   public void fill() {
/*     */     try {
/* 256 */       Class.forName("com.mysql.jdbc.Driver");
/* 257 */       com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection)DriverManager.getConnection(this.url, this.username, this.password);
/* 258 */       String sql = "SELECT * FROM company";
/* 259 */       com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement)conn.prepareStatement(sql);
/* 260 */       this.resultSet = stmt.executeQuery();
/* 261 */       while (this.resultSet.next()) {
/* 262 */         this.nam.setText(this.resultSet.getString(1));
/* 263 */         this.add.setText(this.resultSet.getString(2));
/* 264 */         this.thenam = this.resultSet.getString(1);
/* 265 */         this.ph.setText(this.resultSet.getString(3));
/*     */       }
/*     */     }
/*     */     catch (Exception exc) {
/* 269 */       System.out.println("process error" + exc);
/* 270 */       JOptionPane.showMessageDialog(this.jPanel1, "Sorry, connection Failed!\nOpen Xampp And Set MySql Running", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void prepare()
/*     */   {
/*     */     try
/*     */     {
/* 282 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 283 */       java.sql.Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
/*     */ 
/* 285 */       java.sql.PreparedStatement psmnt = connection
/* 285 */         .prepareStatement("INSERT INTO  company values(?,?,?)");
/*     */ 
/* 287 */       psmnt.setString(1, this.nam.getText());
/* 288 */       psmnt.setString(2, this.add.getText());
/*     */ 
/* 291 */       psmnt.setString(3, this.ph.getText());
/*     */ 
/* 297 */       int s = psmnt.executeUpdate();
/*     */ 
/* 300 */       if (s > 0)
/*     */       {
/* 302 */         JOptionPane.showMessageDialog(null, "Succesful", "saved!", 1);
/*     */       }
/*     */       else {
/* 305 */         System.out.println("unsucessfull item not found ");
/* 306 */         JOptionPane.showMessageDialog(null, "Sorry, Not All Details Were Saved!", "Error!", 0);
/*     */       }
/* 308 */       connection.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 312 */       System.out.println("Found some error : " + ex);
/* 313 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/*     */     try {
/* 320 */       String jj = this.nam.getText();
/* 321 */       String address = this.add.getText();
/* 322 */       String phone = this.ph.getText();
/* 323 */       Class.forName("com.mysql.jdbc.Driver").newInstance();
/* 324 */       com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(this.url, this.username, this.password);
/* 325 */       String sql = "update company set name='" + jj + "' ,address='" + address + "' ,phone = '" + phone + "'where name='" + this.thenam + "'";
/* 326 */       com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement)connection.prepareStatement(sql);
/*     */ 
/* 329 */       int s = stmt.executeUpdate();
/*     */ 
/* 332 */       if (s > 0) {
/* 333 */         JOptionPane.showMessageDialog(this.jPanel1, "RECORDS HAVE BEEN SAVED", "Successful!", 1);
/*     */       }
/*     */       else
/*     */       {
/* 337 */         JOptionPane.showMessageDialog(this.jPanel1, "RECORDS NOT SAVED", "UnSuccessful!", 0);
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 342 */       System.out.println("Found some error : " + ex);
/* 343 */       JOptionPane.showMessageDialog(null, "Error " + ex + "", "Error!", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 360 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 362 */         company dialog = new company(new JFrame(), true);
/* 363 */         dialog.addWindowListener(new WindowAdapter() {
/*     */           public void windowClosing(WindowEvent e) {
/* 365 */             System.exit(0);
/*     */           }
/*     */         });
/* 368 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.company
 * JD-Core Version:    0.6.0
 */