package befaster.solutions.CHK;

public class SkuOffer 
{
	private	int	offerQuantity;
	private int offerPrice;
	private SKU	offerFreebie;
	
	public SkuOffer(int quantity, int price)
	{
		offerQuantity = quantity;
		offerPrice = price;
	}
	
	public SkuOffer(int quantity, int price, SKU freebie)
	{
		offerQuantity = quantity;
		offerPrice = price;
		offerFreebie = freebie;
	}
	
	
	public int getPrice()
	{
		return offerPrice;
	}
	
	public int getQuantity()
	{
		return offerQuantity;
	}
	
	public void setFreebie(SKU skuIn)
	{
		offerFreebie = skuIn;
	}
	
	public SKU getFreebie()
	{
		return offerFreebie;
	
	}
	
	public boolean isEligible(int aQuantity)
	{
		return aQuantity >=  offerQuantity;
	}
	
	
}
