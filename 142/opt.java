/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
        {
            return null;
        }
        ListNode intersect=getCycle(head);
        if(intersect==null)
        {
            return null;
        }
        ListNode pre=head;
        while(pre!=intersect)
        {
            pre=pre.next;
            intersect=intersect.next;
        }
        return pre;
    }
    public ListNode getCycle(ListNode head)
    {
        ListNode slow =head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                return slow;
            }
        }
        return null;
    }
}