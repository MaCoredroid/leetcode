class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> mono_stack=new Stack<>();
        int[] ans=new int[T.length];
        for(int i=ans.length-1;i>=0;i--){
            
            while(!mono_stack.isEmpty()&&T[mono_stack.peek()]<=T[i]){
                mono_stack.pop();
            }
            if(mono_stack.isEmpty()){
                ans[i]=0;
            }else{
                ans[i]=mono_stack.peek()-i;
            }
            mono_stack.push(i);


            
        }
        return ans;
    }
}