/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory;

/**
 *
 * @author user
 */




/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.io.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
	import java.util.logging.Level;
	import java.util.logging.Logger;
import javax.swing.JDialog;
	import javax.swing.JFrame;
	import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
	import net.sf.jasperreports.swing.JRViewer;

	/**
	 *
	 * @author Hans Kristanto
	 */
	public class invoicereport {
public invoicereport(){


}
	    Connection conn = null;

   public invoicereport(JFrame jFrame, boolean b) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	    public void initConnection(){

	        String HOST = "jdbc:mysql://localhost:3306/inventory";
	        String USERNAME = "root";
	        String PASSWORD = "this";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }

	        try {
	            conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public void showReport() throws FileNotFoundException{

	        //Path to your .jasper file in your package
	        String reportName = "inventory/invoice.jasper";
String wages="Invoice";

	        //Get a stream to read the file
	        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);

	        try {
                    Map param = new HashMap();
	     //Fill the report with parameter, connection and the stream reader
	            JasperPrint jp = JasperFillManager.fillReport(is, null, conn);
JasperPrintManager.printReport(jp,true);
 


	     //Viewer for JasperReport
	            JRViewer jv = new JRViewer(jp);

                
	     //Insert viewer to a JFrame to make it showable

                   JDialog jf = new JDialog();
               jf.setAlwaysOnTop(true);
	            jf.getContentPane().add(jv);
	            jf.validate();
                  
	            jf.setVisible(true);
	            jf.setSize(new Dimension(850,700));
                    jf.setTitle(wages);
                    
 jf.setAlwaysOnTop(true);
	            jf.setLocation(300,100);
	            jf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    //jf.dispose();
	        } catch (JRException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public static void main(String[] args) throws FileNotFoundException {

	       invoicereport ma = new invoicereport();
	        ma.initConnection();
	        ma.showReport();
	    }

	}