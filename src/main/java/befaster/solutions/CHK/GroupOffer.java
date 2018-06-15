package befaster.solutions.CHK;

import java.util.*;

public class GroupOffer {
	
	class MostExpensiveComparator implements Comparator<SKU>{
		@Override
		public int compare(SKU s1, SKU s2)
		{
			if ( s1.getPrice() < s2.getPrice() )
				return 1;
			else
				return -1;
		}
	}
	private	int				offerQuantity;
	private int 			offerPrice;
	private TreeSet<SKU>	qualifyingSkus;
	
	public GroupOffer(int quantity, int price)
	{
		offerQuantity = quantity;
		offerPrice = price;
		qualifyingSkus = new TreeSet<SKU>(new MostExpensiveComparator());
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
	
	public Set<SKU> getQualifyingSkus()
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
		
		int	numberOfQualifying = 0;
		
		for (SKU aSku: qualifyingSkus )
		{
			numberOfQualifying += theBasket.getSkuQuantity(aSku.getId());
			
		}
		return numberOfQualifying >= offerQuantity;
	}
	
	public String toString()
	{
		StringBuffer	buffer = new StringBuffer();
		buffer.append("GroupOffer<" + offerQuantity + "," + offerPrice +"," );
		for (SKU aSku: qualifyingSkus )
		{
			buffer.append(aSku.getId());
			buffer.append(" ");			
		}
		buffer.append(">");
		return buffer.toString();
	}
}
