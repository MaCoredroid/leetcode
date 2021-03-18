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
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        ListNode dummy=new ListNode(-1,head);
        for(int i=1;i<count;i*=2){
            ListNode pre=dummy;
            ListNode curr=dummy.next;
            while(curr!=null){
                ListNode head1=curr;
                for(int j=1;j<i&&curr.next!=null;j++){
                    curr=curr.next;
                }
                ListNode head2=curr.next;
                curr.next=null;
                curr=head2;
                for(int j=1;j<i&&curr!=null&&curr.next!=null;j++){
                    curr=curr.next;
                }
                ListNode next=null;
                if(curr!=null){
                    next=curr.next;
                    curr.next=null;
                }
                pre.next=merge(head1,head2);
                while(pre.next!=null){
                    pre=pre.next;
                }
                curr=next;
            }
            
        }
        return dummy.next;

    }

    private ListNode merge(ListNode node1,ListNode node2){
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(node1!=null||node2!=null){
            int val1=node1!=null?node1.val:Integer.MAX_VALUE;
            int val2=node2!=null?node2.val:Integer.MAX_VALUE;
            if(val1<=val2){
                dummy.next=node1;
                dummy=dummy.next;
                node1=node1.next;
            }else{
                dummy.next=node2;
                dummy=dummy.next;
                node2=node2.next;
            }
        }
        return head.next;
    }
}