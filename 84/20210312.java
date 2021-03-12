class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        Arrays.fill(right, heights.length);
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                right[stack.peek()]=i;
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        int ret=0;
        for(int i=0;i<heights.length;i++){
            ret=Math.max(ret,(right[i]-left[i]-1)*heights[i]);
        }
        return ret;
        
    }
}