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
    private List<Integer> values;
    public Solution()
    {
        this.values = new ArrayList<Integer>();
    }
    public void mapListToValues(ListNode head)
    {
        while(head!=null)
        {
            this.values.add(head.val);
            head=head.next;
        }
    }
    private TreeNode convertListToBST(int left,int right)
    {
        if(left>right)
        {
            return null;
        }
        int mid = (left+right)/2;
        TreeNode node =new TreeNode(this.values.get(mid));
        if(left==right)
        {
            return node;
        }
        node.left=convertListToBST(left,mid-1);
        node.right = convertListToBST(mid+1,right);
        return node;
        
    }
    public TreeNode sortedListToBST(ListNode head) {
        mapListToValues(head);
        return convertListToBST(0,this.values.size()-1);
        
    }
}