/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            if(curr.child!=null){
                curr.next=flatten(curr.child);
                curr.child.prev=curr;
                curr.child=null;
                Node temp=curr;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=next;
                if(next!=null){
                    next.prev=temp;
                }
            }
            curr=next;
        }
        return head;
    }
}