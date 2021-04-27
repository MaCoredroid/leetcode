class Solution {
    public String removeDuplicates(String S) {
        int left=0;
        int right=0;
        char[] ch=S.toCharArray();
        while(right<S.length()){
            ch[left]=ch[right];
            while(left>0&&ch[left]==ch[left-1]){
                left-=2;
            }
            left++;
            right++;
        }
        return new String(ch,0,left);
    }
}