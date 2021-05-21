class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] ch1=s.toCharArray();
        char[] ch2=p.toCharArray();
        List<Integer> ret=new ArrayList<>();
        if(ch2.length>ch1.length){
            return ret;
        }
        int[] count=new int[26];
        for(char c:ch2){
            count[c-'a']++;
        }
        int[] count1=new int[26];
        int left=0;
        for(int right=0;right<ch1.length;right++){
            count1[ch1[right]-'a']++;
            while(count1[ch1[right]-'a']>count[ch1[right]-'a']){
                count1[ch1[left]-'a']--;
                left++;
            }
            if(right-left+1==ch2.length){
                ret.add(left);
            }
        }
        return ret;
        
    }
}