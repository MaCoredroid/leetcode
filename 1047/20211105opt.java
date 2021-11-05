class Solution {
    public String removeDuplicates(String s) {
        char[] ch=s.toCharArray();
        int p=0;
        for(int i=1;i<ch.length;i++){
            if(p>=0&&ch[i]==ch[p]){
                p--;
            }else{
                ch[++p]=ch[i];
            }
        }
        return new String(Arrays.copyOfRange(ch,0,p+1));
        
    }
}