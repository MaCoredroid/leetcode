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
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=head.next;
        ListNode last=head;
        while(curr!=null){
            if(last.val<=curr.val){
                last=last.next;
            }else{
                ListNode prev=dummy;
                while(prev.next.val<=curr.val){
                    prev=prev.next;
                }
                last.next=curr.next;
                curr.next=prev.next;
                prev.next=curr;
            }
            curr=last.next;
        }
        return dummy.next;


    }
}