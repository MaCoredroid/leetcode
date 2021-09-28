class Solution {
    public String minWindow(String s, String t) {
        int[] ch=new int[128];
        int count=0;
        for(char c:t.toCharArray()){
            ch[c]++;
        }
        int left=0;
        String ret=s+"a";
        for(int right=0;right<s.length();right++){
            if(ch[s.charAt(right)]>0){
                count++;
            }
            ch[s.charAt(right)]--;
            while(count==t.length()){
                if(right-left+1<ret.length()){
                    ret=s.substring(left,right+1);
                }
                if(ch[s.charAt(left)]==0){
                    count--;
                }
                ch[s.charAt(left)]++;
                left++;
            }
        }
        return ret.length()>s.length()?"":ret;
    }
}