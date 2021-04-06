class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int[] temp=new int[26];
            for(int j=0;j<strs[i].length();j++){
                temp[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<26;j++){
                sb.append(temp[j]).append(' ');
            }
            String key=sb.toString();
            if(!res.containsKey(key)){
                res.put(key,new ArrayList<>());
            }
            res.get(key).add(strs[i]);
        }
        return new ArrayList<>(res.values());
    }
}