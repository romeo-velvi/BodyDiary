package docsdownload;

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
	public void createDocument() {
		// TODO Auto-generated method stub
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

			table.addCell(new Cell().add(new Paragraph("Data Download\n 01/10/2021\n"))
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
			customerInfoTable.addCell(new Cell().add(new Paragraph("Nome Utente"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph("Cognome:"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph("Cognome Utente"))
					.setBorder(Border.NO_BORDER));

			customerInfoTable.addCell(new Cell().add(new Paragraph("Email:"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph("Email utente"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph("Altre info"))
					.setBorder(Border.NO_BORDER));
			customerInfoTable.addCell(new Cell().add(new Paragraph("okokokok"))
					.setBorder(Border.NO_BORDER));


			float itemInfoWidth[] = {186,186,186};
			Table itemInfoTable = new Table(itemInfoWidth);

			itemInfoTable.addCell(new Cell().add(new Paragraph("Muscoli"))
					.setBackgroundColor(new DeviceRgb(63,169,219))
					.setFontColor(ColorConstants.WHITE)
					);
			itemInfoTable.addCell(new Cell().add(new Paragraph("Valore"))
					.setBackgroundColor(new DeviceRgb(63,169,219))
					.setFontColor(ColorConstants.WHITE));
			itemInfoTable.addCell(new Cell().add(new Paragraph("Ultima Misurazione"))
					.setBackgroundColor(new DeviceRgb(63,169,219))
					.setFontColor(ColorConstants.WHITE));

			itemInfoTable.addCell(new Cell().add(new Paragraph("Primo")));
			itemInfoTable.addCell(new Cell().add(new Paragraph("100")));
			itemInfoTable.addCell(new Cell().add(new Paragraph("1980")));

			itemInfoTable.addCell(new Cell().add(new Paragraph("Secondo")));
			itemInfoTable.addCell(new Cell().add(new Paragraph("200")));
			itemInfoTable.addCell(new Cell().add(new Paragraph("1970")));

			itemInfoTable.addCell(new Cell().add(new Paragraph(""))
					.setBackgroundColor(new DeviceRgb(63,169,219))
					.setFontColor(ColorConstants.WHITE)
					.setBorder(Border.NO_BORDER)
					);
			itemInfoTable.addCell(new Cell().add(new Paragraph("Totale misurazioni: "))
					.setTextAlignment(TextAlignment.CENTER)
					.setBackgroundColor(new DeviceRgb(63,169,219))
					.setFontColor(ColorConstants.WHITE)
					.setBorder(Border.NO_BORDER)
					);
			itemInfoTable.addCell(new Cell().add(new Paragraph("2"))
					.setTextAlignment(TextAlignment.CENTER)
					.setBackgroundColor(new DeviceRgb(63,169,219))
					.setFontColor(ColorConstants.WHITE)
					.setBorder(Border.NO_BORDER)
					);

			document.add(table);
			document.add(new Paragraph("\n"));
			document.add(customerInfoTable);
			document.add(new Paragraph("\n"));
			document.add(itemInfoTable);
			document.close();
		}catch(Exception e) {
			System.out.println("error");
		}
	}
	
}
