class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ch1=s.toCharArray();
        char[] ch2=t.toCharArray();
        int ans=0;
        int[] cost=new int[ch1.length];
        int start=0;
        int curr=0;
        for(int end=0;end<ch1.length;end++){
            cost[end]=Math.abs(ch1[end]-ch2[end]);
            curr+=cost[end];
            while(curr>maxCost&&start<=end){
                curr-=cost[start];
                start++;
            }
            ans=Math.max(ans,end-start+1);
        }
        return ans;
    }

}