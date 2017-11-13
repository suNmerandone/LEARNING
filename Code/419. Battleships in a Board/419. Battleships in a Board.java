class Solution {
    public int countBattleships(char[][] board) {
        int x = board.length;
        int y = board[0].length;
        
        //System.out.println("x = " + x);
        //System.out.println("y = " + y);
        
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                //System.out.println("Now position at (" + i + "," + j + ")");
                if ( 'X' == board[i][j] ) {
                    //System.out.println("Found a 'X'");
                    boolean newBorad = true;
                    if ( 0 <= (i-1) && 'X' == board[i-1][j] ) {
                        newBorad = false;
                    }
                    if ( 0 <= (j-1) && 'X' == board[i][j-1] ) {
                        newBorad = false;
                    }
                    
                    if ( newBorad ) {
                        //System.out.println("    Found a 'X' at (" + i + "," + j + ")");
                        count++;
                    }
                }
            }
        }
        
        return count;
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
    
    public static char[][] stringToChar(String input) {
        String[] strX = input.split("\\],\\[");
        String[][] strXY = new String[strX.length][];
        int j = 0;
        for (int i = 0; i < strX.length; i++) {
            strX[i] = strX[i].replaceAll("\\[","");
            strX[i] = strX[i].replaceAll("\\]","");
            strX[i] = strX[i].replaceAll("\"","");
            
            strXY[i] = strX[i].split(",");
            j++;
        }
        
        char[][] ch = new char[strXY.length][strXY[0].length];
        for (int x = 0; x < strXY.length; x++) {
            for (int y = 0; y < strXY[x].length; y++) {
                ch[x][y] = strXY[x][y].charAt(0);
                //System.out.print(ch[x][y]);
            }
            //System.out.print(" , ");
        }
        
        return ch;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            char[][] ch = stringToChar(s);
            
            int ret = new Solution().countBattleships(ch);
            
            System.out.println(ret);
        }
    }
}