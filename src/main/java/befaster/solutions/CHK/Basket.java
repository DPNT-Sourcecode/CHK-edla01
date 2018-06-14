package befaster.solutions.CHK;

import java.util.HashMap;

public class Basket {
	
	HashMap<String,Integer>	basketItems	= null;
	Shop					theShop;
	
	public Basket(Shop parentShop)
	{
		theShop 	= parentShop;
		basketItems = new HashMap<String,Integer>();
		
	}
	
	public void	decodeSkuString(String skuString) throws DecodeException
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
    			else
    				throw new DecodeException("Illegal value in String");
    			
    		}
    	}
		return skusInBasket;
	}
}
