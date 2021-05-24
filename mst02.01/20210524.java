/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null){
            return head;
        }
        Set<Integer> set=new HashSet<>();
        ListNode pointer=head;
        ListNode pre=head;
        while(pointer!=null){
            ListNode next=pointer.next;
            if(set.contains(pointer.val)){
                pre.next=next;
                pointer=next;
            }else{
                set.add(pointer.val);
                pre=pointer;
                pointer=next;
            }
        }
        return head;
    }
}