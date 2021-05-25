class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] ch=s.toCharArray();
        if(ch.length<3){
            return ch.length;
        }
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        int max_len = 2;
        int fast=0,slow=0;
        while(fast<ch.length){
            if(hashmap.size()<3){
                hashmap.put(ch[fast],fast++);
            }
            if(hashmap.size()==3){
                int index=Collections.min(hashmap.values());
                hashmap.remove(ch[index]);
                slow=index+1;
            }
            max_len=Math.max(max_len,fast-slow);
        }
        return max_len;
        
    }
}