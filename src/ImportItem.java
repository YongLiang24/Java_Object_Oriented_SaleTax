
public class ImportItem extends Item{

	/*This class extends the Item class. 5% Tax will be added 
	 * to the imported exempted items and 15% to the basic imports.
	 * */
	public ImportItem(int itemQuantity, String itemName, double itemPrice) {
		super(itemQuantity, itemName, itemPrice);
	}

	@Override
	public Double calculateBasicTax(double itemPrice) {
		
		itemPrice += (itemPrice * importBasicTax);		
		return itemPrice;
	}

	@Override
	protected Double calculateImportExemptedTax(double itemPrice) {
		
		itemPrice += (itemPrice * importExemptTax);//5% tax added
		return itemPrice;
	}


}
