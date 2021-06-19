class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m=matrix.length, n=matrix[0].length;
        int[][] pre=new int[m+1][n+1];
        int[] ans=new int[m*n];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                pre[i][j]=pre[i-1][j]^pre[i][j-1]^pre[i-1][j-1]^matrix[i-1][j-1];
                ans[(i-1)*n+j-1]=pre[i][j];
            }
        }
        helper(ans,0,ans.length-1,ans.length-k);
        return ans[ans.length-k];
    }

    private void helper(int[] ans,int start,int end,int target){
        if(start>=end){
            return;
        }
        int left=start;
        int right=end;
        int pivot= (int) (left + Math.random() * (right - left + 1));
        int temp=ans[left];
        ans[left]=ans[pivot];
        ans[pivot]=temp;
        pivot=ans[left];
        while(left<right){
            while(left<right&&ans[right]>=pivot){
                right--;
            }
            ans[left]=ans[right];
            while(left<right&&ans[left]<=pivot){
                left++;
            }
            ans[right]=ans[left];
        }
        ans[left]=pivot;
        if(left==target){
            return;
        }
        if(left<target){
            helper(ans,left+1,end,target);
        }else{
            helper(ans,start,left,target);
        }
    }
}