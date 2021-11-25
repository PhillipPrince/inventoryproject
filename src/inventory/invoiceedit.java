/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
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
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ public class invoiceedit extends JDialog
/*     */ {
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JTextField jTextField1;
/*     */ 
/*     */   public invoiceedit(Frame parent, boolean modal)
/*     */   {
/*  17 */     super(parent, modal);
/*  18 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  30 */     this.jPanel1 = new JPanel();
/*  31 */     this.jPanel2 = new JPanel();
/*  32 */     this.jPanel3 = new JPanel();
/*  33 */     this.jLabel1 = new JLabel();
/*  34 */     this.jTextField1 = new JTextField();
/*  35 */     this.jButton1 = new JButton();
/*  36 */     this.jButton2 = new JButton();
/*     */ 
/*  38 */     setDefaultCloseOperation(2);
/*     */ 
/*  40 */     this.jPanel1.setBackground(new Color(204, 204, 204));
/*     */ 
/*  42 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*     */ 
/*  44 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  45 */     this.jPanel2.setLayout(jPanel2Layout);
/*  46 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  47 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  48 */       .addGap(0, 0, 32767));
/*     */ 
/*  50 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  51 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  52 */       .addGap(0, 28, 32767));
/*     */ 
/*  55 */     this.jPanel3.setBackground(new Color(204, 204, 204));
/*  56 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder(0));
/*     */ 
/*  58 */     this.jLabel1.setText("QUANTITY:");
/*     */ 
/*  60 */     this.jTextField1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */ 
/*  62 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  63 */     this.jPanel3.setLayout(jPanel3Layout);
/*  64 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  65 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  66 */       .addGroup(jPanel3Layout
/*  66 */       .createSequentialGroup()
/*  67 */       .addGap(27, 27, 27)
/*  68 */       .addComponent(this.jLabel1)
/*  69 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  70 */       .addComponent(this.jTextField1, -2, 81, -2)
/*  71 */       .addContainerGap(76, 32767)));
/*     */ 
/*  73 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  74 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  75 */       .addGroup(jPanel3Layout
/*  75 */       .createSequentialGroup()
/*  76 */       .addGap(25, 25, 25)
/*  77 */       .addGroup(jPanel3Layout
/*  77 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  78 */       .addComponent(this.jLabel1)
/*  79 */       .addComponent(this.jTextField1, -2, -1, -2))
/*  80 */       .addContainerGap(-1, 32767)));
/*     */ 
/*  83 */     this.jButton1.setText("REMOVE");
/*     */ 
/*  85 */     this.jButton2.setText("SAVE");
/*     */ 
/*  87 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  88 */     this.jPanel1.setLayout(jPanel1Layout);
/*  89 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  90 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  91 */       .addComponent(this.jPanel2, -1, -1, 32767)
/*  92 */       .addGroup(jPanel1Layout
/*  92 */       .createSequentialGroup()
/*  93 */       .addContainerGap()
/*  94 */       .addGroup(jPanel1Layout
/*  94 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  95 */       .addGroup(jPanel1Layout
/*  95 */       .createSequentialGroup()
/*  96 */       .addComponent(this.jPanel3, -2, -1, -2)
/*  97 */       .addContainerGap(20, 32767))
/*  98 */       .addGroup(jPanel1Layout
/*  98 */       .createSequentialGroup()
/*  99 */       .addGap(0, 0, 32767)
/* 100 */       .addComponent(this.jButton1)
/* 101 */       .addGap(18, 18, 18)
/* 102 */       .addComponent(this.jButton2)
/* 103 */       .addGap(33, 33, 33)))));
/*     */ 
/* 105 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 106 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 107 */       .addGroup(jPanel1Layout
/* 107 */       .createSequentialGroup()
/* 108 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 109 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 110 */       .addComponent(this.jPanel3, -2, -1, -2)
/* 111 */       .addGap(25, 25, 25)
/* 112 */       .addGroup(jPanel1Layout
/* 112 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 113 */       .addComponent(this.jButton1)
/* 114 */       .addComponent(this.jButton2))
/* 115 */       .addContainerGap(-1, 32767)));
/*     */ 
/* 118 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 119 */     getContentPane().setLayout(layout);
/* 120 */     layout.setHorizontalGroup(layout
/* 121 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 122 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 124 */     layout.setVerticalGroup(layout
/* 125 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 126 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 129 */     pack();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 147 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 148 */         if ("Nimbus".equals(info.getName())) {
/* 149 */           UIManager.setLookAndFeel(info.getClassName());
/* 150 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 154 */       Logger.getLogger(invoiceedit.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 156 */       Logger.getLogger(invoiceedit.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 158 */       Logger.getLogger(invoiceedit.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 160 */       Logger.getLogger(invoiceedit.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 167 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 170 */         invoiceedit dialog = new invoiceedit(new JFrame(), true);
/* 171 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 175 */             System.exit(0);
/*     */           }
/*     */         });
/* 178 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.invoiceedit
 * JD-Core Version:    0.6.0
 */