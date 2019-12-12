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
    public List<TreeNode> generateTrees(int n) 
    {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if(n==0)
        {
            return pre;
        }
        pre.add(null);
        for(int i=1;i<=n;i++)
        {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            for(TreeNode temp:pre)
            {
                TreeNode insert = new TreeNode(i);
                insert.left = temp;
                cur.add(insert);
                for(int j=0;j<=n;j++)//at most n+1 times
                {
                    TreeNode original = deepCopy(temp);
                    TreeNode pointer = original;
                    for(int k=0;k<j;k++)
                    {
                        if(pointer==null)
                        {
                            break;
                        }
                        pointer=pointer.right;
                    }
                    if(pointer==null)
                    {
                        break;
                    }
                    TreeNode rightTree= pointer.right;
                    insert =  new TreeNode(i);
                    insert.left = rightTree;
                    pointer.right = insert;
                    cur.add(original);
                }
            }
            pre=cur;
        }
        return pre;
    }
    private TreeNode deepCopy(TreeNode node)
    {
        if(node == null)
        {
            return node;
        }
        TreeNode ans = new TreeNode(node.val);
        ans.left=deepCopy(node.left);
        ans.right=deepCopy(node.right);
        return ans;
    }
}