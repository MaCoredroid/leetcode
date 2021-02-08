class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            int first=nums[i];
            int left=i+1;
            int right=n-1;
            while(left<right)
            {
                if(first+nums[left]+nums[right]==0)
                {
                    ans.add(Arrays.asList(first,nums[left],nums[right]));
                    while(left+1<n&&nums[left+1]==nums[left])
                    {
                        left++;
                    }
                    left++;
                }
                else if(first+nums[left]+nums[right]>0)
                {
                    right--;
                }
                else if(first+nums[left]+nums[right]<0)
                {
                    left++;
                }
            }
            while(i+1<n&&nums[i+1]==nums[i])
            {
                i++;
            }

        }
        return ans;
    }
}