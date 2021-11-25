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
	 * 
	 */
	public class purchasesum extends javax.swing.JDialog {
public purchasesum (java.awt.Frame parent, boolean modal){
super(parent, modal);
 this.setSize(new Dimension(800,600));

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
	        String reportName = "inventory/purchasesum.jasper";
String wages="Purchased Items";

	        //Get a stream to read the file
	        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);

	        try {
	     //Fill the report with parameter, connection and the stream reader
	            JasperPrint jp = JasperFillManager.fillReport(is, null, conn);



	     //Viewer for JasperReport
	            JRViewer jv = new JRViewer(jp);

                
	     //Insert viewer to a JFrame to make it showable

                  
               
	           this.getContentPane().add(jv);
	          this.validate();
                  
	          this.setVisible(true);
	           
                  this.setTitle(wages);
 //jf.setAlwaysOnTop(true);
	           this.setLocation(300,100);
	      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //jf.dispose();
	        } catch (JRException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public static void main(String[] args) throws FileNotFoundException {

	       purchasesum ma = new purchasesum(new javax.swing.JFrame(),true);
	        ma.initConnection();
	        ma.showReport();
	    }

	}