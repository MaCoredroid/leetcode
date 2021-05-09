class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int maxVal=Arrays.stream(nums).max().getAsInt();
        int minVal=Arrays.stream(nums).min().getAsInt();
        int d=Math.max(1,(maxVal-minVal)/(nums.length-1));
        int size=(maxVal-minVal)/d+1;
        int[][] buckets=new int[size][2];
        for(int i=0;i<buckets.length;i++){
            Arrays.fill(buckets[i],-1);
        }
        for(int i=0;i<nums.length;i++){
            int index=(nums[i]-minVal)/d;
            if(buckets[index][0]==-1){
                buckets[index][0]=buckets[index][1]=nums[i];
            }else{
                buckets[index][0]=Math.min(buckets[index][0],nums[i]);
                buckets[index][1]=Math.max(buckets[index][1],nums[i]);
            }
        }
        int max=0;
        int prev=0;
        for(int i=1;i<buckets.length;i++){
            if(buckets[i][0]==-1||buckets[prev][1]==-1){
                continue;
            }
            max=Math.max(max,buckets[i][0]-buckets[prev][1]);
            prev=i;
        }
        return max;
    }
}