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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            return false;
        }
        if(check(A,B)){
            return true;
        } 
        return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    private boolean check(TreeNode A,TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null||A.val!=B.val){
            return false;
        }
        return check(A.left,B.left)&&check(A.right,B.right);
    }
}