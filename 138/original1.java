import java.util.HashMap;

class Solution {
    HashMap<Node,Node> res=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return null;
        }
        if(res.containsKey(head))
        {
            return res.get(head);
        }
        Node clone =new Node(head.val);
        res.put(head,clone);
        clone.next=copyRandomList(head.next);
        clone.random=copyRandomList(head.random);
        return clone;

        
    }
    
}