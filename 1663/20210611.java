class Solution {
    public String getSmallestString(int n, int k) {
        char[] ch=new char[n];
        while(n>0){
            int tmp=k-(n-1);
            if(tmp<26){
                ch[--n]=(char)(tmp+'a'-1);
                k-=tmp;
            }else{
                ch[--n]='z';
                k-=26;
            }
            
        }
        return new String(ch);
    }
}