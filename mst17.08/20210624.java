class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n=height.length;
        int[][] person=new int[n][2];
        for(int i=0;i<n;i++){
            person[i][0]=height[i];
            person[i][1]=weight[i];
        }
        Arrays.sort(person,(o1,o2)->(o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]));
        int[] dp=new int[n+1];
        int res=-1;
        for(int[] pair:person){
            if(res==-1||pair[1]>dp[res]){
                dp[++res]=pair[1];
                continue;
            }
            int i = search(dp, 0, res, pair[1]);
            dp[i]=pair[1];
        }
        return res+1;
    }

    private int search(int[] dp,int start,int end, int target){
        if(start==end){
            return start;
        }
        int left=start;
        int right=end;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(dp[mid]==target){
                return mid;
            }
            if(dp[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}