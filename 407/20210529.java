class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        int m = heightMap.length;
        if (m < 3)
        {
            return res;
        }
        int n = heightMap[0].length;
        if (n < 3)
        {
            return res;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] node1, int[] node2){
                return node1[2]-node2[2];
            }
        });
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||i==m-1||j==0||j==n-1){
                    visited[i][j]=true;
                    pq.offer(new int[]{i,j,heightMap[i][j]});
                }
            }
        }
        int cnt=0;
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            for(int i=0;i<4;i++){
                int nx=temp[0]+dirs[i][0];
                int ny=temp[1]+dirs[i][1];
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&!visited[nx][ny]){
                    if(heightMap[nx][ny]<temp[2]){
                        cnt+=temp[2]-heightMap[nx][ny];
                    }
                    visited[nx][ny]=true;
                    pq.offer(new int[]{nx,ny,Math.max(heightMap[nx][ny],temp[2])});
                }
            }
        }
        return cnt;
    }
}