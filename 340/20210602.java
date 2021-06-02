class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] ch=s.toCharArray();
        int left=0;
        Map<Character,Integer> map=new HashMap<>();
        int size=0;
        int ans=0;
        for(int right=0;right<ch.length;right++){
            if(map.containsKey(ch[right])){
                map.put(ch[right],map.get(ch[right])+1);
            }else{
                map.put(ch[right],1);
                size++;
            }
            while(left<=right&&size>k){
                map.put(ch[left],map.get(ch[left])-1);
                if(map.get(ch[left])==0){
                    map.remove(ch[left]);
                    size--;
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}