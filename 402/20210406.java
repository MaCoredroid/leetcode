class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque=new LinkedList<Character>();
        for(int i=0;i<num.length();i++){
            char temp=num.charAt(i);
            while(!deque.isEmpty()&&k>0&&temp<deque.peekLast()){
                deque.pollLast();
                k--;
            }
            deque.offerLast(temp);
        }
        for(int i=0;i<k;i++){
            deque.pollLast();
        }
        StringBuilder sb=new StringBuilder();
        while(!deque.isEmpty()&&deque.peekFirst()=='0'){
            deque.pollFirst();
        }
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.length()==0?"0":sb.toString();

    }
}