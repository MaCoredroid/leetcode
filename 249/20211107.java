class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strings){
            char[] ch=s.toCharArray();
            
            int ret=ch[0]-'a';
            for(int i=0;i<ch.length;i++){
                ch[i]-=ret;
                if(ch[i]<'a'){
                    ch[i]+=26;
                }else if(ch[i]>'z'){
                    ch[i]-=26;
                }
            }
            String export=new String(ch);
            if(!map.containsKey(export)){
                map.put(export,new ArrayList<>());
            }
            map.get(export).add(s);
        }
        List<List<String>> ret=new ArrayList<>();
        for(Map.Entry<String,List<String>> e:map.entrySet()){
            ret.add(e.getValue());
        }
        return ret;
    }
}