/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(-1);
        ListNode oddPointer=odd;
        ListNode even=new ListNode(-1);
        ListNode evenPointer=even;
        while(head!=null){
            oddPointer.next=head;
            oddPointer=oddPointer.next;
            head=head.next;
            if(head==null){
                break;
            }
            evenPointer.next=head;
            evenPointer=evenPointer.next;
            head=head.next;
        }
        evenPointer.next=null;
        oddPointer.next=even.next;
        return odd.next;
    }
}