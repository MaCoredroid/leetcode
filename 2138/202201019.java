class Solution {
    public String[] divideString(String s, int k, char fill) {
        char[] ch=s.toCharArray();
        String[] ans=new String[(ch.length-1)/k+1];
        int p=0;
        for(int i=0;i<ch.length;i+=k){
            char[]temp=new char[k];
            for(int j=i;j<i+k;j++){
                temp[j-i]=j<ch.length?ch[j]:fill;
            }
            ans[p++]=new String(temp);
        }
        return ans;
    }
}