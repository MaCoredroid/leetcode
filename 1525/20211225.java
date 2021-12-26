class Solution {
    public int numSplits(String s) {
        int[] cnt1=new int[26];
        int[] cnt2=new int[26];
        for(char c:s.toCharArray()){
            cnt2[c-'a']++;
        }
        int num1=0,num2=0,ans=0;
        for(int i=0;i<cnt2.length;i++){
            if(cnt2[i]!=0) num2++;
        }
        for(int i=0;i<s.length();i++){
            cnt1[s.charAt(i)-'a']++;
            if(cnt1[s.charAt(i)-'a']==1){
                num1++;
            }
            cnt2[s.charAt(i)-'a']--;
            if(cnt2[s.charAt(i)-'a']==0){
                num2--;
            }
            if(num1==num2) ans++;
        }
        return ans;
        
    }
}