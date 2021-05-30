class Solution {
    String[] ans;
    int index=0;
    public String[] permutation(String S) {
        int len=S.length();
        int size=1;
        while(len>1){
            size*=len;
            len--;
        }
        ans=new String[size];
        backTrack(S.toCharArray(),0);
        return ans;
    }

    private void backTrack(char[] ch,int pointer){
        if(pointer==ch.length-1){
            ans[index++]=new String(ch);
            return;
        }
        for(int i=pointer;i<ch.length;i++){
            char temp=ch[i];
            ch[i]=ch[pointer];
            ch[pointer]=temp;
            backTrack(ch,pointer+1);
            ch[pointer]=ch[i];
            ch[i]=temp;
        }
    }


}