/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(temp);
        ListNode dummy=new ListNode(-1);
        ListNode res=dummy;
        while(left!=null&&right!=null)
        {
            if(left.val<right.val)
            {
                res.next=left;
                left=left.next;
            }
            else
            {
                res.next=right;
                right=right.next;
            }
            res=res.next;
        }
        res.next=left==null?right:left;
        return dummy.next;
    }
}