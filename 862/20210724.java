class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int[] prefix=new int[nums.length+1];
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int ans=nums.length+1;
        for(int i=0;i<prefix.length;i++){
            while(!queue.isEmpty()&&prefix[i]<=prefix[queue.peekLast()]){
                queue.pollLast();
            }
            while(!queue.isEmpty()&&prefix[i]-prefix[queue.peekFirst()]>=k){
                ans=Math.min(ans,i-queue.pollFirst());
            }
            queue.offerLast(i);
        }
        return ans==nums.length+1?-1:ans;
    }
}