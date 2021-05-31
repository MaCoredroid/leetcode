class Solution {
    int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int n,m;
    public int minimalSteps(String[] maze) {
        n=maze.length;
        m=maze[0].length();
        int sx=-1,sy=-1,tx=-1,ty=-1;
        List<int[]> bottons=new ArrayList<>();
        List<int[]> stones=new ArrayList<>();
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length();j++){
                if(maze[i].charAt(j)=='S'){
                    sx=i;
                    sy=j;
                }else if(maze[i].charAt(j)=='T'){
                    tx=i;
                    ty=j;
                }else if(maze[i].charAt(j)=='M'){
                    bottons.add(new int[]{i,j});
                }else if(maze[i].charAt(j)=='O'){
                    stones.add(new int[]{i,j});
                }
            }
        }
        int nb=bottons.size();
        int ns=stones.size();
        int[][] startDict=bfs(sx,sy,maze);
        if(nb==0){
            return startDict[tx][ty];
        }
        int[][] dist=new int[nb][nb+2];
        for(int i=0;i<nb;i++){
            Arrays.fill(dist[i],-1);
        }
        int[][][] dd=new int[nb][][];
        for(int i=0;i<nb;i++){
            dd[i]=bfs(bottons.get(i)[0],bottons.get(i)[1],maze);
            dist[i][nb+1]=dd[i][tx][ty];
        }
        for(int i=0;i<nb;i++){
            int tmp=-1;
            for(int k=0;k<ns;k++){
                int midX=stones.get(k)[0];
                int midY=stones.get(k)[1];
                if(dd[i][midX][midY]!=-1&&startDict[midX][midY]!=-1){
                    if(tmp==-1||dd[i][midX][midY]+startDict[midX][midY]<tmp){
                        tmp=dd[i][midX][midY]+startDict[midX][midY];
                    }
                }
            }
            dist[i][nb]=tmp;
            for(int j=i+1;j<nb;j++){
                int mn=-1;
                for(int k=0;k<ns;k++){
                    int midX=stones.get(k)[0];
                    int midY=stones.get(k)[1];
                    if(dd[i][midX][midY]!=-1&&dd[j][midX][midY]!=-1){
                        if(mn==-1||dd[i][midX][midY]+dd[j][midX][midY]<mn){
                            mn=dd[i][midX][midY]+dd[j][midX][midY];
                        }
                    }
                }
                dist[i][j]=mn;
                dist[j][i]=mn;
            }
        }
        for(int i=0;i<nb;i++){
            if(dist[i][nb]==-1||dist[i][nb+1]==-1){
                return -1;
            }
        }
        int[][] dp=new int[1<<nb][nb];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<nb;i++){
            dp[1<<i][i]=dist[i][nb];
        }
        for(int mask=1;mask<(1<<nb);mask++){
            for(int i=0;i<nb;i++){
                if((mask&(1<<i))!=0){
                    for(int j=0;j<nb;j++){
                        if((mask&(1<<j))==0){
                            int next=mask|(1<<j);
                            if(dp[next][j]==-1||dp[mask][i]+dist[i][j]<dp[next][j]){
                                dp[next][j]=dp[mask][i]+dist[i][j];
                            }
                        }
                    }
                }
            }
        }
        int ret=-1;
        int finalmask=(1<<nb)-1;
        for(int i=0;i<nb;i++){
            if(ret==-1||ret>dp[finalmask][i]+dist[i][nb+1]){
                ret=dp[finalmask][i]+dist[i][nb+1];
            }
        }
        return ret;
        
    }

    public int[][] bfs(int x,int y,String[] maze){
        int[][] ret=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(ret[i],-1);
        }
        ret[x][y]=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            for(int i=0;i<4;i++){
                int nx=temp[0]+dirs[i][0];
                int ny=temp[1]+dirs[i][1];
                if(nx<0||nx>=n||ny<0||ny>=m){
                    continue;
                }
                if(ret[nx][ny]==-1&&maze[nx].charAt(ny)!='#'){
                    ret[nx][ny]=ret[temp[0]][temp[1]]+1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        return ret;
    }
}