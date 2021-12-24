class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0) return new int[0];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int[] ret=new int[changed.length/2];
        int p=0;
        for(int val:changed){
            if(!map.containsKey(val)) map.put(val,0);
            map.put(val,map.get(val)+1);
        }
        for(int x:map.keySet()){
            if(map.get(x)>map.getOrDefault(x+x,0)) return new int[0];
            for(int i=0;i<map.get(x);i++){
                ret[p++]=x;
                map.put(x+x,map.get(x+x)-1);
            }
            
        }
        return ret;
    }
}