import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
        {
            return ans;
        }
        helper(root,0);
        return ans;
    }
    public void helper(TreeNode root,int level)
    {
        if(root==null)
        {
            return;
        }
        if(ans.size()==level)
        {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
        
    }
}