/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        Node left=helper(root);
        Node p=left;
        while(p.right!=null){
            p=p.right;
        }
        left.left=p;
        p.right=left;
        return left;
    }
    
    private Node helper(Node root){
        Node left=null;
        if(root.left!=null){
            left=helper(root.left);
            Node p=left;
            while(p.right!=null){
                p=p.right;
            }
            p.right=root;
            root.left=p;
        }
        if(root.right!=null){
            Node right=helper(root.right);
            right.left=root;
            root.right=right;
        }
        return left==null?root:left;
    }
}