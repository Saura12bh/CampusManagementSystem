package pdfdownload;

import database.DbConfig;
import model.*;

public class ReportDownloadHelper extends DbConfig {

	public boolean studentReportDownload() {
		
		try {

		    ps = con.prepareStatement("SELECT * FROM student");
		    rs = ps.executeQuery();

		    String path = System.getProperty("user.home") + "\\Downloads\\students.pdf";

		    StudentPdfDownload.generateStudentPdf(rs, path); 

		    System.out.println("PDF Download Successfully: " + path);
		    return true;

		} catch (Exception e) {
		    System.out.println("Error is "+e);  
		    return false;
		}
		
	}
	
	public boolean eventReportDownload() {
		
		try {

		    ps = con.prepareStatement("SELECT * FROM event");
		    rs = ps.executeQuery();

		    String path = System.getProperty("user.home") + "\\Downloads\\events.pdf";

		    StudentPdfDownload.generateEventPdf(rs, path); 

		    System.out.println("PDF Download Successfully: " + path);
		    return true;

		} catch (Exception e) {
		    System.out.println("Error is "+e);  
		    return false;
		}
	}

	
}