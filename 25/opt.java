/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ret = new ListNode(0);
        ret.next = head;

        ListNode pre = ret;
        ListNode end = ret;
        while(end.next!=null)
        {
            for(int i=0;i<k&&end!=null;i++)
            {
                end=end.next;
            }
            if(end==null)
            {
                break;
            }
            ListNode start=pre.next;
            ListNode next=end.next;
            end.next=null;
            pre.next=reverse(start);
            start.next=next;
            pre=start;
            end=start;
        }
        




        return ret.next;


    }

    private ListNode reverse(ListNode head) {
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}