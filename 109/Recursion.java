/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode findMiddleElement(ListNode head) {
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr!=null&&fastPtr.next !=null)
        {
            prevPtr=slowPtr;
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        if(prevPtr!=null)//in case there is only one node in the list
        {
            prevPtr.next=null;
        }
        return slowPtr;// it is the mid node in the linked list
  }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)//it is an empty linked list
        {
            return null;
        }
        ListNode mid = findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if(mid==head)//there is only one node
        {
            return node;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }
}