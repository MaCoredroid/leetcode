class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int[] sum=new int[n];
            for(int j=i;j<m;j++){
                for(int c=0;c<n;c++){
                    sum[c]+=matrix[j][c];
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for(int v:sum){
                    s+=v;
                    Integer ceil=sumSet.ceiling(s-k);
                    if(ceil!=null){
                        ans=Math.max(ans,s-ceil);
                    }
                    sumSet.add(s);
                }
            }

        }
        return ans;
    }
}