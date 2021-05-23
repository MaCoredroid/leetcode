class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret=new ArrayList<>();
        if(nums.length==0){
            return ret;
        }
        int pre=nums[0];
        int cnt=1;
        StringBuilder sb=new StringBuilder();
        sb.append(pre);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==pre+1){
                pre++;
                cnt++;
            }else{
                if(cnt==1){
                    ret.add(sb.toString());
                    sb=new StringBuilder();
                    pre=nums[i];
                    cnt=1;
                    sb.append(pre);
                }else{
                    sb.append("->").append(pre);
                    ret.add(sb.toString());
                    sb=new StringBuilder();
                    pre=nums[i];
                    cnt=1;
                    sb.append(pre);
                }
            }
        }
        if(cnt==1){
            ret.add(sb.toString());
        }else{
            sb.append("->").append(pre);
            ret.add(sb.toString());
        }
        return ret;
    }
}