package befaster.solutions.CHK;

public class SkuOffer 
{
	private	int	offerQuantity;
	private int offerPrice;
	
	public SkuOffer(int quantity, int price)
	{
		offerQuantity = quantity;
		offerPrice = price;
	}
	
	public int getPrice()
	{
		return offerPrice;
	}
	
	public int getQuantity()
	{
		return offerQuantity;
	}
	
	public boolean isEligible(int aQuantity)
	{
		return aQuantity >=  offerQuantity;
	}
	
	
}
