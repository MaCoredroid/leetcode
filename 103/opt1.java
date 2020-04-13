import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(0,root);
        return output;
    }
    public void dfs(int level,TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        if(level>=output.size())
        {
            LinkedList<Integer> newlevel=new LinkedList<>();
            newlevel.add(node.val);
            output.add(newlevel);
        }
        else
        {
            if(level%2==0)
            {
                output.get(level).add(node.val);
            }
            else
            {
                output.get(level).add(0,node.val);
            }
        }
        dfs(level+1,node.left);
        dfs(level+1,node.right);
    }
}