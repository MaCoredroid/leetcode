class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] ch=s.toCharArray();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<ch.length;i++){
            if(set.contains(ch[i])){
                set.remove(ch[i]);
            }else{
                set.add(ch[i]);
            }
        }
        return set.size()<=1;
    }
}