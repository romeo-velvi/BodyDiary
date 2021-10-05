package docsdownload;

import database.*;
import application.*;

import org.apache.xmlgraphics.util.uri.DataURIResolver;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

public class DocumentoPDF implements Documento{

	@Override
	public void createDocument(Iterator it) {
		org.apache.log4j.BasicConfigurator.configure();
		try {
			String path  = "PDF_factory.pdf";

			PdfWriter pdfWriter = new PdfWriter(path);
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			Document document = new Document(pdfDocument);
			pdfDocument.setDefaultPageSize(PageSize.A4);

			float col =280f;
			float columnWidth [] = {col,col};
			Table table = new Table(columnWidth);

			table.setBackgroundColor(new DeviceRgb(63,169,219))
			.setFontColor(ColorConstants.WHITE);
			table.addCell(new Cell().add(new Paragraph("Body Diary"))
					.setTextAlignment(TextAlignment.CENTER)
					.setVerticalAlignment(VerticalAlignment.MIDDLE)
					.setMarginTop(50f)
					.setMarginBottom(50f)
					.setFontSize(45f)
					.setBorder(Border.NO_BORDER)
					);

			table.addCell(new Cell().add(new Paragraph("Data Download\n"+ Measurement.getCurrentTime() +"\n"))
					.setTextAlignment(TextAlignment.RIGHT)
					.setMarginTop(50f)
					.setMarginBottom(50f)
					.setBorder(Border.NO_BORDER)
					.setMarginRight(10f)
					);

			@SuppressWarnings("unused")
			float colWidth[] = {80, 300, 100, 80};
			Table customerInfoTable = new Table(columnWidth);

			customerInfoTable.addCell(new Cell(0,4).add(new Paragraph("Informazioni Utente"))
					.setBold()
					.setBorder(Border.NO_BORDER)
					);

			customerInfoTable.addCell(new Cell().add(new Paragraph("Nome:"))
					.setBorder(Border.NO_BORDER)
					);
			customerInfoTable.addCell(new Cell().add(new Paragraph(UserData.getInstance().getName()))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph("Cognome:"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph(UserData.getInstance().getSurname()))
					.setBorder(Border.NO_BORDER));

			customerInfoTable.addCell(new Cell().add(new Paragraph("Email:"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph(UserData.getInstance().getMail()))
					.setBorder(Border.NO_BORDER));
			
			customerInfoTable.addCell(new Cell().add(new Paragraph("Data di nascita"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(UserData.getInstance().getBirt_date())))
					.setBorder(Border.NO_BORDER));

			customerInfoTable.addCell(new Cell().add(new Paragraph("Sesso"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph(UserData.getInstance().getGender()))
					.setBorder(Border.NO_BORDER));
			
			
			document.add(table);
			document.add(new Paragraph("\n"));
			document.add(customerInfoTable);
			document.add(new Paragraph("\n"));
			
			
			float itemInfoWidth[] = {279,279};
			Table itemInfoTable = null;

			Measurement mes;
		
			while (it.hasNext()) {
				mes= (Measurement)it.next();
				
				
				itemInfoTable = new Table(itemInfoWidth);

				itemInfoTable.addCell(new Cell().add(new Paragraph("Tipo"))
						.setBackgroundColor(new DeviceRgb(63,169,219))
						.setFontColor(ColorConstants.WHITE)
						);
				itemInfoTable.addCell(new Cell().add(new Paragraph("Valore"))
						.setBackgroundColor(new DeviceRgb(63,169,219))
						.setFontColor(ColorConstants.WHITE));
				
				itemInfoTable.addCell(new Cell().add(new Paragraph("Weight")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getWeight()))));
				
				itemInfoTable.addCell(new Cell().add(new Paragraph("Thinghs")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getThighs()))));

				itemInfoTable.addCell(new Cell().add(new Paragraph("Chest")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getChest()))));
				
				itemInfoTable.addCell(new Cell().add(new Paragraph("Height")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getHeight()))));
				
				itemInfoTable.addCell(new Cell().add(new Paragraph("Forearms")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getForearms()))));
				
				itemInfoTable.addCell(new Cell().add(new Paragraph("Biceps")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getBiceps()))));
				
				itemInfoTable.addCell(new Cell().add(new Paragraph("Hips")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getHips()))));
				
				
				itemInfoTable.addCell(new Cell().add(new Paragraph("Waistline")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getWaistline()))));
				
				
				itemInfoTable.addCell(new Cell().add(new Paragraph("Calfs")));
				itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(mes.getCalfs()))));	
				
				
				itemInfoTable.addCell(new Cell().add(new Paragraph(""))
						.setBackgroundColor(new DeviceRgb(63,169,219))
						.setFontColor(ColorConstants.WHITE)
						.setBorder(Border.NO_BORDER)
						);
				itemInfoTable.addCell(new Cell().add(new Paragraph("Data misurazione: " + String.valueOf(mes.getDate())))
						.setTextAlignment(TextAlignment.CENTER)
						.setBackgroundColor(new DeviceRgb(63,169,219))
						.setFontColor(ColorConstants.WHITE)
						.setBorder(Border.NO_BORDER)
						);
				
				document.add(itemInfoTable);
				document.add(new Paragraph("\n"));
			}
			




		
			
			
			document.close();
		}catch(Exception e) {
			System.out.println("error");
		}
	}
	
}
