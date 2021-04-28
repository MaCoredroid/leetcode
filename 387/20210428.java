class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),-1);
            }else{
                map.put(s.charAt(i),i);
            }
        }
        int firstIndex=s.length();
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()!=-1&&entry.getValue()<firstIndex){
                firstIndex=entry.getValue();
            }
        }
        return firstIndex==s.length()?-1:firstIndex;
    }
}