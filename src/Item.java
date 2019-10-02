
public abstract class Item implements CalculateTax {
	
	/*This parent class responsible for calculating taxes, updating prices
	 * and sum up the total tax and price. 
	 * */
	
	//These 3 fields will get values from reading the text file
	protected int itemQuantity;
	protected String itemName;
	protected double itemPrice;
	
	//This constructor helps to define datas into correct types
	public Item(int itemQuantity, String itemName, double itemPrice) {
		this.itemQuantity = itemQuantity;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	//This method creates a receipt for a single item
	protected String createReceipt(int quantity, String name, double price) {
		String bookReceipt = quantity + " " + name + ": " +  Math.round(price*100.0)/100.0;
		return bookReceipt;
	};
	/*This boolean method is used to determine whether a basic item 
	 * is exempted from tax.
	 * */
	protected boolean isExempt(String name) {
			
		return (name.indexOf("chocolate") != -1 || name.indexOf("book") != -1 || name.indexOf("pills") != -1) ? true : false;
	}
	//These two methods are setter and getter for itemPrice.
	protected void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	protected double getItemPrice() {
		return this.itemPrice;
	}
	
	
	//This method returns the amount of tax is paid on a single item
	protected Double updateTax(double originalPrice, double updatedPrice){
		
		return updatedPrice - originalPrice;
		
	}
	//This method calculates tax for the import exempt type items
	protected abstract Double calculateImportExemptedTax(double itemPrice);
	
	

}
