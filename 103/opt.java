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
        preOrder(root,0);
        for(int i=0;i<output.size();i++)
        {
            if(i%2==1)
            {
                List<Integer> temp=output.get(i);
                List<Integer> ans=new ArrayList<>();
                for(int j=temp.size()-1;j>=0;j--)
                {
                    ans.add(temp.get(j));
                }
                output.set(i,ans);
            }
        }
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