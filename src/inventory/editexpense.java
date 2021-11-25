/*     */ package inventory;
/*     */ 
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
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
/*     */ public class editexpense extends JFrame
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
/*     */   public editexpense(Frame parent, boolean modal)
/*     */   {
/*  20 */     initComponents();
/*  21 */     setTitle("EDIT EXPENSES");
/*  22 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */   editexpense() {
/*  26 */     throw new UnsupportedOperationException("Not yet implemented");
/*     */   }
/*     */ 
/*     */   public void fill(String name, String description, String amt, String date)
/*     */   {
/*  33 */     this.nam.setText(name);
/*  34 */     this.des.setText(description);
/*  35 */     this.amount.setText(amt);
/*  36 */     Date ee = Date.valueOf(date);
/*  37 */     this.jDateChooser1.setDate(ee);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  49 */     this.jPanel1 = new JPanel();
/*  50 */     this.jPanel2 = new JPanel();
/*  51 */     this.jLabel1 = new JLabel();
/*  52 */     this.jLabel2 = new JLabel();
/*  53 */     this.nam = new JTextField();
/*  54 */     this.des = new JTextField();
/*  55 */     this.jLabel3 = new JLabel();
/*  56 */     this.jDateChooser1 = new JDateChooser();
/*  57 */     this.jLabel4 = new JLabel();
/*  58 */     this.amount = new JTextField();
/*  59 */     this.jButton1 = new JButton();
/*  60 */     this.jButton2 = new JButton();
/*     */ 
/*  62 */     setDefaultCloseOperation(2);
/*     */ 
/*  64 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  66 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  67 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/*  69 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  70 */     this.jPanel2.setLayout(jPanel2Layout);
/*  71 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  72 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  73 */       .addGap(0, 0, 32767));
/*     */ 
/*  75 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  76 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  77 */       .addGap(0, 22, 32767));
/*     */ 
/*  80 */     this.jLabel1.setText("NAME:");
/*     */ 
/*  82 */     this.jLabel2.setText("DESCRIPTION:");
/*     */ 
/*  84 */     this.nam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  86 */     this.des.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  88 */     this.jLabel3.setText("DATE:");
/*     */ 
/*  90 */     this.jLabel4.setText("AMOUNT");
/*     */ 
/*  92 */     this.amount.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  94 */     this.jButton1.setText("SAVE");
/*     */ 
/*  96 */     this.jButton2.setText("DELETE");
/*     */ 
/*  98 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  99 */     this.jPanel1.setLayout(jPanel1Layout);
/* 100 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 101 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 102 */       .addComponent(this.jPanel2, -1, -1, 32767)
/* 103 */       .addGroup(jPanel1Layout
/* 103 */       .createSequentialGroup()
/* 104 */       .addContainerGap()
/* 105 */       .addGroup(jPanel1Layout
/* 105 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 106 */       .addComponent(this.jLabel2)
/* 107 */       .addComponent(this.jLabel1)
/* 108 */       .addComponent(this.jLabel3)
/* 109 */       .addComponent(this.jLabel4))
/* 110 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 111 */       .addGroup(jPanel1Layout
/* 111 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 112 */       .addGroup(jPanel1Layout
/* 112 */       .createSequentialGroup()
/* 113 */       .addComponent(this.jButton1)
/* 114 */       .addGap(40, 40, 40)
/* 115 */       .addComponent(this.jButton2))
/* 116 */       .addGroup(jPanel1Layout
/* 116 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 117 */       .addComponent(this.amount)
/* 118 */       .addComponent(this.nam)
/* 119 */       .addComponent(this.des)
/* 120 */       .addComponent(this.jDateChooser1, -1, 135, 32767)))
/* 121 */       .addContainerGap(42, 32767)));
/*     */ 
/* 123 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 124 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 125 */       .addGroup(jPanel1Layout
/* 125 */       .createSequentialGroup()
/* 126 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 127 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 128 */       .addGroup(jPanel1Layout
/* 128 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 129 */       .addComponent(this.nam, -2, -1, -2)
/* 130 */       .addComponent(this.jLabel1))
/* 131 */       .addGap(18, 18, 18)
/* 132 */       .addGroup(jPanel1Layout
/* 132 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 133 */       .addComponent(this.des, -2, -1, -2)
/* 134 */       .addComponent(this.jLabel2))
/* 135 */       .addGap(28, 28, 28)
/* 136 */       .addGroup(jPanel1Layout
/* 136 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 137 */       .addComponent(this.jLabel3)
/* 138 */       .addComponent(this.jDateChooser1, -2, -1, -2))
/* 139 */       .addGap(23, 23, 23)
/* 140 */       .addGroup(jPanel1Layout
/* 140 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 141 */       .addComponent(this.jLabel4)
/* 142 */       .addComponent(this.amount, -2, -1, -2))
/* 143 */       .addGap(18, 18, 18)
/* 144 */       .addGroup(jPanel1Layout
/* 144 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 145 */       .addComponent(this.jButton1)
/* 146 */       .addComponent(this.jButton2))
/* 147 */       .addGap(0, 23, 32767)));
/*     */ 
/* 150 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 151 */     getContentPane().setLayout(layout);
/* 152 */     layout.setHorizontalGroup(layout
/* 153 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 154 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 156 */     layout.setVerticalGroup(layout
/* 157 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 158 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 161 */     pack();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 178 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 179 */         if ("Nimbus".equals(info.getName())) {
/* 180 */           UIManager.setLookAndFeel(info.getClassName());
/* 181 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 185 */       Logger.getLogger(editexpense.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 187 */       Logger.getLogger(editexpense.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 189 */       Logger.getLogger(editexpense.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 191 */       Logger.getLogger(editexpense.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 198 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 201 */         editexpense dialog = new editexpense(new JFrame(), true);
/* 202 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/*     */           }
/*     */         });
/* 209 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.editexpense
 * JD-Core Version:    0.6.0
 */