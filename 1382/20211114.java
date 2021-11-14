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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        inorder(root,list);
        return balanceBST(0,list.size()-1,list);
    }
    
    public void inorder(TreeNode root,List<TreeNode> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
    
    public TreeNode balanceBST(int left,int right,List<TreeNode> list){
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=list.get(mid);
        root.left=balanceBST(left,mid-1,list);
        root.right=balanceBST(mid+1,right,list);
        return root;
    }
}