/*    */ package inventory;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.InputStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import javax.swing.JFrame;
/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import net.sf.jasperreports.engine.JasperFillManager;
/*    */ import net.sf.jasperreports.engine.JasperPrint;
/*    */ import net.sf.jasperreports.swing.JRViewer;
/*    */ 
/*    */ public class expensereport
/*    */ {
/* 29 */   Connection conn = null;
/*    */ 
/*    */   public void initConnection()
/*    */   {
/* 33 */     String HOST = "jdbc:mysql://localhost:3306/inventory";
/* 34 */     String USERNAME = "root";
/* 35 */     String PASSWORD = "this";
/*    */     try {
/* 37 */       Class.forName("com.mysql.jdbc.Driver");
/*    */     } catch (ClassNotFoundException ex) {
/* 39 */       ex.printStackTrace();
/*    */     }
/*    */     try
/*    */     {
/* 43 */       this.conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
/*    */     } catch (SQLException ex) {
/* 45 */       ex.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void showReport()
/*    */     throws FileNotFoundException
/*    */   {
/* 52 */     String reportName = "inventory/expenses.jasper";
/* 53 */     String wages = "Expenses Summary";
/*    */ 
/* 56 */     InputStream is = getClass().getClassLoader().getResourceAsStream(reportName);
/*    */     try
/*    */     {
/* 60 */       JasperPrint jp = JasperFillManager.fillReport(is, null, this.conn);
/*    */ 
/* 65 */       JRViewer jv = new JRViewer(jp);
/*    */ 
/* 70 */       JFrame jf = new JFrame();
/*    */ 
/* 72 */       jf.getContentPane().add(jv);
/* 73 */       jf.validate();
/*    */ 
/* 75 */       jf.setVisible(true);
/* 76 */       jf.setSize(new Dimension(800, 600));
/* 77 */       jf.setTitle(wages);
/*    */ 
/* 79 */       jf.setLocation(300, 100);
/* 80 */       jf.setDefaultCloseOperation(2);
/*    */     }
/*    */     catch (JRException ex) {
/* 83 */       ex.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws FileNotFoundException
/*    */   {
/* 89 */     expensereport ma = new expensereport();
/* 90 */     ma.initConnection();
/* 91 */     ma.showReport();
/*    */   }
/*    */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.expensereport
 * JD-Core Version:    0.6.0
 */