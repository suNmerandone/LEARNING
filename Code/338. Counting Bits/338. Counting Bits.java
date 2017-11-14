class Solution {
    public int[] countBits(int num) {
        // 0 = 0000 => Number of 1(bit) = 0
        // 1 = 0001 => Number of 1(bit) = 1
        
        // 2 = 0010 => Number of 1(bit) = 1
        // 3 = 0011 => Number of 1(bit) = 2
        
        // 4 = 0100 => Number of 1(bit) = 1
        // 5 = 0101 => Number of 1(bit) = 2
        // 6 = 0110 => Number of 1(bit) = 2
        // 7 = 0111 => Number of 1(bit) = 3
        
        // 8 = 1000 => Number of 1(bit) = 1
        // And so on...
        
        // Traditional way
        // 1. Turn DEC to BIN
        // 2. Count the number of bits
        
        // Count the bit by rules
        // 1. Count the cases in i = 0, 1, 2
        // 2. Calculate the remainder
        
        int[] ret = new int[num+1];
        for ( int i = 0; i <= num; i++ ) {
            if ( 2 > i ) {
                ret[i] = i % 2;
                continue;
            }
            
            if ( 2 == i ) {
                ret[i] = i / 2;
                continue;
            }
            
            int quotient    = i / 2;
            int remainder   = i % 2;
            
            if ( 0 == remainder ) {             // For even
                if ( 0 == (i & (i-1)) ) {         // In cases 2^n => 4, 8, 16...
                    ret[i] = 1;
                    continue;
                }
                
                ret[i] = ret[quotient];         // In other cases
                continue;
            }
            
            if ( 1 == remainder ) {             // For odd
                ret[i] = ret[i-1] + 1;
                continue;
            }
        }
        
        return ret;
    }
}

public class MainClass {
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);
            
            int[] ret = new Solution().countBits(num);
            
            String out = integerArrayToString(ret);
            
            System.out.println(out);
        }
    }
}