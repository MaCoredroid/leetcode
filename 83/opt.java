/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pointer=head;
        while(pointer!=null)
        {
            int pre_value=pointer.val;
            if(pointer.next!=null&&pointer.next.val==pre_value)
            {
                ListNode temp=pointer.next;
                while(temp.next!=null&&temp.next.val==pre_value)
                {
                    temp=temp.next;
                }
                pointer.next=temp.next;
            }
            else
            {
                pointer=pointer.next;
            }
        }
        return dummy.next;

    }
}