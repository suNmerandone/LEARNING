/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        /*
            [3,2,1,6,0,5] => divided by max => [3,2,1],[6],[0,5] 
                          => fill the max sub-node => [null,3,2,1],[6],[0,5,null] (The max node/root must have left and right node)
                          => divided by max => [ [null],[3],[2,1] ],[6],[ [0],[5],[null] ] 
                          => fill the max sub-node => [ [null],[3],[null,2,1] ],[6],[ [0],[5],[null] ] 
                          => divided by max => [ [null],[3],[ [ [null],[2],[1] ] ] ],[6],[ [0],[5],[null] ] (in-order)
                          => pre-ordering => ...
                          => [6,3,5,null,2,0,null,null,1] (Answer)
            
            1. Find the max nums[i] as root. 
            2. If (i == 0) then insert null as nums[0]. 
            3. If (i == n) then insert null as nums[n]. 
            4. Then nums[0~(i-1)] as left node, and nums[(i+1)~n] as right node. 
            5. Stop when (n = nums.length) < 2. 
        */
        if ( nums == null || nums.length == 0 )
            return null;
        
        int maxAt = 0;
        for (int i = 0; i < nums.length; i++) {
            maxAt = nums[i] > nums[maxAt] ? i : maxAt;
        }
        
        TreeNode maxTree = new TreeNode( nums[maxAt] );
        
        int[] fillLeft = null, fillRight = null;
        
        if ( maxAt == 0 ) {
            fillRight = new int[nums.length-(maxAt+1)];
            System.arraycopy(nums, maxAt+1, fillRight, 0, nums.length-(maxAt+1));
        } else if ( maxAt == nums.length-1 ) {
            fillLeft = new int[maxAt];
            System.arraycopy(nums, 0, fillLeft, 0, maxAt);
        } else {
            fillLeft = new int[maxAt];
            System.arraycopy(nums, 0, fillLeft, 0, maxAt);
            fillRight = new int[nums.length-(maxAt+1)];
            System.arraycopy(nums, maxAt+1, fillRight, 0, nums.length-(maxAt+1));
        }
        
        //System.out.println("nums = " + Arrays.toString(nums));
        //System.out.println("fillLeft = " + Arrays.toString(fillLeft));
        //System.out.println("fillRight = " + Arrays.toString(fillRight));
        
        maxTree.left = constructMaximumBinaryTree(fillLeft);
        maxTree.right = constructMaximumBinaryTree(fillRight);
        
        return maxTree;
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
    
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null, ";
              continue;
            }
    
            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            TreeNode ret = new Solution().constructMaximumBinaryTree(nums);
            
            String out = treeNodeToString(ret);
            
            System.out.print(out);
        }
    }
}