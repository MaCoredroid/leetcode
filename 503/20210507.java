class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ret=new int[nums.length];
        Arrays.fill(ret,-1);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length*2-1;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i%nums.length]){
                ret[stack.pop()]=nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return ret;
    }
}