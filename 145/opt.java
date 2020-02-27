import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
    List<Integer> ans=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return ans;
    }
    public void postorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        ans.add(root.val);
        
    }
}