class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m=matrix.length, n=matrix[0].length;
        int[][] pre=new int[m+1][n+1];
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                pre[i][j]=pre[i-1][j]^pre[i][j-1]^pre[i-1][j-1]^matrix[i-1][j-1];
                ans.add(pre[i][j]);
            }
        }
        Collections.sort(ans);
        return ans.get(ans.size()-k);
    }

    // private int helper(List<Integer> ans,int start,int end,int target){
    //     if(start>=end){
    //         return ans.get(start);
    //     }
    //     int left=start;
    //     int right=end;
    //     int pivot=ans.get(left);
    //     while(left<right){
    //         while(left<right&&ans.get(right)>=pivot){
    //             right--;
    //         }
    //         ans.set(left,ans.get(right));
    //         while(left<right&&ans.get(left)<=pivot){
    //             left++;
    //         }
    //         ans.set(right,ans.get(left));
    //     }
    //     ans.set(left,pivot);
    //     if(left==target){
    //         return pivot;
    //     }
    //     if(left<target){
    //         return helper(ans,left+1,end,target);
    //     }else{
    //         return helper(ans,start,left,target);
    //     }
    // }
}