package pdf;

import java.io.FileOutputStream;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class EventPdfDownload {

	public static void generateStudentPdf(ResultSet rs, String path) {
		try {
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(path)); // ✅ FIX
			doc.open();

			Paragraph title = new Paragraph(
				"Event Report"
			);
			title.setAlignment(Element.ALIGN_CENTER);

			doc.add(title);
			doc.add(new Paragraph("\n"));

			PdfPTable table = new PdfPTable(5);
			table.addCell("ID");
			table.addCell("Name");
			table.addCell("Venue");
			table.addCell("Capacity");

			while (rs.next()) {
				table.addCell(String.valueOf(rs.getInt("eid")));
				table.addCell(rs.getString("name"));
				table.addCell(rs.getString("Venue"));
				table.addCell(rs.getString("Capcity"));
			}

			doc.add(table);
			doc.close();

			System.out.println("PDF created at: " + path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
