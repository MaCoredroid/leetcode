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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        backTrack(root,new ArrayList<Integer>(),sum);
        return ans;
    }
    public void backTrack(TreeNode root, List<Integer> temp,int sum)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null&&root.right==null)
        {
            if(sum==root.val)
            {
                temp.add(root.val);
                ans.add(new ArrayList(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        temp.add(root.val);
        backTrack(root.left,temp,sum-root.val);
        backTrack(root.right,temp,sum-root.val);
        temp.remove(temp.size()-1);
        return;
    }
}