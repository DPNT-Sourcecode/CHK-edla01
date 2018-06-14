package befaster.solutions.CHK;

import java.util.HashMap;

public class Shop {
	
	HashMap<String,SKU>	skusInShop	= new HashMap<String,SKU>();
	
	public Shop()
	{
		
	}
	
	public void addSku(SKU aSku)
	{
		skusInShop.put(aSku.getId(), aSku);
	}
	

	public SKU getSku(String id)
	{
		return skusInShop.get(id);
	}
	
	public boolean isValidSku(String id)
	{
		return skusInShop.containsKey(id);
	}

}
