class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue=new LinkedList<>();
        int[] ans=new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        ans[0]=nums[queue.peekFirst()];
        for(int i=k;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
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