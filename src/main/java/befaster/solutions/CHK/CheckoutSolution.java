package befaster.solutions.CHK;

import java.util.*;

public class CheckoutSolution {
	
	Shop	theShop	= new Shop();
	
	
	/**
	 * Constructor
	 * Set up valid Skus - would do this in reality
	 */
	public CheckoutSolution()
	{
		/**
		SKU	A = new SKU("A",50);
		SKU	B = new SKU("B",30);
		SKU	C = new SKU("C",20);
		SKU	D = new SKU("D",15);
		SKU	E = new SKU("E",40);
		SKU	F = new SKU("F",10);
		
		addSku(A);
		addSku(B);
		addSku(C);
		addSku(D);
		addSku(E);
		addSku(F);

		A.addOffer(new SkuOffer(3,130));
		A.addOffer(new SkuOffer(5,200));
		B.addOffer(new SkuOffer(2,45));
		*/
		
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
    	
    	basket.printBasket();
    	    	
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
