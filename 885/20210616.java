class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n=rows*cols;
        int[][] ret=new int[n][2];
        int p=0;
        int x=rStart;
        int y=cStart;
        int step=1;
        while(p<n){
            for(int i=y;i<y+step;i++){
                if(x>=0&&x<rows&&i>=0&&i<cols){
                    ret[p++]=new int[]{x,i};
                }
            }
            y+=step;
            for(int i=x;i<x+step;i++){
                if(i>=0&&i<rows&&y>=0&&y<cols){
                    ret[p++]=new int[]{i,y};
                }
            }
            x+=step;
            step++;
            for(int i=y;i>y-step;i--){
                if(x>=0&&x<rows&&i>=0&&i<cols){
                    ret[p++]=new int[]{x,i};
                }
            }
            y-=step;
            for(int i=x;i>x-step;i--){
                if(i>=0&&i<rows&&y>=0&&y<cols){
                    ret[p++]=new int[]{i,y};
                }
            }
            x-=step;
            step++;
        }
        return ret;
    }
}