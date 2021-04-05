class Solution {
    public int characterReplacement(String s, int k) {
        char[] ch=s.toCharArray();
        int ans=0;
        int[] freq=new int[26];
        int left=0;
        int right=0;
        int max=0;
        while(right<ch.length){
            freq[ch[right]-'A']++;
            max=Math.max(max,freq[ch[right]-'A']);
            if(right-left+1>max+k){
                freq[ch[left]-'A']--;
                left++;
            }
            right++;

        }
            
        return right-left;
    }
}