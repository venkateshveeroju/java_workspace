package com.esgreport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.esgreport.entity.EsgDetail;
import com.esgreport.service.EsgDetailService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
@SpringBootApplication
public class GeneratePdf {
	@Autowired
	private EsgDetailService esgDetailService;
	
	public void generatePdfDocument() {
		OutputStream file = null;
		try {
			file = new FileOutputStream(new File("ESG Faciliation Report.pdf"));

			// Create a new Document object
			Document document = new Document();

			// You need PdfWriter to generate PDF document
			PdfWriter.getInstance(document, file);

			// Opening document for writing PDF
			document.open();
			List<EsgDetail> listEsgDetail = esgDetailService.findAll();
			for (int i = 0; i < listEsgDetail.size(); i++) {
				document.add(new Paragraph("<h1>"+esgDetailService.findAll().get(i).getEsgDetailText()+"<h1>"));
				document.add(new Paragraph(esgDetailService.findAll().get(i).getEsgDetailTextValue()));
				
			}
			// Writing content
			
			document.add(new Paragraph("You are customer # 2345433"));
			document.add(new Paragraph(new Date(new java.util.Date().getTime()).toString()));

			// Add meta data information to PDF file
			document.addCreationDate();
			document.addAuthor("veeroju");
			document.addTitle("ESG Faciliation Report");
			document.addCreator("ESG Faciliation Report");

			// close the document
			document.close();

			System.out.println("Your PDF File is succesfully created");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// closing FileOutputStream
			try {
				if (file != null) {
					file.close();
				}
			} catch (IOException io) {/* Failed to close */

			}

		}

	}

}
