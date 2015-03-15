package PRA;
import java.util.ArrayList;

public class StudentList {

	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Student getStudent(int i){
		return studentList.get(i);
	}
	
	
	public StudentList(){
		
	}
	
	public void addStudent(Student name){
		studentList.add(name);
	}
	
	public String toString(int i){
		String returnString;
		returnString = studentList.get(i).getFirstName() + " (";
		
		returnString += studentList.get(i).getStudentNumber() + ")";
		
		
		return returnString;		
	}
	
	public int getSize(){
		return studentList.size();
	}
	
}
