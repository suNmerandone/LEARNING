class Solution {
    public int hammingDistance(int x, int y) {
        String binX = DECtoBIN(x);
        String binY = DECtoBIN(y);
            //System.out.println("binX = " + binX);
            //System.out.println("binY = " + binY);
        
        int idx = 0, len = binX.length(), count = 0;
        while( idx < len ) {
            if( binX.charAt(idx) != binY.charAt(idx) )
                count++;
            idx++;
        }
        
        return count;
    }
    
    String DECtoBIN(int inDEC) {
        StringBuilder outBIN = new StringBuilder("00000000000000000000000000000000");
        int value, idx = 0;
        
        while ( inDEC != 0 ) {
            value = inDEC % 2;
            if ( value == 1 )
                outBIN.setCharAt(idx, '1');
            inDEC /= 2;
            idx++;
        }
        
        return outBIN.reverse().toString();
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            line = in.readLine();
            int y = Integer.parseInt(line);
            
            int ret = new Solution().hammingDistance(x, y);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}