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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> s=new Stack<>();
        ListNode p=head;
        while(p!=null){
            s.push(p);
            p=p.next;
        }
        p=head;
        int size=s.size();
        while(s.size()>size/2){
            if(p.val!=s.pop().val) return false;
            p=p.next;
        }
        return true;
    }
}