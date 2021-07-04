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
    List<TreeNode> list=new ArrayList<>();
    Set<Integer> set=new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int val:to_delete){
            set.add(val);
        }
        helper(root,true);
        return list;
    }
    
    private boolean helper(TreeNode root,boolean flag){
        if(root==null){
            return true;
        }
        boolean toAdd=false;
        if(set.contains(root.val)){
            toAdd=true;
        }else{
            if(flag){
                list.add(root);
            }
        }
        boolean flag1=helper(root.left,toAdd);
        boolean flag2=helper(root.right,toAdd);
        if(flag1){
            root.left=null;
        }
        if(flag2){
            root.right=null;
        }
        return toAdd;
        
    }
}