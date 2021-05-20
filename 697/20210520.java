class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new int[]{1,i,i});
            }else{
                int[] prev=map.get(nums[i]);
                prev[0]++;
                prev[2]=i;
                map.put(nums[i],prev);
            }
        }
        int maxNum=0,ans=0;
        for(Map.Entry<Integer,int[]> entry:map.entrySet()){
            int[] res=entry.getValue();
            if(res[0]>maxNum){
                maxNum=res[0];
                ans=res[2]-res[1]+1;
            }else if(res[0]==maxNum){
                if(res[2]-res[1]+1<ans){
                    ans=res[2]-res[1]+1;
                }
            }
        }
        return ans;
    }
}