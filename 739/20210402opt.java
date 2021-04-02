class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> mono_stack=new Stack<>();
        int[] ans=new int[T.length];
        ans[ans.length-1]=0;
        for(int i=ans.length-2;i>=0;i--){
            int j=i+1;
            while(j<ans.length){
                if(T[j]>T[i]){
                    ans[i]=j-i;
                    break;
                }else if(ans[j]==0){
                    ans[i]=0;
                    break;
                }else{
                    j+=ans[j];
                }
            }
        }
        return ans;
    }
}