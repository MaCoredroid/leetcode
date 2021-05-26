class Solution {
    public int splitArray(int[] nums) {
        int[] minPrime = new int[1000000 + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=2;i<minPrime.length;i++){
            if(minPrime[i]<2){
                for(int j=i;j<minPrime.length;j+=i){
                    minPrime[j]=i;
                }
            }
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<ans.length;i++){
            int n=nums[i];
            ans[i] = i > 0 ? ans[i - 1] + 1 : 1;
            while(n>1){
                int factor=minPrime[n];
                int minIndex=-1;
                if(map.containsKey(factor)){
                    minIndex=map.get(factor);
                }else{
                    minIndex=i;
                    map.put(factor,minIndex);
                }
                if(minIndex>0){
                    ans[i]=Math.min(ans[i],ans[minIndex-1]+1);
                }else{
                    ans[i]=1;
                }
                if(ans[i]<ans[minIndex]){
                    map.put(factor,i);
                }
                n=n/factor;
            }
        }
        return ans[ans.length-1];


    }
}