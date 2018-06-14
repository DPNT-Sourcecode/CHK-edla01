package befaster.solutions.CHK;

import java.util.*;

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
	
	public boolean isEligible(Basket theBasket)
	{
		if ( qualifyingSkus.isEmpty() )
		{
			// invalid group
			return false;
		}
		
		for (SKU aSku: qualifyingSkus )
		{
			if ( !theBasket.contains(aSku.getId() ))
				return false;
		}
		return true;
	}
	
}
