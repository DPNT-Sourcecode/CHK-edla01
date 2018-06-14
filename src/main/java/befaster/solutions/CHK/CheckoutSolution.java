package befaster.solutions.CHK;

import java.util.HashMap;

public class CheckoutSolution {
	
	HashMap<String,SKU>	skusInShop	= new HashMap<String,SKU>();
	
	/**
	 * Constructor
	 * Set up valid Skus - would do this in reality
	 */
	public CheckoutSolution()
	{
		addSku(new SKU("A",50));
		addSku(new SKU("B",30));
		addSku(new SKU("C",20));
		addSku(new SKU("D",15));
		
		getSku("A").addOffer(new SkuOffer(3,130));
		getSku("B").addOffer(new SkuOffer(2,45));
	}
	
	public void addSku(SKU aSku)
	{
		skusInShop.put(aSku.getId(), aSku);
	}
	
	public SKU getSku(String id)
	{
		return skusInShop.get(id);
	}
	
	public HashMap<String,Integer>	decodeSkuString(String skuString)
	{
		HashMap<String,Integer>	skusInBasket	= new HashMap<String,Integer>();
		String					aSku;
		Integer					skuCount;
		
    	if ( skuString != null && skuString.length() > 0)
    	{
    		for (int index=0;index <skuString.length(); index++)
    		{
    			aSku = new String(skuString.substring(index, index+1));
    			
    			if ( skusInShop.containsKey(aSku) )
    			{
    				if (skusInBasket.containsKey(aSku) )
        			{
        				skuCount = skusInBasket.get(aSku);
        				skusInBasket.put(aSku, Integer.valueOf(skuCount.intValue()+1) );
        			}
        			else
        			{
        				skusInBasket.put(aSku, Integer.valueOf(1) );
        			}
    			}
    			
    		}
    	}
		return skusInBasket;
	}
	
	/**
	 * Calculate value of basket
	 * @param skus a String containing the SKUs of all the products in the basket
	 * @return Integer value
	 */
    public Integer checkout(String skus) {
    	int						totalValue 		= 0;
    	HashMap<String,Integer>	skusInBasket	= decodeSkuString(skus);
    	SKU						aSku;

    	for ( String aSkuId: skusInBasket.keySet() )
    	{
    		aSku = skusInShop.get(aSkuId);
    		
    		if ( aSku != null )
    		{
    			totalValue  += aSku.getBestPrice(skusInBasket.get(aSkuId));
    		}
    		else
    		{
    			System.out.println("Sku not found - Shouldnt happen");
    		}
    	}
    	
    	return Integer.valueOf(totalValue);
    }
}
