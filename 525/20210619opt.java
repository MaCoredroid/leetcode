class Solution {
    public int findMaxLength(int[] nums) {
        int a=0;
        int b=0;
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(b-a,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                a++;
            }else{
                b++;
            }
            if(map.containsKey(b-a)){
                ans=Math.max(ans,i-map.get(b-a));
            }else{
                map.put(b-a,i);
            }
        }
        return ans;
    }
}