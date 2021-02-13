/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)
        {
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pointer=head;
        ListNode prev=dummy;
        while(pointer!=null)
        {
            ListNode first=pointer;
            for(int i=0;i<k;i++)
            {
                if(pointer!=null)
                {
                    pointer=pointer.next;
                }
                else
                {
                    return dummy.next;
                }
            }
            ListNode next=pointer;
            prev.next=reverse(first,k);
            first.next=next;
            prev=first;
        }
        return dummy.next;

    }

    public ListNode reverse(ListNode head,int k)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head.next;
        for(int i=0;i<k;i++)
        {
            curr.next=prev;
            prev=curr;
            curr=next;
            if(curr==null)
            {
                break;
            }
            next=curr.next;
        }
        return prev;


    }
}