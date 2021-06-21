class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] res=new int[n][2];
        for(int i=0;i<n;i++){
            res[i][0]=position[i];
            res[i][1]=speed[i];
        }
        Arrays.sort(res,(o1,o2)->(o1[0]-o2[0]));
        double prev=0;
        int cnt=0;
        for(int i=n-1;i>=0;i--){
            double time=(target-res[i][0])/(double)res[i][1];
            if(time>prev){
                cnt++;
                prev=time;
            }
        }
        return cnt;
    }
}