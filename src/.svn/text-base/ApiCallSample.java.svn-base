import extractor.WikiMetaExtractor;
/*
 * 
 * Sample Java Api Caller for Wikimeta
 * 
 * Thanks Christophe Desclaux - Eurecom
 * 
 * www.wikimeta.org www.wikimeta.com
 * Update April 2012
 * 
 */
public class ApiCallSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 * Sample of Caller
		 * 
		 * give adress in construtor or leave blank to use the default one
		 */
		WikiMetaExtractor SampleCaller = new WikiMetaExtractor("http://www.wikimeta.com/wapi/service");
		
		 /* 
		 *     obtain your free API key at http://my.wikimeta.com/amember/login
		 */ 
		String apikey = "insert_your_key_here"; // define your API key here
		
		/*
		 * Format is :
		 * 	   api account
		 *     format : WikiMetaExtractor.Format.JSON or WikiMetaExtractor.Format.XML
		 *     text to send
		 *     Language used : FR or EN
	
		 */
		String result = SampleCaller.getResult( apikey, WikiMetaExtractor.Format.JSON, "Bienvenue à Antibes", "FR");
		System.out.println(result);
		
		result = SampleCaller.getResult( apikey, WikiMetaExtractor.Format.XML, "The city of Lyon is in France near le Rhône river", "EN");
		System.out.println(result);
		
		/*
		 * 
		 * To make a call and ask a distribution of words
		 * 
		 * 
		 */
		String toannotate = "Charles was born in St. James's Palace on 29 May 1630 (8 June 1630 NS). His parents were King Charles I, who ruled the three kingdoms of England, Scotland and Ireland, and Queen Henrietta Maria, the sister of King Louis XIII of France. Charles was their second son and child. Their first son, who was born about a year before Charles, had died aged less than a day.[3] England, Scotland and Ireland were Christian countries, but worship was divided between different denominations such as Catholicism, Anglicanism, Presbyterianism, and Puritanism. Charles was baptised in the Chapel Royal on 27 June by the Anglican Bishop of London William Laud and brought up in the care of the Protestant Countess of Dorset, though his godparents included his mother's Catholic relations, Louis XIII and Marie de' Medici.[4] At birth, Charles automatically became Duke of Cornwall and Duke of Rothesay, along with several other associated titles. At or around his eighth birthday, he was designated Prince of Wales, though he was never formally invested with the Honours of the Principality of Wales.Charles was born in St. James's Palace on 29 May 1630 (8 June 1630 NS). His parents were King Charles I, who ruled the three kingdoms of England, Scotland and Ireland, and Queen Henrietta Maria, the sister of King Louis XIII of France. Charles was their second son and child. Their first son, who was born about a year before Charles, had died aged less than a day.[3] England, Scotland and Ireland were Christian countries, but worship was divided between different denominations such as Catholicism, Anglicanism, Presbyterianism, and Puritanism. Charles was baptised in the Chapel Royal on 27 June by the Anglican Bishop of London William Laud and brought up in the care of the Protestant Countess of Dorset, though his godparents included his mother's Catholic relations, Louis XIII and Marie de' Medici.[4] At birth, Charles automatically became Duke of Cornwall and Duke of Rothesay, along with several other associated titles. At or around his eighth birthday, he was designated Prince of Wales, though he was never formally invested with the Honours of the Principality of Wales.";
		result = SampleCaller.getResult( apikey, WikiMetaExtractor.Format.JSON, toannotate, "EN", 1);
		System.out.println(result);
		
		 
	}

}
