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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        TreeNode pointer=root;
        int level=0;
        while(pointer!=null){
            pointer=pointer.left;
            level++;
        }
        int left=1<<(level-1);
        int right=(1<<(level))-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(exist(root,mid,level-1)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left-1;
    }

    private boolean exist(TreeNode root,int count,int level){
        int bits=1<<(level-1);
        TreeNode node=root;
        while(node!=null&&bits>0){
            if((bits & count)==0){
                node=node.left;
            }else{
                node=node.right;
            }
            bits=(bits>>1);
        }
        return node!=null;
    }
}