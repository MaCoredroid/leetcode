class Solution {
    public int maxValue(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int num1=i-1>=0?grid[i-1][j]:0;
                int num2=j-1>=0?grid[i][j-1]:0;
                grid[i][j]+=Math.max(num1,num2);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}