class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] record=new int[n][3];
        for(int i=0;i<n;i++){
            record[i][0]=startTime[i];
            record[i][1]=endTime[i];
            record[i][2]=profit[i];
        }
        Arrays.sort(record,(o1,o2)->(o1[1]-o2[1]));
        int[] dp=new int[n];
        dp[0]=record[0][2];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i],dp[i-1]);
            dp[i]=Math.max(dp[i],record[i][2]);
            int left=0;
            int right=i-1;
            while(left<=right){
                int mid=left+((right-left)>>1);
                if(record[i][0]>=record[mid][1]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            if(left-1>=0){
                dp[i]=Math.max(dp[i],dp[left-1]+record[i][2]);
            }
            // for(int j=i-1;j>=0;j--){
            //     if(record[i][0]>=record[j][1]){
            //         dp[i]=Math.max(dp[i],dp[j]+record[i][2]);
            //         break;
            //     }else{
            //         dp[i]=Math.max(dp[i],record[i][2]);
            //     }
            // }
        }
        return dp[n-1];
    }
}