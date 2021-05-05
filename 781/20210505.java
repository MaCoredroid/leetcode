class Solution {
    public int numRabbits(int[] answers) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int answer:answers){
            if(answer==0){
                ans++;
            }else if(!map.containsKey(answer)){
                ans+=answer+1;
                map.put(answer,1);
            }else if(map.containsKey(answer)){
                map.put(answer,map.get(answer)+1);
                if(map.get(answer)==answer+1){
                    map.remove(answer);
                }
            }
        }
        return ans;
    }
}