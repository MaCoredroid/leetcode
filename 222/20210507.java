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
        int height=0;
        while(pointer!=null){
            height++;
            pointer=pointer.left;
        }
        int left=1<<(height-1);
        int right=(1<<height)-1;
        while(left<=right){
            int middle=(left+right)/2;
            if(check(root,middle,height-1)){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return left-1;
    }

    private boolean check(TreeNode root,int count,int height){
        int bits=1<<(height-1);
        TreeNode pointer=root;
        while(pointer!=null&&bits>0){
            if((bits&count)==0){
                pointer=pointer.left;
            }else{
                pointer=pointer.right;
            }
            bits=(bits>>1);
        }
        return pointer!=null;
    }
}