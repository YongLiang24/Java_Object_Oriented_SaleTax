
public interface CalculateTax {
	
	/*This interface will be used for items that have 
	  taxes apply to their cost */
	
	final double basicTax = 10.0/100.0;//10%
	final double importBasicTax = basicTax + 5.0/100.0;//15%
	final double importExemptTax = 5.0/100.0;//5%
	
	public Double calculateBasicTax(double itemPrice);

}
