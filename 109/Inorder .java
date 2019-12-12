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
    private ListNode head;
    private int findSize(ListNode head)
    {
        ListNode ptr=head;
        int size=0;
        while(ptr!=null)
        {
            size++;
            ptr=ptr.next;
        }
        return size;
    }
    private TreeNode convertListToBST(int left,int right)
    {
        if(left>right)
        {
            return null;
        }
        int mid=(left+right)/2;
        TreeNode leftNode=convertListToBST(left,mid-1);
        TreeNode node= new TreeNode(head.val);
        node.left=leftNode;
        head=head.next;
        node.right=convertListToBST(mid+1,right);
        return node;
        
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size= this.findSize(head);
        this.head=head;
        return convertListToBST(0,size-1);
        
    }
}