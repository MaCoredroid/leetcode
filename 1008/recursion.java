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
    int index=0;
    int n=0;
    int[] pre_order;
    public TreeNode helper(int lower, int upper)
    {
        if(index==n)
        {
            return null;
        }
        int val = pre_order[index];
        if(val < lower || val > upper)
        {
            return null;
        }
        index++;
        TreeNode node = new TreeNode(val);
        node.left = helper(lower,val);
        node.right = helper(val,upper);
        return node;
        
        
        
    }
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        this.pre_order=preorder;
        n = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        
        
        
    }
}