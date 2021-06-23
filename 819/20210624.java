class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
       
        HashMap<String,Integer> map=new HashMap<>();
        Set<String> ban=new HashSet<>();
        for(String s:banned){
            ban.add(s);
        }
        StringBuilder temp=new StringBuilder();
        for(char c:paragraph.toCharArray()){
            if(Character.isLetter(c)){
                temp.append(Character.toLowerCase(c));
            }else if(temp.length()>0){
                String finalword=temp.toString();
                if(!ban.contains(finalword)){
                    map.put(finalword,map.getOrDefault(finalword,0)+1);
                }
                temp=new StringBuilder();
            }
        }
        if(temp.length()>0){
            String finalword=temp.toString();
            if(!ban.contains(finalword)){
                map.put(finalword,map.getOrDefault(finalword,0)+1);
            }
            temp=new StringBuilder();
        }
        int cnt=0;
        String word="";
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>cnt){
                cnt=entry.getValue();
                word=entry.getKey();
            }
        }
        return word;
    }
}