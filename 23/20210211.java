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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);

    }

    public ListNode merge(ListNode[] lists, int left, int right){
        if(left==right)
        {
            return lists[left];
        }
        if(left>right)
        {
            return null;
        }
        int mid=(left+right)/2;
        return mergeTwoLists(merge(lists,left,mid),merge(lists,mid+1,right));

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode pointer=dummy;
        while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                pointer.next=l1;
                l1=l1.next;
                pointer=pointer.next;
            }
            else
            {
                pointer.next=l2;
                l2=l2.next;
                pointer=pointer.next;
            }
        }
        if(l1!=null)
        {
            pointer.next=l1;
        }
        if(l2!=null)
        {
            pointer.next=l2;
        }
        return dummy.next;
    }
}