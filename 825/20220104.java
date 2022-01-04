class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<ages.length;i++){
            map.put(ages[i],map.getOrDefault(ages[i],0)+1);
        }
        int res=0;
        for(Integer a:map.keySet()){
            for(Integer b:map.keySet()){
                if(match(a,b)){
                    res+=map.get(a)*(a==b?map.get(b)-1:map.get(b));
                }
            }
        }
        return res;
    }
    
    public boolean match(int a ,int b){
        return !(b<=0.5*a+7||b>a);
    }
}