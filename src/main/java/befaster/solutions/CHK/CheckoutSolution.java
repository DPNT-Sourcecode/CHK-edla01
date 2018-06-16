package befaster.solutions.CHK;

import java.util.*;

public class CheckoutSolution {
	
	Shop	theShop	= new Shop();
	
	
	/**
	 * Constructor
	 */
	public CheckoutSolution()
	{
		SkuLoader loader = new SkuLoader(theShop);
		loader.loadFile("C://dev//tdl-runner-java//sku.txt");

	}

	
	/**
	 * Calculate value of basket
	 * For any illegal input return -1
	 * @param skus a String containing the SKUs of all the products in the basket
	 * @return Integer value
	 */
    public Integer checkout(String skus) {
    	int						totalValue 		= 0;
    	Basket					basket			= new Basket(theShop);
    	SKU						aSku;

    	try
    	{
    		basket.decodeSkuString(skus);
    	}
    	catch (DecodeException e)
    	{
    		return -1;
    	}
    	
    	    	
    	// group offers
    	for ( GroupOffer anOffer: theShop.getGroupOffers())
    	{
    		while ( anOffer.isEligible(basket))
    		{
    			basket.removeSkus(anOffer.getQualifyingSkus(), anOffer.getQuantity());
    			totalValue += anOffer.getPrice();
    		}
    	}
    	
    	// remove freebies up front
    	for ( String aSkuId: basket.getSkus() )
    	{
    		aSku = theShop.getSku(aSkuId);
    		
    		if ( aSku != null )
    		{
    			List<SKU>	freebies = aSku.getFreebies(basket.getSkuQuantity(aSkuId));
    			
    			for ( SKU freebie: freebies )
    			{
    				String	freebieId 	= freebie.getId();
    				
    				if (basket.contains(freebieId) )
    				{
    					basket.removeSku(freebieId);
    				}    				
    			}
    		}
    		else
    		{
    			System.out.println("Sku not found - Shouldnt happen");
    		}
    	}

    	// Sum up prices
    	for ( String aSkuId: basket.getSkus() )
    	{
    		aSku = theShop.getSku(aSkuId);
    		
    		if ( aSku != null )
    		{
    			totalValue  += aSku.getBestPrice(basket.getSkuQuantity(aSkuId));
    		}
    		else
    		{
    			System.out.println("Sku not found - Shouldnt happen");
    		}
    	}
    	
    	return Integer.valueOf(totalValue);
    }
}
