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
    TreeNode preNode=null;
    TreeNode node1=null;
    TreeNode node2=null;
    public void recoverTree(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode rightmost=root.left;
                while(rightmost.right!=null&&rightmost.right!=root){
                    rightmost=rightmost.right;
                }
                if(rightmost.right!=root){
                    rightmost.right=root;
                    root=root.left;
                }else{
                    if(preNode!=null&&root.val<preNode.val){
                        node2=root;
                        if(node1==null){
                            node1=preNode;
                        }
                    }
                    rightmost.right=null;
                    preNode=root;
                    root=root.right;
                }
            }else{
                if(preNode!=null&&root.val<preNode.val){
                    node2=root;
                    if(node1==null){
                        node1=preNode;
                    }
                }
                preNode=root;
                root=root.right;
            }
            

        }
        int temp=node2.val;
        node2.val=node1.val;
        node1.val=temp;


    }
    
}