class Solution {
    int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{0,0}};
    public int minFlips(int[][] mat) {
        int start=0,m=mat.length,n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                start|=mat[i][j]<<(i*n+j);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        Set<Integer> seen=new HashSet<>();
        seen.add(start);
        for(int step=0;!q.isEmpty();step++){
            for(int sz=q.size();sz>0;sz--){
                int cur=q.poll();
                if(cur==0) return step;
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        int next=cur;
                        for(int k=0;k<5;k++){
                            int nx=i+dirs[k][0];
                            int ny=j+dirs[k][1];
                            if(nx>=0&&nx<m&&ny>=0&&ny<n){
                                next^=1<<(nx*n+ny);
                            }
                        }
                        if(seen.add(next)){
                            q.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}