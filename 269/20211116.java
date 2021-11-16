class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character,List<Character>> map=new HashMap<>();
        HashMap<Character,Integer> cnt=new HashMap<>();
        for(String w:words){
            for(char c:w.toCharArray()){
                cnt.put(c,0);
                map.put(c,new ArrayList<>());
            }
        }
        for(int i=0;i<words.length-1;i++){
            String w1=words[i];
            String w2=words[i+1];
            if(w1.length()>w2.length()&&w1.startsWith(w2)){
                return "";
            }
            for(int j=0;j<Math.min(w1.length(),w2.length());j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    cnt.put(w2.charAt(j),cnt.get(w2.charAt(j))+1);
                    break;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        for(Character c:cnt.keySet()){
            if(cnt.get(c).equals(0)){
                q.add(c);
            }
        }
        while(!q.isEmpty()){
            Character c=q.poll();
            sb.append(c);
            for(Character next:map.get(c)){
                cnt.put(next,cnt.get(next)-1);
                if(cnt.get(next)==0){
                    q.add(next);
                }
            }
        }
        if(sb.length()<cnt.size()){
            return "";
        }
        return sb.toString();
    }
}