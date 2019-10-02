import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImportItemTest {
	
	private ImportItem importItem;

	@BeforeEach
	void setUp() throws Exception {
		importItem = new ImportItem(0, null, 0);
	}

	@Test
	void Should_returns_a_price_with_tax_when_a_basePrice_is_passed_as_argument() {
		
		//given
		double itemPrice = 10.00;
		
		//when taxRate is 15%
		double finalPrice = 11.50;
		
		//then
		assertEquals(finalPrice, importItem.calculateBasicTax(itemPrice));
	}
	
	@Test
	void Should_returns_a_taxed_price_when_a_basePrice_is_passed_as_argument() {
		
		//given
		double itemPrice = 10.00;
		
		//when taxRate is 5%
		double finalPrice = 10.50;
		
		//then
		assertEquals(finalPrice, importItem.calculateImportExemptedTax(itemPrice));
	}

}
