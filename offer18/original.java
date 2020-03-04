/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        while(head!=null)
        {
            if(head.val==val)
            {
                pre.next=head.next;
                break;
            }
            pre=head;
            head=head.next;
        }
        return dummy.next;
    }
}