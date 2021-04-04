class Solution {
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int maxNum=0;
        if(source==target){
            return 0;
        }
        for(int[] route:routes){
            for(int i=0;i<route.length;i++){
                maxNum=Math.max(maxNum,route[i]);
            }
        }
        if(target>maxNum){
            return -1;
        }
        int[] dp=new int[maxNum+1];
        Arrays.fill(dp,maxNum+1);
        dp[source]=0;
        boolean updateFlag=false;
        while(!updateFlag){
            for(int[] route:routes){
                int min=maxNum+1;
                for(int bus:route){
                    if(dp[bus]<min){
                        min=dp[bus];
                    }
                }
                for(int bus:route){
                    if(dp[bus]>min+1){
                        dp[bus]=min+1;
                        updateFlag=true;
                    }
                }
            }
            updateFlag=!updateFlag;

        }
        if(dp[target]!=maxNum+1){
            return dp[target];
        }
        return -1;
    }

    
}