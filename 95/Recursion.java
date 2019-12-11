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
    private List<TreeNode> generate_trees(int start, int end)
    {
        List<TreeNode> all_trees=new LinkedList<TreeNode>();
        if(start>end)
        {
            all_trees.add(null);
            return all_trees;
        }
        for(int i=start;i<=end;i++)
        {
            List<TreeNode> leftTree= generate_trees(start, i-1);
            List<TreeNode> rightTree= generate_trees(i+1, end);
            for (TreeNode l:leftTree)
            {
                for(TreeNode r:rightTree)
                {
                    TreeNode node = new TreeNode(i);
                    node.left=l;
                    node.right=r;
                    all_trees.add(node);
                }

            }
        }
        return all_trees;
    }
    public List<TreeNode> generateTrees(int n) 
    {
        if (n == 0) 
        {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }
}