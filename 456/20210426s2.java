class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        List<Integer> candidatesI=new ArrayList<>();
        List<Integer> candidatesJ=new ArrayList<>();
        candidatesI.add(nums[0]);
        candidatesJ.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            int indexI=findLast(candidatesI,nums[i]);
            int indexJ=findFirst(candidatesJ,nums[i]);
            if(indexI>=0&&indexJ>=0&&indexI>=indexJ){
                return true;
            }
            if(candidatesJ.get(candidatesJ.size()-1)>nums[i]){
                candidatesI.add(nums[i]);
                candidatesJ.add(nums[i]);
            }else if(candidatesI.get(candidatesI.size()-1)<nums[i]){
                int lastJ=candidatesJ.get(candidatesJ.size()-1);
                while(candidatesI.size()>0&&candidatesI.get(candidatesI.size()-1)<nums[i]){
                    candidatesI.remove(candidatesI.size()-1);
                    candidatesJ.remove(candidatesJ.size()-1);
                }
                candidatesI.add(nums[i]);
                candidatesJ.add(lastJ);
            }
        }
        return false;
    }

    private int findLast(List<Integer> candidates,int target){
        int left=0;
        int right=candidates.size()-1;
        while(left<=right){
            int middle=(left+right)/2;
            if(candidates.get(middle)>target){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return left-1;
    }

    private int findFirst(List<Integer> candidates,int target){
        int left=0;
        int right=candidates.size()-1;
        while(left<=right){
            int middle=(left+right)/2;
            if(candidates.get(middle)>=target){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return left;
    }
}