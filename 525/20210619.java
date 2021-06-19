class Solution {
    public int findMaxLength(int[] nums) {
        int[][] pre=new int[nums.length+1][2];
        for(int i=0;i<nums.length;i++){
            pre[i+1][0]=pre[i][0];
            pre[i+1][1]=pre[i][1];
            pre[i+1][nums[i]]++;
        }
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<pre.length;i++){
            if(map.containsKey(pre[i][1]-pre[i][0])){
                ans=Math.max(ans,i-map.get(pre[i][1]-pre[i][0]));
            }else{
                map.put(pre[i][1]-pre[i][0],i);
            }
        }
        return ans;
    }
}