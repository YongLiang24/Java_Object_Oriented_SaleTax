import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {
	
	/*
	 * This fileReader method will read a text file, construct a list of items 
	 * with taxed price, calculate the total tax paid, as well as the total cost.
	 * */
	
	protected ArrayList<String> fileReader(String fileName) throws FileNotFoundException {
		
		//These two variables will be used to calculate the total tax and cost	
		double salesTaxes =0;
		double totalPrice =0;	
		ReceiptPrint printReceipt = new ReceiptPrint();
		
		//Scanner object is used to read the file as well as parse int.
		File file = new File(fileName);
		Scanner inputData = new Scanner(file);
						
		/*This while loop reads the text file and breaks it 
		 * down to individual pieces, such as name, quantity and price, 
		 * allowing to pass these values to the Item class's constructor.*/
		
		while(inputData.hasNextLine()) {

			int quantity = inputData.nextInt(); 
			
			String wholeLine = inputData.nextLine();
			
			//This splits the string into an array of strings
			String [] strSplit = wholeLine.split(" "); 
			
			//Arrays.copyOfRange() returns part of the array for item names
			String [] nameSplit = Arrays.copyOfRange(strSplit, 1, strSplit.length-2);		
			String itemName = String.join(" ", nameSplit);//convert the name array back to string
			
			//Based on the data pattern, the last element of the strSplit array is the price 
			double itemPrice = Double.parseDouble(strSplit[strSplit.length -1]);
			
			/*If the name of the item has "imported" string, the ImportItem object will be created.
			*else the BasicItem object will be created*/
			if(itemName.indexOf("imported") != -1) {
				
				Item importItem = new ImportItem(quantity, itemName, itemPrice);
				
			/*Since imported item added additional 5% tax to basic and exempted items,
			*15% and 5% tax will be added based on the item's category.*/
											
				if(importItem.isExempt(itemName)) {
					
					double importExemptPrice = importItem.calculateImportExemptedTax(importItem.itemPrice);	//5% tax added
					importItem.setItemPrice(importExemptPrice);
				}
				else {
					double importTax = importItem.calculateBasicTax(importItem.itemPrice);//15% tax added
					importItem.setItemPrice(importTax);
				}
				//calculate the tax and updatedPrice, sum up the totals to totalPrice and salesTaxes variables.				
				double importPrice = importItem.getItemPrice();			
				salesTaxes += importItem.updateTax(itemPrice, importPrice);
				totalPrice += importPrice;
				//printReceipt prints a new receipt with updated prices and add to an itemInfo list			
				printReceipt.setItemsInfo(importItem.createReceipt(importItem.itemQuantity, importItem.itemName, importItem.itemPrice));										
			}
			else {
				
				Item basicItem = new BasicItem(quantity, itemName, itemPrice);
				//If the basicItem is not exempt type, add 10% tax to the price property
				if(!basicItem.isExempt(itemName)) {
					double basicPrice = basicItem.calculateBasicTax(basicItem.itemPrice); //10% tax added
					basicItem.setItemPrice(basicPrice);
				}
				//This part updates the total tax and price
				double basicItemPrice = basicItem.getItemPrice();
				salesTaxes += basicItem.updateTax(itemPrice, basicItemPrice);
				totalPrice += basicItemPrice;	
				//printReceipt prints a new receipt with updated prices and add it to itemInfo List
				printReceipt.setItemsInfo(basicItem.createReceipt(basicItem.itemQuantity, basicItem.itemName, basicItem.itemPrice));
			}		
			
		}
		inputData.close();//close file
		
		/*The printReceipt() method takes the items datas, total tax and total price
		 *as arguments and prints a complete receipt using a for loop*/
		ArrayList<String> itemInfo = printReceipt.itemsInfo;
		ArrayList<String> itemList = printReceipt.printReceipt(itemInfo, salesTaxes, totalPrice);

		return itemList;	
	}

}
