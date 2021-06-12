/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode curr=root;
        int N=0;
        while(curr!=null){
            N++;
            curr=curr.next;
        }
        int len=N/k;
        ListNode[] ans=new ListNode[k];
        ListNode dummy=root;
        int res=N%k;
        for(int i=0;i<k;i++){
            ans[i]=dummy;
            for(int j=0;j<len-1+(res>0?1:0);j++){
                dummy=dummy.next;
            }
            if(dummy!=null){
                ListNode next=dummy.next;
                dummy.next=null;
                dummy=next;
            }
            res--;
        }
        return ans;
    }
}