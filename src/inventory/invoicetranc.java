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
	import java.util.logging.Level;
	import java.util.logging.Logger;
import javax.swing.JDialog;
	import javax.swing.JFrame;
	import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
	import net.sf.jasperreports.engine.JasperFillManager;
	import net.sf.jasperreports.engine.JasperPrint;
	import net.sf.jasperreports.swing.JRViewer;

	/**
	 *
	 * @author Hans Kristanto
	 */
	public class invoicetranc {
public invoicetranc(){


}
	    Connection conn = null;

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
	        String reportName = "inventory/invoicetransactions.jasper";
String wages="Invoice transactions";

	        //Get a stream to read the file
	        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);

	        try {
	     //Fill the report with parameter, connection and the stream reader
	            JasperPrint jp = JasperFillManager.fillReport(is, null, conn);



	     //Viewer for JasperReport
	            JRViewer jv = new JRViewer(jp);

                
	     //Insert viewer to a JFrame to make it showable

                   JDialog jf = new JDialog();
               
	            jf.getContentPane().add(jv);
	            jf.validate();
                  
	            jf.setVisible(true);
	            jf.setSize(new Dimension(800,600));
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

	       invoicetranc ma = new invoicetranc();
	        ma.initConnection();
	        ma.showReport();
	    }

	}