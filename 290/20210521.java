class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] res=s.split(" ");
        char[] ch=pattern.toCharArray();
        if(res.length!=ch.length){
            return false;
        }
        Map<String,Character> map1=new HashMap<>();
        Map<Character,String> map2=new HashMap<>();
        int p1=0,p2=0;
        while(p1<res.length){   
            if(map1.containsKey(res[p1])||map2.containsKey(ch[p2])){
                if(map1.get(res[p1])==null||map1.get(res[p1])!=ch[p2]){
                    return false;
                }
                if(map2.get(ch[p2])==null||!map2.get(ch[p2]).equals(res[p1])){
                    return false;
                }
            }else{
                map1.put(res[p1],ch[p2]);
                map2.put(ch[p2],res[p1]);
            }
            p1++;
            p2++;
        }
        return true;
    }
}