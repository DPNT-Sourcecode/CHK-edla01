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
	
	/**
	 * Calculate value of basket
	 * @param skus a String containing the SKUs of all the products in the basket
	 * @return Integer value
	 */
    public Integer checkout(String skus) {
    	int						totalValue 		= 0;
    	String 					aSku			= 0;
    	Integer					aSkuCount		= null;
    	HashMap<String,Integer>	skusInBasket	= new HashMap<String,Integer>();
    	
    	// Decode
    	if ( skus != null && skus.length() > 0)
    	{
    		for (int index=0;index <skus.length(); index++)
    		{
    			aSku = new String(skus.substring(index, index+1));
    			
    			if (skusInBasket.containsKey(aSku) )
    			{
    				aSkuCount = skusInBasket.get(aSku);
    				skusInBasket.put(aSku, Integer.valueOf(aSkuCount.intValue()+1) );
    			}
    			else
    			{
    				skusInBasket.put(aSku, Integer.valueOf(1) );
    			}
    		}
    	}
    	
    	
    	return Integer.valueOf(totalValue);
    }
}
