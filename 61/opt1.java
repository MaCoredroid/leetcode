/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            return head;
        }
        ListNode old_tail=head;
        int n=1;
        while(old_tail.next!=null)
        {
            old_tail=old_tail.next;
            n++;
        }
        old_tail.next=head;
        ListNode new_tail=head;
        int end=n-k%n-1;
        for(int i=0;i<end;i++)
        {
            new_tail=new_tail.next;
        }
        ListNode newhead=new_tail.next;
        new_tail.next=null;
        return newhead;
    }
}