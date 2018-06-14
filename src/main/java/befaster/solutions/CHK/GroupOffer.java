package befaster.solutions.CHK;

public class GroupOffer {
	private	int			offerQuantity;
	private int 		offerPrice;
	private List<SKU>	qualifyingSkus;
	
	public GroupOffer(int quantity, int price)
	{
		offerQuantity = quantity;
		offerPrice = price;
		qualifyingSkus = new ArrayList<SKU>();
	}
	
	public int getPrice()
	{
		return offerPrice;
	}
	
	public int getQuantity()
	{
		return offerQuantity;
	}
	
	public void addQualifyingSku(SKU skuIn)
	{
		qualifyingSkus.add(skuIn);
	}
	
	public List<SKU> getQualifyingSkus()
	{
		return qualifyingSkus;
	
	}
	
	public boolean isEligible(int aQuantity)
	{
		return aQuantity >=  offerQuantity;
	}
	
}
