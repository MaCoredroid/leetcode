/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode start= dummy;
        ListNode end=dummy;
        while(end!=null)
        {
            for(int i=0;i<2&&end!=null;i++)
            {
                end=end.next;
            }
            if(end==null)
            {
                break;
            }
            ListNode temp=end.next;
            end.next=start.next;
            start.next=end;
            end.next.next=temp;
            start=end.next;
            end=end.next;
        }
        return dummy.next;
    }
}