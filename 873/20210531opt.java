class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        int ans=0;
        for(int i=2;i<n;i++){
            int target=arr[i];
            int left=0;
            int right=i-1;
            while(left<right){
                if(arr[left]+arr[right]>target){
                    right--;
                }else if(arr[left]+arr[right]<target){
                    left++;
                }else{
                    dp[right][i]=dp[left][right]+1;
                    ans=Math.max(dp[right][i],ans);
                    left++;
                }
            }
        }
        return ans>0?ans+2:0;
    }
}