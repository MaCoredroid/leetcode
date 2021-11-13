class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[0];
        }
        int N=matrix.length;
        int M=matrix[0].length;
        
        int row=0,col=0;
        int dir=1;
        int[] result=new int[N*M];
        int r=0;
        while(row<N&&col<M){
            result[r++]=matrix[row][col];
            int newX=row+(dir==1?-1:1);
            int newY=col+(dir==1?1:-1);
            if(newX<0||newX==N||newY<0||newY==M){
                if(dir==1){
                    row+=(col==M-1?1:0);
                    col+=(col<M-1?1:0);
                }else{
                    col+=(row==N-1?1:0);
                    row+=(row<N-1?1:0);
                    
                }
                dir=1-dir;
            }else{
                row=newX;
                col=newY;
            }
        }
        return result;

    }
}