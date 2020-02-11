/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(0);
        ListNode ret=ans;
        while(l1!=null||l2!=null)
        {
            if(l1==null)
            {
                ListNode temp=new ListNode(l2.val);
                ans.next=temp;
                ans=ans.next;
                l2=l2.next;
                continue;
            }
            if(l2==null)
            {
                ListNode temp=new ListNode(l1.val);
                ans.next=temp;
                ans=ans.next;
                l1=l1.next;
                continue;
            }
            if(l1.val<=l2.val)
            {
                ListNode temp=new ListNode(l1.val);
                ans.next=temp;
                ans=ans.next;
                l1=l1.next;
            }
            else
            {
                ListNode temp=new ListNode(l2.val);
                ans.next=temp;
                ans=ans.next;
                l2=l2.next;
            }
        }
        return ret.next;
    }
}