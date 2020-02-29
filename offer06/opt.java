import java.util.Stack;

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
        Stack<Integer> stack=new Stack<>();
        while(head!=null)
        {
            stack.push(head.val);
            head=head.next;
        }
        int[] ret=new int[stack.size()];
        for(int i=0;i<ret.length;i++)
        {
            ret[i]=stack.pop();
        }
        return ret;
    }
}