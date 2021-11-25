/*    */ package inventory;
/*    */ 
/*    */ import java.awt.Frame;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class rerun
/*    */ {
/* 12 */   String touse = null;
/*    */ 
/* 14 */   public rerun(String customer) { invoice2 m = new invoice2(new JFrame(), true)
/*    */     {
/*    */     };
/* 15 */     m.setVisible(true);
/*    */ 
/* 17 */     this.touse = customer;
/*    */   }
/*    */ 
/*    */   public String toret()
/*    */   {
/* 22 */     String mine = this.touse;
/* 23 */     return mine;
/*    */   }
/*    */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.rerun
 * JD-Core Version:    0.6.0
 */