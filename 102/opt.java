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
    List<List<Integer>> output=new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        preOrder(root,0);
        return output;
    }
    public void preOrder(TreeNode root,int level)
    {
        if(root==null)
        {
            return;
        }
        if(output.size()==level)
        {
            output.add(new ArrayList<Integer>());           
        }
        output.get(level).add(root.val);
        preOrder(root.left,level+1);
        preOrder(root.right,level+1);
    }
}