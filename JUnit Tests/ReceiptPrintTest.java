import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReceiptPrintTest {

	private ReceiptPrint receipt;
	@BeforeEach
	void setUp() throws Exception {
		receipt = new ReceiptPrint();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"book", "food", "import medicine"})
	void should_adds_item_to_itemList_when_a_givenString_is_passed_as_argument(String item) {
		
		//given
		receipt.setItemsInfo(item);
		
		//when
		String name = item;
		
		//then
		assertEquals(name, receipt.itemsInfo.get(0));
	}
	
	
	@Test
	void should_increase_size_when_adding_multipleItems() {
		
		//given
		receipt.setItemsInfo("1 book");
		receipt.setItemsInfo("1 dish");
		receipt.setItemsInfo("1 pill");
		
		//then		
		assertEquals(3, receipt.itemsInfo.size());
	}
	
	@Test
	void should_prints_listOfItems_when_passing_arguments() {
		
		//give
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add("1 book 12.0");
		itemList.add("1 drink 13.0");	
		double tax = 2.5;
		double price = 25.0;
		
		
		//when
		ArrayList<String> itemListCopy = new ArrayList<String>();
		itemListCopy.add("1 book 12.0");
		itemListCopy.add("1 drink 13.0");
		itemListCopy.add("Sales Taxes: 2.5");
		itemListCopy.add("Total: 25.0");
		
		//then
		assertAll(
				() -> assertEquals(itemList.get(0), receipt.printReceipt(itemList, tax, price).get(0)),
				() -> assertEquals(itemList.get(1), receipt.printReceipt(itemList, tax, price).get(1)),
				() -> assertEquals(itemList.get(2), receipt.printReceipt(itemList, tax, price).get(2)),
				() -> assertEquals(itemList.get(3), receipt.printReceipt(itemList, tax, price).get(3))
				);	
		
	}
}
