class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        int i = 0;
        
        StringBuilder ret = new StringBuilder("");
        while ( i < ss.length-1 ) {
            ret.append( (new StringBuilder(ss[i]).reverse().toString()) + " " );
            i++;
        }
        ret.append( (new StringBuilder(ss[i]).reverse().toString()) );
        
        return ret.toString();
    }
}

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
            String s = stringToString(line);
            
            String ret = new Solution().reverseWords(s);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}