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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int overflow=0;
        while(l1!=null||l2!=null||overflow!=0){
            int nums1=l1==null?0:l1.val;
            int nums2=l2==null?0:l2.val;
            int target=nums1+nums2+overflow;
            if(target>=10){
                overflow=1;
                target-=10;
            }else{
                overflow=0;
            }
            curr.next=new ListNode(target);
            curr=curr.next;
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