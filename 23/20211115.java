/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        while(true){
            ListNode cur=null;
            boolean flag=false;
            int mark=-1;
            for(int i=0;i<lists.length;i++){
                ListNode l=lists[i];
                if(l==null){
                    continue;
                }
                if(cur==null||l.val<cur.val){
                    cur=l;
                    mark=i;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
            lists[mark]=lists[mark].next;
            prev.next=cur;
            prev=prev.next;
        }
        return dummy.next;
    }
}