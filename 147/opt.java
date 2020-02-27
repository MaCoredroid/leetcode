/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if((head==null)||(head.next==null))
        {
            return head;
        }
        ListNode dummyNode=new ListNode(Integer.MIN_VALUE);
        dummyNode.next=head;
        ListNode node=head.next;
        ListNode tail=head;
        while(node!=null)
        {
            if(node.val<tail.val)
            {
                ListNode cur=dummyNode;
                while(cur.next!=null&&cur.next.val<node.val)
                {
                    cur=cur.next;
                }
                tail.next=node.next;
                node.next=cur.next;
                cur.next=node;
                node=tail.next;
            }
            else
            {
                node=node.next;
                tail=tail.next;
            }
        }
        return dummyNode.next;
    }
}