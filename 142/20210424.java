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
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                break;
            }
        }
        if(fast!=slow||fast==null||fast.next==null){
            return null;
        }
        ListNode pointer=head;
        while(pointer!=slow){
            pointer=pointer.next;
            slow=slow.next;
        }
        return pointer;
    }
}