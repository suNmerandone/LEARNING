class Solution {
    public String[] findWords(String[] words) {
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";
        
        int size = 0;
        String[] tmpRetWords = new String[words.length];
        int i = 0;
        while ( i < words.length ) {    // Check the first char is belong which row
            String word = words[i].toLowerCase();
            String ch = Character.toString( word.charAt(1) );
            String row = "";
            if ( -1 < r1.indexOf(ch) )
                row = r1;
            else if ( -1 < r2.indexOf(ch) )
                row = r2;
            else if ( -1 < r3.indexOf(ch) )
                row = r3;
            
            //System.out.println( "The first char at row = " + row );
            
            int j = 2;
            while ( j < words[i].length()-1 ) {
                ch = Character.toString( word.charAt(j) );
                if ( -1 == row.indexOf(ch) )
                    break;
                j++;
            }
            
            if ( j == words[i].length()-1 ) {
                //System.out.println( "word[i] = " + word );
                tmpRetWords[size++] = words[i];
            }
            
            i++;
        }
        
        String[] retWords = new String[size];
        for (int k = 0; k < size; k++) {
            retWords[k] = tmpRetWords[k];
        }
        
        return retWords;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] words = null;
        
        while ((line = in.readLine()) != null) {
            line.replace("\"","");
            line = line.substring(1,line.length()-1);
            words = line.split(",");
        }
        
        String[] ret = new Solution().findWords(words);

        System.out.println(Arrays.toString(ret));
    }
}