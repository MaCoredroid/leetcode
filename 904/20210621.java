class Solution {
    public int totalFruit(int[] tree) {
        int ans=0,i=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<tree.length;j++){
            map.put(tree[j],map.getOrDefault(tree[j],0)+1);
            while(map.size()>=3){
                map.put(tree[i],map.getOrDefault(tree[i],0)-1);
                if(map.get(tree[i])==0){
                    map.remove(tree[i]);
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}