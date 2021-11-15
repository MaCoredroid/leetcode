/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node ret=new Node(insertVal);
            ret.next=ret;
            return ret;
        }
        Node record=head;
        while(record!=null){
            if(record.next==head||(insertVal>=record.val&&insertVal<=record.next.val)||(record.val>record.next.val&&insertVal<=record.next.val)||(record.val>record.next.val&&insertVal>=record.val)){
                Node next=record.next;
                record.next=new Node(insertVal);
                record.next.next=next;
                break;
            }
            record=record.next;
        }
        return head;
        
    }
}