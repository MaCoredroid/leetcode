class Solution {
    public double averageWaitingTime(int[][] customers) {
        long time=0;
        long ans=0;
        for(int i=0;i<customers.length;i++){
            if(time<customers[i][0]){
                time=customers[i][0];
            }
            ans+=time+customers[i][1]-customers[i][0];
            time+=customers[i][1];
        }
        return ans/(double)customers.length;
    }
}