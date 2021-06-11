class Solution {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        int[] pre=new int[n+1];
        for(int i=0;i<arr.length;i++){
            pre[i+1]=pre[i]^arr[i];
        }
        Map<Integer,int[]> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(pre[i+1])){
                int[] res=map.get(pre[i+1]);
                ans+=i*res[0]-res[1];
            }
            
            int[] temp=map.getOrDefault(pre[i],new int[]{0,0});
            temp[0]++;
            temp[1]+=i;
            map.put(pre[i],temp);
            
        }
        return ans;
    }
}