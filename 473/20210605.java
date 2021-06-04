class Solution {
    HashMap<Pair<Integer,Integer>,Boolean> map=new HashMap<>();
    int[] nums;
    int L=0;
    int target=0;
    private boolean helper(Integer mask,Integer sides){
        boolean ans=false;
        Pair<Integer, Integer> memoKey = new Pair(mask, sides);
        if(map.containsKey(memoKey)){
            return map.get(memoKey);
        }
        int total=0;
        for(int i=L-1;i>=0;i--){
            if((mask&(1<<i))==0){
                total+=nums[L-1-i];
            }
        }
        if(total>0&&total%target==0){
            sides++;
        }
        if(sides==3){
            return true;
        }
        int remain=target*(total/target+1)-total;
        for(int i=L-1;i>=0;i--){
            if(nums[L-1-i]<=remain&&(mask&(1<<i))>0){
                if(helper(mask^(1<<i),sides)){
                    ans=true;
                    break;
                }
            }
        }
        map.put(memoKey,ans);
        return ans;

    }
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length==0){
            return false;
        }
        this.nums=matchsticks;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        this.target=sum/4;
        if(target*4!=sum){
            return false;
        }
        this.L=nums.length;
        return helper((1<<L)-1,0);
    }
}