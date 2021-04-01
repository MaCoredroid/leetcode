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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        
        int pointer2=0;
        TreeNode root=new TreeNode(preorder[0]);
        Stack<TreeNode> res=new Stack<>();
        res.push(root);
        for(int pointer1=1;pointer1<preorder.length;pointer1++){
            int val=preorder[pointer1];
            TreeNode node=res.peek();
            if(inorder[pointer2]!=res.peek().val){
                node.left=new TreeNode(val);
                res.push(node.left);
            }else{
                while(!res.isEmpty()&&res.peek().val==inorder[pointer2]){
                    pointer2++;
                    node=res.pop();
                }
                node.right=new TreeNode(val);
                res.push(node.right);
            }
        }
        return root;

    }

   

    
}