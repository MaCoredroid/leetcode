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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode groupHead=head;
        ListNode curr=head;
        int count=k;
        while(curr!=null){
            count--;
            if(count==0){
                ListNode next=curr.next;
                curr.next=null;
                prev.next=reverseNode(groupHead);
                groupHead.next=next;
                prev=groupHead;
                groupHead=next;
                curr=next;
                count=k;
            }else{
                curr=curr.next;
            }
        }
        return dummy.next;

    }

    private ListNode reverseNode(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}