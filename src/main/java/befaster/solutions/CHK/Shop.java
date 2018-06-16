package befaster.solutions.CHK;

import java.util.*;

public class Shop {
	
	HashMap<String,SKU>	skusInShop	= new HashMap<String,SKU>();
	List<GroupOffer>	groupOffers	= new ArrayList<GroupOffer>();
	
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

	public void addGroupOffer(GroupOffer offer )
	{
		groupOffers.add(offer);
	}
	
	public List<GroupOffer> getGroupOffers()
	{
		return groupOffers;
	}
}
