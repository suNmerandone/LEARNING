class Solution {
    public int findComplement(int num) {
        /*
            1. For 999 as example (0011 1110 0111)
            2. Get the max power of 999 is 10-bit (2 ^ 10 = 10 0000 0000)
            3. NOT(999) = -1000 (1100 0001 1000)
            4. AND it with ((2 ^ 10)-1) = 01 1111 1111
        */
        
        int power = 0, tmp = num;
        while ( tmp != 0 ) {
            tmp = tmp >> 1;
            power++;
        }
        
        return ~num & ((1 << power)-1);
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);
            
            int ret = new Solution().findComplement(num);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}