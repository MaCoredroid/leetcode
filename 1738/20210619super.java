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
        return partition(ans,0,ans.length-1,ans.length-k);
        // return ans[ans.length-k];
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[k];
        }
        int left = start;
        int right = end;
        int mid = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < mid) {
                left++;
            }
            while (left <= right && nums[right] > mid) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        if (k <= right) {
            return partition(nums, start, right, k);
        } else {
            return partition(nums, left, end, k);
        }
    }
}