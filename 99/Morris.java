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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode temp = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
        while(cur!=null) 
        {
            if(cur.left==null)
            {
                if(temp!=null&&temp.val>cur.val)
                {
                    node1=(node1==null)?temp:node1;
                    node2=cur;                   
                }
                temp=cur;
                cur=cur.right;
            }
            else
            {
                TreeNode mostRight=cur.left;
                while(mostRight.right!=null&&mostRight.right!=cur)
                {
                    mostRight=mostRight.right;
                }
                if(mostRight.right==null)
                {
                    mostRight.right=cur;
                    cur=cur.left;
                    continue;
                }
                if(mostRight.right==cur)
                {
                    mostRight.right=null;
                    if(temp!=null&&temp.val>cur.val)
                    {
                        node1=(node1==null)?temp:node1;
                        node2=cur;                   
                    }
                    temp=cur;
                    cur=cur.right;
                }
            }
        }
        int tempval = node1.val;
        node1.val = node2.val;
        node2.val = tempval;
    }
}