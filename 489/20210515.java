class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat==null||mat.length==0){
            return new int[0];
        }
        int M=mat.length;
        int N=mat[0].length;
        int[] ret=new int[M*N];
        int row=0,column=0;
        int direction=1;
        int pointer=0;
        while(row<M&&column<N){
            ret[pointer++]=mat[row][column];
            int new_row=row+(direction==1?-1:1);
            int new_col=column+(direction==1?1:-1);
            if(new_row<0||new_row>=M||new_col<0||new_col>=N){
                if(direction==1){
                    row+=(column==N-1?1:0);
                    column+=(column<N-1?1:0);
                }else{
                    column+=(row<M-1?0:1);
                    row+=(row==M-1?0:1);
                }
                direction=1-direction;
            }else{
                row=new_row;
                column=new_col;
            }
        }
        return ret;
    }
}