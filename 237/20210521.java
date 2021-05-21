/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node==null){
            return;
        }
        ListNode next=node.next;
        if(next==null){
            node=null;
            return;
        }else{
            node.val=next.val;
            node.next=next.next;
        }
    }
}