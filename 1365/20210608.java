class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[][] data=new int[n][2];
        for(int i=0;i<nums.length;i++){
            data[i][0]=nums[i];
            data[i][1]=i;
        }
        Arrays.sort(data,(n1,n2)->(n1[0]-n2[0]));
        int prev=-1;
        int[] ret=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0||data[i][0]!=data[i-1][0]){
                prev=i;
            }
            ret[data[i][1]]=prev;
        }
        return ret;
    }
}