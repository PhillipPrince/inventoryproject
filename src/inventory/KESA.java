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
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
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
/*     */ public class KESA extends JDialog
/*     */ {
/*  40 */   static String url = "jdbc:mysql://localhost:3306/inventory";
/*  41 */   static String username = "root";
/*  42 */   static String password = "this";
/*     */   ChartPanel cat;
/*     */   String[][] data;
/*     */   public JPanel jPanel1;
/*     */ 
/*     */   public KESA(Frame parent, boolean modal)
/*     */   {
/*  55 */     super(parent, modal);
/*  56 */     initComponents();
/*     */   }
/*     */ 
/*     */   public void getter(String start, String end)
/*     */   {
/*     */     try
/*     */     {
/*  69 */       Class.forName("com.mysql.jdbc.Driver");
/*  70 */       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
/*  71 */       String sql = "SELECT date,amt FROM sales where date>='" + start + "'&& date<='" + end + "' ";
/*  72 */       PreparedStatement stamt = con.prepareStatement(sql);
/*  73 */       ResultSet ris = stamt.executeQuery();
/*  74 */       if (ris.next()) {
/*  75 */         ris.last();
/*  76 */         this.data = new String[ris.getRow()][2];
/*  77 */         ris.beforeFirst();
/*     */       }
/*  79 */       int rowcount = 0;
/*  80 */       while (ris.next())
/*     */       {
/*  83 */         this.data[rowcount][0] = ris.getString(1);
/*  84 */         this.data[rowcount][1] = ris.getString(2);
/*  85 */         System.out.println(this.data[rowcount][0]);
/*  86 */         rowcount++;
/*     */       }
/*     */     }
/*     */     catch (Exception exc) {
/*  90 */       exc.printStackTrace();
/*     */     }
/*  92 */     prepare();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 105 */     this.jPanel1 = new JPanel();
/*     */ 
/* 107 */     setDefaultCloseOperation(2);
/* 108 */     setBackground(new Color(0, 0, 0));
/*     */ 
/* 110 */     this.jPanel1.setBackground(new Color(0, 0, 0));
/*     */ 
/* 112 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 113 */     this.jPanel1.setLayout(jPanel1Layout);
/* 114 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 115 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 116 */       .addGap(0, 862, 32767));
/*     */ 
/* 118 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 119 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 120 */       .addGap(0, 77, 32767));
/*     */ 
/* 123 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 124 */     getContentPane().setLayout(layout);
/* 125 */     layout.setHorizontalGroup(layout
/* 126 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 127 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 129 */     layout.setVerticalGroup(layout
/* 130 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 131 */       .addGroup(GroupLayout.Alignment.TRAILING, layout
/* 131 */       .createSequentialGroup()
/* 132 */       .addComponent(this.jPanel1, -2, -1, -2)
/* 133 */       .addContainerGap(383, 32767)));
/*     */ 
/* 136 */     pack();
/*     */   }
/*     */ 
/*     */   public void prepare() {
/*     */     try {
/* 141 */       int u = 0;
/* 142 */       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/* 143 */       SimpleDateFormat t = new SimpleDateFormat("yyyy-MM");
/* 144 */       Double amtJan = Double.valueOf(0.0D);
/* 145 */       Double amtFeb = Double.valueOf(0.0D);
/* 146 */       Double amtMar = Double.valueOf(0.0D);
/* 147 */       Double amtApril = Double.valueOf(0.0D);
/* 148 */       Double amtMay = Double.valueOf(0.0D);
/* 149 */       Double amtJune = Double.valueOf(0.0D);
/* 150 */       Double amtJul = Double.valueOf(0.0D);
/* 151 */       Double amtAug = Double.valueOf(0.0D);
/* 152 */       Double amtSep = Double.valueOf(0.0D);
/* 153 */       Double amtOct = Double.valueOf(0.0D);
/* 154 */       Double amtNov = Double.valueOf(0.0D);
/* 155 */       Double amtDec = Double.valueOf(0.0D);
/*     */ 
/* 157 */       for (int i = 0; i < this.data.length; i++) {
/* 158 */         for (int y = 0; y < this.data[i].length; y++) {
/* 159 */           if (y != 0) continue;
/*     */           try {
/* 161 */             Date cur = t.parse(this.data[i][y]);
/* 162 */             String ff = t.format(cur);
/* 163 */             System.out.println(ff.substring(5, 7) + "the");
/* 164 */             u = Integer.parseInt(String.valueOf(ff.substring(5, 7)));
/*     */           } catch (ParseException ex) {
/* 166 */             ex.printStackTrace();
/*     */           }
/* 168 */           if (u == 1) {
/* 169 */             amtJan = Double.valueOf(amtJan.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 171 */           else if (u == 2) {
/* 172 */             amtFeb = Double.valueOf(amtFeb.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 174 */           else if (u == 3) {
/* 175 */             amtMar = Double.valueOf(amtMar.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 177 */           else if (u == 4) {
/* 178 */             amtApril = Double.valueOf(amtApril.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 180 */           else if (u == 5) {
/* 181 */             amtMay = Double.valueOf(amtMay.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 183 */           else if (u == 6) {
/* 184 */             amtJune = Double.valueOf(amtJune.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 186 */           else if (u == 7) {
/* 187 */             amtJul = Double.valueOf(amtJul.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 189 */           else if (u == 8) {
/* 190 */             amtAug = Double.valueOf(amtAug.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 192 */           else if (u == 9) {
/* 193 */             amtSep = Double.valueOf(amtSep.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 195 */           else if (u == 10) {
/* 196 */             amtOct = Double.valueOf(amtOct.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 198 */           else if (u == 11)
/*     */           {
/* 200 */             amtNov = Double.valueOf(amtNov.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/* 202 */           else if (u == 12) {
/* 203 */             amtDec = Double.valueOf(amtDec.doubleValue() + Double.parseDouble(this.data[i][1]));
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 210 */       System.out.println(amtOct);
/* 211 */       dataset.setValue(amtJan, "Sales", "Jan");
/* 212 */       dataset.setValue(amtFeb, "Sales", "Feb");
/* 213 */       dataset.setValue(amtMar, "Sales", "Mar");
/* 214 */       dataset.setValue(amtApril, "Sales", "April");
/* 215 */       dataset.setValue(amtMay, "Sales", "May");
/* 216 */       dataset.setValue(amtJune, "Sales", "Jun");
/* 217 */       dataset.setValue(amtJul, "Sales", "Jul");
/* 218 */       dataset.setValue(amtAug, "Sales", "Aug");
/* 219 */       dataset.setValue(amtSep, "Sales", "Sep");
/* 220 */       dataset.setValue(amtOct, "Sales", "Oct");
/* 221 */       dataset.setValue(amtNov, "Sales", "Nov");
/* 222 */       dataset.setValue(amtDec, "Sales", "Dec");
/* 223 */       JFreeChart chart = ChartFactory.createBarChart("Comparison between Salesman", "Month", "Sales", dataset, PlotOrientation.VERTICAL, false, true, false);
/*     */       try
/*     */       {
/* 227 */         ChartUtilities.saveChartAsJPEG(new File("C:chart.jpg"), chart, 500, 300);
/* 228 */         chart.setBackgroundPaint(Color.white);
/* 229 */         chart.fireChartChanged();
/*     */ 
/* 231 */         chart.setTitle("SALES CHART");
/* 232 */         this.cat = new ChartPanel(chart);
/*     */ 
/* 235 */         setContentPane(this.cat);
/*     */       } catch (IOException e) {
/* 237 */         System.err.println("Problem occurred creating chart.");
/*     */       }
/*     */ 
/* 241 */       chart.setBackgroundPaint(Color.white);
/* 242 */       chart.fireChartChanged();
/*     */ 
/* 244 */       chart.setTitle("SALES CHART");
/* 245 */       this.cat = new ChartPanel(chart);
/*     */ 
/* 248 */       setContentPane(this.cat);
/*     */     }
/*     */     catch (Exception ex) {
/* 251 */       JOptionPane.showMessageDialog(null, "Error", "No Data found for selected year", 0);
/* 252 */       dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 262 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 263 */         if ("windows".equals(info.getName())) {
/* 264 */           UIManager.setLookAndFeel(info.getClassName());
/* 265 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 269 */       Logger.getLogger(KESA.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 271 */       Logger.getLogger(KESA.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 273 */       Logger.getLogger(KESA.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 275 */       Logger.getLogger(KESA.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 280 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 282 */         KESA dialog = new KESA(new JFrame(), true);
/* 283 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 286 */             System.exit(0);
/*     */           }
/*     */         });
/* 289 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.KESA
 * JD-Core Version:    0.6.0
 */