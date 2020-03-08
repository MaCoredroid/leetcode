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
    public int[] levelOrder(TreeNode root) {
        if(root==null)
        {
            return new int[0];
        }
        List<TreeNode> res=new ArrayList<>();
        List<Integer> ret=new ArrayList<>();
        res.add(root);
        while(res.size()!=0)
        {
            TreeNode head=res.remove(0);
            ret.add(head.val);
            if(head.left!=null)
            {
                res.add(head.left);
            }
            if(head.right!=null)
            {
                res.add(head.right);
            }    
        }
        int[] ans=new int[ret.size()];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=ret.get(i);
        }
        return ans;
    }
}