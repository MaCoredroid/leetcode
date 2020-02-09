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
    int[] postorder;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder=postorder;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(0,postorder.length,0,inorder.length);
    }
    private TreeNode helper(int pstart,int pend,int istart,int iend)
    {
        if(pstart==pend)
        {
            return null;
        }
        TreeNode root=new TreeNode(postorder[pend-1]);
        int rootIndex=map.get(postorder[pend-1]);
        int leftlength=rootIndex-istart;
        root.left=helper(pstart,pstart+leftlength,istart,rootIndex);
        root.right=helper(pstart+leftlength,pend-1,rootIndex+1,iend);
        return root;

    }
}