class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        int ans=0;
        Arrays.fill(left,-1);
        Arrays.fill(right,heights.length);
        Stack<Integer> monostack=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!monostack.isEmpty()&&heights[monostack.peek()]>=heights[i]){
                right[monostack.pop()]=i;
            }
            if(!monostack.isEmpty()){
                left[i]=monostack.peek();
            }
            monostack.push(i);
        }
        for(int i=0;i<heights.length;i++){
            ans=Math.max(heights[i]*(right[i]-left[i]-1),ans);
        }
        return ans;

        
        
    }
}