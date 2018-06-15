package befaster.solutions.CHK;

import java.util.*;

public class Basket {
	
	HashMap<String,Integer>	basketItems	= null;
	Shop					theShop;
	
	public Basket(Shop parentShop)
	{
		theShop 	= parentShop;
		basketItems = new HashMap<String,Integer>();
		
	}
	
	public int getSkuQuantity(String aSku)
	{
		
		if ( basketItems.containsKey(aSku))
		{
			return basketItems.get(aSku);
		}
		return 0;
	}
	
	public void addSku(String aSku)
	{
		Integer					skuCount;
		
		if (basketItems.containsKey(aSku) )
		{
			skuCount = basketItems.get(aSku);
			basketItems.put(aSku, Integer.valueOf(skuCount.intValue()+1) );
		}
		else
		{
			basketItems.put(aSku, Integer.valueOf(1) );
		}
	}
	
	public void removeSku(String aSku)
	{
		Integer					skuCount;
		
		if (basketItems.containsKey(aSku) )
		{
			skuCount = basketItems.get(aSku);
			if (skuCount> 1 )
			{
				basketItems.put(aSku, Integer.valueOf(skuCount.intValue()-1) );
			}
			else
			{
				basketItems.remove(aSku);
			}
		}
	}
	
	public void removeSkus(List<String> skuList)
	{
		for (String aSku: skuList)
			removeSku(aSku);
		
	}
	
	public void removeListOfSkus(List<SKU> skuList)
	{
		for (SKU aSku: skuList)
			removeSku(aSku.getId());
		
	}
	
	public void	decodeSkuString(String skuString) throws DecodeException
	{
		String					aSku;
		
		
    	if ( skuString != null && skuString.length() > 0)
    	{
    		for (int index=0;index <skuString.length(); index++)
    		{
    			aSku = new String(skuString.substring(index, index+1));
    			
    			addSku(aSku);
    			if ( theShop.isValidSku(aSku) )
    			{
    				addSku(aSku);
    			}
    			else
    				throw new DecodeException("Illegal value in String");
    			
    		}
    	}
	}
	
	public boolean contains(String aSku)
	{
		return basketItems.containsKey(aSku);
	}
	
	public void printBasket()
	{
		for ( String aSkuId: basketItems.keySet() )
    	{
			System.out.println("SKU " + aSkuId + " = " + basketItems.get(aSkuId));
    	}
	}
	
}
