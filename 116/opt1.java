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
    public Node connect(Node root) {
        if(root==null)
        {
            return root;
        }
        Queue<Node> ans=new LinkedList<Node>();
        ans.add(root);
        while(ans.size()>0)
        {
            int size=ans.size();
            for(int i=0;i<size;i++)
            {
                Node temp=ans.poll();
                if(i<size-1)
                {
                    temp.next=ans.peek();
                }
                if(temp.left!=null)
                {
                    ans.add(temp.left);
                }
                if(temp.right!=null)
                {
                    ans.add(temp.right);
                }
            }

        }
        return root;
    }
}