class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
        {
            return new ArrayList<>();
        }
        HashMap<String,List> map=new HashMap<>();
        for(String temp:strs)
        {
            char[] chars=temp.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if(!map.containsKey(key))
            {
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(temp);
            
        }
        return new ArrayList(map.values());
    }
}