class Solution {
    int[][] dirs=new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    int[][][] b=new int[4][8][8];
    public int countCombinations(String[] pieces, int[][] positions) {
        return helper(pieces,positions,0);
    }
    
    public int helper(String[] pieces,int[][] pos,int p){
        if(p==pieces.length){
            return 1;
        }
        int pos1=pos[p][0]-1,pos2=pos[p][1]-1;
        int res=0;
        for(int i=0;i<8;i++){
            if((i<4&&pieces[p].equals("bishop"))||(i>=4&&pieces[p].equals("rook"))){
                continue;
            }
            boolean blocked=false;
            for(int step=(res==0)?1:2;!blocked;step++){
                int x=pos1+(step-1)*dirs[i][0],y=pos2+(step-1)*dirs[i][1];
                if(x<0||x>=8||y<0||y>=8){
                    break;
                }
                boolean CanStop=true;
                for(int pp=0;pp<p;pp++){
                    CanStop &= b[pp][x][y] >= 0 && b[pp][x][y] < step;
                    blocked |= (b[pp][x][y] < 0 && -b[pp][x][y] <= step) || (b[pp][x][y] == step);
                }
                if(CanStop){
                    b[p][x][y]=-step;
                    res+=helper(pieces,pos,p+1);
                }
                b[p][x][y]=step;
                
            }
            b[p]=new int[8][8];
        }
        return res;
    }
}