package befaster.solutions.CHK;

import java.util.HashMap;

public class CheckoutSolution {
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
