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
class BSTIterator {
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        this.stack=new Stack<TreeNode>();
        this.leftMost(root);
    }
    
    public void leftMost(TreeNode root){
        while(root!=null){
            this.stack.push(root);
            root=root.left;
        }
    }
    public int next() {
        TreeNode node=this.stack.pop();
        if(node.right!=null){
            this.leftMost(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return stack.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */