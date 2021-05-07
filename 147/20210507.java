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
        ListNode lastSort=head;
        ListNode curr=head.next;
        while(curr!=null){
            if(lastSort.val<=curr.val){
                lastSort=lastSort.next;
            }else{
                ListNode prev=dummy;
                while(prev.next.val<curr.val){
                    prev=prev.next;
                }
                lastSort.next=curr.next;
                curr.next=prev.next;
                prev.next=curr;
            }
            curr=lastSort.next;
        }
        return dummy.next;
    }
}