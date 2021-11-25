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
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class list extends JDialog
/*     */ {
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JPanel jPanel4;
/*     */   private JTextField jTextField1;
/*     */ 
/*     */   public list(Frame parent, boolean modal)
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
/*  33 */     this.jPanel4 = new JPanel();
/*  34 */     this.jButton1 = new JButton();
/*  35 */     this.jTextField1 = new JTextField();
/*  36 */     this.jLabel1 = new JLabel();
/*     */ 
/*  38 */     setDefaultCloseOperation(2);
/*     */ 
/*  40 */     this.jPanel1.setBackground(new Color(204, 204, 204));
/*     */ 
/*  42 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  43 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/*  45 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  46 */     this.jPanel2.setLayout(jPanel2Layout);
/*  47 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  48 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  49 */       .addGap(0, 0, 32767));
/*     */ 
/*  51 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  52 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  53 */       .addGap(0, 24, 32767));
/*     */ 
/*  56 */     this.jPanel3.setBackground(new Color(204, 204, 204));
/*  57 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/*  59 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  60 */     this.jPanel3.setLayout(jPanel3Layout);
/*  61 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  62 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  63 */       .addGap(0, 98, 32767));
/*     */ 
/*  65 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  66 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  67 */       .addGap(0, 0, 32767));
/*     */ 
/*  70 */     this.jPanel4.setBackground(new Color(204, 204, 204));
/*  71 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/*  73 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  74 */     this.jPanel4.setLayout(jPanel4Layout);
/*  75 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  76 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  77 */       .addGap(0, 339, 32767));
/*     */ 
/*  79 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  80 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  81 */       .addGap(0, 144, 32767));
/*     */ 
/*  84 */     this.jButton1.setText("ADD ITEM");
/*     */ 
/*  86 */     this.jLabel1.setText("QUANTITY:");
/*     */ 
/*  88 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  89 */     this.jPanel1.setLayout(jPanel1Layout);
/*  90 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  91 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  92 */       .addComponent(this.jPanel2, -1, -1, 32767)
/*  93 */       .addGroup(jPanel1Layout
/*  93 */       .createSequentialGroup()
/*  94 */       .addContainerGap()
/*  95 */       .addComponent(this.jPanel3, -2, -1, -2)
/*  96 */       .addGroup(jPanel1Layout
/*  96 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  97 */       .addGroup(jPanel1Layout
/*  97 */       .createSequentialGroup()
/*  98 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  99 */       .addComponent(this.jPanel4, -2, -1, -2))
/* 100 */       .addGroup(jPanel1Layout
/* 100 */       .createSequentialGroup()
/* 101 */       .addGap(60, 60, 60)
/* 102 */       .addComponent(this.jLabel1)
/* 103 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 104 */       .addComponent(this.jTextField1, -2, 71, -2)
/* 105 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 106 */       .addComponent(this.jButton1)))
/* 107 */       .addContainerGap(87, 32767)));
/*     */ 
/* 109 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 110 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 111 */       .addGroup(jPanel1Layout
/* 111 */       .createSequentialGroup()
/* 112 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 113 */       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 114 */       .addGroup(jPanel1Layout
/* 114 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 115 */       .addComponent(this.jPanel3, -1, -1, 32767)
/* 116 */       .addGroup(jPanel1Layout
/* 116 */       .createSequentialGroup()
/* 117 */       .addComponent(this.jPanel4, -2, -1, -2)
/* 118 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 119 */       .addGroup(jPanel1Layout
/* 119 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 120 */       .addComponent(this.jButton1)
/* 121 */       .addComponent(this.jTextField1, -2, -1, -2)
/* 122 */       .addComponent(this.jLabel1))
/* 123 */       .addGap(0, 66, 32767)))
/* 124 */       .addContainerGap()));
/*     */ 
/* 127 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 128 */     getContentPane().setLayout(layout);
/* 129 */     layout.setHorizontalGroup(layout
/* 130 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 131 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 133 */     layout.setVerticalGroup(layout
/* 134 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 135 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 138 */     pack();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 155 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 156 */         if ("Nimbus".equals(info.getName())) {
/* 157 */           UIManager.setLookAndFeel(info.getClassName());
/* 158 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 162 */       Logger.getLogger(list.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 164 */       Logger.getLogger(list.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 166 */       Logger.getLogger(list.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 168 */       Logger.getLogger(list.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 175 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 178 */         list dialog = new list(new JFrame(), true);
/* 179 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 183 */             System.exit(0);
/*     */           }
/*     */         });
/* 186 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.list
 * JD-Core Version:    0.6.0
 */