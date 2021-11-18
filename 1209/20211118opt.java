class Solution {
    public String removeDuplicates(String s, int k) {
        char[] ch=s.toCharArray();
        int[] cnt=new int[ch.length];
        int i=0;
        for(int j=0;j<ch.length;i++,j++){
            ch[i]=ch[j];
            cnt[i]=i>0&&ch[i]==ch[i-1]?cnt[i-1]+1:1;
            if(cnt[i]==k) i-=k;
        }
        return new String(ch,0,i);
    }
    
    
}