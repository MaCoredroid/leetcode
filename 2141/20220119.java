class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum=0;
        for(int a:batteries){
            sum+=a;
        }
        int k=0,na=batteries.length-1;
        while(batteries[na-k]>sum/(n-k)){
            sum-=batteries[na-k++];
        }
        return sum/(n-k);
    }
}