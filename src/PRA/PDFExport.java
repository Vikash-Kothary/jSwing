package PRA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PDFExport {

	private static String filePath = "src\\PDFs\\pdfExports.pdf";
	private static Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static StudentList mainList;
	
	/**
	 * Creates an instance of a document which is saved in the given directory.
	 * 
	 * @param mainList
	 */
	public PDFExport(StudentList mainList){
		this.mainList = mainList;
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			addContent(document);
			document.close();
			JOptionPane.showMessageDialog(null, "PDF successfully created", "InfoBox: " + "Emails Sent" , JOptionPane.INFORMATION_MESSAGE);
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}


	  /**
	   *  This method adds content by generating paragraphs and sections for each part of the pdf
	   * The for loop cycles through each student being added to the pdf .
	   * @param document
	   * @throws DocumentException
	   */
	private static void addContent(Document document) throws DocumentException {
	    Anchor anchor = new Anchor("Student Results", font);
	    anchor.setName("Student Results");

	  
	    Chapter studentResults = new Chapter(new Paragraph(anchor), 1);

	    Section[] resultsTable = new Section[mainList.size()];
	   


	    for (int s = 0; s < mainList.size(); s++){
	    	Paragraph subPara = new Paragraph(mainList.getStudent(s).getStudentName(), font);
	    	
	    	if(mainList.getStudent(s).getResults().size() != 0){
	    	
	    		resultsTable[s] = studentResults.addSection(subPara);
	    		resultsTable[s].add(new Paragraph(" "));
	    		createTable(resultsTable[s], s);
	    	}
	    	
	    	
	     }	

	    document.add(studentResults);


	    																								
	  }

	  /**
	   * creates a table of 4 columns and stores the data of each student in the table,
	   * the cells are added one by one with each piece of information from the 2 dimensional array.
	   * 
	   * @param subCatPart
	   * @param s
	   * @throws BadElementException
	   */
	private static void createTable(Section subCatPart, int s)
	      throws BadElementException {
	    PdfPTable table = new PdfPTable(4);



	    PdfPCell c1 = new PdfPCell(new Phrase("Exam Module"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    PdfPCell c2 = new PdfPCell(new Phrase("Assessment Module"));
	    c2.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c2);

	    PdfPCell c3 = new PdfPCell(new Phrase("Exam Mark"));
	    c3.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c3);
	    
	    
	    PdfPCell c4 = new PdfPCell(new Phrase("Exam Grade"));
	    c4.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c4);
	    
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
	  
		/**
		 * Generates a 2 dimensional array based on the data pulled from each results object.
		 * @param resultsData
		 * @return
		 */
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

}