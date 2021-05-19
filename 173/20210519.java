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
    List<Integer> ans=new ArrayList<>();
    int pointer=0;
    public BSTIterator(TreeNode root) {
        helper(root);
    }
    
    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }

    public int next() {
        return ans.get(pointer++);
    }
    
    public boolean hasNext() {
        return pointer!=ans.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */