class Solution {
    public String compressString(String S) {
        char[] ch=S.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            int count=1;
            while(i+1<ch.length&&ch[i+1]==ch[i]){
                i++;
                count++;
            }
            sb.append(ch[i]);
            sb.append(count);
            if(sb.length()>=ch.length){
                return S;
            }
        }
        return sb.toString();
    }
}