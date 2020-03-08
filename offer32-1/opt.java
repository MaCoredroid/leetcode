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
        int size=1;
        res.add(root);
        for(int i=0;i<size;i++)
        {
            TreeNode temp=res.get(i);
            if(temp.left!=null)
            {
                res.add(temp.left);
                size++;
            }
            if(temp.right!=null)
            {
                res.add(temp.right);
                size++;
            }
        }
        int[] ans=new int[size];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=res.get(i).val;
        }
        return ans;
    }
}