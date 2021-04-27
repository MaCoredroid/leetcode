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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller=new ListNode(-1);
        ListNode small=smaller;
        ListNode bigger=new ListNode(-1);
        ListNode big=bigger;
        while(head!=null){
            if(head.val<x){
                small.next=head;
                small=small.next;
            }else{
                big.next=head;
                big=big.next;
            }
            head=head.next;
        }
        small.next=bigger.next;
        big.next=null;
        return smaller.next;
    }
}