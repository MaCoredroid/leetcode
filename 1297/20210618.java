class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n=s.length();
        Map<String,Integer> cnt=new HashMap<>();
        int ans=0;
        int maxcnt=0;
        char[] ch=s.toCharArray();
        for(int i=0;i<n-minSize+1;i++){
            String target=new String(ch,i,minSize);
            HashSet<Integer> set=new HashSet<>();
            for(char c:target.toCharArray()){
                set.add(c-'a');
            }
            if(set.size()<=maxLetters){
                cnt.put(target,cnt.getOrDefault(target,0)+1);
                ans=Math.max(ans,cnt.get(target));
            }
        }
        return ans;
    }
}