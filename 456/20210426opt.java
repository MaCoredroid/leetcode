class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        Deque<Integer> mono_queue=new LinkedList<>();
        int rightMax=Integer.MIN_VALUE;
        mono_queue.push(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<rightMax){
                return true;
            }
            while(!mono_queue.isEmpty()&&mono_queue.peek()<nums[i]){
                rightMax=mono_queue.pop();
            }
            mono_queue.push(nums[i]);
        }
        return false;
    }
}