class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows=getRows(grid);
        List<Integer> cols=getCols(grid);
        return count(rows)+count(cols);
    }
    
    public List<Integer> getRows(int[][] grid){
        List<Integer> ret=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ret.add(i);
                }
            }
        }
        return ret;
    }
    
    public List<Integer> getCols(int[][] grid){
        List<Integer> ret=new ArrayList<>();
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==1){
                    ret.add(i);
                }
            }
        }
        return ret;
    }
    
    public int count(List<Integer> points){
        int d=0;
        int i=0,j=points.size()-1;
        while(i<j){
            d+=points.get(j)-points.get(i);
            i++;
            j--;
        }
        return d;
    }
}