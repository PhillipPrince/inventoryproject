/*     */ package inventory;
/*     */ 
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.sql.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class editexpense3 extends JFrame
/*     */ {
/*     */   private JTextField amount;
/*     */   private JTextField des;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JDateChooser jDateChooser1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JTextField nam;
/*     */ 
/*     */   public editexpense3()
/*     */   {
/*  20 */     initComponents();
/*  21 */     setTitle("EDIT EXPENSES");
/*  22 */     setLocationRelativeTo(null);
/*  23 */     setResizable(false);
/*  24 */     addWindowListener(new WindowAdapter()
/*     */     {
/*     */       public void windowClosing(WindowEvent e)
/*     */       {
/*  30 */         editexpense3.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void fill(String name, String description, String amt, String date)
/*     */   {
/*  39 */     this.nam.setText(name);
/*  40 */     this.des.setText(description);
/*  41 */     this.amount.setText(amt);
/*  42 */     Date ee = Date.valueOf(date);
/*  43 */     this.jDateChooser1.setDate(ee);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  56 */     this.jPanel1 = new JPanel();
/*  57 */     this.jPanel2 = new JPanel();
/*  58 */     this.jLabel1 = new JLabel();
/*  59 */     this.jLabel2 = new JLabel();
/*  60 */     this.nam = new JTextField();
/*  61 */     this.des = new JTextField();
/*  62 */     this.jLabel3 = new JLabel();
/*  63 */     this.jDateChooser1 = new JDateChooser();
/*  64 */     this.jLabel4 = new JLabel();
/*  65 */     this.amount = new JTextField();
/*  66 */     this.jButton1 = new JButton();
/*  67 */     this.jButton2 = new JButton();
/*     */ 
/*  69 */     setDefaultCloseOperation(3);
/*     */ 
/*  71 */     this.jPanel1.setBackground(new Color(204, 204, 204));
/*     */ 
/*  73 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  74 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/*  76 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  77 */     this.jPanel2.setLayout(jPanel2Layout);
/*  78 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  79 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  80 */       .addGap(0, 0, 32767));
/*     */ 
/*  82 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  83 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  84 */       .addGap(0, 22, 32767));
/*     */ 
/*  87 */     this.jLabel1.setText("NAME:");
/*     */ 
/*  89 */     this.jLabel2.setText("DESCRIPTION:");
/*     */ 
/*  91 */     this.nam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  93 */     this.des.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  95 */     this.jLabel3.setText("DATE:");
/*     */ 
/*  97 */     this.jLabel4.setText("AMOUNT");
/*     */ 
/*  99 */     this.amount.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/* 101 */     this.jButton1.setText("SAVE");
/*     */ 
/* 103 */     this.jButton2.setText("DELETE");
/*     */ 
/* 105 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 106 */     this.jPanel1.setLayout(jPanel1Layout);
/* 107 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 108 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 109 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 110 */       .addGroup(jPanel1Layout
/* 110 */       .createSequentialGroup()
/* 111 */       .addContainerGap()
/* 112 */       .addGroup(jPanel1Layout
/* 112 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 113 */       .addComponent(this.jLabel2)
/* 114 */       .addComponent(this.jLabel1)
/* 115 */       .addComponent(this.jLabel3)
/* 116 */       .addComponent(this.jLabel4))
/* 117 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 118 */       .addGroup(jPanel1Layout
/* 118 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 119 */       .addGroup(jPanel1Layout
/* 119 */       .createSequentialGroup()
/* 120 */       .addComponent(this.jButton1)
/* 121 */       .addGap(40, 40, 40)
/* 122 */       .addComponent(this.jButton2))
/* 123 */       .addGroup(jPanel1Layout
/* 123 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 124 */       .addComponent(this.amount)
/* 125 */       .addComponent(this.nam)
/* 126 */       .addComponent(this.des)
/* 127 */       .addComponent(this.jDateChooser1, -1, 135, 32767)))
/* 128 */       .addContainerGap(42, 32767)));
/*     */ 
/* 130 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 131 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 132 */       .addGroup(jPanel1Layout
/* 132 */       .createSequentialGroup()
/* 133 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 134 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 135 */       .addGroup(jPanel1Layout
/* 135 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 136 */       .addComponent(this.nam, -2, -1, -2)
/* 137 */       .addComponent(this.jLabel1))
/* 138 */       .addGap(18, 18, 18)
/* 139 */       .addGroup(jPanel1Layout
/* 139 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 140 */       .addComponent(this.des, -2, -1, -2)
/* 141 */       .addComponent(this.jLabel2))
/* 142 */       .addGap(28, 28, 28)
/* 143 */       .addGroup(jPanel1Layout
/* 143 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 144 */       .addComponent(this.jLabel3)
/* 145 */       .addComponent(this.jDateChooser1, -2, -1, -2))
/* 146 */       .addGap(23, 23, 23)
/* 147 */       .addGroup(jPanel1Layout
/* 147 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 148 */       .addComponent(this.jLabel4)
/* 149 */       .addComponent(this.amount, -2, -1, -2))
/* 150 */       .addGap(18, 18, 18)
/* 151 */       .addGroup(jPanel1Layout
/* 151 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 152 */       .addComponent(this.jButton1)
/* 153 */       .addComponent(this.jButton2))
/* 154 */       .addGap(0, 28, 32767)));
/*     */ 
/* 157 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 158 */     getContentPane().setLayout(layout);
/* 159 */     layout.setHorizontalGroup(layout
/* 160 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 161 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 163 */     layout.setVerticalGroup(layout
/* 164 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 165 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 168 */     pack();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 185 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 186 */         if ("Nimbus".equals(info.getName())) {
/* 187 */           UIManager.setLookAndFeel(info.getClassName());
/* 188 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 192 */       Logger.getLogger(editexpense3.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 194 */       Logger.getLogger(editexpense3.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 196 */       Logger.getLogger(editexpense3.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 198 */       Logger.getLogger(editexpense3.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 205 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 208 */         new editexpense3().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.editexpense3
 * JD-Core Version:    0.6.0
 */