package pdf;
import java.io.FileOutputStream;
import java.sql.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.*;
public class StudentPdfDownload {
	public static void generateStudentPdf(ResultSet rs, String path) {
		try {
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(path)); // ✅ FIX
			doc.open();

			Paragraph title = new Paragraph(
				"Student Report"
			);
			title.setAlignment(Element.ALIGN_CENTER);

			doc.add(title);
			doc.add(new Paragraph("\n"));

			PdfPTable table = new PdfPTable(5);
			table.addCell("ID");
			table.addCell("Name");
			table.addCell("Email");
			table.addCell("Mobile");
			table.addCell("Department");

			while (rs.next()) {
				table.addCell(String.valueOf(rs.getInt("sid")));
				table.addCell(rs.getString("sname"));
				table.addCell(rs.getString("email"));
				table.addCell(rs.getString("mobile"));
				table.addCell(rs.getString("department"));
			}

			doc.add(table);
			doc.close();

			System.out.println("PDF created at: " + path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
