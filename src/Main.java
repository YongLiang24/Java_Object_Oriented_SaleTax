import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * This application is ready to run. Input files are included in the project.
 * */

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		
		FileReader fileReader = new FileReader();
		
		//Add the input files to a list
		ArrayList<String> fileNames = new ArrayList<String>();
		fileNames.add("inputText_01");
		fileNames.add("inputText_02");
		fileNames.add("inputText_03");
		
		//This outter loop iterates through each files
		for(String eachFile : fileNames) {
			
			//This inner loop takes each file as argument and passes it to the fileReader method
			for(String eachItem : fileReader.fileReader(eachFile)) {
				
				//Prints out each line of the item summary to console
				System.out.println(eachItem);				
			}
			//these are for spacing when printing to console
			System.out.println("__________________________________");
			System.out.println();
		}		
	}
}
