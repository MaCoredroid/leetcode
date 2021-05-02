class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                int height=heights[stack.pop()];
                int len= stack.isEmpty()?i:i-stack.peek()-1;
                ans=Math.max(ans,height*len);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()&&heights[stack.peek()]>=0){
            int height=heights[stack.pop()];
            int len= stack.isEmpty()?heights.length:heights.length-stack.peek()-1;
            ans=Math.max(ans,height*len);
        }
        return ans;

    }
}