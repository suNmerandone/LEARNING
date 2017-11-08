class Solution {
    public String complexNumberMultiply(String a, String b) {
        // x+yi
        // (x+yi)^2 = x^2 + yi^2 + 2xyi
        // i^2 = -1
        // String a = x+yi
        // String b = m+ni
        // x and m are constant, y and n are coefficient
        
        int x = 0, y = 0, m = 0, n = 0;
            //System.out.println(a);
        
        String[] aSplit = a.split("\\+");
        aSplit[1] = aSplit[1].replace("i", "");
        x = Integer.parseInt(aSplit[0]);
        y = Integer.parseInt(aSplit[1]);
        
        String[] bSplit = b.split("\\+");
        bSplit[1] = bSplit[1].replace("i", "");
        m = Integer.parseInt(bSplit[0]);
        n = Integer.parseInt(bSplit[1]);
        
            //System.out.println("(x,y) = (" + x + "," + y + ")");
            //System.out.println("(m,n) = (" + m + "," + n + ")");
        
        
        String sumCons = "", sumCoeff = "";
        //sum += (x*m) + (x*ni) + (m*yi) + (y*n*-1);
        sumCons += ((x*m) + (y*n*-1));
        sumCoeff += ((x*n) + (m*y));
        
        return sumCons + "+" + sumCoeff + "i";
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
            String a = stringToString(line);
            line = in.readLine();
            String b = stringToString(line);
            
            String ret = new Solution().complexNumberMultiply(a, b);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}