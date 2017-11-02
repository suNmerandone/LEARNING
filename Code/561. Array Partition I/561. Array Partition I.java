class Solution {
    public int arrayPairSum(int[] nums) {
        /*
            1. Get n = nums.length/2
            2. Ordering nums[] from small to large
            3. Get the sum of every nums[i] when 0 == i%2
        */
        int n = nums.length/2, sum = 0;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        
        return sum;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().arrayPairSum(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}