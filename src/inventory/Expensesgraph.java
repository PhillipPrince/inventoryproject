/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author user
 */
public class Expensesgraph extends javax.swing.JDialog {
ChartPanel cat;
    String [][]data; 
    /**
     * Creates new form Expensesgraph
     */
    public Expensesgraph(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       // getter();
         
    }
public void getter( String start,String end){try{
Class.forName("com.mysql.jdbc.Driver");
           Connection  con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "this");
            String sql = "SELECT date,amt FROM expenses where date>='"+start+"'&& date<='"+end+"'";
            PreparedStatement stamt = con.prepareStatement(sql);
         ResultSet ris = stamt.executeQuery();
         if(ris.next()){
           ris.last();
           data=new String[ris.getRow()][2];
           ris.beforeFirst();
         }
         int rowcount = 0;
            while (ris.next()) {
                           

             data[rowcount][0]=ris.getString(1); 
             data[rowcount][1]=ris.getString(2); 
             System.out.println(data[rowcount][0]);
              rowcount++;   
               // connf.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
prepare();
}
public void prepare(){
try{
int u=0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    SimpleDateFormat t=new SimpleDateFormat("yyyy-MM");
    Double amtJan=0.0;
    Double amtFeb=0.0;
    Double amtMar=0.0;
    Double amtApril=0.0;
    Double amtMay=0.0;
    Double amtJune=0.0;
    Double amtJul=0.0;
    Double amtAug=0.0;
    Double amtSep=0.0;
    Double amtOct=0.0;
    Double amtNov=0.0;
    Double amtDec=0.0;
    
    for(int i=0; i<data.length; i++){
    for(int y=0;y<data[i].length;y++){
    if(y==0){
                    try {
                        Date cur=(Date)t.parse(data[i][y]);
                        String ff=t.format(cur);
                        System.out.println(ff.substring(5,7) +"the");
                        u=Integer.parseInt(String.valueOf(ff.substring(5,7)));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    if(u==1){
                    amtJan=amtJan+Double.parseDouble(data[i][1]);
                    }
                    else if(u==2){
                    amtFeb=amtFeb+Double.parseDouble(data[i][1]);
                    }
                    else if(u==3){
                    amtMar=amtMar+Double.parseDouble(data[i][1]);
                    }
                    else if(u==4){
                    amtApril=amtApril+Double.parseDouble(data[i][1]);
                    }
                    else if(u==5){
                    amtMay=amtMay+Double.parseDouble(data[i][1]);
                    }
                    else if(u==6){
                    amtJune=amtJune+Double.parseDouble(data[i][1]);
                    }
                    else if(u==7){
                    amtJul=amtJul+Double.parseDouble(data[i][1]);
                    }
                    else if(u==8){
                    amtAug=amtAug+Double.parseDouble(data[i][1]);
                    }
                    else if(u==9){
                    amtSep=amtSep+Double.parseDouble(data[i][1]);
                    }
                    else if(u==10){
                    amtOct=amtOct+Double.parseDouble(data[i][1]);
                    }
                    else if(u==11){
                       // System.out.println("nov");
                    amtNov=amtNov+Double.parseDouble(data[i][1]);
                    }
                    else if(u==12){
                    amtDec=amtDec+Double.parseDouble(data[i][1]);
                    }
                    
    }
    }
    
    }
    System.out.println(amtOct);
dataset.setValue(amtJan, "Expenses", "Jan");
dataset.setValue(amtFeb, "Expenses", "Feb");
dataset.setValue(amtMar, "Expenses", "Mar");
dataset.setValue(amtApril,"Expenses", "April");
dataset.setValue(amtMay, "Expenses", "May");
dataset.setValue(amtJune, "Expenses", "Jun");
dataset.setValue(amtJul, "Expenses", "Jul");
dataset.setValue(amtAug, "Expenses", "Aug");
dataset.setValue(amtSep, "Expenses", "Sep");
dataset.setValue(amtOct, "Expenses", "Oct");
dataset.setValue(amtNov, "Expenses", "Nov");
dataset.setValue(amtDec, "Expenses", "Dec");
JFreeChart chart = ChartFactory.createBarChart("Comparison between Expenses",
"Month", "Expenses", dataset, PlotOrientation.VERTICAL,
false, true, false);
try {
ChartUtilities.saveChartAsJPEG(new File("C:chart.jpg"), chart, 500, 300);
chart.setBackgroundPaint(Color.white);
         chart.fireChartChanged();
         
       chart.setTitle("Expense CHART");
        cat= new ChartPanel(chart);
        //cat.add(jPanel1);
       // this.add(jPanel2);
        this.setContentPane(cat);
} catch (IOException e) {
System.err.println("Problem occurred creating chart.");
}
        
        //jPanel2.add(this);
         chart.setBackgroundPaint(Color.white);
         chart.fireChartChanged();
         
       chart.setTitle("Expenses CHART");
        cat= new ChartPanel(chart);
        //cat.add(jPanel1);
       // this.add(jPanel2);
        this.setContentPane(cat);


}catch(Exception ex){
JOptionPane.showMessageDialog(null, "Error", "No Data found for selected year", JOptionPane.ERROR_MESSAGE);
   this.dispose();

}


}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Expensesgraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expensesgraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expensesgraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expensesgraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Expensesgraph dialog = new Expensesgraph(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
