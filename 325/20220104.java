class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n=nums.length;
        int[] pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int i=0;i<pre.length;i++){
            if(map.containsKey(pre[i]-k)){
                int index=map.get(pre[i]-k);
                cnt=Math.max(cnt,i-index);
            }
            if(!map.containsKey(pre[i])){
                map.put(pre[i],i);
            }
        }
        return cnt;
    }
}