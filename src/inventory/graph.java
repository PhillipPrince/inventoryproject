/*     */ package inventory;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.ChartUtilities;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.data.category.DefaultCategoryDataset;
/*     */ 
/*     */ public class graph
/*     */ {
/*     */   ChartPanel cat;
/*     */   String[][] data;
/*  32 */   DBConnection nn = new DBConnection();
/*     */ 
/*  34 */   public void prepare() { Double pointsf1t1 = Double.valueOf(0.0D);
/*  35 */     Double pointsf1t2 = Double.valueOf(0.0D);
/*  36 */     Double pointsf1t3 = Double.valueOf(0.0D);
/*  37 */     Double pointsf2t1 = Double.valueOf(0.0D);
/*  38 */     Double pointsf2t2 = Double.valueOf(0.0D);
/*  39 */     Double pointsf2t3 = Double.valueOf(0.0D);
/*  40 */     Double pointsf3t1 = Double.valueOf(0.0D);
/*  41 */     Double pointsf3t2 = Double.valueOf(0.0D);
/*  42 */     Double pointsf3t3 = Double.valueOf(0.0D);
/*  43 */     Double pointsf4t1 = Double.valueOf(0.0D);
/*  44 */     Double pointsf4t2 = Double.valueOf(0.0D);
/*  45 */     Double pointsf4t3 = Double.valueOf(0.0D);
/*     */     try
/*     */     {
/*  48 */       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*     */ 
/*  50 */       String[] clases = fillClass();
/*     */ 
/*  52 */       for (int i = 0; i < this.data.length; i++)
/*     */       {
/*  55 */         if (this.data[i][0].equals(clases[0]))
/*     */         {
/*  57 */           if (this.data[i][1].equals("1"))
/*     */           {
/*  59 */             pointsf1t1 = new Double(this.data[i][3]);
/*     */           }
/*  63 */           else if (this.data[i][1].equals("2"))
/*     */           {
/*  65 */             pointsf1t2 = new Double(this.data[i][3]);
/*     */           }
/*     */           else {
/*  68 */             if (!this.data[i][1].equals("3"))
/*     */               continue;
/*  70 */             pointsf1t3 = new Double(this.data[i][3]);
/*     */           }
/*     */ 
/*     */         }
/*  74 */         else if (this.data[i][0].equals(clases[1]))
/*     */         {
/*  76 */           if (this.data[i][1].equals("1"))
/*     */           {
/*  78 */             pointsf2t1 = new Double(this.data[i][3]);
/*     */           }
/*  82 */           else if (this.data[i][1].equals("2"))
/*     */           {
/*  84 */             pointsf2t2 = new Double(this.data[i][3]);
/*     */           }
/*     */           else {
/*  87 */             if (!this.data[i][1].equals("3"))
/*     */               continue;
/*  89 */             pointsf2t3 = new Double(this.data[i][3]);
/*     */           }
/*     */ 
/*     */         }
/*  94 */         else if (this.data[i][0].equals(clases[2]))
/*     */         {
/*  96 */           if (this.data[i][1].equals("1"))
/*     */           {
/*  98 */             pointsf3t1 = new Double(this.data[i][3]);
/*     */           }
/* 102 */           else if (this.data[i][1].equals("2"))
/*     */           {
/* 104 */             pointsf3t2 = new Double(this.data[i][3]);
/*     */           }
/*     */           else {
/* 107 */             if (!this.data[i][1].equals("3"))
/*     */               continue;
/* 109 */             pointsf3t3 = new Double(this.data[i][3]);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 114 */           if (!this.data[i][0].equals(clases[3]))
/*     */             continue;
/* 116 */           if (this.data[i][1].equals("1"))
/*     */           {
/* 118 */             pointsf4t1 = new Double(this.data[i][3]);
/*     */           }
/* 122 */           else if (this.data[i][1].equals("2"))
/*     */           {
/* 124 */             pointsf4t2 = new Double(this.data[i][3]);
/*     */           }
/*     */           else {
/* 127 */             if (!this.data[i][1].equals("3"))
/*     */               continue;
/* 129 */             pointsf4t3 = new Double(this.data[i][3]);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 138 */       dataset.setValue(pointsf1t1, "", "F1 T1");
/* 139 */       dataset.setValue(pointsf1t2, "", "F1 T2");
/* 140 */       dataset.setValue(pointsf1t3, "", "F1 T3");
/* 141 */       dataset.setValue(pointsf2t1, "", "F2 T1");
/* 142 */       dataset.setValue(pointsf2t2, "", "F2 T2");
/* 143 */       dataset.setValue(pointsf2t3, "", "F2 T3");
/* 144 */       dataset.setValue(pointsf3t1, "", "F3 T1");
/* 145 */       dataset.setValue(pointsf3t2, "", "F3 T2");
/* 146 */       dataset.setValue(pointsf3t3, "", "F3 T3");
/* 147 */       dataset.setValue(pointsf4t1, "", "F4 T1");
/* 148 */       dataset.setValue(pointsf4t2, "", "F4 T2");
/* 149 */       dataset.setValue(pointsf4t3, "", "F4 T3");
/* 150 */       JFreeChart chart = ChartFactory.createBarChart("TREND ANALYSIS ON POINTS", "Month", "Sales", dataset, PlotOrientation.VERTICAL, false, true, false);
/*     */       try
/*     */       {
/* 154 */         ChartUtilities.saveChartAsJPEG(new File("C:/chart.jpg"), chart, 500, 300);
/* 155 */         chart.setBackgroundPaint(Color.white);
/* 156 */         chart.fireChartChanged();
/*     */ 
/* 158 */         chart.setTitle("SALES CHART");
/* 159 */         this.cat = new ChartPanel(chart);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 164 */         System.err.println("Problem occurred creating chart.");
/*     */       }
/*     */ 
/* 168 */       chart.setBackgroundPaint(Color.white);
/* 169 */       chart.fireChartChanged();
/*     */ 
/* 171 */       chart.setTitle("SALES CHART");
/* 172 */       this.cat = new ChartPanel(chart);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 177 */       ex.printStackTrace();
/* 178 */       JOptionPane.showMessageDialog(null, "Error", "No Data found for selected year", 0);
/*     */     } }
/*     */ 
/*     */   public void getter()
/*     */   {
/*     */     try
/*     */     {
/* 185 */       Connection con = this.nn.getDBConnection();
/* 186 */       String sql = "SELECT Class,term,grade,round((points),2) FROM exams_ave where admin_no='377'";
/* 187 */       PreparedStatement stamt = con.prepareStatement(sql);
/* 188 */       ResultSet ris = stamt.executeQuery();
/* 189 */       if (ris.next()) {
/* 190 */         ris.last();
/* 191 */         this.data = new String[ris.getRow()][4];
/* 192 */         ris.beforeFirst();
/*     */       }
/* 194 */       int rowcount = 0;
/* 195 */       while (ris.next())
/*     */       {
/* 198 */         this.data[rowcount][0] = ris.getString(1);
/* 199 */         this.data[rowcount][1] = ris.getString(2);
/* 200 */         this.data[rowcount][2] = ris.getString(3);
/* 201 */         this.data[rowcount][3] = ris.getString(4);
/* 202 */         System.out.println(this.data[0][3]);
/* 203 */         rowcount++;
/*     */       }
/*     */     }
/*     */     catch (Exception exc) {
/* 207 */       exc.printStackTrace();
/*     */     }
/* 209 */     System.out.println(this.data.length);
/* 210 */     prepare();
/*     */   }
/*     */   public String[] fillClass() {
/* 213 */     String[] classes = null;
/*     */     try
/*     */     {
/* 217 */       String sql = "SELECT Name FROM Class order by ordered asc";
/* 218 */       Connection con = this.nn.getDBConnection();
/* 219 */       PreparedStatement st = con.prepareStatement(sql);
/*     */ 
/* 221 */       ResultSet rs = st.executeQuery();
/* 222 */       if (rs.next()) {
/* 223 */         rs.last();
/* 224 */         classes = new String[rs.getRow()];
/* 225 */         rs.beforeFirst();
/*     */       }
/* 227 */       int rowcount = 0;
/* 228 */       while (rs.next())
/*     */       {
/* 230 */         classes[rowcount] = rs.getString(1);
/* 231 */         rowcount++;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 237 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 241 */     return classes;
/*     */   }
/*     */   public graph() {
/* 244 */     getter();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 248 */     new graph();
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.graph
 * JD-Core Version:    0.6.0
 */