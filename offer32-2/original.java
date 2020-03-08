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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(root.val);
        ans.add(temp);
        List<TreeNode> nodes=new ArrayList<>();
        nodes.add(root);
        while(nodes.size()>0)
        {
            helper(ans,nodes);
        }
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<TreeNode> nodes)
    {
        int size=nodes.size();
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            if(nodes.get(i).left!=null)
            {
                temp.add(nodes.get(i).left.val);
                nodes.add(nodes.get(i).left);
            }
            if(nodes.get(i).right!=null)
            {
                temp.add(nodes.get(i).right.val);
                nodes.add(nodes.get(i).right);
            }
        }
        for(int i=0;i<size;i++)
        {
            nodes.remove(0);
        }
        if(temp.size()>0)
        {
            ans.add(temp);
        }
    }
}