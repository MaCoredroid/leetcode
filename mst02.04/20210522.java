/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(-1);
        ListNode large=new ListNode(-1);
        ListNode p1=small;
        ListNode p2=large;
        ListNode p=head;
        while(p!=null){
            if(p.val<x){
                p1.next=p;
                p=p.next;
                p1=p1.next;
            }else{
                p2.next=p;
                p=p.next;
                p2=p2.next;
            }
        }
        p2.next=null;
        p1.next=large.next;
        return small.next;
    }
}