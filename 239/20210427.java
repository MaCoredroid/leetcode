class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] pair1,int[] pair2){
                return pair1[0]==pair2[0]?pair2[1]-pair1[1]:pair2[0]-pair1[0];
            }
        });
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i],i});
        }
        int[] ans=new int[nums.length-k+1];
        ans[0]=pq.peek()[0];
        for(int i=k;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
            while(!pq.isEmpty()&&pq.peek()[1]<=i-k){
                pq.poll();
            }
            ans[i-k+1]=pq.peek()[0];
        }
        return ans;
    }
}