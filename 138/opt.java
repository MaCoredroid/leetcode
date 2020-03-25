import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    HashMap<Node,Node> res=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return null;
        }
        Node curr=head;
        while(curr!=null)
        {
            res.put(curr,new Node(curr.val));
            curr=curr.next;    
        }
        curr=head;
        while(curr!=null)
        {
            Node clone=res.get(curr);
            clone.next=res.get(curr.next);
            clone.random=res.get(curr.random);
            curr=curr.next;
        }
        return res.get(head);
        
    }
    
}