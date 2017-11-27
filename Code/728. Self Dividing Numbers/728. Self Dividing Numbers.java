class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> retList = new ArrayList<Integer>();
        
        //List<Integer> retDigt = numToDigit(1024);
        //String out = integerArrayListToString(ret);
        //System.out.println(out);
        
        for (int i = left; i <= right; i++) {
            List<Integer> retDigt = numToDigit(i);
            if ( retDigt.contains(0) )
                continue;
            
            boolean isSelfDividing = true;
            
            Iterator<Integer> it = retDigt.iterator(); 
            while ( it.hasNext() ) {
                int digit = it.next();   
                if ( 0 != i % digit ) {
                    isSelfDividing = false;
                    break;
                }
            }
            
            if ( isSelfDividing )
                retList.add(i);
        }
        
        return retList;
    }
    
    private List<Integer> numToDigit(int num) {
        String strNum = Integer.toString(num);
        int len = strNum.length();
        List<Integer> retNum = new ArrayList<Integer>();
        
        for (int i = 0; i < len ; i++) {
            retNum.add( Character.getNumericValue( strNum.charAt(i) ) );
        }
        
        return retNum;
    }
    
    /* Just print out for testing
    private String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    private String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    */
}

public class MainClass {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int left = Integer.parseInt(line);
            line = in.readLine();
            int right = Integer.parseInt(line);
            
            List<Integer> ret = new Solution().selfDividingNumbers(left, right);
            
            String out = integerArrayListToString(ret);
            
            System.out.print(out);
        }
    }
}