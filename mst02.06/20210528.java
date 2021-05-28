/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode pointer;
    public boolean isPalindrome(ListNode head) {
        pointer=head;
        return reverse(head);
    }

    
    private boolean reverse(ListNode head){
        if(head!=null){ 
            if(!reverse(head.next)){
                return false;
            }
            if(head.val!=pointer.val){
                return false;
            }
            pointer=pointer.next;
        }
        return true;
    }
}