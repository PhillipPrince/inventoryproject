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
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
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
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class userManager extends JDialog
/*     */ {
/*     */   JTable table;
/*  25 */   String ip = "localhost";
/*  26 */   String[][] list = (String[][])null;
/*  27 */   DBConnection nn = new DBConnection();
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */ 
/*     */   public userManager(Frame parent, boolean modal)
/*     */   {
/*  32 */     super(parent, modal);
/*  33 */     setResizable(false);
/*  34 */     initComponents();
/*  35 */     setLocationRelativeTo(null);
/*  36 */     tablep();
/*     */   }
/*     */ 
/*     */   public void tablep()
/*     */   {
/*  43 */     String[] headers = { "User Name", "User Level" };
/*     */ 
/*  47 */     this.list = getDatap();
/*     */ 
/*  49 */     DefaultTableModel model = new DefaultTableModel(this.list, headers);
/*  50 */     this.table = new JTable(model);
/*     */ 
/*  53 */     JScrollPane scrollPane = new JScrollPane(this.table);
/*  54 */     this.table.setFillsViewportHeight(true);
/*  55 */     this.jPanel3.add(scrollPane, "Center");
/*  56 */     scrollPane.setBounds(0, 0, 560, 225);
/*  57 */     this.table.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e) {
/*  60 */         int row = userManager.this.table.getSelectedRow();
/*  61 */         String adm = userManager.this.list[row][0];
/*  62 */         userEdit nn = new userEdit(new JFrame(), true);
/*     */ 
/*  64 */         nn.fill(adm);
/*  65 */         System.out.print(adm);
/*  66 */         nn.setVisible(true);
/*  67 */         userManager.this.update();
/*  68 */         userManager.this.list = userManager.this.getDatap();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public String[][] getDatap()
/*     */   {
/*  77 */     String[][] sample = (String[][])null;
/*     */ 
/*  81 */     String sql = "SELECT user,userlevel from login order by user ASC ";
/*     */     try
/*     */     {
/*  91 */       Connection con = this.nn.getDBConnection();
/*  92 */       PreparedStatement st = con.prepareStatement(sql);
/*  93 */       ResultSet rs = st.executeQuery();
/*     */ 
/*  96 */       if (rs.next()) {
/*  97 */         rs.last();
/*     */ 
/*  99 */         sample = new String[rs.getRow()][2];
/* 100 */         rs.beforeFirst();
/*     */       }
/* 102 */       int rowcount = 0;
/*     */ 
/* 104 */       while (rs.next())
/*     */       {
/* 106 */         sample[rowcount][0] = rs.getString(1);
/* 107 */         sample[rowcount][1] = rs.getString(2);
/*     */ 
/* 112 */         System.out.println(rs.getString(1));
/*     */ 
/* 114 */         rowcount++;
/*     */       }
/*     */ 
/* 117 */       rs.close();
/* 118 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 122 */       e.printStackTrace();
/*     */     }
/* 124 */     return sample;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 136 */     this.jPanel1 = new JPanel();
/* 137 */     this.jPanel2 = new JPanel();
/* 138 */     this.jLabel1 = new JLabel();
/* 139 */     this.jPanel3 = new JPanel();
/* 140 */     this.jButton1 = new JButton();
/*     */ 
/* 142 */     setDefaultCloseOperation(2);
/*     */ 
/* 144 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/* 145 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*     */ 
/* 147 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/* 148 */     this.jPanel2.setBorder(BorderFactory.createBevelBorder(0));
/*     */ 
/* 150 */     this.jLabel1.setFont(new Font("Arial Rounded MT Bold", 0, 11));
/* 151 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 152 */     this.jLabel1.setText("USER MANAGEMENT");
/*     */ 
/* 154 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 155 */     this.jPanel2.setLayout(jPanel2Layout);
/* 156 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 157 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 158 */       .addGroup(jPanel2Layout
/* 158 */       .createSequentialGroup()
/* 159 */       .addContainerGap()
/* 160 */       .addComponent(this.jLabel1)
/* 161 */       .addContainerGap(455, 32767)));
/*     */ 
/* 163 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 164 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 165 */       .addGroup(jPanel2Layout
/* 165 */       .createSequentialGroup()
/* 166 */       .addContainerGap()
/* 167 */       .addComponent(this.jLabel1)
/* 168 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 171 */     this.jPanel3.setBackground(new Color(153, 153, 255));
/* 172 */     this.jPanel3.setBorder(BorderFactory.createBevelBorder(1));
/*     */ 
/* 174 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 175 */     this.jPanel3.setLayout(jPanel3Layout);
/* 176 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 177 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 178 */       .addGap(0, 0, 32767));
/*     */ 
/* 180 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 181 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 182 */       .addGap(0, 221, 32767));
/*     */ 
/* 185 */     this.jButton1.setText("NEW USER");
/* 186 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 188 */         userManager.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 192 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 193 */     this.jPanel1.setLayout(jPanel1Layout);
/* 194 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 195 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 196 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 197 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
/* 197 */       .createSequentialGroup()
/* 198 */       .addContainerGap()
/* 199 */       .addGroup(jPanel1Layout
/* 199 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 200 */       .addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 201 */       .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
/* 201 */       .createSequentialGroup()
/* 202 */       .addGap(0, 0, 32767)
/* 203 */       .addComponent(this.jButton1)))
/* 204 */       .addContainerGap()));
/*     */ 
/* 206 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 207 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */       .addGroup(jPanel1Layout
/* 208 */       .createSequentialGroup()
/* 209 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 210 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 211 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 212 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 213 */       .addComponent(this.jButton1)
/* 214 */       .addContainerGap()));
/*     */ 
/* 217 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 218 */     getContentPane().setLayout(layout);
/* 219 */     layout.setHorizontalGroup(layout
/* 220 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 221 */       .addGroup(layout
/* 221 */       .createSequentialGroup()
/* 222 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 223 */       .addGap(0, 0, 32767)));
/*     */ 
/* 225 */     layout.setVerticalGroup(layout
/* 226 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 227 */       .addGroup(layout
/* 227 */       .createSequentialGroup()
/* 228 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 229 */       .addGap(0, 0, 32767)));
/*     */ 
/* 232 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 236 */     newuser ne = new newuser(new JFrame(), true);
/* 237 */     ne.setVisible(true);
/* 238 */     update();
/* 239 */     this.list = getDatap();
/*     */   }
/*     */ 
/*     */   public void update() {
/* 243 */     String[] headers = { "User Name", "User Level" };
/*     */ 
/* 247 */     this.list = getDatap();
/*     */ 
/* 249 */     DefaultTableModel model = new DefaultTableModel(this.list, headers);
/* 250 */     this.table.setModel(model);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 269 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 270 */         if ("Windows".equals(info.getName())) {
/* 271 */           UIManager.setLookAndFeel(info.getClassName());
/* 272 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 276 */       Logger.getLogger(userManager.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 278 */       Logger.getLogger(userManager.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 280 */       Logger.getLogger(userManager.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 282 */       Logger.getLogger(userManager.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 289 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 292 */         userManager dialog = new userManager(new JFrame(), true);
/* 293 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 297 */             System.exit(0);
/*     */           }
/*     */         });
/* 300 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.userManager
 * JD-Core Version:    0.6.0
 */