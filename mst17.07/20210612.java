class Solution {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        HashMap<String,Integer> map=new HashMap<>();
        HashMap<String,String> unionmap=new HashMap<>();
        for(String name:names){
            int idx1=name.indexOf('(');
            int idx2=name.indexOf(')');
            int freq=Integer.parseInt(name.substring(idx1+1,idx2));
            map.put(name.substring(0,idx1),freq);
        }
        for(String synonym:synonyms){
            int index=synonym.indexOf(',');
            String name1=synonym.substring(1,index);
            String name2=synonym.substring(index+1,synonym.length()-1);
            while(unionmap.containsKey(name1)){
                name1=unionmap.get(name1);
            }
            while(unionmap.containsKey(name2)){
                name2=unionmap.get(name2);
            }
            if(!name1.equals(name2)){
                int freq=map.getOrDefault(name1,0)+map.getOrDefault(name2,0);
                String truename=name1.compareTo(name2) < 0 ? name1 : name2;
                String nickname=name1.compareTo(name2) < 0 ? name2 : name1;
                unionmap.put(nickname,truename);
                map.put(truename,freq);
                map.remove(nickname);
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String name : map.keySet()) {
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            sb.append(map.get(name));
            sb.append(')');
            res[index++] = sb.toString();
        }
        return res;
    }
}

