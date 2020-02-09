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
    int[] preorder;
    int[] inorder;
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(0,preorder.length,0,inorder.length);
    }
    private TreeNode helper(int p_start,int p_end, int i_start,int i_end)
    {
        if(p_start==p_end)
        {
            return null;
        }
        TreeNode root=new TreeNode(preorder[p_start]);
        int root_index=map.get(preorder[p_start]);
        int left_num=root_index-i_start;
        root.left=helper(p_start+1,p_start+1+left_num,i_start,root_index);
        root.right=helper(p_start+1+left_num,p_end,root_index+1,i_end);
        return root;
    }
}