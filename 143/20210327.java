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
    public void reorderList(ListNode head) {
        ListNode curr=head;
        Stack<ListNode> stack=new Stack<>();
        int count=0;
        while(curr!=null){
            stack.push(new ListNode(curr.val,curr.next));
            curr=curr.next;
            count++;
        }
        curr=head;
        ListNode next=new ListNode(0);
        ListNode tail=new ListNode(0);
        for(int i=0;i<count/2;i++){
            next=curr.next;
            tail=stack.pop();
            curr.next=tail;
            tail.next=next;
            curr=next;
        }
        if(count%2==1){
            next.next=null;
        }else{
            tail.next=null;
        }        
    }
}