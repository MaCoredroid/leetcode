/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        int count=0;
        ListNode p=head;
        while(p!=null)
        {
            count++;
            p=p.next;
        }
        int[] ret=new int[count];
        p=head;
        for(int i=ret.length-1;i>=0;i--)
        {
            ret[i]=p.val;
            p=p.next;
        }
        return ret;
    }
}