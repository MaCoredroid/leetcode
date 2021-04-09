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
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        int[] ret=new int[count];
        for(int i=ret.length-1;i>=0;i--){
            ret[i]=head.val;
            head=head.next;
        }
        return ret;
    }
}