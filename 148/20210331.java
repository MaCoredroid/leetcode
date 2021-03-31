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
    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }

    private ListNode sort(ListNode head,ListNode tail){
        if(head==null){
            return null;
        }
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=tail){
            fast=fast.next;
            slow=slow.next;
            if(fast!=tail){
                fast=fast.next;
            }
        }
        ListNode mid=slow;
        ListNode sorted1=sort(head,mid);
        ListNode sorted2=sort(mid,tail);
        return merge(sorted1,sorted2);
    }

    private ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(-1);
        ListNode pointer=dummy;
        while(head1!=null&&head2!=null){
            int val1=head1.val;
            int val2=head2.val;
            if(val1<val2){
                pointer.next=head1;
                head1=head1.next;
            }else{
                pointer.next=head2;
                head2=head2.next;
            }
            pointer=pointer.next;
        }
        if(head1!=null){
            pointer.next=head1;
        }
        if(head2!=null){
            pointer.next=head2;
        }
        return dummy.next;
    }

    
}