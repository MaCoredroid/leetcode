class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x:arr){
            if(map.containsKey(x-difference)){
                int val=map.get(x-difference)+1;
                map.put(x,val);
                ans=Math.max(ans,val);
            }else{
                map.put(x,1);
            }
        }
        return ans;
    }
}