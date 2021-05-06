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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode curr=dummy;
        while(curr!=null){
            if(curr.val==val){
                ListNode next=curr.next;
                pre.next= next;
                curr=next;
            }else{
                ListNode next=curr.next;
                pre=curr;
                curr=next;
            }
        }
        return dummy.next;
    }
}