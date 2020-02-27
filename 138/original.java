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
    HashMap<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        return dfs(head);
    }
    public Node dfs(Node head)
    {
        if(head==null)
        {
            return head;
        }
        if(map.containsKey(head))
        {
            return map.get(head);
        }
        Node clone=new Node(head.val);
        map.put(head,clone);
        clone.next=dfs(head.next);
        clone.random=dfs(head.random);
        return clone;
    }
}