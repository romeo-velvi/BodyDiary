package docsdownload;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import database.Iterator;
import database.Measurement;
import database.UserData;

public class DocumentoDOCX implements Documento{

	@Override
	public void createDocument(Iterator it) {
		@SuppressWarnings("resource")
		XWPFDocument document= new XWPFDocument();  
        try(FileOutputStream out = new FileOutputStream(new File("DOCX_factory.docx"))){
        	
        	XWPFParagraph paragrafo = document.createParagraph();
        	XWPFRun run = paragrafo.createRun();
        	XWPFRun run01 = paragrafo.createRun();

        	paragrafo.setAlignment(ParagraphAlignment.CENTER);
        	paragrafo.setBorderTop(Borders.BASIC_BLACK_DOTS);
        	paragrafo.setBorderLeft(Borders.BASIC_BLACK_DOTS);
        	paragrafo.setBorderRight(Borders.BASIC_BLACK_DOTS);
        	paragrafo.setBorderBottom(Borders.BASIC_BLACK_DOTS);
        	run.setText("Body Diary\n");
        	run.setFontSize(18);
        	run.setColor("0394fc");
        	run.setBold(true);
        	run.addBreak(BreakType.TEXT_WRAPPING);
        	run01.setText("\tDownload date\n " + Measurement.getCurrentTime() +  "\n");
        	run01.setFontSize(14);
        	run01.setColor("2C2121");
        	
        	XWPFParagraph paragrafoUtente = document.createParagraph();
        	XWPFRun runUtente = paragrafoUtente.createRun();
        	XWPFRun runUtente1 = paragrafoUtente.createRun();
        	runUtente.setText(" User information: \n");
        	runUtente.setBold(true);
        	runUtente.addBreak(BreakType.TEXT_WRAPPING);
        	runUtente.setFontSize(14);

        	
        	runUtente1.setText("\tName: " + UserData.getInstance().getName());
        	runUtente1.addBreak(BreakType.TEXT_WRAPPING);
        	runUtente1.setText("\n\tSurname: " + UserData.getInstance().getSurname());
        	runUtente1.addBreak(BreakType.TEXT_WRAPPING);
        	runUtente1.setText("\n\tEmail: " + UserData.getInstance().getMail());
        	runUtente1.addBreak(BreakType.TEXT_WRAPPING);
        	runUtente1.setText("\n\tBirth date: " + UserData.getInstance().getBirt_date());
        	runUtente1.addBreak(BreakType.TEXT_WRAPPING);
        	runUtente1.setText("\n\tGender: " + UserData.getInstance().getGender());
        	runUtente1.addBreak(BreakType.TEXT_WRAPPING);        	
        	runUtente1.setFontSize(13);
        	
        	
        	
        	XWPFTable [] tab = new XWPFTable[10];
        
        	

			Measurement mes;
			int i = 0;
			while (it.hasNext()) {
				mes= (Measurement)it.next();
        		// Creating Table  
        		tab[i]= document.createTable();
                XWPFTableRow row1 = tab[i].getRow(0); // First row  
                // Columns  
                row1.getCell(0).setText("Type");  
                row1.addNewTableCell().setText("Value");   
                tab[i].setRowBandSize(25);
                
                XWPFTableRow row2 = tab[i].createRow(); // Second Row  
                row2.getCell(0).setText("Weight");  
                row2.getCell(1).setText(String.valueOf(mes.getWeight()));  
                
                
                XWPFTableRow row3 = tab[i].createRow(); // Third Row  
                row3.getCell(0).setText("Thinghs");  
                row3.getCell(1).setText(String.valueOf(mes.getThighs()));  
                
                XWPFTableRow row4 = tab[i].createRow(); // Third Row  
                row4.getCell(0).setText("Chest");  
                row4.getCell(1).setText(String.valueOf(mes.getChest()));  
                
                XWPFTableRow row5 = tab[i].createRow(); // Third Row  
                row5.getCell(0).setText("Height");  
                row5.getCell(1).setText(String.valueOf(mes.getHeight()));  
                
                XWPFTableRow row6 = tab[i].createRow(); // Third Row  
                row6.getCell(0).setText("Forearms");  
                row6.getCell(1).setText(String.valueOf(mes.getForearms()));  
                
                XWPFTableRow row7 = tab[i].createRow(); // Third Row  
                row7.getCell(0).setText("Biceps");  
                row7.getCell(1).setText(String.valueOf(mes.getBiceps()));  
                
                XWPFTableRow row8 = tab[i].createRow(); // Third Row  
                row8.getCell(0).setText("Hips");  
                row8.getCell(1).setText(String.valueOf(mes.getHips()));  
                
                XWPFTableRow row9 = tab[i].createRow(); // Third Row  
                row9.getCell(0).setText("Waistline");  
                row9.getCell(1).setText(String.valueOf(mes.getWaistline()));  
                
                XWPFTableRow row10 = tab[i].createRow(); // Third Row  
                row10.getCell(0).setText("Calfs");  
                row10.getCell(1).setText(String.valueOf(mes.getCalfs()));  
                
                XWPFTableRow row11 = tab[i].createRow(); // Third Row  
                row11.getCell(0).setText("Measuration date");  
                row11.getCell(1).setText(String.valueOf(mes.getDate()));  
                
                
            	XWPFParagraph paragrafo1 = document.createParagraph();
                XWPFRun run1 = paragrafo1.createRun();
                run1.setText("\n\n");
                i++;
        	}
        	
            
            
            
            document.write(out);  
        }catch(Exception e) {  
            System.out.println(e);  
        } 
         
	}

}
