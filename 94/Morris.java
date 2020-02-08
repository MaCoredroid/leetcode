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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null)
        {
            if(cur.left==null)
            {
                ans.add(cur.val);
                cur=cur.right;
            }
            else
            {
                TreeNode pre=cur.left;
                while(pre.right!=null&&pre.right!=cur)
                {
                    pre=pre.right;
                }
                if(pre.right==null)
                {
                    pre.right=cur;
                    cur=cur.left;
                }
                if(pre.right==cur)
                {
                    pre.right=null;
                    ans.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return ans;
    }
    
}