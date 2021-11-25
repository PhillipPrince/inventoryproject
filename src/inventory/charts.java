/*     */ package inventory;
/*     */ 
/*     */ import com.toedter.calendar.JYearChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.border.SoftBevelBorder;
/*     */ 
/*     */ public class charts extends JDialog
/*     */ {
/*     */   Date n;
/*     */   String lastday;
/*     */   String first;
/*     */   private JButton jButton1;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JYearChooser jYearChooser1;
/*     */ 
/*     */   public charts(Frame parent, boolean modal)
/*     */   {
/*  23 */     super(parent, modal);
/*  24 */     initComponents();
/*  25 */     setLocationRelativeTo(null);
/*  26 */     Calendar c = Calendar.getInstance();
/*  27 */     SimpleDateFormat ff = new SimpleDateFormat();
/*  28 */     this.n = c.getTime();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  42 */     this.jPanel1 = new JPanel();
/*  43 */     this.jPanel2 = new JPanel();
/*  44 */     this.jLabel1 = new JLabel();
/*  45 */     this.jComboBox1 = new JComboBox();
/*  46 */     this.jLabel2 = new JLabel();
/*  47 */     this.jYearChooser1 = new JYearChooser();
/*  48 */     this.jButton1 = new JButton();
/*     */ 
/*  50 */     setDefaultCloseOperation(2);
/*     */ 
/*  52 */     this.jPanel1.setBackground(new Color(153, 153, 255));
/*     */ 
/*  54 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/*  55 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/*     */ 
/*  57 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  58 */     this.jPanel2.setLayout(jPanel2Layout);
/*  59 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  60 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  61 */       .addGap(0, 0, 32767));
/*     */ 
/*  63 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  64 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  65 */       .addGap(0, 32, 32767));
/*     */ 
/*  68 */     this.jLabel1.setText("GRAPH:");
/*     */ 
/*  70 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "SALES", "PURCHASES", "EXPENSES" }));
/*     */ 
/*  72 */     this.jLabel2.setText("SELECT DATE:");
/*     */ 
/*  74 */     this.jButton1.setText("VIEW");
/*  75 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  77 */         charts.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  81 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  82 */     this.jPanel1.setLayout(jPanel1Layout);
/*  83 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  84 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  85 */       .addComponent(this.jPanel2, -1, -1, 32767)
/*  86 */       .addGroup(jPanel1Layout
/*  86 */       .createSequentialGroup()
/*  87 */       .addGroup(jPanel1Layout
/*  87 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  88 */       .addGroup(jPanel1Layout
/*  88 */       .createSequentialGroup()
/*  89 */       .addGap(60, 60, 60)
/*  90 */       .addComponent(this.jLabel1))
/*  91 */       .addGroup(jPanel1Layout
/*  91 */       .createSequentialGroup()
/*  92 */       .addGap(35, 35, 35)
/*  93 */       .addComponent(this.jLabel2, -2, 75, -2)))
/*  94 */       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  95 */       .addGroup(jPanel1Layout
/*  95 */       .createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  96 */       .addComponent(this.jComboBox1, 0, 88, 32767)
/*  97 */       .addComponent(this.jYearChooser1, -1, -1, 32767))
/*  98 */       .addGap(18, 18, 18)
/*  99 */       .addComponent(this.jButton1)
/* 100 */       .addContainerGap(121, 32767)));
/*     */ 
/* 102 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 103 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 104 */       .addGroup(jPanel1Layout
/* 104 */       .createSequentialGroup()
/* 105 */       .addComponent(this.jPanel2, -2, -1, -2)
/* 106 */       .addGap(30, 30, 30)
/* 107 */       .addGroup(jPanel1Layout
/* 107 */       .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 108 */       .addGroup(jPanel1Layout
/* 108 */       .createSequentialGroup()
/* 109 */       .addGroup(jPanel1Layout
/* 109 */       .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 110 */       .addComponent(this.jLabel1)
/* 111 */       .addComponent(this.jComboBox1, -2, -1, -2))
/* 112 */       .addGap(38, 38, 38)
/* 113 */       .addGroup(jPanel1Layout
/* 113 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 114 */       .addComponent(this.jLabel2)
/* 115 */       .addComponent(this.jYearChooser1, -2, -1, -2)))
/* 116 */       .addComponent(this.jButton1))
/* 117 */       .addGap(0, 95, 32767)));
/*     */ 
/* 120 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 121 */     getContentPane().setLayout(layout);
/* 122 */     layout.setHorizontalGroup(layout
/* 123 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 124 */       .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/* 126 */     layout.setVerticalGroup(layout
/* 127 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 128 */       .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/* 131 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 135 */     getGraph();
/*     */   }
/*     */ 
/*     */   public void getGraph()
/*     */   {
/* 143 */     start();
/* 144 */     if (this.jComboBox1.getSelectedItem().equals("SALES"))
/*     */     {
/* 146 */       KESA n = new KESA(new JFrame(), true);
/* 147 */       n.getter(this.first, this.lastday);
/* 148 */       n.setVisible(true);
/*     */     }
/* 150 */     else if (this.jComboBox1.getSelectedItem().equals("PURCHASES")) {
/* 151 */       purchaseGraph n = new purchaseGraph(new JFrame(), true);
/* 152 */       n.getter(this.first, this.lastday);
/* 153 */       n.setVisible(true);
/*     */     }
/* 155 */     else if (this.jComboBox1.getSelectedItem().equals("EXPENSES"))
/*     */     {
/* 157 */       Expensesgraph n = new Expensesgraph(new JFrame(), true);
/* 158 */       n.getter(this.first, this.lastday);
/* 159 */       n.setVisible(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/* 165 */     int year = this.jYearChooser1.getYear();
/* 166 */     String fir = "01";
/* 167 */     String last = "31";
/* 168 */     String mon = "12";
/* 169 */     String separate = "-";
/* 170 */     this.first = String.valueOf(year).concat(separate).concat(fir).concat(separate).concat(fir);
/* 171 */     this.lastday = String.valueOf(year).concat(separate).concat(mon).concat(separate).concat(last);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 186 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 187 */         if ("Nimbus".equals(info.getName())) {
/* 188 */           UIManager.setLookAndFeel(info.getClassName());
/* 189 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 193 */       Logger.getLogger(charts.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 195 */       Logger.getLogger(charts.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 197 */       Logger.getLogger(charts.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 199 */       Logger.getLogger(charts.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 206 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 209 */         charts dialog = new charts(new JFrame(), true);
/* 210 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e)
/*     */           {
/* 214 */             System.exit(0);
/*     */           }
/*     */         });
/* 217 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           F:\inventory_run\inventory.jar
 * Qualified Name:     inventory.charts
 * JD-Core Version:    0.6.0
 */