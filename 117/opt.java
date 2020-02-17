/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    Node prev, leftmost;
    public void processNode(Node root)
    {
        if(root==null)
        {
            return;
        }
        if(prev!=null)
        {
            prev.next=root;
        }
        else
        {
            leftmost=root;
        }
        prev=root;
    }
    public Node connect(Node root) {
        if(root==null)
        {
            return root;
        }
        leftmost=root;
        Node curr=root;
        while(leftmost!=null)
        {
            prev=null;
            curr=leftmost;
            leftmost=null;
            while(curr!=null)
            {
                processNode(curr.left);
                processNode(curr.right);
                curr=curr.next;
            }

        }
        return root;
    }
}