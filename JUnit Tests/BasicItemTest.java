import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicItemTest {

	
	private BasicItem basicItem;
	@BeforeEach
	void setUp() throws Exception {
		this.basicItem = new BasicItem(0, null, 0);
	}

	@Test
	void Should_returns_taxedPrice_when_a_basePrice_is_passed_as_argument() {
		
		//given
		double itemPrice = 10.00;
		
		//when taxRate is 10%
		double finalPrice = 11.00;
		
		//then
		assertEquals(finalPrice, basicItem.calculateBasicTax(itemPrice));
	}
	
	@Test
	void should_return_null_when_an_argument_is_passed_to_the_method() {
		
		//given
		double price = 20.00;
		
		//then
		assertNull(basicItem.calculateImportExemptedTax(price));
	}

}
