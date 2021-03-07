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
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode first=head;
        ListNode second=head.next;
        while(first!=null&&second!=null){
            if(first==second){
                return true;
            }
            first=first.next;
            if(second.next==null){
                break;
            }
            second=second.next.next;
        }
        return false;
    }
}