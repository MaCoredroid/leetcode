class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans=new int[4];
        int M=matrix.length;
        int N=matrix[0].length;
        int[] res=new int[N];
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int leftI=0;
        int leftJ=0;
        for(int i=0;i<M;i++){
            Arrays.fill(res,0);
            for(int j=i;j<M;j++){
                sum=0;
                for(int k=0;k<N;k++){
                    res[k]+=matrix[j][k];
                    if(sum>0){
                        sum+=res[k];
                    }else{
                        sum=res[k];
                        leftI=i;
                        leftJ=k;
                    }
                    if(sum>maxSum){
                        maxSum=sum;
                        ans[0]=leftI;
                        ans[1]=leftJ;
                        ans[2]=j;
                        ans[3]=k;
                    }
                }
            }
        }
        return ans;
    }
}