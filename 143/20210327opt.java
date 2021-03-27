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
    public void reorderList(ListNode head) {
        ListNode mid=findMedian(head);
        ListNode next=mid.next;
        mid.next=null;
        ListNode reverse=reverse(next);
        merge(head,reverse);
    }

    private ListNode findMedian(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
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

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(l1!=null||l2!=null){
            curr.next=l1;
            l1=l1.next;
            curr=curr.next;
            if(l2!=null){
                curr.next=l2;
                l2=l2.next;
                curr=curr.next;
            }
        }
        return dummy.next;
    }
}