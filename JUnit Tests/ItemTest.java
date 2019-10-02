import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {

	private Item importItem;
	private Item basicItem;

	@BeforeEach
	void setUp() throws Exception {
		importItem = new ImportItem(0, null, 0);
		basicItem = new BasicItem(0, null, 0);		
	}
	
	@Test
	void should_returns_a_string_with_item_quanity_name_price() {
		
		//given
		int quantity = 1;
		String name = "book";
		double price = 12.49;
		
		//when
		String item = "1 book: 12.49";
		
		//then
		assertAll(
				()-> assertEquals(item, importItem.createReceipt(quantity, name, price)),
				()-> assertEquals(item, basicItem.createReceipt(quantity, name, price))			
				);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"book", "chocolate", "pills"})
	void should_returns_true_when_itemName_is_book_or_chocolate_or_pills(String name) {
		
		//given
		String itemName = "perfume";
		
		//then
		assertAll(
				()-> assertTrue(importItem.isExempt(name)),
				()-> assertFalse(importItem.isExempt(itemName)),
				
				()-> assertTrue(basicItem.isExempt(name)),
				()-> assertFalse(basicItem.isExempt(itemName))			
				);
	}
	
	@Test
	void should_returns_the_taxPaid_when_taxedPrice_minus_basePrice() {
		
		//give
		double originalPrice =100.0;
		double taxedPrice =105.49;
		
		//when
		
		double taxPaid = taxedPrice - originalPrice;
		
		//then
		
		assertAll(
				()-> assertEquals(taxPaid, importItem.updateTax(originalPrice, taxedPrice)),
				()-> assertEquals(taxPaid, basicItem.updateTax(originalPrice, taxedPrice))			
				);
	}	

}
