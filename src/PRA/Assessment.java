package PRA;

import java.util.ArrayList;

public class Assessment {
	String assModule;
	ArrayList<Result> results;
	
	public Assessment(String _assModule){
		results = new ArrayList<>();
		assModule = _assModule;
	}
	
	public boolean addResult(Result result){
		if(result.getAssModule()==assModule){
			results.add(result);
			return true;
		}
		return false;
	}
}
