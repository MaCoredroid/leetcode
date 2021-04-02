class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    if(ans==0){
                        ans=1;
                    }
                    int len=2;
                    while(verify(matrix,i,j,len)){
                        ans=Math.max(ans,len*len);
                        len++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean verify(char[][] matrix, int i,int j,int len){
        if(i+len-1>=matrix.length||j+len-1>=matrix[0].length){
            return false;
        }
        for(int p=i;p<=i+len-1;p++){
            if(matrix[p][j+len-1]!='1'){
                return false;
            }
        }
        for(int p=j;p<j+len-1;p++){
            if(matrix[i+len-1][p]!='1'){
                return false;
            }
        }
        return true;

    }
}