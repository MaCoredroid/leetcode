class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return new int[0];
        }
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        int[] ans=new int[nums.length-k+1];
        ans[0]=nums[queue.peekFirst()];
        for(int i=k;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while(!queue.isEmpty()&&queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            ans[i-k+1]=nums[queue.peekFirst()];
        }
        return ans;
    }
}