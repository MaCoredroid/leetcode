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
        int length=0;
        ListNode pointer=head;
        while(pointer!=null){
            pointer=pointer.next;
            length++;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        for(int step=1;step<length;step*=2){
            ListNode prev=dummy;
            ListNode curr=dummy.next;
            while(curr!=null){
                ListNode head1=curr;
                for(int i=1;i<step&&curr.next!=null;i++){
                    curr=curr.next;
                }
                ListNode head2=curr.next;
                curr.next=null;
                curr=head2;
                for(int i=1;i<step&&curr!=null&&curr.next!=null;i++){
                    curr=curr.next;
                }
                ListNode next=null;
                if(curr!=null){
                    next=curr.next;
                    curr.next=null;
                }
                prev.next=merge(head1,head2);
                while(prev.next!=null){
                    prev=prev.next;
                }
                curr=next;

            }

        }
        return dummy.next;
    }

    

    private ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(-1);
        ListNode pointer=dummy;
        while(head1!=null&&head2!=null){
            int val1=head1.val;
            int val2=head2.val;
            if(val1<val2){
                pointer.next=head1;
                head1=head1.next;
            }else{
                pointer.next=head2;
                head2=head2.next;
            }
            pointer=pointer.next;
        }
        if(head1!=null){
            pointer.next=head1;
        }
        if(head2!=null){
            pointer.next=head2;
        }
        return dummy.next;
    }

    
}