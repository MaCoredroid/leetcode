class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] cnt=new int[26];
        Arrays.fill(cnt,-1);
        int ans=-1;
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            char c=ch[i];
            if(cnt[c-'a']!=-1){
                ans=Math.max(i-cnt[c-'a']-1,ans);
            }else{
                cnt[c-'a']=i;
            }
        }
        return ans;
    }
}