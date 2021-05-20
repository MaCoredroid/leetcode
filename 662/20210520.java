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
    int ans=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        helper(root,0,0);
        return ans;
    }

    private void helper(TreeNode root,int depth,int pos){
        if(root==null){
            return;
        }
        if(!map.containsKey(depth)){
            map.put(depth,pos);
        }
        ans=Math.max(ans,pos-map.get(depth)+1);
        helper(root.left,depth+1,2*pos);
        helper(root.right,depth+1,2*pos+1);
    }
}