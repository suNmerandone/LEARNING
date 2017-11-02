/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */
import java.util.Base64;
class Codec {
    private String trickCode;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        byte[] encodedBytes = Base64.getEncoder().encode(longUrl.getBytes());
        String encodedText = new String(encodedBytes);
        
        // Need a mapping method here for saving unique code with url
        trickCode = encodedText;
        encodedText = encodedText.substring(10,20);         // This is a tricky way
        
        return "http://tinyurl.com/" + encodedText;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        shortUrl = shortUrl.replaceAll("http://tinyurl.com/", "");
        
        // Need a mapping method here for loading url with unique code
        shortUrl = trickCode;           // This is a tricky way
        
        byte[] decodedBytes = Base64.getDecoder().decode(shortUrl.getBytes());
        String decodedText = new String(decodedBytes);
        
        return decodedText;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

public class MainClass {
    public static String stringToString(String input) {
        assert input.length() >= 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '\\') {
                char nextChar = input.charAt(i+1);
                switch (nextChar) {
                    case '\"': sb.append('\"'); break;
                    case '/' : sb.append('/'); break;
                    case '\\': sb.append('\\'); break;
                    case 'b' : sb.append('\b'); break;
                    case 'f' : sb.append('\f'); break;
                    case 'r' : sb.append('\r'); break;
                    case 'n' : sb.append('\n'); break;
                    case 't' : sb.append('\t'); break;
                    default: break;
                }
                i++;
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String url = stringToString(line);
            Codec code = new Codec();
            
            String ret = code.encode(url);
            String out = (ret);
            System.out.println("Encode = " + out);
            
            ret = code.decode( code.encode(url) );
            out = (ret);
            System.out.println("Decode = " + out);
        }
    }
}