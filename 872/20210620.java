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
    List<Integer> ans1=new ArrayList<>();
    List<Integer> ans2=new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        helper(root1,true);
        helper(root2,false);
        if(ans1.size()!=ans2.size()){
            return false;
        }
        for(int i=0;i<ans1.size();i++){
            if(ans1.get(i)!=ans2.get(i)){
                return false;
            }
        }
        return true;
    }

    private void helper(TreeNode root,boolean flag){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(flag){
                ans1.add(root.val);
            }else{
                ans2.add(root.val);
            }
            return;
        }
        helper(root.left,flag);
        helper(root.right,flag);
    }
}