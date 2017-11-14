class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>();
        
        for (int i = 1; i <= n; i++) {
            if ( (0 == i%3) && (0 == i%5) )
                ret.add("FizzBuzz");
            else if ( 0 == i%3 )
                ret.add("Fizz");
            else if ( 0 == i%5 )
                ret.add("Buzz");
            else
                ret.add("" + i);
        }
        
        return ret;
    }
}

/* God way...
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new java.util.AbstractList<String>() {
			@Override
			public String get(int index) {
				int i = index + 1;
				if (i % 15 == 0) {
					return "FizzBuzz";
				} else if (i % 5 == 0) {
					return "Buzz";
				} else if (i % 3 == 0) {
					return "Fizz";
				} else {
					return String.valueOf(i);
				}
			}
			@Override
			public int size() {
				return n;//Solution.this.size;
			}
		};
		//this.size = n;
		return result;
    }
}
*/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);
            
            List<String> ret = new Solution().fizzBuzz(num);
            
            //String out = String.valueOf(ret);
            
            System.out.println(ret);
        }
    }
}