class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch=s.toCharArray();
        int left=0;
        int[] res=new int[128];
        Arrays.fill(res,-1);
        int ans=0;
        for(int right=0;right<ch.length;right++){
            left=Math.max(left,res[ch[right]]+1);
            res[ch[right]]=right;
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}