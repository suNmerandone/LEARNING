class Solution {
    public boolean judgeCircle(String moves) {
        int steps = moves.length(), i = 0;
        int axisX = 0, axisY = 0;
        
        while( i < steps ) {
            switch( moves.charAt(i) ) {
                case 'U': axisY++; break;
                case 'D': axisY--; break;
                case 'L': axisX--; break;
                case 'R': axisX++; break;
                default: break;
            }
            i++;
        }
        
        if ( axisX == 0 && axisY == 0)
            return true;
        else
            return false;
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
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String moves = stringToString(line);
            
            boolean ret = new Solution().judgeCircle(moves);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}