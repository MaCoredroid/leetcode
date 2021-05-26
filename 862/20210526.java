class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] res=new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            res[i+1]=res[i]+(long)nums[i];
        }
        Deque<Integer> queue=new LinkedList<>();
        int ans=nums.length+1;
        for(int i=0;i<res.length;i++){
            while(!queue.isEmpty()&&res[queue.getLast()]>=res[i]){
                queue.removeLast();
            }
            while(!queue.isEmpty()&&res[queue.getFirst()]+k<=res[i]){
                ans=Math.min(ans,i-queue.removeFirst());
            }
            queue.addLast(i);
        }
        return ans<=nums.length?ans:-1;
    }
}