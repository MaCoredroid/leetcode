/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
final class TreeInfo {
  public final int height;
  public final boolean balanced;

  public TreeInfo(int height, boolean balanced) {
    this.height = height;
    this.balanced = balanced;
  }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return postOrder(root).balanced;
    }
    public TreeInfo postOrder(TreeNode root)
    {
        if(root==null)
        {
            return new TreeInfo(-1,true);
        }
        TreeInfo leftInfo=postOrder(root.left);
        if(!leftInfo.balanced)
        {
            return new TreeInfo(-1,false);
        }
        TreeInfo rightInfo=postOrder(root.right);
        if(!rightInfo.balanced)
        {
            return new TreeInfo(-1,false);
        }
        if (Math.abs(leftInfo.height - rightInfo.height) < 2) 
        {
            return new TreeInfo(Math.max(leftInfo.height,rightInfo.height)+1,true);
        }
        
        return new TreeInfo(-1,false);
        
    }
}