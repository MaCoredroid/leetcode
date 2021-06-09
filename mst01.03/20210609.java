class Solution {
    public String replaceSpaces(String S, int length) {
        char[] ch=S.toCharArray();
        int index=ch.length-1;
        for(int i=length-1;i>=0;i--){
            if(ch[i]==' '){
                ch[index--]='0';
                ch[index--]='2';
                ch[index--]='%';
            }else{
                ch[index--]=ch[i];
            }
        }
        return new String(ch,index+1,ch.length-index-1);
    }
}