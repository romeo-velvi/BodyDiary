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

import database.Iterator;
import database.Measurement;

public class DocumentoDOCX implements Documento{

	@Override
	public void createDocument(Iterator it) {
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
        	
        	
        	
            // Creating Table  
           
            
            Measurement mes;
            
			while (it.hasNext()) {
				mes= (Measurement)it.next();
				 // Columns  
				 XWPFTable tab = document.createTable();  
		         XWPFTableRow row1 = tab.getRow(0);   
	            row1.getCell(0).setText("Tipo");  
	            row1.addNewTableCell().setText("Valore");   
	            tab.setRowBandSize(25);
	            
	            XWPFTableRow row2 = tab.createRow(); // Second Row  
	            row2.getCell(0).setText("Weight");  
	            row2.getCell(1).setText(String.valueOf(mes.getWeight()));   
	            
	            XWPFTableRow row3 = tab.createRow(); // Third Row  
	            row3.getCell(0).setText("Thighs");  
	            row3.getCell(1).setText(String.valueOf(mes.getThighs()));
	            
	            XWPFTableRow row4 = tab.createRow(); // Third Row  
	            row4.getCell(0).setText("Chest");  
	            row4.getCell(1).setText(String.valueOf(mes.getChest()));
	            
	            XWPFTableRow row5 = tab.createRow(); // Third Row  
	            row5.getCell(0).setText("Height");  
	            row5.getCell(1).setText(String.valueOf(mes.getHeight()));
	            
	            XWPFTableRow row6 = tab.createRow(); // Third Row  
	            row6.getCell(0).setText("Forearms");  
	            row6.getCell(1).setText(String.valueOf(mes.getForearms()));
	            
	            XWPFTableRow row7 = tab.createRow(); // Third Row  
	            row7.getCell(0).setText("Biceps");  
	            row7.getCell(1).setText(String.valueOf(mes.getBiceps()));
	            
	            XWPFTableRow row8 = tab.createRow(); // Third Row  
	            row8.getCell(0).setText("Hips");  
	            row8.getCell(1).setText(String.valueOf(mes.getHips()));
	            
	            XWPFTableRow row9 = tab.createRow(); // Third Row  
	            row9.getCell(0).setText("Waistline");  
	            row9.getCell(1).setText(String.valueOf(mes.getWaistline()));
	            
	            XWPFTableRow row10 = tab.createRow(); // Third Row  
	            row10.getCell(0).setText("Calfs");  
	            row10.getCell(1).setText(String.valueOf(mes.getCalfs()));
	            
	            XWPFTable tab2 = document.createTable();  
	            XWPFTableRow row = tab2.createRow();
	            row.getCell(1).setText("Data misurazione: " + mes.getDate());
	            document.write(out);  

			}
			
           
            
            
            
        }catch(Exception e) {  
            System.out.println(e);  
        }   
	}

}
