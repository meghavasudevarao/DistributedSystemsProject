package Task3;

public class CaeserCipher {
    // Rotate a character k-positions
	public static String cipher(String sentence, int offset) {
		  String s = "";
		  for(int i = 0; i < sentence.length(); i++) {
		    char c = (char)(sentence.charAt(i));
		    if (c >= 'A' && c <= 'Z') {     
		      s += (char)((c - 'A' + offset) % 26 + 'A');
		    } else if (c >= 'a' && c <= 'z') {
		      s += (char)((c - 'a' + offset) % 26 + 'a');
		    } else {
		      s += c;
		    }
		  }
		  return s;
		}
	
    public  String encode(String s)
    {
    	return cipher(s, 3);
    }
    
    public  String decode(String s)
    {
    	return cipher(s, -3);
    } 

}
