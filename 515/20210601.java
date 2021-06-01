/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        helper(root,0);
        return ans;
    }

    public void helper(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(ans.size()==level){
            ans.add(root.val);
        }else{
            if(ans.get(level)<root.val){
                ans.set(level,root.val);
            }
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}