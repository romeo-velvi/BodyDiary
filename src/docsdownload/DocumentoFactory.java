package docsdownload;

public class DocumentoFactory {

	public Documento getDocumento(String documentType){
	      if(documentType == null){
	         return null;
	      }		
	      if(documentType.equalsIgnoreCase("PDF")){
	         return new DocumentoPDF();
	         
	      } else if(documentType.equalsIgnoreCase("DOCX")){
	         return new DocumentoDOCX();
	      }
	      
	      return null;
	   }

}
