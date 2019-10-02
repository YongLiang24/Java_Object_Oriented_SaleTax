import java.util.ArrayList;

/*This class is responsible for putting datas together and prints a
 * complete receipt.
 * */

public class ReceiptPrint {
	//This ArrayList will hold all item informations after prices are determined with tax.
	protected ArrayList <String> itemsInfo = new ArrayList<String>();

	//This is a setter method for adding new items to the ArrayList
	protected void setItemsInfo(String name) {
		
		itemsInfo.add(name);
	}
	
	//This method takes the total tax and price and added them to the itemList.
	protected ArrayList<String> printReceipt(ArrayList<String> itemList, double totalTax, double totalPrice) {
		
	
		String tax = "Sales Taxes: " + Double.toString(Math.round(totalTax*100.0)/100.0);
		String price = "Total: " +Double.toString(Math.round(totalPrice*100.0)/100.0);	
		itemList.add(tax);
		itemList.add(price);
		
		return itemList;
	}
}