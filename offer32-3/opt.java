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
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null)
        {
            queue.add(root);
        }
        while(!queue.isEmpty())
        {
            List<Integer> temp=new ArrayList<>();
            for(int i=queue.size()-1;i>=0;i--)
            {
                TreeNode node=queue.poll();
                temp.add(node.val);
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
            if(res.size()%2==1)
            {
                Collections.reverse(temp);
            }
            res.add(temp);
        }
        return res;
    }
}