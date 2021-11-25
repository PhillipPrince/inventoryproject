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
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public class setPeriod extends JDialog
/*     */ {
/*  16 */   DBConnection nn = new DBConnection();
/*  17 */   Connection conn = this.nn.getDBConnection();
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   private JTextField jTextField3;
/*     */ 
/*     */   public setPeriod(Frame parent, boolean modal)
/*     */   {
/*  22 */     super(parent, modal);
/*  23 */     initComponents();
/*  24 */     setLocationRelativeTo(null);
/*  25 */     find();
/*     */   }
/*     */ 
/*     */   public void save()
/*     */   {
/*     */     try
/*     */     {
/*  32 */       String sql = "insert into expirydatesetting(days,Weeks,months ) values('" + this.jTextField1.getText() + "','" + this.jTextField2.getText() + "','" + this.jTextField3.getText() + "')";
/*  33 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/*  34 */       int f = stmt.executeUpdate();
/*     */ 
/*  36 */       if (f > 0)
/*     */       {
/*  38 */         JOptionPane.showMessageDialog(null, "Sucessfully Saved!!", "Success!!", 2);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception exc)
/*     */     {
/*  44 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void find()
/*     */   {
/*     */     try
/*     */     {
/*  56 */       String sql = "select * from expirydatesetting";
/*  57 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/*  58 */       ResultSet rs = stmt.executeQuery();
/*     */ 
/*  60 */       while (rs.next()) {
/*  61 */         this.jTextField1.setText(rs.getString(1));
/*  62 */         this.jTextField2.setText(rs.getString(2));
/*  63 */         this.jTextField3.setText(rs.getString(3));
/*     */       }
/*     */     }
/*     */     catch (Exception exc)
/*     */     {
/*  68 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/*     */     try
/*     */     {
/*  80 */       String sql = "update expirydatesetting set days='" + this.jTextField1.getText() + "',Weeks='" + this.jTextField2.getText() + "',months='" + this.jTextField3.getText() + "'";
/*  81 */       PreparedStatement stmt = this.conn.prepareStatement(sql);
/*  82 */       int f = stmt.executeUpdate();
/*  83 */       if (f <= 0) {
/*  84 */         save();
/*     */       }
/*     */       else
/*     */       {
/*  88 */         JOptionPane.showMessageDialog(null, "Sucessfully Saved!!", "Success!!", 2);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception exc)
/*     */     {
/*  95 */       System.out.println("process error" + exc);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 110 */     this.jPanel2 = new JPanel();
/* 111 */     this.jPanel3 = new JPanel();
/* 112 */     this.jLabel1 = new JLabel();
/* 113 */     this.jLabel2 = new JLabel();
/* 114 */     this.jLabel3 = new JLabel();
/* 115 */     this.jTextField1 = new JTextField();
/* 116 */     this.jTextField2 = new JTextField();
/* 117 */     this.jTextField3 = new JTextField();
/* 118 */     this.jButton1 = new JButton();
/*     */ 
/* 120 */     setDefaultCloseOperation(2);
/*     */ 
/* 122 */     this.jPanel2.setBackground(new Color(153, 153, 255));
/*     */ 
/* 124 */     this.jPanel3.setBackground(new Color(0, 0, 0));
/*     */ 
/* 126 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 127 */     this.jPanel3.setLayout(jPanel3Layout);
/* 128 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 129 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 130 */       .addGap(0, 0, 32767));
/*     */ 
/* 132 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 133 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 134 */       .addGap(0, 33, 32767));
/*     */ 
/* 137 */     this.jLabel1.setText("Weeks:");
/*     */ 
/* 139 */     this.jLabel2.setText("Days:");
/*     */ 
/* 141 */     this.jLabel3.setText("Months:");
/*     */ 
/* 143 */     this.jButton1.setText("SAVE");
/* 144 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 146 */         setPeriod.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 150 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 151 */     this.jPanel2.setLayout(jPanel2Layout);
/* 152 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 153 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 154 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 155 */       .addGroup(jPanel2Layout
/* 155 */       .createSequentialGroup()
/* 156 */       .addGap(22, 22, 22)
/* 157 */       .addGroup(jPanel2Layout
/* 157 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 158 */       .addComponent(this.jLabel3)
/* 159 */       .addComponent(this.jLabel1)
/* 160 */       .addComponent(this.jLabel2))
/* 161 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 162 */       .addGroup(jPanel2Layout
/* 162 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 163 */       .addComponent(this.jTextField2)
/* 164 */       .addComponent(this.jTextField1)
/* 165 */       .addComponent(this.jTextField3, -1, 131, 32767)
/* 166 */       .addComponent(this.jButton1, GroupLayout.Alignment.TRAILING))
/* 167 */       .addContainerGap(114, 32767)));
/*     */ 
/* 169 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 170 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 171 */       .addGroup(jPanel2Layout
/* 171 */       .createSequentialGroup()
/* 172 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 173 */       .addGap(18, 18, 18)
/* 174 */       .addGroup(jPanel2Layout
/* 174 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 175 */       .addComponent(this.jLabel2)
/* 176 */       .addComponent(this.jTextField1, -2, -1, -2))
/* 177 */       .addGap(20, 20, 20)
/* 178 */       .addGroup(jPanel2Layout
/* 178 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 179 */       .addComponent(this.jLabel1)
/* 180 */       .addComponent(this.jTextField2, -2, -1, -2))
/* 181 */       .addGap(22, 22, 22)
/* 182 */       .addGroup(jPanel2Layout
/* 182 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 183 */       .addComponent(this.jLabel3)
/* 184 */       .addComponent(this.jTextField3, -2, -1, -2))
/* 185 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 186 */       .addComponent(this.jButton1)
/* 187 */       .addContainerGap(18, 32767)));
/*     */ 
/* 190 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 191 */     getContentPane().setLayout(layout);
/* 192 */     layout.setHorizontalGroup(layout
/* 193 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 194 */       .addComponent(this.jPanel2, -2, -1, -2));
/*     */ 
/* 196 */     layout.setVerticalGroup(layout
/* 197 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 198 */       .addComponent(this.jPanel2, -2, -1, -2));
/*     */ 
/* 201 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 205 */     update();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 222 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 223 */         if ("Nimbus".equals(info.getName())) {
/* 224 */           UIManager.setLookAndFeel(info.getClassName());
/* 225 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 229 */       Logger.getLogger(setPeriod.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 231 */       Logger.getLogger(setPeriod.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 233 */       Logger.getLogger(setPeriod.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 235 */       Logger.getLogger(setPeriod.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 242 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 245 */         setPeriod dialog = new setPeriod(new JFrame(), true);
/* 246 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 250 */             System.exit(0);
/*     */           }
/*     */         });
/* 253 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.setPeriod
 * JD-Core Version:    0.6.0
 */