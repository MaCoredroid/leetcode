class Solution {
    public int splitArray(int[] nums, int m) {
        int left=0,right=0;
        for(int num:nums){
            left=Math.max(left,num);
            right+=num;
        }
        while(left<=right){
            int middle=left+((right-left)>>1);
            if(check(nums,m,middle)){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return left;
    }

    private boolean check(int[] nums,int m,int val){
        int cnt=1;  
        int temp=0;
        for(int num:nums){
            if(temp+num>val){
                cnt++;
                temp=num;
            }else{
                temp+=num;
            }
            if(cnt>m){
                return false;
            }
        }
        return cnt<=m;
    }
}