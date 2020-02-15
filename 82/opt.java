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
        if(head==null)
        {
            return null;
        }
        ListNode virtual=new ListNode(-1);
        virtual.next=head;
        ListNode pointer=virtual;
        while(pointer.next!=null)
        {
            int value=pointer.next.val;
            if(pointer.next.next!=null&&pointer.next.next.val==value)
            {
                ListNode temp=pointer.next.next;
                while(temp!=null&&temp.val==value)
                {
                    temp=temp.next;
                }
                pointer.next=temp;
            }
            else
            {
                pointer=pointer.next;
            }
        }
        return virtual.next;
    }
}