class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        HashMap<String,List<Integer>> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
        List<Integer> l1=map.get(word1);
        List<Integer> l2=map.get(word2);
        int p1=0,p2=0;
        int cnt=words.length;
        while(p1<l1.size()&&p2<l2.size()){
            cnt=Math.min(cnt,Math.abs(l1.get(p1)-l2.get(p2)));
            if(l1.get(p1)-l2.get(p2)<0){
                p1++;
            }else{
                p2++;
            }
        }
        return cnt;
    }
}