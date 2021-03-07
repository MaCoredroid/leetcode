class Solution {
    class UnionFind{
        public int count;
        private int[] parent;
        private int[] rank;
        public UnionFind(char[][] grid){
            count=0;
            parent=new int[grid.length*grid[0].length];
            rank=new int[grid.length*grid[0].length];
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]=='1'){
                        parent[i*grid[0].length+j]=i*grid[0].length+j;
                        count++;
                    }
                    rank[i*grid[0].length+j]=0;
                }
            }
        }
        public int find(int i){
            if(i!=parent[i]){
                parent[i]=find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i,int j){
            int root1=find(i);
            int root2=find(j);
            if(root1!=root2){
                if(rank[root1]>rank[root2]){
                    parent[root2]=root1;
                }else if(rank[root1]<rank[root2]){
                    parent[root1]=root2;
                }else{
                    parent[root2]=root1;
                    rank[root1]++;
                }
                count--;
            }
        }
    }
    public int numIslands(char[][] grid) {
        UnionFind unionfind=new UnionFind(grid);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    if(i-1>=0&&grid[i-1][j]=='1'){
                        unionfind.union(i*grid[0].length+j,i*grid[0].length+j-grid[0].length);
                    }
                    if(i+1<grid.length&&grid[i+1][j]=='1'){
                        unionfind.union(i*grid[0].length+j,i*grid[0].length+j+grid[0].length);
                    }
                    if(j-1>=0&&grid[i][j-1]=='1'){
                        unionfind.union(i*grid[0].length+j,i*grid[0].length+j-1);
                    }
                    if(j+1<grid[0].length&&grid[i][j+1]=='1'){
                        unionfind.union(i*grid[0].length+j,i*grid[0].length+j+1);
                    }
                }
            }
        }
        return unionfind.count;
    }

    
}