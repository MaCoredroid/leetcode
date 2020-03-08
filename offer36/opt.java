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
    public Node pre;
    public Node head;
    public Node tail;
    public Node treeToDoublyList(Node root) {
        if(root==null)
        {
            return root;
        }
        inOrder(root);
        head.left=tail;
        tail.right=head;
        return head;
    }
    public void inOrder(Node root)
    {
        if(root==null)
        {
            return;
        }
        inOrder(root.left);
        root.left=pre;
        if(pre!=null)
        {
            pre.right=root;
        }
        else
        {
            head=root;
        }
        pre=root;
        tail=root;
        inOrder(root.right);
    }

}