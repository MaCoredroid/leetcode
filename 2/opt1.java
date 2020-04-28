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
        while(l1!=null||l2!=null||carry!=0)
        {
            int num1=(l1==null)?0:l1.val;
            int num2=(l2==null)?0:l2.val;
            int sum=num1+num2+carry;
            if(sum>=10)
            {
                sum-=10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            pointer.next=new ListNode(sum);
            pointer=pointer.next;
            if(l1!=null)
            {
                l1=l1.next;
            }
            if(l2!=null)
            {
                l2=l2.next;
            }

        }
        return dummy.next;
    }
}