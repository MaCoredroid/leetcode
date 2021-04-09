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
        List<Integer> ans=new ArrayList<>();
        while(head!=null){
            ans.add(head.val);
            head=head.next;
        }
        int[] ret=new int[ans.size()];
        int pointer=ans.size()-1;
        for(int i=0;i<ret.length;i++){
            ret[i]=ans.get(pointer);
            pointer--;
        }
        return ret;
    }
}