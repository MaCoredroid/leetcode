class Solution {
    public int[] missingTwo(int[] nums) {
        int N=nums.length+2;
        int ans=0;
        for(int i=1;i<=N;i++){
            ans^=i;
        }
        for(int num:nums){
            ans^=num;
        }
       
        int flag = ans & -ans;
        int num1=0;
        for(int i=1;i<=N;i++){
            if((i&flag)!=0){
                num1^=i;
            }
        }
        for(int num:nums){
            if((num&flag)!=0){
                num1^=num;
            }
        }
        return new int[]{num1,num1^ans};
    }
}