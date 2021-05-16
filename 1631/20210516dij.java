class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] edge1,int[] edge2){
                return edge1[2]-edge2[2];
            }
        });
        int[] dist=new int[m*n];
        boolean[] seen=new boolean[m*n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] edge=pq.poll();
            int id=edge[0]*n+edge[1];
            if(seen[id]){
                continue;
            }
            if(edge[0]==m-1&&edge[1]==n-1){
                break;
            }
            seen[id]=true;
            for(int i=0;i<4;i++){
                int x=edge[0]+dirs[i][0];
                int y=edge[1]+dirs[i][1];
                if(x>=0&&x<m&&y>=0&&y<n&&(Math.max(edge[2],Math.abs(heights[x][y]-heights[edge[0]][edge[1]]))<dist[x*n+y])){
                    dist[x*n+y]=Math.max(edge[2],Math.abs(heights[x][y]-heights[edge[0]][edge[1]]));
                    pq.offer(new int[]{x,y,dist[x*n+y]});
                }
            }
        }
        return dist[m * n - 1];

        
    }
}

