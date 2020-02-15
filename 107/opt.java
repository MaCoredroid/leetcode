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
    List<List<Integer>> ans=new ArrayList();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        preOrder(root,0);
        List<List<Integer>> ret=new ArrayList();
        for(int i=ans.size()-1;i>=0;i--)
        {
            ret.add(ans.get(i));
        }
        return ret;

    }
    public void preOrder(TreeNode root,int n)
    {
        if(root==null)
        {
            return;
        }
        if(ans.size()==n)
        {
            ans.add(new ArrayList<Integer>());
            ans.get(n).add(root.val);
        }
        else
        {
            ans.get(n).add(root.val);
        }
        preOrder(root.left,n+1);
        preOrder(root.right,n+1);
    }
}