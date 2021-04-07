class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue=new LinkedList<Integer>();
        int[] ans=new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while(!queue.isEmpty()&queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            if(i-k+1>=0){
                ans[i-k+1]=nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}