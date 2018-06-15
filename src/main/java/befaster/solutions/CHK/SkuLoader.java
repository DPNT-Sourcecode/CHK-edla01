package befaster.solutions.CHK;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SkuLoader {

	private	Shop theShop;
	
	public SkuLoader(Shop parent)
	{
		theShop = parent;
	}
	
	public void loadFile(String filename)
	{
		List<String>lines	= new ArrayList<String>();
		
		try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) 
		{
			lines = br.lines().collect(Collectors.toList());
		}
		catch ( IOException e)
		{
			e.printStackTrace();
			
		}
		
		for ( String aLine : lines )
		{
			parse(aLine);
		}
	}
	
	private void parse(String aLine)
	{
		String[]	fields = aLine.split(",");
		int			numberOfFields = fields.length;
		SKU			aSku;
		SkuOffer	anOffer;
		GroupOffer	aGroupOffer;
		
		if ( numberOfFields > 0)
		{
			switch ( fields[0] )
			{
			case	"S":
				// SKU
				if ( numberOfFields >= 3)
				{
					aSku = new SKU(fields[1], Integer.parseInt(fields[2]) );
					theShop.addSku(aSku);
				}
				else
				{
					System.out.println("Invalid SKU " + aLine);
				}
				break;
			case 	"O":
				// Offer
				aSku = theShop.getSku(fields[1]);
				if ( numberOfFields >= 4)
				{
					if ( aSku != null )
					{
						anOffer = new SkuOffer(Integer.parseInt(fields[2]),Integer.parseInt(fields[3]));
						aSku.addOffer(anOffer);
						
						if (numberOfFields >= 5 )
						{
							SKU	associated = theShop.getSku(fields[4]);
							if ( associated != null )
							{
								anOffer.setFreebie(associated);
							}
							else
							{
								System.out.println("Invalid offer/freebie " + aLine);
							}
						}
					}
					else
					{
						System.out.println("Invalid offer/sku " + aLine);
					}
				}
				else
				{
					System.out.println("Invalid offer " + aLine);
				}
				break;
			case 	"G":
				// Group Offer
				
				
				if ( numberOfFields >= 4) // must be one item in group
				{
					aGroupOffer = new GroupOffer(Integer.parseInt(fields[1]),Integer.parseInt(fields[2]));
					
					for (int index = 3; index <numberOfFields; index++ )
					{
						aSku = theShop.getSku(fields[index]);
						if ( aSku != null )
						{
							aGroupOffer.addQualifyingSku(aSku);
						}
						else
						{
							System.out.println("Invalid group/sku " + aLine);
						}
					}
					theShop.addGroupOffer(aGroupOffer);
				}
				else
				{
					System.out.println("Invalid group " + aLine);
				}
				break;
			}
		}
	}
}
