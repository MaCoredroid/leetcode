class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++){
            int[] sum=new int[n];
            for(int j=i;j<m;j++){
                for(int c=0;c<n;c++){
                    sum[c]+=matrix[j][c];
                }
                ans+=helper(sum, target);
            }
        }
        return ans;
    }

    private int helper(int[] sum,int target){
        int n=sum.length;
        int[] pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+sum[i];
        }
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<n+1;i++){
            if(map.containsKey(pre[i]-target)){
                ans+=map.get(pre[i]-target);
            }
            map.put(pre[i],map.getOrDefault(pre[i],0)+1);
        }
        return ans;
    }
}