class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int[] ans=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            
            int res=0;
            
            while(!s.isEmpty()&&s.peek()<heights[i]){
                s.pop();
                res++;
            }
            if(!s.isEmpty()) res++;
    
            ans[i]=res;
            s.push(heights[i]);
        }
        return ans;
    }
}