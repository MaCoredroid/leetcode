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
    int pre_idx=0;
    int [] preorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer,Integer>();
    public TreeNode helper(int left, int right)
    {
        if(left==right)
        {
            return null;
        }
        int root_val= preorder[pre_idx];
        TreeNode node = new TreeNode(root_val);
        int index = idx_map.get( root_val);
        pre_idx++;
        node.left = helper(left,index);
        node.right = helper(index+1,right);
        return node;
        
    }
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        this.preorder=preorder;
        int[] inorder= Arrays.copyOf(preorder,preorder.length);
        Arrays.sort(inorder);
        int index=0;
        for(Integer val:inorder)
        {
            idx_map.put(val,index++);
        }
        return helper(0,inorder.length);
        
        
        
        
    }
}