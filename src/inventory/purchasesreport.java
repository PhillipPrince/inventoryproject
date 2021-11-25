/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.InputStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import javax.swing.JFrame;
/*     */ import net.sf.jasperreports.engine.JRException;
/*     */ import net.sf.jasperreports.engine.JasperFillManager;
/*     */ import net.sf.jasperreports.engine.JasperPrint;
/*     */ import net.sf.jasperreports.swing.JRViewer;
/*     */ 
/*     */ public class purchasesreport
/*     */ {
/*  46 */   Connection conn = null;
/*     */ 
/*     */   public void initConnection()
/*     */   {
/*  50 */     String HOST = "jdbc:mysql://localhost:3306/inventory";
/*  51 */     String USERNAME = "root";
/*  52 */     String PASSWORD = "this";
/*     */     try {
/*  54 */       Class.forName("com.mysql.jdbc.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/*  56 */       ex.printStackTrace();
/*     */     }
/*     */     try
/*     */     {
/*  60 */       this.conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
/*     */     } catch (SQLException ex) {
/*  62 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void showReport()
/*     */     throws FileNotFoundException
/*     */   {
/*  69 */     String reportName = "inventory/purchasesreport.jasper";
/*  70 */     String wages = "Purchases report";
/*     */ 
/*  73 */     InputStream is = getClass().getClassLoader().getResourceAsStream(reportName);
/*     */     try
/*     */     {
/*  77 */       JasperPrint jp = JasperFillManager.fillReport(is, null, this.conn);
/*     */ 
/*  82 */       JRViewer jv = new JRViewer(jp);
/*     */ 
/*  87 */       JFrame jf = new JFrame();
/*     */ 
/*  89 */       jf.getContentPane().add(jv);
/*  90 */       jf.validate();
/*     */ 
/*  92 */       jf.setVisible(true);
/*  93 */       jf.setSize(new Dimension(800, 600));
/*  94 */       jf.setTitle(wages);
/*     */ 
/*  97 */       jf.setLocation(300, 100);
/*  98 */       jf.setDefaultCloseOperation(2);
/*     */     }
/*     */     catch (JRException ex) {
/* 101 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws FileNotFoundException
/*     */   {
/* 107 */     purchasesreport ma = new purchasesreport();
/* 108 */     ma.initConnection();
/* 109 */     ma.showReport();
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.purchasesreport
 * JD-Core Version:    0.6.0
 */