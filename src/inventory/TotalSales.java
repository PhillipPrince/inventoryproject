/*    */ package inventory;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.EventQueue;
/*    */ import java.awt.Frame;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.GroupLayout.Alignment;
/*    */ import javax.swing.GroupLayout.ParallelGroup;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.UIManager.LookAndFeelInfo;
/*    */ import javax.swing.UnsupportedLookAndFeelException;
/*    */ 
/*    */ public class TotalSales extends JDialog
/*    */ {
/*    */   public TotalSales(Frame parent, boolean modal)
/*    */   {
/* 17 */     super(parent, modal);
/* 18 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 30 */     setDefaultCloseOperation(2);
/*    */ 
/* 32 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 33 */     getContentPane().setLayout(layout);
/* 34 */     layout.setHorizontalGroup(layout
/* 35 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 36 */       .addGap(0, 400, 32767));
/*    */ 
/* 38 */     layout.setVerticalGroup(layout
/* 39 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 40 */       .addGap(0, 300, 32767));
/*    */ 
/* 43 */     pack();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 60 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 61 */         if ("Nimbus".equals(info.getName())) {
/* 62 */           UIManager.setLookAndFeel(info.getClassName());
/* 63 */           break;
/*    */         }
/*    */     }
/*    */     catch (ClassNotFoundException ex) {
/* 67 */       Logger.getLogger(TotalSales.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (InstantiationException ex) {
/* 69 */       Logger.getLogger(TotalSales.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (IllegalAccessException ex) {
/* 71 */       Logger.getLogger(TotalSales.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (UnsupportedLookAndFeelException ex) {
/* 73 */       Logger.getLogger(TotalSales.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */ 
/* 80 */     EventQueue.invokeLater(new Runnable()
/*    */     {
/*    */       public void run() {
/* 83 */         TotalSales dialog = new TotalSales(new JFrame(), true);
/* 84 */         dialog.addWindowListener(new WindowAdapter()
/*    */         {
/*    */           public void windowClosing(WindowEvent e)
/*    */           {
/* 88 */             System.exit(0);
/*    */           }
/*    */         });
/* 91 */         dialog.setVisible(true);
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.TotalSales
 * JD-Core Version:    0.6.0
 */