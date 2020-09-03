/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    var num1, num2, overflow int
    var ret = &ListNode{0,nil}
    var dummy = ret
    for l1!=nil || l2!=nil {
        if l1!=nil {
            num1=l1.Val
            l1=l1.Next
        }else{
            num1=0
        }
        if l2!=nil {
            num2=l2.Val
            l2=l2.Next
        }else{
            num2=0
        }
        if num1+num2+overflow>=10{
            ret.Next= &ListNode{num1+num2+overflow-10,nil}
            ret=ret.Next
            overflow=1
        }else{
            ret.Next= &ListNode{num1+num2+overflow,nil}
            ret=ret.Next
            overflow=0
        }

    }
    if overflow==1{
        ret.Next= &ListNode{1,nil}
        return dummy.Next
    }else{
        return dummy.Next
    }
}