class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n=candiesCount.length;
        long[] pre=new long[n];
        long prev=0;
        for(int i=0;i<pre.length;i++){
            pre[i]=prev;
            prev+=candiesCount[i];
        }
        boolean[] ret=new boolean[queries.length];
        for(int i=0;i<ret.length;i++){
            int[] query=queries[i];
            if((long)query[2]*(long)(query[1]+1)<=(long)pre[query[0]]||query[1]>=pre[query[0]]+candiesCount[query[0]]){
                ret[i]=false;
            }else{
                ret[i]=true;
            }
        }
        return ret;
    }
}