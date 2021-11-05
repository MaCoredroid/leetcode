class Solution {
    public int maximumSwap(int num) {
        char[] s=Integer.toString(num).toCharArray();
        String ans=new String(s);
        int maxId=s.length-1;
        char maxVal=s[s.length-1];
        for(int i=s.length-2;i>=0;i--){
            if(s[i]<maxVal){
                s[maxId]=s[i];
                s[i]=maxVal;
                ans=new String(s);
                s[i]=s[maxId];
                s[maxId]=maxVal;
            }else if(s[i]>maxVal){
                maxVal=s[i];
                maxId=i;
            }
        }
        return Integer.parseInt(ans);
    }
}