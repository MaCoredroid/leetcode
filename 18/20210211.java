class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++)
        {
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)
            {
                break;
            }
            if(nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target)
            {
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)
                {
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1]<target)
                {
                    continue;
                }
                int start=j+1;
                int end=nums.length-1;
                while(start<end)
                {
                    if(nums[i]+nums[j]+nums[start]+nums[end]==target)
                    {
                        List<Integer> ans=new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[start]);
                        ans.add(nums[end]);
                        ret.add(ans);
                        while(start<end&&nums[start]==nums[start+1])
                        {
                            start++;
                        }
                        while(start<end&&nums[end]==nums[end-1])
                        {
                            end--;
                        }
                    }
                    if(nums[i]+nums[j]+nums[start]+nums[end]>target)
                    {
                        end--;
                    }
                    else
                    {
                        start++;
                    }
                }
                while(j+1<nums.length-2&&nums[j+1]==nums[j])
                {
                    j++;
                }
            }
            while(i+1<nums.length-3&&nums[i+1]==nums[i])
            {
                i++;
            }
        }
        return ret;
    }
}