class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int x:arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(Integer key:map.keySet()){
            if(map.get(key)==0) continue;
            int want=key<0?key/2:key*2;
            if(key<0&&key%2!=0) return false;
            if(map.getOrDefault(want,0)<map.get(key)){
                return false;
            }
            map.put(want,map.get(want)-map.get(key));
        }
        return true;
    }
}