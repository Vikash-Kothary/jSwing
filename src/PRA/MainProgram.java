package PRA;


public class MainProgram {

	public static void main(String[] args) {
		System.out.println("Bitbucket sucks");
		System.out.println("NetBeans rules");
		Student Vikash = new Student("Vikash", "Kothary", "1462396", "vikash.kothary@kcl.ac.uk", "jeff.vader@mailinator.com");
		Student Toby = new Student("Toby", "Birkett", "1431286", "toby.birkett@kcl.ac.uk", "jeff.vader@mailinator.com");
		
		StudentList mainList = new StudentList();
		
		mainList.addStudent(Vikash);
		mainList.addStudent(Toby);
		
		new InterfaceWindow(mainList);
		//new InformationPopup(Vikash);
	}

}
