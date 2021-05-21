class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaA=coordinates[0][0], deltaB=coordinates[0][1];
        for(int i=0;i<coordinates.length;i++){
            coordinates[i][0]-=deltaA;
            coordinates[i][1]-=deltaB;
        }
        int A=coordinates[1][0],B=-coordinates[1][1];
        for(int i=2;i<coordinates.length;i++){
            if(B*coordinates[i][0]+A*coordinates[i][1]!=0){
                return false;
            }
        }
        return true;
    }
}