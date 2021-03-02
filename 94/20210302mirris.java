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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode pre=null;
        while(root!=null){
            if(root.left==null){
                ans.add(root.val);
                root=root.right;
            }
            else{
                pre=root.left;
                while(pre.right!=null&&pre.right!=root){
                    pre=pre.right;
                }
                if(pre.right!=null){
                    ans.add(root.val);
                    pre.right=null;
                    root=root.right;
                }else{
                    pre.right=root;
                    root=root.left;
                }
            }

        }
        return ans;
    }

    
}