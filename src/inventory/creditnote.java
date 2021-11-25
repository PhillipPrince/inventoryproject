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
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ public class creditnote extends JDialog
/*     */ {
/*     */   private JPanel jPanel1;
/*     */ 
/*     */   public creditnote(Frame parent, boolean modal)
/*     */   {
/*  17 */     super(parent, modal);
/*  18 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  30 */     this.jPanel1 = new JPanel();
/*     */ 
/*  32 */     setDefaultCloseOperation(2);
/*     */ 
/*  34 */     this.jPanel1.setBackground(new Color(204, 204, 204));
/*     */ 
/*  36 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  37 */     this.jPanel1.setLayout(jPanel1Layout);
/*  38 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  39 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  40 */       .addGap(0, 400, 32767));
/*     */ 
/*  42 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  43 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  44 */       .addGap(0, 300, 32767));
/*     */ 
/*  47 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  48 */     getContentPane().setLayout(layout);
/*  49 */     layout.setHorizontalGroup(layout
/*  50 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  51 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/*  53 */     layout.setVerticalGroup(layout
/*  54 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  55 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/*  58 */     pack();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/*  75 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/*  76 */         if ("Nimbus".equals(info.getName())) {
/*  77 */           UIManager.setLookAndFeel(info.getClassName());
/*  78 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/*  82 */       Logger.getLogger(creditnote.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/*  84 */       Logger.getLogger(creditnote.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/*  86 */       Logger.getLogger(creditnote.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/*  88 */       Logger.getLogger(creditnote.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/*  95 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/*  98 */         creditnote dialog = new creditnote(new JFrame(), true);
/*  99 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 103 */             System.exit(0);
/*     */           }
/*     */         });
/* 106 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.creditnote
 * JD-Core Version:    0.6.0
 */