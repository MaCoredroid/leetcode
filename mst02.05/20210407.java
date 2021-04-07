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
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        int overflow=0;
        while(l1!=null||l2!=null||overflow!=0){
            int val1=(l1==null?0:l1.val);
            int val2=(l2==null?0:l2.val);
            int ans=val1+val2+overflow;
            if(ans>=10){
                ans-=10;
                overflow=1;
            }else{
                overflow=0;
            }
            head.next=new ListNode(ans);
            head=head.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;

    }
}