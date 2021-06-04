class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=0;
        Stack<Integer> stack=new Stack<>();
        for(int push:pushed){
            stack.push(push);
            while(j<popped.length&&!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return j==popped.length;
    }
}