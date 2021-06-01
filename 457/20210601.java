class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                continue;
            }
            int slow=i;
            int fast=next(nums,i);
            while(nums[slow]*nums[fast]>0&&nums[slow]*nums[next(nums,slow)]>0&&nums[fast]*nums[next(nums,fast)]>0){
                if(slow==fast){
                    if(next(nums,slow)==slow){
                        break;
                    }else{
                        return true;
                    }
                }
                slow=next(nums,slow);
                fast=next(nums,next(nums,fast));
            }
            int idx=i;
            while(nums[idx]>0){
                int tmp=next(nums,idx);
                nums[idx]=0;
                idx=tmp;
            }
            idx=i;
            while(nums[idx]<0){
                int tmp=next(nums,idx);
                nums[idx]=0;
                idx=tmp;
            }
        }
        return false;
    }

    private int next(int[] nums,int i){
        int res=(i+nums[i])%nums.length;
        if(res<0){
            return res+nums.length;
        }
        return res;
    }
}