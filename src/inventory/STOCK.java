/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.data.jdbc.JDBCCategoryDataset;
/*     */ 
/*     */ public class STOCK extends JDialog
/*     */ {
/*  27 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  28 */   static String username = "root";
/*  29 */   static String password = "this";
/*     */   ChartPanel cat;
/*     */ 
/*     */   public STOCK(Frame parent, boolean modal)
/*     */   {
/*  35 */     super(parent, modal);
/*  36 */     initComponents();
/*     */     try {
/*  38 */       String query = "SELECT date,quantity from purchases where DATE_SUB(CURDATE(),INTERVAL 1 MONTH )>= date   LIMIT 7 ";
/*  39 */       JDBCCategoryDataset dataset = new JDBCCategoryDataset("jdbc:mysql://localhost:3306/inventory", "com.mysql.jdbc.Driver", "root", "this");
/*  40 */       dataset.executeQuery(query);
/*  41 */       JFreeChart chart = ChartFactory.createBarChart("PURCHASE CHART", "DATE", "purchases", dataset, PlotOrientation.VERTICAL, modal, modal, modal);
/*     */ 
/*  53 */       chart.setBackgroundPaint(Color.white);
/*  54 */       chart.fireChartChanged();
/*     */ 
/*  56 */       chart.setTitle("PURCHASES CHART");
/*  57 */       this.cat = new ChartPanel(chart);
/*     */ 
/*  60 */       setContentPane(this.cat);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  66 */       System.out.println(e.toString());
/*     */     }
/*     */     finally
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  84 */     setDefaultCloseOperation(2);
/*     */ 
/*  86 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  87 */     getContentPane().setLayout(layout);
/*  88 */     layout.setHorizontalGroup(layout
/*  89 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  90 */       .addGap(0, 672, 32767));
/*     */ 
/*  92 */     layout.setVerticalGroup(layout
/*  93 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  94 */       .addGap(0, 425, 32767));
/*     */ 
/*  97 */     pack();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 110 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 111 */         if ("Nimbus".equals(info.getName())) {
/* 112 */           UIManager.setLookAndFeel(info.getClassName());
/* 113 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 117 */       Logger.getLogger(STOCK.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 119 */       Logger.getLogger(STOCK.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 121 */       Logger.getLogger(STOCK.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 123 */       Logger.getLogger(STOCK.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 128 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 130 */         STOCK dialog = new STOCK(new JFrame(), true);
/* 131 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 134 */             System.exit(0);
/*     */           }
/*     */         });
/* 137 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.STOCK
 * JD-Core Version:    0.6.0
 */