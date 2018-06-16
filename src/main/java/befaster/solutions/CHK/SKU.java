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
	
	public int getPrice()
	{
		return price;
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
		
		int	bestPrice 			= forQuantity * price;
		int	offerPrice			= 0;
		
		int	nonOfferQuantity	= 0;
		
		if ( !offers.isEmpty() )
		{
			for ( SkuOffer anOffer: offers)
			{
				if ( anOffer.isEligible(forQuantity) )
				{		
					// Need the quantity above the offer quantity
					nonOfferQuantity	= forQuantity - anOffer.getQuantity(); 
					
					offerPrice 			= anOffer.getPrice() + getBestPrice(nonOfferQuantity);
					if ( offerPrice < bestPrice )
					{
						bestPrice = offerPrice;
					}
				}
			}
		}
		return bestPrice;
	}
	
	public List<SKU>		getFreebies(int forQuantity)
	{
		List<SKU>	freebies 	= new ArrayList<SKU>();
		
		if ( !offers.isEmpty() )
		{			
			for ( SkuOffer anOffer: offers)
			{
				if ( anOffer.isEligible(forQuantity) )
				{		
					if ( anOffer.getFreebie() != null )
					{
						freebies.add( anOffer.getFreebie());
						freebies.addAll(getFreebies(forQuantity- anOffer.getQuantity()));
					}
				}
			}
		}
		return freebies;
	}
}
