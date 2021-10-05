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
           
            
          
            document.write(out);  

            
        }catch(Exception e) {  
            System.out.println(e);  
        }   
	}

}
