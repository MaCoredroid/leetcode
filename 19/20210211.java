class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode second=dummy;
        for(int i=0;i<n;i++)
        {
            head=head.next;
        }
        while(head!=null)
        {
            head=head.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;
    }
}