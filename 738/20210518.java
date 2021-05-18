class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] ch=Integer.toString(n).toCharArray();
        int i=1;
        while(i<ch.length&&ch[i-1]<=ch[i]){
            i++;
        }
        if(i<ch.length){
            while(i>0&&ch[i-1]>ch[i]){
                ch[i-1]--;
                i--;
            }
            i++;
            while(i<ch.length){
                ch[i]='9';
                i++;
            }
        }
        return Integer.parseInt(new String(ch));
    }
}