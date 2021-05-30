class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N=nums.length;
        int[] length=new int[N];
        int[] count=new int[N];
        Arrays.fill(count,1);
        for(int j=0;j<N;j++){
            for(int i=0;i<j;i++){
                if(nums[i]<nums[j]){
                    if(length[i]>=length[j]){
                        length[j]=length[i]+1;
                        count[j]=count[i];
                    }else if(length[i]+1==length[j]){
                        count[j]+=count[i];
                    }
                }
            }
        }
        int longest=0,ans=0;
        for(int i=0;i<N;i++){
            longest=Math.max(longest,length[i]);
        }
        for(int i=0;i<N;i++){
            if(length[i]==longest){
                ans+=count[i];
            }
        }
        return ans;
        
    }
}