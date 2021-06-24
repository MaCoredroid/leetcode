class Solution {
    public int minDeletions(String s) {
        int[] cnt=new int[26];
        for(char c:s.toCharArray()){
            cnt[c-'a']++;
        }
        int res=0;
        Set<Integer> flag = new HashSet<>();
        for (int i: cnt) {
            while (i > 0 && flag.contains(i)) {
                i--;
                res++;
            }
            flag.add(i);
        }
        return res;
    }
}