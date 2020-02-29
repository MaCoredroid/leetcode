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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0)
        {
            return null;
        }
        Map<Integer,Integer> indexMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            indexMap.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,indexMap);
    }
    public TreeNode helper(int[] preorder, int preorderStart,int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer,Integer> indexMap)
    {
        if(preorderStart>preorderEnd)
        {
            return null;
        }
        TreeNode root=new TreeNode(preorder[preorderStart]);
        if(preorderStart==preorderEnd)
        {
            return root;
        }
        int rootIndex=indexMap.get(preorder[preorderStart]);
        int leftlength=rootIndex-inorderStart;
        root.left=helper(preorder,preorderStart+1,preorderStart+leftlength,inorder,inorderStart,rootIndex-1,indexMap);
        root.right=helper(preorder,preorderStart+leftlength+1,preorderEnd,inorder,rootIndex+1,inorderEnd,indexMap);
        return root;
    }

    
}