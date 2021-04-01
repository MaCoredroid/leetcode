class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i+3<nums.length;i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target){
                continue;
            }
            for(int j=i+1;j+2<nums.length;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1]<target){
                    continue;
                }
                int start=j+1;
                int end=nums.length-1;
                while(start<end){
                    if(nums[i]+nums[j]+nums[start]+nums[end]==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        while(start<end&&nums[start]==nums[start+1]){
                            start++;
                        }
                        while(start<end&&nums[end]==nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    }else if(nums[i]+nums[j]+nums[start]+nums[end]>target){
                        end--;
                    }else{
                        start++;
                    }
                }
                while(j+2<nums.length&&nums[j+1]==nums[j]){
                    j++;
                }
            }
            while(i+3<nums.length&&nums[i+1]==nums[i]){
                i++;
            }

        }
        return ans;
    }
}