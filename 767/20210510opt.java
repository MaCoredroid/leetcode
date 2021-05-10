class Solution {
    public String reorganizeString(String S) {
        char[] ch=S.toCharArray();
        if(S.length()<2){
            return S;
        }
        int[] count=new int[26];
        int maxCount=0;
        for(int i=0;i<ch.length;i++){
            count[ch[i]-'a']++;
            maxCount=Math.max(maxCount,count[ch[i]-'a']);
        }
        if(maxCount>(1+ch.length)/2){
            return "";
        }
        char[] ans=new char[S.length()];
        int evenIndex=0, oddIndex=1;
        int halfLength=S.length()/2;
        for(int i=0;i<26;i++){
            while(count[i]>0&&count[i]<=halfLength&&oddIndex<S.length()){
                ans[oddIndex]=(char)('a'+i);
                oddIndex+=2;
                count[i]--;
            }
            while(count[i]>0){
                ans[evenIndex]=(char)('a'+i);
                evenIndex+=2;
                count[i]--;
            }
        }
        return new String(ans);
    }
}