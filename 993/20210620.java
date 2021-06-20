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
    int level1=-1;
    int parent1=-1;
    int level2=-1;
    int parent2=-1;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,-2);
        return (level1==level2)&&(parent1!=parent2);
    }

    private void helper(TreeNode root,int x,int y,int level,int parent){
        if(root==null){
            return;
        }
        if(root.val==x){
            level1=level;
            parent1=parent;
            return;
        }else if(root.val==y){
            level2=level;
            parent2=parent;
            return;
        }
        helper(root.left,x,y,level+1,root.val);
        helper(root.right,x,y,level+1,root.val);
    }
}