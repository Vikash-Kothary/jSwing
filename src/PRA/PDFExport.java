package PRA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PDFExport {

	private static String filePath = "src\\PDFs\\pdfExports.pdf";
	private static Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static StudentList mainList;
	
	public PDFExport(StudentList mainList){
		this.mainList = mainList;
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			addMetaData(document);
			addContent(document);
			document.close();
		
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}


	  private static void addMetaData(Document document) {
	  
	  }

	

	  private static void addContent(Document document) throws DocumentException {
	    Anchor anchor = new Anchor("First Chapter", font);
	    anchor.setName("First Chapter");

	  
	    Chapter catPart = new Chapter(new Paragraph(anchor), 1);

	    Paragraph subPara = new Paragraph("Subcategory 1", font);
	    Section subCatPart = catPart.addSection(subPara);
	    subCatPart.add(new Paragraph("Hello"));

	    subPara = new Paragraph("Subcategory 2", font);
	    subCatPart = catPart.addSection(subPara);


	    // add a list
	    createList(subCatPart);
	    Paragraph paragraph = new Paragraph();
	    addEmptyLine(paragraph, 5);
	    subCatPart.add(paragraph);

	    // add a table
	    for (int s = 0; s < mainList.size(); s++){
	    	createTable(subCatPart, s);
	    	
	    }
	    // now add all this to the document
	    document.add(catPart);



	  }

	  private static void createTable(Section subCatPart, int s)
	      throws BadElementException {
	    PdfPTable table = new PdfPTable(4);

	    // t.setBorderColor(BaseColor.GRAY);
	    // t.setPadding(4);
	    // t.setSpacing(4);
	    // t.setBorderWidth(1);

	    PdfPCell c1 = new PdfPCell(new Phrase("Exam Module"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Assessment Module"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Exam Mark"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);
	    table.setHeaderRows(1);
	    
	    c1 = new PdfPCell(new Phrase("Exam Grade"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);
	    table.setHeaderRows(1);
	    
	    String[][] dataArray = toStringArray(mainList.getStudent(s).getResults());
	    for (int i = 0; i < dataArray.length; i++){
	       	table.addCell(dataArray[i][0].toString());
	    	table.addCell(dataArray[i][1].toString());
	    	table.addCell(dataArray[i][2].toString());
	    	table.addCell(dataArray[i][3].toString());
	    }

	    subCatPart.add(table);

	  }
	  
		private static String[][] toStringArray(ArrayList<Result> resultsData) {
			String[][] dataArray = new String[resultsData.size()][4];
			for (int i = 0; i < dataArray.length; i++) {
				dataArray[i][0] = resultsData.get(i).getExamModule();
				dataArray[i][1] = resultsData.get(i).getAssModule();
				dataArray[i][2] = resultsData.get(i).getExamMark();
				dataArray[i][3] = resultsData.get(i).getExamGrade();
			}
			return dataArray;
		}

	  private static void createList(Section subCatPart) {
	    List list = new List(true, false, 10);
	    list.add(new ListItem("First point"));
	    list.add(new ListItem("Second point"));
	    list.add(new ListItem("Third point"));
	    subCatPart.add(list);
	  }

	  private static void addEmptyLine(Paragraph paragraph, int number) {
	    for (int i = 0; i < number; i++) {
	      paragraph.add(new Paragraph(" "));
	    }
	  }
}