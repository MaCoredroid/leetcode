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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int base=1;
        while(!q.isEmpty()){
            int size=q.size();
            boolean flag=false;
            boolean notfull=(size==base?false:true);
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null){
                    if(flag||notfull) return false;
                    q.offer(temp.left);
                }else{
                    flag=true;
                }
                if(temp.right!=null){
                    if(flag||notfull) return false;
                    q.offer(temp.right);
                }else{
                    flag=true;
                }
            }
            base*=2;
        }
        return true;
    }
}