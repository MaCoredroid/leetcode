/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    List<ListNode> res=new ArrayList<>();
    public ListNode[] listOfDepth(TreeNode tree) {
        helper(tree,0);
        ListNode[] ret=new ListNode[res.size()];
        for(int i=0;i<ret.length;i++){
            ret[i]=res.get(i);
        }
        return ret;
    }

    private void helper(TreeNode tree, int level){
        if(tree==null){
            return;
        }
        if(res.size()==level){
            res.add(new ListNode(tree.val));
        }else{
            ListNode temp=res.get(level);
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new ListNode(tree.val);
        }
        helper(tree.left,level+1);
        helper(tree.right,level+1);
    }
}