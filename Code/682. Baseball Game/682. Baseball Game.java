class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        
        String[] fixedOps = new String[ops.length];
        int fixLen = 0;
        for (int i = 0; i < ops.length; i++) {
            if ( ops[i].equals("C") ) {
                fixLen--;
            } else {
                fixedOps[fixLen++] = ops[i];
            }
        }
        
        //System.out.println( Arrays.toString(fixedOps) );
        
        int now = 0, last1 = 0, last2 = 0;
        for (int i = 0; i < fixLen; i++) {
            String str = fixedOps[i];
            switch (str) {
                case "D":
                    last2 = last1;
                    last1 = now;
                    now = last1*2;
                    sum += now;
                    break;
                case "+":
                    last2 = last1;
                    last1 = now;
                    now = last1+last2;
                    sum += now;
                    break;
                default:
                    last2 = last1;
                    last1 = now;
                    now = Integer.parseInt(str);
                    sum += now;
                    break;
                    
            }
                    
        }
        
        return sum;
    }
}

public class MainClass {
    private static String[] stringToStringArray(String inStr) {
        inStr = inStr.replaceAll("\\[", "");
        inStr = inStr.replaceAll("\\]", "");
        inStr = inStr.replaceAll("\"", "");
        
        //System.out.println(inStr);
        
        String[] retStr = inStr.split(",");
        
        return retStr;
    }
        
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int ret = new Solution().calPoints( stringToStringArray(line) );
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}

