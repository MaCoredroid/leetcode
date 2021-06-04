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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        dummy.next=list1;
        ListNode pointer=dummy;
        int count=0;
        while(count<a){
            pointer=pointer.next;
            count++;
        }
        ListNode pre=pointer;
        while(count<=b){
            pointer=pointer.next;
            count++;
        }
        ListNode next=pointer.next;
        pre.next=list2;
        ListNode p=list2;
        while(p.next!=null){
            p=p.next;
        }
        p.next=next;
        return dummy.next;
    }
}