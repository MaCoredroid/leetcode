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
        int overflow=0;
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        Stack<Integer> stack3=new Stack<>();
        ListNode curr=null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||overflow!=0){
            int num1=stack1.isEmpty()?0:stack1.pop();
            int num2=stack2.isEmpty()?0:stack2.pop();
            int ans=num1+num2+overflow;
            if(ans>=10){
                ans-=10;
                overflow=1;
            }else{
                overflow=0;
            }
            ListNode tmp=new ListNode(ans);
            tmp.next=curr;
            curr=tmp;
        }
        return curr;
    }
}