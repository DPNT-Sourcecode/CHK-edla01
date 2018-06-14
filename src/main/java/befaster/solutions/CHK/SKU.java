package befaster.solutions.CHK;

import java.util.*;

public class SKU 
{
	private	String			id;
	private int				price;
	private List<SkuOffer>	offers;
	
	public SKU(String theId, int thePrice)
	{
		id 			= theId;
		price 		= thePrice;
		offers 		= new ArrayList<SkuOffer>();
		
	}
	
	public String getId()
	{
		return id;
	}
	
	public void addOffer(SkuOffer anOffer)
	{
		offers.add(anOffer);
	}
	
	/**
	 * Get (best) price
	 * This is dependent on quantity
	 * @param quantity
	 * @return
	 */
	public int getBestPrice(int forQuantity)
	{
		
		int	bestPrice 	= forQuantity * price;
		int	offerPrice	= 0;
		
		if ( !offers.isEmpty() )
		{
			for ( SkuOffer anOffer: offers)
			{
				if ( anOffer.isEligible(forQuantity) )
				{
					System.out.println("Offer " + anOffer.getPrice() + " = " + anOffer.getQuantity() );
					
					offerPrice = anOffer.getPrice() * forQuantity;
					if ( offerPrice < bestPrice )
					{
						bestPrice = offerPrice;
					}
				}
			}
		}
		return bestPrice;
	}
}
