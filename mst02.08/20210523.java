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
        ListNode fast=head;
        ListNode slow=head;
        do{
            if(fast==null||fast.next==null||slow==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }while(fast!=slow);
        ListNode curr=head;
        while(slow!=curr){
            slow=slow.next;
            curr=curr.next;
        }
        return curr;
    }
}