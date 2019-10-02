
public class BasicItem extends Item{

	/*This class handles all the basic sales, which will have 10% tax
	 * added to the price property.
	 */
	
	public BasicItem(int itemQuantity, String itemName, double itemPrice) {
		super(itemQuantity, itemName, itemPrice);
	}
	

	@Override
	public Double calculateBasicTax(double itemPrice) {
		
		itemPrice += (itemPrice * basicTax);	
		return itemPrice;
	}

	//The import-exempted tax does not apply to this class 
	@Override
	protected Double calculateImportExemptedTax(double itemPrice) {
		return null;
	}

}
