import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class FileReaderTest {
	
	FileReader fileReader; 

	@BeforeEach
	void setUp() throws Exception {
		this.fileReader  = new FileReader();
	}

	@Test
	void should_return_FileNotFoundException_when_file_is_invalid() throws FileNotFoundException {
		
		//given
		String invalidFile = "invalid file";
		
		//when
		Executable executable = ()-> fileReader.fileReader(invalidFile);
		
		//then
		assertThrows(FileNotFoundException.class, executable);
		
	}
	
	@Test
	void should_return_ArrayList_of_items_when_file_is_valid() throws FileNotFoundException {
		
		//given
		String validFile ="inputText_01";
		
		//when
		ArrayList<String> itemList = fileReader.fileReader(validFile);
			
		ArrayList<String> itemListCopy = new ArrayList<String>();
		itemListCopy.add("1 book: 12.49");
		itemListCopy.add("1 music CD: 16.49");
		itemListCopy.add("1 chocolate bar: 0.85");
		itemListCopy.add("Sales Taxes: 1.5");
		itemListCopy.add("Total: 29.83");
		
		//then
		assertArrayEquals(itemListCopy.toArray(), itemList.toArray());
		
	}
	
}
