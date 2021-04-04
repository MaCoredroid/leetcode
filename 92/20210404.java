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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count=0;
        ListNode dummy=new ListNode(-1,head);
        ListNode pointer=dummy;
        ListNode leftPrev=null;
        ListNode rightNode=null;
        while(pointer!=null){
            if(count==left-1){
                leftPrev=pointer;
            }else if(count==right){
                rightNode=pointer;
            }
            count++;
            pointer=pointer.next;
        }
        ListNode leftNode=leftPrev.next;
        ListNode rightNext=rightNode.next;
        rightNode.next=null;
        leftPrev.next=reverse(leftNode);
        leftNode.next=rightNext;
        return dummy.next;


    }

    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}