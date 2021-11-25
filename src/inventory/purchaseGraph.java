/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.ChartUtilities;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.data.category.DefaultCategoryDataset;
/*     */ 
/*     */ public class purchaseGraph extends JDialog
/*     */ {
/*     */   ChartPanel cat;
/*     */   String[][] data;
/*     */ 
/*     */   public purchaseGraph(Frame parent, boolean modal)
/*     */   {
/*  36 */     super(parent, modal);
/*  37 */     initComponents();
/*     */   }
/*     */ 
/*     */   public void getter(String start, String end) {
/*     */     try {
/*  42 */       Class.forName("com.mysql.jdbc.Driver");
/*  43 */       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*  44 */       String sql = "SELECT date,amtowed FROM purchasedpaid  where date>='" + start + "'&& date<='" + end + "' ";
/*  45 */       PreparedStatement stamt = con.prepareStatement(sql);
/*  46 */       ResultSet ris = stamt.executeQuery();
/*  47 */       if (ris.next()) {
/*  48 */         ris.last();
/*  49 */         this.data = new String[ris.getRow()][2];
/*  50 */         ris.beforeFirst();
/*     */       }
/*  52 */       int rowcount = 0;
/*  53 */       while (ris.next())
/*     */       {
/*  56 */         this.data[rowcount][0] = ris.getString(1);
/*  57 */         this.data[rowcount][1] = ris.getString(2);
/*  58 */         System.out.println(this.data[rowcount][0]);
/*  59 */         rowcount++;
/*     */       }
/*     */     }
/*     */     catch (Exception exc) {
/*  63 */       exc.printStackTrace();
/*     */     }
/*  65 */     prepare();
/*     */   }
/*     */   public void prepare() {
/*     */     try {
/*  69 */       int u = 0;
/*  70 */       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*  71 */       SimpleDateFormat t = new SimpleDateFormat("yyyy-MM");
/*  72 */       Double amtJan = Double.valueOf(0.0D);
/*  73 */       Double amtFeb = Double.valueOf(0.0D);
/*  74 */       Double amtMar = Double.valueOf(0.0D);
/*  75 */       Double amtApril = Double.valueOf(0.0D);
/*  76 */       Double amtMay = Double.valueOf(0.0D);
/*  77 */       Double amtJune = Double.valueOf(0.0D);
/*  78 */       Double amtJul = Double.valueOf(0.0D);
/*  79 */       Double amtAug = Double.valueOf(0.0D);
/*  80 */       Double amtSep = Double.valueOf(0.0D);
/*  81 */       Double amtOct = Double.valueOf(0.0D);
/*  82 */       Double amtNov = Double.valueOf(0.0D);
/*  83 */       Double amtDec = Double.valueOf(0.0D);
/*     */ 
/*  85 */       for (int i = 0; i < this.data.length; i++) {
/*  86 */         for (int y = 0; y < this.data[i].length; y++) {
/*  87 */           if (y != 0) continue;
/*     */           try {
/*  89 */             Date cur = t.parse(this.data[i][y]);
/*  90 */             String ff = t.format(cur);
/*  91 */             System.out.println(ff.substring(5, 7) + "the");
/*  92 */             u = Integer.parseInt(String.valueOf(ff.substring(5, 7)));
/*     */           } catch (ParseException ex) {
/*  94 */             ex.printStackTrace();
/*     */           }
/*  96 */           if (u == 1) {
/*  97 */             amtJan = Double.valueOf(amtJan.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/*  99 */           else if (u == 2) {
/* 100 */             amtFeb = Double.valueOf(amtFeb.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 102 */           else if (u == 3) {
/* 103 */             amtMar = Double.valueOf(amtMar.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 105 */           else if (u == 4) {
/* 106 */             amtApril = Double.valueOf(amtApril.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 108 */           else if (u == 5) {
/* 109 */             amtMay = Double.valueOf(amtMay.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 111 */           else if (u == 6) {
/* 112 */             amtJune = Double.valueOf(amtJune.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 114 */           else if (u == 7) {
/* 115 */             amtJul = Double.valueOf(amtJul.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 117 */           else if (u == 8) {
/* 118 */             amtAug = Double.valueOf(amtAug.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 120 */           else if (u == 9) {
/* 121 */             amtSep = Double.valueOf(amtSep.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 123 */           else if (u == 10) {
/* 124 */             amtOct = Double.valueOf(amtOct.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 126 */           else if (u == 11)
/*     */           {
/* 128 */             amtNov = Double.valueOf(amtNov.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 130 */           else if (u == 12) {
/* 131 */             amtDec = Double.valueOf(amtDec.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 138 */       System.out.println(amtOct);
/* 139 */       dataset.setValue(amtJan, "Purchases", "Jan");
/* 140 */       dataset.setValue(amtFeb, "Purchases", "Feb");
/* 141 */       dataset.setValue(amtMar, "Purchases", "Mar");
/* 142 */       dataset.setValue(amtApril, "Purchases", "April");
/* 143 */       dataset.setValue(amtMay, "Purchases", "May");
/* 144 */       dataset.setValue(amtJune, "Purchases", "Jun");
/* 145 */       dataset.setValue(amtJul, "Purchases", "Jul");
/* 146 */       dataset.setValue(amtAug, "Purchases", "Aug");
/* 147 */       dataset.setValue(amtSep, "Purchases", "Sep");
/* 148 */       dataset.setValue(amtOct, "Purchases", "Oct");
/* 149 */       dataset.setValue(amtNov, "Purchases", "Nov");
/* 150 */       dataset.setValue(amtDec, "Purchases", "Dec");
/* 151 */       JFreeChart chart = ChartFactory.createBarChart("Comparison between Purchases", "Month", "Purchases", dataset, PlotOrientation.VERTICAL, false, true, false);
/*     */       try
/*     */       {
/* 155 */         ChartUtilities.saveChartAsJPEG(new File("C:chart.jpg"), chart, 500, 300);
/* 156 */         chart.setBackgroundPaint(Color.white);
/* 157 */         chart.fireChartChanged();
/*     */ 
/* 159 */         chart.setTitle("PURCHASES CHART");
/* 160 */         this.cat = new ChartPanel(chart);
/*     */ 
/* 163 */         setContentPane(this.cat);
/*     */       } catch (IOException e) {
/* 165 */         System.err.println("Problem occurred creating chart.");
/*     */       }
/*     */ 
/* 169 */       chart.setBackgroundPaint(Color.white);
/* 170 */       chart.fireChartChanged();
/*     */ 
/* 172 */       chart.setTitle("PURCHASES CHART");
/* 173 */       this.cat = new ChartPanel(chart);
/*     */ 
/* 176 */       setContentPane(this.cat); } catch (Exception ex) {
/* 177 */       JOptionPane.showMessageDialog(null, "Error", "No Data found for selected year", 0);
/* 178 */       dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 189 */     setDefaultCloseOperation(2);
/*     */ 
/* 191 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 192 */     getContentPane().setLayout(layout);
/* 193 */     layout.setHorizontalGroup(layout
/* 194 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 195 */       .addGap(0, 734, 32767));
/*     */ 
/* 197 */     layout.setVerticalGroup(layout
/* 198 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 199 */       .addGap(0, 427, 32767));
/*     */ 
/* 202 */     pack();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 219 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 220 */         if ("Nimbus".equals(info.getName())) {
/* 221 */           UIManager.setLookAndFeel(info.getClassName());
/* 222 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 226 */       Logger.getLogger(purchaseGraph.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 228 */       Logger.getLogger(purchaseGraph.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 230 */       Logger.getLogger(purchaseGraph.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 232 */       Logger.getLogger(purchaseGraph.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 239 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 242 */         purchaseGraph dialog = new purchaseGraph(new JFrame(), true);
/* 243 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 247 */             System.exit(0);
/*     */           }
/*     */         });
/* 250 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.purchaseGraph
 * JD-Core Version:    0.6.0
 */