class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQue=new LinkedList<>();
        Deque<Integer> minQue=new LinkedList<>();
        int left=0,right=0;
        int ret=0;
        while(right<nums.length){
            while(!maxQue.isEmpty()&&maxQue.peekLast()<nums[right]){
                maxQue.pollLast();
            }
            while(!minQue.isEmpty()&&minQue.peekLast()>nums[right]){
                minQue.pollLast();
            }
            maxQue.offerLast(nums[right]);
            minQue.offerLast(nums[right]);
            while(!maxQue.isEmpty()&&!minQue.isEmpty()&&maxQue.peekFirst()-minQue.peekFirst()>limit){
                if(nums[left]==maxQue.peekFirst()){
                    maxQue.pollFirst();
                }
                if(nums[left]==minQue.peekFirst()){
                    minQue.pollFirst();
                }
                left++;
            }
            ret=Math.max(ret,right-left+1);
            right++;
        }
        return ret;
    }
}