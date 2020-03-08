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
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root!=null)
        {
            backTrack(root,sum,new ArrayList<>());
        }
        return res;
    }

    public void backTrack(TreeNode root,int sum,List<Integer> temp)
    {
        if(root.left==null&&root.right==null)
        {
            if(sum==root.val)
            {
                temp.add(root.val);
                res.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size()-1);
                return;
            }
        }
        else
        {
            temp.add(root.val);
            
            if(root.left!=null)
            {
                backTrack(root.left,sum-root.val,temp);
            }
            if(root.right!=null)
            {
                backTrack(root.right,sum-root.val,temp);
            }
            temp.remove(temp.size()-1);
        }
    }
}