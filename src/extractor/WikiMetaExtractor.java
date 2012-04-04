package extractor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author descl
 * 
 * Improvements by eric / eric.charton@polymtl.ca
 * 
 */
public class WikiMetaExtractor {
    
    public enum Format {
    	XML("xml"),
		JSON("json");
    	
        private final String value;
        
        Format(String value) {this.value = value;}
        
        public String getValue() {return this.value;}
    }
    
    /*
     * Define API URL by default
     * 
     */
    private static String apiurl = ("http://www.wikimeta.com/wapi/service");
    
    /**
	 * construct a default loader
	 */
	public WikiMetaExtractor() { // default constructor - use default simplenlg.lexicon
		
	}
    
	/**
	 * constructor with an API URL passed 
	 */
	public WikiMetaExtractor(String ParametrizedUrl) { // default constructor - use default simplenlg.lexicon
		this.apiurl = ParametrizedUrl;
	}
    
    /*
     * Preformated method needs only api key, return format, string, language
     * 
     */
	public static String getResult(String apiKey, Format format, String content, String lng) {
		return WikiMetaExtractor.getResult(apiKey, format, content, 10, 100, lng ,true, 0);
	}

	 /*
     * Method with inclusion of word distributions parameter (1 on or 0 off)
     * 
     */
	public static String getResult(String apiKey, Format format, String content, String lng, int stats) {
		return WikiMetaExtractor.getResult(apiKey, format, content, 10, 100, lng ,true, stats);
	}
	
    /*
     * Full method
     * 
     */
    public static String getResult(String apiKey, Format format, String content, int treshold, int span, String lng, boolean semtag, int stats) {    
        String result = "";
        String callFormat = format.value;
        
        try {
            URL url = new URL(apiurl);
            HttpURLConnection server = (HttpURLConnection)url.openConnection();
            server.setDoInput(true);
            server.setDoOutput(true);
            server.setRequestMethod("POST");
            server.setRequestProperty("Accept", callFormat );
            server.connect();
            
            BufferedWriter bw = new BufferedWriter(
                                new OutputStreamWriter(
                                    server.getOutputStream()));
            String semtagS = "0";
            if(semtag)semtagS = "1";
            
            String request = "treshold="+treshold+"&span="+span+"&lng="+lng+"&semtag="+semtagS+"&api="+apiKey+"&textmining="+stats+"&contenu="+content;
            bw.write(request, 0, request.length());
            bw.flush();
            bw.close();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                result += ligne+"\n";
            }
            
            reader.close();
            server.disconnect();
        }
        catch (Exception e)
        {
            Logger.getLogger(WikiMetaExtractor.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    
   
}
