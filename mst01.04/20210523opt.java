class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] ch=s.toCharArray();
        int[] res=new int[128];
        int count=0;
        for(int i=0;i<ch.length;i++){
            if(res[ch[i]]==1){
                res[ch[i]]--;
                count--;
            }else{
                res[ch[i]]++;
                count++;
            }
        }
        return count<=1;
    }
}