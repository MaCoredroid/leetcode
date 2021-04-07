class Solution {
    int[] parents;
    public int findCircleNum(int[][] isConnected) {
        parents=new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            parents[i]=i;
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(parents[i]==i){
                count++;
            }
        }
        return count;

    }

    private void union(int index1, int index2){
        parents[find(index1)]=find(index2);

    }

    private int find(int target){
        if(parents[target]!=target){
            parents[target]=find(parents[target]);
        }
        return parents[target];
    }
}