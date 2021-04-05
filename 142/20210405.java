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
        ListNode pointer=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                pointer=fast;
                break;
            }
        }
        if(pointer==null){
            return null;
        }
        ListNode cur=head;
        
        while(cur!=pointer){
            cur=cur.next;
            pointer=pointer.next;
            
        }
        return cur;
    }
}