class Solution {
    public long maxPoints(int[][] points) {
        int m=points.length,n=points[0].length;
        long[] pre=new long[n];
        for(int i=0;i<n;i++){
            pre[i]=points[0][i];
        }
        for(int j=1;j<m;j++){
            long[] left=new long[n];
            left[0]=pre[0];
            for(int i=1;i<n;i++){
                left[i]=Math.max(left[i-1]-1,pre[i]);
            }
            long[] right=new long[n];
            right[n-1]=pre[n-1];
            for(int i=n-2;i>=0;i--){
                right[i]=Math.max(right[i+1]-1,pre[i]);
            }
            for(int i=0;i<n;i++){
                pre[i]=points[j][i]+Math.max(left[i],right[i]);
            }
        }
        long ret=0;
        for(int i=0;i<n;i++){
            ret=Math.max(ret,pre[i]);
        }
        return ret;
    }
}