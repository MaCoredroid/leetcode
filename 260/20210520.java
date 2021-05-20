class Solution {
    public int[] singleNumber(int[] nums) {
        int ret=0;
        for(int num:nums){
            ret^=num;
        }
        int div=1;
        while((ret&div)==0){
            div<<=1;
        }
        int ans1=0,ans2=0;
        for(int num:nums){
            if((num&div)==0){
                ans1^=num;
            }else{
                ans2^=num;
            }
        }
        return new int[]{ans1,ans2};

    }
}