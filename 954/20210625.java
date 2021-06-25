class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Integer[] B = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i)
            B[i] = arr[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));
        for(int val:B){
            if(map.get(val)>0){
                if(map.containsKey(2*val)&&map.get(2*val)>0){
                    map.put(val,map.get(val)-1);
                    map.put(2*val,map.get(2*val)-1);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}