/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pointer=dummy;
        int i=1;
        for(;i<m;i++)
        {
            pointer=pointer.next;
        }
        ListNode nextHeader=pointer.next;
        ListNode next=null;
        ListNode pre=null;
        for(;i<=n;i++)
        {
            next=nextHeader.next;
            nextHeader.next=pre;
            pre=nextHeader;
            nextHeader=next;
        }
        pointer.next.next=next;
        pointer.next=pre;
        return dummy.next;
        

    }
    
}