package docsdownload;

import java.io.File;
import java.io.FileOutputStream;


import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class DocumentoDOCX implements Documento{

	@Override
	public void createDocument() {
		@SuppressWarnings("resource")
		XWPFDocument document= new XWPFDocument();  
        try(FileOutputStream out = new FileOutputStream(new File("DOCX_factory.docx"))){
        	
        	XWPFParagraph paragrafo = document.createParagraph();
        	XWPFRun run = paragrafo.createRun();
        	paragrafo.setAlignment(ParagraphAlignment.CENTER);
        	paragrafo.setBorderTop(Borders.BASIC_BLACK_DOTS);
        	paragrafo.setBorderLeft(Borders.BASIC_BLACK_DOTS);
        	paragrafo.setBorderRight(Borders.BASIC_BLACK_DOTS);
        	paragrafo.setBorderBottom(Borders.BASIC_BLACK_DOTS);
        	run.setText("Body Diary");
        	run.setFontSize(28);
        	run.setColor("0394fc");
        	run.setBold(true);
        	//run.addBreak(BreakType.TEXT_WRAPPING);
        	
        	
            // Creating Table  
            XWPFTable tab = document.createTable();  
            XWPFTableRow row1 = tab.getRow(0); // First row  
            
            // Columns  
            row1.getCell(0).setText("Prima Riga Muscoli");  
            row1.addNewTableCell().setText("Primo");  
            row1.addNewTableCell().setText("Secondo");  
            tab.setRowBandSize(25);
            
            XWPFTableRow row2 = tab.createRow(); // Second Row  
            row2.getCell(0).setText("Seconda Riga valore");  
            row2.getCell(1).setText("Prim Valore");  
            row2.getCell(2).setText("Secondo Valore");  
            
            XWPFTableRow row3 = tab.createRow(); // Third Row  
            row3.getCell(0).setText("Terza riga ultima misurazione");  
            row3.getCell(1).setText("1980");  
            row3.getCell(2).setText("1970");
            
            
            document.write(out);  
        }catch(Exception e) {  
            System.out.println(e);  
        }   
	}

}
