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
	
	public Set<String> getSkus()
	{
		return basketItems.keySet();
	}
	
	public void setSkuQuantity(String aSku, int quantity)
	{
		basketItems.put(aSku, Integer.valueOf(quantity) );
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
				basketItems.put(aSku, 0);
			}
		}
	}
	
	/**
	 * Remove skews from basket up to limit
	 * @param skus		list of skus to remove
	 * @param skuCount max number to remove
	 */
	public void removeSkus(Set<SKU> skus, int skuCount)
	{
		String 	skuId;
		int		qtyOfSku 	= 0;
		int		remaining	= skuCount;
		
		for ( SKU aSku: skus )
		{
			skuId 	= aSku.getId();
			qtyOfSku = getSkuQuantity(skuId);
		
			if ( ( remaining > 0 ) && ( qtyOfSku > 0 ) )
			{
				if ( remaining < qtyOfSku )
				{
					setSkuQuantity(skuId,qtyOfSku-remaining);
					remaining = 0;
				}
				else
				{
					setSkuQuantity(skuId,0);
					remaining -= qtyOfSku;
				}				
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
	
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		
		for ( String aSkuId: basketItems.keySet() )
    	{
			buffer.append("SKU " + aSkuId + " = " + basketItems.get(aSkuId));
			buffer.append(",");
    	}
		
		return buffer.toString();
	}
	
}
