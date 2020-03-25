/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode pointer=dummy;
        while(l1!=null&&l2!=null)
        {
            int ans=l1.val+l2.val+carry;
            if(ans>=10)
            {
                ans-=10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            pointer.next=new ListNode(ans);
            pointer=pointer.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null)
        {
            int ans=l1.val+carry;
            if(ans>=10)
            {
                ans-=10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            pointer.next=new ListNode(ans);
            pointer=pointer.next;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int ans=l2.val+carry;
            if(ans>=10)
            {
                ans-=10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            pointer.next=new ListNode(ans);
            pointer=pointer.next;
            l2=l2.next;
        }
        if(carry!=0)
        {
            pointer.next=new ListNode(1);
            pointer=pointer.next;
        }
        return dummy.next;
    }
}